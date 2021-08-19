package com.humeyrapolat.newsapp.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

data class APIResponse(
    val status: String,
    val news: List<News>,
    val page: Long
)

data class News(
    val id: String,
    val title: String,
    val description: String,
    val url: String,
    val author: String,
    val image: String,
    val language: Language,
    val category: List<String>,
    val published: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var uuıd: Int = 0
}

enum class Language {
    En
}
