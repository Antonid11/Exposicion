/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel;

import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Huesped huesped = new Huesped();
        Habitacion habitacion100 = new Habitacion(100, "Individual", 50.0, 1, true, false);
        Habitacion habitacion204 = new Habitacion(204, "Doble", 75.0, 2, true, false);
        Habitacion habitacion230 = new Habitacion(230, "Doble", 85.0, 2, true, true);
        Habitacion habitacion250 = new Habitacion(250, "Suite individual", 100.0, 1, true, true);
        Habitacion habitacion320 = new Habitacion(320, "Suite doble", 120.0, 2, true, true);
        Habitacion habitacion487 = new Habitacion(487, "Suite Familiar", 180.0, 4, true, true);

        System.out.println("---REGISTRO DE NUEVO HUESPED---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        huesped.setNombre(nombre);
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        huesped.setApellido(apellido);
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        huesped.setDni(dni);
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();
        huesped.setTelefono(telefono);
        String email;
        boolean emailValido = false;
        do {
            System.out.print("Email: ");
            email = sc.nextLine();
            if (huesped.emailValido(email)) { // solo si es valido se setea el email
                emailValido = true;
                huesped.setEmail(email);
            } else {
                System.out.println("Email no valido. Solo se aceptan correos con terminacion @gmail.com, @yahoo.es, @icloud.com, @yahoo.com o @hotmail.com");
                System.out.println("Por favor, ingrese un email valido.");
            }
        } while (!emailValido); // va a repetir la pregunta hasta que ingrese un correo valido
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        huesped.setEdad(edad);
        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();
        huesped.setNacionalidad(nacionalidad);

        int personas;
        boolean numValido = false;
        do {
            System.out.print("Numero de personas que se alojaran (maximo 4): ");
            personas = sc.nextInt();
            sc.nextLine();
            if (personas > 0 && personas <= 4) {
                numValido = true;
            } else {
                System.out.println("Numero de personas no valido. Debe ser entre 1 a 4 personas por habitacion");
                System.out.println("Por favor, ingrese un valor valido.");
            }
        } while (!numValido);// va a repetir la pregunta hasta ingresar un numero valido
        System.out.println("---INFORMACION DEL HUESPED REGISTRADO---");
        System.out.println(huesped.toString());
        
        if (huesped.descuentoAplicable()) {
            System.out.println("Se le aplicara el descuento!");
        }
        
        System.out.println("---HABITACIONES DISPONIBLES PARA "+personas+" PERSONAS---");
        if (personas >=2 && personas <=4) {
            System.out.println("---HABITACIONES DISPONIBLES---");
            System.out.println(habitacion204.toString());
            System.out.println(habitacion230.toString());
            System.out.println(habitacion250.toString());
            System.out.println(habitacion320.toString());
            System.out.println(habitacion487.toString());
        }else if (personas>=1&&personas<-4) {
            System.out.println("---HABITACIONES DISPONIBLES---");
            System.out.println(habitacion100.toString());
            System.out.println(habitacion204.toString());
            System.out.println(habitacion230.toString());
            System.out.println(habitacion250.toString());
            System.out.println(habitacion320.toString());
            System.out.println(habitacion487.toString());
        }
    }
}
