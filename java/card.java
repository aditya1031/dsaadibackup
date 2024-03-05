import java.util.*;

class Card {
    String symbol;
    int number;

    Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of Cards: ");
        int numCards = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Map<String, List<Card>> cardsMap = new TreeMap<>();

        for (int i = 0; i < numCards; i++) {
            System.out.println("Enter card " + (i + 1) + ":");
            String symbol = scanner.nextLine().trim();
            int number = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            cardsMap.putIfAbsent(symbol, new ArrayList<>());
            cardsMap.get(symbol).add(new Card(symbol, number));
        }

        System.out.println("Distinct Symbols are :");
        for (String symbol : cardsMap.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();

        for (Map.Entry<String, List<Card>> entry : cardsMap.entrySet()) {
            String symbol = entry.getKey();
            List<Card> cards = entry.getValue();

            System.out.println("\nCards in " + symbol + " Symbol");
            for (Card card : cards) {
                System.out.println(card.symbol + " " + card.number);
            }
            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + cards.stream().mapToInt(card -> card.number).sum());
        }

        scanner.close();
    }
}
