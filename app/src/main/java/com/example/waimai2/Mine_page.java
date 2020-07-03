package com.example.waimai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.waimai2.BmobSql.Customer;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;

public class Mine_page extends AppCompatActivity {
private TextView ad;
private TextView username;
private ImageButton setting;
private Button recharge;
private TextView balance;
private ImageButton card_bag;
private ImageButton message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine);

        //在此处用数据库传出账户余额


        //在此处用数据库传出账户余额

        Intent intent=getIntent();
        balance=findViewById(R.id.balance);
       ad=findViewById(R.id.address);
     username=findViewById(R.id.name);

        String str1= intent.getStringExtra("naddress");
        String num=intent.getStringExtra("balance");
        final String name=intent.getStringExtra("username");
        final String nuname=intent.getStringExtra("username new");
        if(name==null&&nuname==null)
        {

            username.setText("张三");
        }
        else if(nuname!=null){
            username.setText(nuname);
            //在此处用数据库传出用户名
        }else if(name!=null){
            username.setText(name);
        }

//在此处用数据库传出用户名
       if(str1==null)
        {
            ad.setText("松江商城");
        }
        else if(str1!=null){
            ad.setText(intent.getStringExtra("naddress"));
            //在此处用数据库传出地址（详细地址）
        }
        BmobQuery<Customer>cus=new BmobQuery<Customer>();
        cus.addWhereEqualTo("Cname",name);
        cus.findObjects(new FindListener<Customer>() {
            @Override
            public void done(List<Customer> list, BmobException e) {

                balance.setText(String.valueOf(list.get(0).getCbalance()));
            }
        });
        /*if(num==null)
        {
            balance.setText("0");
        }
        else if(num!=null){
            balance.setText(num);
            //在此处用数据库传出余额
        }*/


        ad.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Mine_page.this, Modify_Address.class);
                startActivityForResult(intent, 1);
                //intent.putExtra("username", name);

            }
        });

        setting=findViewById(R.id.ib_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(Mine_page.this,Setting_page.class);
                startActivityForResult(intent, 1);
                Mine_page.this.finish();
            }
        });
        recharge=findViewById(R.id.Recharge);
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(Mine_page.this,Recharge_page.class);
                intent.putExtra("username",name);
                intent.putExtra("balance",balance.getText());
                startActivityForResult(intent, 1);
                Mine_page.this.finish();
            }
        });
        card_bag=findViewById(R.id.card_bag);
        message=findViewById(R.id.message);
        card_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(Mine_page.this,CardBag_page.class);
                startActivityForResult(intent, 1);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(Mine_page.this,Message_page.class);
                startActivityForResult(intent, 1);
            }
        });
    }
}
