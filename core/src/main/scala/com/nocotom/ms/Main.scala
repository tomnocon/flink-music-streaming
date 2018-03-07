package com.nocotom.ms

import monix.execution.Scheduler.{global => scheduler}

import scala.io.StdIn.readLine
import scala.concurrent.duration._
import com.nocotom.ms.input.Songs

object Main {
  def main(args: Array[String]): Unit = {
    println(Songs.SONGS)

    scheduler.scheduleOnce(5.seconds) {
      println("Hello, world!")
    }

    readLine()
  }
}
