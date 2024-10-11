package com.example.hh_mock.ui.adapter_delegate.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.home.VacancyModel
import com.example.hh_mock.R
import com.example.hh_mock.databinding.ItemVacancyBinding
import com.example.toolkit.extensions.formatDateToRussian

class VacanciesAdapter() : RecyclerView.Adapter<VacanciesAdapter.VacanciesViewHolder>() {

    private val items = ArrayList<VacancyModel>()

    private lateinit var vacancyListener: VacancyClickListener

    fun setOnVacancyCLickListener(listener: VacancyClickListener) {
        vacancyListener = listener
    }

    interface VacancyClickListener {
        fun onVacancyClick(vacancyModel: VacancyModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacanciesViewHolder {
        return VacanciesViewHolder(
            ItemVacancyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VacanciesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class VacanciesViewHolder(private val binding: ItemVacancyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: VacancyModel) {
            binding.tvAddress.text = data.town
            binding.tvProfession.text = data.title
            binding.tvExperiencedYears.text = data.experiencePreviewText
            binding.tvNumberOfCandidates.text =
                itemView.resources.getString(R.string.NumberOfCandidates, data.lookingNumber)
            binding.tvPublishedDate.text = formatDateToRussian(data.publishedDate!!)
            binding.tvSalary.text = data.fullSalary
            binding.tvCompanyName.text = data.company
            if (data.isFavorite) {
                binding.ivAddFavorite.setImageResource(R.drawable.ic_favorite_filled)
            } else {
                binding.ivAddFavorite.setImageResource(R.drawable.ic_favorite)
            }

            binding.ivAddFavorite.setOnClickListener {
                if (data.isFavorite) {
                    binding.ivAddFavorite.setImageResource(R.drawable.ic_favorite)
                    data.isFavorite = false
                } else {
                    binding.ivAddFavorite.setImageResource(R.drawable.ic_favorite_filled)
                    data.isFavorite = true
                }
            }

            binding.llVacancy.setOnClickListener {
                vacancyListener.onVacancyClick(data)
            }
        }
    }

    fun setItems(data: List<VacancyModel>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}