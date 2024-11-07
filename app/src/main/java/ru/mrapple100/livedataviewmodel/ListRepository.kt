package ru.mrapple100.livedataviewmodel

class ListRepository {

    val listFilms = arrayListOf<Film>(
        Film("Интерстеллар",2008,"Nolan"),
        Film("Волк с уолл-стрит",2013,"Скорсезэ"),
        Film("Джентельмены",2023,"Рич"),
        Film("Сваты",2000,"Михалков"),
        Film("Чебурашка",2023,"Михалков"),
        Film("Драйв",2011,"Гослинг"),
        Film("Довод",2020,"Nolan"))

    fun getList():ArrayList<Film>{
        return listFilms
    }
}