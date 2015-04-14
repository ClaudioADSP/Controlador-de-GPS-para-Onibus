/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Note-Claudio
 */
public final class Conexao {
    
    private static Connection con;
    
    public static Connection getConexao() throws Exception{
        if(con == null){DriverManager.registerDriver(new org.postgresql.Driver());
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/OnibusGPS", "postgres", "postgres");
        return con;
        }
        return con;
    }
}
