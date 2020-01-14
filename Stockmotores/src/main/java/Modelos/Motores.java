/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Pc
 */
public class Motores {
    /*
    Comentario Jesús Aldea 13/01/2020: clase Motores para trabajar sobre la tabla motores
    de BD 'motorland'. La clase se compone de los mismos atributos de la tabla motores, un 
    constructor vacío y otro con todos sus campos, así como los GETTERS y SETTERS para poder
    trabajar con los mismos desde las clases del package Controller 'altaController' y 
    'listadoController'.
    También se ha creado una función 'motoroptimo()' cuya finalidad es devolver 
    un string "SI" o "NO" acorde al resultado de dividir peso y potencia del motor, 
    y poder mostrarlo en el listado de la aplicación. Esta función es invocada desde
    'listadoController'.
    */
    
    private String modelo,fabricante;
    private int potencia,peso,cantidad;

    public Motores() {
    }

    public Motores(String modelo, String fabricante, int potencia, int peso, int cantidad) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.potencia = potencia;
        this.peso = peso;
        this.cantidad = cantidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String motoroptimo()
    {
        float division;
        float dividendo = this.getPeso();
        float divisor = this.getPotencia();
        String optimo;
        
        division = (dividendo/divisor);
        if(division<10)
        {
            optimo = "SI";
        }
        else
        {
            optimo = "NO";
        }
        return optimo;
    }
    
}
