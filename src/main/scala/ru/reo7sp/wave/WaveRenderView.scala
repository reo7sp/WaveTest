package ru.reo7sp.wave

import javax.swing.{JPanel, Timer}
import java.awt.{Graphics, Graphics2D, RenderingHints, Color}
import java.awt.event.{ActionListener, ActionEvent}

class WaveView(private val _viewModel: WaveViewModel) extends JPanel with ActionListener {
  private val _colors = Array(Color.RED, Color.BLUE, Color.GREEN, Color.PINK, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.GRAY)

  private var _fps = 0
  private var _fpsRaw = 0
  private var _lastFpsUpdate = 0L

  private val _timer = new Timer(32, this);
  _timer.start()

  override def actionPerformed(e: ActionEvent): Unit = if (e.getSource == _timer) {
    repaint()
  }

  override def paintComponent(rawG: Graphics): Unit = {
    val g = rawG.asInstanceOf[Graphics2D]
    g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)
    g.clearRect(0, 0, getWidth, getHeight)

    // render waves
    val baseY = getHeight / 2
    for (x <- 0 until getWidth) {
      if (!_viewModel.showOnlySum) {
        for (i <- 0 until _viewModel.wavesCount) {
          g.setColor(_colors(i % _colors.length))
          g.drawLine(
            x, baseY + _viewModel.calculateY(x, i).toInt,
            x + 1, baseY + _viewModel.calculateY(x + 1, i).toInt
          )
        }
      }

      g.setColor(Color.BLACK)
      g.drawLine(
        x, baseY + _viewModel.calculateSum(x).toInt,
        x + 1, baseY + _viewModel.calculateSum(x + 1).toInt
      )
    }

    // render info
    g.setColor(Color.BLACK)
    g.drawString("t = " + _viewModel.time, 16, 16)
    g.drawString("fps = " + _fps, 16, 32)

    // update fps counter
    _fpsRaw += 1
    if (System.currentTimeMillis - _lastFpsUpdate > 1000) {
      _fps = _fpsRaw
      _fpsRaw = 0
      _lastFpsUpdate = System.currentTimeMillis
    }

    // update time
    _viewModel.updateTime()
  }
}
