package ru.mrapple100.livedataviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomViewModel : ViewModel() {

    val repo = ListRepository()


    val mutableLiveDataList = MutableLiveData<ArrayList<Film>>()
    val mutableLiveDataTextList = MutableLiveData<String>().apply {
        value = repo.getList().toString()
    }
    val mutableLiveDataKeyWord = MutableLiveData<String>()

    fun search (){
        val keyword = mutableLiveDataKeyWord.value
        mutableLiveDataList.value = keyword?.let { repo.getList().filterListTitle(it) }
        mutableLiveDataTextList.value = mutableLiveDataList.value.toString()
    }


    fun ArrayList<Film>.filterListTitle(keyword:String): ArrayList<Film> {
        return this.filter{it ->  it.title.lowercase().startsWith(keyword.lowercase())} as ArrayList
    }
    fun ArrayList<Film>.filterListYear(keyword:String): ArrayList<Film>{
        //">2005"  "<2020"
        return this.filter{it ->
            if(keyword.length==5) {
                val char = keyword[0]
                if (char == '>') {
                    return@filter (it.year > (keyword.split(">")[1].toInt()))
                } else if (char == '<') {
                    return@filter it.year < (keyword.split("<")[1].toInt())
                }
            }
            return@filter false
        } as ArrayList<Film>
    }
    fun ArrayList<Film>.sortListDirector(keyword:String): ArrayList<Film> {
        //>  < лексикографически
        if(keyword.equals(">")) {

            return this.sortedBy { it -> it.director }.toList() as ArrayList<Film>
        }else{
            return this.sortedByDescending { it -> it.director } as ArrayList<Film>
        }
    }


}