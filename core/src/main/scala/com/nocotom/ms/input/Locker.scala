package com.nocotom.ms.input

import scala.concurrent.duration._

class Locker {

  private var _isOpen = false

  def isOpen: Boolean ={
    _isOpen
  }

  def open(): Unit = synchronized {
      _isOpen = true
      notifyAll()
  }

  def await(timeout: FiniteDuration = 0.second) : Boolean = synchronized {
    val start = now
    var remaining = timeout
    var isBraked = false
    while (!_isOpen && !isBraked) {
      wait(timeout.toMillis)
      if(timeout > 0.second){
        remaining = timeout - now - start
        if(remaining <= 0.second){
          isBraked = true
        }
      }
    }
    _isOpen
  }

  private def now = System.currentTimeMillis.millis
}
