package MainBanco;

import java.util.HashMap;
import java.util.Map;


public class Banco {
    // Se crea un mapa donde se guardan las cuentas
    // las cuales se guardan por el numero de cuenta.
    private Map<Integer, Cuenta> cuentas = new HashMap<>();

    // Crea un metodo donde se recibe el numero de
    // la cuenta con su saldo inicial y se cre a un pin asociado.
    public void crearCuenta(int numeroCuenta, double saldoInicial, int pin) {
        //El nuevo objeto Cuenta es el valor.
        // El objeto Cuenta se inicializa con el PIN y el saldo inicial.
        cuentas.put(numeroCuenta, new Cuenta(pin, saldoInicial));

        // Imprime un mensaje para confirmar la creación de la cuenta con el número asignado.
        System.out.println("Cuenta creada con éxito. Número de cuenta: " + numeroCuenta);
    }


    // Metodo para obtener una objeto existente(cuenta)
    // donde recibe el número de la cuenta
    // y el PIN como parámetros para validar el acceso.
    public Cuenta obtenerCuenta(int numeroCuenta, int pin) {
        // Busca el objeto (cuenta) con los parametros numero de cuenta y el pin para ingresar.
        Cuenta cuenta = cuentas.get(numeroCuenta);

        // Verifica si la cuenta existe y si el PIN proporcionado es correcto.
        if (cuenta != null && cuenta.validarPin(pin)) {
            // Si la cuenta existe y el PIN es correcto, devuelve el objeto Cuenta.
            return cuenta;
        } else {
            // Si no se encuentra la cuenta o el PIN es incorrecto, imprime un mensaje de error
            // y devuelve null.
            System.out.println("Número de cuenta no existente o PIN incorrecto.");
            return null;
        }
    }
}
