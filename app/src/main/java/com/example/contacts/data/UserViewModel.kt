package com.example.contacts.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = AppDatabase.getDatabase(application).UserDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }
    fun addUser(user: User)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.addUser(user)
        }
    }

}