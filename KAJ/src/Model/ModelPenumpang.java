package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelPenumpang extends TemplateModel{
    final String lihatPenumpang = "select * from penumpang ";
    public ModelPenumpang() throws SQLException {
        super();
    }

    public void showPenumpang() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(lihatPenumpang);
        ResultSet rs = preparedStatement.executeQuery();

        System.out.println("==============================================================================================");
        System.out.printf("|%-5s | %-30s | %-50s |%n","No","ID Pegawai","Nama Pegawai");
        System.out.println("==============================================================================================");
        int num = 1;
        while(rs.next()){
            System.out.printf("|%-5d | %-30s | %-50s |%n",num,String.valueOf(rs.getInt("id_Penumpang")),rs.getString("nama_Penumpang"));
            num++;

        }
    }

}
