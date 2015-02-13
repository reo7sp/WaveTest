package ru.reo7sp.wave

import javax.swing.JFrame
import java.awt.BorderLayout

class MainWindow extends JFrame {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

  getContentPane.add(new WaveController(Core.waveModel), BorderLayout.NORTH)
  getContentPane.add(new WaveView(Core.waveModel))
  setSize(1000, 400)
  setLocationRelativeTo(null)
  setTitle("Wave renderer 0.1 by Reo_SP")
}
