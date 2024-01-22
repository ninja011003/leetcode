import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCase {
    public static Integer[] TestCaseArr(String fileName){
        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file).useDelimiter(",");
            List<Integer> integerList = new ArrayList<>();
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                integerList.add(num);
            }
            return integerList.toArray(new Integer[0]);
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found.");
            System.out.println("File should in the same directory as this file!");
            return null;
        }
        catch(Exception e){
            System.out.println("Error Occured:-\n"+e.getMessage());
            return null;
        }
    }
}
