/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.text.DecimalFormat;

/**
 *
 * @author orlynux
 */
public class Modelo {
   private double cantidad;
   private String divisaEntrante;
   private String divisaSaliente;
   private double resultado;
   
   public double[] MXN = {0.049,0.047};
   public double[] DLS = {20.47,0.95};
   public double[] EUR = {21.49,1.05};

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDivisaEntrante() {
        return divisaEntrante;
    }

    public void setDivisaEntrante(String divisaEntrante) {
        this.divisaEntrante = divisaEntrante;
    }

    public String getDivisaSaliente() {
        return divisaSaliente;
    }

    public void setDivisaSaliente(String divisaSaliente) {
        this.divisaSaliente = divisaSaliente;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    //métodos de conversion
    
    public String aMoneda(double monto, String moneda) {        
        DecimalFormat formatoImporte = new DecimalFormat("#,###.##");        
        String signo="";
        switch (moneda) {
            case "MXN":                
                signo="$";
                break;
            case "DLS":                
                signo="$";
                break;
            case "EUR":
                signo="€";
                break;
        }
        return signo+" "+formatoImporte.format(monto)+" "+moneda;
    }
    
    public double conversion (double cantidad, double equivalente) {
        return cantidad * equivalente;
    }
   
   
}
