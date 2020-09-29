package com.knittertest.ui.main

import androidx.lifecycle.ViewModel
import com.knittertest.data.repository.UsersRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(val usersRepository: UsersRepository) : ViewModel() {

    val userList by lazy {
        usersRepository.observePagedUsers()
    }

}