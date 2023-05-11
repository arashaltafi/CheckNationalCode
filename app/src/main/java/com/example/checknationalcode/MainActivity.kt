package com.example.checknationalcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import com.example.checknationalcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        btnCheck.setOnClickListener {
            val nationalCode = edtCode.editText?.text
            if (nationalCode.isNullOrEmpty() || nationalCode.length < 10) {
                edtCode.error = getString(R.string.please_fill_10_length_code)
            } else {
                edtCode.error = ""
                tvResult.toShow()
                if (checkNationalCode(nationalCode.toString())) {
                    tvResult.text = getString(R.string.correct)
                    tvResult.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.background_text_success)
                } else {
                    tvResult.text = getString(R.string.wrong)
                    tvResult.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.background_text_wrong)
                }
            }
        }

        edtCode.editText?.setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    btnCheck.performClick()
                }
            }
            false
        }
    }

    private fun checkNationalCode(nationalCode: String): Boolean {
        val cDigitLast = nationalCode.substring(nationalCode.length - 1)
        val fNationalCode = nationalCode.toLong().toString()

        if (fNationalCode[0] == '0' && fNationalCode.length !in 8..9) return false

        val nineLeftDigits = nationalCode.substring(0, nationalCode.length - 1)

        var positionNumber = 10
        var result = 0

        for (chr in nineLeftDigits) {
            val digit = chr.toString().toInt()
            result += digit * positionNumber
            positionNumber--
        }

        val remain = result % 11

        var controllerNumber = remain

        if (2 < remain) {
            controllerNumber = 11 - remain
        }

        return cDigitLast == controllerNumber.toString()
    }
}