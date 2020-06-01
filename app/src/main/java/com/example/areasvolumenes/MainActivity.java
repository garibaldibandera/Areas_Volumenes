package com.example.areasvolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lista_opciones, lista_area, lista_volumenes;
    private String[] opciones, area, volumenes;
    private ArrayAdapter<String> adapter, adapter_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista_opciones=findViewById(R.id.lstOpciones);
        opciones=getResources().getStringArray(R.array.opciones);
        area=getResources().getStringArray(R.array.areas);
        volumenes=getResources().getStringArray(R.array.volumenes);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, opciones);
        lista_opciones.setAdapter(adapter);

       /* adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, area);
        area.setAdapter(adapter);

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, volumenes);
        volumenes.setAdapter(adapter);*/


    }
}
