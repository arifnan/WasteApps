package com.example.wasteapps.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.wasteapps.R

/**class OnboardingActivity : AppCompatActivity() {
    private val onboardingSlideAdapter = OnboardingSlideAdapter(
        listOf(
            OnboardingSlide(
                "Sunlight",
                "Sunlight is the light and energy that comes from the Sun.",
                R.drawable.gambar_one
            ),
            OnboardingSlide(
                "Pay Online",
                "Electronic bill payment is a feature of online, mobile and telephone banking.",
                R.drawable.gambar_two
            ),
            OnboardingSlide(
                "Video Streaming",
                "Streaming media is multimedia that is constantly received by and presented to an end-user.",
                R.drawable.gambar_three
            )
        )
    )
    private lateinit var onboardingSlideViewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onboardingSlideViewPager = findViewById<ViewPager2>(R.id.intro)
        onboardingSlideViewPager.adapter = onboardingSlideAdapter
        setupIndicators()
        setCurrentIndicator(0)
        intro.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)

            }

        })
        buttonNext.setOnClickListener{
            if (intro.currenItem+1<intro.itemCount){
                intro.currentItem+=1<intro.itemCount
            }else{

            }
        }
    }


    private fun setupIndicators() {

        val indicators = arrayOfNulls<ImageView>(onboardingSlideAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorsContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childcount = indicatorsContainer.childCount
        for (i in 0 until childcount) {
            val inageView = indicatorsContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}*/