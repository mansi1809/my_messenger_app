package com.example.mymessengerapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChatActivity extends AppCompatActivity {

    Toolbar chatBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);


        chatBar = findViewById(R.id.chatBar);
       setSupportActionBar(chatBar);
        setTitle("");
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
      String Name = intent.getStringExtra("NAME");

     //  int Image = intent.getIntExtra("IMAGE",900);
     //  chatBar.setSubtitle(Image);
       chatBar.setSubtitle(Name);

    }

}