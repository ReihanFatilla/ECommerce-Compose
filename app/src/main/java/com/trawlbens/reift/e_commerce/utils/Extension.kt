package com.trawlbens.reift.e_commerce.utils

object Extension {
    fun String.firstThirdWords(): String {
        return split(" ").take(3).joinToString(" ")
    }
}
