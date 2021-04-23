package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.RedBlackBST;

public class TravelBug extends Item {

  private Localizacao local_bug;
  private Utilizador dono;

  public static RedBlackBST<Integer,TravelBug> travelBugs = new RedBlackBST<>();
  public static RedBlackBST<Integer,TravelBug> deleted_travelBugs = new RedBlackBST<>();

  public TravelBug(Integer id, Localizacao local_bug, Utilizador dono) {
    super(id);
    this.local_bug = local_bug;
    this.dono = dono;
  }

  public Localizacao getLocal_bug() {
    return local_bug;
  }

  public void setLocal_bug(Localizacao local_bug) {
    this.local_bug = local_bug;
  }

  public Utilizador getDono() {
    return dono;
  }

  public void setDono(Utilizador dono) {
    this.dono = dono;
  }

  public void delete(){
    if (travelBugs.contains(this.getId())){
      deleted_travelBugs.put(this.getId(),this);
      travelBugs.delete(this.getId());

    }
  }

  @Override
  public String toString() {
    return "TravelBug{" +
            "local_bug=" + local_bug +
            ", dono=" + dono +
            '}';
  }
}