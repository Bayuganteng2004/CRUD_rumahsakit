import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasienCRUD {

    public void tambahPasien(String nama, int umur, String alamat) {
        String sql = "INSERT INTO pasien (nama, umur, alamat) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nama);
            stmt.setInt(2, umur);
            stmt.setString(3, alamat);
            stmt.executeUpdate();
            System.out.println("Pasien berhasil ditambahkan.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ubahPasien(int id, String nama, int umur, String alamat) {
        String sql = "UPDATE pasien SET nama = ?, umur = ?, alamat = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nama);
            stmt.setInt(2, umur);
            stmt.setString(3, alamat);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Data pasien berhasil diubah.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapusPasien(int id) {
        String sql = "DELETE FROM pasien WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Data pasien berhasil dihapus.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> tampilkanPasien() {
        List<String> pasienList = new ArrayList<>();
        String sql = "SELECT * FROM pasien";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String pasien = "ID: " + rs.getInt("id") + ", Nama: " + rs.getString("nama") +
                                ", Umur: " + rs.getInt("umur") + ", Alamat: " + rs.getString("alamat");
                pasienList.add(pasien);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pasienList;
    }
}
