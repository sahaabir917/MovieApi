package com.example.tvshows.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tvshows.R
import com.example.tvshows.databinding.FragmentTvDetailsBinding
import com.squareup.picasso.Picasso
import kotlin.concurrent.timer

class TvDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentTvDetailsBinding.inflate(inflater,container,false)
        var args = getArguments()
        var image = args!!.getString("image","Not passed any data ")
        var name = args!!.getString("name","Not passed any data ")
        var type = args!!.getString("type","Not passed any data ")
        var language = args!!.getString("language","Not passed any data ")
        var genre = args!!.getString("genre","Not passed any data ")
        var summary = args!!.getString("summary","Not passed any data ")
        var time = args!!.getString("time","Not passed any data ")
        var days = args!!.getString("days","Not passed any data ")
        var officialsite = args!!.getString("officialsite","Not passed any data ")
        var rating = args!!.getString("rating","Not passed any data ")
        var status = args!!.getString("status","Not passed any data ")
        var premiared = args!!.getString("premiared","Not passed any data ")

        binding.moviename.text = "Name : $name"
        binding.type.text = "Type : $type"
        binding.movielanguage.text = "Language : " + language
        binding.genres.text = "Genres : " + genre
        binding.summary.setHtml(summary)
        binding.time.text = "$time"
        binding.days.text = "$days"
        binding.rating.text = "Rating : $rating"
        binding.status.text = "Status : $status"
        binding.premired.text = "$premiared"
        binding.officalsite.setOnClickListener {
            val mArgs = Bundle()
            mArgs.putString("website", officialsite.toString())
            view!!.findNavController()
                .navigate(R.id.action_tvDetailsFragment_to_tvWebsite, mArgs)
        }


        Picasso.get().load(image).into(binding.moviesimage)
        return binding.root
    }

}