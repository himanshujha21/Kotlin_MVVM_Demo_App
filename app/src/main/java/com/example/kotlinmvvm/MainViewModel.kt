package com.example.kotlinmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.model.MovieResItem
import com.example.kotlinmvvm.repository.MainRepository
import kotlinx.coroutines.*

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val errorMsg = MutableLiveData<String>()
    val mList = MutableLiveData<List<MovieResItem>>()

    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    val loading = MutableLiveData<Boolean>()

    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            loading.postValue(true)
            val response = mainRepository.getAllMovies()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    mList.postValue(response.body())
                    loading.value = false

                } else {
                    onError("Error:${response.message()}")
                }


            }


        }

    }


    private fun onError(message: String) {
        errorMsg.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}

