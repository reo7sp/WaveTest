package ru.reo7sp.wave

object Core extends App {
  val waveModel = new WaveModel
  val mainWindow = new MainWindow
  var showOnlySum = false

  mainWindow.setVisible(true)
}
