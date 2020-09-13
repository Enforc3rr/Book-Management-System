package BackEnd;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DAO {
    Properties properties = new Properties();
    public void setUserValues(UserDetails userDetails) throws IOException {
        try {
            properties.load(new FileInputStream("D:\\sql.properties"));
            String url = properties.getProperty("url");
            String userNameSQL = properties.getProperty("user");
            String passwordSQL = properties.getProperty("password");
            Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
            PreparedStatement statement = connection.prepareStatement("insert into user (name ,userName ,mobileNumber , address , email , password)" + "VALUES (? , ?  , ? , ? , ? , ?)");
            statement.setString(1, userDetails.getName());
            statement.setString(2, userDetails.getUserName());
            statement.setString(3, userDetails.getMobileNumber());
            statement.setString(4, userDetails.getAddress());
            statement.setString(5, userDetails.getEmail());
            statement.setString(6, userDetails.getPassword());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "You've Been Added To Book Management System.");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"USERNAME IS ALREADY TAKEN TRY AGAIN WITH DIFFERENT USERNAME");
        }
    }
    public boolean checkUserLoginDetails(PassCheckUser passCheckUser) throws IOException, SQLException {
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url,userNameSQL,passwordSQL);
       PreparedStatement statement = connection.prepareStatement("select * from user where userName = ?");
       statement.setString(1,passCheckUser.enteredUserName);
       ResultSet rs = statement.executeQuery();
       while (rs.next()){
           String storedPassword = rs.getString("password");
           if(storedPassword.equals(passCheckUser.enteredPassword)){
               PreparedStatement addingTemp = connection.prepareStatement("update temp set tempUserName = ? where id = 1");
               addingTemp.setString(1,passCheckUser.enteredUserName);
               addingTemp.executeUpdate();
               return  true;
           }
       }
    return false;
    }
    public void setBookValues(BookDetails bookDetails) throws IOException {
        try {
            properties.load(new FileInputStream("D:\\sql.properties"));
            String url = properties.getProperty("url");
            String userNameSQL = properties.getProperty("user");
            String passwordSQL = properties.getProperty("password");
            Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
            PreparedStatement statement = connection.prepareStatement("insert  into books (bookName , authorName , genre , yearOfPublication , description)" + "Values(?,?,?,?,?)");
            statement.setString(1, bookDetails.getNameOfBook());
            statement.setString(2, bookDetails.getNameOfAuthor());
            statement.setString(3, bookDetails.getGenreOfBook());
            statement.setString(4, bookDetails.getYearOfPublication());
            statement.setString(5, bookDetails.getDescription());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Book Has Been Successfully Added");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"BOOK IS ALREADY PRESENT");
        }
    }
    public void changePassValue(ChangePassValues changePassValues) throws  IOException , SQLException {
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url,userNameSQL,passwordSQL);
        Statement tempStatement = connection.createStatement();
        String tempUserName = "" ;
        ResultSet rs = tempStatement.executeQuery("SELECT tempUserName from temp where id = 1");
        while (rs.next()){
            tempUserName = rs.getString("tempUserName");
        }
        PreparedStatement statement = connection.prepareStatement("UPDATE user set password = ? where userName = ? ");
        statement.setString(1,changePassValues.getNewPass());
        statement.setString(2,tempUserName);
        statement.executeUpdate();
    }
    public void changePassValueAdmin(String changePassAdmin)throws IOException , SQLException{
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url,userNameSQL,passwordSQL);
        PreparedStatement statement = connection.prepareStatement("UPDATE admin set adminPassword = ? where adminUserName = ? ");
        statement.setString(1,changePassAdmin);
        statement.setString(2,"Admin");
        statement.executeUpdate();
    }
    public void showUsers(JTable table) throws  IOException , SQLException {
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
        PreparedStatement statement = connection.prepareStatement("select * from user");
        ResultSet rs = statement.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public void showTableBooks(JTable table) throws  IOException , SQLException {
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
        PreparedStatement statement = connection.prepareStatement("select * from books");
        ResultSet rs = statement.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public void searchUsers(String userName , JTable table) throws  IOException , SQLException{
        userName += "%";
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
        PreparedStatement statement = connection.prepareStatement("select * from user where userName like ? order by userName");
        statement.setString(1,userName);
        ResultSet rs = statement.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public void searchBookTableByName(String nameOfBook ,JTable table ) throws  IOException , SQLException  {
        nameOfBook += "%";
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
        PreparedStatement statement = connection.prepareStatement("select * from books where bookName like ? order by bookName");
        statement.setString(1,nameOfBook);
        ResultSet rs = statement.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public void searchBookTableByYear(JTable table , String year)throws  IOException , SQLException{
        year += "%";
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
        PreparedStatement statement = connection.prepareStatement("select * from books where yearOfPublication like ? order by yearOfPublication");
        statement.setString(1,year);
        ResultSet rs = statement.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public void searchBookTableByNameAuthor(JTable table , String nameAuthor)throws  IOException , SQLException{
        nameAuthor += "%";
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
        PreparedStatement statement = connection.prepareStatement("select * from books where authorName like ? order by authorName");
        statement.setString(1,nameAuthor);
        ResultSet rs = statement.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public void searchBookTableByGenre(JTable table , String genre)throws  IOException , SQLException{
        genre += "%";
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
        PreparedStatement statement = connection.prepareStatement("select * from books where genre like ? order by genre");
        statement.setString(1,genre);
        ResultSet rs = statement.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public void deleteBook(String bookName) throws  IOException , SQLException{
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
        PreparedStatement statement = connection.prepareStatement("DELETE  from books where bookName = ?");
        statement.setString(1,bookName);
        statement.executeUpdate();
    }
    public void deleteUser(String userName) throws  IOException , SQLException{
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, userNameSQL, passwordSQL);
        PreparedStatement statement = connection.prepareStatement("DELETE  from user where userName = ?");
        statement.setString(1,userName);
        statement.executeUpdate();
    }
    public boolean checkAdminLoginDetails(PassCheckUser passCheckUser) throws IOException, SQLException {
        properties.load(new FileInputStream("D:\\sql.properties"));
        String url = properties.getProperty("url");
        String userNameSQL = properties.getProperty("user");
        String passwordSQL = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url,userNameSQL,passwordSQL);
        PreparedStatement statement = connection.prepareStatement("select * from admin where adminUserName = ?");
        statement.setString(1,passCheckUser.enteredUserName);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            String storedPassword = rs.getString("adminPassword");
            if(storedPassword.equals(passCheckUser.enteredPassword)){
                return  true;
            }
        }
        return false;
    }
}
