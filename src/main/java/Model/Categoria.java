package Model;

import java.sql.Date;

public class Categoria {
    private int id;
    private String descricao;
    private boolean offroad;
    private int pesoMinimoEmKg;
    private int pesoMaximoEmKg;
    private int alturaChaoMinimaEmCm;
    private int alturaChaoMaximaEmCm;
    private Date dataCriacao;
    private int distanciaMinimaEntreEixosEmCm;
    private int distanciaMaximaEntreEixosEmCm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isOffroad() {
        return offroad;
    }

    public void setOffroad(boolean offroad) {
        this.offroad = offroad;
    }

    public int getPesoMinimoEmKg() {
        return pesoMinimoEmKg;
    }

    public void setPesoMinimoEmKg(int pesoMinimoEmKg) {
        this.pesoMinimoEmKg = pesoMinimoEmKg;
    }

    public int getPesoMaximoEmKg() {
        return pesoMaximoEmKg;
    }

    public void setPesoMaximoEmKg(int pesoMaximoEmKg) {
        this.pesoMaximoEmKg = pesoMaximoEmKg;
    }

    public int getAlturaChaoMinimaEmCm() {
        return alturaChaoMinimaEmCm;
    }

    public void setAlturaChaoMinimaEmCm(int alturaChaoMinimaEmCm) {
        this.alturaChaoMinimaEmCm = alturaChaoMinimaEmCm;
    }

    public int getAlturaChaoMaximaEmCm() {
        return alturaChaoMaximaEmCm;
    }

    public void setAlturaChaoMaximaEmCm(int alturaChaoMaximaEmCm) {
        this.alturaChaoMaximaEmCm = alturaChaoMaximaEmCm;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getDistanciaMinimaEntreEixosEmCm() {
        return distanciaMinimaEntreEixosEmCm;
    }

    public void setDistanciaMinimaEntreEixosEmCm(int distanciaMinimaEntreEixosEmCm) {
        this.distanciaMinimaEntreEixosEmCm = distanciaMinimaEntreEixosEmCm;
    }

    public int getDistanciaMaximaEntreEixosEmCm() {
        return distanciaMaximaEntreEixosEmCm;
    }

    public void setDistanciaMaximaEntreEixosEmCm(int distanciaMaximaEntreEixosEmCm) {
        this.distanciaMaximaEntreEixosEmCm = distanciaMaximaEntreEixosEmCm;
    }
    
    
}