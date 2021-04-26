package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.Date;

public class Log {
    private Integer id;
    private Date data;
    private String nota;
    private Utilizador user;



    public Log(Integer id,Date data, String nota, Utilizador user) {
        this.id=id;
        this.data = data;
        this.nota = nota;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setUser(Utilizador user) {
        this.user = user;
    }



    @Override
    public String toString() {
        return "Log{\n    data: '" + data +
                "',\n    id: '" + id +
                "',\n    nota: '" + nota +
                "',\n    user: '" + user.getNome() +
                "'\n}\n";
    }


}
