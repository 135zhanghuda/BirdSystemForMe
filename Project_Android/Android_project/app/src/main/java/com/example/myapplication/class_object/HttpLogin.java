package com.example.myapplication.class_object;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.example.myapplication.*;
import com.example.myapplication.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.logging.LogRecord;



/*
* 还存在以下问题待解决
* 连接不上服务器的Toast显示
*
* */




public class HttpLogin {
    private String userName;
    private String passWord;
    public  boolean rt=true;
    public Handler handler;
    String getBuffer="";
    String path="http://192.168.124.12:8081/WebProject/Login";
    public HttpLogin(String username,String password,Handler handler){
        userName=username;
        passWord=password;
        this.handler=handler;
    }
  /*  Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.obj.equals("success")){
                //Intent intent = new Intent(activity,HomePage.class);
                rt=true;
                System.out.println("bbbbbbbbbbbbbb");
                //startActivity(intent);
            }
        }
    };*/
    //            URL url=new URL(path + "?uname=" + userName + "&upass=" + passWord);
    public boolean isLoginSuccess(){
        /*if (!checkNetwork()) {
            //Toast.makeText(, "yes",Toast.LENGTH_SHORT).show();
        }else{
        }*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url=new URL(path + "?name=" + userName + "&password=" + passWord);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    //得到connection对象。
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    //设置超时
                    connection.setConnectTimeout(6*1000);
                    //设置请求方式
                    connection.setRequestMethod("GET");
                    //连接
                    connection.connect();
                   // Toast.makeText(activity.getApplicationContext(), "yes",Toast.LENGTH_SHORT).show();
                   // System.out.println("println输入日志信息");
                    if(connection.getResponseCode()==200){
                        //与Eclipse进行数据交互
                        InputStream is=connection.getInputStream();
                        BufferedReader br=new BufferedReader(new InputStreamReader(is));
                        //从Eclipse进行数据交互的值
                        int s=0;
                       // String getBuffer="";
                        while((s=br.read())!=-1)
                        {
                            getBuffer=getBuffer+(char)s;
                        //Toast.makeText(activity.getApplicationContext(),"s"+s,Toast.LENGTH_SHORT).show();
                        //System.out.println((char)s);
                        }
                        Message message = new Message();
                        message.obj=getBuffer;
                        handler.sendMessage(message);

                        //System.out.println(getBuffer);
                        is.close();
                        br.close();
                    }


                } catch (MalformedURLException e) {

                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }).start();

           // System.out.println(getBuffer+"aaaaaaaaaaaaa");
      /* try {
            Thread.sleep(8000);
                 System.out.println("aaaaaaaaaaaaa");
             //System.out.println("aaaaaaaaaaaaaaaaaa");
        } catch (InterruptedException e) {
           e.printStackTrace();
       }*/
        //System.out.println("aaaaaaaaaaaaa");
       return rt;
    }

  /*  private boolean checkNetwork() {
        ConnectivityManager connManager = (ConnectivityManager) (Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }*/
}
