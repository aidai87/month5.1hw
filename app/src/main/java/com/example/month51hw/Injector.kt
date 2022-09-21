package com.example.month51hw

import com.example.month51hw.model.CounterModel
import com.example.month51hw.presenter.Presenter

class Injector {
    companion object{
        fun getPresenter(): Presenter {
            return Presenter()
        }
        fun getModel(): CounterModel {
            return CounterModel()
        }
    }
}