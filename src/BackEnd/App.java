package BackEnd;

import UI.MainMenu;
import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws IOException, SQLException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.initialize();
    }
}
