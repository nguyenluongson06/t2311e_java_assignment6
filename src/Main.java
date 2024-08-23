import com.model.*;

import java.util.Scanner;

public class Main {
    public static Person[] people = new Person[3];
    public static void main(String[] args) {

    }

    public static void enterInfo(){
        ManagementPerson manager = new ManagementPerson();
        Scanner input = new Scanner(System.in);
        System.out.println("=====Management Person program=====");
        System.out.print("Please input name: ");
        String name = input.nextLine();
        System.out.print("Please input address: ");
        String address = input.nextLine();
        System.out.print("Please input salary: ");
        String salary = input.nextLine();
        try {
            Person newPerson = manager.inputPersonInfo(name, address, salary);
            while (newPerson == null){
                System.out.print("Please input salary:");
                salary = input.nextLine();
                newPerson = manager.inputPersonInfo(name, address, salary);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
