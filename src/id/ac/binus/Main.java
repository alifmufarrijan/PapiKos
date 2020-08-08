package id.ac.binus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<Kos> arKos = new ArrayList<>();
    private static List<Daerah> arDaerah = new ArrayList<>();
    private static List<Pelanggan> arPelanggan = new ArrayList<>();
    private static List<Transaksi> arTransaksi = new ArrayList<>();
    private static List<Kamar> arKamar = new ArrayList<>();
    private static List<String> listIdAuto = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static String[] args = {};
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        // write your code here
        InitializeData();
        mainMenu();
    }

    private static void mainMenu() {
        String pilihan = "";
        setIDAutomatic();
        showHeader();
        showMenu();
        System.out.print("Masukkan pilihan Anda : ");
        while (!input.hasNext("[123456]")) {
            System.out.println("Pilihan Anda salah!");
            input.nextLine();
        }
        pilihan = input.nextLine();
        switch (pilihan) {
            case "1":
                kelolaKos();
                break;
            case "2":
                kelolaDaerah();
                break;
            case "3":
                kelolaPelanggan();
                break;
            case "4":
                transaksiPembelian();
                mainMenu();
                break;
            case "5":
                menuReport();
                break;
            case "6":
                System.out.println("==== Terima kasih! Semoga Anda sehat selalu! ====");
                System.out.println("====         Copyright : Team 4 DYBA         ====");
                System.out.println("=================================================");
                break;
            default:
                mainMenu();
                break;
        }
    }

    private static void showHeader() {
        System.out.println("===================================================");
        System.out.println("     Aplikasi PapiKos Team 4 - BOL 2020 DYBA     ");
        System.out.println("===================================================");
    }

    //method Get menu
    private static int getMenu(int menu) {
        boolean isvalid;
        do {
            try {
                System.out.print("Masukkan Pilihan Anda : ");
                menu = Integer.parseInt(input.nextLine());
                isvalid = true;
            } catch (Exception e) {
                System.out.println("Mohon masukkan pilihan yang sesuai!");
                isvalid = false;
            }
        } while (!isvalid);
        return menu;
    }

    //Show Menu Utama
    private static void showMenu() {
        System.out.println("Menu Utama");
        System.out.println("1. Kelola Kos");
        System.out.println("2. Kelola Daerah");
        System.out.println("3. Kelola Pelanggan");
        System.out.println("4. Transaksi Penyewaan");
        System.out.println("5. Laporan Transaksi");
        System.out.println("6. Keluar");
    }

    //Kumpulan Method Show Menu
    private static void showKelolaKos() {
        System.out.println("Kelola Kos");
        System.out.println("1. Tambah Kos");
        System.out.println("2. Lihat Kos");
        System.out.println("3. Ubah Kos");
        System.out.println("4. Hapus Kos");
        System.out.println("5. Kembali");
    }

    private static void showKelolaDaerah() {
        System.out.println("Kelola Daerah");
        System.out.println("1. Tambah Daerah");
        System.out.println("2. Lihat Daerah");
        System.out.println("3. Ubah Daerah");
        System.out.println("4. Hapus Daerah");
        System.out.println("5. Kembali");
    }

    private static void showKelolaPelanggan() {
        System.out.println("Kelola Pelanggan");
        System.out.println("1. Tambah Pelanggan");
        System.out.println("2. Lihat Pelanggan");
        System.out.println("3. Ubah Pelanggan");
        System.out.println("4. Hapus Pelanggan");
        System.out.println("5. Kembali");
    }

    //Kumpulan Method Main
    private static void kelolaDaerah() {
        boolean stop = false;
        int menu = 0;

        showKelolaDaerah();
        menu = getMenu(menu);
        switch (menu) {
            case 1:
                addDaerah();
                kelolaDaerah();
                break;
            case 2:
                showAllDaerah();
                kelolaDaerah();
                break;
            case 3:
                updateDaerah();
                kelolaDaerah();
                break;
            case 4:
                deleteDaerah();
                kelolaDaerah();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Mohon masukkan pilihan yang sesuai!");
                kelolaDaerah();
                break;
        }
    }

    private static void kelolaKos() {
        boolean valid = true;
        boolean stop = false;
        int pilihan = 0;

        showKelolaKos();
        pilihan = getMenu(pilihan);

        switch (pilihan) {
            case 1:
                addKos();
                kelolaKos();
                break;
            case 2:
                showAllKos();
                kelolaKos();
                break;
            case 3:
                updateKos();
                kelolaKos();
                break;
            case 4:
                deleteKos();
                kelolaKos();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Mohon masukkan pilihan yang sesuai!");
                kelolaKos();
                break;
        }
    }

    private static void kelolaPelanggan() {
        boolean valid = true;
        boolean stop = false;
        int pilihan = 0;

        showKelolaPelanggan();
        pilihan = getMenu(pilihan);

        switch (pilihan) {
            case 1:
                addPelanggan();
                kelolaPelanggan();
                break;
            case 2:
                showAllPelanggan();
                kelolaPelanggan();
                break;
            case 3:
                updatePelanggan();
                kelolaPelanggan();
                break;
            case 4:
                deletePelanggan();
                kelolaPelanggan();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Mohon masukkan pilihan yang sesuai!");
                kelolaPelanggan();
                break;
        }
    }

    //Kumpulan Method Add Data
    private static void addKos() {
        String id = "";
        String nama = "";
        String alamat = "";
        float harga = 0;
        String fasilitas = "";
        String daerah = "";
        int jmlKamar = 0;
        boolean isValid = true;

        setIDAutomatic();
        id = getIDAutomatic(listIdAuto.get(0));
        System.out.println("=== Tambah Kos ===");
        System.out.println("ID Kos : " + id);
        System.out.print("Nama Kos : ");
        nama = input.nextLine();
        System.out.print("Alamat Kos : ");
        alamat = input.nextLine();
        showAllDaerah();
        do {
            System.out.print("Masukkan Daerah Kos : ");
            daerah = input.nextLine();
            for (Daerah data : arDaerah) {
                if (data.getNamaDaerah().equalsIgnoreCase(daerah) || data.getIdDaerah().equalsIgnoreCase(daerah)) {
                    daerah = data.getNamaDaerah();
                    isValid = true;
                }
            }
            if (!isValid) {
                System.out.println("Daerah tidak ditemukan!");
            }
        } while (!isValid);
        do {
            try {
                System.out.print("Harga Sewa Bulanan : ");
                harga = input.nextInt();
                isValid = true;
            } catch (Exception ex) {
                System.out.println("harga tidak valid!");
                input.nextLine();
                isValid = false;
            }
        } while (!isValid);

        do {
            try {
                System.out.print("Jumlah Kamar : ");
                jmlKamar = input.nextInt();
                isValid = true;
            } catch (Exception ex) {
                System.out.println("Jumlah Kamar tidak valid!");
                input.nextLine();
                isValid = false;
            }
        } while (!isValid);
        input.nextLine();


        System.out.print("Fasilitas : ");
        fasilitas = input.nextLine();

        Kos kos = new Kos(id, nama, alamat, harga, fasilitas, daerah, jmlKamar);
        System.out.println("Data Kos yang akan Anda tambahkan :");
        showKos(kos);
        System.out.print("Apakah ingin menyimpan data? (Y/N) : ");
        while (!input.hasNext("[YyNn]")) {
            System.out.println("Pilihan hanya bisa Y atau N");
            input.nextLine();
        }
        String saved = input.nextLine();
        if (saved.equalsIgnoreCase("Y")) {
            arKos.add(kos);
            System.out.println("Kos berhasil ditambahkan!");
        } else {
            System.out.println("Kos gagal ditambahkan!");
        }
    }

    private static void addDaerah() {
        String id = "";
        String nama = "";

        boolean isValid = true;

        setIDAutomatic();
        id = getIDAutomatic(listIdAuto.get(1));
        System.out.println("=== Tambah Daerah ===");
        System.out.println("ID Daerah : " + id);
        System.out.print("Nama Daerah : ");
        nama = input.nextLine();
        Daerah gnr = new Daerah(id, nama);
        System.out.println("Data Daerah yang akan Anda tambahkan :");
        showDaerah(gnr);
        System.out.print("Apakah ingin menyimpan data? (Y/N) : ");
        while (!input.hasNext("[YyNn]")) {
            System.out.println("Pilihan hanya bisa Y atau N");
            input.nextLine();
        }
        String saved = input.nextLine();
        if (saved.equalsIgnoreCase("Y")) {
            arDaerah.add(gnr);
            System.out.println("Daerah berhasil ditambahkan!");
        } else {
            System.out.println("Daerah gagal ditambahkan!");
        }
    }

    private static void addPelanggan() {
        String id = "";
        String nama = "";
        String alamat = "";
        String noHP = "";
        String email = "";
        String strTanggal = "";
        Date tglLahir = new Date();
        double rating = 0;
        boolean isValid = true;

        setIDAutomatic();
        id = getIDAutomatic(listIdAuto.get(2));
        System.out.println("=== Tambah Pelanggan ===");
        System.out.println("ID Pelanggan : " + id);
        System.out.print("Nama Pelanggan : ");
        nama = input.nextLine();
        System.out.print("Alamat : ");
        alamat = input.nextLine();
        do {
            System.out.print("Nomor HP (Hanya Angka): ");
            noHP = input.nextLine();
        } while (!noHP.matches("[0-9]+"));
        System.out.print("Email : ");
        email = input.nextLine();
        do {
            try {
                System.out.print("Tanggal Lahir (DD/MM/YYYY) : ");
                strTanggal = input.nextLine();
                tglLahir = new SimpleDateFormat("dd/MM/yyyy").parse(strTanggal);
                isValid = true;
            } catch (Exception ex) {
                System.out.println("Format tanggal tidak valid!");
                isValid = false;
            }
        } while (!isValid);

        Pelanggan plg = new Pelanggan(id, nama, alamat, noHP, email, tglLahir);
        System.out.println("Data Pelanggan yang akan Anda tambahkan :");
        showPelanggan(plg);
        System.out.print("Apakah ingin menyimpan data? (Y/N) : ");
        while (!input.hasNext("[YyNn]")) {
            System.out.println("Pilihan hanya bisa Y atau N");
            input.nextLine();
        }
        String saved = input.nextLine();
        if (saved.equalsIgnoreCase("Y")) {
            arPelanggan.add(plg);
            System.out.println("Pelanggan berhasil ditambahkan!");
        } else {
            System.out.println("Pelanggan gagal ditambahkan!");
        }
    }


    //Kumpulan Method show All data
    private static void showAllDaerah() {
        sort();
        String leftAlignFormat = "| %-10s | %-20s |%n";
        System.out.println("=== Data Daerah ===");
        System.out.format("+------------+----------------------+%n");
        System.out.format("| ID         | Daerah               |%n");
        System.out.format("+------------+----------------------+%n");
        for (Daerah daerah : arDaerah) {
            System.out.format(leftAlignFormat, daerah.getIdDaerah(), daerah.getNamaDaerah());
        }
        System.out.format("+------------+----------------------+%n");
    }

    private static void showAllKos() {
        sort();
        String leftAlignFormat = "| %-10s | %-40s | %-40s | %-20s | %-20s | %-10s | %-50s |%n";
        System.out.println("=== Data Kos ===");
        System.out.format("+------------+------------------------------------------+------------------------------------------+----------------------+----------------------+------------+----------------------------------------------------+%n");
        System.out.format("| ID         | Nama                                     | Alamat                                   | Daerah               | Sewa Bulanan         | Jml Kamar  | Fasilitas                                          |%n");
        System.out.format("+------------+------------------------------------------+------------------------------------------+----------------------+----------------------+------------+----------------------------------------------------|%n");
        for (Kos kos : arKos) {
            System.out.format(leftAlignFormat, kos.getIdKos(), kos.getNamaKos(), kos.getAlamatKos(), kos.getDaerah(), "Rp." + kos.getHargaSewa(), kos.getJmlKamar(), kos.getFasilitas());
        }
        System.out.format("+------------+------------------------------------------+------------------------------------------+----------------------+----------------------+------------+----------------------------------------------------|%n");
    }

    private static void showAllPelanggan() {
        sort();
        String leftAlignFormat = "| %-10s | %-30s | %-10s | %-30s | %-10s | %-30s |%n";
        System.out.println("=== Data Pelanggan ===");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+--------------+--------------------------------+%n");
        System.out.format("| ID         | Nama                           | Tgl Lahir  | Alamat                         | No HP        | Email                          |%n");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+--------------+--------------------------------+%n");
        for (Pelanggan data : arPelanggan) {
            String strTanggal = dateFormat.format(data.getTanggalLahir());
            System.out.format(leftAlignFormat, data.getIdPelanggan(), data.getNamaPelanggan(), strTanggal, data.getAlamat(), data.getNoHP(), data.getEmail());
        }
        System.out.format("+------------+--------------------------------+------------+--------------------------------+--------------+--------------------------------+%n");
    }

    private static void showAllTransaksi() {
        sort();
        long totalIncome = 0L;
        String leftAlignFormat = "| %-10s | %-30s | %-10s | %-30s | %-10s | %-30s |%n";
        String leftAlignFormat2 = "| %-103s| %-30s |%n";
        System.out.println("=== Data Transaksi ===");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
        System.out.format("| ID         | Pelanggan                      | Tgl Pesan  | Kos                            | No Kamar   | Harga                          |%n");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
        for (Transaksi data : arTransaksi) {
            String strTanggal = dateFormat.format(data.getTglTransaksi());
            long harga = (long) data.getHargaTotal();
            totalIncome = totalIncome + harga;
            System.out.format(leftAlignFormat, data.getIdTransaksi(), data.getNamaPelanggan(), strTanggal, data.getKos(), data.getNoKamar(), "Rp" + data.getHargaTotal());
        }
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
        System.out.format(leftAlignFormat2, "Total", "Rp" + totalIncome);
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
    }

    //Kumpulan Method Show Single/Filtered Data
    private static void showKos(Kos kos) {
        sort();
        String leftAlignFormat = "| %-10s | %-40s | %-40s | %-20s | %-20s | %-10s | %-50s |%n";
        System.out.println("=== Data Kos ===");
        System.out.format("+------------+------------------------------------------+------------------------------------------+----------------------+----------------------+------------+----------------------------------------------------+%n");
        System.out.format("| ID         | Nama                                     | Alamat                                   | Daerah               | Sewa Bulanan         | Jml Kamar  | Fasilitas                                          |%n");
        System.out.format("+------------+------------------------------------------+------------------------------------------+----------------------+----------------------+------------+----------------------------------------------------|%n");
        System.out.format(leftAlignFormat, kos.getIdKos(), kos.getNamaKos(), kos.getAlamatKos(), kos.getDaerah(), "Rp." + kos.getHargaSewa(), kos.getJmlKamar(), kos.getFasilitas());
        System.out.format("+------------+------------------------------------------+------------------------------------------+----------------------+----------------------+------------+----------------------------------------------------|%n");
    }

    private static void showKos(List<Kos> lsKos) {
        sort();
        String leftAlignFormat = "| %-10s | %-40s | %-40s | %-20s | %-20s | %-10s | %-50s |%n";
        System.out.println("=== Daftar Kos Yang Anda Cari ===");
        System.out.format("+------------+------------------------------------------+------------------------------------------+----------------------+----------------------+------------+----------------------------------------------------+%n");
        System.out.format("| ID         | Nama                                     | Alamat                                   | Daerah               | Sewa Bulanan         | Jml Kamar  | Fasilitas                                          |%n");
        System.out.format("+------------+------------------------------------------+------------------------------------------+----------------------+----------------------+------------+----------------------------------------------------|%n");
        for (Kos data : lsKos) {
            System.out.format(leftAlignFormat, data.getIdKos(), data.getNamaKos(), data.getAlamatKos(), data.getDaerah(), "Rp." + data.getHargaSewa(), data.getJmlKamar(), data.getFasilitas());
        }
        System.out.format("+------------+------------------------------------------+------------------------------------------+----------------------+----------------------+------------+----------------------------------------------------|%n");
    }

    private static void showDaerah(Daerah daerah) {
        String leftAlignFormat = "| %-10s | %-20s |%n";
        System.out.println("=== Data Daerah ===");
        System.out.format("+------------+----------------------+%n");
        System.out.format("| ID         | Daerah               |%n");
        System.out.format("+------------+----------------------+%n");
        System.out.format(leftAlignFormat, daerah.getIdDaerah(), daerah.getNamaDaerah());
        System.out.format("+------------+----------------------+%n");
    }

    private static void showPelanggan(Pelanggan pelanggan) {
        sort();
        String leftAlignFormat = "| %-10s | %-30s | %-10s | %-30s | %-10s | %-30s |%n";
        System.out.println("=== Data Pelanggan ===");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+--------------+--------------------------------+%n");
        System.out.format("| ID         | Nama                           | Tgl Lahir  | Alamat                         | No HP        | Email                          |%n");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+--------------+--------------------------------+%n");
        String strTanggal = dateFormat.format(pelanggan.getTanggalLahir());
        System.out.format(leftAlignFormat, pelanggan.getIdPelanggan(), pelanggan.getNamaPelanggan(), strTanggal, pelanggan.getAlamat(), pelanggan.getNoHP(), pelanggan.getEmail());
        System.out.format("+------------+--------------------------------+------------+--------------------------------+--------------+--------------------------------+%n");
    }

    private static void showTransaksi(List<Transaksi> transaksi) {
        String leftAlignFormat = "| %-10s | %-30s | %-10s | %-30s | %-10s | %-30s |%n";
        System.out.println("=== Data Transaksi ===");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
        System.out.format("| ID         | Pelanggan                      | Tgl Pesan  | Kos                            | No Kamar   | Harga                          |%n");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
        for (Transaksi data : transaksi) {
            String strTanggal = dateFormat.format(data.getTglTransaksi());
            System.out.format(leftAlignFormat, data.getIdTransaksi(), data.getNamaPelanggan(), strTanggal, data.getKos(), data.getNoKamar(), data.getHargaTotal());
        }
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
    }

    private static void showTransaksi(Transaksi data) {
        String leftAlignFormat = "| %-10s | %-30s | %-10s | %-30s | %-10s | %-30s |%n";
        System.out.println("=== Transaksi Anda ===");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
        System.out.format("| ID         | Pelanggan                      | Tgl Pesan  | Kos                            | No Kamar   | Harga                          |%n");
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
        String strTanggal = dateFormat.format(data.getTglTransaksi());
        System.out.format(leftAlignFormat, data.getIdTransaksi(), data.getNamaPelanggan(), strTanggal, data.getKos(), data.getNoKamar(), data.getHargaTotal());
        System.out.format("+------------+--------------------------------+------------+--------------------------------+------------+--------------------------------+%n");
    }

    //Kumpulan Method Updating Data
    private static void updateKos() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        String menu = "";
        String fieldBaru = "";
        int indeks = 0;
        int counter = 0;
        showAllKos();
        boolean updated = false;
        boolean cancelled = false;
        do {
            System.out.print("Masukkan ID Kos yang akan diubah : ");
            id = input.nextLine();
            for (Kos data : arKos) {
                if (data.getIdKos().equalsIgnoreCase(id)) {
                    indeks = counter;
                }
                counter++;
            }
            showKos(arKos.get(indeks));
            for (Kos data : arKos) {
                if (data.getIdKos().equals(id)) {
                    System.out.println("Apa yang akan Anda ubah?");
                    System.out.println("1. Nama Kos");
                    System.out.println("2. Alamat");
                    System.out.println("3. Daerah");
                    System.out.println("4. Harga");
                    System.out.println("5. Fasilitas");
                    System.out.println("6. Jml Kamar");
                    System.out.println("7. Kembali");
                    System.out.print("Masukkan pilihan anda : ");
                    while (!input.hasNext("[1234567]")) {
                        System.out.println("Menu yang anda masukkan salah!");
                        input.nextLine();
                    }
                    menu = input.nextLine();
                    if (menu.equalsIgnoreCase("1")) {
                        System.out.println("Nama Lama : " + data.getNamaKos());
                        System.out.print("Masukkan Nama baru : ");
                        fieldBaru = input.nextLine();
                        data.setNamaKos(fieldBaru);
                        updated = true;
                    } else if (menu.equalsIgnoreCase("2")) {
                        System.out.println("Alamat Kos Lama : " + data.getAlamatKos());
                        System.out.print("Masukkan Alamat Kos baru : ");
                        fieldBaru = input.nextLine();
                        data.setAlamatKos(fieldBaru);
                        updated = true;
                    } else if (menu.equalsIgnoreCase("3")) {
                        showAllDaerah();
                        System.out.println("Daerah Lama : " + data.getDaerah());
                        System.out.print("Masukkan Nama Daerah Baru : ");
                        fieldBaru = input.nextLine();
                        for (Daerah daerah : arDaerah) {
                            if (daerah.getNamaDaerah().equalsIgnoreCase(fieldBaru) || daerah.getIdDaerah().equalsIgnoreCase(fieldBaru)) {
                                data.setDaerah(daerah.getNamaDaerah());
                                updated = true;
                            }
                        }
                        if (!updated) {
                            System.out.println("Daerah tidak ditemukan, data tidak terubah!");
                        }
                    } else if (menu.equalsIgnoreCase("4")) {
                        System.out.println("Harga Sewa Bulanan Lama : " + data.getHargaSewa());
                        System.out.print("Masukkan Harga Sewa Bulanan baru : ");
                        try {
                            fieldBaru = input.nextLine();
                            data.setHargaSewa(Float.parseFloat(fieldBaru));
                            updated = true;
                        } catch (Exception ex) {
                            data.setHargaSewa(0);
                        }
                    } else if (menu.equalsIgnoreCase("5")) {
                        System.out.println("Fasilitas Kos Lama : " + data.getFasilitas());
                        System.out.print("Masukkan Fasilitas Kos baru : ");
                        fieldBaru = input.nextLine();
                        data.setFasilitas(fieldBaru);
                        updated = true;
                    } else if (menu.equalsIgnoreCase("6")) {
                        System.out.println("Jumlah Kamar Lama : " + data.getHargaSewa());
                        System.out.print("Masukkan Jumlah Kamar baru : ");
                        try {
                            fieldBaru = input.nextLine();
                            data.setJmlKamar(Integer.parseInt(fieldBaru));
                            updated = true;
                        } catch (Exception ex) {
//                            data.setHargaSewa(0);
                        }
                    } else if (menu.equalsIgnoreCase("7")) {
                        cancelled = true;
                    }
                }
            }

            if (updated) {
                System.out.println("Data berhasil diubah!");
            } else if (!updated) {
                System.out.println("Data gagal diubah!");
            }
            if (cancelled) {
                System.out.println("Batal mengubah data!");
            }
        } while (!updated && !cancelled);
    }

    private static void updateDaerah() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        String nama = "";
        String fieldBaru = "";
        int indeks = 0;
        int counter = 0;

        showAllDaerah();
        boolean updated = false;
        do {
            System.out.print("Masukkan ID Daerah yang akan diubah : ");
            id = input.nextLine();
            for (Daerah data : arDaerah) {
                if (data.getIdDaerah().equalsIgnoreCase(id)) {
                    indeks = counter;
                }
                counter++;
            }
            showDaerah(arDaerah.get(indeks));
            for (Daerah data : arDaerah) {
                if (data.getIdDaerah().equals(id)) {
                    System.out.println("Daerah Lama : " + data.getNamaDaerah());
                    System.out.print("Masukkan Nama baru : ");
                    fieldBaru = input.nextLine();
                    data.setNamaDaerah(fieldBaru);
                    updated = true;
                }
            }

            if (updated) {
                System.out.println("Data berhasil diubah!");
            } else if (!updated) {
                System.out.println("Data gagal diubah!");
            }
        } while (!updated);
    }

    private static void updatePelanggan() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        String menu = "";
        String fieldBaru = "";
        int indeks = 0;
        int counter = 0;
        showAllPelanggan();
