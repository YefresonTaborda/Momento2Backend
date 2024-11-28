package bancoBlacle.interfaces;

import bancoBlacle.model.Cliente;

public interface IClienteDAO {
    Cliente buscarClientePorId(String id);
    void guardarCliente(Cliente cliente);
}
