package com.example.books.network

import kotlinx.serialization.*

@Serializable
data class VolumesList(
    val items : List<Volume>
)

@Serializable
data class Volume(
    @SerialName("id")
    val volumeId : String,
    val volumeInfo : VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title : String = "",
    val authors : List<String> = listOf(),
    val publishedDate : String = "",
    val description : String = "",
    val pageCount : Int = 0,
    val mainCategory : String = "",
    val imageLinks : ImageLinks
)

@Serializable
data class ImageLinks(
    val smallThumbnail : String,
    val thumbnail : String
)
