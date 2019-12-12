import java.io.*;
import java.util.Comparator;
import java.util.Scanner;

public class TestPlanetP {

    public static void main(String[] args){

        ReadAndSort rs = new ReadAndSort(new File(args[0]));

        Comparator comparator = Comparator.comparing(Person::getStartDate);
        switch(Integer.parseInt(args[1])) {
            case 1:
                comparator = Comparator.comparing(Person::getFirstName);
                break;
            case 2:
                comparator = Comparator.comparing(Person::getLastName);
                break;
        }
        rs.print(comparator);
    }


}
