package ru.reo7sp.wave

import scala.collection.mutable.ArrayBuffer
import scala.math._

class WaveViewModel {
  private val _waves = new ArrayBuffer[WaveModel]

  private var _speed = 0.0
  private var _time = 0.0
  private var _kStep = 0.1
  private var _scaleX = 10.0
  private var _showOnlySum = false
  private var _baseX = 0.0
  private var _lastUpdate = 0L

  def a = _waves(0).a
  def k = _waves(0).k
  def kExponent = _waves(0).kExponent
  def omegaFactor = _waves(0).omegaFactor

  def speed = _speed
  def time = _time
  def kStep = _kStep
  def scaleX = _scaleX
  def wavesCount = _waves.length
  def showOnlySum = _showOnlySum
  def baseX = _baseX

  def calculateY(x: Double, i: Int) = _waves(i).calculateY(x / scaleX, time).toInt

  def calculateSum(x: Double) = {
    var result = 0.0
    (0 until _waves.length).foreach(result += calculateY(x, _))
    result
  }

  def updateTime(): Unit = {
    val delta = max((System.currentTimeMillis - _lastUpdate) / 1000.0, 1.0)
    _time += _speed * delta
    _lastUpdate = System.currentTimeMillis
  }

  def updateVars(a: Double, k: Double, kExponent: Double, omegaFactor: Double, wavesCount: Int, kStep: Double, scaleX: Double, showOnlySum: Boolean, baseX: Double, speed: Double) {
    _kStep = kStep
    _scaleX = scaleX
    _speed = speed
    _showOnlySum = showOnlySum
    _baseX = baseX

    _waves.clear()
    for (i <- 0 until wavesCount) {
      val wave = new WaveModel
      wave.a = a
      wave.k = k + kStep * i
      wave.kExponent = kExponent
      wave.omegaFactor = omegaFactor
      _waves += wave
    }
  }

  updateVars(
    a = 10,
    k = 1,
    kExponent = 1,
    omegaFactor = 1,
    wavesCount = 1,
    kStep = _kStep,
    scaleX = _scaleX,
    showOnlySum = _showOnlySum,
    baseX = _baseX,
    speed = _speed
  )
}
