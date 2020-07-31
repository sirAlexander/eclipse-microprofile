# Local Environment Setup

This document describes how to set up Minikube with Istio and Kiali to run cloud-native applications with multiple microservices locally.

After following these instructions you will be able to use the Kubernetes dashboard, Kiali, Jaeger, Grafana and Prometheus.

### Minikube

Follow the [instructions](https://kubernetes.io/docs/tasks/tools/install-minikube/) to install Minikube. 

This project has been tested with Minikube version 1.5.2. 

Once installed, run these commands:

```
$ minikube config set cpus 2
$ minikube config set memory 8192
$ minikube config set disk-size 50g
$ minikube start -p cloud-native-starter
$ eval $(minikube docker-env)
```

When Minikube is started you can get the IP address and open the Kubernetes dashboard with these commands:

```
$ minikube ip
$ minikube dashboard
```

To stop the cluster run this command:

```
$ minikube stop -p cloud-native-starter
```

export PATH="$PATH:/home/sir_alexander/istio-1.5.1/bin"
 

