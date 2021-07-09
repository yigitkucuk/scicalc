package com.malkinfo.scientifccalcultor

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {

    private lateinit var previousCal:TextView
    private lateinit var display:EditText

    var isPortrait = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        previousCal = findViewById(R.id.previCal)
        display = findViewById(R.id.display)
        display.showSoftInputOnFocus = false

    }

    private fun updateText(strToAdd:String){

        val oldStr = display.text.toString()
        val cursorPs = display.selectionStart
        val leftStr = oldStr.substring(0,cursorPs)
        val rightStr = oldStr.substring(cursorPs)
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr))
        display.setSelection(cursorPs + strToAdd.length)
    }
    fun zeroBtn(v:View){
        updateText(resources.getString(R.string.zeroText))
    }
    fun oneBtn(v:View){
        updateText(resources.getString(R.string.oneText))
    }
    fun twoBtn(v:View){
        updateText(resources.getString(R.string.twoText))
    }
    fun threeBtn(v:View){
        updateText(resources.getString(R.string.threeText))
    }
    fun foureBtn(v:View){
        updateText(resources.getString(R.string.fourText))
    }
    fun fiveBtn(v:View){
        updateText(resources.getString(R.string.fiveText))
    }
    fun sixBtn(v:View){
        updateText(resources.getString(R.string.sixText))
    }
    fun sevenBtn(v:View){
        updateText(resources.getString(R.string.sevenText))
    }
    fun eightBtn(v:View){
        updateText(resources.getString(R.string.eightText))
    }
    fun nineBtn(v:View){
        updateText(resources.getString(R.string.nineText))
    }
    fun parOpenBtn(v:View){
        updateText(resources.getString(R.string.parenthesesOpenText))
    }
    fun parcloseBtn(v:View){
        updateText(resources.getString(R.string.parenthesesCloseText))
    }
    fun divideBtn(v:View){
        updateText(resources.getString(R.string.divideText))
    }
    fun multiplyBtn(v:View){
        updateText(resources.getString(R.string.multiplyText))
    }
    fun subtractBtn(v:View){
        updateText(resources.getString(R.string.subtractText))
    }

    fun decimalBtn(v:View){
        updateText(resources.getString(R.string.decimalText))
    }
    fun addBtn(v:View){
        updateText(resources.getString(R.string.addText))
    }
    fun equalsBtn(v:View){

        var userExp = display.text.toString()
        previousCal.text = userExp
        userExp = userExp.replace(resources.getString(R.string.divideText).toRegex(), "/")
        userExp = userExp.replace(resources.getString(R.string.multiplyText).toRegex(), "*")
        val exp = Expression(userExp)
        val result = exp.calculate().toString()
        display.setText(result)
        display.setSelection(result.length)


    }
    fun clearBtn(v:View){
        display.setText("")
        previousCal.text = ""

    }
    fun trigSinBtn(v:View){
        updateText("sin(")
    }
    fun trigCosBtn(v:View){
        updateText("cos(")
    }
    fun trigtanBtn(v:View){
        updateText("tan(")
    }
    fun trigArcSinBtn(v:View){
        updateText("arcsin(")
    }
    fun trigArcCosBtn(v:View){
        updateText("arccos(")
    }
    fun trigArcTanBtn(v:View){
        updateText("arctan(")
    }
    fun logBtn(v:View){
        updateText("log(")
    }
    fun naturalLogBtn(v:View){
        updateText("ln(")
    }
    fun absBtn(v:View){
        updateText("abs(")
    }
    fun piBtn(v:View){
        updateText("pi")
    }
    fun eBtn(v:View){
        updateText("e")
    }
    fun sqrtBtn(v:View){
        updateText("sqrt(")
    }
    fun xSquaredBtn(v:View){
        updateText("^(2)")
    }
    fun xPowerYBtn(v:View){
        updateText("^(")
    }
    fun primeBtn(v:View){
        updateText("isprc(")
    }

    fun backSpaceBtn(v:View){
        val cursorPos = display.selectionStart
        val textLen = display.text.length
        if (cursorPos != 0 && textLen != 0){
            val selection = display.text as SpannableStringBuilder
            selection.replace(cursorPos -1,cursorPos,"")
            display.text = selection
            display.setSelection(cursorPos -1)
        }

    }
    fun rotateBtn(v:View){

        requestedOrientation = if (isPortrait){
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
        }
        else{
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
        }
        isPortrait = !isPortrait
    }

}