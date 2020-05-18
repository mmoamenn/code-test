package com.interview.codetest.presenter.sections

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.codetest.data.repository.SectionRepository
import com.interview.codetest.data.response.Data
import com.interview.codetest.data.response.DataStatus
import com.interview.codetest.data.response.PageResponse
import com.interview.codetest.domain.model.Page
import kotlinx.coroutines.launch
import java.lang.Exception

class SectionViewModel(private val repository: SectionRepository) : ViewModel() {

    private val sectionResponse: MutableLiveData<Data<Page>> = MutableLiveData()

    val sectionLiveData: LiveData<Data<Page>> = sectionResponse

    fun getSections() {
        viewModelScope.launch {
            try {
                sectionResponse.postValue(Data(DataStatus.LOADING))
                val itemsCached = repository.getCachedSections()
                sectionResponse.postValue(Data(DataStatus.SUCCESS, data = itemsCached))
                val items = repository.getSections()
                sectionResponse.postValue(Data(DataStatus.SUCCESS, data = items))
            } catch (exception: Exception) {
                sectionResponse.postValue(Data(DataStatus.ERROR, error = exception))
            }
        }
    }

    fun getSection(sectionURL: String) {
        viewModelScope.launch {
            try {
                sectionResponse.postValue(Data(DataStatus.LOADING))
                val itemsCached = repository.getCachedSection(sectionURL)
                sectionResponse.postValue(Data(DataStatus.SUCCESS, data = itemsCached))
                val items = repository.getSection(sectionURL)
                sectionResponse.postValue(Data(DataStatus.SUCCESS, data = items))
            } catch (exception: Exception) {
                sectionResponse.postValue(Data(DataStatus.ERROR, error = exception))
            }
        }
    }

}