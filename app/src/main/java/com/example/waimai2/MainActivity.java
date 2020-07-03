package com.example.waimai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RadioGroup;


import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRgGroup;
    private FragmentManager fragmentManager;

    private static final String[] FRAGMENT_TAG = {"tab_home","tab_dingdan", "tab_mine"};

    private final int show_tab_dingdan = 1;//评价
    private final int show_tab_home = 0;//菜单页
    private final int show_tab_mine = 2;//商家




    private int index = -100;// 记录当前的选项
    /**
     * 上一次界面 onSaveInstanceState 之前的tab被选中的状态 key 和 value
     */
    private static final String PRV_SELINDEX = "PREV_SELINDEX";
    private home home;
    private dingdan dingdan;
    private mine mine;
    private int mrIndex = show_tab_home;//默认选中菜单页
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //解决底部选项按钮被输入文字框顶上去
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //显示界面
        setContentView(R.layout.activity_main);
        //Bmob.initialize(this, "a26ff1015f8286092fa7db4e71077046");
        fragmentManager = getSupportFragmentManager();

        //防止app闪退后fragment重叠
        if (savedInstanceState != null) {
            //读取上一次界面Save的时候tab选中的状态
            mrIndex = savedInstanceState.getInt(PRV_SELINDEX, mrIndex);

            dingdan = (dingdan) fragmentManager.findFragmentByTag(FRAGMENT_TAG[1]);
            home = (home) fragmentManager.findFragmentByTag(FRAGMENT_TAG[0]);
            mine = (mine) fragmentManager.findFragmentByTag(FRAGMENT_TAG[2]);

        }

        //初始化

        initView();
        //MyDbOpenHelper dbhelper=new MyDbOpenHelper(MainActivity.this);
        //SQLiteDatabase db=dbhelper.getWritableDatabase();
        // @Override
        /*protected void onSaveInstanceState(Bundle outState){
            outState.putInt(PRV_SELINDEX, mrIndex);
            super.onSaveInstanceState(outState);*/


        //登录按钮的点击事件

    }



    protected void initView(){
        //获得RadioGroup控件
        mRgGroup = (RadioGroup) findViewById(R.id.rg_group);
        //选择设置Fragment
        setTabSelection(show_tab_home);
        //点击事件

        mRgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {

                    case R.id.home://地图
                        setTabSelection(show_tab_home);
                        break;
                    case R.id.mine://发现
                        setTabSelection(show_tab_mine);
                        Intent i=new Intent(MainActivity.this,Mine_page.class);
                        //i.putExtra("username",userName);
                        break;

                    default:
                        break;
                }
            }
        });


    }
    private void setTabSelection(int id) {    //根据传入的index参数来设置选中的tab页。
        if (id == index) {
            return;
        }
        index = id;
        Intent intent=this.getIntent();
        String userName=intent.getStringExtra("username");
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 设置切换动画
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {

            case show_tab_home://地图的fragment
                mRgGroup.check(R.id.home);
                if (home == null) {
                    home = new home();
                    transaction.add(R.id.fl_container, home, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(home);
                }
                transaction.commit();
                break;
            case show_tab_mine://的fragment
                mRgGroup.check(R.id.mine);//设置商城被选中
                if (mine == null) {
                    mine = new mine();
                    //transaction.add(R.id.fl_container, mine, FRAGMENT_TAG[index]);


                } else {
                    transaction.show(mine);
                }
                transaction.commit();
                Intent data=new Intent(MainActivity.this,Mine_page.class);
                setResult(RESULT_OK,data);
                data.putExtra("username",userName);
                startActivity(data);
                break;

            default:
                break;
        }
    }

    /**
     * 隐藏fragment
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (dingdan != null) {
            transaction.hide(dingdan);
        }
        if (home != null) {
            transaction.hide(home);
        }
        if (home != null) {
            transaction.hide(home);
        }

    }



}