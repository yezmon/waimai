package com.example.waimai2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.waimai2.BmobSql.Menu;
import com.example.waimai2.BmobSql.Orders;

import java.util.List;

public class OrdAdapter extends BaseAdapter {
    private Context context;
    private List<Orders> list;

    private viewHolder holder;
    public OrdAdapter(Context context,List<Orders> list){
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
        private TextView count;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.menu_item,null);
            holder=new viewHolder();
            holder.name=(TextView)convertView.findViewById(R.id.tv_Bname);
            holder.price=(TextView)convertView.findViewById(R.id.tv_price);
            holder.count=(TextView)convertView.findViewById(R.id.tv_Quan);
        }
        Orders ord=list.get(position);
        if(ord!=null){
            holder.name.setText(ord.getDname().toString());
            holder.count.setText("数量："+String.valueOf(ord.getOdquan()));
            holder.price.setText("单价：￥ "+String.valueOf(ord.getOalto()));
        }
        return convertView;
    }
}
