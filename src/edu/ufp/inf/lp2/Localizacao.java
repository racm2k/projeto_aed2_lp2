package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.ST;

import java.util.HashMap;

public class Localizacao {
    private double latitude;
    private double longitude;
    private String zona;

    public static HashMap<Integer,Localizacao> localizacoes;

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
