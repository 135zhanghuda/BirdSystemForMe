package com.example.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.adapt.RecommendAdapt;


public class SortRecyclerview extends Fragment {
    View rootView;
    public RecyclerView recyclerView ;
    public SortRecyclerview() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_recommend, container, false);
        recyclerView= (RecyclerView) rootView.findViewById(R.id.recycler_view);
        //创建线性布局
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(linerLayoutManager);
        //给RecyclerView设置布局管理器
        //recyclerView.setLayoutManager(mLayoutManager);
        //创建适配器，并且设置
        FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
        RecommendAdapt mAdapter = new RecommendAdapt(recyclerView,transaction);
        recyclerView.setAdapter(mAdapter);
        return rootView;
    }

}
