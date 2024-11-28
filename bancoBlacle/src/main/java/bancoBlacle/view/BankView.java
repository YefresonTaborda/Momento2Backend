package view;

import bancoBlacle.service.ClienteService;
import bancoBlacle.service.CuentaService;
import bancoBlacle.model.Cliente;

import java.util.Scanner;

public class BankView {
    private final CuentaService cuentaService = new CuentaService();
    private final ClienteService clienteService = new ClienteService();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.println("¡Bienvenido al Banco Virtual!");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Gestionar Clientes");
        System.out.println("2. Operaciones Bancarias");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (opcion == 1) {
            gestionarClientes();
        } else if (opcion == 2) {
            operacionesBancarias();
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private void gestionarClientes() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Buscar Cliente");
        System.out.println("3. Actualizar Cliente");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1 -> registrarCliente();
            case 2 -> buscarCliente();
            case 3 -> actualizarCliente();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void registrarCliente() {
        System.out.println("Ingrese el ID del cliente:");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese la dirección:");
        String direccion = scanner.nextLine();

        clienteService.registrarCliente(id, nombre, apellido, direccion);
        System.out.println("Cliente registrado exitosamente.");
    }

    private void buscarCliente() {
        System.out.println("Ingrese el ID del cliente:");
        String id = scanner.nextLine();

        Cliente cliente = clienteService.buscarCliente(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombre());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private void actualizarCliente() {
        System.out.println("Ingrese el ID del cliente a actualizar:");
        String id = scanner.nextLine();

        Cliente cliente = clienteService.buscarCliente(id);
        if (cliente != null) {
            System.out.println("Ingrese el nuevo nombre:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el nuevo apellido:");
            String apellido = scanner.nextLine();
            System.out.println("Ingrese la nueva dirección:");
            String direccion = scanner.nextLine();

            boolean actualizado = clienteService.actualizarCliente(id, nombre, apellido, direccion);
            if (actualizado) {
                System.out.println("Cliente actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el cliente.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private void operacionesBancarias() {
        System.out.println("Ingrese el número de cuenta:");
        String numeroCuenta = scanner.nextLine();

        System.out.println("Seleccione una operación:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> {
                double saldo = cuentaService.buscarCuenta(numeroCuenta).getSaldo();
                System.out.println("Saldo actual: " + saldo);
            }
            case 2 -> {
                System.out.println("Ingrese el monto a depositar:");
                double monto = scanner.nextDouble();
                cuentaService.depositar(numeroCuenta, monto);
                System.out.println("Depósito exitoso.");
            }
            case 3 -> {
                System.out.println("Ingrese el monto a retirar:");
                double monto = scanner.nextDouble();
                if (cuentaService.retirar(numeroCuenta, monto)) {
                    System.out.println("Retiro exitoso.");
                } else {
                    System.out.println("Fondos insuficientes.");
                }
            }
        }
    }
}
