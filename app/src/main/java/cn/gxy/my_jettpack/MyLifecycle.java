package cn.gxy.my_jettpack;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 观察感知生命周期的类
 */
public class MyLifecycle implements LifecycleObserver {

    private Context context;

    public MyLifecycle(Context context) {
        this.context = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void create(){
        Log.e("'zdh'","-------------创建");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void start(){


        Log.e("'zdh'","-------------开始");
    }
}
