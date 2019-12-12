import java.text.SimpleDateFormat;
import java.util.Date;

public class Person{

    private String firstName, lastName, address1, address2, city, state, country, zip;
    private Date startDate;


    public Person(String firstName, String lastName, Date startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        // Default fields
        country = "USA";
        state = "CA";
    }

    public Person(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setAddress1(String address) {
        this.address1 = address;
    }

    public void setAddress2(String address) {
        this.address2 = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");

        StringBuilder info = new StringBuilder("");
        if(address1 != null || address2 != null){
            if(address1 != null)
                info.append(address1).append(", ");
            if(address2 != null)
                info.append(address2).append(", ");
            info.append("\n");
        }
        if(city != null)
            info.append(city).append(", ");
        info.append(state).append(",\n");
        info.append(country);
        if(zip != null)
            info.append(", ").append(zip);
        info.append("\n");

        return  firstName + " " + lastName + ", " + "(" + sdf.format(startDate) + ")" + "\n" +
                info.toString();
    }
}
