package com.trawlbens.reift.e_commerce.utils

object Extension {
    fun String.firstThirdWords(): String {
        return split(" ").take(3).joinToString(" ")
    }
    fun String.toWordCase(): String {
        val words = this.split(" ")
        val capitalizedWords = words.map { it.capitalize() }
        return capitalizedWords.joinToString(" ")
    }

}
