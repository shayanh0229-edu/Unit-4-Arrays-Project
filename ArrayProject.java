import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ArrayProject {
    private String[] hands;
    private String[] cards;
    private int numberOfUniques;


    public ArrayProject(String[] hands) {
        this.hands = hands;
        for (int i = 0; i < hands.length; i++) {
            cards = hands[i].split(",");
        }
        List<String> list = Arrays.asList(hands);
        Set<String> uniqueStrings = new HashSet<>(list);
        this.numberOfUniques = uniqueStrings.size();
        System.out.println(numberOfUniques);

    }

    public int getNumberOfUniques() {
        return numberOfUniques;
    }
    public void numberOfEachTypeOfHand() {
        int fiveOfAKind = 0;
        int fullHouses = 0;
        int fourOfAKind = 0;
        int threeOfAKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        System.out.println("Number of five of a kind hands: " + fiveOfAKind);
        System.out.println("Number of full house hands: " + fullHouses);
        System.out.println("Number of four of a kind hands: " + fourOfAKind);
        System.out.println("Number of three of a kind hands: " + threeOfAKind);
        System.out.println("Number of two pair hands: " + twoPair);
        System.out.println("Number of one pair hands: " + onePair);
        System.out.println("Number of high card hands: " + highCard);
        System.out.println("Total Bid Value: ");

    }
}

//    public int cardTypes() {
//        //some preface for this:
//        //i had to do some research and found that
//        //set is a java import that takes  in only unique elements
//        //to convert our array into a set, it seems we must use lists as a bridge to do so
//
//        List<String> list = Arrays.asList(hands[0]);
//        Set<String> uniqueStrings = new HashSet<>(list);
//        int typeNumber = uniqueStrings.size();
//
//        return typeNumber;
//    }

        // WELCOME TO THE GRAVEYARD
//        String cardIndices = "1";
//        for (int i = 1; i < cards.length; i++) {
//            boolean matched = false;
//            // Check against all previous cards
//            for (int j = 0; j < i; j++) {
//                if (cards[i].equals(cards[j])) {
//                    cardIndices += (j + 1); //
//                    matched = true;
//                    break; // pls stop checking more
//                }
//            }
//            // If no match was found, use its own index
//            if (!matched) {
//                int greatestNum = 0;
//                for (int i2 = 0; i2 < cardIndices.length(); i2++) {
//                    if (Integer.parseInt(cardIndices.substring(i2, i2 + 1)) > greatestNum) {
//                        greatestNum = Integer.parseInt(cardIndices.substring(i2, i2 + 1));
//                    }
//                }
//                cardIndices += (greatestNum + 1);
//            }
//        }
//        System.out.println(cardIndices);
//        int greatestNum = 0;
//        for (int i = 0; i < cardIndices.length(); i++) {
//            if (Integer.parseInt(cardIndices.substring(i, i + 1)) > greatestNum) {
//                greatestNum = Integer.parseInt(cardIndices.substring(i, i + 1));
//            }
//        }
//        if (cards[1].equals(cards[0])) {
//            cardIndices += "1";
//        } else {
//            cardIndices += "2";
//        }
//        if (cards[2].equals(cards[0])) {
//            cardIndices += "1";
//        } else if (cards[2].equals(cards[1])){
//            cardIndices += "2";
//        } else {
//            cardIndices += "3";
//        }
//        if (cards[3].equals(cards[0])) {
//            cardIndices += "1";
//        } else if (cards[3].equals(cards[1])) {
//            cardIndices += "2";
//        } else if (cards[3].equals(cards[2])) {
//            cardIndices += "3";
//        } else {
//            cardIndices += "4";
//        }
//        if (cards[4].equals(cards[0])) {
//            cardIndices += "1";
//        } else if (cards[4].equals(cards[1])) {
//            cardIndices += "2";
//        } else if (cards[4].equals(cards[2])) {
//            cardIndices += "3";
//        } else if (cards[4].equals(cards[3])){
//            cardIndices += "4";
//        } else {
//            cardIndices += "5";
//        }
//         for (int i = 0; i < cards.length; i++) {
//            for (int repeater = 0; repeater < cards.length; repeater++)
//
//                if (!cards[i].equals(cards[repeater])) {
//                    typeNumber ++;
//                }
//        }
//        typeNumber = greatestNum;
//        return typeNumber;
//    }
//
//}
   /*for (String card : hand) {
       String numbers = hands.split(",");




       int[] values = new int[numbers.length];
       for (int i = 0; i < values.length; i++) {
           values[i] = Integer.parseInt(numbers[i]);
       }
       System.out.println(values[0]);
*/




