package com.example.nikita.authentication.Activity.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.nikita.authentication.Activity.model.UserAthentication;
import com.example.nikita.authentication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<UserAthentication> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onItemsNext(ArrayList<UserAthentication> items) {
        this.itemsList = items;
    }

    public void onItemsError(Throwable error) {
        Toast.makeText(this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
