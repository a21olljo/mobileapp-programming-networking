package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    RecyclerView recyclerView;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private ArrayList<Mountain> mountains = new ArrayList<Mountain>();
    MountainAdapter mountainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        mountainAdapter = new MountainAdapter(mountains);
        recyclerView.setAdapter(mountainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        new JsonTask(this).execute(JSON_URL);

    }

    @Override
    public void onPostExecute(String json) {
        // Create GSON object to perform marshall/unmarshall operations
        Gson gson = new Gson();

        // Unmarshall JSON -> list of objects
        Type type = new TypeToken<ArrayList<Mountain>>() {}.getType();
        mountains = gson.fromJson(json, type);
        mountainAdapter.setMountains(mountains);
        mountainAdapter.notifyDataSetChanged();

        Log.d("MainActivity", json);
    }
}
