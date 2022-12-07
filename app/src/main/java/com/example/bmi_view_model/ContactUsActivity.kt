package com.example.bmi_view_model

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.bmi_view_model.databinding.ActivityContactUsBinding

class ContactUsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var dataBinding: ActivityContactUsBinding
    private val requestPermissionList = arrayOf(android.Manifest.permission.CALL_PHONE)
    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_contact_us)

        dataBinding.btnDial.setOnClickListener(this)
        dataBinding.btnCall.setOnClickListener(this)
        dataBinding.btnEmail.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_dial -> {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9990174891"))
                startActivity(intent)
            }
            R.id.btn_call -> {
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED){
                    actionCall()
                }else{
                    ActivityCompat.requestPermissions(this, requestPermissionList, 1)
                }
            }

            R.id.btn_email -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/mail/u/0/#inbox"))
                startActivity(intent)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==REQUEST_CODE && permissions.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            actionCall()
        }else{
            Toast.makeText(this, "Please allow the permission", Toast.LENGTH_SHORT).show()
        }
    }

    private fun actionCall(){val intent= Intent(Intent.ACTION_CALL, Uri.parse("tel:9990174891"))
        startActivity(intent)}
}
