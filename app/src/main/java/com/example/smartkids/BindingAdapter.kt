package com.example.smartkids

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("src")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}