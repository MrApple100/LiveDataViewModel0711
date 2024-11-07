package ru.mrapple100.livedataviewmodel

class Film(
    val title: String,
    val year: Int,
    val director: String
) {
    override fun toString(): String {
        return "Film(title='$title', year=$year, director='$director')"
    }
}