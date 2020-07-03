package com.example.waimai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.waimai2.BmobSql.Customer;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class Changename_page extends AppCompatActivity {
    private ImageButton back;
    private Button modifyname;
    private EditText newname;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.change_name);
        back = (ImageButton) findViewById(R.id.btn_back);
        modifyname=findViewById(R.id.btn_modifyname);

       newname=findViewById(R.id.newname);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Changename_page.this.finish();

            }
        });
        modifyname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //在此处修改数据库中用户名
                Intent intent = new Intent(Changename_page.this, Mine_page.class);
                String str1=newname.getText().toString().trim();
                Customer customer=new Customer();
                /*customer.setCname(str1);
                customer.update("kcIpSSSd", new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Toast.makeText(Changename_page.this,"昵称已修改",Toast.LENGTH_SHORT).show();
                        }

                    }
                });*/
                intent.putExtra("username new", str1);
                startActivity(intent);
                //用str1修改数据库中用户名
                Changename_page.this.finish();


            }
        });
    }
}
