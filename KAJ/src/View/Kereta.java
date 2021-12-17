package View;

import Model.ModelKereta;

import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;

public class Kereta {
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    ModelKereta kereta = new ModelKereta();

    public Kereta() throws SQLException {
    }
    public void showKereta() throws SQLException {
        kereta.showKereta();
    }
    public void addKereta() throws SQLException {
        System.out.println("MASUKKAN DETAIL KERETA");
        System.out.print("ID Kereta : ");
        int id = sc1.nextInt();
        System.out.print("Nama Kereta : ");
        String nama = sc.nextLine();
        System.out.print("Waktu Berangkat (hh:mm:ss) : ");
        String waktu_berangkat = sc.nextLine();
        System.out.print("Waktu Tiba (hh:mm:ss) : ");
        String waktu_tiba = sc.nextLine();
        System.out.print("Harga : ");
        int harga = sc.nextInt();

        kereta.addKereta(id,nama,waktu_berangkat,waktu_tiba,harga);


    }

    public void updatenama_kereta() throws SQLException {
        System.out.println("EDIT NAMA Kereta");
        System.out.print("ID Kereta : ");
        int id = sc.nextInt();
        System.out.print("Nama : ");
        String nama = sc.next();

        kereta.Updatenama_kereta(id,nama);
    }
    public void updatewaktu_berangkat() throws SQLException {
        System.out.println("EDIT WAKTU BERANGKAT Kereta");
        System.out.print("ID Kereta : ");
        int id = sc.nextInt();
        System.out.print("Waktu Berangkat (yyy/mm/dd  hh:mm:ss) : ");
        String waktu_berangkat = sc.next();

        kereta.Updatewaktu_berangkat(id,Time.valueOf(waktu_berangkat));
    }

    public void updatewaktu_tiba() throws SQLException {
        System.out.println("EDIT WAKTU TIBA Kereta");
        System.out.print("ID Kereta : ");
        int id = sc.nextInt();
        System.out.print("Waktu Tiba (yyy/mm/dd  hh:mm:ss) : ");
        String waktu_tiba = sc.next();

        kereta.Updatewaktu_tiba(id,Time.valueOf(waktu_tiba));
    }

    public void updateHargaKereta() throws SQLException {
        System.out.println("EDIT HARGA Kereta");
        System.out.print("ID Kereta : ");
        int id = sc.nextInt();
        System.out.print("Harga : ");
        int harga = sc.nextInt();

        kereta.UpdateHargaKereta(id,harga);
    }
    public void deleteKereta() throws SQLException {
        System.out.println("HAPUS Kereta");
        System.out.print("ID Kereta : ");
        int id = sc.nextInt();
        kereta.deleteDataKereta(id);
    }
}
