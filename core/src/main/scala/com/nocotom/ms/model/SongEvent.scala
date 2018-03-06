package com.nocotom.ms.model

import com.nocotom.ms.model.SongEventType.SongEventType

class SongEvent(val song: Song, val timestamp: Long, val `type`: SongEventType, val userId: Int) {

  override def toString: String = s"SongEvent{song=$song, timestamp=$timestamp, type=${`type`}, userId=$userId}"
}
