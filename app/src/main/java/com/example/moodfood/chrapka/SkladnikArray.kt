package com.example.moodfood.chrapka

class SkladnikArray(private var nazwa: String, var checked: Boolean) {


    @JvmName("getNazwa1")
    fun getNazwa(): String {
        return nazwa
    }
    fun isChecked(): Boolean {
        return checked
    }

}