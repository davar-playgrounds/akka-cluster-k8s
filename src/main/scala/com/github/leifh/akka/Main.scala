package com.github.leifh.akka

import akka.actor.{ActorSystem, CoordinatedShutdown}
import akka.discovery.kubernetes.KubernetesApiSimpleServiceDiscovery
import akka.management.AkkaManagement
import akka.management.cluster.bootstrap.ClusterBootstrap
import org.slf4j.LoggerFactory

object Main extends App{


  val logger = LoggerFactory.getLogger(Main.getClass)

  val actorSystem = ActorSystem("myapp")

  //new KubernetesApiSimpleServiceDiscovery(actorSystem)

  AkkaManagement(actorSystem).start()
  ClusterBootstrap(actorSystem).start()

  CoordinatedShutdown(actorSystem).addJvmShutdownHook {
    logger.info("Terminating...")
    // clean shutdown of the flow
    logger.info("Terminated... Bye")
  }
}
