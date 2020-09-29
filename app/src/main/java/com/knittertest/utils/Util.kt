package com.knittertest.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Util {
    companion object {
        fun parseDateToddMMyyyy(time: String?): String? {
            val inputPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS"
            val outputPattern = "dd-MMM-yyyy h:mm a"
            val inputFormat = SimpleDateFormat(inputPattern)
            val outputFormat = SimpleDateFormat(outputPattern)
            var date: Date? = null
            var str: String? = null
            try {
                date = inputFormat.parse(time)
                str = outputFormat.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return str
        }
    }
}