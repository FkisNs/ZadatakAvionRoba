package zadaci;

import java.sql.ResultSet;

public class Konstante {
    public static final String DATABASE_URL="jdbc:sqlite:avionRoba.db";
    public static void prikazUniverzalan(ResultSet rs) throws Exception{
        int columnCount=rs.getMetaData().getColumnCount();
        while (rs.next()){
            for( int i=1; i<=columnCount;i++)
                System.out.print(rs.getMetaData().getColumnName(i) + " " + rs.getObject(i)+ " ");
            System.out.println();
        }
    }
}

