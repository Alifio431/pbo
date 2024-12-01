import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tas";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "";

        public boolean checkCredentials(String username, String password) {
            String query = "SELECT * FROM user_info WHERE username = ? AND password = ?";

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                // Set the parameters for the query
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // If the result set is not empty, the user credentials are valid
                return resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
                return false; // Return false if there is an exception
            }
        }
}
