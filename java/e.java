import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class e {
    public static void displayList(List<String> items) {
        System.out.print("List contents: ");
        for (String item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void insertItem(List<String> items) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to insert: ");
        String newItem = scanner.next();
        items.add(newItem);
        System.out.println("Item inserted successfully.");
    }

    public static void deleteItem(List<String> items) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to delete: ");
        String itemToDelete = scanner.next();
        if (items.remove(itemToDelete)) {
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item not found in the list.");
        }
    }

    public static void searchItem(List<String> items) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to search: ");
        String itemToSearch = scanner.next();
        if (items.contains(itemToSearch)) {
            System.out.println("Item found in the list.");
        } else {
            System.out.println("Item not found in the list.");
        }
    }

    public static void main(String[] args) {
        List<String> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Insert\n2. Delete\n3. Display\n4. Search\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertItem(itemList);
                    break;
                case 2:
                    deleteItem(itemList);
                    break;
                case 3:
                    displayList(itemList);
                    break;
                case 4:
                    searchItem(itemList);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}