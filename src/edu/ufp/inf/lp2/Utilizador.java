package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class Utilizador {

    private String tipo;
    private Integer id;
    private String nome;
    private RedBlackBST<Integer, Cache> hiddenCaches = new RedBlackBST<>();
    private RedBlackBST<Integer, Cache> visitedCaches = new RedBlackBST<>();
    private ST<Integer, TravelBug> travelBugs = new ST<>();


    public Utilizador(String tipo, Integer id, String nome) {
        this.tipo = tipo;
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public void addHiddenCache(Cache c) {
        if (this.hiddenCaches.contains(c.getId())) {
            System.out.println("addHiddenCache() - Utilizador : Cache already in ST!");
        } else {
            this.hiddenCaches.put(c.getId(), c);
            System.out.println("Hidden Cache added!");
        }
    }

    public void removeHiddenCache(Integer id) {
        if (this.hiddenCaches.contains(id)) {
            this.hiddenCaches.delete(id);
            System.out.println("Hidden Cache removida!");
        } else
            System.out.println("removeHiddenCache() - Utilizador : Cache does not exist in ST!");
    }

    public void editHiddenCache(Cache c, Integer id, String tipo, String dificuldade, Localizacao localizacao) {
        Cache c1 = new Cache(id, tipo, dificuldade, localizacao);
        if (this.hiddenCaches.contains(c.getId())) {
            this.hiddenCaches.delete(c.getId());
            this.hiddenCaches.put(c1.getId(), c1);
            System.out.println("Hidden Cache editada com sucesso!");
        } else
            System.out.println("editHiddenCache() - Utilizador : Error editing Cache!");
    }

    /************************  VISITED CACHES *************************/

    public void listVisitedCaches() {
        for (Integer vkey : visitedCaches.keys())
            StdOut.println(vkey + " " + visitedCaches.get(vkey));
    }


    public void addVisitedCache(Cache c) {
        if (this.visitedCaches.contains(c.getId())) {
            System.out.println("addVisitedCache() - Utilizador : Cache already in ST!");
        } else {
            this.visitedCaches.put(c.getId(), c);
            System.out.println("Visited Cache added!");
        }
    }

    public void removeVisitedCache(Integer id) {
        if (this.visitedCaches.contains(id)) {
            this.visitedCaches.delete(id);
        } else
            System.out.println("removeVisitedCache() - Utilizador : Cache does not exist in ST!");
    }

    public void editVisitedCache(Cache c, Integer id, String tipo, String dificuldade, Localizacao localizacao) {
        Cache c1 = new Cache(id, tipo, dificuldade, localizacao);
        if (this.visitedCaches.contains(c.getId())) {
            this.visitedCaches.delete(c.getId());
            this.visitedCaches.put(c1.getId(), c1);
            System.out.println("Visited Cache editada com sucesso!");
        } else
            System.out.println("editVisitedCache() - Utilizador : Error editing Cache!");
    }

    /************************  TRAVEL BUGS *************************/

    public void listTravelBugs() {
        for (Integer tbkey : travelBugs.keys())
            StdOut.println(tbkey + " " + travelBugs.get(tbkey));
    }

    public ST<Integer,TravelBug> getTravelBugs(){
        return this.travelBugs;
    }

    public void addTravelBug(TravelBug tb) {
        if (this.travelBugs.contains(tb.getId())) {
            System.out.println("addTravelBug() - Utilizador : TravelBug already in ST!");
            return;
        }
        this.travelBugs.put(tb.getId(), tb);
    }

    public void removeTravelBug(TravelBug tb) {
        if (this.travelBugs.contains(tb.getId())) {
            this.travelBugs.delete(tb.getId());
        } else
            System.out.println("removeTravelBug() - Utilizador : TravelBug does not exist in ST!");
    }

    public void editTravelBug(TravelBug tb, Cache cache, Utilizador user) {
        if (this.travelBugs.contains(tb.getId())) {
            tb.setId(id);
            tb.setBugCache(cache);
            tb.setDono(user);
        } else
            System.out.println("editTravelBug() - Utilizador : Error editing Travel Bug!");
    }


    @Override
    public String toString() {
        return tipo+" User {\n    id: '" + id + "',\n    nome: '" + nome + "'\n}\n";
    }

}
