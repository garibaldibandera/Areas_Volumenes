package com.example.areasvolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Circulo extends AppCompatActivity {
    private EditText radio;
    private TextView resultado;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        radio=findViewById(R.id.txtRadio);
        resultado=findViewById(R.id.lblValorResultado);
    }

    public void calcular (View v){
        double vlrradio, vlrarea=0, pi = 3.1416;
        String operacion, datos, total;
        Operaciones operaciones;
        if (validar()){
            vlrradio=Double.parseDouble(radio.getText().toString());
            vlrarea= vlrradio*pi;
            resultado.setText(String.format("%1s %.2f",getResources().getString(R.string.area),vlrarea));
            operacion=getResources().getString(R.string.area)+getString(R.string.circulo);
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
        resultado.setText(getResources().getString(R.string.area));
    }
    public void botonok(View v){
        intent=new Intent(Circulo.this,CalcularArea.class);
        startActivity(intent);
    }
}
