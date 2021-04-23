package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.RedBlackBST;

public class Log {
    private Date data;
    private String nota;
    private Utilizador user;

    public static RedBlackBST<Integer,Log> logs= new RedBlackBST<>();
    public static RedBlackBST<Integer,Log> deleted_logs= new RedBlackBST<>();

    public Log(Date data, String nota, Utilizador user) {
        this.data = data;
        this.nota = nota;
        this.user = user;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Utilizador getUser() {
        return user;
    }

    public int getUserID(){
        return user.getId();
    }

    public void setUser(Utilizador user) {
        this.user = user;
    }

    public void delete(){
        if (logs.contains(this.getUserID())){
            deleted_logs.put(this.getUserID(),this);
            logs.delete(this.getUserID());

        }
    }

    @Override
    public String toString() {
        return "Log{" +
                "data=" + data +
                ", nota='" + nota + '\'' +
                ", user=" + user +
                '}';
    }
}
