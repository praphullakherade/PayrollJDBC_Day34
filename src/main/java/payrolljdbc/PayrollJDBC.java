package payrolljdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PayrollJDBC {
    public static void main(String[] args) {
        String jdbcurl = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String username = "root";
        String password = "Prafull@123";
        Connection connection;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        listDrivers();
        try{
            System.out.println("Connecting database: " +jdbcurl);
            connection = DriverManager.getConnection(jdbcurl, username, password);
            System.out.println("Connection is successful " +connection);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private  static void listDrivers(){
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " +driverClass.getClass().getName());
        }
    }
}
