package com.example.month51hw.presenter

import android.view.View
import com.example.month51hw.Injector
import com.example.month51hw.model.CounterModel
import com.example.month51hw.view.CounterView

class Presenter {

    private val model = Injector.getModel()
    lateinit var view: CounterView

    fun increment() {
        model.increment()
        view.upDataCount(model.getCount())
        when {
            model.getCount() == 10 -> {
                view.showToastPlusTen()
            }
            model.getCount() == -5 -> {
                view.showToastMinusFive()
            }
            model.getCount() == 15 -> {
                view.textColorFifteen()
            }
            model.getCount() != 15 -> {
                view.defaultTextColor()
            }
        }
    }

    fun decrement() {
        model.decrement()
        view.upDataCount(model.getCount())
        when {
            model.getCount() == -5 -> {
                view.showToastMinusFive()
            }
            model.getCount() == 10 -> {
                view.showToastPlusTen()
            }
            model.getCount() == 15 -> {
                view.textColorFifteen()
            }
            model.getCount() != 15 -> {
                view.defaultTextColor()
            }
        }
    }
    fun attachView(view: CounterView) {
        this.view = view
    }
}