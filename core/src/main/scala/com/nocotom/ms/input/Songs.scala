package com.nocotom.ms.input

import scala.concurrent.duration._
import com.nocotom.ms.model._

object Songs {
  val SONGS = List(
    new Song("Yellow Submarine", "The Beatles", 2.4.second),
    new Song("Get Off Of My Cloud", "The Rolling Stones", 2.59.second),
    new Song("Let It Bleed", "The Rolling Stones", 5.28.second),
    new Song("Dancing Queen", "Abba", 3.51.second),
    new Song("Rolling in the Deep", "Adele", 3.53.second),
    new Song("Killer Queen", "Queen", 3.11.second),
    new Song("California Gurls", "Katy Perry", 3.54.second),
    new Song("Silent All These Years", "Tori Amos", 4.57.second),
    new Song("Bohemian Rhapsody", "Queen", 6.6.second),
    new Song("I want to break free", "Queen", 4.32.second)
  )
}
