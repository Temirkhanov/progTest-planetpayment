import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadAndSort {

    private File file;
    private List<Person> list;

    ReadAndSort(File file) {
        this.file = file;
        list = new ArrayList<>();
        loadRecords();
    }

    private String format(String str){
        String address1="", address3="";
        // Get Rest of the Info
        for(int i = str.length()-1, count = 4; count != 0; i--){
            if(str.charAt(i) == ' ')
                count--;
            if(count == 0) {
                address3 = str.substring(i).replace(" ", ",");
                if(str.charAt(i-1) == '*')
                    address1 = str.substring(0, i-2) + ",*";
                else {
                    int last = str.substring(0, i-1).lastIndexOf(' ');
                    last = str.substring(0, last).lastIndexOf(' ');
                    address1 = str.substring(0, last) + "," + str.substring(last+1, i);
                }
            }
        }
        return address1 + address3;
    }


    private void loadRecords(){
        try {
            Scanner inFile = new Scanner(new FileReader(file));
            char separator = inFile.nextLine().equals("1") ? ' ' : ',';
            while(inFile.hasNext()){
                String line = inFile.nextLine();
                line = line.replace(separator +""+ separator, separator +"*"+ separator);
                // Required fields: First Name, Last Name, Start Date. Storing rest of the info as the last element.
                String[] info = line.split(separator +"", 4);
                Person p = new Person(info[0], info[1], new SimpleDateFormat("yyyyMMdd").parse(info[2]));
                // Rest of the info. Optional fields.
                if(separator == ' ')
                    info[3] = format(info[3]);
                info = info[3].split(",");

                if(!info[0].contains("*"))
                    p.setAddress1(info[0]);
                if(!info[1].contains("*"))
                    p.setAddress2(info[1]);
                if(!info[2].contains("*"))
                    p.setCity(info[2]);
                if(!info[3].contains("*"))
                    p.setState(info[3]);
                if(!info[4].contains("*"))
                    p.setCountry(info[4]);
                if(!info[5].contains("*"))
                    p.setZip(info[5]);

                list.add(p);
            } // while
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }

    void print(Comparator comparator){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("output.txt", "UTF-8");
            list.sort(comparator);
            for(int i = 0; i < list.size(); i++){
                writer.println(i+1);
                writer.println(list.get(i).toString());
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
/*
    void sortByFirstName(){
        PrintWriter writer = null;
        try {
            Comparator comparator = Comparator.comparing(Person::getFirstName);
            writer = new PrintWriter("output.txt", "UTF-8");
            list.sort(Comparator.comparing(Person::getFirstName));
            for(int i = 0; i < list.size(); i++){
                writer.println(i+1);
                writer.println(list.get(i).toString());
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    void sortByLastName(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("output.txt", "UTF-8");
            list.sort(Comparator.comparing(Person::getLastName));
            for(int i = 0; i < list.size(); i++){
                writer.println(i+1);
                writer.println(list.get(i).toString());
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    void sortByStartDate(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("output.txt", "UTF-8");
            list.sort(Comparator.comparing(Person::getStartDate));
            for(int i = 0; i < list.size(); i++){
                writer.println(i+1);
                writer.println(list.get(i).toString());
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
*/

}

