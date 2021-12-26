# install ArgoCD on K3s

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
