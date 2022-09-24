package com.example.tobuylist.util

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.DateFormat

@BindingAdapter("setPriority")
fun setPriority(view: TextView, priority: Int) {
    when(priority) {
        0 -> {
            view.text = "Fruit"
            view.setTextColor(Color.MAGENTA)
        }
        1 -> {
            view.text = "Vegetable"
            view.setTextColor(Color.YELLOW)
        }
        else -> {
            view.text = "Dairy Product"
            view.setTextColor(Color.WHITE)
        }
    }
}

@BindingAdapter("setTimestamp")
fun setTimestamp(view: TextView, timestamp: Long) {
    view.text = DateFormat.getInstance().format(timestamp)
}