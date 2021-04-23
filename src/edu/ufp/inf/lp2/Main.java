package edu.ufp.inf.lp2;

public class Main {

    public static void main(String[] args) {
        Utilizador u1 = new Utilizador(UserType.BASIC,38237);
        Localizacao l1= new Localizacao(1,45.765,-38.222,"Montanha");
        Cache c1= new Cache(1,CacheType.BASIC,CacheDifficulty.HARD,l1);
        Cache.caches.put(c1.getId(),c1);
        u1.addHiddenCache(c1);
        c1.delete();
        u1.listHiddenCaches();

        u1.addVisitedCache(c1);
        u1.listVisitedCaches();


    }
}
