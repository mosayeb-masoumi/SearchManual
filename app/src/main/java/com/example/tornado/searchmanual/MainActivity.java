package com.example.tornado.searchmanual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editTextSearch;
    ArrayList<String> names;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        names = new ArrayList<>();

        names.add("Ramiz");
        names.add("Belal");
        names.add("Azad");
        names.add("Manish");
        names.add("Sunny");
        names.add("Shahid");
        names.add("Deepak");
        names.add("Deepika");
        names.add("Sumit");
        names.add("Mehtab");
        names.add("Vivek");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        editTextSearch = (EditText) findViewById(R.id.editTextSearch);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CustomAdapter(names);

        recyclerView.setAdapter(adapter);
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

    }

    private void filter(String text) {
        ArrayList<String> filterdNames = new ArrayList<>();

        for (String s : names) {
            if (s.toLowerCase().contains(text.toLowerCase())) {
                filterdNames.add(s);
            }
        }

        adapter.filterList(filterdNames);
    }
}