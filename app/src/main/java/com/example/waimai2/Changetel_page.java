package com.example.waimai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.waimai2.BmobSql.Customer;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class Changetel_page extends AppCompatActivity {
    private ImageButton back;
    private Button modifytel;
    private EditText newtel;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.change_tel);
        back = (ImageButton) findViewById(R.id.btn_back);
        modifytel=findViewById(R.id.btn_modifytel);
        newtel=findViewById(R.id.newtel);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Changetel_page.this.finish();

            }
        });
        modifytel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在此处修改数据库中电话号
                String str1=newtel.getText().toString().trim();
                //用str1修改数据库中电话号
                Customer customer=new Customer();
                customer.setCtel(str1);
                customer.update("kcIpSSSd", new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Toast.makeText(Changetel_page.this,"电话号码已修改",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Changetel_page.this.finish();


            }
        });
    }
}