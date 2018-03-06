package com.nocotom.ms.model

object SongEventType extends Enumeration {
  type SongEventType = Value
  val Play: Value = Value("Play")
  val Pause: Value = Value("Pause")
  val Skip: Value = Value("Skip")
}


