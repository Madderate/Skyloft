package com.madderate.skyloft.ViewModels.Main;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Task.GetMainPageInfoTask;

public class MainViewModel extends ViewModel {

    public GetMainPageInfoTask mainPageInfoTask = new GetMainPageInfoTask();

    public void getMainPageInfo(){
        mainPageInfoTask.execute();
    }


}
