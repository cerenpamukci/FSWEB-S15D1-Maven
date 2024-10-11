package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Grocery {

    // Public static ArrayList tipinde bir groceryList oluşturuyoruz
    public static ArrayList<String> groceryList = new ArrayList<>();

    // Kullanıcıdan giriş almak için Scanner objesi oluşturuyoruz
    private static Scanner scanner = new Scanner(System.in);

    // Uygulamayı başlatan method
    public static void startGrocery() {
        boolean quit = false;
        printInstructions();

        while (!quit) {
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer temizleme

            switch (choice) {
                case 0:
                    System.out.println("Uygulama durduruluyor...");
                    quit = true;
                    break;
                case 1:
                    System.out.print("Eklemek istediğiniz eleman ya da elemanları giriniz (örneğin: tomato ya da tomato, orange, peach): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    printSorted();
                    break;
                case 2:
                    System.out.print("Çıkarmak istediğiniz eleman ya da elemanları giriniz (örneğin: tomato ya da tomato, orange, peach): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    printSorted();
                    break;
                default:
                    printInstructions();
            }
        }
    }

    // Eklenmek istenen elemanları listeye ekleyen metod
    public static void addItems(String input) {
        String[] items = input.split(","); // Virgülle ayırarak birden çok eleman alabiliriz
        for (String item : items) {
            item = item.trim(); // Elemanları temizleyerek listeye ekliyoruz
            if (!checkItemIsInList(item)) { // Eğer eleman listede yoksa ekle
                groceryList.add(item);
            } else {
                System.out.println(item + " zaten listede mevcut.");
            }
        }
        Collections.sort(groceryList); // Listeyi her ekleme sonrasında sıralıyoruz
    }

    // Listeden eleman çıkaran metod
    public static void removeItems(String input) {
        String[] items = input.split(","); // Virgülle ayırarak birden çok eleman alabiliriz
        for (String item : items) {
            item = item.trim(); // Elemanları temizleyerek listeden çıkarıyoruz
            if (checkItemIsInList(item)) { // Eğer eleman listede varsa çıkar
                groceryList.remove(item);
            } else {
                System.out.println(item + " listede bulunmuyor.");
            }
        }
        Collections.sort(groceryList); // Listeyi her çıkarma sonrasında sıralıyoruz
    }

    // Elemanın listede olup olmadığını kontrol eden metod
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product); // Liste elemanları içeriyor mu kontrolü
    }

    // Listeyi sıralayarak ekrana basan metod
    public static void printSorted() {
        HashSet<String> set = new HashSet<>(groceryList); // Tekrar eden verileri önlemek için set kullanıyoruz
        groceryList.clear();
        groceryList.addAll(set);
        Collections.sort(groceryList); // Listeyi sıralıyoruz
        System.out.println("Mevcut Pazar Arabası Listesi: " + groceryList);
    }

    // Kullanıcıya talimatları gösteren metod
    public static void printInstructions() {
        System.out.println("\nKomut Seçenekleri:");
        System.out.println("\t0 - Uygulamayı kapat");
        System.out.println("\t1 - Listeye eleman ekle");
        System.out.println("\t2 - Listeden eleman çıkar");
    }

    // Ana method
    public static void main(String[] args) {
        startGrocery(); // Uygulama başladığında startGrocery methodunu çağırıyoruz
    }
}
