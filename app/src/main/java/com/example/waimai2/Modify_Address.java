package com.example.waimai2;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import androidx.appcompat.app.AppCompatActivity;
public class Modify_Address extends AppCompatActivity  {
    private SearchView mSearchView;
    private ListView lv;
    private ImageButton back;
    private TextView TV;

    private TextView city;
    private final String[] mString={"松江商城","万达广场","上海工程技术大学"};
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.modify_address);
        city=findViewById(R.id.city);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mString));
        lv.setTextFilterEnabled(true);
        Intent intent=getIntent();
        String str1= intent.getStringExtra("ncity");

        if(str1==null)
        {
            city.setText("上海");

        }
        else if(str1!=null){
            city.setText(intent.getStringExtra("ncity"));
            //在此处用数据库传出地址（详细地址）
        }

        mSearchView = (SearchView) findViewById(R.id.search);
        mSearchView.setIconifiedByDefault(true);
        mSearchView.setFocusable(false);
        mSearchView.clearFocus();
        mSearchView.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String queryText) {
                Toast.makeText(getApplicationContext(), "您选择的是:" + queryText, Toast.LENGTH_SHORT).show();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    lv.clearTextFilter();
                } else {
                    lv.setFilterText(newText);
                }
                return true;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(getApplicationContext(), "click item" + i, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Modify_Address.this, Mine_page.class);
                String address = mString[i].toString().trim();


                    intent.putExtra("naddress", address);

                startActivity(intent);
            }
        });

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Modify_Address.this.finish();

            }
        });

        city.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent=new Intent(Modify_Address.this,Chose_city_page.class);
                startActivityForResult(intent, 1);
            }


        });

    }
}
