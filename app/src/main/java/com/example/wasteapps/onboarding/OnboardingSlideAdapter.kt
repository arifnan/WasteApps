package com.example.wasteapps.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteapps.R

    class OnboardingSlideAdapter(private val onboardingSlides:List<OnboardingSlide>):
        RecyclerView.Adapter<OnboardingSlideAdapter.OnboardingSlideViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingSlideViewHolder {
            return OnboardingSlideViewHolder(
                LayoutInflater.from(parent.context).inflate
                    ( R.layout.slide_item_container,
                    parent,
                    false
                )
            )

        }
        override fun getItemCount(): Int {

            return onboardingSlides.size

        }

        override fun onBindViewHolder(holder: OnboardingSlideViewHolder, position: Int) {
            holder.bind(onboardingSlides[position])
        }

        inner class OnboardingSlideViewHolder(view: View): RecyclerView.ViewHolder(view) {

            private val textTitle = view.findViewById<TextView>(R.id.textTitle)

            private val textDescription = view.findViewById<TextView>(R.id.textDescription)

            private val imageIcon = view.findViewById<ImageView>(R.id.imageSlideIcon)

            fun bind(onboardingSlide: OnboardingSlide) {

                textTitle.text = onboardingSlide.title
                textDescription.text = onboardingSlide.description
                imageIcon.setImageResource(onboardingSlide.icon)
            }
        }
}