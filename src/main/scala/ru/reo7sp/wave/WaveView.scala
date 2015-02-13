package ru.reo7sp.wave

import javax.swing.{JPanel, Timer}
import java.awt.{Graphics, Graphics2D, RenderingHints, Color}
import java.awt.event.{ActionListener, ActionEvent}

class WaveView(model: WaveModel) extends JPanel with ActionListener {
  private var colors = Array(Color.RED, Color.BLUE, Color.GREEN, Color.PINK, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.GRAY)

  private var timer = new Timer(16, this);
  timer.start()

  override def paintComponent(rawG: Graphics): Unit = {
    val g = rawG.asInstanceOf[Graphics2D]
    g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)
    g.clearRect(0, 0, getWidth, getHeight)

    val baseY = getHeight / 2
    for (x <- 0 until getWidth) {
      if (!Core.showOnlySum) {
        for (i <- 0 until model.count) {
          g.setColor(colors(i % colors.length))
          g.drawLine(
            x, baseY + model.calculateY(x, i).toInt,
            x + 1, baseY + model.calculateY(x + 1, i).toInt
          )
        }
      }

      g.setColor(Color.BLACK)
      g.drawLine(
        x, baseY + model.calculateSum(x).toInt,
        x + 1, baseY + model.calculateSum(x + 1).toInt
      )
    }

    g.setColor(Color.BLACK)
    g.drawString("t = " + model.t, 16, 64)

    model.t += model.speed
  }

  override def actionPerformed(e: ActionEvent): Unit = if (e.getSource == timer) {
    repaint()
  }
}
