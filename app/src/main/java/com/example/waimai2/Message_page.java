package com.example.waimai2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Message_page extends AppCompatActivity {
    private ImageButton back;
    private LinearLayout message1;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.message);
        back = (ImageButton) findViewById(R.id.btn_back);
        message1=findViewById(R.id.message1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Message_page.this.finish();

            }
        });
        message1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到商家页面
                Intent intent =new Intent();

                intent.setClass(Message_page.this,CardBag_page.class);
                startActivityForResult(intent, 1);

            }
        });
    }
}


