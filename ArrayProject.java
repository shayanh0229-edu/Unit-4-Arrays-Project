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
    private boolean wild;

    public ArrayProject(String[] hands, int bracketThingy, boolean wild) {
        this.hands = hands;
        this.rank = 0;
        this.bidValue = bracketThingy;

        int[] freqs = new int[hands.length];
        String[] uniqueCards = new String[hands.length];
        int uniqueCount = 0;

        for (String card : hands) {
            if (wild && card.equals("Jack")) continue;
            boolean found = false;
            for (int i = 0; i < uniqueCount; i++) {
                if (uniqueCards[i].equals(card)) {
                    freqs[i]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                uniqueCards[uniqueCount] = card;
                freqs[uniqueCount] = 1;
                uniqueCount++;
            }
        }
        int jackCount = 0;
        for (String card : hands) if (card.equals("Jack")) jackCount++;

        int maxFreq;
        if (wild && jackCount > 0) {

            maxFreq = 0;
            for (int i = 0; i < uniqueCount; i++) {
                int freqWithJacks = freqs[i] + jackCount;
                if (freqWithJacks > maxFreq) maxFreq = freqWithJacks;
            }
        } else {
            maxFreq = 0;
            for (int i = 0; i < uniqueCount; i++) {
                if (freqs[i] > maxFreq) {
                    maxFreq = freqs[i];
            }
            }
        }

        this.maxFrequency = maxFreq;
        this.numberOfUniques = uniqueCount;

        if (maxFreq == 5) {
            handType = "fiveOfAKind";
        } else if (maxFreq == 4) {
            handType = "fourOfAKind";
        } else if (maxFreq == 3) {
            if (uniqueCount == 2) {
                handType = "fullHouse";
            } else {
                handType = "threeOfAKind";
            }
        } else if (maxFreq == 2) {
            if (uniqueCount == 3) {
                handType = "twoPair";
            } else {
                handType = "onePair";
            }
        } else {
            handType = "highCard";
        }
    }

    public int getNumberOfUniques() {
        return numberOfUniques;
    }

    public void setWild(boolean wild) {
        this.wild = wild;
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

    public int jackCardValue(String card) {
        return switch (card) {
            case "Ace"   -> 14;
            case "King"  -> 13;
            case "Queen" -> 12;
            case "Jack"  -> 1;
            default      -> Integer.parseInt(card);
        };
    }

    public int getHandValue() {

        return switch (this.getHandType()) {

            case "fiveOfAKind"   -> 7;
            case "fourOfAKind"   -> 6;
            case "fullHouse"       -> 5;
            case "threeOfAKind"  -> 4;
            case "twoPair"         -> 3;
            case "onePair"         -> 2;
            case "highCard"        -> 1;

            default -> 0;
        };
    }

    public int getBidValue(){
        return bidValue * rank;
    }
    public int getBracketThingy(){
        return bidValue;
    }

    public String[] getHands() {
        return hands;
    }

    public void giveRankingsByN(ArrayProject[] frog) {
        for (ArrayProject hand : frog) {
            int beatenCount = 0;

            for (ArrayProject other : frog) {
                if (hand == other) continue;

                if (hand.getHandValue() > other.getHandValue()) {
                    beatenCount++;
                } else if (hand.getHandValue() == other.getHandValue()) {

                    int cardIdx = 0;
                    String[] handCards = hand.getHands();
                    String[] otherCards = other.getHands();

                    while (cardIdx < handCards.length &&
                            getCardValue(handCards[cardIdx]) ==
                                    getCardValue(otherCards[cardIdx])) {
                        cardIdx++;
                    }
                    if (cardIdx < handCards.length &&
                            getCardValue(handCards[cardIdx]) >
                                    getCardValue(otherCards[cardIdx])) {
                        beatenCount++;
                    }
                }
            }
            hand.setRank(beatenCount + 1);
        }
    }

    public void giveJackedRankingsByN(ArrayProject[] frog) {

        for (ArrayProject hand : frog) {
            int beatenCount = 0;

            for (ArrayProject other : frog) {
                if (hand == other) continue;

                if (hand.getHandValue() > other.getHandValue()) {
                    beatenCount++;
                } else if (hand.getHandValue() == other.getHandValue()) {

                    int cardIdx = 0;
                    String[] handCards = hand.getHands();
                    String[] otherCards = other.getHands();

                    while (cardIdx < handCards.length && jackCardValue(handCards[cardIdx]) == jackCardValue(otherCards[cardIdx])) {
                        cardIdx++;
                    }
                    if (cardIdx < handCards.length && jackCardValue(handCards[cardIdx]) >
                                    jackCardValue(otherCards[cardIdx])) {
                        beatenCount++;
                    }
                }
            }
            hand.setRank(beatenCount + 1);
        }
    }



    public int getRank() {
        return rank;
    }
}
