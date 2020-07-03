package com.example.waimai2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Help_Forgetpsw_Page extends AppCompatActivity {
    private ImageButton back;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.help_forgetpsw);
        back = (ImageButton) findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Help_Forgetpsw_Page.this.finish();

            }
        });
    }
}
