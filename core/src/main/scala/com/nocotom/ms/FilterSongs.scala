package com.nocotom.ms

import com.nocotom.ms.input.SongsSource
import org.apache.flink.streaming.api.scala._

import scala.concurrent.duration._

object FilterSongs {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream = env.addSource(new SongsSource(10, 4.seconds))

    dataStream.print()

    env.execute()
  }
}
