package edu.ufp.inf.lp2;

public class TravelBug extends Item {

  private Localizacao local_bug;

  private Utilizador dono;

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

  @Override
  public String toString() {
    return "TravelBug{" +
            "local_bug=" + local_bug +
            ", dono=" + dono +
            '}';
  }
}