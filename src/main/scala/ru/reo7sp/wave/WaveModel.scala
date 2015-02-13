package ru.reo7sp.wave

import scala.math._

class WaveModel {
  var a = 1.0
  var k = 1.0
  var t = 0.0
  var baseX = 0.0
  var speed = 0.0
  var count = 1
  var step = 0.01
  var scaleX = 16.0
  var scaleY = 16.0
  var z = 1.0
  var j = 1.0

  def omega(i: Int) = j * pow(k + step * i, z)

  def calculateY(x: Double, i: Int) = scaleY * a * cos(omega(i) * t - (k + step * i) * (baseX + x) / scaleX)

  def calculateSum(x: Double) = {
    var result = 0.0
    for (i <- 0 until count) {
      result += calculateY(x, i)
    }
    result
  }
}
