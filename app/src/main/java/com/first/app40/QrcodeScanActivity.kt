package com.first.app40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.integration.android.IntentIntegrator

class QrcodeScanActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode_scan)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        initQrcodeScanner()
    }
    private fun initQrcodeScanner() {

        val integrator = IntentIntegrator(this)
        integrator.setBeepEnabled

    }
}