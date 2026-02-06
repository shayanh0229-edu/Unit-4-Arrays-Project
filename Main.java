import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int fiveOfAKind = 0;
        int fullHouses = 0;
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

            } s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


        System.out.println(fileData);
        String[] hands = fileData.split("\n");

//        ArrayProject pokerAnalyzer = new ArrayProject(hands);

    }
}