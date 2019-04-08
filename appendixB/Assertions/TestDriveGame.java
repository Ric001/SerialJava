

import java.util.Scanner;
public class TestDriveGame  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int height = sc.nextInt();
        int weight = height + 20;
        assert (height > 0) : "height = " + 
        height + " weight = " + weight;
        System.out.println("No somos tan distintos");
    }
}