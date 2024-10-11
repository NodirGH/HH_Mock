package com.example.hh_mock.ui.detailed_vacancy.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.data.model.home.VacancyModel
import com.example.hh_mock.R
import com.example.hh_mock.databinding.FragmentDetailedVacancyBinding
import com.example.hh_mock.ui.FavoriteVacancyStorage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailedVacancyFragment : Fragment(), CustomBottomSheet.BottomSheetClickListener,
    CustomDialog.DialogClickListener {

    private var _binding: FragmentDetailedVacancyBinding? = null
    private val binding get() = _binding!!
    private val args: DetailedVacancyFragmentArgs by navArgs()
    lateinit var bottomSheetDialog: CustomBottomSheet
    lateinit var bottomSheetListener: CustomBottomSheet.BottomSheetClickListener
    private lateinit var dialog: CustomDialog
    private lateinit var dialogListener: CustomDialog.DialogClickListener
    private lateinit var favoriteVacancyStorage: FavoriteVacancyStorage

    @Inject
    lateinit var questionsAdapter: QuestionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomSheetListener = this
        dialogListener = this
        favoriteVacancyStorage = FavoriteVacancyStorage(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailedVacancyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData(args.vacancyModel)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvBtnReply.setOnClickListener {
            showBottomSheet(args.vacancyModel.title)
        }
    }

    private fun showBottomSheet(job: String) {
        bottomSheetDialog = CustomBottomSheet(bottomSheetListener, job)
        bottomSheetDialog.show(this.parentFragmentManager, "tag")

    }

    private fun setData(vacancyModel: VacancyModel) {
        questionsAdapter.setItems(vacancyModel.questions)
        binding.rvQuestionList.adapter = questionsAdapter

        binding.tvTitle.text = vacancyModel.title
        binding.tvSalary.text = vacancyModel.fullSalary
        binding.tvAppliedNumbers.text =
            requireContext().getString(R.string.AppliedNumbers, vacancyModel.appliedNumber)
        binding.tvLookingNumbers.text =
            requireContext().getString(R.string.LookingNumbers, vacancyModel.lookingNumber)
        binding.tvCompany.text = vacancyModel.company
        binding.tvExactAddress.text =
            "${vacancyModel.town}, ${vacancyModel.street}, ${vacancyModel.house}"
        binding.tvDescription.text = vacancyModel.description
        binding.tvResponsibilityList.text = vacancyModel.responsibilities
        binding.tvExperience.text = requireContext().getString(
            R.string.RequiredExperience,
            vacancyModel.experiencePreviewText
        )
        if (vacancyModel.isFavorite) {
            binding.ivFavorite.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.ivFavorite.setImageResource(R.drawable.ic_favorite)
        }

        val schedule = vacancyModel.schedules.joinToString(", ")
        binding.tvSchedule.text = schedule
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickCoverLetter() {
        bottomSheetDialog.dismiss()
        showDialog()
    }

    override fun onClickReply() {
        Toast.makeText(requireContext(), "Успешный", Toast.LENGTH_SHORT).show()
        bottomSheetDialog.dismiss()
    }

    private fun showDialog() {

        dialog = CustomDialog(dialogListener, job = args.vacancyModel.title)
        dialog.show(parentFragmentManager, "tag_dialog")

    }

    override fun onDialogClickReply(text: String) {
        Toast.makeText(requireContext(), "Успешный", Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }
}