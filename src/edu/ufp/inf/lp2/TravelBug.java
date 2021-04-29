package edu.ufp.inf.lp2;

public class TravelBug extends Item {
  private Cache cache;
  private Utilizador dono;


  public TravelBug(Integer id, String descricao, Cache cache, Utilizador dono) {
    super(id, descricao);
    this.cache = cache;
    this.dono = dono;
  }

  public Cache getBugCache() {
    return this.cache;
  }

  public void setBugCache(Cache cache) {
    this.cache = cache;
  }

  public Utilizador getDono() {
    return dono;
  }

  public void setDono(Utilizador dono) {
    this.dono = dono;
  }


  @Override
  public String toString() {
    return "TravelBug{\n    id: '"+this.getId()+"',\n    descrição: '"+this.getDescricao()+"',\n    cache='" + cache + "',\n    dono= '" + dono.getNome() +"'\n}\n";
  }
}