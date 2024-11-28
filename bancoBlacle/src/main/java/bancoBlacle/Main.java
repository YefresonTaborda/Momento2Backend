package bancoBlacle;

import view.BankView;
import bancoBlacle.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

/*
public class Main {
    public static void main(String[] args) {

    }
}
*/
public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        BankView bankView = new BankView();
        bankView.iniciar();
    }
}