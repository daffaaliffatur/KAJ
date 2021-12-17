package View;

import Model.ModelTransaksi;

import java.sql.SQLException;

public class Transaksi {
    ModelTransaksi transaksi = new ModelTransaksi();

    public Transaksi() throws SQLException {
    }

    public void showTransaksi() throws SQLException {
        transaksi.showTransaksi();
    }
}
