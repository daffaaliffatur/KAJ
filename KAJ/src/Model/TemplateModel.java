package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TemplateModel {
    protected String dbUrl;
    protected String dbPassword;
    protected String dbUser;
    protected Connection connection;

    public TemplateModel() throws SQLException {
        dbUrl = "jdbc:postgresql://localhost/KAJ";
        dbUser = "postgres";
        dbPassword = "123";
        connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
    }
}
