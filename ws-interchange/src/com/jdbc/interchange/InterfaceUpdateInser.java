/**
 * 
 */
package com.jdbc.interchange;

import java.sql.SQLException;

/**
 * @author Adrian Morales Ruaro
 *
 */
public interface InterfaceUpdateInser {
    public void insert(Object o) throws SQLException;
    public void update(Object o) throws SQLException;
    public void delete(Object o) throws SQLException;
    public void utils(Object o) throws SQLException;
    public void procesa(String registro,String db) throws SQLException;

}
