package com.geeks.myapplication3;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity2 extends AppCompatActivity {
    private ImageView heartIcon;
    private boolean isHeartLiked = false;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main2);

       heartIcon = findViewById(R.id.vector_heart);

       heartIcon.setOnClickListener(v -> {
           isHeartLiked = !isHeartLiked;

           if (isHeartLiked) {
               heartIcon.setColorFilter(ContextCompat.getColor(MainActivity2.this, R.color.red));
           } else {
               heartIcon.setColorFilter(ContextCompat.getColor(MainActivity2.this, R.color.blue));
           }
       });

       Button btn_next = findViewById(R.id.btn_next);
       btn_next.setOnClickListener(v -> {
           finishAffinity();
       });
   }

}