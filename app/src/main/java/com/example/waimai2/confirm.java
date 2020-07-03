package com.example.waimai2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.waimai2.BmobSql.Customer;
import com.example.waimai2.BmobSql.Menu;
import com.example.waimai2.BmobSql.Orders;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.UpdateListener;

public class confirm extends AppCompatActivity{
    private TextView tv_name,tv_address,tv_tel,tv_bname;
    private Context context;
    private List<Customer> list;
    private TextView tv_addr,tv_nam,tv_tele,tv_bnam,tv_alt,dcname1,dcname2,dcprice1,dcprice2,dcnum1,dcnum2;
    private ListView lv_conf;
    private Button btn_conf;
    private Tool tool;
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //显示界面
        setContentView(R.layout.confirm);
        tv_addr = (TextView)findViewById(R.id.tv_address);
        tv_bnam=(TextView)findViewById(R.id.tv_bname);
        tv_nam=(TextView)findViewById(R.id.tv_name);
        tv_tele=(TextView)findViewById(R.id.tv_tel);
        tv_alt=(TextView)findViewById(R.id.tv_alto);
        //lv_conf=(ListView)findViewById(R.id.lv_confirm);
        btn_conf=(Button)findViewById(R.id.btn_confirm);
        dcname1=(TextView)findViewById(R.id.dcname1);
        dcname2=(TextView)findViewById(R.id.dcname2);
        dcprice1=(TextView)findViewById(R.id.dcprice1);
        dcprice2=(TextView)findViewById(R.id.dcprice2);
        dcnum1=(TextView)findViewById(R.id.dcnum1);
        dcnum2=(TextView)findViewById(R.id.dcnum2);

        btn_conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobQuery<Customer> cus=new BmobQuery<Customer>();
                cus.addWhereEqualTo("Cno","1");
                cus.findObjects(new FindListener<Customer>() {
                    @Override
                    public void done(List<Customer> list, BmobException e) {

                        //Toast.makeText(confirm.this,"succeeded "+list.size()+"条数据",Toast.LENGTH_LONG).show();
                        if(list.get(0).getCbalance() >= Integer.valueOf(tv_alt.getText().toString())){
                            int i=list.get(0).getCbalance()- Integer.valueOf(tv_alt.getText().toString());
                            list.get(0).setCbalance(i);
                            list.get(0).update("kcIpSSSd", new UpdateListener() {
                                @Override
                                public void done(BmobException e) {
                                    if(e==null)
                                        Toast.makeText(confirm.this,"成功",Toast.LENGTH_SHORT).show();
                                }
                            });
                            Toast.makeText(confirm.this,"succeeded",Toast.LENGTH_SHORT).show();
                            confirm.this.finish();
                        }else{
                            Toast.makeText(confirm.this,"FAILED:余额不足！",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //Toast.makeText(confirm.this,"succeeded",Toast.LENGTH_SHORT).show();
            }
        });
        initData();
    }
    private void initData(){
        /*BmobQuery<Orders> query=new BmobQuery<Orders>();

        query.addQueryKeys("Caddress,Oalto,Dname,Odquan");
        //query.addWhereEqualTo("Dname","羊肉串");
        query.findObjects(new FindListener<Orders>() {
            @Override
            public void done(List<Orders> list, BmobException e) {
                if(e==null){
                    Toast.makeText(confirm.this,list.size()+" initDate succeeded",Toast.LENGTH_SHORT).show();
                    String strAddr=String.valueOf(list.get(0).getCaddress());
                    tv_addr.setText(strAddr);
                    //tv_alt.setText("总价：￥ "+String.valueOf(tool.getInt(0)));

                    lv_conf.setAdapter(new OrdAdapter(confirm.this,list));
                }
            }
        });*/
        //tv_alt.setText("总价：￥ "+String.valueOf(tool.getInt(0)));
        Intent i=this.getIntent();
        int t=i.getIntExtra("total",0);
        tv_alt.setText(String.valueOf(t));
        String str=i.getStringExtra("bname");
        if(str.equals("1"))
            tv_bnam.setText("顺子烧烤（松江店）");
        else if(str.equals("2"))
            tv_bnam.setText("小杨生煎");
        else if(str.equals("3"))
            tv_bnam.setText("永和大王");
        BmobQuery<Customer>cus=new BmobQuery<Customer>();
        cus.addWhereEqualTo("Cname","张三");
        cus.findObjects(new FindListener<Customer>() {
            @Override
            public void done(List<Customer> list, BmobException e) {
                tv_addr.setText(list.get(0).getCaddress());
                tv_nam.setText(list.get(0).getCname());
                tv_tele.setText(list.get(0).getCtel());
            }
        });
        if(Integer.valueOf(i.getStringExtra("num1").toString())>0 && Integer.valueOf(i.getStringExtra("num2").toString())<=0){
            dcname1.setText(i.getStringExtra("dcname1"));
            dcprice1.setText(i.getStringExtra("dcprice1"));
            dcnum1.setText(i.getStringExtra("num1"));
        }else if(Integer.valueOf(i.getStringExtra("num1").toString())>0 && Integer.valueOf(i.getStringExtra("num2").toString())>0){
            dcname1.setText(i.getStringExtra("dcname1"));
            dcprice1.setText(i.getStringExtra("dcprice1"));
            dcnum1.setText(i.getStringExtra("num1"));
            dcname2.setText(i.getStringExtra("dcname2"));
            dcprice2.setText(i.getStringExtra("dcprice2"));
            dcnum2.setText(i.getStringExtra("num2"));
        }else if(Integer.valueOf(i.getStringExtra("num1").toString())<=0 && Integer.valueOf(i.getStringExtra("num2").toString())>0){
            dcname1.setText(i.getStringExtra("dcname2"));
            dcprice1.setText(i.getStringExtra("dcprice2"));
            dcnum1.setText(i.getStringExtra("num2"));
        }

    }
}
