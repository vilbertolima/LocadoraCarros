package Model;

import java.sql.Date;
import java.util.List;

public class Montadora {
    private int id;
    private String nome;
    private String sloganEmPortugues;
    private String sloganOriginal;
    private double faturamenteAnualEmDolar;
    private double lucroAnualEmDolar;
    private String cidadeFundacao;
    private Date dataFundacao;
    private List<Pais> paisesComSede;
    private int qtdFabricas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSloganEmPortugues() {
        return sloganEmPortugues;
    }

    public void setSloganEmPortugues(String sloganEmPortugues) {
        this.sloganEmPortugues = sloganEmPortugues;
    }

    public String getSloganOriginal() {
        return sloganOriginal;
    }

    public void setSloganOriginal(String sloganOriginal) {
        this.sloganOriginal = sloganOriginal;
    }

    public double getFaturamenteAnualEmDolar() {
        return faturamenteAnualEmDolar;
    }

    public void setFaturamenteAnualEmDolar(double faturamenteAnualEmDolar) {
        this.faturamenteAnualEmDolar = faturamenteAnualEmDolar;
    }

    public double getLucroAnualEmDolar() {
        return lucroAnualEmDolar;
    }

    public void setLucroAnualEmDolar(double lucroAnualEmDolar) {
        this.lucroAnualEmDolar = lucroAnualEmDolar;
    }

    public String getCidadeFundacao() {
        return cidadeFundacao;
    }

    public void setCidadeFundacao(String cidadeFundacao) {
        this.cidadeFundacao = cidadeFundacao;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public List<Pais> getPaisesComSede() {
        return paisesComSede;
    }

    public void setPaisesComSede(List<Pais> paisesComSede) {
        this.paisesComSede = paisesComSede;
    }

    public int getQtdFabricas() {
        return qtdFabricas;
    }

    public void setQtdFabricas(int qtdFabricas) {
        this.qtdFabricas = qtdFabricas;
    }
    
    
}