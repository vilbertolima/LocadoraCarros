package DAO;

import Model.Cliente;
import Model.PedidoLocacao;
import Model.Veiculo;
import Model.Vendedor;
import Util.FabricaConexao;
import Util.Utilitario.EnumFormaPagamento;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoLocacaoDAO {

    public static void salvar(PedidoLocacao pPedidoLocacao) throws SQLException, ClassNotFoundException {
        int contadorParametros = 1;
        String comando;
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        
        if(pPedidoLocacao.getId() == 0){
            comando = "INSERT INTO Pedido_Locacao (data_pedido, valor_locacao, forma_pagamento, id_cliente, id_vendedor, data_devolucao"
                    + ", obs, cupom, devolvido) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            stmt = conexao.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS);
            
        } else {
            for (Veiculo veiculo : VeiculoDAO.consultarPorPedidoLocacao(pPedidoLocacao)) {
                //Atualiza a qtd de veiculos disponiveis
                veiculo = VeiculoDAO.consultar(veiculo).get(0);
                veiculo.setQtdDisponivel(veiculo.getQtdDisponivel() + 1);
                VeiculoDAO.atualizarQtdDisponivel(veiculo);
            }
            
            //Exclui os audios vinculados ao pedidoLocacao
            contadorParametros = 1;
            comando = "DELETE FROM Pedido_Locacao_Veiculo WHERE id_pedido_locacao = ?";
            stmt = conexao.prepareStatement(comando);
            stmt.setLong(contadorParametros++, pPedidoLocacao.getId());
            stmt.executeUpdate();
            
            
            contadorParametros = 1;
            comando = "UPDATE Pedido_Locacao SET"
                    + " data_pedido = ?"
                    + ", valor_locacao = ?"
                    + ", forma_pagamento = ?"
                    + ", id_cliente = ?"
                    + ", id_vendedor = ?"
                    + ", data_devolucao = ?"
                    + ", obs = ?"
                    + ", cupom = ?"
                    + ", devolvido = ?"
                    + " WHERE id = ?";
            stmt = conexao.prepareStatement(comando);
        }

        stmt.setDate(contadorParametros++, pPedidoLocacao.getDataPedido());
        stmt.setDouble(contadorParametros++, pPedidoLocacao.getValorLocacao());
        stmt.setString(contadorParametros++, pPedidoLocacao.getFormaPagamento().toString());
        stmt.setLong(contadorParametros++, pPedidoLocacao.getCliente().getId());
        stmt.setLong(contadorParametros++, pPedidoLocacao.getVendedor().getId());
        stmt.setDate(contadorParametros++, pPedidoLocacao.getDataDevolucao());
        stmt.setString(contadorParametros++, pPedidoLocacao.getObs());
        stmt.setString(contadorParametros++, pPedidoLocacao.getCupom());
        stmt.setBoolean(contadorParametros++, pPedidoLocacao.isDevolvido());

        //passa o id para ALTERACAO
        if(pPedidoLocacao.getId() > 0) {
            stmt.setLong(contadorParametros++, pPedidoLocacao.getId());
        }
        
        //salva na tabela pedidoLocacao
        stmt.executeUpdate();

        //recupera o id gerado na tabela pedidoLocacao para INCLUSAO
        if(pPedidoLocacao.getId() == 0){
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

            pPedidoLocacao.setId(rs.getInt(1));
            
        }

        for (Veiculo veiculo : pPedidoLocacao.getVeiculos()) {
            //zera o contador de parametros
            contadorParametros = 1;
            
            comando = "INSERT INTO Pedido_Locacao_Veiculo (id_pedido_locacao, id_veiculo) "
            + "VALUES (?, ?);";
            stmt = conexao.prepareStatement(comando);
            stmt.setLong(contadorParametros++, pPedidoLocacao.getId());
            stmt.setLong(contadorParametros++, veiculo.getId());

            //insere o audio na tabela Pedido_Locacao_Veiculo
            stmt.executeUpdate();
            
            veiculo = VeiculoDAO.consultar(veiculo).get(0);
            veiculo.setQtdDisponivel(veiculo.getQtdDisponivel() - 1);
            VeiculoDAO.atualizarQtdDisponivel(veiculo);
        }

        conexao.close();
            
    }

    public static List<PedidoLocacao> consultar(PedidoLocacao pPedidoLocacao) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException{
        int contadorParametros = 1;
        List<PedidoLocacao> pedidosLocacao = new ArrayList<>();
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        
        String comando = "SELECT id, data_pedido, valor_locacao, forma_pagamento, id_cliente, id_vendedor, data_devolucao"
                        + ", obs, cupom, devolvido"
                        + " FROM Pedido_Locacao WHERE devolvido = 0 ";
        
        if(pPedidoLocacao.getId() > 0){
            comando += "AND Pedido_Locacao.id = ? ";
        }
        
        stmt = conexao.prepareStatement(comando);
        
        if(pPedidoLocacao.getId() > 0){
            stmt.setLong(contadorParametros++, pPedidoLocacao.getId());
        }
                 
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            pedidosLocacao.add(montarObjeto(rs));
        }
        
        for(PedidoLocacao pedidoLocacao : pedidosLocacao){
            pedidoLocacao.setVeiculos(VeiculoDAO.consultarPorPedidoLocacao(pedidoLocacao));
        }
        
        //fecha a conexao
        conexao.close();
        
        return pedidosLocacao;
    }

    public static void excluir(PedidoLocacao pPedidoLocacao) throws SQLException, ClassNotFoundException {
        String comando;
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        
        //Exclui os veiculos vinculados ao pedidoLocacao
        comando = "DELETE FROM Pedido_Locacao_Veiculo WHERE id_pedido_locacao = ?";
        stmt = conexao.prepareStatement(comando);
        stmt.setLong(1, pPedidoLocacao.getId());
        stmt.executeUpdate();
        
        //Exclui da tabela PedidoLocacao
        comando = "DELETE FROM Pedido_Locacao WHERE id = ?";
        stmt = conexao.prepareStatement(comando);
        stmt.setLong(1, pPedidoLocacao.getId());
        stmt.executeUpdate();
    }
    
    public static void devolver(PedidoLocacao pPedidoLocacao) throws SQLException, ClassNotFoundException {
        String comando;
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        
        //Atualiza a tabela pedido_locacao com a devolucao do veiculo
        comando = "UPDATE Pedido_Locacao SET devolvido = 1 WHERE id = ?";
        stmt = conexao.prepareStatement(comando);
        stmt.setLong(1, pPedidoLocacao.getId());
        stmt.executeUpdate();
        
        //Atualiza a quantidade disponivel dos veiculos do pedido
        for (Veiculo veiculo : pPedidoLocacao.getVeiculos()) {
            veiculo.setQtdDisponivel(veiculo.getQtdDisponivel() + 1);
            VeiculoDAO.atualizarQtdDisponivel(veiculo);
        }
    }
    
    private static PedidoLocacao montarObjeto(ResultSet rs) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException{
        PedidoLocacao pedidoLocacao = new PedidoLocacao();

        //Monta o objeto pedidoLocacao
        pedidoLocacao.setId(rs.getInt("id"));
        pedidoLocacao.setDataPedido(rs.getDate("data_pedido"));
        pedidoLocacao.setValorLocacao(rs.getDouble("valor_locacao"));
        pedidoLocacao.setFormaPagamento(EnumFormaPagamento.valueOf(rs.getString("forma_pagamento")));
        pedidoLocacao.setDataDevolucao(rs.getDate("data_devolucao"));
        pedidoLocacao.setObs(rs.getString("obs"));
        pedidoLocacao.setCupom(rs.getString("cupom"));
        pedidoLocacao.setDevolvido(rs.getBoolean("devolvido"));
        
        Cliente cliente = new Cliente(rs.getInt("id_cliente"));
        pedidoLocacao.setCliente(ClienteDAO.consultar(cliente).get(0));
            
        Vendedor vendedor = new Vendedor(rs.getInt("id_vendedor"));
        pedidoLocacao.setVendedor(VendedorDAO.consultar(vendedor).get(0));

        pedidoLocacao.setVeiculos(VeiculoDAO.consultarPorPedidoLocacao(pedidoLocacao));

        return pedidoLocacao;
    }
}