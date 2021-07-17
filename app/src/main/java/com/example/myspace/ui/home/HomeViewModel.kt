package com.example.myspace.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myspace.Utility
import com.example.myspace.data.entity.Rate
import com.example.myspace.database.MyDatabase
import com.example.myspace.repository.SpaceNewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val utility: Utility,
    context: Context
) : ViewModel() {

    private val currencyRepository =
        SpaceNewsRepository(MyDatabase.getDatabase(context.applicationContext))
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _rates = MutableLiveData<List<Rate>>()
    val rates: LiveData<List<Rate>> = _rates

    private val _errorBus = MutableLiveData<String>()
    val errorBus: LiveData<String> = _errorBus

    fun loadAllSpaceNews() {
        _isLoading.value = true
        ioScope.launch {
            try {
                val spaceNewsList = currencyRepository.loadAllNews()
                _rates.postValue(spaceNewsList)
                _isLoading.postValue(false)
            } catch (e: Exception) {
                e.message
            }
        }
    }
}