package com.example.waimai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Help_page extends AppCompatActivity {
    private ImageButton back;
    private Button btn_introduce;
    private Button btn_how_to_use;
    private Button btn_forgetpsw;
    private Button btn_about_us;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.help);
        btn_introduce =findViewById(R.id.btn_introduce);
        btn_how_to_use =findViewById(R.id.btn_how_to_use);
        btn_forgetpsw =findViewById(R.id.btn_forgetpsw);
        btn_about_us =findViewById(R.id.btn_about_us);
        back = (ImageButton) findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Help_page.this.finish();

            }
        });
        btn_introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到产品介绍页面
                Intent intent=new Intent(Help_page.this,Help_Introduce_page.class);
                startActivityForResult(intent, 1);
            }
        });
        btn_how_to_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到如何使用页面
                Intent intent=new Intent(Help_page.this,Help_How_To_Use_page.class);
                startActivityForResult(intent, 1);
            }
        });
        btn_forgetpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到找回密码页面
                Intent intent=new Intent(Help_page.this,Help_Forgetpsw_Page.class);
                startActivityForResult(intent, 1);
            }
        });
        btn_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到关于我们页面
                Intent intent=new Intent(Help_page.this,Help_About_Us.class);
                startActivityForResult(intent, 1);
            }
        });
    }
}
