package com.example.hh_mock.ui.detailed_vacancy.adapter

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.hh_mock.R
import com.example.hh_mock.databinding.BottomSheetReplyBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomDialog(listener: DialogClickListener, private val job: String) : DialogFragment() {

    private lateinit var binding: BottomSheetReplyBinding
    private var listener: DialogClickListener? = null

    init {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext(), R.style.CustomAlertDialogTheme)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
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

        binding.tvAddCoverLetter.visibility = View.GONE
        binding.tvJob.text = job
        binding.etYourCoverLetter.visibility = View.VISIBLE

        binding.tvBtnReply.setOnClickListener {
            listener?.onDialogClickReply(binding.etYourCoverLetter.text.toString())
        }
    }

    interface DialogClickListener {
        fun onDialogClickReply(text: String)
    }
}