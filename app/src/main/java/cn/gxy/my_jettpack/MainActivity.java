package cn.gxy.my_jettpack;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {


    private MutableLiveData mutableLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定感知生命周期 对象
        getLifecycle().addObserver(new MyLifecycle(getApplicationContext()));

        //获取仓库 对象
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        mutableLiveData = myViewModel.getMutableLiveData();
        //监听数据变化
        mutableLiveData.observe(this, new Observer<HomeBean>() {
            @Override
            public void onChanged(HomeBean bean) {
                //当仓库数据发生变化 回调这个方法
                Log.e("zdh", "-----------" + bean.getAge());

            }
        });


    }


    /**
     * 加载数据 到仓库
     *
     * @param view
     */
    public void load(View view) {
        mutableLiveData.postValue(new HomeBean(18));
    }

    /**
     * 获取仓库数据
     *
     * @param view
     */
    public void getData(View view) {
        HomeBean bean = (HomeBean) mutableLiveData.getValue();
        Toast.makeText(this, "" + bean.getAge(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,TextActivity.class));

    }
}
