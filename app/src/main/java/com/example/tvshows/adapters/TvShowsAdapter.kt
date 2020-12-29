package com.example.tvshows.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tvshows.R
import com.example.tvshows.network.TvShowsDataItem
import com.squareup.picasso.Picasso

class TvShowsAdapter(private val context: Context, listener: Itemclicklistener ): RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {
    private var dataSet : MutableList<TvShowsDataItem>?=null
    var itemClickListerner: Itemclicklistener? = null
    init {
        dataSet = mutableListOf<TvShowsDataItem>()
        this.itemClickListerner = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.tvcard,  null)
        return TvShowsViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataSet == null)
            return 0

        else{
            return dataSet!!.size
        }
    }

    public fun setData(data: MutableList<TvShowsDataItem>){
        dataSet = data
        notifyDataSetChanged()
    }



    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvdatas = dataSet?.elementAt(position)


//       if(currency?.destination == "ALL"){
//            holder.imageIcon.setImageResource(R.drawable.ALL)
//        }

        holder.name.setText(tvdatas!!.name)
        holder.genres.setText("Tag : " +tvdatas!!.genres.toString())
        holder.language.setText(tvdatas.language.toString())
        Picasso.get().load(tvdatas!!.image.medium).into(holder.image)

//        holder.currencyRate.setText("$"+currency?.rate)

        holder.itemView.setOnClickListener {
            tvdatas?.let { it1 -> itemClickListerner!!.onClickItemClick(it, it1,position) }
        }

        holder.closeButton.setOnClickListener {
            tvdatas?.let { it1->itemClickListerner!!.onDeleteClick(it,it1) }
        }

    }




    class TvShowsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var image: ImageView
        lateinit var name: TextView
        lateinit var genres:TextView
        lateinit var language : TextView
        lateinit var closeButton : ImageView


        init {
            image = itemView.findViewById(R.id.tvimage)
            name = itemView.findViewById(R.id.name)
            genres = itemView.findViewById(R.id.genres)
            language = itemView.findViewById(R.id.language)
            closeButton = itemView.findViewById(R.id.closebutton)

        }
    }

    interface Itemclicklistener{
        fun onClickItemClick(view:View, data: TvShowsDataItem,position: Int)
        fun onDeleteClick(view:View, data : TvShowsDataItem)
    }
}
