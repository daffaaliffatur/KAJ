package View;

import Model.ModelPemesanan;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Pemesanan {
    Scanner sc = new Scanner(System.in);
    ModelPemesanan Pemesanan = new ModelPemesanan();

    public Pemesanan() throws SQLException {
    }
    public void addPemesanan() throws SQLException {
        System.out.print("Tanggal (yyyy-mm-dd) : ");
        Date tanggal = Date.valueOf(sc.nextLine());
        System.out.print("ID Perjalanan: ");
        int id_perjalanan = sc.nextInt();
        System.out.print("Nomor Kursi : ");
        String nomor_kursi = sc.nextLine();
        System.out.print("Nomor Gerbong : ");
        int nomor_gerbong =  sc.nextInt();
        System.out.print("ID Penumpang : ");
        int id_penumpang = sc.nextInt();


        Pemesanan.addPemesanan(tanggal,id_perjalanan,nomor_kursi,nomor_gerbong,id_penumpang);
    }
    public void showPemesanan() throws SQLException {
        Pemesanan.showPemesanan();
    }
    public void updatePemesanan() throws SQLException {
        System.out.println("PILIH UPDATE");
        System.out.println("1. Nomor Kursi\n2. Nomor Gerbong");
        System.out.print("Pilih : ");
        int pilihan = sc.nextInt();

        if(pilihan==1){
            Scanner sc1 = new Scanner(System.in);
            System.out.print("ID Pemesanan : ");
            int id = sc.nextInt();
            System.out.print("Nomor Kursi : ");
            String nomor_kursi = sc1.nextLine();
            Pemesanan.updatenomor_kursi(nomor_kursi,id);
        } else if (pilihan==2){
            Scanner sc1 = new Scanner(System.in);
            System.out.print("ID Pemesanan : ");
            int id = sc.nextInt();
            System.out.print("Nomor Gerbong : ");
            int nomor_gerbong = sc1.nextInt();
            Pemesanan.updatenomor_gerbong(nomor_gerbong,id);
        }


    }
}
