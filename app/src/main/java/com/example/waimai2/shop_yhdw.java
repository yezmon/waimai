package com.example.waimai2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class shop_yhdw extends AppCompatActivity {
    private RadioGroup mRgGroup;
    private FragmentManager fragmentManager;

    private static final String[] FRAGMENT_TAG = {"tab_caidanye","tab_pingjia", "tab_shangjia"};

    private final int show_tab_pingjia = 1;//评价
    private final int show_tab_caidanye = 0;//菜单页
    private final int show_tab_shangjia = 2;//商家



    private int index = -100;// 记录当前的选项
    /**
     * 上一次界面 onSaveInstanceState 之前的tab被选中的状态 key 和 value
     */
    private static final String PRV_SELINDEX = "PREV_SELINDEX";
    private caidanye caidanye;
    private pingjia pingjia;
    private shangjia shangjia;
    private int mrIndex = show_tab_caidanye;//默认选中菜单页
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //解决底部选项按钮被输入文字框顶上去
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //显示界面
        setContentView(R.layout.shop_yhdw);

        fragmentManager = getSupportFragmentManager();

        //防止app闪退后fragment重叠
        if (savedInstanceState != null) {
            //读取上一次界面Save的时候tab选中的状态
            mrIndex = savedInstanceState.getInt(PRV_SELINDEX, mrIndex);

            caidanye = (caidanye) fragmentManager.findFragmentByTag(FRAGMENT_TAG[1]);
            pingjia = (pingjia) fragmentManager.findFragmentByTag(FRAGMENT_TAG[0]);
            shangjia = (shangjia) fragmentManager.findFragmentByTag(FRAGMENT_TAG[2]);

        }

        //初始化
        initView();
        // @Override
        /*protected void onSaveInstanceState(Bundle outState){
            outState.putInt(PRV_SELINDEX, mrIndex);
            super.onSaveInstanceState(outState);*/
    }



    protected void initView(){
        //获得RadioGroup控件
        mRgGroup = (RadioGroup) findViewById(R.id.rg_group);
        //选择设置Fragment
        setTabSelection(show_tab_caidanye);
        //点击事件
        mRgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.pingjia_yhdw://导航
                        setTabSelection(show_tab_pingjia);
                        break;
                    case R.id.menu_yhdw://地图
                        setTabSelection(show_tab_caidanye);
                        break;
                    case R.id.shangjia_yhdw://发现
                        setTabSelection(show_tab_shangjia);
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
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 设置切换动画
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case show_tab_pingjia://导航的fragment
                mRgGroup.check(R.id.rb_pingjia);
                if (pingjia == null) {
                    pingjia = new pingjia();
                    transaction.add(R.id.fl_container, pingjia, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(pingjia);
                }
                transaction.commit();
                break;
            case show_tab_caidanye://地图的fragment
                mRgGroup.check(R.id.menu_yhdw);
                if (caidanye == null) {
                    caidanye = new caidanye();
                    Bundle bundle=new Bundle();
                    bundle.putString("Bno","3");
                    caidanye.setArguments(bundle);
                    transaction.add(R.id.fl_container, caidanye, FRAGMENT_TAG[index]);
                } else {
                    Bundle bundle=new Bundle();
                    bundle.putString("Bno","3");
                    caidanye.setArguments(bundle);
                    transaction.show(caidanye);
                }
                transaction.commit();
                break;
            case show_tab_shangjia://的fragment
                mRgGroup.check(R.id.rb_shangjia);//设置商城被选中
                if (shangjia == null) {
                    shangjia = new shangjia();
                    Bundle bundle=new Bundle();
                    bundle.putString("Bno","3");
                    shangjia.setArguments(bundle);
                    transaction.add(R.id.fl_container, shangjia, FRAGMENT_TAG[index]);
                } else {
                    Bundle bundle=new Bundle();
                    bundle.putString("Bno","3");
                    shangjia.setArguments(bundle);
                    transaction.show(shangjia);
                }
                transaction.commit();
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
        if (pingjia != null) {
            transaction.hide(pingjia);
        }
        if (caidanye != null) {
            transaction.hide(caidanye);
        }
        if (shangjia != null) {
            transaction.hide(shangjia);
        }

    }



}


