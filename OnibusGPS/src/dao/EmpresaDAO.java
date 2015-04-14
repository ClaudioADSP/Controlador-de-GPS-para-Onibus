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
import modelo.Empresa;
/**
 *
 * @author Note-Claudio
 */
public class EmpresaDAO {
    private final Connection con;
    
     public EmpresaDAO() throws SQLException, Exception{
        con = Conexao.getConexao();
    }
 /**
    * Método responsável por identificar a operação, se Inserir ou Alterar.
    * @param emp
    * @return boolean
    */
    public boolean salvar(Empresa emp){
        if(emp.getIdEmpresa() == null){
            System.out.println("inserir");

            return inserir(emp);
        }else{
            return alterar(emp);
        }
    }
    
    private boolean inserir(Empresa emp){
        String sql = "INSERT INTO empresa (nome) VALUES ( ?)";
        
        try(PreparedStatement pstm = con.prepareStatement(sql)){
          
            pstm.setString(1, emp.getNome());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção no método inserir() da classe EmpresaDAO: " + ex.getMessage());
            return false;
        }
    }
    
    private boolean alterar(Empresa emp){
        String sql = "UPDATE empresa SET nome=? WHERE id_empresa = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, emp.getNome());
            pstm.setInt(2, emp.getIdEmpresa());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex){
            System.out.println("Exceção no método alterar() da classe EmpresaDAO: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean excluir(Integer id){
        String sql = "DELETE from empresa where id_empresa = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção no método excluir() da classe EmpresaDAO: " + ex.getMessage());
            return false;
        }
    }
    
    public Empresa getEmpresaById(Integer id){
        String sql = "SELECT * from empresa where id_empresa = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, id);
            try(ResultSet rs = pstm.executeQuery()){
                Empresa emp = new Empresa();
                if(rs.next()){
                    emp.setIdEmpresa(rs.getInt("id_empresa"));
                    emp.setNome(rs.getString("nome"));
                    return emp;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Exceção no método localizarEmpresa() da classe EmpresaDAO: " + ex.getMessage());
        }
        return null;
    }
    
    public List<Empresa> getEmpresaByNome(String nome){
        String sql = "select * from empresa where nome ILIKE ? ORDER BY nome";
        try ( PreparedStatement pstmt = con.prepareStatement(sql) ) {
            pstmt.setString(1, nome + "%");
            List<Empresa> emps = new ArrayList<>();
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    Empresa emp = new Empresa();
                    emp.setIdEmpresa(rs.getInt("id_empresa"));
                    emp.setNome(rs.getString("nome"));
                    emps.add(emp);
                }
            }
            return emps;
        }catch(SQLException ex){
            System.out.println("Exceção no método getEmpresaByNome() da classe EmpresaDAO: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Empresa> getLista(){
        String sql = "select * from empresa order by id_empresa";
        
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            List<Empresa> emps = new ArrayList<>();
            try(ResultSet rs = pstm.executeQuery()){
                while(rs.next()){
                    Empresa emp = new Empresa();
                    emp.setIdEmpresa(rs.getInt("id_empresa"));
                    emp.setNome(rs.getString("nome"));
                    emps.add(emp);
                }
            }
            return emps;
        } catch (SQLException ex) {
            System.out.println("Exceção no método getLista() da classe EmpresaDAO: " + ex.getMessage());
            return null;
        }
    }
}