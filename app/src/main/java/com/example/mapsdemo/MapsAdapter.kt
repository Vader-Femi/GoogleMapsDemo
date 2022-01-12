package com.example.mapsdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mapsdemo.MapsAdapter.*
import com.example.mapsdemo.databinding.ItemViewBinding
import com.example.mapsdemo.models.UserMap

class MapsAdapter(val userMaps: List<UserMap>, val onClickListener: OnClickListener) :
    RecyclerView.Adapter<MapsViewHolder>() {

    interface OnClickListener{
        fun onItemClick(position: Int)
    }
    inner class MapsViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapsViewHolder {
        return MapsViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holderMaps: MapsViewHolder, position: Int) {
        holderMaps.binding.apply {
            tvUserMap.text = userMaps[position].title
            tvUserMap.setOnClickListener {
                onClickListener.onItemClick(position)
            }
        }

    }

    override fun getItemCount() = userMaps.size

}
