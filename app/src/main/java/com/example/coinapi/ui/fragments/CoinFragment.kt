package com.example.coinapi.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coinapi.R
import com.example.coinapi.base.BaseFragment
import com.example.coinapi.databinding.FragmentCoinBinding
import com.example.coinapi.ui.adapter.CoinAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinFragment : BaseFragment<FragmentCoinBinding, CoinViewModel>(R.layout.fragment_coin) {

    override val binding by viewBinding(FragmentCoinBinding::bind)
    override val viewModel: CoinViewModel by viewModels()
    private val coinAdapter = CoinAdapter()

    override fun initialize() {
        binding.coinRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coinAdapter
        }
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchCoin().collect {
                coinAdapter.submitList(it.rates)
            }
        }
    }
}