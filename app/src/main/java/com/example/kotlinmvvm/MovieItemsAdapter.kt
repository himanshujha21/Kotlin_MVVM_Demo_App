package com.example.kotlinmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinmvvm.databinding.RowMovieItemsBinding
import com.example.kotlinmvvm.model.MovieResItem

class MovieItemsAdapter :
    RecyclerView.Adapter<MovieItemsAdapter.MovieViewHolder>() {
      private var mList = mutableListOf<MovieResItem>()

    fun setMovies(mList: List<MovieResItem>) {
        this.mList = mList.toMutableList()
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        //
        val view = LayoutInflater.from(parent.context)
        val binding = RowMovieItemsBinding.inflate(view, parent, false)


        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val mList = mList[position]
        holder.binding.tvName.text = mList.name
        Glide.with(holder.binding.ivIcon.context).load(mList.imageUrl).into(holder.binding.ivIcon)


    }

    override fun getItemCount(): Int {
        return mList.size

    }

    inner class MovieViewHolder(val binding: RowMovieItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val mName = binding.tvName
        private val mIcon = binding.ivIcon

    }


}
