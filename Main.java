import java.io.File;
import java.io.FileNotFoundException;
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
                String[] ewGetOutBracket = line.split("\\|");
                String[] cardsInThisLine = ewGetOutBracket[0].split(","); //( new cool method to do either or "[,|]")
                ArrayProject pokerAnalyzer = new ArrayProject(cardsInThisLine);
                if (pokerAnalyzer.getNumberOfUniques() == 1) {
                    fiveOfAKind ++;
                } else if (pokerAnalyzer.getNumberOfUniques() == 2) {
                    if (pokerAnalyzer.getMaxFrequency() == 4) {
                        fourOfAKind++;
                    } else {
                        fullHouse++;
                    }
                } else if (pokerAnalyzer.getNumberOfUniques() == 3) {
                    if (pokerAnalyzer.getMaxFrequency() == 3) {
                        threeOfAKind++;
                    } else {
                        twoPair++;
                    }

                } else if (pokerAnalyzer.getNumberOfUniques() == 4) {
                    onePair ++;
                } else if (pokerAnalyzer.getNumberOfUniques() == 5) {
                    highCard ++;
                }



            } s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println(fileData);
        String[] hands = fileData.split("\n");

        System.out.println("Number of five of a kind hands: " + fiveOfAKind);
        System.out.println("Number of full house hands: " + fullHouse);
        System.out.println("Number of four of a kind hands: " + fourOfAKind);
        System.out.println("Number of three of a kind hands: " + threeOfAKind);
        System.out.println("Number of two pair hands: " + twoPair);
        System.out.println("Number of one pair hands: " + onePair);
        System.out.println("Number of high card hands: " + highCard);



    }
}
