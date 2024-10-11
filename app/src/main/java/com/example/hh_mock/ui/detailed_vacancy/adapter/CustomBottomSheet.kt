package com.example.hh_mock.ui.detailed_vacancy.adapter

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hh_mock.R
import com.example.hh_mock.databinding.BottomSheetReplyBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomSheet(listener: BottomSheetClickListener, private val job: String) : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetReplyBinding
    private var bottomSheetListener: BottomSheetClickListener? = null

    init {
        bottomSheetListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetReplyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvJob.text = job
        binding.tvAddCoverLetter.setOnClickListener {
            bottomSheetListener?.onClickCoverLetter()
        }

        binding.tvBtnReply.setOnClickListener {
            bottomSheetListener?.onClickReply()
        }
    }

    interface BottomSheetClickListener {
        fun onClickCoverLetter()
        fun onClickReply()
    }
}