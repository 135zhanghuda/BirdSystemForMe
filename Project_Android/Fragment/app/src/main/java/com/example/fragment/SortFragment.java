package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SortFragment extends Fragment {
    View sortView;
    Spinner habitatSpinner,lifestyleSpinner,residenceSpinner;
    ArrayAdapter<String> habitatAdapter,lifestyleAdapter,residenceAdapter;
    TextView getHabitat,getLifestyle,getResidence;
    Button sortInquireButton;
    //三个获取当前分类textview
    List<String> habitatSpringList=new ArrayList<>();
    List<String> lifestyleSpringList=new ArrayList<>();
    List<String> residenceSpringList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sortView=inflater.inflate(R.layout.fragment_sort, container, false);
        habitatSpinner=sortView.findViewById(R.id.spinner_habitat);
        lifestyleSpinner=sortView.findViewById(R.id.spinner_lifestyle);
        residenceSpinner=sortView.findViewById(R.id.spinner_residence);
        getHabitat=sortView.findViewById(R.id.get_habitat);
        getLifestyle=sortView.findViewById(R.id.get_lifestyle);
        getResidence=sortView.findViewById(R.id.get_residence);
        sortInquireButton=sortView.findViewById(R.id.button_inquire);
        //给栖息地下拉框添加加元素,设置样式
        initHabitatSpinner();
        //给生活习性下拉框添加加元素,设置样式
        initLifestyleSpinner();
        //给留居类型下拉框添加加元素,设置样式
        initResidenceSpinner();
        //栖息地下拉框点击事件
        habitatOnclick();
        //生活习性下拉框点击事件
        lifestyleOnclick();
        //留居类型下拉框点击事件
        residenceOnclick();
        //分类查询按钮点击事件
        sortInquireOnclick();




        return sortView;

    }



    //分类查询点击事件
    public void sortInquireOnclick(){
        sortInquireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.addfragment,new SortRecyclerview())
                        .commit();
            }
        });
    }


//湿地鸟类、林灌鸟类、山地鸟类、城镇鸟类、农田草地鸟类、高原荒漠鸟类
    public void initHabitatSpinner(){
        habitatSpringList.add("湿地鸟类");
        habitatSpringList.add("林灌鸟类");
        habitatSpringList.add("山地鸟类");
        habitatSpringList.add("城镇鸟类");
        habitatSpringList.add("农田草地鸟类");
        habitatSpringList.add("高原荒漠鸟类");
        habitatSpringList.add("其他类型鸟类");
        habitatSpringList.add("所有类型鸟类");
        //设置字体尺寸
       habitatAdapter=new ArrayAdapter<String>(getActivity(), R.layout.item_isfly,R.id.test,habitatSpringList );
       habitatSpinner.setAdapter(habitatAdapter);
    }

    public void initLifestyleSpinner(){
        lifestyleSpringList.add("游禽");
        lifestyleSpringList.add("涉禽");
        lifestyleSpringList.add("陆禽");
        lifestyleSpringList.add("猛禽");
        lifestyleSpringList.add("攀禽");
        lifestyleSpringList.add("鸣禽");
        lifestyleSpringList.add("其他类型");
        lifestyleSpringList.add("所有类型");
        lifestyleAdapter=new ArrayAdapter<String>(getActivity(), R.layout.item_lifestyle,R.id.test1,lifestyleSpringList );
        lifestyleSpinner.setAdapter(lifestyleAdapter);
    }

    public  void initResidenceSpinner(){
        residenceSpringList.add("留鸟");
        residenceSpringList.add("漂鸟");
        residenceSpringList.add("候鸟");
        residenceSpringList.add("迷鸟");
        residenceSpringList.add("其他类型");
        residenceSpringList.add("所有类型");
        residenceAdapter=new ArrayAdapter<String>(getActivity(), R.layout.item_isfly,R.id.test,residenceSpringList );
        residenceSpinner.setAdapter(residenceAdapter);
    }

    public void habitatOnclick(){
        habitatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getHabitat.setText((String)habitatSpinner.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void lifestyleOnclick(){
        lifestyleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getLifestyle.setText((String)lifestyleSpinner.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void residenceOnclick(){
        residenceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getResidence.setText((String)residenceSpinner.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


}
