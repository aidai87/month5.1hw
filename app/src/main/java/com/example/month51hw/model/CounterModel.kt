package com.example.month51hw.model

open class CounterModel {
    private var count = 0

    fun increment() {
        ++count
    }

    fun decrement() {
        --count
    }

    fun getCount(): Int {
        return count
    }

   }
