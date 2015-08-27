package ru.reo7sp.wave

import scala.math._

class WaveModel {
  var a = 1.0
  var k = 1.0
  var kExponent = 1.0
  var omegaFactor = 1.0

  def omega = omegaFactor * pow(k, kExponent)

  def calculateY(x: Double, t: Double) = a * cos(omega * t - k * x)
}
