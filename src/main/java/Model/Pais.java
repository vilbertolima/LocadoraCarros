package Model;

import java.sql.Date;

public class Pais {
    private int id;
    private String nomeEmPortugues;
    private String nomeNoIdiomaOriginal;
    private String idiomaPrincipal;
    private long qtdHabitantes;
    private Date dataFundacao;
    private double pibEmDolar;
    private String continente;
    private int temperaturaMaximaRegistradaEmCelcius;
    private int temperaturaMinimaRegistradaEmCelcius;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEmPortugues() {
        return nomeEmPortugues;
    }

    public void setNomeEmPortugues(String nomeEmPortugues) {
        this.nomeEmPortugues = nomeEmPortugues;
    }

    public String getNomeNoIdiomaOriginal() {
        return nomeNoIdiomaOriginal;
    }

    public void setNomeNoIdiomaOriginal(String nomeNoIdiomaOriginal) {
        this.nomeNoIdiomaOriginal = nomeNoIdiomaOriginal;
    }

    public String getIdiomaPrincipal() {
        return idiomaPrincipal;
    }

    public void setIdiomaPrincipal(String idiomaPrincipal) {
        this.idiomaPrincipal = idiomaPrincipal;
    }

    public long getQtdHabitantes() {
        return qtdHabitantes;
    }

    public void setQtdHabitantes(long qtdHabitantes) {
        this.qtdHabitantes = qtdHabitantes;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public double getPibEmDolar() {
        return pibEmDolar;
    }

    public void setPibEmDolar(double pibEmDolar) {
        this.pibEmDolar = pibEmDolar;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getTemperaturaMaximaRegistradaEmCelcius() {
        return temperaturaMaximaRegistradaEmCelcius;
    }

    public void setTemperaturaMaximaRegistradaEmCelcius(int temperaturaMaximaRegistradaEmCelcius) {
        this.temperaturaMaximaRegistradaEmCelcius = temperaturaMaximaRegistradaEmCelcius;
    }

    public int getTemperaturaMinimaRegistradaEmCelcius() {
        return temperaturaMinimaRegistradaEmCelcius;
    }

    public void setTemperaturaMinimaRegistradaEmCelcius(int temperaturaMinimaRegistradaEmCelcius) {
        this.temperaturaMinimaRegistradaEmCelcius = temperaturaMinimaRegistradaEmCelcius;
    }
    
}