/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Linha;

/**
 *
 * @author Note-Claudio
 */
public class LinhaDAO {
    private final Connection con;
    
     public LinhaDAO() throws SQLException, Exception{
        con = Conexao.getConexao();
    }
 /**
    * Método responsável por identificar a operação, se Inserir ou Alterar.
    * @param emp
    * @return boolean
    */
    public boolean salvar(Linha lin){
        if(lin.getIdLinha() == null){
            System.out.println("inserir");

            return inserir(lin);
        }else{
            return alterar(lin);
        }
    }
    
    private boolean inserir(Linha lin){
        String sql = "INSERT INTO linha (id_linha, nome, empresa) VALUES (?, ?, ?)";
        
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, lin.getIdLinha());
            pstm.setString(2, lin.getNome());
            pstm.setInt(3, lin.getIdEmpresa());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção no método inserir() da classe LinhaDAO: " + ex.getMessage());
            return false;
        }
    }
    
    private boolean alterar(Linha lin){
        String sql = "UPDATE linha SET id_linha=?, nome=?, empresa=? WHERE id_linha = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, lin.getIdLinha());
            pstm.setString(2, lin.getNome());
            pstm.setInt(3, lin.getIdEmpresa());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex){
            System.out.println("Exceção no método alterar() da classe LinhaDAO: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean excluir(Integer id){
        String sql = "DELETE from linha where id_linha = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção no método excluir() da classe LinhaDAO: " + ex.getMessage());
            return false;
        }
    }
    
    public Linha getLinhaById(Integer id){
        String sql = "SELECT * from linha where id_linha = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, id);
            try(ResultSet rs = pstm.executeQuery()){
                Linha lin = new Linha();
                if(rs.next()){
                    lin.setIdLinha(rs.getInt("id_linha"));
                    lin.setNome(rs.getString("nome"));
                    lin.setIdEmpresa(rs.getInt("empresa"));
                    return lin;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Exceção no método localizarLinha() da classe LinhaDAO: " + ex.getMessage());
        }
        return null;
    }
    
    public List<Linha> getLinhaByNome(String nome){
        String sql = "select * from linha where nome ILIKE ? ORDER BY nome";
        try ( PreparedStatement pstmt = con.prepareStatement(sql) ) {
            pstmt.setString(1, nome + "%");
            List<Linha> lins = new ArrayList<>();
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    Linha lin = new Linha();
                    lin.setIdLinha(rs.getInt("id_linha"));
                    lin.setNome(rs.getString("nome"));
                    lin.setIdEmpresa(rs.getInt("empresa"));
                    lins.add(lin);
                }
            }
            return lins;
        }catch(SQLException ex){
            System.out.println("Exceção no método getLinhaByNome() da classe LinhaDAO: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Linha> getLista(){
        String sql = "select * from linha order by id_linha";
        
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            List<Linha> lins = new ArrayList<>();
            try(ResultSet rs = pstm.executeQuery()){
                while(rs.next()){
                    Linha lin = new Linha();
                    lin.setIdLinha(rs.getInt("id_linha"));
                    lin.setNome(rs.getString("nome"));
                    lins.add(lin);
                }
            }
            return lins;
        } catch (SQLException ex) {
            System.out.println("Exceção no método getLista() da classe LinhaDAO: " + ex.getMessage());
            return null;
        }
    }
}