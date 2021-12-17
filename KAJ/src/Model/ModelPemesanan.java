package Model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelPemesanan extends TemplateModel{
    final String lihatPemesanan = "select * from pemesanan";
    final String tambahPemesanan = "insert into pemesanan (tanggal, id_perjalanan, nomor_kursi, nomor_gerbong, id_Penumpang) values (?,?,?,?,?)";
    final String Updatenomor_kursi = "update pemesanan set nomor_kursi  = ? where id_Pemesanan = ?";
    final String Updatenomor_gerbong = "update pemesanan set nomor_gerbong = ? where id_Pemesanan = ?";

    public ModelPemesanan() throws SQLException {
        super();
    }

    public void showPemesanan() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(lihatPemesanan);
        ResultSet rs = preparedStatement.executeQuery();

        System.out.println("===============================================================================================================================");
        System.out.println(String.format("| %-5s | %-11s | %-10s |%-11s |%-20s | %-20s | %-15s |", "No","ID Pemesanan","Tanggal","ID Perjalanan","Nomor Kursi", "Nomor Gerbong", "ID Penumpang"));
        System.out.println("===============================================================================================================================");
        int num = 1;
        while (rs.next()) {
            System.out.println(String.format("| %-5s | %-11s | %-10s |%-11s |%-20s | %-20s | %-15s |", num, rs.getInt("id_Pemesanan"), rs.getDate("tanggal"),rs.getInt("id_perjalanan"), rs.getString("nomor_kursi"), rs.getInt("nomor_gerbong"), rs.getInt("id_Penumpang")));
            num++;

        }
    }
    public void addPemesanan(Date tanggal,int id_perjalanan, String nomor_kursi, int nomor_gerbong, int id_Penumpang) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(tambahPemesanan);

        preparedStatement.setDate(1,tanggal);
        preparedStatement.setInt(2,id_perjalanan);
        preparedStatement.setString(2,nomor_kursi);
        preparedStatement.setInt(3,nomor_gerbong);
        preparedStatement.setInt(4,id_Penumpang);

        preparedStatement.executeUpdate();

    }
    public void updatenomor_kursi(String nomor_kursi,int id_Pemesanan) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(Updatenomor_kursi);

        preparedStatement.setString(1,nomor_kursi);
        preparedStatement.setInt(2,id_Pemesanan);

        preparedStatement.executeUpdate();
    }
    public void updatenomor_gerbong(int nomor_gerbong,int id_Pemesanan) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(Updatenomor_gerbong);

        preparedStatement.setInt(1,nomor_gerbong);
        preparedStatement.setInt(2,id_Pemesanan);

        preparedStatement.executeUpdate();
    }
}
