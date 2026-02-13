import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int fiveOfAKind = 0;
        int fullHouse = 0;
        int fourOfAKind = 0;
        int threeOfAKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        String fileData = "";
        try {
            File f = new File("src/numberz");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.isEmpty()) continue;
                fileData += line + "\n"; //there was a massive bug here! before line 28 was added,
            }                            // the allHands array was initialized with the wrong size
            s.close();                   //
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String[] hands = fileData.split("\n");
        ArrayProject[] allHands = new ArrayProject[hands.length];
        try {
            File f = new File("src/numberz");
            Scanner s = new Scanner(f);
            int i = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.isEmpty()) continue;
                String[] ewGetOutBracket = line.split("\\|");
                String[] cardsInThisLine = ewGetOutBracket[0].split(","); //( new cool method to do either or "[,|]")
                allHands[i] = new ArrayProject(cardsInThisLine, Integer.parseInt(ewGetOutBracket[1]), false);
                if (allHands[i].getHandType().equals("fiveOfAKind")) {
                    fiveOfAKind++;
                } else if (allHands[i].getHandType().equals("fourOfAKind")) {
                    fourOfAKind++;
                } else if (allHands[i].getHandType().equals("fullHouse")) {
                    fullHouse++;
                } else if (allHands[i].getHandType().equals("threeOfAKind")) {
                    threeOfAKind++;
                } else if (allHands[i].getHandType().equals("twoPair")) {
                    twoPair++;
                } else if (allHands[i].getHandType().equals("onePair")) {
                    onePair++;
                } else if (allHands[i].getHandType().equals("highCard")) {
                    highCard++;
                }
                i++;
            }
            s.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        allHands[0].giveRankingsByN(allHands);
        int totalBidValue = 0;
        for (ArrayProject hand : allHands) {
            totalBidValue += hand.getBidValue();
        }
        ArrayProject[] jackedHands = new ArrayProject[allHands.length];
        int i = 0;
        for (ArrayProject hand: allHands) {
            jackedHands[i] = new ArrayProject(hand.getHands(), hand.getBracketThingy(), true);
            i++;
        }

        int jackBidValue = 0;

        jackedHands[0].giveJackedRankingsByN(jackedHands);
        for (ArrayProject hand : jackedHands) {
            jackBidValue += hand.getBidValue();
        }

        System.out.println("Number of five of a kind hands: " + fiveOfAKind);
        System.out.println("Number of full house hands: " + fullHouse);
        System.out.println("Number of four of a kind hands: " + fourOfAKind);
        System.out.println("Number of three of a kind hands: " + threeOfAKind);
        System.out.println("Number of two pair hands: " + twoPair);
        System.out.println("Number of one pair hands: " + onePair);
        System.out.println("Number of high card hands: " + highCard);
        System.out.println("Total Bid Value: " + totalBidValue);
        System.out.println("Bid Value With Jacks Wild: " + jackBidValue);

    }
}
