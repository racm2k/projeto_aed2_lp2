package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.RedBlackBST;

public class Cache {
    private Integer id;
    private String tipo;
    private String dificuldade;
    private Localizacao local_cache;



    private RedBlackBST<Integer, Log> logs = new RedBlackBST<>();
    private RedBlackBST<Integer, Item> items = new RedBlackBST<>();

    public Cache(Integer id, String tipo, String dificuldade, Localizacao local_cache) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setLocal_cache(Localizacao local_cache) {
        this.local_cache = local_cache;
    }

    public Localizacao getLocal_cache(){
        return this.local_cache;
    }

    /************************  LOGS *************************/

    public RedBlackBST<Integer, Log> getLogs() {
        return logs;
    }

    public void addLog(Log l) {
        if (this.logs.contains(l.getId())) {
            System.out.println("addLog() - Cache : User already logged in this cache!");
        } else {
            this.logs.put(l.getId(), l);
        }
    }

    public void removeLog(Log l) {
        if (this.logs.contains(l.getId())) {
            this.logs.delete(l.getId());
        } else {
            System.out.println("Log não encontrado!");
        }
    }

    /************************  ITEMS *************************/

    public void listItems() {
        System.out.println("Items of Cache " + this.getId());
        for (Integer ikey : items.keys()) {
            System.out.println(ikey + " " + items.get(ikey));
        }
    }

    public void addItem(Item i) {
        if (this.items.contains(i.getId())) {
            System.out.println("addItem() - Cache : Item already in this cache!");
            return;
        }
        this.items.put(i.getId(), i);
    }

    public void removeItem(Item i) {
        if (this.items.contains(i.getId())) {
            items.delete(i.getId());
            this.items.delete(i.getId());
        }
    }

    public RedBlackBST<Integer,Item> getItems(){
        return items;
    }

    public void editItem(Item i, Integer id) {
        if (this.items.contains(i.getId())) {
            this.items.get(i.getId()).setId(id);
            items.get(i.getId()).setId(id);
        } else
            System.out.println("editItem() - Cache : Item não encontrado.");
    }

    @Override
    public String toString() {
        return "Cache{\n    id: '" + id +
                "',\n    tipo: '" + tipo +
                "',\n    dificuldade: '" + dificuldade +
                "',\n    location: '" + local_cache +
                "'\n}\n";
    }
}
