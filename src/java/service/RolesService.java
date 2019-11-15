/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.Dao;
import dao.RolesDaoimpl;
import java.sql.SQLException;
import modelos.Rol;

/**
 *
 * @author jmoya
 */
public class RolesService {

    public int creaRol(Rol rol) {

        int nro = 0;

        Dao dao = new RolesDaoimpl();
        try {
            nro = dao.insert(rol);
            System.out.println(nro);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nro;

    }

}
