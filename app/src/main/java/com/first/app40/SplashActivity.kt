package com.first.app40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.first.app40.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {


    }

    override fun setValues() {

        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed({

              val myIntent = Intent(mContext,MainActivity::class.java)
               startActivity(myIntent)
                finish()

        },3000)

    }
}