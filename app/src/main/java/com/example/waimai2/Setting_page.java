package com.example.waimai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Setting_page extends AppCompatActivity {
    private LinearLayout change_name;
    private LinearLayout change_tel;
    private LinearLayout about_us;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.setting);
        change_name=findViewById(R.id.change_name);
        change_tel=findViewById(R.id.change_tel);
        about_us=findViewById(R.id.btn_about_us);
        back = (ImageButton) findViewById(R.id.btn_back);
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到关于我们页面
                Intent intent=new Intent(Setting_page.this,Help_About_Us.class);
                startActivityForResult(intent, 1);
            }
        });

        change_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到修改电话页面
                Intent intent=new Intent(Setting_page.this,Changetel_page.class);
                startActivityForResult(intent, 1);
            }
        });
       change_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到修改昵称页面
                Intent intent=new Intent(Setting_page.this,Changename_page.class);
                startActivityForResult(intent, 1);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Setting_page.this.finish();

            }
        });
    }

}
