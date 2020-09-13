package BackEnd;

public class PassCheckUser {
    String enteredUserName;
    String enteredPassword;

    public PassCheckUser(String enteredUserName, String enteredPassword) {
        this.enteredUserName = enteredUserName;
        this.enteredPassword = enteredPassword;
    }

    public String getEnteredUserName() {
        return enteredUserName;
    }

    public String getEnteredPassword() {
        return enteredPassword;
    }
}
