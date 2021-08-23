package com.humeyrapolat.newsapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */


data class APIResponse(
    val status: String?,
    val news: List<News>?,
    val page: Long?
)

@Entity
data class News(
    @ColumnInfo(name = "id")
    val id: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "url")
    val url: String?,
    @ColumnInfo(name = "author")
    val author: String?,
    @ColumnInfo(name = "image")
    val image: String?,
    @ColumnInfo(name = "language")
    val language: Language? ,
    @ColumnInfo(name = "category")
    val category: List<String>?,
    @ColumnInfo(name = "published")
    val published: String?
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var uuıd: Int = 0
}

enum class Language {
    En
}
