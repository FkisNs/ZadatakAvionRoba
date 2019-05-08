package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;


@DatabaseTable(tableName = "Avion")
public class Avion {
    public static final String POLJE_NAZIV ="naziv";
    public static final String POLJE_RASPON_KRILA ="rasponKrila";

@DatabaseField(generatedId = true)
    private int id;
@DatabaseField(columnName = POLJE_NAZIV, canBeNull = false)
    private String naziv;
@DatabaseField(columnName = POLJE_RASPON_KRILA, canBeNull = false)
    private int rasponKrila;

    @ForeignCollectionField(foreignFieldName = "avion")
    private ForeignCollection<Roba> roba;

    public Avion() {
    }

    public Avion(String naziv, int rasponKrila) {
        this.naziv = naziv;
        this.rasponKrila = rasponKrila;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getRasponKrila() {
        return rasponKrila;
    }

    public void setRasponKrila(int rasponKrila) {
        this.rasponKrila = rasponKrila;
    }

    public ForeignCollection<Roba> getRoba() {
        return roba;
    }

    public void setRoba(ForeignCollection<Roba> roba) {
        this.roba = roba;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", rasponKrila=" + rasponKrila +
                '}';
    }
}
