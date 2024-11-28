package bancoBlacle.service;

import bancoBlacle.dao.CuentaDAO;
import bancoBlacle.model.Cuenta;

public class CuentaService {
    private final CuentaDAO cuentaDAO = new CuentaDAO();

    public Cuenta buscarCuenta(String numeroCuenta) {
        return cuentaDAO.buscarCuentaPorNumero(numeroCuenta);
    }

    public void depositar(String numeroCuenta, double monto) {
        Cuenta cuenta = cuentaDAO.buscarCuentaPorNumero(numeroCuenta);
        if (cuenta != null) {
            cuenta.depositar(monto);
        }
    }

    public boolean retirar(String numeroCuenta, double monto) {
        Cuenta cuenta = cuentaDAO.buscarCuentaPorNumero(numeroCuenta);
        if (cuenta != null) {
            return cuenta.retirar(monto);
        }
        return false;
    }
}
