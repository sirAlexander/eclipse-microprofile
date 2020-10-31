# Minions for minikube

## The Aim
Our minion army will be Java microservices. We want different types of minions in our army so that we see what Kubernetes can do for us. So we’ll aim for each microservice to respond to a simple http request with a response like:


## Getting Started

```
$ minikube config set cpus 4
$ minikube config set memory 8192
$ minikube config set disk-size 50g
$ minikube start -p minions --kubernetes-version=v1.19.2
$ eval $(minikube -p minions docker-env)

```

## Create your minion Army
```
$ kubectl create -f minion-army.yml
```

## Getting the minion microservices endpoints

```
echo http://$(minikube -p minions ip):30080
echo http://$(minikube -p minions ip):30081
echo http://$(minikube -p minions ip):30082
echo http://$(minikube -p minions ip):30083
echo http://$(minikube -p minions ip):30084
```

## Perform updates to your cluster
```
$ kubectl apply -f minion-army.yml --record
```

## Destroy your minion army
```
$ kubectl delete -f minion-army.yml
```

## Stop your minikube cluster with
```
$ minikube -p minions stop
```