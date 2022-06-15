package com.example.bikehelper_mobileapp_project

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.media.tv.TvView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import java.util.*

private const val CAMERA_REQUEST_CODE = 101

class QRScanner : AppCompatActivity() {

    private lateinit var codeScanner: CodeScanner
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrscanner)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.darkgrey)

        setupPermissions()
        codeScanner()
    }

    fun addToDb(view: View){

        val text = "Nothing was scanned!"
        val duration = Toast.LENGTH_SHORT

        if(textView.text.isEmpty()){
             Toast.makeText(applicationContext, text, duration).show()
        } else  {
            val index = textView.text.toString()
            val intent = Intent(this, BikeAddition::class.java).apply {
                putExtra("bike_code_data", index)
            }
            startActivity(intent)
        }
    }

    private fun codeScanner() {
        codeScanner = CodeScanner(this, findViewById(R.id.QRScannerView))

        codeScanner.apply {
            camera=CodeScanner.CAMERA_BACK
            formats=CodeScanner.ALL_FORMATS
            autoFocusMode=AutoFocusMode.SAFE
            scanMode=ScanMode.CONTINUOUS
            isAutoFocusEnabled=true
            isFlashEnabled=false

            textView=findViewById(R.id.tv_textView)

            decodeCallback= DecodeCallback {
                runOnUiThread {
                    textView.text = it.text
                }
            }

            errorCallback= ErrorCallback {
                runOnUiThread {
                    Log.e("Main","Camera initialization error: ${it.message}")
                }
            }

            }
        }
    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    private fun setupPermissions(){
        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        if(permission != PackageManager.PERMISSION_GRANTED){
            makeRequest()
        }
    }

    private fun makeRequest(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"You need the camera permission to be able to use this app!",Toast.LENGTH_SHORT).show()
                } else {
                    //success
                }
            }
        }
    }

}
