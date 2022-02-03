package com.first.app40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.databinding.DataBindingUtil
import com.first.app40.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        val lotteryNumbers = arrayListOf(binding.number1, binding.number2, binding.number3,binding.number4,binding.number5,binding.number6)

        val countDownTimer = object : CountDownTimer(3000,100) {
            override fun onTick(p0: Long) {
                lotteryNumbers.forEach {

                    val randomNumber = (Math.random()*45+1).toInt()
                    it.text ="$randomNumber"
            }
            }
            override fun onFinish() {

            }

        }

        binding.lotteryButton.setOnClickListener {

            if(binding.lotteryButton.isAnimating) {
                binding.lotteryButton.cancelAnimation()
                countDownTimer.cancel()
            }
            else {
                binding.lotteryButton.playAnimation()
                countDownTimer.start()

            }

//





        }

    }

    override fun setValues() {

    }


}