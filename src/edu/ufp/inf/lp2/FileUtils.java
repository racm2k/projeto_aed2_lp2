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
    public static ST<Integer, Utilizador> deleted_utilizadores;

    private ST<Integer, TravelBug> travelBugs;
    public static ST<Integer, TravelBug> deleted_travelBugs;

    private RedBlackBST<Integer, Cache> caches;
    public static RedBlackBST<Integer, Cache> deleted_caches;

    private HashMap<Integer, Localizacao> localizacoes;
    public static HashMap<Integer, Localizacao> deleted_localizacoes;

    private RedBlackBST<Integer, Log> logs;
    public static RedBlackBST<Integer, Log> deleted_logs;

    private ST<Integer, Item> items;
    public static ST<Integer, Item> deleted_items;


    public FileUtils() {
        utilizadores = new ST<>();
        travelBugs = new ST<>();
        caches = new RedBlackBST<>();
        localizacoes = new HashMap<>();
        logs = new RedBlackBST<>();
        items = new ST<>();

        deleted_utilizadores = new ST<>();
        deleted_travelBugs = new ST<>();
        deleted_caches = new RedBlackBST<>();
        deleted_localizacoes = new HashMap<>();
        deleted_logs = new RedBlackBST<>();
        deleted_items = new ST<>();
    }

    /************************  USERS *************************/

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
            if (myfile.createNewFile()) {
                System.out.println("File created: " + myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : utilizadores.keys()) {
                    myWriter.write(utilizadores.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            } else if (myfile.exists()) {
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : utilizadores.keys()) {
                    myWriter2.append(utilizadores.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e) {
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }

    public void deleteUser(Utilizador u) {
        if (utilizadores.contains(u.getId())) {
            for (Integer key : travelBugs.keys()) {
                if (u.getId().equals(travelBugs.get(key).getDono().getId())) {
                    System.out.println("Deleting travel bug of user");
                    deleted_travelBugs.put(travelBugs.get(key).getId(), travelBugs.get(key));
                    travelBugs.remove(travelBugs.get(key).getId());
                }
            }

            for (Integer lkey : logs.keys()) {
                Log lg = logs.get(lkey);
                if (u.getId().equals(lg.getUser().getId())) {
                    deleted_logs.put(lg.getUser().getId(), lg);
                    logs.delete(lg.getUser().getId());
                }
            }

            deleted_utilizadores.put(u.getId(), u);
            utilizadores.remove(u.getId());
        }
    }

    public void listDeletedUsers() {
        for (Integer key : deleted_utilizadores.keys()) {
            System.out.println(deleted_utilizadores.get(key).toString());
        }
    }

    /************************  CACHES *************************/

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
                if (!caches.contains(c.getId()) && localizacoes.containsKey(l.getId())) {
                    caches.put(c.getId(), c);
                }
            }
        }
    }

    public void saveCaches(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()) {
                System.out.println("File created: " + myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : caches.keys()) {
                    myWriter.write(caches.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            } else if (myfile.exists()) {
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : caches.keys()) {
                    myWriter2.append(caches.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e) {
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }

    public void deleteCache(Cache c) {
        if (caches.contains(c.getId())) {
            for (Integer key : items.keys()) {
                if (c == items.get(key).findCacheFromHistorico(c)) {
                    items.get(key).removeFromHistoricoCaches(c);
                }
            }

            for (Integer key : travelBugs.keys()) {
                if (travelBugs.get(key).getBugCache() == c) {
                    travelBugs.get(key).setBugCache(null);
                }
            }

            for (Integer key : c.getItems().keys()) {
//                deleted_items.put(c.getItems().get(key).getId(), c.getItems().get(key));
                c.getItems().delete(key);
            }
            for (Integer key : c.getLogs().keys()) {
                deleted_logs.put(c.getLogs().get(key).getUser().getId(), c.getLogs().get(key));
                c.getLogs().delete(key);
            }

            deleted_caches.put(c.getId(), c);
            caches.delete(c.getId());
        }
    }

    public void listDeletedCaches() {
        for (Integer key : deleted_caches.keys()) {
            System.out.println(deleted_caches.get(key).toString());
        }
    }

    /************************  LOGS *************************/

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
                Date sDate = new Date(tokens[1]);
                Utilizador utilizador = utilizadores.get(Integer.parseInt(tokens[3]));
                Log lg = new Log(Integer.parseInt(tokens[0]),sDate, tokens[2], utilizador);
                if (!logs.contains(lg.getId())) {
                    logs.put(lg.getId(), lg);
                }
            }
        }
    }

    public void saveLogs(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()) {
                System.out.println("File created: " + myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : logs.keys()) {
                    myWriter.write(logs.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            } else if (myfile.exists()) {
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : logs.keys()) {
                    myWriter2.append(logs.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e) {
            System.out.println("An error ocurred");
            e.printStackTrace();
        }

    }

    public void deleteLog(Log log) {
        if (logs.contains(log.getUser().getId())) {
            for (Integer ckey : caches.keys()) {
                if (caches.get(ckey).getLogs().contains(log.getId())) {
                    caches.get(ckey).getLogs().delete(log.getId());
                }
            }

            deleted_logs.put(log.getId(), log);
            logs.delete(log.getId());
        }
    }

    public void listDeletedLogs() {
        for (Integer key : deleted_logs.keys()) {
            System.out.println(deleted_logs.get(key).toString());
        }
    }

    /************************  ITEMS *************************/

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
                if (!items.contains(i.getId())) {
                    items.put(i.getId(), i);
                }
            }
        }
    }

    public void saveItems(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()) {
                System.out.println("File created: " + myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : items.keys()) {
                    myWriter.write(items.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            } else if (myfile.exists()) {
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : items.keys()) {
                    myWriter2.append(items.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e) {
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }

    public void deleteItem(Item i) {
        if (items.contains(i.getId())) {
            for (Integer key : caches.keys()) {
                for (Integer ikey : caches.get(key).getItems().keys()) {
                    if (caches.get(key).getItems().get(ikey).getId().equals(i.getId())) {
                        caches.get(key).getItems().delete(i.getId());
                    }
                }
            }
            deleted_items.put(i.getId(), i);
            items.delete(i.getId());
        }
    }

    public void listDeletedItems() {
        for (Integer key : deleted_items.keys()) {
            System.out.println(deleted_items.get(key).toString());
        }
    }

    /************************  LOCATIONS *************************/

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
                if (!localizacoes.containsKey(loc.getId())) {
                    localizacoes.put(loc.getId(), loc);
                }
            }
        }
    }

    public void saveLocals(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()) {
                System.out.println("File created: " + myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                Set<Integer> locations = localizacoes.keySet();
                for (Integer key : locations) {
                    myWriter.write(localizacoes.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            } else if (myfile.exists()) {
                FileWriter myWriter2 = new FileWriter(myfile);
                Set<Integer> locations = localizacoes.keySet();
                for (Integer key : locations) {
                    myWriter2.append(localizacoes.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e) {
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }

    public void deleteLocal(Localizacao loc) {
        if (localizacoes.containsKey(loc.getId())) {
            for (Integer ckey : caches.keys()) {
                if (caches.get(ckey).getLocal_cache() == loc) {
                    caches.get(ckey).setLocal_cache(null);
                }
            }

            deleted_localizacoes.put(loc.getId(), loc);
            localizacoes.remove(loc.getId());
        }
    }

    public void listDeletedLocals() {
        for (Integer key : deleted_localizacoes.keySet()) {
            System.out.println(deleted_localizacoes.get(key).toString());
        }
    }

    /************************  TRAVEL BUGS *************************/

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
                Cache c = caches.get(Integer.parseInt(tokens[2]));
                Utilizador ut = utilizadores.get(Integer.parseInt(tokens[3]));
                TravelBug tb = new TravelBug(Integer.parseInt(tokens[0]), tokens[1], c, ut);
                if (!travelBugs.contains(tb.getId()) && caches.contains(c.getId()) && utilizadores.contains(ut.getId())) {
                    travelBugs.put(tb.getId(), tb);
                }
            }
        }
    }

    public void saveTravelBugs(String path) {
        try {
            File myfile = new File(path);
            if (myfile.createNewFile()) {
                System.out.println("File created: " + myfile.getName());
                FileWriter myWriter = new FileWriter(myfile);
                for (Integer key : travelBugs.keys()) {
                    myWriter.write(travelBugs.get(key).toString());
                }
                myWriter.close();
                System.out.println("Successfully writen!");
            } else if (myfile.exists()) {
                FileWriter myWriter2 = new FileWriter(myfile);
                for (Integer key : travelBugs.keys()) {
                    myWriter2.append(travelBugs.get(key).toString());
                }
                myWriter2.close();
                System.out.println("Successfully writen!");

            }
        } catch (IOException e) {
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }

    public void deleteTravelBug(TravelBug tb) {
        if (travelBugs.contains(tb.getId())) {
            for (Integer key : utilizadores.keys()) {
                for (Integer tkey : utilizadores.get(key).getTravelBugs().keys()
                ) {
                    utilizadores.get(key).getTravelBugs().remove(utilizadores.get(key).getTravelBugs().get(tkey).getId());
                }
            }

            deleted_travelBugs.put(tb.getId(), tb);
            travelBugs.delete(tb.getId());
        }
    }

    public void listDeletedTravelBugs() {
        for (Integer key : deleted_travelBugs.keys()) {
            System.out.println(deleted_travelBugs.get(key).toString());
        }
    }

    /******************************************************************************************************/

    public void list_users_visited_given_cache(Cache c) {
        for (Integer key : utilizadores.keys()) {
            if (utilizadores.get(key).getVisitedCaches().get(c.getId()) != null)
                System.out.println(utilizadores.get(key));
        }
    }

    public void list_premiumCaches_atleast_1Item() {
        for (Integer key : caches.keys()) {
            if (caches.get(key).getTipo().equals("PREMIUM") && caches.get(key).getItems().size() != 0) {
                System.out.println(caches.get(key));
            }
        }
    }

    public void list_top5_users(Date begin, Date end) {
        RedBlackBST<Integer, Utilizador> aux = new RedBlackBST<>();
        int i = 5;
        while (i > 0) {
            for (Integer key : utilizadores.keys()) {
                Integer count = 0;
                RedBlackBST<Integer, Cache> vCaches = utilizadores.get(key).getVisitedCaches();
                for (Integer ckey : vCaches.keys()) {
                    RedBlackBST<Integer, Log> cLogs = vCaches.get(ckey).getLogs();
                    for (Integer lkey : cLogs.keys()) {
                        if (cLogs.get(lkey).getData().isAfter(begin) && cLogs.get(lkey).getData().isBefore(end) && cLogs.get(lkey).getUser() == utilizadores.get(key)) {
                            count++;
                        }
                    }
                }
                aux.put(count, utilizadores.get(key));
                i--;
            }
        }
        System.out.println("TOP5 USERS:");
        for (Integer key : aux.keys()) {
            System.out.println(key + " : " + aux.get(key).getNome());
        }

    }

    public void listMost_traveled_Bugs() {
        RedBlackBST<Integer, TravelBug> tbs = new RedBlackBST<>();
        for (Integer key : travelBugs.keys()) {
            tbs.put(travelBugs.get(key).getHistoricoCaches().size(), travelBugs.get(key));
        }

        for (Integer key : tbs.keys()) {
            System.out.println(key + " : " + tbs.get(key).getDescricao());
        }
    }

}
