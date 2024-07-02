package MainBanco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();
        int opcion;


        //Opciones de creacion o acceso a una cuenta con un do
        do {
            System.out.println("\nOpciones:");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Acceder a cuenta existente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            //Switch para creacion, ingreso o salida del programa
            switch (opcion) {
                //Opcion de creacion de cuenta con un pin
                case 1:
                    System.out.print("Ingrese nuevo número de cuenta: ");
                    int numeroCuenta = sc.nextInt();
                    System.out.print("Cree un PIN de 4 dígitos para la cuenta: ");
                    int pin = sc.nextInt();
                    banco.crearCuenta(numeroCuenta, 0, pin);
                    break;
                    //Opcion de ingreso a la cuenta con su pin
                case 2:
                    System.out.print("Ingrese el número de cuenta: ");
                    int numCuenta = sc.nextInt();
                    System.out.print("Ingrese el PIN de la cuenta: ");
                    int pinIngresado = sc.nextInt();
                    Cuenta cuenta = banco.obtenerCuenta(numCuenta, pinIngresado);
                    if (cuenta != null) {
                        realizarOperaciones(sc, cuenta);
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (opcion != 3);

        sc.close();
    }
    //Metodo para realizar operiaciones dentro de las cuentas
    private static void realizarOperaciones(Scanner sc, Cuenta cuenta) {
        int opcion;
        do {
            System.out.println("\nOpciones de cuenta:");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Ver saldo");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese monto a depositar: ");
                    double deposito = sc.nextDouble();
                    cuenta.depositar(deposito);
                    break;
                case 2:
                    System.out.print("Ingrese monto a retirar: ");
                    double retiro = sc.nextDouble();
                    if (cuenta.retirar(retiro)) {
                        System.out.println("Retiro exitoso.");
                    } else {
                        System.out.println("No se pudo realizar el retiro.");
                    }
                    break;
                case 3:
                    cuenta.verSaldo();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (opcion != 4);
    }
}
