package Model;

import java.sql.Date;

public abstract class Motor {
    private int id;
    private Date dataCriacao;
    private int pesoEmKg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getPesoEmKg() {
        return pesoEmKg;
    }

    public void setPesoEmKg(int pesoEmKg) {
        this.pesoEmKg = pesoEmKg;
    }
    
}