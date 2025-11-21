import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ArrayList<String> lines = getFileData("src/data");

        int partOneAnswer = 0;
        int partTwoAnswer = 0;
        for (int i = 0; i < lines.size(); i++) {
            partOneAnswer += getPartOneNumber(lines.get(i));
            partTwoAnswer += getPartTwoNumber(lines.get(i));
        }

        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part two answer: " + partTwoAnswer);
    }

    public static int getPartOneNumber(String line) {
        // do part 1
        // find the first digit and last digit of the String
        // return the number put together
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean isInt = false;
        int firstNum = 0;
        int lastNum = 0;
        int count = 0;
        String calibrated = "";
        int calibrated2;
        for(int i = 0; i < line.length(); i++){
            try{
                Integer.parseInt(line.substring(i,i+1));
                count++;
                isInt = true;
            } catch (NumberFormatException e){
                isInt = false;
            }
            if (isInt && count == 1) {
                firstNum = Integer.parseInt(line.substring(i,i+1));
            }
            if(isInt && count != 1){
                lastNum = Integer.parseInt(line.substring(i, i+1));
            }

        }
        calibrated = String.valueOf(firstNum) + String.valueOf(lastNum);
        calibrated2 = Integer.parseInt(calibrated);
        numbers.add(calibrated2);

    }

    public static int getPartTwoNumber(String line) {
        // do part 2
        return 0;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}