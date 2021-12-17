package Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.sql.Date;

public class ModelPerjalanan extends TemplateModel{
    final String lihatPerjalanan = "select * from perjalanan";
    final String tambahPerjalanan = "insert into perjalanan (asal,tujuan,tanggal,id_kereta) values (?,?,?,?)";
    final String UpdateAsal = "update perjalanan set asal = ? where id_perjalanan = ?";
    final String UpdateTujuan = "update perjalanan set asal = ? where id_perjalanan = ?";
    public ModelPerjalanan() throws SQLException {
        super();
    }
    public void addPerjalanan(String asal, String tujuan, Date tanggal, int id_kereta) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(tambahPerjalanan);

        preparedStatement.setString(1,asal);
        preparedStatement.setString(2,tujuan);
        preparedStatement.setDate(3,tanggal);
        preparedStatement.setInt(4,id_kereta);

        preparedStatement.executeUpdate();

    }
    public void showPerjalanan() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(lihatPerjalanan);
        ResultSet rs = preparedStatement.executeQuery();

        System.out.println("===============================================================================================================================");
        System.out.println(String.format("| %-5s | %-11s |%-26s | %-26s | %-15s | %-10s |", "No", "ID Perjalanan", "Asal Kota", "Tujuan Kota", "Tanggal", "ID Kereta"));
        System.out.println("===============================================================================================================================");
        int num = 1;
        while (rs.next()) {
            System.out.println(String.format("| %-5s | %-11s |%-26s | %-26s | %-15s | %-10s |", num, rs.getInt("id_perjalanan"), rs.getString("asal"), rs.getString("tujuan"), rs.getDate("tanggal"), rs.getInt("id_kereta")));
            num++;

        }
    }

    public void updateAsal(String asal,int id_perjalanan) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UpdateAsal);

        preparedStatement.setString(1,asal);
        preparedStatement.setInt(2,id_perjalanan);

        preparedStatement.executeUpdate();
    }
    public void updateTujuan(String tujuan,int id_perjalanan) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UpdateTujuan);

        preparedStatement.setString(1,tujuan);
        preparedStatement.setInt(2,id_perjalanan);

        preparedStatement.executeUpdate();
    }
}
