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

        int firstNum = 0;
        int lastNum = 0;

        for(int i = 0; i < line.length(); i++){
            char letter = line.charAt(i);
            if(letter >= '0' && letter <= '9'){
                int number = letter - '0';
                if(firstNum == 0){
                    firstNum = number;
                }
                lastNum = number;
            }
        }
        return firstNum * 10 + lastNum;
    }

    public static int getPartTwoNumber(String line) {
        ArrayList<Integer> nums = new ArrayList<>();
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String [] numToWord = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < line.length(); i++){
            String something = line.substring(i, i +1);
            for(int j = 0; j < numbers.length; j++){
                if(something.equals(numbers[j])){
                    nums.add(j);
                }
            }

            for(int k = 0; k < numToWord.length; k++){
                String word = numToWord[k];
                if(i + word.length() <= line.length()){
                    String part = line.substring(i, i + word.length());
                    if(part.equals(word)) {
                        nums.add(k);
                    }
                }
            }
        }
        int first = nums.get(0);
        int last = nums.get(nums.size()-1);
        return first * 10 + last;


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