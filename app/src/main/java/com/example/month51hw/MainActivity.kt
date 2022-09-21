package com.example.month51hw

import android.annotation.SuppressLint
import android.graphics.Color.green
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.annotation.RequiresApi
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import com.example.month51hw.databinding.ActivityMainBinding
import com.example.month51hw.model.CounterModel
import com.example.month51hw.presenter.Presenter
import com.example.month51hw.view.CounterView

class MainActivity : AppCompatActivity() , CounterView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = Injector.getPresenter()
        presenter.attachView(this)
        initClicker()

    }

    private fun initClicker() {
        with(binding){
            incrementBtn.setOnClickListener {
                presenter.increment()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun upDataCount(count: Int) {
        binding.counterTv.text = count.toString()
    }

    override fun showToastMinusFive() {
        this.showToast("Поздравляю -5")
    }

    override fun showToastPlusTen() {
        this.showToast("Поздравляю 10")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun defaultTextColor() {
        binding.counterTv.setTextColor(getColor(R.color.black))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun textColorFifteen() {
        binding.counterTv.setTextColor(getColor(R.color.green))
    }
}