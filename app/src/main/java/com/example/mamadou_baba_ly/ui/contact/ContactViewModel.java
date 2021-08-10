package com.example.mamadou_baba_ly.ui.contact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContactViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Adresse (Bureau): 38, rue Guynemer\nCode postal: 7500\nVille: Paris France\nTél: 01 45 49 04 59\nFax: 01 45 44 87 47\nEmail! contact@fun_app.fr");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
