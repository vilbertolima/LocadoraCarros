package DAO;

import Model.Pais;
import Util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO {
    public static void salvar(Pais pPais) throws SQLException, ClassNotFoundException {
        int contadorParametros = 1;
        String comando;
        Connection conexao = FabricaConexao.getConnection();
        
        if(pPais.getId() == 0){
            comando = "INSERT INTO Pais (nome_em_portugues, nome_no_idioma_original, idioma_principal, "
                    + "qtd_habitantes, data_fundacao, pib_em_dolar, "
                    + "continente, temperatura_maxima_registrada_em_celcius, temperatura_minima_registrada_em_celcius) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            PreparedStatement stmt = conexao.prepareStatement(comando);
            stmt.setString(contadorParametros++, pPais.getNomeEmPortugues());
            stmt.setString(contadorParametros++, pPais.getNomeNoIdiomaOriginal());
            stmt.setString(contadorParametros++, pPais.getIdiomaPrincipal());
            stmt.setLong(contadorParametros++, pPais.getQtdHabitantes());
            stmt.setDate(contadorParametros++, pPais.getDataFundacao());
            stmt.setDouble(contadorParametros++, pPais.getPibEmDolar());
            stmt.setString(contadorParametros++, pPais.getContinente());
            stmt.setInt(contadorParametros++, pPais.getTemperaturaMaximaRegistradaEmCelcius());
            stmt.setInt(contadorParametros++, pPais.getTemperaturaMinimaRegistradaEmCelcius());
            
            //insere na tabela Pais
            stmt.executeUpdate();

            conexao.close();
            
        } else {
            comando = "UPDATE Pais SET "
                    + " nome_em_portugues = ?"
                    + ", nome_no_idioma_original = ?"
                    + ", idioma_principal = ?"
                    + ", qtd_habitantes = ?"
                    + ", data_fundacao = ?"
                    + ", pib_em_dolar = ?"
                    + ", continente = ?"
                    + ", temperatura_maxima_registrada_em_celcius = ?"
                    + ", temperatura_minima_registrada_em_celcius = ?"
                    + " WHERE id = ?";
            
            PreparedStatement stmt = conexao.prepareStatement(comando);
            stmt.setString(contadorParametros++, pPais.getNomeEmPortugues());
            stmt.setString(contadorParametros++, pPais.getNomeNoIdiomaOriginal());
            stmt.setString(contadorParametros++, pPais.getIdiomaPrincipal());
            stmt.setLong(contadorParametros++, pPais.getQtdHabitantes());
            stmt.setDate(contadorParametros++, pPais.getDataFundacao());
            stmt.setDouble(contadorParametros++, pPais.getPibEmDolar());
            stmt.setString(contadorParametros++, pPais.getContinente());
            stmt.setInt(contadorParametros++, pPais.getTemperaturaMaximaRegistradaEmCelcius());
            stmt.setInt(contadorParametros++, pPais.getTemperaturaMinimaRegistradaEmCelcius());
            stmt.setInt(contadorParametros++, pPais.getId());
            
            stmt.executeUpdate();
            
            conexao.close();
        }
    }

    public static List<Pais> consultar(Pais pPais) throws SQLException, ClassNotFoundException{
        int contadorParametros = 1;
        List<Pais> paises = new ArrayList<>();
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        
        String comando = "SELECT id, nome_em_portugues, nome_no_idioma_original, idioma_principal, "
                    + "qtd_habitantes, data_fundacao, pib_em_dolar, "
                    + "continente, temperatura_maxima_registrada_em_celcius,"
                    + " temperatura_minima_registrada_em_celcius FROM Pais "
                    + "WHERE 1 = 1 ";
        
        if(pPais.getId() > 0){
            comando += "AND id = ? ";
        }
        
        stmt = conexao.prepareStatement(comando);
        
        if(pPais.getId() > 0){
            stmt.setLong(contadorParametros++, pPais.getId());
        }
                 
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            paises.add(montarObjeto(rs));
        }
        
        //fecha a conexao
        conexao.close();
        
        return paises;
    }

    public static void excluir(Pais pPais) throws SQLException, ClassNotFoundException {
        String comando;
        Connection conexao = FabricaConexao.getConnection();
        
        comando = "DELETE FROM Pais WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(comando);
        stmt.setLong(1, pPais.getId());
        
        //Exclui da tabela Pais
        stmt.executeUpdate();
    }
    
    private static Pais montarObjeto(ResultSet rs) throws SQLException{
        Pais pais = new Pais();
        pais.setId(rs.getInt("id"));
        pais.setNomeEmPortugues(rs.getString("nome_em_portugues"));
        pais.setNomeNoIdiomaOriginal(rs.getString("nome_no_idioma_original"));
        pais.setIdiomaPrincipal(rs.getString("idioma_principal"));
        pais.setQtdHabitantes(rs.getLong("qtd_habitantes"));
        pais.setDataFundacao(rs.getDate("data_fundacao"));
        pais.setPibEmDolar(rs.getInt("pib_em_dolar"));
        pais.setContinente(rs.getString("continente"));
        pais.setTemperaturaMaximaRegistradaEmCelcius(rs.getInt("temperatura_maxima_registrada_em_celcius"));
        pais.setTemperaturaMinimaRegistradaEmCelcius(rs.getInt("temperatura_minima_registrada_em_celcius"));
        return pais;
    }
}