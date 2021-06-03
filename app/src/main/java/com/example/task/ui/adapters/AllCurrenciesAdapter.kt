package com.example.task.ui.adapters

import com.example.task.pojo.CurrencyModel
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task.constants.UiConstants
import com.example.task.databinding.ListItemBinding
import com.example.task.ui.screens.calculatorScreen.CalculatorActivity
import com.google.gson.Gson


class AllCurrenciesAdapter(private val context:Context, private val currenciesList: ArrayList<CurrencyModel>) :
    RecyclerView.Adapter<AllCurrenciesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val clickedCurrency = CurrencyModel()
            clickedCurrency.key = currenciesList[position].key
            clickedCurrency.value = currenciesList[position].value
            val currencyData: String = Gson().toJson(clickedCurrency)

            val intent = Intent(context, CalculatorActivity::class.java)
            intent.putExtra(UiConstants.INTENT_KEY, currencyData)
            context.startActivity(intent)
        }
        holder.bind(currenciesList[position])
    }

    override fun getItemCount(): Int {
        return currenciesList.size
    }

    inner class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CurrencyModel) {
            binding.currencyModel = item
        }
    }
}