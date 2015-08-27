package ru.reo7sp.wave

object Core extends App {
  val waveViewModel = new WaveViewModel
  val mainWindow = new MainWindow

  mainWindow.setVisible(true)
}
