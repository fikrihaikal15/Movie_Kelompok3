package com.example.movie_kelompok3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie_kelompok3.DataFilm
import com.example.movie_kelompok3.R
import com.example.movie_kelompok3.ViewModelFilm
import com.example.movie_kelompok3.adapter.FilmAdapter
import com.example.movie_kelompok3.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vmFilm = ViewModelProvider(this).get(ViewModelFilm::class.java)
        val usernameAccount = arguments?.getString("USERNAME")
        vmFilm.setUsername(usernameAccount.toString())


        vmFilm.getFilmList()
        val adapter = FilmAdapter(ArrayList())
        vmFilm.listFilm.observe(viewLifecycleOwner, Observer {
            adapter.setFilmList(it as ArrayList<DataFilm>)
        })

        val rv = binding.rvFilm
        rv.adapter = adapter
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv.layoutManager = layoutManager

        var isGridLayout = false

        binding.ivGridOnOff.setOnClickListener {
            isGridLayout = !isGridLayout
            if (isGridLayout){
                binding.ivGridOnOff.setImageResource(R.drawable.ic_grid_on)
                rv.layoutManager = GridLayoutManager(requireContext(),2)
                rv.adapter = adapter

            }else{
                binding.ivGridOnOff.setImageResource(R.drawable.ic_grid_off)
                rv.layoutManager = layoutManager
                rv.adapter = adapter
            }
        }

        binding.btnProfile.setOnClickListener {
            vmFilm.username.observe(viewLifecycleOwner, Observer {
                val bundleData = Bundle().apply {
                    putString("USERNAME", it as String)
                }
                findNavController().navigate(R.id.action_homeFragment_to_profileFragment, bundleData)
            })
        }

    }






}