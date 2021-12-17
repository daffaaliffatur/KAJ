import View.*;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws SQLException {
        Kereta kereta = new Kereta();
        Pemesanan pemesanan = new Pemesanan();
        Penumpang penumpang = new Penumpang();
        Perjalanan perjalanan = new Perjalanan();
        Transaksi transaksi = new Transaksi();
        boolean play = true;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        while(play){
            try{
                System.out.println("============================");
                System.out.println("  SELAMAT DATANG DI KAJ");
                System.out.println("           KERETA API JEMBER");
                System.out.println("============================");
                System.out.println("1. Lihat Kereta\n2. Kelola Kereta\n3. Lihat Pemesanan\n4. Kelola Pemesanan\n5. Lihat Penumpang\n6. Lihat Perjalanan\n7. Kelola Perjalanan\n8. Riwayat Transaksi\n9. Keluar");
                System.out.print("Pilih menu :");
                int pilih = sc.nextInt();
                if(pilih==1){
                    kereta.showKereta();
                    System.out.println("Enter untuk lanjut ..");
                    sc1.nextLine();

                }else if(pilih==2){
                    System.out.println("KELOLA KERETA");
                    System.out.println("1. Tambah Kereta\n2. Update Kereta\n3. Hapus Kereta");
                    System.out.print("Pilihan : ");
                    int kelola = sc.nextInt();
                    if(kelola==1){
                        kereta.addKereta();
                    }else if(kelola==2){
                        System.out.println("1. Update Nama\n2. Update Waktu Berangkat\n3. Update Waktu Tiba\n4. Update harga");
                        System.out.print("Pilihan : ");
                        int update = sc.nextInt();
                        if(update==1){
                            kereta.showKereta();
                            kereta.updatenama_kereta();
                        }else if(update==2){
                            kereta.showKereta();
                            kereta.updatewaktu_berangkat();
                        }else if(update==3){
                            kereta.showKereta();
                            kereta.updatewaktu_tiba();
                        }else if(update==4){
                            kereta.showKereta();
                            kereta.updateHargaKereta();
                        }


                    }else if(kelola==3){
                        kereta.showKereta();
                        kereta.deleteKereta();
                    }

                }else if(pilih==3){
                    pemesanan.showPemesanan();
                    System.out.println("Enter untuk lanjut ..");
                    sc1.nextLine();

                }else if(pilih==4){
                    System.out.println("KELOLA PEMESANAN");
                    System.out.println("1. Tambah Pemesanan\n2. Update Pemesanan");
                    System.out.print("Pilihan : ");
                    int kelola = sc.nextInt();
                    if(kelola==1){
                        pemesanan.addPemesanan();
                    }else if(kelola==2){
                        pemesanan.updatePemesanan();
                    }

                }else if(pilih==5){
                    penumpang.showPenumpang();
                    System.out.println("Enter untuk lanjut ..");
                    sc1.nextLine();

                }else if(pilih==6){
                    perjalanan.showPerjalanan();
                    System.out.println("Enter untuk lanjut ..");
                    sc1.nextLine();

                }else if(pilih==7){
                    System.out.println("KELOLA PERJALANAN");
                    System.out.println("1. Tambah Perjalanan\n2. Update Perjalanan");
                    System.out.print("Pilihan : ");
                    int kelola = sc.nextInt();
                    if(kelola==1){
                        perjalanan.addPerjalanan();
                    }else if(kelola==2){
                        perjalanan.updatePerjalanan();
                    }

                }else if(pilih==8){
                    transaksi.showTransaksi();
                    System.out.println("Enter untuk lanjut ..");
                    sc1.nextLine();

                }else if(pilih==9){
                    play=false;

                }


            }catch (InputMismatchException e){
                System.out.println("Mohon maaf inputan salah");
                break;

            }
        }

    }

}
