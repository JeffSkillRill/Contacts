package com.example.contacts.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.CustomRowBinding

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()
    inner class MyViewHolder(val binding: CustomRowBinding):RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val listitembinding = CustomRowBinding.inflate(inflater, parent, false)
        return MyViewHolder(listitembinding)
//        val binding = CustomRowBinding
//            .inflate(LayoutInflater.from(parent.context), parent, false)
//        return MyViewHolder(binding.root)
        //return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.binding.idTxt.text = currentItem.id.toString()
        holder.binding.firstNameTxt.text = currentItem.firstName
        holder.binding.lastNameTxt.text = currentItem.lastName
        holder.binding.phoneNumberTxt.text = currentItem.phone_number.toString()

//        holder.binding.id_txt.text = currentItem.id.toString()
//        holder.itemView.firstName_txt.text = currentItem.firstName
//        holder.itemView.lastName_txt.text = currentItem.lastName
//        holder.itemView.phoneNumber_txt.text = currentItem.phone_number.toString()
    }

    fun setData(user: List<User>)
    {
        this.userList = user
        notifyDataSetChanged()
    }

}