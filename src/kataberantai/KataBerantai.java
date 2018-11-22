/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kataberantai;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yohan
 */
public class KataBerantai {

    static String jawab;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("+--------------------------------+");
        System.out.println("| Tebak Kuis Gajelas Ini ya Gaes |");
        System.out.println("+--------------------------------+");
        boolean sikon = true;
        while (sikon) {
            System.out.println("1. Mulai Coba Mencoba");
            System.out.println("2. Keluar");
            System.out.print("Pilih Menu : ");
            int pime = sc.nextInt();
            switch (pime) {
                case 1:
                    mulaigameyuk();
                    break;
                case 2:
                    System.out.println("Anda Telah Keluar, Terima Kasih!!!");
                    System.exit(0);
                default:
                    System.err.println("Menu Tidak Tersedia!!!");
            }
        }
    }

    private static void mulaigameyuk() {
        boolean game = true;
        while (game) {
            ArrayList<String> hm = new ArrayList<>();
            LinkedList li = new LinkedList();
            Hashtable<String, String> antrian = new Hashtable<>();
            antrian.put("Di atasnya RT ...", "nekat");
            antrian.put("Klub yang menjuarai La Liga dua musim berturut-turut ...", "ikutlomba");
            antrian.put("Kucing menerkam mangsanya ...", "nangkep");
            antrian.put("Pengendara sepeda motor terpaksa menepi karena di jalan turun ...", "buaya");

            String[] keys = antrian.keySet().toArray(new String[antrian.size()]);
            int a = 0;
            while (a < antrian.size()) {
                String key = keys[a];
                if (!hm.contains(key)) {
                    hm.add(key);
                    li.push(new LinkedListNode(antrian.get(key)));
                    a++;
                }
            }
            String g = "";
            int y = 1;
            int b = 0, s = 0;

            for (int x = 0; x < hm.size(); x++) {
                int kesempatan = 2;
                sc = new Scanner(System.in);
                String cj;
                do {
                    System.out.println("Soal " + y);
                    System.out.print(hm.get(x));
                    jawab = sc.nextLine();
                    cj = antrian.get(hm.get(x));
                    if (cj.equalsIgnoreCase(jawab)) {
                        b += 1;
                        break;
                    } else {
                        System.out.println("Jawaban salah. Coba lagi!");
                        kesempatan--;
                    }
                } while (kesempatan >= 1);
                if (kesempatan == 0){
                    s += 1;
                }
                y++;
                g += (cj + " ");
            }
            System.out.println("+---------------------------------------------------------+");
            System.out.println("| Hasil Jawaban : " + g + "\t|");
            System.out.println("| Seberapa sering kamu benar : " + b + "\t| ");
            System.out.println("| Seberapa sering kamu salah : " + s + "\t| ");
            System.out.println("+---------------------------------------------------------+");
            boolean ulg;
            do {
                ulg = false;
                System.out.print("Ingin Mengulang Permainan ? (Y/T) ");
                String up = sc.next();
                if (up.equalsIgnoreCase("Y")) {
                    game = true;
                } else if (up.equalsIgnoreCase("T")) {
                    System.out.println("Terima Kasih Telah Bermain Main Dengan Saya !!!");
                    System.exit(0);
                } else {
                    System.err.println("Hey Pilihannya hanya Y/T");
                    ulg = true;
                }
            } while (ulg);
        }
    }
}
