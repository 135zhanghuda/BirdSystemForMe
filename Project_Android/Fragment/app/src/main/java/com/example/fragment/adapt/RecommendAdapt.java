package com.example.fragment.adapt;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.BirdInformation;
import com.example.fragment.R;

import java.util.ArrayList;
import java.util.List;

public class RecommendAdapt extends RecyclerView.Adapter<RecommendAdapt.RecyclerHolder> {
    private List<String> datas=new ArrayList<>();
    FragmentTransaction transaction;
    //private LayoutInflater inflater;
    private Context mContext;
    public RecommendAdapt(RecyclerView recyclerView, FragmentTransaction transaction){
        this.mContext = recyclerView.getContext();
        this.transaction=transaction;
        //inflater=LayoutInflater.from(context);
        datas.add("aaaaaaa");
        datas.add("bbbbbbb");
        datas.add("ccccccc");
        datas.add("ddddddd");
        datas.add("eeeeeee");
        datas.add("aaaaaaa");
        datas.add("bbbbbbb");
        datas.add("ccccccc");
        datas.add("ddddddd");
        datas.add("eeeeeee");
        datas.add("aaaaaaa");
        datas.add("bbbbbbb");
        datas.add("ccccccc");
        datas.add("ddddddd");
        datas.add("eeeeeee");
        datas.add("aaaaaaa");
        datas.add("bbbbbbb");
        datas.add("ccccccc");
        datas.add("ddddddd");
        datas.add("eeeeeee");
    }
    //创建每一行的View 用RecyclerView.ViewHolder包装
    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recommend, parent, false);
        return new RecyclerHolder(view);
    }
    //给每一行View填充数据
    @Override
    public void onBindViewHolder(final RecyclerHolder holder, final int position) {
        holder.textView.setText(datas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.addfragment,new BirdInformation()).commit();


                Toast.makeText(mContext, position+"我被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //数据源的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    class RecyclerHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        private RecyclerHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recommend_textview);
            imageView=(ImageView)itemView.findViewById(R.id.recommend_image);
        }
    }
}
