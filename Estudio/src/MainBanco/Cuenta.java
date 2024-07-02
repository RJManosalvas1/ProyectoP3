package MainBanco;

public class Cuenta {
    // Campo privado que almacena el PIN.
    private int pin;

    // Campo privado que referencia un objeto Saldos.
    // donde la Cuenta contiene y gestiona un objeto Saldos.
    private Saldos saldos;

    // Constructor de la clase Cuenta donde
    // se inicializa con un PIN y un saldo inicial.
    public Cuenta(int pin, double saldoInicial) {
        this.pin = pin;  // Asigna el PIN a la cuenta.
        this.saldos = new Saldos();  // Crea un nuevo objeto Saldos.
        this.saldos.setSaldo(saldoInicial);  // Establece el saldo inicial del objeto Saldos.
    }

    // Metodo para validar el PIN ingresado.
    // Devuelve true si el PIN es correcto
    // o false si es incorrecto.
    public boolean validarPin(int pinIngresado) {
        return this.pin == pinIngresado;
    }

    // Metodo para depositar un monto en la cuenta.
    public void depositar(double monto) {
        saldos.depositar(monto);  // Llama al metodo depositar del objeto Saldos.
    }

    // Metodo para retirar un monto de la cuenta.
    // Devuelve true si la operación fue exitosa,
    // es decir, si había suficientes fondos.
    // Devuelve false si los fondos son insuficientes.
    public boolean retirar(double monto) {
        return saldos.retirar(monto);  // Llama al metodo retirar del objeto Saldos.
    }

    // Metodo para imprimir el saldo actual de la cuenta.
    // Obtiene el saldo del objeto Saldos y lo imprime.
    public void verSaldo() {
        System.out.println("Saldo actual: " + saldos.getSaldo());
    }
}
