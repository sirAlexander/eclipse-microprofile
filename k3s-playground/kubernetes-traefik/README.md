# Directing Kubernetes traffic with Traefik

## A step-by-step walkthrough on ingressing traffic into a Kubernetes-Raspberry Pi cluster.

We will deploy a couple of simple websites and learn how to ingress traffic from the outside world into our cluster using Traefik. After that, we will learn how to remove Kubernetes resources as well. 

All deployments will be done onto a k3s Rasberry Pi cluster.

### <u>Deployment configuration</u>

Reference: `mysite.yaml`

We have named our deployment `mysite-nginx` with an app label of `mysite-nginx` as well. We have specified that we want one replica which means there will only be one pod created. We also specified one container, which we named nginx. We specified the image to be nginx. This means, on deployment, k3s will download the nginx image from DockerHub and create a pod from it. Finally, we specified a containerPort of 80, which just means that inside the container the pod will listen on port 80.

I emphasized "inside the container" above because it is an important distinction. As we have the container configured, it is only accessible inside the container, and it is further restricted to an internal network. This is necessary to allow multiple containers to listen on the same container ports. In other words, with this configuration, some other pod could listen on its container port 80 as well and not conflict with this one. To provide formal access to this pod, we need a service configuration.

### <u>Service configuration</u>

Reference: `mysite.yaml`

In Kubernetes, a `service` is an abstraction. It provides a means to access a pod or set of pods. One connects to the service and the service routes to a single pod or load balances to multiple pods if multiple pod replicas are defined.

The service can be specified in the same configuration file i.e. `mysite.yaml`

In this configuration, we have named our service `mysite-nginx-service`. We provided a *selector* of `app: mysite-nginx`. This is how the service chooses the application containers it routes to. Remember, we provided an `app` label for our container as `mysite-nginx`. This is what the service will use to find our container. Finally, we specified that the service protocol is `TCP` and the service listens on port `80`.

### <u>Ingress configuration</u>

The ingress configuration specifies how to get traffic from outside our cluster to services inside our cluster. Remember, k3s comes pre-configured with Traefik as an ingress controller. Therefore, we will write our ingress configuration specific to Traefik. Add the following to `mysite.yaml`