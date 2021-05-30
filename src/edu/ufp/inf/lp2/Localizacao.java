package edu.ufp.inf.lp2;


import java.io.Serializable;

public class Localizacao implements Serializable {
    private Integer id;
    private double latitude;
    private double longitude;
    private String zona;





    public Localizacao(Integer id, double latitude, double longitude, String zona) {
        this.id=id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zona = zona;
    }

    public Localizacao(Integer id) {
        this.id=id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }






    @Override
    public String toString() {
        return "Localizacao{\n    id: '" + id +
                "',\n    latitude: '" + latitude +
                "',\n    longitude: '" + longitude +
                "',\n    zona: '" + zona +
                "'\n}\n";
    }


}
