package BackEnd;

public class UserDetails {
    private String name ;
    private String userName;
    private String mobileNumber;
    private String address;
    private String email;
    private String password;

    public UserDetails(String name, String userName, String mobileNumber, String address, String email, String password){
        this.name = name;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
