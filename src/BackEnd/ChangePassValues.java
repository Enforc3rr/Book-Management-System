package BackEnd;

public class ChangePassValues {
    private String newPass;
    private String confirmPass;

    public ChangePassValues(String newPass, String confirmPass) {
        this.newPass = newPass;
        this.confirmPass = confirmPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }
}
