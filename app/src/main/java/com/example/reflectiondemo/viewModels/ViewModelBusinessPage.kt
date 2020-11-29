package com.netree.marketing.viewModels

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.reflectiondemo.model.BaseObjectResponse

class ViewModelBusinessPage(@NonNull application: Application) : AndroidViewModel(application) {

    var listLiveData: MutableLiveData<List<BaseObjectResponse>>

    init {
        listLiveData = MutableLiveData()
    }


}