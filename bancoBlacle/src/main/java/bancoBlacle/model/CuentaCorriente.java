package bancoBlacle.model;

public class CuentaCorriente extends Cuenta {
    private final double limiteSobregiro = 500000;

    public CuentaCorriente(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
    }

    @Override
    public boolean retirar(double monto) {
        if (getSaldo() + limiteSobregiro >= monto) {
            depositar(-monto);
            return true;
        }
        return false;
    }
}
