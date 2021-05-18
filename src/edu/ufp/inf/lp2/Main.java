package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.*;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileUtils fu = new FileUtils();
        fu.showUsers("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users",false);
//        fu.showUsers("/home/rmachado/Documents/uni/lp2/projeto/data/users",true);

        fu.showLocals("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locations",false);
//        fu.showLocals("/home/rmachado/Documents/uni/lp2/projeto/data/locations",true);

        fu.showCaches("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches",false);
//        fu.showCaches("/home/rmachado/Documents/uni/lp2/projeto/data/caches",true);

        fu.showLogs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\logs",false);
//        fu.showLogs("/home/rmachado/Documents/uni/lp2/projeto/data/logs",true);

        fu.showItems("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items",false);
//        fu.showItems("/home/rmachado/Documents/uni/lp2/projeto/data/items",true);

        fu.showTravelBugs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\travelBugs",false);
//        fu.showTravelBugs("/home/rmachado/Documents/uni/lp2/projeto/data/travelBugs",true);

//        for (Integer key: fu.getUtilizadores().keys()) {
//            for (Integer ckey: fu.getCaches().keys()
//                 ) {
//                fu.getUtilizadores().get(key).addHiddenCache(fu.getCaches().get(ckey));
//            }
//        }
//
//        Utilizador u1 = fu.getUser(1);
//        Utilizador u2 = fu.getUser(2);
//        Utilizador u3 = fu.getUser(3);
//        Utilizador u4 = fu.getUser(4);
//        Utilizador u5 = fu.getUser(5);
//        Utilizador u6 = fu.getUser(6);
//
//
//        Cache c1 = fu.getCache(1);
//        Cache c2 = fu.getCache(2);
//        Cache c3 = fu.getCache(3);
//        Cache c4 = fu.getCache(4);
//        Cache c5 = fu.getCache(5);
//        Cache c6 = fu.getCache(6);
//        Cache c7 = fu.getCache(7);
//        Cache c8 = fu.getCache(8);
//        Cache c9 = fu.getCache(9);
//        Cache c10 = fu.getCache(10);
//        Cache c11 = fu.getCache(11);
//        Cache c12 = fu.getCache(12);
//        Cache c13 = fu.getCache(13);
//        Cache c14 = fu.getCache(14);
//        Cache c15 = fu.getCache(15);
//        Cache c16 = fu.getCache(16);
//        Cache c17 = fu.getCache(17);
//        Cache c18 = fu.getCache(18);
//        Item i1= fu.getItem(1);
//        Item i2 = fu.getItem(2);
//        Item i3 = fu.getItem(3);
//        Item i4 = fu.getItem(4);
//        Item i5 = fu.getItem(5);
//        Item i6 = fu.getItem(6);
//        Item i7 = fu.getItem(7);
//        Item i8 = fu.getItem(8);
//        Item i9 = fu.getItem(9);
//        Item i10 = fu.getItem(10);
//        Item i11 = fu.getItem(11);
//        Item i12 = fu.getItem(12);
//        Item i13 = fu.getItem(13);
//        Item i14 = fu.getItem(14);
//        Item i15 = fu.getItem(15);
//        Item i16 = fu.getItem(16);
//        TravelBug tb1= fu.getTravelBug(1);
//        TravelBug tb2= fu.getTravelBug(2);
//        TravelBug tb3= fu.getTravelBug(3);
//
//        u1.addVisitedCache(c1);
//        u1.addVisitedCache(c2);
//        u1.addVisitedCache(c6);
//        u1.addVisitedCache(c8);
//        u1.addVisitedCache(c13);
//        u1.addVisitedCache(c16);
//        u1.addVisitedCache(c17);
//
//        u2.addVisitedCache(c18);
//        u2.addVisitedCache(c13);
//        u2.addVisitedCache(c8);
//
//        u3.addVisitedCache(c12);
//        u3.addVisitedCache(c11);
//        u3.addVisitedCache(c10);
//        u3.addVisitedCache(c8);
//        u3.addVisitedCache(c9);
//        u3.addVisitedCache(c5);
//        u3.addVisitedCache(c6);
//        u3.addVisitedCache(c4);
//        u3.addVisitedCache(c3);
//        u3.addVisitedCache(c2);
//        u3.addVisitedCache(c1);
//        u3.addVisitedCache(c7);
//        u3.addVisitedCache(c15);
//        u3.addVisitedCache(c17);
//        u3.addVisitedCache(c18);
//        u3.addVisitedCache(c13);
//
//        u4.addVisitedCache(c14);
//        u4.addVisitedCache(c15);
//        u4.addVisitedCache(c18);
//        u4.addVisitedCache(c17);
//        u4.addVisitedCache(c13);
//
//        u5.addVisitedCache(c3);
//        u5.addVisitedCache(c8);
//        u5.addVisitedCache(c9);
//        u5.addVisitedCache(c10);
//        u5.addVisitedCache(c16);
//        u5.addVisitedCache(c11);
//        u5.addVisitedCache(c12);
//
//        u6.addVisitedCache(c5);
//        u6.addVisitedCache(c6);
//        u6.addVisitedCache(c7);
//        u6.addVisitedCache(c3);
//        u6.addVisitedCache(c2);
//        u6.addVisitedCache(c1);
//        u6.addVisitedCache(c8);
//        u6.addVisitedCache(c13);
//
//        c1.addItem(i1);
//        c1.addItem(i2);
//        c1.addItem(i3);
//        c2.addItem(i4);
//        c2.addItem(i5);
//        c2.addItem(i6);
//        c3.addItem(i7);
//        c3.addItem(i8);
//        c3.addItem(i9);
//        c4.addItem(i10);
//        c7.addItem(i11);
//        c8.addItem(i1);
//        c8.addItem(i12);
//        c10.addItem(i13);
//        c10.addItem(i14);
//        c11.addItem(i15);
//        c12.addItem(i16);
//        c15.addItem(i11);
//
////        c2.addItem(tb2);
////        c1.addItem(tb1);
////        c3.addItem(tb3);
//
//
//        System.out.println("\n////////////////////////////////////////////\n");
//
//
//
//
//        fu.showCaches(null,false);
//        fu.showItems(null,false);
//        fu.showUsers(null,false);
//
//        u1.listVisitedCaches(false,"norte");
//        u2.listVisitedCaches(false,"norte");
//        u3.listVisitedCaches(false,"norte");
//        u4.listVisitedCaches(false,"norte");
//        u5.listVisitedCaches(false,"norte");
//        u6.listVisitedCaches(false,"norte");
//
//        u1.listHiddenCaches(false,"norte");
//        u2.listHiddenCaches(false,"norte");
//        u3.listHiddenCaches(false,"norte");
//        u4.listHiddenCaches(false,"norte");
//        u5.listHiddenCaches(false,"norte");
//        u6.listHiddenCaches(false,"norte");
//
//        fu.list_users_visited_given_cache(c6);
//
//        fu.list_premiumCaches_atleast_1Item();
//



        SymbolDigraphAED2 sg = new SymbolDigraphAED2("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\ligacoes.txt",",",fu);

        EdgeWeightedDigraphAED2 graph = sg.digraph();
        System.out.println(graph);


        fu.shortest_path(1,14,graph);





//        fu.list_top5_users();

        fu.saveLocals("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locations_output.txt");
//        fu.saveLocals("/home/rmachado/Documents/uni/lp2/projeto/data/locations_output.txt");

        fu.saveUsers("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users_output.txt");
//        fu.saveUsers("/home/rmachado/Documents/uni/lp2/projeto/data/users_output.txt");

        fu.saveCaches("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches_output.txt");
//        fu.saveCaches("/home/rmachado/Documents/uni/lp2/projeto/data/caches_output.txt");

        fu.saveItems("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items_output.txt");
//        fu.saveItems("/home/rmachado/Documents/uni/lp2/projeto/data/items_output.txt");

        fu.saveLogs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\logs_output.txt");
//        fu.saveLogs("/home/rmachado/Documents/uni/lp2/projeto/data/logs_output.txt");

        fu.saveTravelBugs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\travelBugs_output.txt");
//        fu.saveTravelBugs("/home/rmachado/Documents/uni/lp2/projeto/data/travelBugs_output.txt");

    }


}
