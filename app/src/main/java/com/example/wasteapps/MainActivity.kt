package com.example.wasteapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.wasteapps.home.HomeActivity
import com.example.wasteapps.onboarding.OnboardingSlide
import com.example.wasteapps.onboarding.OnboardingSlideAdapter

class MainActivity: AppCompatActivity() {

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
    private lateinit var intro: ViewPager2
    private lateinit var buttonNext: Button
    private lateinit var indicatorsContainer: LinearLayout
    private lateinit var buttonSkip: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onboardingSlideViewPager = findViewById<ViewPager2>(R.id.intro)
        intro = findViewById<ViewPager2>(R.id.intro)
        buttonNext = findViewById<Button>(R.id.button_next)
        indicatorsContainer = findViewById<LinearLayout>(R.id.indicatorsContainer)

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
        buttonNext.setOnClickListener {
            if (intro.currentItem + 1 < intro.adapter!!.itemCount) {
                intro.currentItem += 1
            } else {
                moveToAddStory() // Navigate to Home activity when last slide is reached
            }
        }
        buttonSkip = findViewById<Button>(R.id.textSkip)

        buttonSkip.setOnClickListener {
            moveToAddStory() // Navigate to Home activity when "Skip" button is clicked
        }

    }
    private fun moveToAddStory() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish() // Finish the current activity to prevent back navigation
    }

    private fun setupIndicators() {

        val indicators = arrayOfNulls<ImageView>(onboardingSlideAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
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
            val inageView = indicatorsContainer.getChildAt(i) as ImageView
            if (i == index) {
                inageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            } else {
                inageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }
        }
    }
}