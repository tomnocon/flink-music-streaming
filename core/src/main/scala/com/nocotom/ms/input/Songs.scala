package com.nocotom.ms.input

import java.util.concurrent.TimeUnit

import com.nocotom.ms.model._

object Songs {
  val SONGS = List(
    new Song("Yellow Submarine", "The Beatles", this.toMillis(2, 40)),
    new Song("Get Off Of My Cloud", "The Rolling Stones", this.toMillis(2, 59)),
    new Song("Let It Bleed", "The Rolling Stones", this.toMillis(5, 28)),
    new Song("Dancing Queen", "Abba", this.toMillis(3, 51)),
    new Song("Rolling in the Deep", "Adele", this.toMillis(3, 53)),
    new Song("Killer Queen", "Queen", this.toMillis(3, 11)),
    new Song("California Gurls", "Katy Perry", this.toMillis(3, 54)),
    new Song("Silent All These Years", "Tori Amos", this.toMillis(4, 57)),
    new Song("Bohemian Rhapsody", "Queen", this.toMillis(6, 6)),
    new Song("I want to break free", "Queen", this.toMillis(4, 32))
  )

  private def toMillis(minutes: Int, seconds: Int): Int = {
    val totalMillis = TimeUnit.MINUTES.toMillis(minutes) + TimeUnit.SECONDS.toMillis(minutes)
    totalMillis.asInstanceOf[Int]
  }
}
