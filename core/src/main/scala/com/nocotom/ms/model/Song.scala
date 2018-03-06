package com.nocotom.ms.model

class Song(val name: String, val author: String, val length: Int) {

  override def toString: String = s"Song{name='$name', author='$author', length=$length}"

}
