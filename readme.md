Description
-----------
Just a simple project with akka cluster and akka management running in kubernetes

Requirements
------------
- Minikube
- Docker

Local deployment
-----------------------------
- eval $(minikube docker-env)
- docker build -t local/openjdk-jre-8-bash docker/openjdk
- sbt docker:publishLocal
- kubectl create -f kubernetes/app.yaml
