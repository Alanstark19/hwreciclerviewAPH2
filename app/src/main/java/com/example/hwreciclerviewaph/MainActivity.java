package com.example.hwreciclerviewaph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //lista de todos los elementos
    List<ListElement> elemets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        init();
    }

    public void init(){
        elemets = new ArrayList<>();
        elemets.add(new ListElement("#656765", "Pedro", "México", "Activo"));
        elemets.add(new ListElement("#056812", "Julio", "Tabasco", "Activo"));
        elemets.add(new ListElement("#845735", "Alejandra", "México", "Cancelada"));

        ListAdapter listAdapter = new ListAdapter(elemets, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//manager lineal
        recyclerView.setAdapter(listAdapter);//le pasamos el adaptador

    }
}