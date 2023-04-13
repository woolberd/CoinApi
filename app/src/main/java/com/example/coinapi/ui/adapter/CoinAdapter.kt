package com.example.coinapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapi.databinding.ItemCoinBinding
import com.example.coinapi.models.RatesItem

class CoinAdapter : ListAdapter<RatesItem, CoinAdapter.CoinViewHolder>(
    diffUtil
) {
    inner class CoinViewHolder(private val binding: ItemCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(coinModel: RatesItem?) {
            binding.numTv.text = coinModel?.rate.toString()
            binding.textTv.text = coinModel?.assetIdQuote.toString()
            binding.timeTv.text = coinModel?.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<RatesItem>() {
            override fun areItemsTheSame(
                oldItem: RatesItem,
                newItem: RatesItem
            )
                    : Boolean {
                return oldItem.rate == newItem.rate
            }

            override fun areContentsTheSame(
                oldItem: RatesItem,
                newItem: RatesItem
            )
                    : Boolean {
                return oldItem == newItem
            }
        }
    }
}