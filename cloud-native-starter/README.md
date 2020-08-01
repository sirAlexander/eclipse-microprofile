Before deploying any application, ensure you've run the following:

```shell script
ROOT_FOLDER=$(pwd)
```

Run the command below to ensure you grant yourself execution permission to all files in the `scripts` folder.

```shell script
chmod -R u+x scripts/
```

Check you have installed everything that's needed.
```shell script
scripts/check-prerequisites.sh
```

Deploy the `articles` backend microservice
```shell script
scripts/deploy-articles-java-jee.sh
```

Deploy the second microservice `web-api v1`. This is a BFF(backend for frontend) service used to display *articles* 
with *authors*.
```shell script
scripts/deploy-web-api-java-jee.sh
```