import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasienCRUD pasienCRUD = new PasienCRUD();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Informasi Rumah Sakit ===");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Ubah Data Pasien");
            System.out.println("3. Hapus Data Pasien");
            System.out.println("4. Tampilkan Daftar Pasien");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan umur: ");
                    int umur = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Masukkan alamat: ");
                    String alamat = scanner.nextLine();
                    pasienCRUD.tambahPasien(nama, umur, alamat);
                    break;
                case 2:
                    System.out.print("Masukkan ID pasien yang ingin diubah: ");
                    int idUbah = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan umur baru: ");
                    int umurBaru = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Masukkan alamat baru: ");
                    String alamatBaru = scanner.nextLine();
                    pasienCRUD.ubahPasien(idUbah, namaBaru, umurBaru, alamatBaru);
                    break;
                case 3:
                    System.out.print("Masukkan ID pasien yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    pasienCRUD.hapusPasien(idHapus);
                    break;
                case 4:
                    List<String> pasienList = pasienCRUD.tampilkanPasien();
                    System.out.println("\nDaftar Pasien:");
                    for (String pasien : pasienList) {
                        System.out.println(pasien);
                    }
                    break;
                case 5:
                    System.out.println("Keluar dari sistem. Terima kasih.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
