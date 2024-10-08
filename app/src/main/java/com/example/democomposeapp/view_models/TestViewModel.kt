package com.example.democomposeapp.view_models
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democomposeapp.models.TestModel
import com.example.democomposeapp.repository.TestRepositry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TestViewModel @Inject constructor(private val testRepository: TestRepositry) :ViewModel(){
    val testLiveData11:LiveData<List<TestModel>> get() = testRepository.testLiveData

    fun getTestListData(){
        viewModelScope.launch {
            testRepository.getTestData()
        }
    }
}