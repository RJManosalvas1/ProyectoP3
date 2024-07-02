package MainBanco;

public class Saldos {
    // Campo privado que almacena el saldo actual de la cuenta.
    private double saldo;

    // Metodo público que devuelve el saldo actual de la cuenta.
    // Este método permite a otras clases obtener el valor del saldo sin modificarlo directamente.
    public double getSaldo() {
        return saldo;
    }

    // Metodo público que establece el saldo de la cuenta.
    // Este método permite a otras clases modificar el saldo directamente.
    public void setSaldo(double saldo) {
        this.saldo = saldo;  // Asigna el valor del saldo proporcionado al campo saldo de la clase.
    }

    // Metodo para depositar un monto en la cuenta.
    // Añade el monto proporcionado al saldo actual y luego imprime el nuevo saldo.
    public void depositar(double monto) {
        this.saldo += monto;  // Incrementa el saldo por el monto especificado.
        System.out.println("Depósito de " + monto + " realizado. Saldo actual: " + saldo);
    }

    // Metodo para retirar un monto de la cuenta.
    // Verifica primero si hay suficientes fondos en la cuenta para cubrir el retiro.
    // Si hay suficientes fondos, reduce el saldo por el monto del retiro y devuelve true.
    // Si no hay suficientes fondos, imprime un mensaje de error y devuelve false.
    public boolean retirar(double monto) {
        if (monto <= saldo) {  // Comprueba si el saldo es suficiente para cubrir el retiro.
            this.saldo -= monto;  // Reduce el monto del saldo.
            System.out.println("Retiro de " + monto + " realizado. Saldo actual: " + saldo);
            return true;  // Retorno verdadero indicando que el retiro fue exitoso.
        } else {
            System.out.println("Fondos insuficientes para retirar " + monto);
            return false;  // Retorno falso indicando que el retiro no pudo realizarse por falta de fondos.
        }
    }
}
