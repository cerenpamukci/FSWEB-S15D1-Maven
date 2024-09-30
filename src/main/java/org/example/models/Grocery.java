package org.example.models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void startGrocery() {
int choice;
do {
    System.out.println("Yapılmak istenen operasyou seçin (0=çıkış 1=ekleme 2=çıkarma)");
    choice = scanner.nextInt();
    scanner.nextLine();
    switch (choice) {
        case 1:
            System.out.println("Eklenmesini istediğiniz elemanları girin");
            String itemsToAdd = scanner.nextLine();
            addItems(itemsToAdd);
            break;
    }
}
while (choice != 0);
scanner.close();
    }

    private void addItems(String itemsToAdd) {
    }
}
