package com.knittertest.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.knittertest.data.local.dao.UserDao
import com.knittertest.data.remote.ApiService
import com.knittertest.data.repository.UserDataSource
import com.knittertest.model.UserEntity
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class UserDataSourceFactory @Inject constructor(
    private val userDao: UserDao,
    private val scope: CoroutineScope,
    private val apiService: ApiService
) : DataSource.Factory<Int, UserEntity>() {

    private val liveData = MutableLiveData<UserDataSource>()

    override fun create(): DataSource<Int, UserEntity> {
        val source = UserDataSource(
            apiService,
            userDao,
            scope
        )
        liveData.postValue(source)
        return source
    }

    companion object {
        private const val PAGE_SIZE = 5

        fun pagedListConfig() = PagedList.Config.Builder()
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()
    }
}