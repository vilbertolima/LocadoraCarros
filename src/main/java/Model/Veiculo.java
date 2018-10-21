package Model;

public class Veiculo {
    private int id;
    private Montadora montadora;
    private int qtd;
    private int qtdDisponivel;
    private String modelo;
    private int anoFabricacao;
    private double precoLancamento;
    private int qtdLugares;
    private Categoria categoria;
    private boolean tracaoNasQuatroRodas;
    private MotorCombustao motor;
    private String cor;
    private int pesoEmKg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Montadora getMontadora() {
        return montadora;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getPrecoLancamento() {
        return precoLancamento;
    }

    public void setPrecoLancamento(double precoLancamento) {
        this.precoLancamento = precoLancamento;
    }

    public int getQtdLugares() {
        return qtdLugares;
    }

    public void setQtdLugares(int qtdLugares) {
        this.qtdLugares = qtdLugares;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isTracaoNasQuatroRodas() {
        return tracaoNasQuatroRodas;
    }

    public void setTracaoNasQuatroRodas(boolean tracaoNasQuatroRodas) {
        this.tracaoNasQuatroRodas = tracaoNasQuatroRodas;
    }

    public MotorCombustao getMotor() {
        return motor;
    }

    public void setMotor(MotorCombustao motor) {
        this.motor = motor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPesoEmKg() {
        return pesoEmKg;
    }

    public void setPesoEmKg(int pesoEmKg) {
        this.pesoEmKg = pesoEmKg;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
    
}