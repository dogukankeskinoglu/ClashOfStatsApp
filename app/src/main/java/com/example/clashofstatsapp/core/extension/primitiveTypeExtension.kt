package com.example.clashofstatsapp.core.extension

fun Int?.orZero(): Int{
    return this ?: return 0
}