package com.example.contacts.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.contacts.R
import com.example.contacts.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.addbtn.setOnClickListener{
                inserDataToDatabse()
        }

        return binding.root
    }

    private fun inserDataToDatabse() {
        val firstName = binding.addPersonFirstName.text.toString()
        val lastName = binding.addPersonLastName.text.toString()
        val phoneNumber = binding.addTextPhone.toString()

        if (inputCheck(firstName, lastName, phoneNumber))
        {
            val user = User(0, firstName, lastName, phoneNumber)
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else
        {
            Toast.makeText(requireContext(), "Fill all fields", Toast.LENGTH_SHORT).show()

        }
    }

    private fun inputCheck(firstName:String, lastName:String, phoneNumber: String): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName))
    }


}