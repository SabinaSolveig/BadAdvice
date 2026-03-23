package com.example.advice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.advice.model.Advice

class AdviceDetailFragment : Fragment() {

    private var advice: Advice? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        advice = arguments?.getParcelable("advice")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_advice_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = getString(R.string.advice_detail_title)
        }

        setupWindowInsets(view)

        advice?.let {
            val tvDayTitle: TextView = view.findViewById(R.id.tv_day_title)
            val tvTitle: TextView = view.findViewById(R.id.tv_title)
            val tvFullDescription: TextView = view.findViewById(R.id.tv_full_description)
            val ivFullImage: ImageView = view.findViewById(R.id.iv_full_image)

            tvDayTitle.text = getString(R.string.day_format, it.day)
            tvTitle.text = it.title
            tvFullDescription.text = it.fullDescription
            ivFullImage.setImageResource(it.imageResId)

            animateContent(view, tvDayTitle, tvTitle, tvFullDescription, ivFullImage)
        }
    }

    private fun animateContent(
        view: View,
        tvDayTitle: TextView,
        tvTitle: TextView,
        tvFullDescription: TextView,
        ivFullImage: ImageView
    ) {
        view.alpha = 0f
        tvDayTitle.translationY = 50f
        tvTitle.translationY = 50f
        ivFullImage.alpha = 0f
        ivFullImage.scaleX = 0.8f
        ivFullImage.scaleY = 0.8f
        tvFullDescription.alpha = 0f
        tvFullDescription.translationY = 50f

        view.animate()
            .alpha(1f)
            .setDuration(300)
            .start()

        tvDayTitle.animate()
            .translationY(0f)
            .setDuration(400)
            .start()

        tvTitle.animate()
            .translationY(0f)
            .setDuration(400)
            .setStartDelay(100)
            .start()

        ivFullImage.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(500)
            .setStartDelay(200)
            .start()

        tvFullDescription.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(400)
            .setStartDelay(300)
            .start()
    }

    private fun setupWindowInsets(view: View) {
        val scrollView = view.findViewById<View>(R.id.scrollView)

        ViewCompat.setOnApplyWindowInsetsListener(scrollView) { v, insets ->
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

    ViewCompat.requestApplyInsets(scrollView)
}

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as? AppCompatActivity)?.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }
}