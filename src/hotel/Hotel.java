/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel;

import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuarReservando = true;
        Habitacion habitacion100 = new Habitacion(100, "Individual", 50.0, 1, true, false);
        Habitacion habitacion204 = new Habitacion(204, "Doble", 75.0, 2, true, false);
        Habitacion habitacion230 = new Habitacion(230, "Doble", 85.0, 2, true, true);
        Habitacion habitacion250 = new Habitacion(250, "Suite individual", 100.0, 1, true, true);
        Habitacion habitacion320 = new Habitacion(320, "Suite doble", 120.0, 2, true, true);
        Habitacion habitacion487 = new Habitacion(487, "Suite Familiar", 180.0, 4, true, true);
        while (continuarReservando) {
            Huesped huesped = new Huesped();
            System.out.println("---REGISTRO DE NUEVO HUESPED---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("DNI: ");
            String dni = sc.nextLine();
            System.out.print("Telefono: ");
            String telefono = sc.nextLine();
            String email;
            boolean emailValido = false;
            do {
                System.out.print("Email: ");
                email = sc.nextLine();
                if (huesped.emailValido(email)) { // solo si es valido se guarda el email
                    emailValido = true;
                } else {
                    System.out.println("Email no valido. Solo se aceptan correos con terminacion @gmail.com, @yahoo.es, @icloud.com, @yahoo.com o @hotmail.com");
                    System.out.println("Por favor, ingrese un email valido.");
                }
            } while (!emailValido); // va a repetir la pregunta hasta que ingrese un correo valido
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();
            System.out.print("Nacionalidad: ");
            String nacionalidad = sc.nextLine();
            huesped = new Huesped(nombre, apellido, dni, telefono, email, edad, nacionalidad);//dandole los valores al huesped
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

            int[] edadHuespedes = new int[personas];
            edadHuespedes[0] = edad;
            for (int i = 1; i < personas; i++) {
                System.out.print("Edad del huesped " + (i + 1) + ": ");
                edadHuespedes[i] = sc.nextInt();
                sc.nextLine();
            }
            boolean huespedDescuento = false;
            for (int i = 0; i < edadHuespedes.length; i++) {
                if (edadHuespedes[i] > 59 || edadHuespedes[i] < 12) {
                    huespedDescuento = true;
                    break;
                }
            }
            System.out.println("---INFORMACION DEL HUESPED REGISTRADO---");
            System.out.println(huesped.toString());

            System.out.println();
            System.out.println("---HABITACIONES DISPONIBLES PARA " + personas + " PERSONAS---");
            if (personas == 2) {
                System.out.println(habitacion204.toString());
                System.out.println();
                System.out.println(habitacion230.toString());
                System.out.println();
                System.out.println(habitacion320.toString());
                System.out.println();
                System.out.println(habitacion487.toString());
            } else if (personas == 1) {
                System.out.println(habitacion100.toString());
                System.out.println();
                System.out.println(habitacion204.toString());
                System.out.println();
                System.out.println(habitacion230.toString());
                System.out.println();
                System.out.println(habitacion250.toString());
                System.out.println();
                System.out.println(habitacion320.toString());
                System.out.println();
                System.out.println(habitacion487.toString());
            } else if (personas >= 3 && personas <= 4) {
                System.out.println(habitacion487.toString());
            }

            int numHabitacion;
            Habitacion habitacionElegida = new Habitacion();
            boolean habitacionValida = false;
            do {
                System.out.println("---REALIZAR RESERVA---");
                System.out.print("Ingrese el numero de habitacion que desea reservar: ");
                numHabitacion = sc.nextInt();
                sc.nextLine();
                switch (numHabitacion) {
                    case 100:
                        habitacionElegida = habitacion100;
                        habitacionValida = true;
                        break;
                    case 204:
                        habitacionElegida = habitacion204;
                        habitacionValida = true;
                        break;
                    case 230:
                        habitacionElegida = habitacion230;
                        habitacionValida = true;
                        break;
                    case 250:
                        habitacionElegida = habitacion250;
                        habitacionValida = true;
                        break;
                    case 320:
                        habitacionElegida = habitacion320;
                        habitacionValida = true;
                        break;
                    case 487:
                        habitacionElegida = habitacion487;
                        habitacionValida = true;
                        break;
                    default:
                        System.out.println("Numero de habitacion no valido");
                        System.out.println("Por favor, ingrese un numero de habitacion valido.");
                        break;
                }
            } while (!habitacionValida);

            System.out.println("Ingrese el numero de noches: ");
            int noches = sc.nextInt();
            sc.nextLine();

            if (huesped.esMayorDeEdad() && habitacionElegida.isDisponible()) {
                double total = habitacionElegida.precioTotal(noches);

                if (huespedDescuento) {
                    double descuento = 39.0;//39% de descuento para los huespedes elegibles
                    System.out.println("Aplicando descuento del " + descuento + "%");
                    habitacionElegida.descuento(descuento);
                    total = habitacionElegida.precioTotal(noches);
                }
                if (huesped.presupuestoSuficiento(total)) {
                    habitacionElegida.setDisponible(false);
                    huesped.pago(total);
                    
                    System.out.println("---RESERVA CONFIRMADA---");
                    System.out.println("Se ha realizado la reserva para " + huesped.nombreCompleto());
                    System.out.println("Habitacion: " + habitacionElegida.getNumero());
                    System.out.println("Numero de personas: " + personas);
                    System.out.println("Duracion: " + noches + " noches");
                    System.out.println("Precio total: " + total + "$");
                    System.out.println();
                    System.out.println("Presupuesto restante: "+huesped.getPresupuesto());
                    System.out.println();
                    System.out.println("---ESTADO ACTUALIZADO DE HABITACIONES");
                    System.out.println(habitacion100.toString());
                    System.out.println();
                    System.out.println(habitacion204.toString());
                    System.out.println();
                    System.out.println(habitacion230.toString());
                    System.out.println();
                    System.out.println(habitacion250.toString());
                    System.out.println();
                    System.out.println(habitacion320.toString());
                    System.out.println();
                    System.out.println(habitacion487.toString());
                    System.out.println();
                    for (int i = 1; i <= noches; i++) {
                        System.out.println("Ha pasado la noche " + i + " de " + noches + " noches");
                    }
                    habitacionElegida.setDisponible(true);
                    System.out.println();
                    System.out.println("El huesped " + huesped.nombreCompleto() + " ha completado su estadia");
                    System.out.println("La habitacion " + habitacionElegida.getNumero() + " esta nuevamente disponible");
                } else {
                    System.out.println("No se puede realizar la reserva. El huesped no tiene suficiente presupuesto.");
                    System.out.println("Presupuesto actual: "+huesped.getPresupuesto()+"$");
                    System.out.println("Costo de la reserva: "+total+"$");
                }
            } else {
                if (!huesped.esMayorDeEdad()) {
                    System.out.println("No se puede realizar la reserva. El huesped debe ser mayor de edad.");
                } else if (!habitacionElegida.isDisponible()) {
                    System.out.println("No se puede realizar la reserva. La habitacion no esta disponible.");
                }
            }
            System.out.println();
            System.out.println("---ESTADO ACTUALIZADO DE HABITACIONES");
            System.out.println(habitacion100.toString());
            System.out.println();
            System.out.println(habitacion204.toString());
            System.out.println();
            System.out.println(habitacion230.toString());
            System.out.println();
            System.out.println(habitacion250.toString());
            System.out.println();
            System.out.println(habitacion320.toString());
            System.out.println();
            System.out.println(habitacion487.toString());

            System.out.print("Desea realizar otra reserva? [s/n]: ");
            String respuesta = sc.nextLine();
            char respuesta1 = respuesta.charAt(0);
            if (respuesta1 == 'n' || respuesta1 == 'N') {
                continuarReservando = false;
                System.out.println("Gracias por hospedarse en nuestro hotel. Vuelva pronto!");
            }
        }
    }
}
