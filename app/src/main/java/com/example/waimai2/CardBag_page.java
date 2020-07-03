package com.example.waimai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class CardBag_page extends AppCompatActivity {
    private ImageButton back;
    private Button use_card;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.cardbag);
        back = (ImageButton) findViewById(R.id.btn_back);
        //跳转到商家页面
        use_card=findViewById(R.id.use_card);
        //
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CardBag_page.this.finish();

            }
        });
        use_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到商家页面
                Intent intent=new Intent(CardBag_page.this,shop.class);
                startActivity(intent);
                CardBag_page.this.finish();

            }
        });
    }
}
