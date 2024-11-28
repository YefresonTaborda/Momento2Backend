package bancoBlacle.service;

import bancoBlacle.dao.ClienteDAO;
import bancoBlacle.model.Cliente;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAO();

    /**
     * Busca un cliente por su ID.
     * @param id Identificación del cliente.
     * @return El cliente encontrado o null si no existe.
     */
    public Cliente buscarCliente(String id) {
        return clienteDAO.buscarClientePorId(id);
    }

    /**
     * Registra un nuevo cliente en el sistema.
     * @param id Identificación del cliente.
     * @param nombre Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @param direccion Dirección del cliente.
     */
    public void registrarCliente(String id, String nombre, String apellido, String direccion) {
        Cliente cliente = new Cliente(id, nombre, apellido, direccion);
        clienteDAO.guardarCliente(cliente);
    }

    /**
     * Actualiza los datos de un cliente existente.
     * @param id Identificación del cliente.
     * @param nombre Nuevo nombre del cliente.
     * @param apellido Nuevo apellido del cliente.
     * @param direccion Nueva dirección del cliente.
     * @return true si el cliente fue actualizado, false si no se encontró.
     */
    public boolean actualizarCliente(String id, String nombre, String apellido, String direccion) {
        Cliente cliente = clienteDAO.buscarClientePorId(id);
        if (cliente != null) {
            cliente = new Cliente(id, nombre, apellido, direccion);
            clienteDAO.guardarCliente(cliente); // Simula actualización sobrescribiendo.
            return true;
        }
        return false;
    }
}
