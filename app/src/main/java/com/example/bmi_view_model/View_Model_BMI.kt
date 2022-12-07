package com.example.bmi_view_model

import androidx.lifecycle.ViewModel


class View_Model_BMI:ViewModel() {
    fun calculate(w: Double, h: Double):Double{
        var BMI=   String.format("%.2f",(w/(h*h))*10000).toDouble()
        return BMI
    }

    fun tips(s: Double):String{
        lateinit var tvTips:String
        if(s< 18.5){
            tvTips = " Result \n Your BMI: $s \n You are Underweight"}

        else if( s>18.5 && s<24.9){
            tvTips= " Result \n Your BMI: $s \n You have Normal Weight"}

        else if(s>25 && s<29.9){
            tvTips = " Result \n Your BMI: $s \nYou are OverWeight"}

        else if(s>30 && s<34.9){
            tvTips = "Result \n Your BMI: $s \n You are at OverWeight Class-1"}

        else if (s>35 && s<39.9){
            tvTips = "Result \n Your BMI: $s \nYou are at OverWeight Class-2"}

        else{
            tvTips = "Result \n Your BMI: $s \nYou are at OverWeight Class- 3"}
        return tvTips
    }
}