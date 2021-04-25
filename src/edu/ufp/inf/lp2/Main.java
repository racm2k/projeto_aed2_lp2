package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.Date;

import java.io.FileNotFoundException;



public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileUtils fu = new FileUtils();
        fu.showUsers("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users",false);
        fu.showLocals("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locations",false);
        fu.showCaches("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches",false);
        fu.showLogs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\logs",false);
        fu.showItems("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items",false);
        fu.showTravelBugs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\travelBugs",false);


        Utilizador u1 = fu.getUser(38237);
        Utilizador u2 = fu.getUser(32742);
        Utilizador u3 = fu.getUser(33234);
        Log l1 = fu.getLog(38237);
        Log l2 = fu.getLog(32742);
        Log l3 = fu.getLog(33234);
        Log l4 = fu.getLog(16425);
        Log l5 = fu.getLog(25674);
        Log l6 = fu.getLog(30060);
        Cache c1 = fu.getCache(25);
        Cache c2 = fu.getCache(5);
        Cache c3 = fu.getCache(20);
        Cache c4 = fu.getCache(10);
        Cache c5 = fu.getCache(50);
        Cache c6 = fu.getCache(80);
        Item i1= fu.getItem(2);
        Item i2 = fu.getItem(4);
        TravelBug tb1= fu.getTravelBug(4);
        TravelBug tb2= fu.getTravelBug(15);
        TravelBug tb3= fu.getTravelBug(34);
        TravelBug tb4= fu.getTravelBug(10);
        TravelBug tb5= fu.getTravelBug(7);
        System.out.println("////////////////////////////////////////////");
//        u1.addTravelBug(fu.getTravelBug(4));
//        u1.listTravelBugs();
//        i1.addHistoricoCaches(c1);
//        fu.deleteUser(u1);
//        fu.deleteCache(c1);

//        System.out.println(fu.getTravelBug(4));
//        c1.addItem(i1);
//        c1.addItem(i2);
//        c2.addItem(i1);
//        c3.addItem(i1);
//
//        c1.addLog(l1);
//        c1.addLog(l2);
//        c2.addLog(l1);
//        c2.addLog(l2);
//        c3.addLog(l1);
//        c4.addLog(l1);
//        c1.addLog(l3);
//        c5.addLog(l1);

        tb1.addHistoricoCaches(c1);
        tb1.addHistoricoCaches(c2);
        tb1.addHistoricoCaches(c3);
        tb1.addHistoricoCaches(c4);
        tb1.addHistoricoCaches(c5);
        tb1.addHistoricoCaches(c6);

        tb2.addHistoricoCaches(c1);
        tb2.addHistoricoCaches(c3);
        tb2.addHistoricoCaches(c5);

        tb3.addHistoricoCaches(c2);
        tb3.addHistoricoCaches(c4);
        tb3.addHistoricoCaches(c6);

        tb4.addHistoricoCaches(c5);

        tb5.addHistoricoCaches(c6);
        tb5.addHistoricoCaches(c1);


//        u1.addVisitedCache(c1);
//        u1.addVisitedCache(c2);
//        u1.addVisitedCache(c3);
//        u1.addVisitedCache(c4);
//        u1.addVisitedCache(c5);
//        u2.addVisitedCache(c1);
//        u2.addVisitedCache(c2);
//        u3.addVisitedCache(c1);


//        u1.addHiddenCache(c5);
//        u1.addHiddenCache(c6);

//        u1.listVisitedCaches(false,"Vk");
//        u1.listHiddenCaches(true,"GC");
//        fu.list_users_visited_given_cache(c1);
//        fu.list_premiumCaches_atleast_1Item();
//        Date begin= new Date(1,1,1900);
//        Date end= new Date(1,1,2005);
//        Date end= new Date(1,1,1999);
//        fu.list_top5_users(begin,end);
        fu.listMost_traveled_Bugs();

//        fu.listDeletedUsers();
//        fu.listDeletedTravelBugs();

        fu.saveLocals("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locations_output.txt");
        fu.saveUsers("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users_output.txt");
        fu.saveCaches("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches_output.txt");
        fu.saveItems("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items_output.txt");
        fu.saveLogs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\logs_output.txt");
        fu.saveTravelBugs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\travelBugs_output.txt");

    }


}
