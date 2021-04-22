package edu.ufp.inf.lp2;

public class Localizacao {
    private double latitude;
    private double longitude;
    private String zona;

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

    @Override
    public String toString() {
        return "Localizacao{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", zona='" + zona + '\'' +
                '}';
    }
}
