package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;


public class Item {

  private Integer id;

  private RedBlackBST<Integer,Cache> historicoCaches;

  public static ST<Integer,Item> items;

public Item(){

}
  public Item(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void getHistoricoCaches() {
    for (Integer ckey : this.historicoCaches.keys())
      StdOut.println(ckey + " " + this.historicoCaches.get(ckey));
  }

  public void addHistoricoCaches(Cache c){
      RedBlackBST<Integer,Cache> caches = Cache.caches;
      if (this.historicoCaches.contains(c.getId())){
        System.out.println("Cache já existente");
      }else if (caches.contains(c.getId())){
        historicoCaches.put(c.getId(),c);
      }
  }

  public void removeFromHistoricoCaches(Cache c){
    if (this.historicoCaches.contains(c.getId())){
      this.historicoCaches.delete(c.getId());
      return;
    }
    System.out.println("removeFromHistoricoCaches() - Cache não existente.");
  }

  public Cache findCacheFromHistorico(Cache c) {
    if (this.historicoCaches.contains(c.getId())) {
      return this.historicoCaches.get(c.getId());
    }
    System.out.println("findCacheFromHistorico() - Cache não encontrada.");
  return null;
  }

  @Override
  public String toString() {
    return "Item{" +
            "id=" + id +
            '}';
  }
}