/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jmoya
 */
public interface Dao<T, K> {

    public int insert(T t) throws SQLException;

    public List<T> getAll() throws SQLException;

    public T getById(K k) throws SQLException;

    public int update(K k, T t) throws SQLException;

    public int delete(K k) throws SQLException;

}
