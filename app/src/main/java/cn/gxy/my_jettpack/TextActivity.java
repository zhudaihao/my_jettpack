package cn.gxy.my_jettpack;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

public class TextActivity extends AppCompatActivity {

    private MyViewModel myViewModel;
    private MutableLiveData mutableLiveData;
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        tv = findViewById(R.id.tv);

        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        mutableLiveData = myViewModel.getMutableLiveData();
        HomeBean homeBean = (HomeBean) mutableLiveData.getValue();


        if (homeBean != null)
            tv.setText("年龄：" + homeBean.getAge());


    }

    /**
     * 修改仓库数据
     *
     * @param view
     */
    public void load(View view) {
        mutableLiveData.setValue(new HomeBean(99));

    }


}
