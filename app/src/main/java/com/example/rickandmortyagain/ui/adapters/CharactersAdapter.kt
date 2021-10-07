package com.example.rickandmortyagain.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyagain.databinding.ItemCharactersBinding
import com.example.rickandmortyagain.models.Info

class CharactersAdapter(
    private val list: List<Info>
) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.count()
    inner class ViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Info) {
            binding.apply {
                binding.textName.text = item.name
                Glide.with(itemView)
                    .load(item.image)
                    .into(binding.imageProfile)

            }
        }

    }
}