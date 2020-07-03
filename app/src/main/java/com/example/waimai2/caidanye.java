package com.example.waimai2;

import android.content.Context;
import android.content.Intent;
import android.net.http.SslCertificate;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waimai2.BmobSql.Menu;
import com.example.waimai2.BmobSql.Orders;


import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link caidanye#newInstance} factory method to
 * create an instance of this fragment.
 */
public class caidanye extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayout top_bar;
    private TextView add,add2,reduce,reduce2,dname,dname2,quan,quan2;
    private TextView price,price2,tprice;
    private TextView delete;
    private TextView tv_go_to_pay;
    private Tool tool;
    private ImageView pic1,pic2;

    //private List<User> goodsList;
    private List<Menu> list;
    //private UserDao userDao;
    private List<HashMap<String,String>> listmap=new ArrayList<>();
    private MyAdapter adapter;
    private TextView pay;
    private String str;


    public caidanye() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment caidanye.
     */
    // TODO: Rename and change types and number of parameters
    public static caidanye newInstance(String param1, String param2) {
        caidanye fragment = new caidanye();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_caidanye, container, false);


    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }
    private void initView() {
        //top_bar = (LinearLayout) getActivity().findViewById(R.id.top_bar);
        //listview = (ListView)getActivity().findViewById(R.id.listview);
        //all_chekbox = (CheckBox)getActivity().findViewById(R.id.all_chekbox);
        tprice = (TextView)getActivity().findViewById(R.id.tv_total_price);

        tv_go_to_pay = (TextView)getActivity().findViewById(R.id.tv_go_to_pay);
        price2=(TextView)getActivity().findViewById(R.id.tv_goods_price2);
        price=(TextView)getActivity().findViewById(R.id.tv_goods_price);
        add=(TextView)getActivity().findViewById(R.id.tv_add);
        add2=(TextView)getActivity().findViewById(R.id.tv_add2);
        reduce=(TextView)getActivity().findViewById(R.id.tv_reduce);
        reduce2=(TextView)getActivity().findViewById(R.id.tv_reduce2);
        dname=(TextView)getActivity().findViewById(R.id.tv_goods_name);
        dname2=(TextView)getActivity().findViewById(R.id.tv_goods_name2);
        quan=(TextView)getActivity().findViewById(R.id.tv_num);
        quan2=(TextView)getActivity().findViewById(R.id.tv_num2);
        pic1=(ImageView)getActivity().findViewById(R.id.iv_adapter_list_pic);
        pic2=(ImageView)getActivity().findViewById(R.id.iv_adapter_list_pic2);

        quan.setText("0");
        quan2.setText("0");
        initDate();
        if(str.equals("1")){
            pic1.setImageDrawable(getResources().getDrawable(R.drawable.yangrou));
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.jichi));
        }else if(str.equals("2")){
            pic1.setImageDrawable(getResources().getDrawable(R.drawable.shengjian));
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.tang));
        }else if(str.equals("3")){
            pic1.setImageDrawable(getResources().getDrawable(R.drawable.youtiao));
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.doujiang));
        }

        tv_go_to_pay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(Integer.valueOf(quan.getText().toString())==0 && Integer.valueOf(quan2.getText().toString())==0){
                    Toast.makeText(getActivity(), "你没有选择任何商品！", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i=new Intent(getActivity(), confirm.class);
                    //tool.setInt(0,8);//Integer.valueOf(tprice.getText().toString())
                    i.putExtra("total",Integer.valueOf(tprice.getText().toString()));
                    i.putExtra("dcname1",dname.getText().toString());
                    i.putExtra("dcname2",dname2.getText().toString());
                    i.putExtra("dcprice1",price.getText().toString());
                    i.putExtra("dcprice2",price2.getText().toString());
                    i.putExtra("num1",quan.getText().toString());
                    i.putExtra("num2",quan2.getText().toString());
                    i.putExtra("bname",str);
                    startActivity(i);
                }

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num;
                int pri=0;

                quan.setText(String.valueOf(Integer.valueOf(quan.getText().toString())+1));
                if(str.equals("1"))
                {pri=5;}
                else if(str.equals("2"))
                {pri=13;}
                else if(str.equals("3"))
                {pri=6;}

                num=Integer.valueOf(quan.getText().toString());

                tprice.setText(String.valueOf(Integer.valueOf(tprice.getText().toString())+pri));
            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quan2.setText(String.valueOf(Integer.valueOf(quan2.getText().toString())+1));
                int num,pri=0;
                num=Integer.valueOf(quan2.getText().toString());
                if(str.equals("1"))
                {pri=8;}
                else if(str.equals("2"))
                {pri=15;}
                else if(str.equals("3"))
                {pri=7;}

                tprice.setText(String.valueOf(Integer.valueOf(tprice.getText().toString())+pri));
            }
        });
        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(quan.getText().toString())<=0){
                    Toast.makeText(getActivity(), "数量不能再减啦!", Toast.LENGTH_SHORT).show();
                }else{
                    quan.setText(String.valueOf(Integer.valueOf(quan.getText().toString())-1));
                    int num,pri=0;
                    num=Integer.valueOf(quan.getText().toString());
                    if(str.equals("1"))
                    {pri=5;}
                    else if(str.equals("2"))
                    {pri=13;}
                    else if(str.equals("3"))
                    {pri=6;}
                    tprice.setText(String.valueOf(Integer.valueOf(tprice.getText().toString())-pri));
                }

            }
        });
        reduce2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(quan2.getText().toString())<=0){
                    Toast.makeText(getActivity(), "数量不能再减啦!", Toast.LENGTH_SHORT).show();
                }else{
                    quan2.setText(String.valueOf(Integer.valueOf(quan2.getText().toString())-1));
                    int num,pri=0;
                    num=Integer.valueOf(quan2.getText().toString());
                    if(str.equals("1"))
                    {pri=8;}
                    else if(str.equals("2"))
                    {pri=15;}
                    else if(str.equals("3"))
                    {pri=7;}
                    tprice.setText(String.valueOf(Integer.valueOf(tprice.getText().toString())-pri));
                }

            }
        });




        //adapter = new tiaomu(caidanye.this, listmap);
        //listview.setAdapter(adapter);
        //adapter.setRefreshPriceInterface(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.tv_go_to_pay:

                break;
        }
    }
    /**
     * 数据
     */
    private void initDate(){
        BmobQuery<Menu>query=new BmobQuery<Menu>();
        //BmobQuery<Orders>oquery=new BmobQuery<Orders>();
        //query.addQueryKeys("Dname,Dprice");
        Bundle bundle=this.getArguments();
        str=bundle.getString("Bno");
        query.addWhereEqualTo("Bno",bundle.getString("Bno"));
        query.findObjects(new FindListener<Menu>() {
            @Override
            public void done(List<Menu> list, BmobException e) {
                if(e==null){
                    Toast.makeText(getActivity(),"succeeded "+list.size()+"条数据",Toast.LENGTH_LONG).show();
                    dname.setText(list.get(0).getDname().toString());
                    dname2.setText(list.get(1).getDname().toString());
                    price.setText("￥ "+String.valueOf(list.get(0).getDprice()));
                    price2.setText("￥ "+String.valueOf(list.get(1).getDprice()));
                    //listview.setAdapter(new MyAdapter(getActivity(),list));
                }else{
                    Log.e("BMOB",e.toString());

                }
            }
        });
        /*oquery.findObjects(new FindListener<Orders>() {
            @Override
            public void done(List<Orders> list, BmobException e) {

            }
        });*/

    }

    public void dealFoodCount(int position, boolean isAdd){
        adapter.setFoodCountMap(position,isAdd);
        adapter.notifyDataSetChanged();
    }


}
