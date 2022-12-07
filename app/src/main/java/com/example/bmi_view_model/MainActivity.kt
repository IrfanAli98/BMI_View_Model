package com.example.bmi_view_model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bmi_view_model.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: View_Model_BMI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[View_Model_BMI::class.java]

        dataBinding.btnCalculate.setOnClickListener {
            if (dataBinding.etHeight.text.toString().isNotEmpty() && dataBinding.etWeight.text.toString().isNotEmpty()){
            val bmi = viewModel.calculate(dataBinding.etWeight.text.toString().toDouble(), dataBinding.etHeight.text.toString().toDouble())
            dataBinding.tvTips.text=viewModel.tips(bmi)}
            else{
                Toast.makeText(this@MainActivity, "Enter Height and Weight", Toast.LENGTH_SHORT).show()}
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option_items , menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.it_about->{
                val intent = Intent(this@MainActivity, AboutAppActivity::class.java)
                startActivity(intent)
            }

            R.id.it_bmiChart->{
                val intent= Intent(this@MainActivity, BMIChartActivity::class.java)
                startActivity(intent)
            }

            R.id.it_contact->{
                val intent = Intent(this@MainActivity, ContactUsActivity::class.java)
                startActivity(intent)
            }

            R.id.it_exit->{
                //This is alert Dialogue implementation to Exit app
                val alertdialog : AlertDialog = AlertDialog.Builder(this).create()
                alertdialog.setMessage("Do you want to exit")

                alertdialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes"){
                        dialog, which-> finish()
                    dialog.dismiss()}
                alertdialog.setButton(AlertDialog.BUTTON_NEGATIVE,"No"){
                        dialog, which->
                    dialog.dismiss()
                }
                alertdialog.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        Toast.makeText(this,"Press Exit from option menu", Toast.LENGTH_SHORT).show()
    }

}