package com.example.task.ui.screens.calculatorScreen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.task.constants.UiConstants
import com.example.task.databinding.ActivityCalculatorBinding
import com.example.task.pojo.CurrencyModel
import com.google.gson.Gson


class CalculatorActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = mBinding.root
        setContentView(view)

        val intentData: String = intent.getStringExtra(UiConstants.INTENT_KEY)!!
        val selectedCurrency: CurrencyModel = Gson().fromJson(intentData, CurrencyModel::class.java)

        mBinding.selectedCurrencyKeyTv.text = selectedCurrency.key
        mBinding.selectedCurrencyValueTv.text = selectedCurrency.value.toString()

        mBinding.valueInputEt.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val inputValue =  mBinding.valueInputEt.text.toString()
                if (inputValue.isNotEmpty()){
                    mBinding.selectedCurrencyValueTv.text =  (selectedCurrency.value!! * inputValue.toFloat()).toString()
                }else{
                    mBinding.selectedCurrencyValueTv.text =  (selectedCurrency.value!! * 1).toString()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {}
        })

    }
}