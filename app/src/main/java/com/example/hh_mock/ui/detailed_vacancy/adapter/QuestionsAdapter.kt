package com.example.hh_mock.ui.detailed_vacancy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.home.HeadersModel
import com.example.hh_mock.R
import com.example.hh_mock.databinding.ItemHeaderBinding
import com.example.hh_mock.databinding.ItemQuestionListBinding

class QuestionsAdapter : RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder>() {

    private val items = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        return QuestionsViewHolder(
            ItemQuestionListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class QuestionsViewHolder(private val binding: ItemQuestionListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: String) {

        binding.tvResponsibility.text = question

        }
    }

    fun setItems(data: List<String>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}