package com.example.childknowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String listnumtext[]={"un 1","deux 2","trois 3","quatre 4","cinq 5","six 6","sept 7","huit 8","neuf 9"};
    int listnumimg[]={R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6,R.drawable.i7,R.drawable.i8,R.drawable.i9};
    int listnumaudio[]={R.raw.a1,R.raw.a2,R.raw.a3,R.raw.a4,R.raw.a5,R.raw.a6,R.raw.a7,R.raw.a8,R.raw.a9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button numero = findViewById(R.id.numero);
        numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numeroIntent = new Intent(getApplicationContext(),NumActivity.class);
                numeroIntent.putExtra("listnum",listnumtext);
                numeroIntent.putExtra("listimg",listnumimg);
                numeroIntent.putExtra("listaudio",listnumaudio);
                startActivity(numeroIntent);
            }
        });
    }
}