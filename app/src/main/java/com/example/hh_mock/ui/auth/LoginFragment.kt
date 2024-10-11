package com.example.hh_mock.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.data.local.AppPreferences
import com.example.hh_mock.R
import com.example.hh_mock.databinding.FragmentLoginBinding
import javax.inject.Inject

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvBtnContinue.setOnClickListener {
            val email = binding.etEmail.text.toString()
            if (email.isEmpty()){
                Toast.makeText(requireContext(), R.string.EmailError, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val action = LoginFragmentDirections.actionLoginFragmentToVerifyFragment(email)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}