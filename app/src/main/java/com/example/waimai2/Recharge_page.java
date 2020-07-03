package com.example.waimai2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.waimai2.BmobSql.Customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class Recharge_page extends AppCompatActivity {
    private ImageButton back;
    private Button recharge;
    private EditText recharge_number;
    private int num;
    private TextView balance;
private TextView username;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.recharge);
        balance=findViewById(R.id.balance);
        recharge =findViewById(R.id.recharge);
        username=findViewById(R.id.username);

        recharge_number=findViewById(R.id.recharge_number);
        //在此处用数据库传出账户余额
        Intent in=this.getIntent();
        username.setText(in.getStringExtra("username"));
        balance.setText(in.getStringExtra("balance"));
        //

        back = (ImageButton) findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Recharge_page.this.finish();

            }
        });
       recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pattern p= Pattern.compile("[0-9]*");
                Matcher m=p.matcher(recharge_number.getText().toString().trim());
                if (m.matches()) {
                    num = Integer.parseInt(recharge_number.getText().toString().trim());

                    if (recharge_number.getText().toString().trim()=="") {
                        Toast.makeText(Recharge_page.this, "充值失败,金额不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (num < 1 | num > 10000) {
                        Toast.makeText(Recharge_page.this, "充值失败,金额不能小于1或大于10000", Toast.LENGTH_SHORT).show();
                    } else {
                        //在此处向数据库中账户余额一栏加上充值的金额num
                        Toast.makeText(Recharge_page.this, "充值成功", Toast.LENGTH_SHORT).show();
                        //BmobQuery<Customer> cus=new BmobQuery<Customer>();
                        Customer c=new Customer();
                        c.setCbalance(Integer.valueOf(balance.getText().toString())+Integer.valueOf(recharge_number.getText().toString()));
                        c.update("kcIpSSSd", new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                Intent intent = new Intent(Recharge_page.this, Mine_page.class);

                                startActivity(intent);
                                Recharge_page.this.finish();
                            }
                        });

                        //String balance=recharge_number.getText().toString().trim();


                    }
                }
                else {
                    Toast.makeText(Recharge_page.this, "充值失败,请输入数字", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}