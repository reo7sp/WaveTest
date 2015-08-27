package ru.reo7sp.wave

import javax.swing.JFrame
import java.awt.BorderLayout

class MainWindow extends JFrame {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

  getContentPane.add(new WaveController(Core.waveViewModel), BorderLayout.NORTH)
  getContentPane.add(new WaveView(Core.waveViewModel))
  setSize(1000, 400)
  setLocationRelativeTo(null)
  setTitle("Wave renderer 0.2 by Reo_SP")
}
