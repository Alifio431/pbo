import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi{
    private static koneksi instance = new koneksi();
    private static Connection conn;

    public static Connection getConnection() {
        return conn;
    }

    public static koneksi getKoneksi() {
        return instance;
    }

    public koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tas", "root", "");
            System.out.println("koneksi ke database berhasil!");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("koneksi gagal: " + e.getMessage());
        }
    }
}