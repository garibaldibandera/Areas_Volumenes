package com.example.areasvolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Rectangulo extends AppCompatActivity {
    private EditText base, altura;
    private TextView resultado;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        base=findViewById(R.id.txtValorBase);
        altura=findViewById(R.id.txtValorAltura);
        resultado=findViewById(R.id.lblValorResultado);
    }

    public void calcular (View v){
        double vlrbase, vlraltura, vlrarea=0;
        if (validar()){
            vlrbase=Double.parseDouble(base.getText().toString());
            vlraltura=Double.parseDouble(altura.getText().toString());
            vlrarea=vlrbase*vlraltura;
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
        intent=new Intent(Rectangulo.this,CalcularArea.class);
        startActivity(intent);
    }
}

