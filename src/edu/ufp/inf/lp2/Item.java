package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;



public class Item {

  private Integer id;
  private String descricao;

  private RedBlackBST<Integer,Cache> historicoCaches = new RedBlackBST<>();


  public Item(Integer id, String descricao) {
    this.id = id;
    this.descricao = descricao;
  }

  public Item(Integer id) {
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
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
      }else
        historicoCaches.put(c.getId(),c);
  }

  public void removeFromHistoricoCaches(Cache c){
    if (this.historicoCaches.contains(c.getId())){
      this.historicoCaches.delete(c.getId());
      System.out.println("removeFromHistoricoCaches() - Cache encontrada e removida!");
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
    return "Item{\n    id: '" + id +
            "',\n    descricao: '" + descricao +
            "'\n}\n";
  }

}