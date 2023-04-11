package com.example.movie_kelompok3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelFilm:ViewModel() {

    val list = arrayListOf(
        DataFilm("JohnWick", "2023 Sept", "7.9","John Wick adalah mantan pembunuh bayaran yang pensiun dari dunia mafia dengan alasan menikah. Suatu hari, istri John yang bernama Helen Wick meninggal. Helen memberikan John seekor anak anjing yang John terima setelah kematian Helen. Anjing itu dinamai Daisy dan John mengajak jalan-jalan Daisy dengan mobil Mustang untuk menghapus kesedihannya. Di perjalanan, John harus berhenti di sebuah pom bensin dan ia berpas-pasan dengan tiga pemuda. Tiga pemuda itu berbicara dengan bahasa Rusia dan salah satu di antara mereka menghampiri John dan menawarkan diri untuk membeli mobil Mustang John dengan sombong, tetapi John menolaknya yang membuat pemuda itu menghina John dengan bahasa Rusia. Pemuda itu semakin kesal dan ingin bertindak ketika John membalas hinaannya dalam bahasa Rusia juga, tetapi kemudian dilerai oleh salah satu temannya.", R.drawable.john),
        DataFilm("Batman", "2022 Sept", "8.0", "Di Kota Gotham, Bruce Wayne muda jatuh ke sumur kering dan diserang oleh segerombolan kelelawar, mengembangkan ketakutan bruce terhadap kekelawar. Menghadiri opera bersama orang tuanya, Thomas dan Martha, Bruce menjadi ketakutan oleh para pemain yang menyamar sebagai kelelawar dan meminta untuk pergi. Di luar, perampok Joe Chill membunuh orang tua Bruce di depannya, dan Bruce yang yatim piatu dibesarkan oleh kepala pelayan keluarga, Alfred Pennyworth.",R.drawable.bat)
    )

    private var _username : MutableLiveData<String> = MutableLiveData()
    val username : LiveData<String> get() = _username

    private var _listFilm :MutableLiveData<List<DataFilm>> = MutableLiveData()
    val listFilm:LiveData<List<DataFilm>> get() = _listFilm

    fun setUsername(user: String){
        _username.value = user
    }

    fun getFilmList(){
        val film = list
        _listFilm.value = film
    }
}