package com.example.movie_kelompok3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie_kelompok3.DataFilm
import com.example.movie_kelompok3.R
import com.example.movie_kelompok3.databinding.FragmentDetailFilmBinding


class DetailFilmFragment : Fragment() {

    lateinit var binding:FragmentDetailFilmBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailFilmBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val img  = arguments?.getInt("img")
        val namaJudul = arguments?.getString("judul")
        val tglRilis = arguments?.getString("tgl")
        val rating = arguments?.getString("rating")
        val deskripsi = arguments?.getString("desc")

        val listFilm = DataFilm(namaJudul.toString(),tglRilis.toString(),rating.toString(),deskripsi.toString(),img.toString().toInt())
        binding.film = listFilm
    }


}