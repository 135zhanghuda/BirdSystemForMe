package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.example.myapplication.class_object.*;
import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {
    public Button loginButton;
    public EditText userName;
    public EditText passWord;
    public Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton=(Button) findViewById(R.id.loginbutton);
        userName=(EditText) findViewById(R.id.username);
        passWord=(EditText) findViewById(R.id.password);
        registerButton=(Button)findViewById(R.id.registerbutton);

        //登录点击事件
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "yes",Toast.LENGTH_SHORT).show();
                //将账号密码上传
                //登录成功
                Handler handler=new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        if(msg.obj.equals("success")){
                            Intent intent = new Intent(MainActivity.this,HomePage.class);
                            startActivity(intent);
                        }//登录失败（为输入账号密码）
                        else if (userName.getText().toString().equals("") || passWord.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "请输入账号名密码", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "请确保您的输入账号密码正确", Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                final HttpLogin httpLogin = new HttpLogin(userName.getText().toString(), passWord.getText().toString(),handler);
                Toast.makeText(MainActivity.this, "请输入账号名密码", Toast.LENGTH_SHORT);
                httpLogin.isLoginSuccess();
     /*           new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            if(httpLogin.isLoginSuccess()==false){
                                Toast.makeText(MainActivity.this, "未连接上服务器", Toast.LENGTH_SHORT);
                            }


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                });*/

            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activity_register.class);
                startActivity(intent);
            }
        });

    }


}
