package com.nomi.makhrij_al_hurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView_;
    Button btn_,btn2_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView_ = findViewById(R.id.view5);
        btn_ = findViewById(R.id.btn_login);
        btn2_ = findViewById(R.id.practice);


        btn2_.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this , PracticeActivity.class);
            startActivity(intent);
        });
        imageView_.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://github.com/nauman-aziz/Makh-rij-al-Hur-f"));
            startActivity(intent);
        });
        btn_.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this , TestActivity.class);
            startActivity(intent);
        });

    }
}