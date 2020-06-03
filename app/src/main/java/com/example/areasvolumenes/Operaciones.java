package com.example.areasvolumenes;

public class Operaciones {
    private String operacion;
    private String operador;
    private String resultado;

    public Operaciones (String operacion, String operador, String resultado) {
        this.operacion = operacion;
        this.operador = operador;
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    public void guardar(){
        Datos.guardar(this);
    }
}
