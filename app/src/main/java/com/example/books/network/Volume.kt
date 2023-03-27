package com.example.books.network

import kotlinx.serialization.*

@Serializable
data class VolumesList(
    val items : List<Volume>,
    val totalItems : Int
)

@Serializable
data class Volume(
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
