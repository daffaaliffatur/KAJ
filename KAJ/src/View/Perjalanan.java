package View;

import Model.ModelPerjalanan;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Perjalanan {
    Scanner sc = new Scanner(System.in);
    ModelPerjalanan perjalanan = new ModelPerjalanan();

    public Perjalanan() throws SQLException {
    }
    public void addPerjalanan() throws SQLException {
        System.out.print("Asal Kota : ");
        String asal = sc.nextLine();
        System.out.print("Tujuan Kota : ");
        String tujuan = sc.nextLine();
        System.out.print("Tanggal (yyyy-mm-dd) : ");
        Date tanggal = Date.valueOf(sc.nextLine());
        System.out.print("ID Kereta : ");
        int id_kereta =  sc.nextInt();

        perjalanan.addPerjalanan(asal,tujuan,tanggal,id_kereta);
    }
    public void showPerjalanan() throws SQLException {
        perjalanan.showPerjalanan();
    }
    public void updatePerjalanan() throws SQLException {
        System.out.println("PILIH UPDATE");
        System.out.println("1. Asal\n2. Tujuan");
        System.out.print("Pilih : ");
        int pilihan = sc.nextInt();

        if(pilihan==1){
            Scanner sc1 = new Scanner(System.in);
            System.out.print("ID Perjalanan : ");
            int id = sc.nextInt();
            System.out.print("Asal Kota : ");
            String asal = sc1.nextLine();
            perjalanan.updateAsal(asal,id);
        } else if (pilihan==2){
            Scanner sc1 = new Scanner(System.in);
            System.out.print("ID Perjalanan : ");
            int id = sc.nextInt();
            System.out.print("Tujuan Kota : ");
            String tujuan = sc1.nextLine();
            perjalanan.updateTujuan(tujuan,id);
        }


    }
}
