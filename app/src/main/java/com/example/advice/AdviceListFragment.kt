package com.example.advice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.advice.adapter.AdviceAdapter
import com.example.advice.databinding.FragmentAdviceListBinding
import com.example.advice.model.Advice

class AdviceListFragment : Fragment() {

    private var _binding: FragmentAdviceListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdviceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(binding.rvAdvice) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adviceList = generateAdvice()

        val spanCount = try {
            resources.getInteger(R.integer.grid_span_count)
        } catch (e: Exception) {
            2
        }
        binding.rvAdvice.layoutManager = GridLayoutManager(requireContext(), spanCount)
        binding.rvAdvice.adapter = AdviceAdapter(adviceList)

        setupWindowInsets()
    }
    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.rvAdvice) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val navigationBars = insets.getInsets(WindowInsetsCompat.Type.navigationBars())

            v.setPadding(
                v.paddingLeft,
                systemBars.top + v.paddingTop,
                v.paddingRight,
                navigationBars.bottom + v.paddingBottom
            )
            insets
        }

        ViewCompat.requestApplyInsets(binding.rvAdvice)
    }

    private fun generateAdvice(): List<Advice> {
        return listOf(
            Advice(1, getString(R.string.a_1_title), getString(R.string.a_1_short),
                getString(R.string.a_1_full), R.drawable.advice_1),
            Advice(2, getString(R.string.a_2_title), getString(R.string.a_2_short),
                getString(R.string.a_2_full), R.drawable.advice_2),
            Advice(3, getString(R.string.a_3_title), getString(R.string.a_3_short),
                getString(R.string.a_3_full), R.drawable.advice_3),
            Advice(4, getString(R.string.a_4_title), getString(R.string.a_4_short),
                getString(R.string.a_4_full), R.drawable.advice_4),
            Advice(5, getString(R.string.a_5_title), getString(R.string.a_5_short),
                getString(R.string.a_5_full), R.drawable.advice_5),
            Advice(6, getString(R.string.a_6_title), getString(R.string.a_6_short),
                getString(R.string.a_6_full), R.drawable.advice_6),
            Advice(7, getString(R.string.a_7_title), getString(R.string.a_7_short),
                getString(R.string.a_7_full), R.drawable.advice_7),
            Advice(8, getString(R.string.a_8_title), getString(R.string.a_8_short),
                getString(R.string.a_8_full), R.drawable.advice_8),
            Advice(9, getString(R.string.a_9_title), getString(R.string.a_9_short),
                getString(R.string.a_9_full), R.drawable.advice_9),
            Advice(10, getString(R.string.a_10_title), getString(R.string.a_10_short),
                getString(R.string.a_10_full), R.drawable.advice_10),
            Advice(11, getString(R.string.a_11_title), getString(R.string.a_11_short),
                getString(R.string.a_11_full), R.drawable.advice_11),
            Advice(12, getString(R.string.a_12_title), getString(R.string.a_12_short),
                getString(R.string.a_12_full), R.drawable.advice_12),
            Advice(13, getString(R.string.a_13_title), getString(R.string.a_13_short),
                getString(R.string.a_13_full), R.drawable.advice_13),
            Advice(14, getString(R.string.a_14_title), getString(R.string.a_14_short),
                getString(R.string.a_14_full), R.drawable.advice_14),
            Advice(15, getString(R.string.a_15_title), getString(R.string.a_15_short),
                getString(R.string.a_15_full), R.drawable.advice_15),
            Advice(16, getString(R.string.a_16_title), getString(R.string.a_16_short),
                getString(R.string.a_16_full), R.drawable.advice_16),
            Advice(17, getString(R.string.a_17_title), getString(R.string.a_17_short),
                getString(R.string.a_17_full), R.drawable.advice_17),
            Advice(18, getString(R.string.a_18_title), getString(R.string.a_18_short),
                getString(R.string.a_18_full), R.drawable.advice_18),
            Advice(19, getString(R.string.a_19_title), getString(R.string.a_19_short),
                getString(R.string.a_19_full), R.drawable.advice_19),
            Advice(20, getString(R.string.a_20_title), getString(R.string.a_20_short),
                getString(R.string.a_20_full), R.drawable.advice_20),
            Advice(21, getString(R.string.a_21_title), getString(R.string.a_21_short),
                getString(R.string.a_21_full), R.drawable.advice_21),
            Advice(22, getString(R.string.a_22_title), getString(R.string.a_22_short),
                getString(R.string.a_22_full), R.drawable.advice_22),
            Advice(23, getString(R.string.a_23_title), getString(R.string.a_23_short),
                getString(R.string.a_23_full), R.drawable.advice_23),
            Advice(24, getString(R.string.a_24_title), getString(R.string.a_24_short),
                getString(R.string.a_24_full), R.drawable.advice_24),
            Advice(25, getString(R.string.a_25_title), getString(R.string.a_25_short),
                getString(R.string.a_25_full), R.drawable.advice_25),
            Advice(26, getString(R.string.a_26_title), getString(R.string.a_26_short),
                getString(R.string.a_26_full), R.drawable.advice_26),
            Advice(27, getString(R.string.a_27_title), getString(R.string.a_27_short),
                getString(R.string.a_27_full), R.drawable.advice_27),
            Advice(28, getString(R.string.a_28_title), getString(R.string.a_28_short),
                getString(R.string.a_28_full), R.drawable.advice_28),
            Advice(29, getString(R.string.a_29_title), getString(R.string.a_29_short),
                getString(R.string.a_29_full), R.drawable.advice_29),
            Advice(30, getString(R.string.a_30_title), getString(R.string.a_30_short),
                getString(R.string.a_30_full), R.drawable.advice_30)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

