package com.first.app40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.first.app40.databinding.ActivityMyBarcodeReaderBinding
import com.journeyapps.barcodescanner.CaptureManager

class MyBarcodeReaderActivity : AppCompatActivity() {
    private lateinit var capture: CaptureManager

    lateinit var binding:ActivityMyBarcodeReaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_my_barcode_reader)

        capture = CaptureManager(this,binding.barcodeScanner)
        capture.initializeFromIntent(intent, savedInstanceState)
        capture.decode()
    }

    override fun onResume() {
        super.onResume()
        capture.onResume()
    }

    override fun onPause() {
        super.onPause()
        capture.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        capture.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        capture.onSaveInstanceState(outState)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        capture.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}