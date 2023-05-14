package com.example.contacts.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contacts.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveViewModel  @Inject constructor  (var prepo: PersonRepository): ViewModel() {
    fun save(name: String,phone:String){
        CoroutineScope(Dispatchers.Main).launch {
            prepo.save(name, phone)
        }
    }
}