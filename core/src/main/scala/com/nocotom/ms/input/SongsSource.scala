package com.nocotom.ms.input

import com.nocotom.ms.model._
import monix.execution.Cancelable
import monix.execution.Scheduler.{global => scheduler}
import org.apache.flink.streaming.api.functions.source.{RichParallelSourceFunction, SourceFunction}

import scala.concurrent.duration._
import scala.util.Random

class SongsSource(numberOfUsers: Int, period: FiniteDuration) extends RichParallelSourceFunction[SongEvent] {

  private var cancelable: Cancelable = _

  override def cancel(): Unit = cancelable.cancel()

  override def run(sourceContext: SourceFunction.SourceContext[SongEvent]): Unit = {
    val rnd = new Random

    // schedule worker at fixed rate
    cancelable = scheduler.scheduleAtFixedRate(2.seconds, period) {

      // random values
      val userId = rnd.nextInt(numberOfUsers)
      val songIdx = rnd.nextInt(Songs.SONGS.length)
      val eventTypeIdx = rnd.nextInt(SongEventType.values.size)

      // create song event
      val songEvent = new SongEvent(Songs.SONGS(songIdx), System.currentTimeMillis, SongEventType(eventTypeIdx), userId)

      // publish event
      sourceContext.collect(songEvent)
    }
  }
}
