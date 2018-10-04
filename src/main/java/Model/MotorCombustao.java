package Model;

public class MotorCombustao extends Motor {
    private String combustivel;
    private int qtdTempos;
    private int potenciaNoAlcool;
    private int potenciaNaGasolina;
    private int potenciaNoDiesel;
    private int torqueEmKgFm;
    private int cilindradas;

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getQtdTempos() {
        return qtdTempos;
    }

    public void setQtdTempos(int qtdTempos) {
        this.qtdTempos = qtdTempos;
    }

    public int getPotenciaNoAlcool() {
        return potenciaNoAlcool;
    }

    public void setPotenciaNoAlcool(int potenciaNoAlcool) {
        this.potenciaNoAlcool = potenciaNoAlcool;
    }

    public int getPotenciaNaGasolina() {
        return potenciaNaGasolina;
    }

    public void setPotenciaNaGasolina(int potenciaNaGasolina) {
        this.potenciaNaGasolina = potenciaNaGasolina;
    }

    public int getPotenciaNoDiesel() {
        return potenciaNoDiesel;
    }

    public void setPotenciaNoDiesel(int potenciaNoDiesel) {
        this.potenciaNoDiesel = potenciaNoDiesel;
    }

    public int getTorqueEmKgFm() {
        return torqueEmKgFm;
    }

    public void setTorqueEmKgFm(int torqueEmKgFm) {
        this.torqueEmKgFm = torqueEmKgFm;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    
}