package com.example.waimai2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import com.example.waimai2.BmobSql.Menu;
import com.example.waimai2.BmobSql.Orders;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.UpdateListener;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Menu> list;

    private HashMap<String, Integer> pitchOnMap;
    private HashMap<Integer,Integer> foodCountMap;
    private viewHolder holder ;
    FoodCallBack mCallback;



    TextView reduce,add,num,total;

    public MyAdapter(Context context,List<Menu> list){
        this.context=context;
        this.list=list;

    }
    @Override
    public int getCount(){
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    class viewHolder{

        private TextView name; // 名称
        private TextView price; // 价格
        private TextView description_long; // 介绍：长的
        private TextView count;
        private LinearLayout layout_foodCountSelect;
        private TextView tv_food_delete;
        private Button btn_food_count;
        private TextView tv_food_add;

    }
    private class ClickListener implements View.OnClickListener{
        viewHolder mViewHolder;
        Menu mMenu;
        int mPosition;
        public ClickListener(Menu menu){
            this.mMenu=menu;
        }
        public  ClickListener(int Position){
            this.mPosition=Position;
        }
        @Override
        public void onClick(View v){
            int fCount=Integer.parseInt((String)((TextView)holder.count).getText());
            switch (v.getId()) {
                case R.id.tv_add:
                    //mCallback.dealFoodCount(mPosition,true);
                    int i= foodCountMap.get(mPosition)+1;
                    holder.count.setText(String.valueOf(i));
                    break;
                case R.id.tv_reduce:
                    mCallback.dealFoodCount(mPosition,false);
                    break;
                }
            }
        }



    public interface FoodCallBack{
        void dealFoodCount(int pos,boolean isAdd);
    }
    public void setCallBack(FoodCallBack callback){
        this.mCallback=callback;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){


            LayoutInflater inflater=LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.tiaomu,null);
            holder=new viewHolder();
            /*TextView dnameText=convertView.findViewById(R.id.tv_goods_name);
            TextView dpriceText=convertView.findViewById(R.id.tv_goods_price);*/

            holder.name=(TextView)convertView.findViewById(R.id.tv_goods_name);
            holder.price=(TextView)convertView.findViewById(R.id.tv_goods_price);
            holder.count=(TextView)convertView.findViewById(R.id.tv_num);
            holder.tv_food_add=(TextView)convertView.findViewById(R.id.tv_add);
            holder.tv_food_delete=(TextView)convertView.findViewById(R.id.tv_reduce);
            convertView.setTag(holder);

        }else{holder=(viewHolder)convertView.getTag();}
        Menu menu=list.get(position);
        if(menu != null){
            if(!TextUtils.isEmpty(menu.getDname())){
                holder.name.setText(menu.getDname());
            }
            holder.price.setText("￥"+menu.getDprice());
        }
            /*dnameText.setText(dname);
            dpriceText.setText(String.valueOf(dprice));*/
            /*for(int i=0;i<list.size();i++){
                foodCountMap.put(Integer.valueOf(list.get(i).toString()),0);
            }*/
        convertView.setOnClickListener(new ClickListener(menu));
        //holder.count.setText(foodCountMap.get(position).toString());
        holder.count.setText("0");
        holder.tv_food_add.setOnClickListener(new ClickListener(position));
        holder.tv_food_delete.setOnClickListener(new ClickListener(position));
        return convertView;
        /*reduce = convertView.findViewById(R.id.tv_reduce);
        add = convertView.findViewById(R.id.tv_add);
        num=convertView.findViewById(R.id.tv_num);
        total=convertView.findViewById(R.id.tv_total_price);
        num.setTag(position);*/

        //
        //商品数量减
        /*reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dprice;
                dprice=list.get(position).getDprice();
                /*if (Integer.valueOf(list.get(position).get("count")) <= 1) {
                    Toast.makeText(context, "数量不能再减啦,只能删除!", Toast.LENGTH_SHORT).show();
                } else {
                    //list.get(position).put("count", (Integer.valueOf(list.get(position).get("count")) - 1) + "");
                    //notifyDataSetChanged();
                if(Integer.valueOf(num.getText().toString())<=0){
                    Toast.makeText(context, "数量不能再减啦!", Toast.LENGTH_SHORT).show();
                }else{
                    //numReduce();

                    totalReduce(dprice);
                    //num.setText(String.valueOf(nc));

                    num.setText(Olist.get(position).getOdquan());
                    //total.setText("￥"+String.valueOf(tt));
                }

                }
                //mrefreshPriceInterface.refreshPrice(pitchOnMap);
            //}
        });*/
        //商品数量加
        /*add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dprice;
                dprice=list.get(position).getDprice();

                //numAdd();

                //num.setText(String.valueOf(nc));
                BmobQuery<Orders> search = new BmobQuery<Orders>();
                String dname=list.get(position).getDname();
                String sqlstr="select Dno from Orders where Dname="+dname+" and Ostatus=False";
                search.doSQLQuery(sqlstr,new SQLQueryListener<Orders>() {
                    @Override
                    public void done(BmobQueryResult<Orders> bmobQueryResult, BmobException e) {
                        if(e==null){
                            List<Orders> list2=(List<Orders>)bmobQueryResult.getResults();
                            if(list2 != null && list2.size()>0){
                                int n=Olist.get(position).getOdquan();
                                String s=Olist.get(position).getObjectId();
                                n+=1;
                                //totalAdd(dprice);
                                //num.setText(String.valueOf(nc));
                                Olist.get(position).setOdquan(n);
                                Olist.get(position).update(s, new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {

                                    }
                                });
                                num.setText(Olist.get(position).getOdquan());
                            }else{
                                Orders o=new Orders();
                                o.setBno(list.get(position).getBno());
                                o.setDname(list.get(position).getDname());
                                o.setOdquan(1);
                                num.setText(Olist.get(position).getOdquan());
                            }
                        }
                    }
                });
                /*int n=Olist.get(position).getOdquan();
                String s=Olist.get(position).getObjectId();
                n+=1;
                totalAdd(dprice);
                //num.setText(String.valueOf(nc));
                Olist.get(position).setOdquan(n);
                Olist.get(position).update(s, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {

                    }
                });
                num.setText(Olist.get(position).getOdquan());
                //total.setText("￥"+String.valueOf(tt));
            }

        });*/
        //num.setText(String.valueOf(nc));
        //return convertView;
    }
    public void setFoodCountMap(int position,boolean isAdd){
        int foodCount=foodCountMap.get(position);
        if(foodCount==0 && !isAdd){
            Toast.makeText(context, "数量不能再减啦,只能删除!", Toast.LENGTH_SHORT).show();
            return;
        }
        foodCountMap.put(position,isAdd ? (foodCount+1) : (foodCount-1));
    }

}
