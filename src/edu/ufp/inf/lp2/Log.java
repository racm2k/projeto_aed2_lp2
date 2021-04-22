package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.Date;
import jdk.jshell.execution.Util;

public class Log {
    private Date data;
    private String nota;
    private Utilizador user;

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

    @Override
    public String toString() {
        return "Log{" +
                "data=" + data +
                ", nota='" + nota + '\'' +
                ", user=" + user +
                '}';
    }
}
