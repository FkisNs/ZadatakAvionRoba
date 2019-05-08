package zadaci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:avionRoba.db");
            System.out.println("Uspesno uspostavljena konekcija");
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }finally {
            try{
                c.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
