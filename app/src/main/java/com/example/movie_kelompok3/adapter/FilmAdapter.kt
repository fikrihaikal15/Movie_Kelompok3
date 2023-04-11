package com.example.movie_kelompok3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_kelompok3.DataFilm
import com.example.movie_kelompok3.databinding.ItemFilmBinding

class FilmAdapter (var listFilm : ArrayList<DataFilm>) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
    class ViewHolder (val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindFilm(itemFilm : DataFilm){
            binding.film = itemFilm
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAdapter.ViewHolder {
        val view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmAdapter.ViewHolder, position: Int) {
        holder.bindFilm(listFilm[position])
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }

    fun setFilmList(listFilm: ArrayList<DataFilm>){
        this.listFilm = listFilm
        notifyDataSetChanged()
    }
}