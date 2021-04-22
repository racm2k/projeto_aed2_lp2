package edu.ufp.inf.lp2;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class Utilizador {

    private UserType tipo;
    private Integer id;
    private RedBlackBST<Integer,Cache> hiddenCaches;
    private RedBlackBST<Integer,Cache> visitedCaches;
    private RedBlackBST<Integer,TravelBug> travelBugs;

    public static ST<Integer,Utilizador> utilizadores;


    public Integer getId() {
        return id;
    }

    public UserType getTipo() {
        return tipo;
    }

    public void setTipo(UserType tipo) {
        this.tipo = tipo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /************************  HIDDEN CACHES *************************/

    public void listHiddenCaches() {
        for (Integer hkey : hiddenCaches.keys())
            StdOut.println(hkey + " " + hiddenCaches.get(hkey));
    }

    public void addHiddenCache(Cache c){
        if (this.hiddenCaches.contains(c.getId())){
            System.out.println("addHiddenCache() - Utilizador : Cache already in ST!");
            return;
        }
        this.hiddenCaches.put(c.getId(),c);
    }

    public void removeHiddenCache(Cache c){
        if (this.hiddenCaches.contains(c.getId())){
            this.hiddenCaches.delete(c.getId());
        }else
            System.out.println("removeHiddenCache() - Utilizador : Cache does not exist in ST!");
    }

    public void editHiddenCache(Cache c,Integer id, CacheType tipo, CacheDifficulty dificuldade, Localizacao localizacao ){
        if (this.hiddenCaches.contains(c.getId())){
            c.setId(id);
            c.setTipo(tipo);
            c.setDificuldade(dificuldade);
            c.setLocal_cache(localizacao);
        }else
            System.out.println("editHiddenCache() - Utilizador : Error editing Cache!");
    }

    /************************  VISITED CACHES *************************/

    public void listVisitedCaches() {
        for (Integer vkey : visitedCaches.keys())
            StdOut.println(vkey + " " + visitedCaches.get(vkey));
    }


    public void addVisitedCache(Cache c){
        if (this.visitedCaches.contains(c.getId())){
            System.out.println("addVisitedCache() - Utilizador : Cache already in ST!");
            return;
        }
        this.visitedCaches.put(c.getId(),c);
    }

    public void removeVisitedCache(Cache c){
        if (this.visitedCaches.contains(c.getId())){
            this.visitedCaches.delete(c.getId());
        }else
            System.out.println("removeVisitedCache() - Utilizador : Cache does not exist in ST!");
    }

    /************************  TRAVEL BUGS *************************/

    public void listTravelBugs() {
        for (Integer tbkey : travelBugs.keys())
            StdOut.println(tbkey + " " + travelBugs.get(tbkey));
    }

    public void addTravelBug(TravelBug tb){
        if (this.travelBugs.contains(tb.getId())){
            System.out.println("addTravelBug() - Utilizador : TravelBug already in ST!");
            return;
        }
        this.travelBugs.put(tb.getId(),tb);
    }

    public void removeTravelBug(Cache c){
        if (this.travelBugs.contains(c.getId())){
            this.travelBugs.delete(c.getId());
        }else
            System.out.println("removeTravelBug() - Utilizador : TravelBug does not exist in ST!");
    }

    public void editTravelBug(TravelBug tb, Localizacao local_bug, Utilizador user ){
        if (this.travelBugs.contains(tb.getId())){
            tb.setId(id);
            tb.setLocal_bug(local_bug);
            tb.setDono(user);
        }else
            System.out.println("editTravelBug() - Utilizador : Error editing Travel Bug!");
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "tipo=" + tipo +
                ", id=" + id +
                '}';
    }
}
