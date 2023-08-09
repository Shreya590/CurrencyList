package com.example.mvvmchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmchallenge.model.RandomCurrencyResponse
import com.example.mvvmchallenge.network.CurrencyRepository
import com.example.mvvmchallenge.utils.UIState
import kotlinx.coroutines.launch

class CurrencyViewModel (private val repository: CurrencyRepository) : ViewModel(){
    //LiveData
    private val _currencyLiveData = MutableLiveData<RandomCurrencyResponse>()
    val currencyLiveData : LiveData<RandomCurrencyResponse>
        get() = _currencyLiveData

    private val _uiState = MutableLiveData<UIState>()
    val uiState : LiveData<UIState>
        get() = _uiState

    fun getRandomCurrency(q : String){
        _uiState.postValue(UIState.LOADING)
        viewModelScope.launch {
            val response = repository.getRandomCurrency(q)
            if(response.isSuccessful){
                _currencyLiveData.postValue(response.body())
                _uiState.postValue(UIState.SUCCESS)
            }else{
                _uiState.postValue(UIState.ERROR)
            }
        }
    }
    fun selectedCurrency(){
        _uiState.postValue(UIState.SELECTED)
    }
}