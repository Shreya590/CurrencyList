package com.example.mvvmchallenge.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmchallenge.databinding.CurrencyListItemBinding
import com.example.mvvmchallenge.model.RandomCurrency
import com.example.mvvmchallenge.utils.OnCurrencyClickListener

class CurrencyAdapter(
    private val listener : OnCurrencyClickListener
) : RecyclerView.Adapter<CurrencyViewHolder>() {

    private var currencyList = mutableListOf<RandomCurrency>()
    fun setCurrencyList(list : List<RandomCurrency>){
        currencyList.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CurrencyListItemBinding.inflate(inflater,parent,false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currentCurrency = currencyList[position]


        holder.itemView.setOnClickListener{
            val currencySymbol : String = currentCurrency.volumeInfo.currencySymbol
            val currencyTitle : String = currentCurrency.volumeInfo.currencyType
            val currencyRateUSD: String = currentCurrency.volumeInfo.rateUSD

            Toast.makeText(holder.itemView.context, currencySymbol, Toast.LENGTH_LONG).show()
            Toast.makeText(holder.itemView.context, currencyTitle, Toast.LENGTH_LONG).show()
            Toast.makeText(holder.itemView.context, currencyRateUSD, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount() = currencyList.size
}

class CurrencyViewHolder (val binding: CurrencyListItemBinding) : RecyclerView.ViewHolder(binding.root)
