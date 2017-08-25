/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import bean.ComputadoraBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class ConexionBD {
    private Connection con;             //Establece la coneion
    private Statement enunciadoSQL;     //enunciado valido SQL
    private ResultSet rs;               //conjunto de datos resultante de una consulta

    public ConexionBD(String origen){
        try{
            //Carga el controlador mySql
           Class.forName("com.mysql.jdbc.Driver");
           
           //Carga el controlador de SQLServer
           // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Cargando correctamente driver...");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //controlador genÃ©rico Access
            //con= DriverManager.getConnection(
            //        "jdbc:odbc:"+origen,"",""); //Cadena de conexiÃƒÂ³n
            con= DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/"+origen,"root","");
                     //Cadena de conexiÃƒÂ³n
            
            
            JOptionPane.showMessageDialog(null,"Conexión exitosa!!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al establecer la conexión!!");
        }
    }
     /**
     * MÃ©todo empleado para realizar Inserciones, Eliminaciones
     * y Actualizaciones en una tabla (Altas, Bajas y Cambios)
     * @param enunciado Enunciado vÃ¡lido de SQL (insert, delete
     * update)
     */
    public void actualizar(String enunciado){
        int n=0;    //nÃºmero de registros afectados
        try{
            enunciadoSQL= con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            n= enunciadoSQL.executeUpdate(enunciado);
            JOptionPane.showMessageDialog(
                    null,""+n+" registros actualizados");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,"Error al intentar actualizar.");
        }
    }
    
    /**
     * MÃ©todo que nos permite realizar consultas
     * a una base de datos
     * @param enunciado Enunciado de consulta vÃ¡lido (query)
     */
    public List<ComputadoraBean> consultar(String enunciado){
        List<ComputadoraBean> computadoraBeans = new ArrayList<ComputadoraBean>();
        try{
            enunciadoSQL= con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
                    );
          rs= enunciadoSQL.executeQuery(enunciado);
          while(rs.next()){
              ComputadoraBean bean = new ComputadoraBean();
              bean.setNoSerie(rs.getString("noSerie"));
              bean.setEstado(rs.getString("estado"));
              bean.setDisco(rs.getInt("disco"));
              bean.setRam(rs.getInt("ram"));
              bean.setModelo(rs.getString("modelo"));
              bean.setProcesador(rs.getString("procesador"));
              bean.setMarca(rs.getString("marca"));
              computadoraBeans.add(bean);
          }
          JOptionPane.showMessageDialog(null, "Consulta exitosa" );
          return computadoraBeans;
        }catch(Exception e){
            e.printStackTrace();
          JOptionPane.showMessageDialog(null,"Error en la consulta!!");
          return null;
        
        }
    }
    
    public boolean irPrimero(){
        try{
            rs.first();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No hay registros!!");
            return false;
        }
    }
    
    public boolean irSiguiente(){
        try{
            rs.next();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ãºltimo registro!!");
            return false;
        }
    }
    
    public boolean irAnterior(){
        try{
            rs.previous();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Primer registro!!");
            return false;
        }
    }
    
    public boolean irUltimo(){
        try{
            rs.last();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No hay registros!!");
            return false;
        }
    }
    
    public String obtenerCampo(int num){
        try{
            return rs.getString(num);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: el campo "+num+" no existe!!");
            return null;
        }
    }
    
    public String obtenerCampo(String campo){
        try{
            return rs.getString(campo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: el campo "+campo+" no existe!!");
            return null;
        }
    }
    
    public int getNumRegistros(){
        try{
            rs.last(); //Posicionarse en el último registro.
            return rs.getRow();  //Devuelve el número de registro.
        }catch(Exception e){
            return 0;
        }
        
    }
    
    public void cerrar(){
        try{
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al intentar cerrar BD");
        }
    }
}
