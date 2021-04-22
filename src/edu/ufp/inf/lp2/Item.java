package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;


public class Item {


  private Integer id;

  private ST<Integer,Cache> historicoCaches;

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
      if (this.historicoCaches.contains(c.getId())){
        System.out.println("Cache já existente");
        return;
      }
      historicoCaches.put(c.getId(),c);


  }

  public void removeFromHistoricoCaches(Cache c){
    if (this.historicoCaches.contains(c.getId())){
      this.historicoCaches.remove(c.getId());
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