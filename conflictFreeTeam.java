import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Employee {
    int skill;

    Employee(int skill) {
        this.skill = skill;
    }
}

public class conflictFreeTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of employees
        int c = scanner.nextInt(); // Number of conflict pairs

        Employee[] employees = new Employee[n];

        // Read conflict pairs
        int[] conflictPairs = new int[c * 2];
        for (int i = 0; i < c * 2; i++) {
            conflictPairs[i] = scanner.nextInt();
        }

        // Read expertise levels of employees
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee(scanner.nextInt());
        }

        int result = getMaxExpertise(employees, conflictPairs, n);
        System.out.println(result);
    }
}
