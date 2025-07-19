package project_mahabub;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connectDB() {
        try {
            // ✅ For MySQL Connector 5.1.49
            Class.forName("com.mysql.jdbc.Driver");

            // ✅ Connect to 'tome' database using root and empty password
            Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tome", "root", ""
            );

            return connect;

        } catch (Exception e) {
            System.out.println("❌ Database Connection Failed!");
            e.printStackTrace(); // Print the real error in the console
            return null;
        }
    }
}
