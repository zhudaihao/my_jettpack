package cn.gxy.my_jettpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    //定义个方法获取liveData子类的方法

    private  MutableLiveData<HomeBean> liveData;


    public MutableLiveData getMutableLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
        }
        return liveData;
    }


}
