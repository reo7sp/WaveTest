package ru.reo7sp.wave

import javax.swing.{JPanel, JTextField, JLabel, JCheckBox}
import java.awt.event.{ActionListener, ActionEvent}

class WaveController(_viewModel: WaveViewModel) extends JPanel with ActionListener {
  add(new JLabel("A="))
  private val aTextField = new JTextField(_viewModel.a.toString, 3)
  aTextField.addActionListener(this)
  add(aTextField)

  add(new JLabel("z="))
  private val kExponentTextField = new JTextField(_viewModel.kExponent.toString, 3)
  kExponentTextField.addActionListener(this)
  add(kExponentTextField)

  add(new JLabel("j="))
  private val omegaFactorTextField = new JTextField(_viewModel.omegaFactor.toString, 3)
  omegaFactorTextField.addActionListener(this)
  add(omegaFactorTextField)

  add(new JLabel("k="))
  private val kTextField = new JTextField(_viewModel.k.toString, 3)
  kTextField.addActionListener(this)
  add(kTextField)

  add(new JLabel("Base x="))
  private val baseXTextField = new JTextField(_viewModel.baseX.toString, 3)
  baseXTextField.addActionListener(this)
  add(baseXTextField)

  add(new JLabel("Speed="))
  private val speedTextField = new JTextField(_viewModel.speed.toString, 3)
  speedTextField.addActionListener(this)
  add(speedTextField)

  add(new JLabel("Waves count="))
  private val wavesCountTextField = new JTextField(_viewModel.wavesCount.toString, 3)
  wavesCountTextField.addActionListener(this)
  add(wavesCountTextField)

  add(new JLabel("k step="))
  private val kStepTextField = new JTextField(_viewModel.kStep.toString, 3)
  kStepTextField.addActionListener(this)
  add(kStepTextField)

  add(new JLabel("Scale x="))
  private val scaleXTextField = new JTextField(_viewModel.scaleX.toString, 3)
  scaleXTextField.addActionListener(this)
  add(scaleXTextField)

  private val showOnlySum = new JCheckBox("Show only sum") 
  showOnlySum.addActionListener(this)
  add(showOnlySum)

  override def actionPerformed(e: ActionEvent): Unit = try {
    _viewModel.updateVars(
      a = aTextField.getText.toDouble,
      k = kTextField.getText.toDouble,
      kExponent = kExponentTextField.getText.toDouble,
      omegaFactor = omegaFactorTextField.getText.toDouble,
      wavesCount = wavesCountTextField.getText.toDouble.toInt,
      kStep = kStepTextField.getText.toDouble,
      scaleX = scaleXTextField.getText.toDouble,
      showOnlySum = showOnlySum.isSelected,
      baseX = baseXTextField.getText.toDouble,
      speed = speedTextField.getText.toDouble
    )
  } catch {
    case _: Throwable =>
  }
}
