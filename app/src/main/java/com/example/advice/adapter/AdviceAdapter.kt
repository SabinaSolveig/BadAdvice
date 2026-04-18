package com.example.advice.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.recyclerview.widget.RecyclerView
import com.example.advice.databinding.ItemAdviceBinding
import com.example.advice.model.Advice
import androidx.navigation.findNavController
import com.example.advice.R

class AdviceAdapter(
    private val advices: List<Advice>
) : RecyclerView.Adapter<AdviceAdapter.AdviceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdviceViewHolder {
        val binding = ItemAdviceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AdviceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdviceViewHolder, position: Int) {
        holder.bind(advices[position])

        holder.itemView.alpha = 0f
        holder.itemView.translationX = 50f
        holder.itemView.animate()
            .alpha(1f)
            .translationX(0f)
            .setDuration(300)
            .setStartDelay(position * 50L)
            .start()
    }

    override fun getItemCount(): Int = advices.size

    inner class AdviceViewHolder(
        private val binding: ItemAdviceBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(advice: Advice) {
            binding.apply {
                tvDay.text = binding.root.context.getString(R.string.day_format, advice.day)
                tvTitle.text = advice.title
                tvShortDescription.text = advice.shortDescription
                ivAdviceImage.setImageResource(advice.imageResId)

                root.setOnClickListener {
                    root.animate()
                        .scaleX(0.95f)
                        .scaleY(0.95f)
                        .setDuration(100)
                        .withEndAction {
                            root.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(100)
                                .withEndAction {
                                    val bundle = Bundle()
                                    bundle.putParcelable("advice", advice)

                                    val navOptions = NavOptions.Builder()
                                        .setEnterAnim(R.anim.slide_in_right)
                                        .setExitAnim(R.anim.slide_out_left)
                                        .setPopEnterAnim(R.anim.slide_in_left)
                                        .setPopExitAnim(R.anim.slide_out_right)
                                        .build()

                                    root.findNavController().navigate(
                                        R.id.action_adviceListFragment_to_adviceDetailFragment,
                                        bundle,
                                        navOptions
                                    )
                                }
                                .start()
                        }
                        .start()
                }
            }
        }
    }
}