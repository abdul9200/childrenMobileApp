package com.example.childknowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumActivity extends AppCompatActivity {
    public MediaPlayer media;
    String listnum[]={"un 1","deux 2","trois 3","quatre 4","cinq 5","six 6","sept 7","huit 8","neuf 9"};
    int listimg[]={R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6,R.drawable.i7,R.drawable.i8,R.drawable.i9};
    int listaudio[]={R.raw.a1,R.raw.a2,R.raw.a3,R.raw.a4,R.raw.a5,R.raw.a6,R.raw.a7,R.raw.a8,R.raw.a9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num);
        List<HashMap<String,String>> aList=new ArrayList<HashMap<String,String>>();
        for(int i=0;i<9;i++){
            HashMap<String,String>hm=new HashMap<String,String>();
            hm.put("image",Integer.toString(listimg[i]));
            hm.put("text",listnum[i]);
            aList.add(hm);
        }
        String [] from={"image","text"};
        int[] to={R.id.image,R.id.text};
        SimpleAdapter adapter= new SimpleAdapter(getBaseContext(),aList,R.layout.num_layout,from,to);
        GridView gridView=(GridView) findViewById(R.id.grid);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent g = new Intent(getApplicationContext(),NumElem.class);
                g.putExtra("image",listimg[i]);
                g.putExtra("text",listnum[i]);
                g.putExtra("audio",listaudio[i]);
                startActivity(g);


            }
        });


    }
}