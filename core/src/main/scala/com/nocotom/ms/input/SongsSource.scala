package com.nocotom.ms.input

import com.nocotom.ms.model._
import org.apache.flink.streaming.api.functions.source.{RichParallelSourceFunction, SourceFunction}

import scala.concurrent.duration._
import scala.util.Random

class SongsSource(numberOfUsers: Int, period: FiniteDuration) extends RichParallelSourceFunction[SongEvent] {

  private lazy val locker = new Locker()

  override def cancel(): Unit = locker.open()

  override def run(sourceContext: SourceFunction.SourceContext[SongEvent]): Unit = {
    val random = new Random

    while(!locker.await(period)){
      // random values
      val userId = random.nextInt(numberOfUsers)
      val songIndex = random.nextInt(Songs.SONGS.length)
      val eventTypeIndex = random.nextInt(SongEventType.values.size)

      // create song event
      val songEvent = new SongEvent(Songs.SONGS(songIndex), System.currentTimeMillis, SongEventType(eventTypeIndex), userId)

      // publish event
      sourceContext.collect(songEvent)
    }
  }
}
