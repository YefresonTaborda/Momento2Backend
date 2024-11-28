package bancoBlacle.dao;

import bancoBlacle.db.Database;
import bancoBlacle.interfaces.IClienteDAO;
import bancoBlacle.model.Cliente;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Cliente buscarClientePorId(String id) {
        return Database.clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        Database.clientes.add(cliente);
    }
}
