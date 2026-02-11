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
        int totalBidValue = 0;

        String fileData = "";
        try {
            File f = new File("src/numberz");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.isEmpty()) continue;
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[] hands = fileData.split("\n");
        ArrayProject[] allHands = new ArrayProject[hands.length];

        try {
            File f = new File("src/numberz");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.isEmpty()) continue;
                String[] ewGetOutBracket = line.split("\\|");
                String[] cardsInThisLine = ewGetOutBracket[0].split(","); //( new cool method to do either or "[,|]")

                for (int i = 0; i < hands.length; i++) {
                    allHands[i] = new ArrayProject(cardsInThisLine, Integer.parseInt(ewGetOutBracket[1]));

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
                }
            }
            s.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        ArrayProject[] fiveOfAKindStrings = new ArrayProject[fiveOfAKind];
        ArrayProject[] fourOfAKindStrings = new ArrayProject[fourOfAKind];
        ArrayProject[] fullHouseStrings = new ArrayProject[fullHouse];
        ArrayProject[] threeOfAKindStrings = new ArrayProject[threeOfAKind];
        ArrayProject[] twoPairStrings = new ArrayProject[twoPair];
        ArrayProject[] onePairStrings = new ArrayProject[onePair];
        ArrayProject[] highCardStrings = new ArrayProject[highCard];

        int count5 = 0;
        int count4 = 0;
        int countFH = 0;
        int count3 = 0;
        int count2P = 0;
        int count1P = 0;
        int countHC = 0;

        for (ArrayProject hand : allHands) {
            if (hand.getHandType().equals("fiveOfAKind")) {
                fiveOfAKindStrings[count5] = hand;
                count5++;
            } else if (hand.getHandType().equals("fourOfAKind")) {
                fourOfAKindStrings[count4] = hand;
                count4++;
            } else if (hand.getHandType().equals("fullHouse")) {
                fullHouseStrings[countFH] = hand;
                countFH++;
            } else if (hand.getHandType().equals("threeOfAKind")) {
                threeOfAKindStrings[count3] = hand;
                count3++;
            } else if (hand.getHandType().equals("twoPair")) {
                twoPairStrings[count2P] = hand;
                count2P++;
            } else if (hand.getHandType().equals("onePair")) {
                onePairStrings[count1P] = hand;
                count1P++;
            } else if (hand.getHandType().equals("highCard")) {
                highCardStrings[countHC] = hand;
                countHC++;
            }



            System.out.println(fileData);


            System.out.println("Number of five of a kind hands: " + fiveOfAKind);
            System.out.println("Number of full house hands: " + fullHouse);
            System.out.println("Number of four of a kind hands: " + fourOfAKind);
            System.out.println("Number of three of a kind hands: " + threeOfAKind);
            System.out.println("Number of two pair hands: " + twoPair);
            System.out.println("Number of one pair hands: " + onePair);
            System.out.println("Number of high card hands: " + highCard);
            System.out.println("Total Bid Value: " + totalBidValue);
            twoPairStrings[0].giveRankingsByN(twoPairStrings, 2);
            for (int i = 0; i < twoPairStrings.length + 1; i++) {
                System.out.println(twoPairStrings[i].getRank());
            }
// to lists segregated, index of each


        }
    }
}
