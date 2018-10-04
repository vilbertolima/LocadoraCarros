package Model;

import Util.Utilitario.EnumFormaPagamento;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PedidoLocacao {
    private int id;
    private List<Veiculo> veiculos;
    private Date dataPedido;
    private double valorLocacao;
    private EnumFormaPagamento formaPagamento;
    private Cliente cliente;
    private Vendedor vendedor;
    private Date dataDevolucao;
    private String obs;
    private String cupom;
    private boolean devolvido;
    
    public PedidoLocacao(){
        this.veiculos = new ArrayList<>();
    }
    
    public PedidoLocacao(int id){
        this();
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }
    
    public void removerAudio(Veiculo veiculo){
        this.veiculos.remove(veiculo);
    }
    
    public void limparVeiculos(){
        this.veiculos.removeAll(veiculos);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    
    public List<Integer> getIdVeiculos(){
        List<Integer> idsVeiculos = new ArrayList<>();
        
        for(Veiculo veiculo: veiculos){
            idsVeiculos.add(veiculo.getId());
        }
        
        return idsVeiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean isDevolvido) {
        this.devolvido = isDevolvido;
    }
    
}