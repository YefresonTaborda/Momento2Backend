package bancoBlacle.interfaces;
import bancoBlacle.model.Cuenta;

public interface ICuentaDAO {
    Cuenta buscarCuentaPorNumero(String numeroCuenta);
    void guardarCuenta(Cuenta cuenta);
}
