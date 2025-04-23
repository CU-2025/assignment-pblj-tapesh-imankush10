import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exp5 {
    public static Integer convertStringToInt(String str) {
        return Integer.valueOf(str);
    }

    public static int getTotal(List<Integer> nums) {
        int total = 0;
        for (Integer n : nums) {
            total += n;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();
        System.out.println("Enter integers separated by spaces: ");
        String line = scanner.nextLine();
        String[] tokens = line.trim().split("\\s+");
        for (String token : tokens) {
            numList.add(convertStringToInt(token));
        }
        int total = getTotal(numList);
        System.out.println("The sum of the integers is: " + total);
        scanner.close();
    }
}
