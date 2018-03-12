package com.nocotom.ms.input

import akka.actor._
import com.nocotom.ms.model._
import org.apache.flink.streaming.api.functions.source.{RichParallelSourceFunction, SourceFunction}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.Random

class SongsSource(numberOfUsers: Int, period: FiniteDuration) extends RichParallelSourceFunction[SongEvent] {

  private var running : Boolean = true

  override def cancel(): Unit = running = false

  override def run(sourceContext: SourceFunction.SourceContext[SongEvent]): Unit = {
    val random = new Random

    val system = ActorSystem.create()

    // schedule worker at fixed rate
    val cancellable = system.scheduler.schedule(2.seconds, period) {

      // random values
      val userId = random.nextInt(numberOfUsers)
      val songIndex = random.nextInt(Songs.SONGS.length)
      val eventTypeIndex = random.nextInt(SongEventType.values.size)

      // create song event
      val songEvent = new SongEvent(Songs.SONGS(songIndex), System.currentTimeMillis, SongEventType(eventTypeIndex), userId)

      // publish event
      sourceContext.collect(songEvent)
    }

    while (running) {
      Thread.sleep(10L)
    }

    cancellable.cancel()
    system.terminate()
  }
}
