/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

public class Huesped {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private int edad;
    private String nacionalidad;

    public Huesped() {
        
    }

    public Huesped(String nombre, String apellido, String dni, String telefono, String email, int edad, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Huesped: " + nombre + " " + apellido + "\nDNI: " + dni + "\nTelefono: " + telefono + "\nEmail: " + email + "\nEdad: " + edad + "\nNacionalidad: " + nacionalidad;
    }
    
    public String nombreCompleto(){
        return nombre + " " + apellido;
    }
    
    public boolean esMayorDeEdad(){
        return edad >= 18;
    }
    
    public boolean descuentoAplicable(){
        return edad > 59 || edad < 12; // personas mayores de 59 años y menores de 12 se les aplica el descuento
    }
    public boolean emailValido(String email){ //validacion de los dominios que utiliza el hotel
        String [] validos = {"@gmail.com","@yahoo.es","@icloud.com","@yahoo.com","@hotmail.com"};
        if (email.isBlank()||email.isEmpty()) {
            return false;
        }
        for (int i = 0; i < validos.length; i++) {
            if (email.toLowerCase().endsWith(validos[i])) {
                return true;
            }
        }
        return false;
    }
}
