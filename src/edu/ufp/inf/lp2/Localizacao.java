package edu.ufp.inf.lp2;



import java.util.HashMap;

public class Localizacao {
    private Integer id;
    private double latitude;
    private double longitude;
    private String zona;

    public static HashMap<Integer,Localizacao> localizacoes = new HashMap<>();
    public static HashMap<Integer,Localizacao> deleted_localizacoes = new HashMap<>();


    public Localizacao(Integer id,double latitude, double longitude, String zona) {
        this.id=id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zona = zona;
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

    public void delete(){
        if (localizacoes.containsValue(this)){
            deleted_localizacoes.put(this.id,this);
            localizacoes.remove(this.id);

        }
    }

    @Override
    public String toString() {
        return "Localizacao{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", zona='" + zona + '\'' +
                '}';
    }
}
