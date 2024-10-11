package com.example.hh_mock.ui.adapter_delegate.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.home.HeadersModel
import com.example.hh_mock.R
import com.example.hh_mock.databinding.ItemHeaderBinding

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    private val items = ArrayList<HeadersModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return HeaderViewHolder(
            ItemHeaderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HeadersModel, position: Int) {


            when (position + 1) {
                1 -> {
                    binding.tvTitle.text = data.title
                    binding.ivIcon.setImageResource(R.drawable.ic_location)
                    binding.ivIcon.setBackgroundDrawable(itemView.resources.getDrawable(R.drawable.bg_oval_blue))
                }
                2 -> {
                    binding.tvTitle.text = data.title
                    binding.ivIcon.setImageResource(R.drawable.ic_star)
                }
                3 -> {
                    binding.tvTitle.text = data.title
                    binding.ivIcon.setImageResource(R.drawable.ic_list)
                    binding.ivIcon.setPadding(12, 12, 12, 12)
                }
                4 -> {
                    binding.tvTitle.text = data.title
                    binding.ivIcon.setImageResource(R.drawable.ic_map)
                }
                else -> {
                    binding.tvTitle.text = ""
                }
            }

            if (data.buttonText.isNotEmpty()) {
                binding.tvRaise.apply {
                    visibility = View.VISIBLE
                    text = data.buttonText
                }

            }

        }
    }

    fun setItems(data: List<HeadersModel>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}