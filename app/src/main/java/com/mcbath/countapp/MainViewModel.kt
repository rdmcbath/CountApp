package com.mcbath.countapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    /*create an integer variable to hold our counting values*/
    private var clickCount:Int = 0
    /*create live data object(countLiveData) to hold our integer values*/
    private var countLiveData = MutableLiveData<Int>()

   /* Method to get initial count value at the beginning of our app.
    This will return Live Data object with initial counting values.*/
    fun getInitialCount():MutableLiveData<Int>{
        countLiveData.value=clickCount
        return countLiveData
    }

    /*methods to update Live Data counting values*/

    fun getCurrentCount(){
        clickCount+=1
        countLiveData.value=clickCount
    }

    fun incrementCount(){
        clickCount = ++clickCount
        countLiveData.value=clickCount
    }

    fun decrementCount(){
        clickCount = --clickCount
        countLiveData.value=clickCount
    }

    fun resetCount(){
        clickCount = 0
        countLiveData.value=clickCount
    }
}