package com.example.areasvolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Triangulo extends AppCompatActivity {
    private EditText base, altura;
    private TextView resultado;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        base=findViewById(R.id.txtValorBase);
        altura=findViewById(R.id.txtValorAltura);
        resultado=findViewById(R.id.lblValorResultado);
    }

    public void calcular (View v){
        double vlrbase, vlraltura, vlrarea=0;
        String operacion, datos, total;
        Operaciones operaciones;
        if (validar()){
            vlrbase=Double.parseDouble(base.getText().toString());
            vlraltura=Double.parseDouble(altura.getText().toString());
            vlrarea=(vlrbase*vlraltura)/2;
            resultado.setText(String.format("%1s %.2f",getResources().getString(R.string.area),vlrarea));
            operacion=getResources().getString(R.string.area)+" "+getString(R.string.triangulo);
            datos=getString(R.string.base)+base.getText().toString()+getString(R.string.salto_linea)+getString(R.string.altura)+altura.getText().toString();
            total=resultado.getText().toString();
            operaciones=new Operaciones(operacion, datos, total);
            operaciones.guardar();
            Toast.makeText(this,getString(R.string.operacion_guardada), Toast.LENGTH_LONG).show();

        }
        resultado.setText(String.format("%1s %.2f",getResources().getString(R.string.area),vlrarea));
    }

    public boolean validar() {
        String error_valor;
        error_valor=getResources().getString(R.string.error_valor);

        if (base.getText().toString().isEmpty()){
            base.setError(error_valor);
            base.requestFocus();
            return false;
        }else if (altura.getText().toString().isEmpty()){
            altura.setError(error_valor);
            altura.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        base.setText("");
        altura.setText("");
        resultado.setText(getResources().getString(R.string.area));
    }
    public void botonok(View v){
        intent=new Intent(Triangulo.this,CalcularArea.class);
        startActivity(intent);
    }
}
