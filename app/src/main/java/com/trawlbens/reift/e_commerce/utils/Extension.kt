package com.trawlbens.reift.e_commerce.utils

object Extension {
    fun String.firstTwoWords(): String {
        return split(" ").take(2).joinToString(" ")
    }
}
