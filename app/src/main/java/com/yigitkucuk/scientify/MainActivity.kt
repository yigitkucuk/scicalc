package com.yigitkucuk.scientify

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {

    private lateinit var previousCal: TextView
    private lateinit var display: EditText
    private var isPortrait = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        previousCal = findViewById(R.id.previous_call)
        display = findViewById(R.id.current_call)
        display.showSoftInputOnFocus = false

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }

    private fun updateText(strToAdd: String) {
        val oldStr = display.text.toString()
        val cursorPs = display.selectionStart
        val leftStr = oldStr.substring(0, cursorPs)
        val rightStr = oldStr.substring(cursorPs)
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
        display.setSelection(cursorPs + strToAdd.length)
    }

    fun zeroButton(v: View) {
        updateText(resources.getString(R.string.zeroText))
    }

    fun oneButton(v: View) {
        updateText(resources.getString(R.string.oneText))
    }

    fun twoButton(v: View) {
        updateText(resources.getString(R.string.twoText))
    }

    fun threeButton(v: View) {
        updateText(resources.getString(R.string.threeText))
    }

    fun fourButton(v: View) {
        updateText(resources.getString(R.string.fourText))
    }

    fun fiveButton(v: View) {
        updateText(resources.getString(R.string.fiveText))
    }

    fun sixButton(v: View) {
        updateText(resources.getString(R.string.sixText))
    }

    fun sevenButton(v: View) {
        updateText(resources.getString(R.string.sevenText))
    }

    fun eightButton(v: View) {
        updateText(resources.getString(R.string.eightText))
    }

    fun nineButton(v: View) {
        updateText(resources.getString(R.string.nineText))
    }

    fun openParenthesesButton(v: View) {
        updateText(resources.getString(R.string.parenthesesOpenText))
    }

    fun closeParenthesesButton(v: View) {
        updateText(resources.getString(R.string.parenthesesCloseText))
    }

    fun divideButton(v: View) {
        updateText(resources.getString(R.string.divideText))
    }

    fun multiplyButton(v: View) {
        updateText(resources.getString(R.string.multiplyText))
    }

    fun subtractButton(v: View) {
        updateText(resources.getString(R.string.subtractText))
    }

    fun decimalButton(v: View) {
        updateText(resources.getString(R.string.decimalText))
    }

    fun addButton(v: View) {
        updateText(resources.getString(R.string.addText))
    }

    fun equalsButton(v: View) {

        var userExp = display.text.toString()
        previousCal.text = userExp
        userExp = userExp.replace(resources.getString(R.string.divideText).toRegex(), "/")
        userExp = userExp.replace(resources.getString(R.string.multiplyText).toRegex(), "*")
        val exp = Expression(userExp)
        val result = exp.calculate().toString()
        display.setText(result)
        display.setSelection(result.length)
    }

    fun clearButton(v: View) {
        display.setText("")
        previousCal.text = ""
    }

    fun sinButton(v: View) {
        updateText("sin(")
    }

    fun cosButton(v: View) {
        updateText("cos(")
    }

    fun tanButton(v: View) {
        updateText("tan(")
    }

    fun arcsinButton(v: View) {
        updateText("arcsin(")
    }

    fun arccosButton(v: View) {
        updateText("arccos(")
    }

    fun arctanButton(v: View) {
        updateText("arctan(")
    }

    fun logButton(v: View) {
        updateText("log(")
    }

    fun naturalLogButton(v: View) {
        updateText("ln(")
    }

    fun absButton(v: View) {
        updateText("abs(")
    }

    fun piNumberButton(v: View) {
        updateText("pi")
    }

    fun eulerNumberButton(v: View) {
        updateText("e")
    }

    fun squareRootButton(v: View) {
        updateText("sqrt(")
    }

    fun xSquaredButton(v: View) {
        updateText("^(2)")
    }

    fun xPowerYButton(v: View) {
        updateText("^(")
    }

    fun isPrimeButton(v: View) {
        updateText("is-prc(")
    }

    fun backspaceButton(v: View) {
        val cursorPos = display.selectionStart
        val textLen = display.text.length
        if (cursorPos != 0 && textLen != 0) {
            val selection = display.text as SpannableStringBuilder
            selection.replace(cursorPos - 1, cursorPos, "")
            display.text = selection
            display.setSelection(cursorPos - 1)
        }
    }

    fun rotateButton(v: View) {
        requestedOrientation = if (isPortrait) {
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
        } else {
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
        }
        isPortrait = !isPortrait
    }
}