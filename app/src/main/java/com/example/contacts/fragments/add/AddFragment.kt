package com.example.contacts.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contacts.R
import com.example.contacts.databinding.FragmentAddBinding
import com.example.contacts.databinding.FragmentListBinding

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)

        binding.addbtn.setOnClickListener{

        }

        return binding.root
    }


}