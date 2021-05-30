package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import edu.ufp.inf.lp2.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GcController implements Initializable {

    public TableView<Cache> cachesTable;
    public TableColumn<Cache, Integer> cacheidCol;
    public TableColumn<Cache, String> cacheTipoCol;
    public TableColumn<Cache, String> cacheDifCol;
    public TableColumn<Cache, Localizacao> cacheLocalCol;
    public TextField cacheIdField;
    public TextField cacheTipoField;
    public TextField cacheDifField;
    public TextField cacheLocField;

    public TableView<Utilizador> usersTable;
    public TableColumn<Utilizador, Integer> useridCol;
    public TableColumn<Utilizador, String> nomeCol;
    public TableColumn<Utilizador, String> usertypeCol;
    public TextField userTipoField;
    public TextField userIdField;
    public TextField userNameField;

    public TableView<TravelBug> bugsTable;
    public TableColumn<TravelBug, Integer> bugID;
    public TableColumn<TravelBug, Cache> bugStartCache;
    public TableColumn<TravelBug, Cache> bugEndCache;
    public TableColumn<TravelBug, Utilizador> bugOwner;
    public TextField tbIdField;
    public TextField tbCIField;
    public TextField tbCFField;
    public TextField tbDonoField;

    public TableView<Item> itemsTable;
    public TableColumn<Item, Integer> itemID;
    public TableColumn<Item, String> itemName;
    public TextField itemIdField;
    public TextField itemNomeField;

    public TableView<Localizacao> localsTable;
    public TableColumn<Localizacao, Integer> locID;
    public TableColumn<Localizacao, Double> locLat;
    public TableColumn<Localizacao, Double> locLong;
    public TableColumn<Localizacao, String> locZona;
    public TextField locIdField;
    public TextField locLatField;
    public TextField locLongField;
    public TextField locZonaField;

    public Button spButtonID;
    public TextField startCacheSPField;
    public TextField endCacheSPField;

    public Group graphGroup;
    private static final Integer radius = 15;
    private static final double R = 6371e3;

    FileUtils fileUtils = new FileUtils();

    ST<Cache, Integer> nodes = new ST<>();



    ObservableList<Cache> caches = FXCollections.observableArrayList();
    ObservableList<Utilizador> utilizadores = FXCollections.observableArrayList();
    ObservableList<TravelBug> travelBugs = FXCollections.observableArrayList();
    ObservableList<Item> items = FXCollections.observableArrayList();
    ObservableList<Localizacao> localizacoes = FXCollections.observableArrayList();

    ArrayList<Cache> readCaches = new ArrayList<>(caches);
    ArrayList<Utilizador> readUsers = new ArrayList<>(utilizadores);
    ArrayList<TravelBug> readBugs = new ArrayList<>(travelBugs);
    ArrayList<Item> readItems = new ArrayList<>(items);
    ArrayList<Localizacao> readLocals = new ArrayList<>(localizacoes);

    private static final String PATH_READ_LOC_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locations";
    private static final String PATH_READ_CACHE_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches";
    private static final String PATH_READ_USER_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users";
    private static final String PATH_READ_ITEMS_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items";
    private static final String PATH_READ_BUGS_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\travelBugs";

    private static final String PATH_SAVE_CACHE_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches_txt";
    private static final String PATH_SAVE_USER_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users_txt";
    private static final String PATH_SAVE_LOC_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locals_txt";
    private static final String PATH_SAVE_BUGS_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\bugs_txt";
    private static final String PATH_SAVE_ITEMS_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items_txt";

    private static final String PATH_SAVE_CACHE_BIN = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches_bin";
    private static final String PATH_SAVE_USER_BIN = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users_bin";
    private static final String PATH_SAVE_BUGS_BIN = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\bugs_bin";
    private static final String PATH_SAVE_LOC_BIN = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locals_bin";
    private static final String PATH_SAVE_ITEMS_BIN = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items_bin";


    private static final String PATH_LIG_TXT = "C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\ligacoes.txt";


    public void handleOpenOnAction(ActionEvent actionEvent) throws IOException {
        fileUtils.showUsers("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users", false);
//        fu.showUsers("/home/rmachado/Documents/uni/lp2/projeto/data/users",true);

        fileUtils.showLocals("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locations", false);
//        fu.showLocals("/home/rmachado/Documents/uni/lp2/projeto/data/locations",true);

        fileUtils.showCaches("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches", false);
//        fu.showCaches("/home/rmachado/Documents/uni/lp2/projeto/data/caches",true);

        fileUtils.showLogs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\logs", false);
//        fu.showLogs("/home/rmachado/Documents/uni/lp2/projeto/data/logs",true);

        fileUtils.showItems("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items", false);
//        fu.showItems("/home/rmachado/Documents/uni/lp2/projeto/data/items",true);

        fileUtils.showTravelBugs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\travelBugs", false);
//        fu.showTravelBugs("/home/rmachado/Documents/uni/lp2/projeto/data/travelBugs",true);
        usersTable.getItems().clear();
        utilizadores.clear();

        cachesTable.getItems().clear();
        caches.clear();

        bugsTable.getItems().clear();
        travelBugs.clear();

        itemsTable.getItems().clear();
        items.clear();

        localsTable.getItems().clear();
        localizacoes.clear();

        try {
            System.out.println("READING FROM TXT FILE....");
            utilizadores = readUsersFileTxt();
            caches = readCachesFileTxt();
            travelBugs = readBugsFileTxt();
            items = readItemsFileTxt();
            localizacoes = readLocalsFileTxt();

            cachesTable.getItems().addAll(caches);
            usersTable.getItems().addAll(utilizadores);
            bugsTable.getItems().addAll(travelBugs);
            itemsTable.getItems().addAll(items);
            localsTable.getItems().addAll(localizacoes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ObservableList<Localizacao> readLocalsFileTxt() throws IOException {
        try (Scanner scanner = new Scanner(new java.io.File(PATH_READ_LOC_TXT))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                Localizacao l = new Localizacao(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), tokens[3]);
                if (!localizacoes.contains(l)) {
                    localizacoes.add(l);
                }
            }
        }
        int size_locals = localizacoes.size();
        System.out.println("Read " + size_locals + " Locals;");
        return localizacoes;
    }

    private ObservableList<Item> readItemsFileTxt() throws IOException {
        try (Scanner scanner = new Scanner(new java.io.File(PATH_READ_ITEMS_TXT))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                Item i = new Item(Integer.parseInt(tokens[0]), tokens[1]);
                if (!items.contains(i)) {
                    items.add(i);
                }
            }
        }
        int size_items = items.size();
        System.out.println("Read " + size_items + " Items;");
        return items;
    }

    private ObservableList<TravelBug> readBugsFileTxt() throws IOException {
        try (Scanner scanner = new Scanner(new java.io.File(PATH_READ_BUGS_TXT))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                Cache ci = fileUtils.getCaches().get(Integer.parseInt(tokens[1]));
                Cache cd = fileUtils.getCaches().get(Integer.parseInt(tokens[2]));
                Utilizador u = fileUtils.getUtilizadores().get(Integer.parseInt(tokens[3]));
                TravelBug tb = new TravelBug(Integer.parseInt(tokens[0]), ci, cd, u);
                if (!travelBugs.contains(tb)) {
                    travelBugs.add(tb);
                }
            }
        }
        int size_bugs = travelBugs.size();
        System.out.println("Read " + size_bugs + " Bugs;");
        return travelBugs;
    }

    public void handleOpenBinOnAction(ActionEvent actionEvent) {
        cachesTable.getItems().clear();
        caches.clear();
        usersTable.getItems().clear();
        utilizadores.clear();
        bugsTable.getItems().clear();
        travelBugs.clear();
        itemsTable.getItems().clear();
        items.clear();
        localsTable.getItems().clear();
        localizacoes.clear();
        readFromBinFile();


    }

    public void handleSaveOnAction(ActionEvent actionEvent) {
        saveToTxtFile();
    }

    private void saveToTxtFile() {
        System.out.println("SAVING TO TXT FILES......");
        fileUtils.saveUsers(PATH_SAVE_USER_TXT);
        fileUtils.saveCaches(PATH_SAVE_CACHE_TXT);
        fileUtils.saveTravelBugs(PATH_SAVE_BUGS_TXT);
        fileUtils.saveItems(PATH_SAVE_ITEMS_TXT);
        fileUtils.saveLocals(PATH_SAVE_LOC_TXT);
    }

    public void handleSaveBinOnAction(ActionEvent actionEvent) {
        System.out.println("SAVING TO BIN FILES......");
        saveToBinFile();
    }

    public void handleExitOnAction(ActionEvent actionEvent) {
        System.out.println("EXITING.......");
        System.exit(0);
    }

    private ObservableList<Cache> readCachesFileTxt() throws IOException {

        try (Scanner scanner = new Scanner(new java.io.File(PATH_READ_CACHE_TXT))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                Localizacao l = fileUtils.getLocal(Integer.parseInt(tokens[3]));
                Cache c = new Cache(Integer.parseInt(tokens[0]), tokens[1], tokens[2], l);
                if (!caches.contains(c)) {
                    caches.add(c);
                }
            }
        }
        int size_caches = caches.size();
        System.out.println("Read " + size_caches + " Caches;");
        return caches;
    }

    private ObservableList<Utilizador> readUsersFileTxt() throws IOException {
        try (Scanner scanner = new Scanner(new java.io.File(PATH_READ_USER_TXT))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                Utilizador u = new Utilizador(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                if (!utilizadores.contains(u)) {
                    utilizadores.add(u);
                }
            }
        }
        int size_users = utilizadores.size();
        System.out.println("Read " + size_users + " Users;");
        return utilizadores;
    }

    private void saveToBinFile() {
        File cacheBinFile = new File(PATH_SAVE_CACHE_BIN);
        File usersBinFile = new File(PATH_SAVE_USER_BIN);
        File bugsBinFile = new File(PATH_SAVE_BUGS_BIN);
        File localsBinFile = new File(PATH_SAVE_LOC_BIN);
        File itemsBinFile = new File(PATH_SAVE_ITEMS_BIN);

        try {
            FileOutputStream fos_cache = new FileOutputStream(cacheBinFile);
            FileOutputStream fos_users = new FileOutputStream(usersBinFile);
            FileOutputStream fos_bugs = new FileOutputStream(bugsBinFile);
            FileOutputStream fos_locals = new FileOutputStream(localsBinFile);
            FileOutputStream fos_items = new FileOutputStream(itemsBinFile);

            ObjectOutputStream oos_users = new ObjectOutputStream(fos_users);
            ObjectOutputStream oos_cache = new ObjectOutputStream(fos_cache);
            ObjectOutputStream oos_bugs = new ObjectOutputStream(fos_bugs);
            ObjectOutputStream oos_locals = new ObjectOutputStream(fos_locals);
            ObjectOutputStream oos_items = new ObjectOutputStream(fos_items);
            oos_cache.writeObject(new ArrayList<Cache>(caches));
            System.out.println("Wrote " + caches.size() + " Caches;");
            oos_cache.close();
            oos_users.writeObject(new ArrayList<Utilizador>(utilizadores));
            System.out.println("Wrote " + utilizadores.size() + " Users;");
            oos_users.close();
            oos_bugs.writeObject(new ArrayList<TravelBug>(travelBugs));
            System.out.println("Wrote " + travelBugs.size() + " Bugs;");
            oos_bugs.close();
            oos_items.writeObject(new ArrayList<Item>(items));
            System.out.println("Wrote " + items.size() + " Items;");
            oos_items.close();
            oos_locals.writeObject(new ArrayList<Localizacao>(localizacoes));
            System.out.println("Wrote " + localizacoes.size() + " Locals;");
            oos_locals.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromBinFile() {
        File cacheBinFile = new File(PATH_SAVE_CACHE_BIN);
        File usersBinFile = new File(PATH_SAVE_USER_BIN);
        File bugsBinFile = new File(PATH_SAVE_BUGS_BIN);
        File itemsBinFile = new File(PATH_SAVE_ITEMS_BIN);
        File localsBinFile = new File(PATH_SAVE_LOC_BIN);

        try {
            FileInputStream fis_cache = new FileInputStream(cacheBinFile);
            FileInputStream fis_users = new FileInputStream(usersBinFile);
            FileInputStream fis_bugs = new FileInputStream(bugsBinFile);
            FileInputStream fis_items = new FileInputStream(itemsBinFile);
            FileInputStream fis_locals = new FileInputStream(localsBinFile);

            ObjectInputStream ois_users = new ObjectInputStream(fis_users);
            ObjectInputStream ois_cache = new ObjectInputStream(fis_cache);
            ObjectInputStream ois_bugs = new ObjectInputStream(fis_bugs);
            ObjectInputStream ois_items = new ObjectInputStream(fis_items);
            ObjectInputStream ois_locals = new ObjectInputStream(fis_locals);

            readCaches = (ArrayList<Cache>) ois_cache.readObject();
            readUsers = (ArrayList<Utilizador>) ois_users.readObject();
            readBugs = (ArrayList<TravelBug>) ois_bugs.readObject();
            readItems = (ArrayList<Item>) ois_items.readObject();
            readLocals = (ArrayList<Localizacao>) ois_locals.readObject();

            cachesTable.getItems().addAll(readCaches);
            usersTable.getItems().addAll(readUsers);
            bugsTable.getItems().addAll(readBugs);
            itemsTable.getItems().addAll(readItems);
            localsTable.getItems().addAll(readLocals);

            int size_bugs = readBugs.size();
            int size_caches = readCaches.size();
            int size_users = readUsers.size();
            int size_items = readItems.size();
            int size_locals = readLocals.size();
            System.out.println("READING FROM BIN FILE....\nRead " + size_bugs + " TravelBugs;\nRead " + size_caches + " Caches;\nRead " + size_users + " Users;\nRead " + size_items + " Items;\nRead " + size_locals + " Locals;");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }


    public void handleAddCacheAction(ActionEvent actionEvent) {
        System.out.println(cacheIdField);
        Localizacao l = fileUtils.getLocal(Integer.parseInt(cacheLocField.getText()));
        Cache c = new Cache(Integer.parseInt(cacheIdField.getText()), cacheTipoField.getText(), cacheDifField.getText(), l);
        if (fileUtils.getCache(c.getId()) == null) {
            cachesTable.getItems().add(c);
            caches.add(c);
            fileUtils.getCaches().put(c.getId(), c);
            cacheIdField.setText("");
            cacheTipoField.setText("");
            cacheDifField.setText("");
            cacheLocField.setText("");
        } else
            System.out.println("ERRO: Cache com o mesmo ID já existente!");

    }

    public void handleRemoveCacheAction(ActionEvent actionEvent) {
        ObservableList<Cache> chs = cachesTable.getSelectionModel().getSelectedItems();
        for (Cache key : chs
        ) {
            fileUtils.getCaches().delete(key.getId());
        }
        cachesTable.getItems().removeAll(chs);
        caches.removeAll(chs);
    }

    public void handleAddUserAction(ActionEvent actionEvent) {
        System.out.println(userIdField);
        Utilizador u = new Utilizador(userTipoField.getText(), Integer.parseInt(userIdField.getText()), userNameField.getText());
        if (fileUtils.getUser(u.getId()) == null) {
            usersTable.getItems().add(u);
            utilizadores.add(u);
            fileUtils.getUtilizadores().put(u.getId(), u);
            userIdField.setText("");
            userNameField.setText("");
            userTipoField.setText("");

        } else
            System.out.println("ERRO: User com o mesmo ID já existente!");
    }

    public void handleRemoveUserAction(ActionEvent actionEvent) {
        ObservableList<Utilizador> users = usersTable.getSelectionModel().getSelectedItems();
        for (Utilizador key : users) {
            fileUtils.getUtilizadores().remove(key.getId());
        }
        usersTable.getItems().removeAll(users);
        utilizadores.removeAll(users);
    }

    public void handleAddBugAction(ActionEvent actionEvent) {
        System.out.println(tbIdField);
        Cache ci = fileUtils.getCache(Integer.parseInt(tbCIField.getText()));
        Cache cf = fileUtils.getCache(Integer.parseInt(tbCFField.getText()));
        Utilizador u = fileUtils.getUser(Integer.parseInt(tbDonoField.getText()));
        TravelBug tb = new TravelBug(Integer.parseInt(tbIdField.getText()), ci, cf, u);
        if (fileUtils.getTravelBug(tb.getId()) == null) {
            bugsTable.getItems().add(tb);
            travelBugs.add(tb);
            fileUtils.getTravelBugs().put(tb.getId(), tb);
            tbIdField.setText("");
            tbCIField.setText("");
            tbCFField.setText("");
            tbDonoField.setText("");

        } else
            System.out.println("ERRO: TravelBug com o mesmo ID já existente!");
    }

    public void handleRemoveBugAction(ActionEvent actionEvent) {
        ObservableList<TravelBug> bugs = bugsTable.getSelectionModel().getSelectedItems();
        for (TravelBug key : bugs
        ) {
            fileUtils.getTravelBugs().remove(key.getId());
        }
        bugsTable.getItems().removeAll(bugs);
        travelBugs.removeAll(bugs);
    }

    public void handleAddItemAction(ActionEvent actionEvent) {
        System.out.println(itemIdField);
        Item i = new Item(Integer.parseInt(itemIdField.getText()), itemNomeField.getText());
        if (fileUtils.getItem(i.getId()) == null) {

            itemsTable.getItems().add(i);
            items.add(i);
            fileUtils.getItems().put(i.getId(), i);
            fileUtils.getItems().put(i.getId(), i);
            itemIdField.setText("");
            itemNomeField.setText("");

        } else
            System.out.println("ERRO: Item com mesmo ID já existente!");
    }

    public void handleRemoveItemAction(ActionEvent actionEvent) {
        ObservableList<Item> its = itemsTable.getSelectionModel().getSelectedItems();
        for (Item key : its
        ) {
            fileUtils.getItems().remove(key.getId());
        }
        itemsTable.getItems().removeAll(its);
        items.removeAll(its);
    }

    /**
     * AINDA NAO FUNFAM MAS NAO DAO ERROS FILHAS DAS PUTAS
     */

    public void handleAddLocAction(ActionEvent actionEvent) {
        System.out.println(locIdField);
        Localizacao l = new Localizacao(Integer.parseInt(locIdField.getText()), Double.parseDouble(locLatField.getText()), Double.parseDouble(locLongField.getText()), locZonaField.getText());
        if (fileUtils.getLocal(l.getId()) == null) {

            localsTable.getItems().add(l);
            localizacoes.add(l);
            fileUtils.getLocalizacoes().put(l.getId(), l);
            locIdField.setText("");
            locLatField.setText("");
            locLongField.setText("");
            locZonaField.setText("");

        } else
            System.out.println("ERRO: Localizacao com o mesmo ID já existente!");
    }

    public void handleRemoveLocAction(ActionEvent actionEvent) {
        ObservableList<Localizacao> locs = localsTable.getSelectionModel().getSelectedItems();
        for (Localizacao key : locs
        ) {
            fileUtils.getLocalizacoes().remove(key.getId());
        }
        localsTable.getItems().removeAll(locs);
        localizacoes.removeAll(locs);
    }

    public void handleEditCacheAction(TableColumn.CellEditEvent<Cache, String> cacheStringCellEditEvent) {
        Cache c = cachesTable.getSelectionModel().getSelectedItem();
        int col = cacheStringCellEditEvent.getTablePosition().getColumn();//seleciona coluna
        switch (col) {//seleciona linha
            case 0 -> c.setId(Integer.parseInt(cacheStringCellEditEvent.getNewValue()));
            case 1 -> c.setTipo(cacheStringCellEditEvent.getNewValue());
            case 2 -> c.setDificuldade(cacheStringCellEditEvent.getNewValue());
            case 3 -> {
                Localizacao l = fileUtils.getLocal(Integer.parseInt(cacheStringCellEditEvent.getNewValue()));
                c.setLocal_cache(l);
            }
        }
        caches.add(c);
        fileUtils.getCaches().put(c.getId(), c);
    }

    public void handleEditUserAction(TableColumn.CellEditEvent<Utilizador, String> utilizadorStringCellEditEvent) {
        Utilizador u = usersTable.getSelectionModel().getSelectedItem();
        int col = utilizadorStringCellEditEvent.getTablePosition().getColumn();
        switch (col) {
            case 0 -> u.setTipo(utilizadorStringCellEditEvent.getNewValue());
            case 1 -> u.setId(Integer.parseInt(utilizadorStringCellEditEvent.getNewValue()));
            case 2 -> u.setNome(utilizadorStringCellEditEvent.getNewValue());
        }
        utilizadores.add(u);
        fileUtils.getUtilizadores().put(u.getId(), u);
    }

    public void handleEditBugAction(TableColumn.CellEditEvent<TravelBug, String> bugStringCellEditEvent) {
        TravelBug tb = bugsTable.getSelectionModel().getSelectedItem();
        int col = bugStringCellEditEvent.getTablePosition().getColumn();//seleciona coluna
        switch (col) {//seleciona linha
            case 0 -> tb.setId(Integer.parseInt(bugStringCellEditEvent.getNewValue()));
            case 1 -> {
                Cache ci = fileUtils.getCache(Integer.parseInt(bugStringCellEditEvent.getNewValue()));
                tb.setCache_inicial(ci);
            }
            case 2 -> {
                Cache cd = fileUtils.getCache(Integer.parseInt(bugStringCellEditEvent.getNewValue()));
                tb.setCache_destino(cd);
            }
            case 3 -> {
                Utilizador u = fileUtils.getUser(Integer.parseInt(bugStringCellEditEvent.getNewValue()));
                tb.setDono(u);
            }
        }
        travelBugs.add(tb);
        fileUtils.getTravelBugs().put(tb.getId(), tb);
    }

    public void handleEditItemAction(TableColumn.CellEditEvent<Item, String> itemStringCellEditEvent) {
        Item i = itemsTable.getSelectionModel().getSelectedItem();
        int col = itemStringCellEditEvent.getTablePosition().getColumn();//seleciona coluna
        switch (col) {//seleciona linha
            case 0 -> i.setId(Integer.parseInt(itemStringCellEditEvent.getNewValue()));
            case 1 -> i.setDescricao(itemStringCellEditEvent.getNewValue());

        }
        items.add(i);
        fileUtils.getItems().put(i.getId(), i);
    }

    public void handleEditLocalAction(TableColumn.CellEditEvent<Localizacao, String> localStringCellEditEvent) {
        Localizacao l = localsTable.getSelectionModel().getSelectedItem();
        int col = localStringCellEditEvent.getTablePosition().getColumn();//seleciona coluna
        switch (col) {//seleciona linha
            case 0 -> l.setId(Integer.parseInt(localStringCellEditEvent.getNewValue()));
            case 1 -> l.setLatitude(Double.parseDouble(localStringCellEditEvent.getNewValue()));
            case 2 -> l.setLongitude(Double.parseDouble(localStringCellEditEvent.getNewValue()));
            case 3 -> l.setZona(localStringCellEditEvent.getNewValue());
        }
        localizacoes.add(l);
        fileUtils.getLocalizacoes().put(l.getId(), l);
    }


    public EdgeWeightedDigraphAED2 grafo(ST<Cache, Integer> nodes) {

        graphGroup.getChildren().clear();
        SymbolDigraphAED2 sg = new SymbolDigraphAED2("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\ligacoes.txt", ",", fileUtils);
        EdgeWeightedDigraphAED2 graph = sg.digraph();

        nodes = sg.getSt();

        for (Cache key : nodes.keys()) {
            Mercator mercator= new SphericalMercator();
            double X = mercator.xAxisProjection(key.getLocal_cache().getLatitude())  ;
            double Y = mercator.yAxisProjection(key.getLocal_cache().getLongitude());
            System.out.println(X+" | "+Y);
//            X = R * Math.cos(X) * Math.cos(Y);
//            Y = R * Math.cos(X) * Math.sin(Y);
            Circle c = new Circle(X, Y, radius);
            c.setFill(Color.GREY.brighter());
            c.setId("" + key.getId());
            Text text = new Text("" + key.getId());
            StackPane stack = new StackPane();
            stack.setLayoutX(X - radius);
            stack.setLayoutY(Y - radius);
            stack.getChildren().addAll(c, text);
            graphGroup.getChildren().add(stack);
        }

        for (DirectedEdge de : graph.edges()) {
            int from = de.from();
            int to = de.to();
            StackPane spFrom = (StackPane) graphGroup.getChildren().get(from);
            Circle cFrom = (Circle) spFrom.getChildren().get(0);
            StackPane spTo = (StackPane) graphGroup.getChildren().get(to);
            Circle cTo = (Circle) spTo.getChildren().get(0);
            Line line = new Line(cFrom.getCenterX(), cFrom.getCenterY(), cTo.getCenterX(), cTo.getCenterY());
            graphGroup.getChildren().add(line);
        }
        return graph;
    }


    public void handleSpButtonAction(ActionEvent actionEvent) {
        EdgeWeightedDigraphAED2 graph = grafo(nodes);
        fileUtils.shortest_path(Integer.parseInt(startCacheSPField.getText()),Integer.parseInt(endCacheSPField.getText()),graph);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            fileUtils.showUsers("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\users", false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        fu.showUsers("/home/rmachado/Documents/uni/lp2/projeto/data/users",true);

        try {
            fileUtils.showLocals("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\locations", false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        fu.showLocals("/home/rmachado/Documents/uni/lp2/projeto/data/locations",true);

        try {
            fileUtils.showCaches("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\caches", false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        fu.showCaches("/home/rmachado/Documents/uni/lp2/projeto/data/caches",true);

        try {
            fileUtils.showLogs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\logs", false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        fu.showLogs("/home/rmachado/Documents/uni/lp2/projeto/data/logs",true);

        try {
            fileUtils.showItems("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\items", false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        fu.showItems("/home/rmachado/Documents/uni/lp2/projeto/data/items",true);

        try {
            fileUtils.showTravelBugs("C:\\Users\\ruben\\IdeaProjects\\projeto_aed_lp\\data\\travelBugs", false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        fu.showTravelBugs("/home/rmachado/Documents/uni/lp2/projeto/data/travelBugs",true);

        grafo(nodes);

        usersTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        usertypeCol.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        usertypeCol.setCellFactory(TextFieldTableCell.<Utilizador>forTableColumn());


        useridCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        useridCol.setCellFactory(TextFieldTableCell.<Utilizador, Integer>forTableColumn(new IntegerStringConverter()));

        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        nomeCol.setCellFactory(TextFieldTableCell.<Utilizador>forTableColumn());

        usersTable.setEditable(true);

        cachesTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        cacheidCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        cacheidCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        cacheTipoCol.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        cacheTipoCol.setCellFactory(TextFieldTableCell.forTableColumn());

        cacheDifCol.setCellValueFactory(new PropertyValueFactory<>("dificuldade"));
        cacheDifCol.setCellFactory(TextFieldTableCell.forTableColumn());

        cacheLocalCol.setCellValueFactory(new PropertyValueFactory<>("local_cache"));
        cacheLocalCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Localizacao>() {
            @Override
            public String toString(Localizacao localizacao) {
                return localizacao.toString();
            }

            @Override
            public Localizacao fromString(String s) {
                return null;
            }
        }));

        cachesTable.setEditable(true);

        bugsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        bugID.setCellValueFactory(new PropertyValueFactory<>("id"));
        bugID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        bugStartCache.setCellValueFactory(new PropertyValueFactory<>("cache_inicial"));
        bugStartCache.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Cache>() {
            @Override
            public String toString(Cache cache) {
                return cache.toString();
            }

            @Override
            public Cache fromString(String s) {
                return null;
            }
        }));

        bugEndCache.setCellValueFactory(new PropertyValueFactory<>("cache_destino"));
        bugEndCache.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Cache>() {
            @Override
            public String toString(Cache cache) {
                return cache.toString();
            }

            @Override
            public Cache fromString(String s) {
                return null;
            }
        }));

        bugOwner.setCellValueFactory(new PropertyValueFactory<>("dono"));
        bugOwner.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Utilizador>() {
            @Override
            public String toString(Utilizador utilizador) {
                return utilizador.toString();
            }

            @Override
            public Utilizador fromString(String s) {
                return null;
            }
        }));

        bugsTable.setEditable(true);

        itemsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        itemID.setCellValueFactory(new PropertyValueFactory<>("id"));
        itemID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        itemName.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        itemName.setCellFactory(TextFieldTableCell.forTableColumn());

        itemsTable.setEditable(true);

        localsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        locID.setCellValueFactory(new PropertyValueFactory<>("id"));
        locID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        locLat.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        locLat.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        locLong.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        locLong.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        locZona.setCellValueFactory(new PropertyValueFactory<>("zona"));
        locZona.setCellFactory(TextFieldTableCell.forTableColumn());

        localsTable.setEditable(true);
    }
}
