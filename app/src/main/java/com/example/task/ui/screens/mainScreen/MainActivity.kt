package com.example.task.ui.screens.mainScreen

import com.example.task.ui.adapters.AllCurrenciesAdapter
import com.example.task.pojo.CurrencyModel
import MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mMainViewModel: MainViewModel
    private val mCurrenciesModelList: ArrayList<CurrencyModel> = ArrayList()
    private lateinit var mAllCurrenciesAdapter : AllCurrenciesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mBinding.root
        setContentView(view)

        mMainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mMainViewModel.getAllCurrencies()

        mMainViewModel.mAllCurrencies.observe(this, { item ->
            if (item.rates!!.isNotEmpty()){
                item.rates?.forEach { (key, value) ->
                    val currency = CurrencyModel()
                    currency.key = key
                    currency.value = value.toFloat()
                    mCurrenciesModelList.add(currency)
                }
                mBinding.allCurrenciesRv.layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                mAllCurrenciesAdapter = AllCurrenciesAdapter(this@MainActivity,mCurrenciesModelList)
                mBinding.allCurrenciesRv.adapter = mAllCurrenciesAdapter
                mBinding.mainPb.visibility = View.GONE
                mBinding.allCurrenciesRv.visibility = View.VISIBLE
            }
        })

    }
}