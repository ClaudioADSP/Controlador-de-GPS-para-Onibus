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
import modelo.Horario;

/**
 *
 * @author Note-Claudio
 */
public class HorarioDAO {
    private final Connection con;
    
     public HorarioDAO() throws SQLException, Exception{
        con = Conexao.getConexao();
    }
 /**
    * Método responsável por identificar a operação, se Inserir ou Alterar.
    * @param emp
    * @return boolean
    */
    public boolean salvar(Horario hor){
        if(hor.getIdHorario() == null){
            System.out.println("inserir");

            return inserir(hor);
        }else{
            return alterar(hor);
        }
    }
    
    private boolean inserir(Horario hor){
        String sql = "INSERT INTO horario (id_horario, hora_saida, hora_chegada, tipo) VALUES (?, ?, ?, ?)";
        
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, hor.getIdHorario());
            pstm.setString(2, hor.getHoraSaida());
            pstm.setString(3, hor.getHoraChegada());
            pstm.setString(4, hor.getTipo());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção no método inserir() da classe HorarioDAO: " + ex.getMessage());
            return false;
        }
    }
    
    private boolean alterar(Horario hor){
        String sql = "UPDATE horario SET id_hotrario=?, tipo=? WHERE id_horario = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, hor.getIdHorario());
            pstm.setString(2, hor.getHoraSaida());
            pstm.setString(3, hor.getHoraChegada());
            pstm.setString(4, hor.getTipo());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex){
            System.out.println("Exceção no método alterar() da classe HorarioDAO: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean excluir(Integer id){
        String sql = "DELETE from horario where id_horario = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção no método excluir() da classe HorarioDAO: " + ex.getMessage());
            return false;
        }
    }
    
    public Horario getHorarioById(Integer id){
        String sql = "SELECT * from horario where id_horario = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, id);
            try(ResultSet rs = pstm.executeQuery()){
                Horario hor = new Horario();
                if(rs.next()){
                    hor.setIdHorario(rs.getInt("id_horario"));
                    return hor;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Exceção no método localizarHorario() da classe HorarioDAO: " + ex.getMessage());
        }
        return null;
    }
    
    public List<Horario> getHorarioByHora(String hora){
        String sql = "select * from horario where hora_saida ILIKE ? ORDER BY hora_saida";
        try ( PreparedStatement pstmt = con.prepareStatement(sql) ) {
            pstmt.setString(1, hora + "%");
            List<Horario> hors = new ArrayList<>();
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    Horario hor = new Horario();
                    hor.setIdHorario(rs.getInt("id_Horario"));
                    hor.setHoraSaida(rs.getString("horario_saida"));
                    hors.add(hor);
                }
            }
            return hors;
        }catch(SQLException ex){
            System.out.println("Exceção no método getHorarioByHora() da classe HorarioDAO: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Horario> getLista(){
        String sql = "select * from horario order by id_horario";
        
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            List<Horario> hors = new ArrayList<>();
            try(ResultSet rs = pstm.executeQuery()){
                while(rs.next()){
                    Horario hor = new Horario();
                    hor.setIdHorario(rs.getInt("id_horario"));
                    hor.setTipo(rs.getString("tipo"));
                    hors.add(hor);
                }
            }
            return hors;
        } catch (SQLException ex) {
            System.out.println("Exceção no método getLista() da classe HorarioDAO: " + ex.getMessage());
            return null;
        }
    }
}