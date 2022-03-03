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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num);
        List<HashMap<String,String>> aList=new ArrayList<HashMap<String,String>>();
        Intent g = getIntent();
        String listnum[]=g.getStringArrayExtra("listnum");
        int listimg[]=g.getIntArrayExtra("listimg");
        int listaudio[]=g.getIntArrayExtra("listaudio");
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