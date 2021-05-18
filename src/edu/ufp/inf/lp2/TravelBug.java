package edu.ufp.inf.lp2;

public class TravelBug extends Item {
  private Cache cache_inicial;
  private Cache cache_destino;
  private Utilizador dono;


  public TravelBug(Integer id, Cache cache_inicial,Cache cache_destino, Utilizador dono) {
    super(id);
    this.cache_inicial = cache_inicial;
    this.cache_destino = cache_destino;
    this.dono = dono;
  }

  public Cache getCache_inicial() {
    return cache_inicial;
  }

  public void setCache_inicial(Cache cache_inicial) {
    this.cache_inicial = cache_inicial;
  }

  public Cache getCache_destino() {
    return cache_destino;
  }

  public void setCache_destino(Cache cache_destino) {
    this.cache_destino = cache_destino;
  }

  public Utilizador getDono() {
    return dono;
  }

  public void setDono(Utilizador dono) {
    this.dono = dono;
  }


  @Override
  public String toString() {
    return "TravelBug{\n    id: '"+this.getId()+"',\n    descrição: '"+this.getDescricao()+"',\n    cache_inicial='" + cache_inicial + "',\n    cache_destino='" + cache_destino + "',\n    dono= '" + dono.getNome() +"'\n}\n";
  }
}