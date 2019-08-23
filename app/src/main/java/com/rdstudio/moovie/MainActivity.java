package com.rdstudio.moovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // add dummy list data movie
    private String[] dataMovie = {"A Star Is Born", "Aquaman", "Bohemian Rhapsody", "BumbleBee", "Creed II", "DeadPool", "HTTYD",
    "DragonBall","Glass", "Hunter Killer", "Mary Poppins", "Mortal Engines", "preman Pensiun", "Robin Hood", "Spiderman In To The Spider Verse",
    "The Girl In The Spders Web", "The Mule", "Venom"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add dummy main view
        ListView listView = findViewById(R.id.lv_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, dataMovie);
        listView.setAdapter(adapter);
    }
}
