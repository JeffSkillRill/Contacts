package com.example.contacts.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.entity.Persons
import com.example.contacts.databinding.CardDesignBinding
import com.example.contacts.ui.fragments.HomeFragmentDirections
import com.example.contacts.ui.util.go
import com.example.contacts.ui.viewmodel.HomeViewModel
import com.google.android.material.snackbar.Snackbar


class PersonAdapter(var mContext: Context, var personList: List<Persons>, var viewModel: HomeViewModel)
    : RecyclerView.Adapter<PersonAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var binding:CardDesignBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding: CardDesignBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.card_design,parent,false)
        return  CardDesignHolder(binding)
    }
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = personList.get(position)
        val b = holder.binding
        b.person = person

        b.cardViewPerson.setOnClickListener{
            val transition = HomeFragmentDirections.toDetail(person)
            Navigation.go(it,transition)
        }

        b.imageViewDelete.setOnClickListener{
            Snackbar.make(it,"Do you want to delete ${person.name} ?", Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    viewModel.delete(person.id)
                }.show()
        }

    }



    override fun getItemCount(): Int {
        return personList.size
    }




}