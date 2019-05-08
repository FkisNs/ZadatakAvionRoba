package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;
import java.util.List;

import java.io.IOException;



public class Zadatak2DodavanjeVrednosti {
    static Dao<Avion,Integer>AvionDao;
    static Dao<Roba,Integer>RobaDao;
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try{
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            AvionDao = DaoManager.createDao(connectionSource, Avion.class);
            RobaDao = DaoManager.createDao(connectionSource, Roba.class);

            TableUtils.clearTable(connectionSource,Avion.class);
            TableUtils.clearTable(connectionSource,Roba.class);

            Avion a1 = new Avion("Avion1",34);
            AvionDao.create(a1);
            Avion a2 = new Avion("Avion2", 21);
            AvionDao.create(a2);

            Roba r1 = new Roba("Patike", "Duboke patike", 1.0,a1);
            RobaDao.create(r1);
            Roba r2 = new Roba("Kosulja", "Na duge rukave", 0.4,a1);
            RobaDao.create(r2);
            Roba r3 = new Roba("Voda", "Voda za pice", 1.4,a1);
            RobaDao.create(r3);
            Roba r4 = new Roba("Ploce", "Drvene ploce", 3.4,a2);
            RobaDao.create(r4);
            Roba r5 = new Roba("Stolica", "Plasticna stolica", 2.4,a2);
            RobaDao.create(r5);

            List<Roba> robe = RobaDao.queryForAll();
            for(Roba r:robe)
                System.out.println(r);
            List<Avion> avioni = AvionDao.queryForAll();
            for(Avion a : avioni)
                System.out.println(a);

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
