package com.example.tvshows.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvshows.R
import com.example.tvshows.adapters.TvShowsAdapter
import com.example.tvshows.databinding.FragmentTvBinding
import com.example.tvshows.network.TvShowsData
import com.example.tvshows.network.TvShowsDataItem
import com.example.tvshows.viewmodel.TvFragmentViewModel


class TvFragment : Fragment() {

    private val viewModel: TvFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(TvFragmentViewModel::class.java)
    }
    private  var tvdata : MutableList<TvShowsDataItem>?=null
   private lateinit var binding : FragmentTvBinding
    private lateinit var adapter: TvShowsAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var alertDialog: AlertDialog.Builder
    lateinit var dialog: AlertDialog

    init {
        tvdata = mutableListOf<TvShowsDataItem>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTvBinding.inflate(inflater,container,false)
        binding.setLifecycleOwner(this)


        initObserver()


        binding.recyclerview.layoutManager = LinearLayoutManager(inflater.context)


        adapter = TvShowsAdapter(inflater.context, object : TvShowsAdapter.Itemclicklistener {
                override fun onClickItemClick(view: View, data: TvShowsDataItem,position : Int) {
                   d("onclick","onclick is clicked")
                    d("tvdatas",tvdata.toString())
                    val mArgs = Bundle()
                    mArgs.putString("name", data.name)
                    mArgs.putString("language",data.language)
                    mArgs.putString("type",data.type)
                    mArgs.putString("genre",data.genres.toString())
                    mArgs.putString("summary",data.summary)
                    mArgs.putString("time",data.schedule.time)
                    mArgs.putString("days",data.schedule.days.toString())
                    mArgs.putString("officialsite",data.officialSite)
                    mArgs.putString("rating",data.rating.average.toString())
                    mArgs.putString("status",data.status.toString())
                    mArgs.putString("premiared",data.premiered.toString())
                    mArgs.putString("image",data.image.original)

                    view.findNavController()
                        .navigate(R.id.action_tvFragment_to_tvDetailsFragment, mArgs)
                }

                override fun onDeleteClick(view: View, data: TvShowsDataItem) {
                    d("ondelete","ondelete is clicked")
                    alertDialog = AlertDialog.Builder(context)
                    var view1 = layoutInflater.inflate(R.layout.popupwindow,null)
                    var yes =view1.findViewById<Button>(R.id.yes)
                    var no =view1.findViewById<Button>(R.id.no)

                    yes.setOnClickListener {
                        var sizeoftvdatas = tvdata!!.size - 2
                        for(i in 0..sizeoftvdatas){
                            if(data == tvdata!![i]){
                                d("matched","matched")
                                tvdata?.removeAt(i)
                                adapter.setData(tvdata as MutableList<TvShowsDataItem>)
                            }
                        }
                        dialog.cancel()
                    }

                    no.setOnClickListener {
                        d("no","no")
                        dialog.cancel()
                    }

                    alertDialog.setView(view1)
                    dialog = alertDialog.create()
                    dialog.show()


                }
            })

        setHasOptionsMenu(true)
        binding.recyclerview.adapter = adapter

        return binding.root
    }




    private fun initObserver() {
        viewModel.properties.observe(viewLifecycleOwner, Observer {
           showAllData(it)
        })
    }

    private fun showAllData(tvShowDatas: TvShowsData?) {
        d("datas", tvShowDatas.toString())
        tvdata = tvShowDatas
        adapter.setData(tvdata as MutableList<TvShowsDataItem>)
        layoutManager = LinearLayoutManager(activity)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.setHasFixedSize(true)
    }


}