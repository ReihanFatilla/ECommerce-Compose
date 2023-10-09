package com.trawlbens.reift.e_commerce.utils

import androidx.compose.ui.text.capitalize
import java.util.Locale

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
