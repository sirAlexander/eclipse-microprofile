# Installing Kubernetes On Your Raspberry PI 4+

https://alexellisuk.medium.com/walk-through-install-kubernetes-to-your-raspberry-pi-in-15-minutes-84a8492dc95a

```
# Omit sudo if you wish, then move the arkade binary to /usr/local/bin/
curl -sSL https://get.arkade.dev | sudo sh
```

## Installing Tekton

The command below will install the controller and webhooks

```
kubectl apply --filename https://storage.googleapis.com/tekton-releases/pipeline/latest/release.yaml

kubectl get pods --namespace tekton-pipelines
```

After successfully both the controllers and webhook, install the dashboard with the following command

```
kubectl apply --filename https://github.com/tektoncd/dashboard/releases/latest/download/tekton-dashboard-release.yaml
```
