package com.example.nizarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView image=findViewById(R.id.image);
        TextView  text=findViewById(R.id.text);
        Button button=findViewById(R.id.button);
        Button button2=findViewById(R.id.button2);
        Intent g = getIntent();
        image.setImageResource(g.getIntExtra("image",100001));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer media = MediaPlayer.create(getApplicationContext(),g.getIntExtra("audio",1000001));
                media.start();
            }
        });
        text.setText(g.getStringExtra("text"));
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(j);
            }
        });

    }
}