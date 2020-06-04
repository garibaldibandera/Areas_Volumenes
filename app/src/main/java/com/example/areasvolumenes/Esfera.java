package com.example.areasvolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Esfera extends AppCompatActivity {
    private EditText radio;
    private TextView resultado;
    private  Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        radio=findViewById(R.id.txtValorRadio);
        resultado=findViewById(R.id.lblValorResultado);
    }

    public void calcular (View v){
        double vlrradio, vlrvolumen=0, pi = 3.1416;
        String operacion, datos, total;
        Operaciones operaciones;
        if (validar()){
            vlrradio=Double.parseDouble(radio.getText().toString());
            vlrvolumen= (4*(pi*((vlrradio*vlrradio)*vlrradio)))/3;
            resultado.setText(String.format("%1s %.2f",getResources().getString(R.string.valor_volumen),vlrvolumen));
            operacion=getResources().getString(R.string.valor_volumen)+getString(R.string.esfera);
            datos=getString(R.string.radio)+radio.getText().toString();
            total=resultado.getText().toString();
            operaciones=new Operaciones(operacion, datos, total);
            operaciones.guardar();
            Toast.makeText(this,getString(R.string.operacion_guardada), Toast.LENGTH_LONG).show();
        }
    }

    public boolean validar() {
        String error_valor;
        error_valor=getResources().getString(R.string.error_valor);

        if (radio.getText().toString().isEmpty()){
            radio.setError(error_valor);
            radio.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        radio.setText("");
        resultado.setText(getResources().getString(R.string.valor_volumen));
    }
    public void botonok(View v){
        intent=new Intent(Esfera.this,CalcularVolumenes.class);
        startActivity(intent);
    }
}
