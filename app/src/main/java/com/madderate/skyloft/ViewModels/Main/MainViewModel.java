package com.madderate.skyloft.ViewModels.Main;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Task.GetMainPageInfoTask;
import com.madderate.skyloft.Utils.InterfaceManager;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private GetMainPageInfoTask mainPageInfoTask = new GetMainPageInfoTask();


}
