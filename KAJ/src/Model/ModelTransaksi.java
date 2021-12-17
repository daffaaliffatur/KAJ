package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelTransaksi extends TemplateModel{
    final String lihatTransaksi = "select * from transaksi";


    public ModelTransaksi() throws SQLException {
        super();
    }

    public void showTransaksi() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(lihatTransaksi);
        ResultSet rs = preparedStatement.executeQuery();

        System.out.println("===========================================================================================================");
        System.out.println(String.format("| %-10s | %-8s | %-15s | %-10s | %-30s |","ID Transaksi","Jumlah","Tanggal","ID Penumpang","Keterangan"));
        System.out.println("===========================================================================================================");
        int num = 1;
        while(rs.next()){
            System.out.println(String.format("| %-12d | %-8s | %-15s | %-11d | %-30s |",rs.getInt("id_transaksi"),rs.getInt("jumlah_transaksi"),rs.getDate("tanggal"),rs.getInt("id_penumpang"),rs.getString("keterangan")));
            num++;

        }
        System.out.println("===========================================================================================================");
    }
}
