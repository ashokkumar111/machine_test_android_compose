package com.example.democomposeapp.repository
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.democomposeapp.api.PhotoApi
import com.example.democomposeapp.models.TestModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TestRepositry  @Inject constructor(private val photoApi: PhotoApi, @ApplicationContext val appContext: Context) {
    val _liveData :MutableLiveData<List<TestModel>> =MutableLiveData<List<TestModel>>()
    val testLiveData :LiveData<List<TestModel>> get() = _liveData

    suspend fun getTestData(){
        val response = photoApi.testResponse()
        if (response.isSuccessful && response.body()!=null){
            _liveData.postValue(response.body())
        }
    }
}