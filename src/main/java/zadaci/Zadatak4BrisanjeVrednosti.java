package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.util.List;


public class Zadatak4BrisanjeVrednosti {
    static Dao<Avion,Integer> AvionDao;
    static Dao<Roba,Integer>RobaDao;
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try{
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            AvionDao = DaoManager.createDao(connectionSource, Avion.class);
            RobaDao = DaoManager.createDao(connectionSource, Roba.class);
            List<Roba> robe = RobaDao.queryForAll();
            for(Roba r:robe)
                System.out.println(r);

            Roba rDel = RobaDao.queryForEq(Roba.POLJE_NAZIV, "Voda").get(0);
            RobaDao.delete(rDel);

            robe = RobaDao.queryForAll();
            for(Roba r:robe)
                System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
