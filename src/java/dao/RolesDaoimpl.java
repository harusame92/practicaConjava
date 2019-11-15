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
import java.util.List;
import modelos.Rol;
import util.Conexion;

public class RolesDaoimpl implements Dao<Rol,Integer>{

    private final String SQL_INSERT = "INSERT INTO security.roles(id, name, priority) VALUES (?, ?, ?)";

    /*
    private final String SQL_UPDATE = "UPDATE security.roles SET id=?, name=?, priority=? WHERE <condition>";    

    private final String SQL_DELETE = "DELETE FROM security.roles WHERE <condition>";

    private final String SQL_SELECT = "SELECT id, name, priority FROM security.roles";
    */            
    
   
    @Override
    public int insert(Rol t) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//no se utiliza en este ejercicio

        int rows = 0; //registros afectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setInt(index++, t.getId());//param1 => ?
            stmt.setString(index++, t.getName());//param2 => ?
            stmt.setInt(index++, t.getPriority());//param2 => ?
            System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();//no. registros afectados
            System.out.println("Registros afectados:" + rows);
        System.out.println("aqui toy");

        }catch (SQLException e){
                e.printStackTrace();
            }  finally {
                stmt.close();
                conn.close();
        }
        return rows;
        
    }

    @Override
    public List<Rol> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol getById(Integer k) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Integer k, Rol t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer k) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
    }

