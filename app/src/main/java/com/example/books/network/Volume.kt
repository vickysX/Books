package com.example.books.network

import kotlinx.serialization.*

@Serializable
data class VolumesList(
    val items : List<Volume>
)

@Serializable
data class Volume(
    val volumeId : String,
    val volumeInfo : VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title : String,
    val authors : List<String>,
    val publishedDate : String,
    val description : String,
    val pageCount : String,
    val mainCategory : String,
    val imageLinks : ImageLinks
)

@Serializable
data class ImageLinks(
    val smallThumbnail : String,
    val thumbnail : String
)
