package ru.reo7sp.wave

import javax.swing.{JPanel, JTextField, JLabel, JCheckBox}
import java.awt.event.{ActionListener, ActionEvent}

class WaveController(model: WaveModel) extends JPanel {
  add(new JLabel("A="))

  private val aTextField = new JTextField(model.a.toString, 3)
  aTextField.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = try {
      model.a = e.getSource.asInstanceOf[JTextField].getText.toDouble
    } catch {
      case _: Throwable =>
    }
  })
  add(aTextField)

  add(new JLabel("z="))

  private val zTextField = new JTextField(model.z.toString, 3)
  zTextField.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = try {
      model.z = e.getSource.asInstanceOf[JTextField].getText.toDouble
    } catch {
      case _: Throwable =>
    }
  })
  add(zTextField)

  add(new JLabel("j="))

  private val jTextField = new JTextField(model.j.toString, 3)
  jTextField.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = try {
      model.j = e.getSource.asInstanceOf[JTextField].getText.toDouble
    } catch {
      case _: Throwable =>
    }
  })
  add(jTextField)

  add(new JLabel("k="))

  private val kTextField = new JTextField(model.k.toString, 3)
  kTextField.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = try {
      model.k = e.getSource.asInstanceOf[JTextField].getText.toDouble
    } catch {
      case _: Throwable =>
    }
  })
  add(kTextField)

  add(new JLabel("Base x="))

  private val baseXTextField = new JTextField(model.baseX.toString, 3)
  baseXTextField.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = try {
      model.baseX = e.getSource.asInstanceOf[JTextField].getText.toDouble
    } catch {
      case _: Throwable =>
    }
  })
  add(baseXTextField)
  add(new JLabel("Speed="))

  private val speedTextField = new JTextField(model.speed.toString, 3)
  speedTextField.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = try {
      model.speed = e.getSource.asInstanceOf[JTextField].getText.toDouble
    } catch {
      case _: Throwable =>
    }
  })
  add(speedTextField)

  add(new JLabel("Waves count="))

  private val countTextField = new JTextField(model.count.toString, 3)
  countTextField.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = try {
      model.count = e.getSource.asInstanceOf[JTextField].getText.toDouble.toInt
    } catch {
      case _: Throwable =>
    }
  })
  add(countTextField)

  add(new JLabel("Step for k="))

  private val stepTextField = new JTextField(model.step.toString, 3)
  stepTextField.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = try {
      model.step = e.getSource.asInstanceOf[JTextField].getText.toDouble
    } catch {
      case _: Throwable =>
    }
  })
  add(stepTextField)

  add(new JLabel("Scale x="))

  private val scaleXTextField = new JTextField(model.scaleX.toString, 3)
  scaleXTextField.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = try {
      model.scaleX = e.getSource.asInstanceOf[JTextField].getText.toDouble
    } catch {
      case _: Throwable =>
    }
  })
  add(scaleXTextField)

  //add(new JLabel("Scale y="))

  //private val scaleYTextField = new JTextField(model.scaleY.toString, 3)
  //scaleYTextField.addActionListener(new ActionListener {
    //override def actionPerformed(e: ActionEvent): Unit = try {
      //model.scaleY = e.getSource.asInstanceOf[JTextField].getText.toDouble
    //} catch {
      //case _: Throwable =>
    //}
  //})
  //add(scaleYTextField)

  private val showOnlySum = new JCheckBox("Show only sum") 
  showOnlySum.addActionListener(new ActionListener { 
    override def actionPerformed(e: ActionEvent): Unit = try {
      Core.showOnlySum = !Core.showOnlySum
    } catch {
      case _: Throwable =>
    }
  })
  add(showOnlySum)
}
