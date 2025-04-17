package br.senai.sp.jandira.bmi.utils

import java.util.Locale

fun numberConvertTolocale(value: Double): String{
    return String.format(Locale.getDefault(), "%.1f", value)
}