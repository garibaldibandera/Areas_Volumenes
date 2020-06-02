package com.example.areasvolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cubo extends AppCompatActivity {
    private EditText lado;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        lado=findViewById(R.id.txtValorlado);
        resultado=findViewById(R.id.lblValorResultado);
    }
    public void calcular (View v){
        double vlrlado, vlrvolumen=0;
        if (validar()){
            vlrlado=Double.parseDouble(lado.getText().toString());
            vlrvolumen=(vlrlado*vlrlado)*vlrlado;
        }
        resultado.setText(String.format("%1s %.2f",getResources().getString(R.string.valor_volumen),vlrvolumen));
    }

    public boolean validar() {
        String error_valor;
        error_valor=getResources().getString(R.string.error_valor);

        if (lado.getText().toString().isEmpty()){
            lado.setError(error_valor);
            lado.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        lado.setText("");
        resultado.setText(getResources().getString(R.string.area));
    }

}
