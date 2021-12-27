# Install ArgoCD on K3s

ArgoCD doesn't support the arm64 architecture out of the box. So to get ArgoCD working on the raspberry Pi 4+

1. Either compile the argo source code on an arm 64 based machine
2. Opt to use some of the exisintg ArgoCD arm-64 docker images that exist on docker Hub.

_Note:_ With this option, you may end up having to use an older version of ArgoCD.

I'm using an image created by https://github.com/rdelpret which ia ArgoCD version v2.1.3 as of writing this.

## Steps to Install your own ArgoCD Docker Image

1. Download the ArgoCD install file

```
$ wget https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
```

2. Replace the all existing `image:` entries with the reference to the image you intend to use i.e.

`image: quay.io/argoproj/argocd:v2.2.1` with `image: rdelprete/argocd-arm64:v2.1.3`

3. Run the following commands

```
kubectl create namespace argocd
kubectl apply -n argocd -f install.yaml

```

4. Once all pods are upd and running, check with `$ kubectl get pods -n argocd` we can now check what services were deployed.

5. To check for available services, use `$ kubectl get svc -n argocd`

6. We will now access the ArgoCD server via port forwarding. Use the command below:

```
kubectl port-forward -n argocd svc/argocd-server 9090:443
```

7. Now access the server via `localhost:9090`

## Login using the CLI

1. default username is `admin`
2. Use the following command to retrieve the auto generated password.

```
$ kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d; echo
```

## Installing Tekton

1. The command below will install the controller and webhooks

```
kubectl apply --filename https://storage.googleapis.com/tekton-releases/pipeline/latest/release.yaml

kubectl get pods --namespace tekton-pipelines
```

2. After successfully both the controllers and webhook, install the dashboard with the following command

```
kubectl apply --filename https://github.com/tektoncd/dashboard/releases/latest/download/tekton-dashboard-release.yaml

kubectl get pods --namespace tekton-pipelines
```

3. We will now access the Tekton dashboard via port forwarding. Use the command below:

```
kubectl port-forward -n tekton-pipelines svc/tekton-dashboard 9097:9097
```

4. Now access the dashboard via `localhost:9097`
