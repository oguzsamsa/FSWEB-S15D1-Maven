package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen bir seçim yapınız: 0-Uygulamayı kapat 1-Ürün ekle 2-Ürün çıkar");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 0:
                System.out.println("Uygulama kapatılıyor...");
                break;
            case 1:
                System.out.println("Eklemek istediğiniz ürünleri giriniz (virgülle ayırarak)");
                String itemsToAdd = scanner.nextLine();
                addItems(itemsToAdd);
                break;
            case 2:
                System.out.println("Çıkarmak istediğiniz ürünleri giriniz (");
                String itemsToRemove = scanner.nextLine();
                removeItems(itemsToRemove);
                break;
            default:
                System.out.println("Geçersiz seçim. Geçerli bir seçim yapınız");
        }
    }

    public static void removeItems(String input) {
        String[] itemsToRemove = input.split(",");
        for (String item: itemsToRemove) {
            groceryList.remove(item);
        }
        Collections.sort(groceryList);
    }

    public static void addItems(String input) {
        String[] itemsToAdd = input.split(",");
        for (String item: itemsToAdd) {
            if(!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product){
        return groceryList.contains(product);
    }

    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}
