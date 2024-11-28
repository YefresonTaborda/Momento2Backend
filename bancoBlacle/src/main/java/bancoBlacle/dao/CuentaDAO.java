package bancoBlacle.dao;

import bancoBlacle.db.Database;
import bancoBlacle.interfaces.ICuentaDAO;
import bancoBlacle.model.Cuenta;

public class CuentaDAO implements ICuentaDAO {

    @Override
    public Cuenta buscarCuentaPorNumero(String numeroCuenta) {
        return Database.cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        Database.cuentas.add(cuenta);
    }
}
