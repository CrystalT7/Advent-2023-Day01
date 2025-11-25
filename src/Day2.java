/*
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ArrayList<String> lines = getFileData("src/data");

        int partOneAnswer = 0;
        int partTwoAnswer = 0;
        for (int i = 0; i < lines.size(); i++) {
            partOneAnswer += day2getPartOneNumber(lines.get(i));
            partTwoAnswer += day2getPartTwoNumber(lines.get(i));
        }

        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part two answer: " + partTwoAnswer);
    }

    public static int day2getPartOneNumber(String line){
        int redCubes = 12;
        int greenCubes = 13;
        int blueCubes = 14;

        int gameID = Integer.parseInt(line.substring(5, line.indexOf(":")));
        String[] colorVals = line.substring(line.indexOf(":")+2).split("; ");
        for(int i = 0; i < colorVals.length; i++){
            String[] colorVals2 = colorVals[i].split(", ");
            for(int j = 0; j < colorVals2.length; j++){
                int s = colorVals2[j].indexOf(" ");
                if (colorVals2[j].contains("red")) {
                    if (Integer.parseInt(colorVals2[j].substring(0, s)) > 12) {
                        return 0;
                    }
                }
                if (colorVals2[j].contains("green")) {
                    if (Integer.parseInt(colorVals2[j].substring(0, s)) > 13) {
                        return 0;
                    }
                }
                if (colorVals2[j].contains("blue")) {
                    if (Integer.parseInt(colorVals2[j].substring(0, s)) > 14) {
                        return 0;
                    }
                }
            }
        }
        return gameID;

    }

    public static int day2getPartTwoNumber(String line){
        int gameID = Integer.parseInt(line.substring(5, line.indexOf(":")));
        String[] val = line.substring(line.indexOf(":") + 2).split("; ");
        int red = 0;
        int green = 0;
        int blue = 0;
        for (String str : val) {
            String[] val2 = str.split(", ");
            for (String str2 : val2) {
                int s = str2.indexOf(" ");
                if (str2.contains("red")) {
                    if (Integer.parseInt(str2.substring(0, s)) > red) {
                        red = Integer.parseInt(str2.substring(0, s));
                    }
                }
                if (str2.contains("green")) {
                    if (Integer.parseInt(str2.substring(0, s)) > green) {
                        green = Integer.parseInt(str2.substring(0, s));
                    }
                }
                if (str2.contains("blue")) {
                    if (Integer.parseInt(str2.substring(0, s)) > blue) {
                        blue = Integer.parseInt(str2.substring(0, s));
                    }
                }
            }
        }
        return red * green * blue;
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
*/
