package com.humeyrapolat.newsapp.util

import androidx.room.TypeConverter
/**
 * @author Hümeyra POLAT
 * @sınce 23.08.2021
 */

class Converters {


    @TypeConverter
    fun fromListToInteger(intList: List<Int>?): String {
        if (intList == null) return ""
        return intList.joinToString(",")
    }

    @TypeConverter
    fun fromListToString(stringList: List<String>?): String {
        if (stringList == null) return ""
        return stringList.joinToString(",")
    }

    @TypeConverter
    fun fromStringToIntegerList(list: String?): List<Int> {
        if (list == null) return ArrayList()
        return list.split(",").map { it.toInt() }
    }

    @TypeConverter
    fun fromStringToStringList(list: String?): List<String> {
        if (list == null) return ArrayList()
        return list.split(",").map { it }
    }


}