//        Kos buku = new Kos();
        boolean updated = false;
        boolean cancelled = false;
        do {
            System.out.print("Masukkan ID Pelanggan yang akan diubah : ");
            id = input.nextLine();
            for (Pelanggan data : arPelanggan) {
                if (data.getIdPelanggan().equalsIgnoreCase(id)) {
                    indeks = counter;
                }
                counter++;
            }
            showPelanggan(arPelanggan.get(indeks));
            for (Pelanggan data : arPelanggan) {
                if (data.getIdPelanggan().equalsIgnoreCase(id)) {
                    showPelanggan(data);
                    System.out.println("Apa yang akan Anda ubah?");
                    System.out.println("1. Nama");
                    System.out.println("2. Tanggal Lahir");
                    System.out.println("3. Alamat");
                    System.out.println("4. Nomor HP");
                    System.out.println("5. Email");
                    System.out.println("6. Kembali");
                    System.out.print("Masukkan pilihan anda : ");
                    while (!input.hasNext("[123456]")) {
                        System.out.println("Menu yang anda masukkan salah!");
                        input.nextLine();
                    }
                    menu = input.nextLine();
                    if (menu.equalsIgnoreCase("1")) {
                        System.out.println("Nama Lama : " + data.getNamaPelanggan());
                        System.out.print("Masukkan Nama baru : ");
                        fieldBaru = input.nextLine();
                        data.setNamaPelanggan(fieldBaru);
                        updated = true;
                    } else if (menu.equalsIgnoreCase("2")) {
                        System.out.println("Tanggal Lahir Lama : " + dateFormat.format(data.getTanggalLahir()));
                        boolean isValid = false;
                        do {
                            try {
                                System.out.print("Masukkan Tanggal Lahir baru (DD/MM/YYYY) : ");
                                fieldBaru = input.nextLine();
                                Date tglLahir = new SimpleDateFormat("dd/MM/yyyy").parse(fieldBaru);
                                data.setTanggalLahir(tglLahir);
                                updated = true;
                                isValid = true;
                            } catch (Exception ex) {
                                System.out.print("Format Tanggal Lahir Salah!");
                            }
                        } while (!isValid);
                    } else if (menu.equalsIgnoreCase("3")) {
                        System.out.println("Alamat Lama : " + data.getAlamat());
                        System.out.print("Masukkan Alamat baru : ");
                        fieldBaru = input.nextLine();
                        data.setAlamat(fieldBaru);
                        updated = true;
                    } else if (menu.equalsIgnoreCase("4")) {
                        System.out.println("Nomor HP Lama : " + data.getNoHP());
                        do {
                            System.out.print("Masukkan No HP baru (Hanya Angka): ");
                            fieldBaru = input.nextLine();
                        } while (!fieldBaru.matches("[0-9]+"));
                        data.setNoHP(fieldBaru);
                        updated = true;
                    } else if (menu.equalsIgnoreCase("5")) {
                        System.out.println("Email Lama : " + data.getEmail());
                        System.out.print("Masukkan Email baru : ");
                        fieldBaru = input.nextLine();
                        data.setEmail(fieldBaru);
                        updated = true;
                    } else if (menu.equalsIgnoreCase("7")) {
                        cancelled = true;
                    }
                }
            }

            if (updated) {
                System.out.println("Data berhasil diubah!");
            } else if (!updated) {
                System.out.println("Data gagal diubah!");
            }
            if (cancelled) {
                System.out.println("Batal mengubah data!");
            }
        } while (!updated && !cancelled);
    }

    //Kumpulan Method Deleting Data
    private static void deleteKos() {
        String id = "";
        boolean isdeleted = false;
        boolean found = false;
        String saved = "";
        int index = 0;
        int iteration = 0;
        Kos ks = new Kos();
        showAllKos();
        do {
            System.out.print("Masukkan ID Kos yang akan dihapus : ");
            id = input.nextLine();
            for (Kos data : arKos) {
                if (data.getIdKos().equalsIgnoreCase(id)) {
                    index = iteration;
                    found = true;
                }
                iteration++;
            }
            if (found) {
                System.out.println("Data yang akan Anda hapus :");
                showKos(arKos.get(index));
                System.out.println("Anda yakin ingin menghapus? (Y/N) :");
                while (!input.hasNext("[YyNn]")) {
                    System.out.println("Grade hanya bisa Y atau N");
                    input.nextLine();
                }
                saved = input.nextLine();
            }
            if (saved.equalsIgnoreCase("Y")) {
                arKos.remove(index);
                isdeleted = true;
                System.out.println("Berhasil menghapus Kos!");
            } else {
                System.out.println("Batal menghapus Kos");
                isdeleted = true;
            }
            if (!found) {
                System.out.println("Kos yang anda masukkan tidak terdaftar!");
            }
        } while (!isdeleted);
    }

    private static void deleteDaerah() {
        String id = "";
        boolean isdeleted = false;
        boolean found = false;
        String saved = "";
        int index = 0;
        int iteration = 0;
        showAllDaerah();
        do {
            System.out.print("Masukkan ID Daerah yang akan dihapus : ");
            id = input.nextLine();
            for (Daerah data : arDaerah) {
                if (data.getIdDaerah().equalsIgnoreCase(id)) {
                    index = iteration;
                    found = true;

                }
                iteration++;
            }
            if (found) {
                System.out.println("Data yang akan Anda hapus :");
                showDaerah(arDaerah.get(index));
                System.out.println("Anda yakin ingin menghapus? (Y/N) :");
                while (!input.hasNext("[YyNn]")) {
                    System.out.println("Pilihan hanya bisa Y atau N :");
                    input.nextLine();
                }
                saved = input.nextLine();
            }
            if (saved.equalsIgnoreCase("Y")) {
                arDaerah.remove(index);
                isdeleted = true;
                System.out.println("Berhasil menghapus Daerah!");
            } else {
                System.out.println("Batal Menghapus Daerah");
                isdeleted = true;
            }
            if (!found) {
                System.out.println("Daerah yang anda masukkan tidak terdaftar!");
            }
        } while (!isdeleted);
    }

    private static void deletePelanggan() {
        String id = "";
        boolean isdeleted = false;
        boolean found = false;
        String saved = "";
        int index = 0;
        int iteration = 0;
        showAllPelanggan();
        do {
            System.out.print("Masukkan ID Kos yang akan dihapus : ");
            id = input.nextLine();
            for (Pelanggan data : arPelanggan) {
                if (data.getIdPelanggan().equalsIgnoreCase(id)) {
                    index = iteration;
                    found = true;
                }
                iteration++;
            }
            if (found) {
                System.out.println("Data yang akan Anda hapus :");
                showPelanggan(arPelanggan.get(index));
                System.out.println("Anda yakin ingin menghapus? (Y/N) :");
                while (!input.hasNext("[YyNn]")) {
                    System.out.println("Pilihan hanya bisa Y atau N");
                    input.nextLine();
                }
                saved = input.nextLine();
                if (saved.equalsIgnoreCase("Y")) {
                    arPelanggan.remove(index);
                    isdeleted = true;
                    System.out.println("Berhasil menghapus Pelanggan!");
                } else {
                    System.out.println("Batal Menghapus Pelanggan!");
                    isdeleted = true;
                }
            } else {
                System.out.println("ID Pelanggan yang anda masukkan tidak terdaftar!");
            }
        } while (!isdeleted);
    }

    //Set ID Otomatis
    private static void setIDAutomatic() {
        arKos.sort((ar1, ar2) -> ar2.getIdKos().compareTo(ar1.getIdKos()));
        arPelanggan.sort((ar1, ar2) -> ar2.getIdPelanggan().compareTo(ar1.getIdPelanggan()));
        arTransaksi.sort((ar1, ar2) -> ar2.getIdTransaksi().compareTo(ar1.getIdTransaksi()));
        arDaerah.sort((ar1, ar2) -> ar2.getIdDaerah().compareTo(ar1.getIdDaerah()));
        listIdAuto.clear();
        listIdAuto.add(arKos.get(0).idKos);
        listIdAuto.add(arDaerah.get(0).idDaerah);
        listIdAuto.add(arPelanggan.get(0).idPelanggan);
        listIdAuto.add(arTransaksi.get(0).idTransaksi);
    }

    //Get ID Otomatis
    private static String getIDAutomatic(String ID) {
        String returnID = "";
        String temp1;
        int nomor = 0;

        String[] split = ID.split("-");
        nomor = Integer.parseInt(split[1]);
        nomor++;
        returnID = split[0] + "-" + nomor;

        return returnID;
    }

    //SortIncreaseByID
    private static void sort() {
        arKos.sort((ar1, ar2) -> ar1.getIdKos().compareTo(ar2.getIdKos()));
        arPelanggan.sort((ar1, ar2) -> ar1.getIdPelanggan().compareTo(ar2.getIdPelanggan()));
        arDaerah.sort((ar1, ar2) -> ar1.getIdDaerah().compareTo(ar2.getIdDaerah()));
        arTransaksi.sort((ar1, ar2) -> ar1.getIdTransaksi().compareTo(ar2.getIdTransaksi()));
    }

    //Inisialisasi Data
    private static void InitializeData() {
        Kos bk = new Kos("KS-1", "Kos Pak Haji", "Jl Swasembada Timur X", 1200000, "AC, KM Dalam, Full Furnished, WiFi", "Tanjung Priok", 12);
        Kos bk2 = new Kos("KS-2", "Kos Pak Mamat", "Jl Gading Kelapa XII", 1500000, "AC, Full Furnished, KM Dalam, Dapur", "Kelapa Gading", 10);
        arKos.add(bk);
        arKos.add(bk2);
        for (Kos kos : arKos) {
            for (int i = 1; i <= kos.getJmlKamar(); i++) {
                String noKamar = kos.getIdKos() + "/" + i;
                Kamar kamar = new Kamar(noKamar, kos.getIdKos(), true);
                arKamar.add(kamar);
            }
        }

        Daerah gn = new Daerah("DR-1", "Tanjung Priok");
        Daerah gn2 = new Daerah("DR-2", "Kelapa Gading");
        arDaerah.add(gn);
        arDaerah.add(gn2);
//        String namaPelanggan, String namaPelanggan, String alamatKos, String noHP, String email
        Date tgl = null;
        Date tgl2 = null;

        try {
            tgl = new SimpleDateFormat("dd/MM/yyyy").parse("29/10/1998");
            tgl2 = new SimpleDateFormat("dd/MM/yyyy").parse("19/11/1998");
        } catch (Exception ex) {
            System.out.println("Error Converting Tanggal");
        }
        Pelanggan plg = new Pelanggan("PLG-1", "Lutfi Alif", "Jakarta Utara", "081388227505", "lutfi.mufarrijan@gmail.com", tgl);
        Pelanggan plg2 = new Pelanggan("PLG-2", "M Lutfy", "Jakarta barat", "085720889920", "mlutfy.firmansyah@gmail.com", tgl2);
        arPelanggan.add(plg);
        arPelanggan.add(plg2);
//        String idTransaksi, Date tglTransaksi, float hargaTotal, String namaPelanggan
        Transaksi tr = new Transaksi("TR-1", new Date(), 1200000, "M Lutfy", "Kos Pak Haji", "KS-3/1");
        Transaksi tr2 = new Transaksi("TR-2", new Date(), 1500000, "M Lutfy", "Kos Pak Haji", "KS-3/2");
        Transaksi tr3 = new Transaksi("TR-3", new Date(), 1500000, "Lutfi AM", "Kos Pak Mamat", "KS-2/2");
        Transaksi tr4 = new Transaksi("TR-4", new Date(), 1500000, "Lutfi AM", "Kos Pak Mamat", "KS-2/3");
        Transaksi tr5 = new Transaksi("TR-5", new Date(), 1500000, "Lutfi AM", "Kos Pak Mamat", "KS-2/4");
        Transaksi tr6 = new Transaksi("TR-6", new Date(), 1500000, "M Lutfy", "Kos Sederhana", "KS-4/1");
        Transaksi tr7 = new Transaksi("TR-7", new Date(), 1500000, "M Lutfy", "Kos Sederhana", "KS-4/2");
        Transaksi tr8 = new Transaksi("TR-8", new Date(), 1500000, "M Lutfy", "Kos Sejahtera", "KS-5/1");
        arTransaksi.add(tr);
        arTransaksi.add(tr2);
        arTransaksi.add(tr3);
        arTransaksi.add(tr4);
        arTransaksi.add(tr5);
        arTransaksi.add(tr6);
        arTransaksi.add(tr7);
        arTransaksi.add(tr8);
    }

    //Transaksi
    private static void transaksiPembelian() {
        Date tgl = new Date();
        String strSearch = "";
        String tglskrg = dateFormat.format(tgl);
        String id = "";
        String namapelanggan = "";
        String namaKos = "";
        String idkos = "";
        int jmlKamar = 0;
        int index = 0;
        boolean foundSearch = false;
        boolean foundKos = false;
        boolean foundPelanggan = false;
        float harga = 0;
        float bayar = 0;
        float kembali = 0;
        String noKamar = "";
        List<Kos> listKos = new ArrayList<>();
        List<Kamar> listKamar = new ArrayList<>();
        System.out.println("=== Penyewaan Kos ===");
        do {
            System.out.print("Pencarian Kos (ID, Daerah, Nama, atau Alamat : ");
            strSearch = input.nextLine();
            for (Kos data : arKos) {
                if ((data.getIdKos().equalsIgnoreCase(strSearch) || data.getNamaKos().equalsIgnoreCase(strSearch) || data.getAlamatKos().equalsIgnoreCase(strSearch) || data.getDaerah().equalsIgnoreCase(strSearch)) && (data.getJmlKamar() > 0)) {
                    listKos.add(data);
                    foundSearch = true;
                }
            }
        } while (!foundSearch);

        do {
            int iteration = 0;
            showKos(listKos);
            System.out.print("Pilih ID Kos yang akan ditempati : ");
            id = input.nextLine();
            for (Kos data : arKos) {
                if (data.getIdKos().equalsIgnoreCase(id)) {
                    jmlKamar = data.getJmlKamar();
                    idkos = data.getIdKos();
                    harga = data.getHargaSewa();
                    namaKos = data.getNamaKos();
                    index = iteration;
//                    data.setJmlKamar(jmlKamar - 1);
                    foundKos = true;
                }
                iteration++;
            }
            if (foundKos) {
                showKos(arKos.get(index));
                arKos.get(index).setJmlKamar(jmlKamar-1);
                for (Kamar km : arKamar) {
                    if (km.idKos.equalsIgnoreCase(arKos.get(index).idKos) && km.isEmpty) {
                        listKamar.add(km);
                    }
                }
                listKamar.sort((ar1, ar2) -> ar1.getNoKamar().compareTo(ar2.getNoKamar()));
                noKamar = listKamar.get(0).noKamar;
                for (Kamar km : arKamar) {
                    if (km.getNoKamar().equalsIgnoreCase(noKamar)) {
                        km.setEmpty(false);
                    }
                }
                System.out.println("ID Transaksi : " + listIdAuto.get(3));
                do {
                    System.out.print("Masukkan ID Pelanggan Anda : ");
                    id = input.nextLine();
                    for (Pelanggan data : arPelanggan) {
                        if (data.getIdPelanggan().equalsIgnoreCase(id)) {
                            index = iteration;
                            namapelanggan = data.getNamaPelanggan();
                            foundPelanggan = true;
                        }
                        iteration++;
                    }
                    if (!foundPelanggan) {
                        System.out.println("ID Pelanggan yang anda masukkan tidak terdaftar!");
                    }
                } while (!foundPelanggan);
                System.out.println("Tanggal Masuk : " + tglskrg);
                System.out.println("No Kamar      : " + noKamar);
                System.out.println("Harga Sewa    : " + harga);
                System.out.println("Ringkasan Transaksi Anda");
                Transaksi tr = new Transaksi(listIdAuto.get(3), tgl, harga, namapelanggan, namaKos, noKamar);
                showTransaksi(tr);
                arTransaksi.add(tr);
                System.out.println("Terima kasih telah memilih PapiKos");
                System.out.println("Untuk pembayaran tagihan Anda selanjutnya silakan menghubungi pemilik kos yang Anda tempati!");
            } else {
                System.out.println("ID Kos Salah!");
            }
        } while (!foundKos);
    }

    //Report
    private static void showReport() {
        System.out.println("Laporan Transaksi");
        System.out.println("1. Semua Transaksi");
        System.out.println("2. Kos Tersedia per Daerah");
        System.out.println("3. Total Pemasukan");
        System.out.println("4. Top 3 Kos Favorit");
        System.out.println("5. Kembali");
    }

    private static void menuReport() {
        boolean stop = false;
        int menu = 0;

        showReport();
        menu = getMenu(menu);
        switch (menu) {
            case 1:
                showAllTransaksi();
                menuReport();
                break;
            case 2:
                showAvailableKosByDaerah();
                menuReport();
                break;
            case 3:
                showAllIncome();
                menuReport();
                break;
            case 4:
                showTop3Favorite();
                menuReport();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Mohon masukkan pilihan yang sesuai!");
                menuReport();
                break;
        }
    }

    private static void showAllIncome() {
        long totalIncome = 0L;
        for (Transaksi tr : arTransaksi) {
            long income = (long) tr.getHargaTotal();
            totalIncome = totalIncome + income;
        }
        System.out.println("Total Pemasukan PapiKos s.d. hari ini : Rp" + totalIncome);
    }

    private static void showAvailableKosByDaerah() {

        String leftAlignFormat = "| %-20s | %-10s |%n";
        System.out.println("=== Availability Kos per Daerah ===");
        System.out.format("+----------------------+------------+%n");
        System.out.format("| Daerah               | Available  |%n");
        System.out.format("+----------------------|------------+%n");
        for (Daerah daerah : arDaerah) {
            int jmlKos = 0;
            for (Kos kos : arKos) {
                if (kos.getDaerah().equalsIgnoreCase(daerah.getNamaDaerah())) {
                    jmlKos++;
                }
            }
            System.out.format(leftAlignFormat, daerah.getNamaDaerah(), jmlKos);
        }
        System.out.format("+------------+----------------------+%n");
    }

    private static void showTop3Favorite() {
        List<TransaksiKos> listTK = new ArrayList<>();
        List<String> listKos = new ArrayList<>();
        for (Transaksi tr : arTransaksi) {
            listKos.add(tr.getKos());
        }
        List<String> newList = listKos.stream().distinct().collect(Collectors.toList());
        for (String kos : newList) {
            int jml = Collections.frequency(listKos, kos);
            TransaksiKos transkos = new TransaksiKos(kos, jml);
            listTK.add(transkos);
        }
        listTK.sort((ar1, ar2) -> ar2.getEntity2() - ar1.getEntity2());
        String leftAlignFormat = "| %-20s | %-10s |%n";
        System.out.println("=== Top 3 Kos Favorit ===");
        System.out.format("+----------------------+------------+%n");
        System.out.format("| Kos                  | Jml Sewa   |%n");
        System.out.format("+----------------------|------------+%n");
        for (int i = 0; i < 3; i++) {
            System.out.format(leftAlignFormat, listTK.get(i).entity1, listTK.get(i).entity2);
        }
        System.out.format("+----------------------+------------+%n");
    }
}
