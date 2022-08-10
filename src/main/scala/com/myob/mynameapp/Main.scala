package com.myob.mynameapp

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    MynameappServer.stream[IO].compile.drain.as(ExitCode.Success)
}
