package Model;

import java.sql.*;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class ModelKereta extends TemplateModel {
    final String lihatKereta = "select * from kereta";
    final String tambahKereta = "insert into kereta (id_kereta,nama_kereta,waktu_berangkat,waktu_tiba,harga) values (?,?,?,?,?)";
    final String updatenama_kereta = "update kereta set nama_kereta = ? where id_kereta = ?";
    final String updatewaktu_berangkat = "update kereta set waktu_berangkat = ? where id_kereta";
    final String updatewaktu_tiba = "update kereta set waktu_tiba = ? where id_kereta";
    final String updateHargaKereta = "update kereta set harga = ? where id_kereta = ?";
    final String deleteKereta = "delete from Kereta where id_kereta = ?";

    public ModelKereta() throws SQLException {
        super();
    }

    public void showKereta() throws SQLException {
        Locale indo = new Locale("in","ID");
        Currency rupiah = Currency.getInstance(indo);
        NumberFormat format_rupiah = NumberFormat.getCurrencyInstance(indo);


        PreparedStatement preparedStatement = connection.prepareStatement(lihatKereta);
        ResultSet rs = preparedStatement.executeQuery();
        System.out.println("======================================================================================");
        System.out.println(String.format("|%-10s | %-30s | %-30s | %-30s | %-25s |","ID Kereta","Nama Kereta","Waktu Berangkat","Waktu Tiba","Harga"));
        System.out.println("======================================================================================");

        while(rs.next()){
            System.out.println(String.format("|%-10s | %-30s | %-30s | %-30s | %-25s|",rs.getString("id_kereta"),rs.getString("nama_kereta"),rs.getTime("waktu_berangkat"),rs.getTime("waktu_tiba"),format_rupiah.format(rs.getInt("harga"))));


        }
    }

    public void addKereta(int id_kereta,String nama,String waktu_berangkat,String waktu_tiba,int harga ) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(tambahKereta);

        preparedStatement.setInt(1,id_kereta);
        preparedStatement.setString(2,nama);
        preparedStatement.setTime(3, Time.valueOf(waktu_berangkat));
        preparedStatement.setTime(4, Time.valueOf(waktu_tiba));
        preparedStatement.setInt(5,harga);

        preparedStatement.executeUpdate();


    }
    //    final String updatenama_kereta = "update Kereta set nama_kereta = ? where id_kereta = ?;";
//    final String updateHargaKereta = "update Kereta set harga = ? where id_kereta = ?;";
    public void UpdateHargaKereta(int id_kereta,int harga) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(updateHargaKereta);

        preparedStatement.setInt(1,harga);
        preparedStatement.setInt(2,id_kereta);

        preparedStatement.executeUpdate();

    }

    public void Updatenama_kereta(int id_kereta,String nama) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(updatenama_kereta);

        preparedStatement.setString(1,nama);
        preparedStatement.setInt(2,id_kereta);

        preparedStatement.executeUpdate();

    }

    public void Updatewaktu_berangkat(int id_kereta,Time waktu_berangkat) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(updatewaktu_berangkat);

        preparedStatement.setTime(1,waktu_berangkat);
        preparedStatement.setInt(2,id_kereta);

        preparedStatement.executeUpdate();
    }

    public void Updatewaktu_tiba(int id_kereta,Time waktu_tiba) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(updatewaktu_tiba);

        preparedStatement.setTime(1,waktu_tiba);
        preparedStatement.setInt(2,id_kereta);

        preparedStatement.executeUpdate();


    }

    public void deleteDataKereta(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(deleteKereta);
        preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();

    }

}
