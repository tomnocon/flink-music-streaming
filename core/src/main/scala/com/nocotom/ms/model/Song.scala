package com.nocotom.ms.model

import scala.concurrent.duration.FiniteDuration

class Song(val name: String, val author: String, val length: Long) {

  def this(name: String, author: String, length: FiniteDuration){
    this(name, author, length.toMillis)
  }

  override def toString: String = s"Song{name='$name', author='$author', length=$length}"

}
