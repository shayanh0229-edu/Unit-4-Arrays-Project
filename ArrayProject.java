import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;


public class ArrayProject {
    private String[] hands;
    private int bidValue;
    private int rank;
    private String handType;
    private int numberOfUniques;
    private int maxFrequency;
    private int bracketThingy;



    public ArrayProject(String[] hands, int bracketThingy) {
        this.bracketThingy = bracketThingy;
        this.hands = hands;
        this.rank = 0;
        List<String> list = Arrays.asList(hands);
        Set<String> uniqueStrings = new HashSet<>(list);
        this.numberOfUniques = uniqueStrings.size();
        System.out.println(numberOfUniques);


        int[] frequencies = new int[numberOfUniques];
        int whichFrequency = 0;
        for (String card : uniqueStrings) {
            for (int i = 0; i < hands.length; i++) {
                if (hands[i].equals(card)) {
                    frequencies[whichFrequency]++;
                }
            }
            whichFrequency++;
        }
        this.maxFrequency = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > maxFrequency) {
                maxFrequency = frequencies[i];
            }
        }
        if (numberOfUniques == 1) {
            handType = "fiveOfAKind";
        } else if (numberOfUniques == 2) {
            if (maxFrequency == 4) {
                handType = "fourOfAKind";
            } else {
                handType = "fullHouse";
            }
        } else if (numberOfUniques == 3) {
            if (maxFrequency == 3) {
                handType = "threeOfAKind";
            } else {
                handType = "twoPair";
            }
        } else if (numberOfUniques == 4) {
            handType = "onePair";
        } else if (numberOfUniques == 5) {
            handType = "highCard";
        }




    }
    public int getNumberOfUniques() {
        return numberOfUniques;
    }

    public String getHandType() {
        return handType;
    }
    public int getMaxFrequency() {
        return maxFrequency;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getCardValue(String card) {
        return switch (card) { //for this part, i had to look to the internet to find a way to
            case "Ace"   -> 14; // "index" each card to make the comparisons seamless
            case "King"  -> 13;
            case "Queen" -> 12;
            case "Jack"  -> 11;
            default      -> Integer.parseInt(card);
        };
    }
    public int bidValue(){


        return bidValue;
    }

    public String[] getHands() {
        return hands;
    }

//    public void giveRankingsByN(ArrayProject[] frog, int totalRankings) {
//        for (ArrayProject hand : frog) {
//            int cardNumber = 0;
//            int ranksAbove = 0;
//            for (int i = cardNumber + 1; i < frog.length; i++) {
//                while (this.getCardValue(hand.getHands()[cardNumber]) == this.getCardValue(frog[i].getHands()[i])) {
//                    cardNumber++;
//                    i++;
//                }
//                if (this.getCardValue(hand.getHands()[cardNumber]) > this.getCardValue(frog[i].getHands()[i])) {
//                    ranksAbove = cardNumber;
//                }
//            }
//
//            hand.setRank(ranksAbove);
//        }
//        }
    public void giveRankingsByN(ArrayProject[] frog, int totalRankings) {
        for (ArrayProject hand : frog) {
            int beatenCount = 0; // Count how many hands are weaker than current 'hand'
            for (int i = 0; i < frog.length; i++) {
                ArrayProject other = frog[i];
                if (hand == other) continue; // Don't compare to self
                int cardIdx = 0;
                while (getCardValue(hand.getHands()[cardIdx]) == getCardValue(other.getHands()[cardIdx])) {
                    cardIdx++;
                }
                if (getCardValue(hand.getHands()[cardIdx]) > getCardValue(other.getHands()[cardIdx])) {
                    beatenCount++;
                }
            }
            hand.setRank(totalRankings + beatenCount + 1);
        }
    }



    public int getRank() {
        return rank;
    }
}

