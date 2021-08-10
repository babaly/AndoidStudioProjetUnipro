package com.example.mamadou_baba_ly.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Passionné des TIC, je suis un étudiant en Bachelor Degree à Univers Professionel. \nToujours déterminé à changer la vision et le système Africain, je souhaite mettre en pratique mes compètences et connaissances au service de la nation pour un Afrique gagnant.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}