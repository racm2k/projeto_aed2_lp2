package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class FileUtils {


    private ST<Integer, Utilizador> utilizadores;
    public static ST<Integer,Utilizador> deleted_utilizadores = new ST<>();

    private ST<Integer, TravelBug> travelBugs;
    public static ST<Integer,TravelBug> deleted_travelBugs = new ST<>();

    private RedBlackBST<Integer, Cache> caches;
    public static RedBlackBST<Integer, Cache> deleted_caches = new RedBlackBST<>();

    private HashMap<Integer, Localizacao> localizacoes;
    public static HashMap<Integer,Localizacao> deleted_localizacoes = new HashMap<>();

    private RedBlackBST<Integer, Log> logs;
    public static RedBlackBST<Integer,Log> deleted_logs= new RedBlackBST<>();

    private ST<Integer, Item> items;
    public static ST<Integer,Item> deleted_items = new ST<>();


    public FileUtils() {
        utilizadores = new ST<>();
        travelBugs = new ST<>();
        caches = new RedBlackBST<>();
        localizacoes = new HashMap<>();
        logs = new RedBlackBST<>();
        items = new ST<>();

        deleted_utilizadores= new ST<>();
        deleted_travelBugs = new ST<>();
        deleted_caches= new RedBlackBST<>();
        deleted_localizacoes = new HashMap<>();
        deleted_logs= new RedBlackBST<>();
        deleted_items= new ST<>();
    }


    public void showUsers(String path, boolean forceRead) throws FileNotFoundException {
        if (utilizadores.size() == 0 || forceRead) {
            readUsers(path);
        }
        for (Integer key : utilizadores.keys()) {
            System.out.println(utilizadores.get(key).toString());
        }
    }

    public Utilizador getUser(Integer id) {
        return utilizadores.get(id);
    }

    private void readUsers(String path) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new java.io.File(path))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(";");
                Utilizador u = new Utilizador(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                if (!utilizadores.contains(u.getId())) {
                    utilizadores.put(u.getId(), u);
                }
            }
        }
    }

    public void saveUsers(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()){
                System.out.println("File created: "+myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : utilizadores.keys()) {
                    myWriter.write(utilizadores.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            }else if (myfile.exists()){
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : utilizadores.keys()) {
                    myWriter2.append(utilizadores.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }


    public void showCaches(String path, boolean forceRead) throws FileNotFoundException {
        if (caches.size() == 0 || forceRead) {
            readCaches(path);
        }
        for (Integer key : caches.keys()) {
            System.out.println(caches.get(key).toString());
        }
    }

    public Cache getCache(Integer id) {
        return caches.get(id);
    }

    private void readCaches(String path) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new java.io.File(path))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(";");
                Localizacao l = getLocal(Integer.parseInt(tokens[3]));
                Cache c = new Cache(Integer.parseInt(tokens[0]), tokens[1], tokens[2], l);
                if (!caches.contains(c.getId()) && localizacoes.containsKey(l.getId())){
                    caches.put(c.getId(), c);
                }
            }
        }
    }

    public void saveCaches(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()){
                System.out.println("File created: "+myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : caches.keys()) {
                    myWriter.write(caches.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            }else if (myfile.exists()){
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : caches.keys()) {
                    myWriter2.append(caches.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }


    public void showLogs(String path, boolean forceRead) throws FileNotFoundException {
        if (logs.size() == 0 || forceRead) {
            readLogs(path);
        }
        for (Integer key : logs.keys()) {
            System.out.println(logs.get(key).toString());
        }
    }

    public Log getLog(Integer id) {
        return logs.get(id);
    }

    private void readLogs(String path) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new java.io.File(path))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(";");
                Date sDate = new Date(tokens[0]);
                Utilizador utilizador= utilizadores.get(Integer.parseInt(tokens[2]));
                Log lg = new Log(sDate, tokens[1],utilizador );
                if (!logs.contains(lg.getUser().getId())){
                    logs.put(lg.getUser().getId(), lg);
                }
            }
        }
    }

    public void saveLogs(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()){
                System.out.println("File created: "+myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : logs.keys()) {
                    myWriter.write(logs.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            }else if (myfile.exists()){
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : logs.keys()) {
                    myWriter2.append(logs.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }

    }


    public void showItems(String path, boolean forceRead) throws FileNotFoundException {
        if (items.size() == 0 || forceRead) {
            readItems(path);
        }
        for (Integer key : items.keys()) {
            System.out.println(items.get(key).toString());
        }
    }

    public Item getItem(Integer id) {
        return items.get(id);
    }

    private void readItems(String path) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new java.io.File(path))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(";");
                Item i = new Item(Integer.parseInt(tokens[0]), tokens[1]);
                if (!items.contains(i.getId())){
                    items.put(i.getId(), i);
                }
            }
        }
    }

    public void saveItems(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()){
                System.out.println("File created: "+myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : items.keys()) {
                    myWriter.write(items.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            }else if (myfile.exists()){
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : items.keys()) {
                    myWriter2.append(items.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }


    public void showLocals(String path, boolean forceRead) throws FileNotFoundException {
        if (localizacoes.size() == 0 || forceRead) {
            readLocals(path);
        }
        Set<Integer> setOfLocalizations = localizacoes.keySet();
        for (Integer key : setOfLocalizations) {
            System.out.println(localizacoes.get(key));
        }
    }

    public Localizacao getLocal(Integer id) {
        return localizacoes.get(id);
    }

    private void readLocals(String path) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new java.io.File(path))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(";");
                Localizacao loc = new Localizacao(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), tokens[3]);
                if (!localizacoes.containsKey(loc.getId())){
                    localizacoes.put(loc.getId(), loc);
                }
            }
        }
    }

    public void saveLocals(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()){
                System.out.println("File created: "+myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                Set<Integer> locations = localizacoes.keySet();
                for (Integer key : locations) {
                    myWriter.write(localizacoes.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            }else if (myfile.exists()){
                FileWriter myWriter2 = new FileWriter(myfile);
                Set<Integer> locations = localizacoes.keySet();
                for (Integer key : locations) {
                    myWriter2.append(localizacoes.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }

    public void showTravelBugs(String path, boolean forceRead) throws FileNotFoundException {
        if (travelBugs.size() == 0 || forceRead) {
            readTravelBugs(path);
        }
        for (Integer key : travelBugs.keys()) {
            System.out.println(travelBugs.get(key).toString());
        }
    }

    public TravelBug getTravelBug(Integer id) {
        return travelBugs.get(id);
    }

    private void readTravelBugs(String path) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new java.io.File(path))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(";");
                Localizacao l = localizacoes.get(Integer.parseInt(tokens[2]));
                Utilizador ut = utilizadores.get(Integer.parseInt(tokens[3]));
                TravelBug tb = new TravelBug(Integer.parseInt(tokens[0]), tokens[1], l, ut);
                if (!travelBugs.contains(tb.getId()) && localizacoes.containsKey(l.getId()) && utilizadores.contains(ut.getId())){
                    travelBugs.put(tb.getId(), tb);
                }
            }
        }
    }

    public void saveTravelBugs(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()){
                System.out.println("File created: "+myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : travelBugs.keys()) {
                    myWriter.write(travelBugs.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            }else if (myfile.exists()){
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : travelBugs.keys()) {
                    myWriter2.append(travelBugs.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }


}
