package com.example.books

import android.app.Application
import com.example.books.data.AppContainer
import com.example.books.data.BooksAppContainer

class BooksApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = BooksAppContainer()
    }
}