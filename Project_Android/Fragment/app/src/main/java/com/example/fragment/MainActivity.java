package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    RadioGroup radioGroup;
    RadioButton recommendButton,classfficationButton,myMenuButton;
    //Fragment changeFragment;
    RecommendFragment recommendFragment;
    SortFragment sortFragment;
    MyMenuFragment myMenuFragment;
    //装要显示的所有fragment的列表
    private List<Fragment> fragmentList=new ArrayList<>();
    //fragment索引位置 : 0为推荐、1为分类、2为我的（我的主页）
    private int position=0;
    //当前fragment
    private Fragment currentFragment=new Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //changeFragment=(Fragment)findViewById(R.id.top_fragment) ;
        //fragment初始化
        initFragment();

        //控件初始化
        radioGroup=(RadioGroup)findViewById(R.id.radio_group);
        recommendButton=(RadioButton)findViewById(R.id.button_recommend);
        classfficationButton=(RadioButton)findViewById(R.id.button_classiffication);
        myMenuButton=(RadioButton)findViewById(R.id.button_mymenu);
        //radiobutton的点击事件，给position赋值
        radioButtonChange();
        //加载fragment
        //showFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //初始化界面（主fragment）
        transaction.add(R.id.addfragment, fragmentList.get(position), "" + position);//第三个参数给添加的fragment增加一个标识
        transaction.commit();
       /* getSupportFragmentManager()
                .beginTransaction()
                .remove(currentFragment)
                .add(R.id.addfragment,new RecommendFragment())
                //.addToBackStack(null)
                .commit();*/

       // System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

    }

    /*
    * 初始化frament并将fragment放入lsit
    */
    public void initFragment(){
        recommendFragment=new RecommendFragment();
        sortFragment=new SortFragment();
        myMenuFragment=new MyMenuFragment();
        fragmentList.add(recommendFragment);
        fragmentList.add(sortFragment);
        fragmentList.add(myMenuFragment);
        currentFragment=recommendFragment;
    }

    /*
    通过FragmentTransaction加载fragment
     */

    public  void showFragment() {
        //获取FragmentTransaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            //如果需要展示的这个Fragment没有被添加过，那么隐藏当前Fragmnet并且添加这个Fragment
            transaction.replace(R.id.addfragment, fragmentList.get(position), "" + position);//第三个参数给添加的fragment增加一个标识

        //把这个Fragment设置为当前Fragment
        currentFragment = fragmentList.get(position);
        //提交
        transaction.commit();
    }

    /*
    radioButton点击事件
     */
    public void radioButtonChange(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==recommendButton.getId()){
                    //Toast.makeText(MainActivity.this,"b1选中", Toast.LENGTH_LONG).show();
                    position=0;
                }
                if(checkedId==classfficationButton.getId()){
                    //Toast.makeText(MainActivity.this,"b2选中", Toast.LENGTH_LONG).show();
                    position=1;
                }
                if(checkedId==myMenuButton.getId()){
                    position=2;
                    //Toast.makeText(main.this,"b3选中", Toast.LENGTH_LONG).show();
                }
                showFragment();
            }
        });
    }





}
