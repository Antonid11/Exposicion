/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

public class Habitacion {
    private int numero;
    private String tipo;
    private double precioNoche;
    private boolean disponible;
    private int capacidad;
    private boolean tieneWifi;
    private boolean tieneMiniBar;

    public Habitacion() {
        
    }
    
    public Habitacion(int numero, String tipo, double precioNoche, int capacidad, boolean tieneWifi, boolean tieneMiniBar) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.disponible = true; //Siempre estara disponible por defecto
        this.capacidad = capacidad;
        this.tieneWifi = tieneWifi;
        this.tieneMiniBar = tieneMiniBar;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isTieneWifi() {
        return tieneWifi;
    }

    public void setTieneWifi(boolean tieneWifi) {
        this.tieneWifi = tieneWifi;
    }

    public boolean isTieneMiniBar() {
        return tieneMiniBar;
    }

    public void setTieneMiniBar(boolean tieneMiniBar) {
        this.tieneMiniBar = tieneMiniBar;
    }

    @Override
    public String toString() {
        return "Habitacion: " + numero + "\nTipo: " + tipo + "\nPrecio por Noche: " + precioNoche + "\nDisponible: " + disponible + "\nCapacidad: " + capacidad + "\nTiene Wifi:" + tieneWifi + "\nTiene Mini Bar:" + tieneMiniBar;
    }
    public double precioTotal(int numeroNoches){
        return precioNoche*numeroNoches;
    }
    public void descuento(double porcentaje){
        if (porcentaje > 0 && porcentaje <= 100) {
            double descuento = precioNoche * (porcentaje/100);
            precioNoche -= descuento;
        }
    }
}
