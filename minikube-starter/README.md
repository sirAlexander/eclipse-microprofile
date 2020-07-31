# Local Minikube Setup

This document describes how to set up Minikube to run cloud-native applications with multiple microservices locally.


## Minikube

I’ve chosen [Minikube](https://kubernetes.io/docs/setup/minikube/) which runs a single-node Kubernetes cluster inside a VM on your development machine.

### Install and Set Up kubectl on Ubuntu

I highly recommend using `snap package manager`, kubectl is available as a snap application.
```
snap install kubectl --classic

kubectl version
```

### Install MiniKube

One first needs to check if virtualization is supported on their Linux distro. Run the following command and verify that the output is non-empty:
```
$ grep -E --color 'vmx|svm' /proc/cpuinfo
```

Verify that `kubectl` was installed correctly
```
$ kubectl version -o json
```

You should see similar output:
```
{
  "clientVersion": {
    "major": "1",
    "minor": "17",
    "gitVersion": "v1.17.0",
    "gitCommit": "70132b0f130acc0bed193d9ba59dd186f0e634cf",
    "gitTreeState": "clean",
    "buildDate": "2019-12-10T03:03:57Z",
    "goVersion": "go1.13.5",
    "compiler": "gc",
    "platform": "linux/amd64"
  }
}
```

#### Install a Hypervisor
* Update your system with the latest version. You can do this by running the following commands:
```
$ sudo apt-get update -y
$ sudo apt-get upgrade -y
```
* Next, install some required packages with the following command:
```
$ sudo apt-get install curl wget apt-transport-https -y
```
* Follow the process below to install latest version of VirtualBox.

  * Add Oracle VirtualBox’s repository to your list of repositories. You add its GPG key so that your system trusts this repository. Now when you install VirtualBox, it will be installed from Oracle’s repository instead of Ubuntu’s repository. If there is a new version released, VirtualBox install will be updated along with the system updates.

  * First, add the key for the repository, using the following command:
```
$ wget -q https://www.virtualbox.org/download/oracle_vbox_2016.asc -O- | sudo apt-key add -
```

  * Now add the Oracle VirtualBox repository to the list of repositories using this command:
```
$ sudo add-apt-repository "deb [arch=amd64] http://download.virtualbox.org/virtualbox/debian $(lsb_release -cs) contrib"
```

  * Type `sudo apt install virtualbox–` and hit tab to see the various VirtualBox versions available for installation and then select one of them by typing it completely.
```
$ sudo apt update && sudo apt install virtualbox-6.1
```

  * Use the command below if you need to `remove` VirtualBox from Ubuntu
```
$ sudo apt remove virtualbox virtualbox-*
```

### Completion of MiniKube Installation
* Download the latest version of `Minikube` to your system. You can download it from their official websites with the following command:
```
 $ wget https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
```
* Once the download is completed, copy the downloaded file under /usr/local/bin with the following command:
```
$ cp minikube-linux-amd64 /usr/local/bin/minikube
```
* Next, give execution permission to the minikube with the following command:
```
$ chmod 755 /usr/local/bin/minikube
```
* Next, check the version of Minikube with the following command:
```
$ minikube version
```
* You should get the following output:
```
minikube version: v1.6.2
commit: 54f28ac5d3a815d1196cd5d57d707439ee4bb392
```

