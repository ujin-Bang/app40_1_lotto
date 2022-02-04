package com.first.app40

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.first.app40.databinding.ActivityQrcodeScanBinding
import com.google.zxing.integration.android.IntentIntegrator

class QrcodeScanActivity : BaseActivity() {

    lateinit var binding: ActivityQrcodeScanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_qrcode_scan)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {



    }

    override fun setValues() {


            }

    fun startBarcodeReader(view:View){

        IntentIntegrator(this).initiateScan()

    }

    fun startBarcodeReaderCustom(view: View){

        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("QR 코드를 스캔하여 주세요")
        integrator.setCameraId(0)
        integrator.setBeepEnabled(true)
        integrator.setBarcodeImageEnabled(true)
        integrator.initiateScan()

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if(result != null){
             if(result.contents != null) {
                 Toast.makeText(this, "scanned: ${result.contents}format: ${result.formatName}", Toast.LENGTH_SHORT).show()
             }
            else{
                 Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
             }
            if(result.barcodeImagePath != null) {
                val bitmap = BitmapFactory.decodeFile(result.barcodeImagePath)
                binding.scannedBitmap.setImageBitmap(bitmap)
            }
        }



        else {
            super.onActivityResult(requestCode, resultCode, data)

        }
    }

}