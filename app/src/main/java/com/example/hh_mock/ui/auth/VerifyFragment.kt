package com.example.hh_mock.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hh_mock.R
import com.example.hh_mock.databinding.FragmentVerifyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerifyFragment : Fragment() {

    private var _binding: FragmentVerifyBinding? = null
    private val binding get() = _binding!!
    private val args: VerifyFragmentArgs by navArgs()
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerifyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSentToEmail.text = getString(R.string.SentCodeToEmail, args.email)

        binding.tvBtnConfirm.setOnClickListener {
            val verificationCodes = binding.etVerificationCode1.text.toString() +
                    binding.etVerificationCode2.text.toString() +
                    binding.etVerificationCode3.text.toString() +
                    binding.etVerificationCode4.text.toString()

            if (verificationCodes.length != 4) {
                Toast.makeText(requireContext(), "Введите код", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            authViewModel.login(verificationCodes)

            authViewModel.isLogin.observe(viewLifecycleOwner) {
                isLogin(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isLogin(login: Boolean) {
        if (login) {
            findNavController().navigate(R.id.action_verifyFragment_to_homeFragment)
        }
    }
}