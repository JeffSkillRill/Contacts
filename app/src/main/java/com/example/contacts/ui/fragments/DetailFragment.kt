package com.example.contacts.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.contacts.R
import com.example.contacts.databinding.FragmentDetailBinding
import com.example.contacts.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)
        binding.detailFragment = this
        binding.toolbarDetailTitle  = "Person Detail"

        val bundle:DetailFragmentArgs by navArgs()
        val resultPerson = bundle.person

        binding.person = resultPerson

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun update(id:Int, name: String,phone:String){
        viewModel.update(id, name, phone)
    }

}