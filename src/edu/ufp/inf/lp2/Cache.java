package edu.ufp.inf.lp2;


import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;


public class Cache {
    private Integer id;
    private CacheType tipo;

    private CacheDifficulty dificuldade;

    private Localizacao local_cache;
    private RedBlackBST<Integer,Log> logs;
    private RedBlackBST<Integer,Item> items;

    public Cache(Integer id, CacheType tipo, CacheDifficulty dificuldade, Localizacao local_cache) {
        this.id = id;
        this.tipo = tipo;
        this.dificuldade = dificuldade;
        this.local_cache = local_cache;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CacheType getTipo() {
        return tipo;
    }

    public void setTipo(CacheType tipo) {
        this.tipo = tipo;
    }

    public CacheDifficulty getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(CacheDifficulty dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setLocal_cache(Localizacao local_cache) {
        this.local_cache = local_cache;
    }

    public Localizacao getLocal_cache() {
        return local_cache;
    }

    public void getLogs() {
        for (Integer lkey : logs.keys()) {
            System.out.println("Logs of Cache "+this.getId());
            System.out.println(lkey + " " + logs.get(lkey));
        }
    }

    public void addLog(Log l){
        if (this.logs.contains(l.getUserID())){
            System.out.println("addLog() - Cache : User already logged in this cache!");
            return;
        }
        this.logs.put(l.getUserID(), l);
    }

    public void removeLog(Log l){
        if (this.logs.contains(l.getUserID())){
            this.logs.delete(l.getUserID());
        }else{
            System.out.println("Log não encontrado!");
        }
    }

    public void listItems() {
        for (Integer ikey : items.keys()) {
            System.out.println("Items of Cache " + this.getId());
            System.out.println(ikey + " " + items.get(ikey));
        }
    }

    public void addItem(Item i){
        if (this.items.contains(i.getId())){
            System.out.println("addItem() - Cache : Item already in this cache!");
            return;
        }
        this.items.put(i.getId(),i);
    }

    public void removeItem(Item i){
        if (this.items.contains(i.getId())){
            this.items.delete(i.getId());
        }
    }

    public void editItem(Item i, Integer id){
        if (this.items.contains(i.getId())){
            this.items.get(i.getId()).setId(id);
        }else
            System.out.println("editItem() - Cache : Item não encontrado.");
    }


    @Override
    public String toString() {
        return "Cache{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", dificuldade=" + dificuldade +
                ", local_cache=" + local_cache +
                '}';
    }
}