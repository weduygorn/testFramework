package data;

import static helpers.DateTimeHelper.currentDateMinusNYears;

public enum Passenger {

    JOHNY("Johny", "Depp", "Adult", "Mr", "vladislav.piskunov@amadeus.com", "Skovorody 19", "22222", "Kiev", "123123"),
    JOAN("Joan", "West", "Adult", "Mr", null, null, null, null, null),
    RON("Ron", "Stone", "Adult", "Mr", null, null, null, null, null),
    FRED("Fred", "Claus", "Adult", "Mr", null, null, null, null, null),
    ADAM("Adam", "Baker", "Adult", "Mr", null, null, null, null, null),
    SAM("Sam", "White", "Child", "Mr", null, null, null, null, null),
    BOB("Bob", "Marley", "Child", "Mr", null, null, null, null, null),
    ALEX("Alex", "Reeves", "Child", "Mr", null, null, null, null, null),
    DAVID("David", "Blake", "Infant", "Mr", null, null, null, null, null),
    PAUL("Paul", "King", "Adult", "Mr", null, null, null, null, null);

    private String firstName;
    private String lastName;
    private String type;
    private String birthDate;
    private String salutation;
    private String email;
    private String street;
    private String postcode;
    private String city;
    private String phone;


    public String getBirthDate() {
        switch (getType()) {
            case "Adult":
                birthDate = currentDateMinusNYears(30);
                return birthDate;
            case "Child":
                birthDate = currentDateMinusNYears(7);
                return birthDate;
            case "Infant":
                birthDate = currentDateMinusNYears(1);
                return birthDate;

            default:
                throw new AssertionError("Unsupported passenger type: " + getType());

        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getType() {
        return type;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    Passenger(String firstName, String lastName, String type, String salutation, String email, String street, String postcode, String city, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.salutation = salutation;
        this.email = email;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
        this.birthDate = getBirthDate();
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", salutation='" + salutation + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
