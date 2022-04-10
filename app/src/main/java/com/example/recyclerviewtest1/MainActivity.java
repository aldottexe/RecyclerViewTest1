package com.example.recyclerviewtest1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //create a list with 100 items
    String[] data = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //fills list with pee/poop randomly
        for(int i = 0; i < data.length; i++){
            data[i] = Math.random() < 0.5 ? "pee" : "poop";
        }

        //autogenerated idk
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //grabs the recyclerView from the layout
        RecyclerView recyclerView = findViewById(R.id.listy);
        //sets the layoutManager to a new instance of the premade grid one. with a collum count of 2
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        //sets the adapter to the adapter class we made.
        recyclerView.setAdapter(new RAdapter(data));

    }
}