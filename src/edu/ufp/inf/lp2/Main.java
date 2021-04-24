package edu.ufp.inf.lp2;

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
        Localizacao l1= fu.getLocal(1025);
        System.out.println("////////////////////////////////////////////");
        u1.addTravelBug(fu.getTravelBug(4));
        u1.listTravelBugs();

        fu.deleteLocal(l1);
        fu.deleteUser(u1);

        fu.listDeletedUsers();
        fu.listDeletedTravelBugs();
        fu.listDeletedLocals();

        fu.saveLocals("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locations_output.txt");
        fu.saveUsers("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users_output.txt");
        fu.saveCaches("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches_output.txt");
        fu.saveItems("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items_output.txt");
        fu.saveLogs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\logs_output.txt");
        fu.saveTravelBugs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\travelBugs_output.txt");

    }


}
