package com.example.waimai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Chose_city_page extends AppCompatActivity {
    private ImageButton back;
    private Button sh;
    private Button bj;
    private Button nj;
    private Button sz;
    private Button hz;
    private Button gz;
    private Button wx;
    private Button hf;
    private Button shenzhen;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.chose_city);
        back = (ImageButton) findViewById(R.id.btn_back);
        sh=findViewById(R.id.sh);
        bj=findViewById(R.id.bj);
        nj=findViewById(R.id.nj);
        sz=findViewById(R.id.sz);
        hz=findViewById(R.id.hz);
        gz=findViewById(R.id.gz);
        wx=findViewById(R.id.wx);
        hf=findViewById(R.id.hf);
        shenzhen=findViewById(R.id.shenzhen);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Chose_city_page.this.finish();

            }
        });
       sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chose_city_page.this, Modify_Address.class);

                String city = sh.getText().toString().trim();

                    intent.putExtra("ncity", city);

                startActivity(intent);
                Chose_city_page.this.finish();
            }
        });
        bj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chose_city_page.this, Modify_Address.class);

                String city = bj.getText().toString().trim();

                intent.putExtra("ncity", city);

                startActivity(intent);
                Chose_city_page.this.finish();
            }
        });
        nj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chose_city_page.this, Modify_Address.class);

                String city = nj.getText().toString().trim();

                intent.putExtra("ncity", city);

                startActivity(intent);
                Chose_city_page.this.finish();
            }
        });
        sz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chose_city_page.this, Modify_Address.class);

                String city = sz.getText().toString().trim();

                intent.putExtra("ncity", city);

                startActivity(intent);
                Chose_city_page.this.finish();
            }
        });
        gz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chose_city_page.this, Modify_Address.class);

                String city = gz.getText().toString().trim();

                intent.putExtra("ncity", city);

                startActivity(intent);
                Chose_city_page.this.finish();
            }
        });
        hf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chose_city_page.this, Modify_Address.class);

                String city = hf.getText().toString().trim();

                intent.putExtra("ncity", city);

                startActivity(intent);
                Chose_city_page.this.finish();
            }
        });
        wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chose_city_page.this, Modify_Address.class);

                String city = wx.getText().toString().trim();

                intent.putExtra("ncity", city);

                startActivity(intent);
                Chose_city_page.this.finish();
            }
        });
        hz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chose_city_page.this, Modify_Address.class);

                String city = hz.getText().toString().trim();

                intent.putExtra("ncity", city);

                startActivity(intent);
                Chose_city_page.this.finish();
            }
        });
        shenzhen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chose_city_page.this, Modify_Address.class);

                String city = shenzhen.getText().toString().trim();

                intent.putExtra("ncity", city);

                startActivity(intent);
                Chose_city_page.this.finish();
            }
        });
    }
}