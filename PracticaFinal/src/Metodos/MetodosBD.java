/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoaN
 */
public class MetodosBD {
    
    Pool metodospool = new Pool();
    DefaultTableModel ModeloTabla;
    
    
    public int Borrar(String id, String tabla, String codigo){
        String SSQL="DELETE from "+tabla+" where "+codigo+"='"+id+"'";
        Connection con = null;
        int resultado=0;
            try{
                con = metodospool.dataSource.getConnection();
                PreparedStatement psql = con.prepareStatement(SSQL);
                resultado = psql.executeUpdate();
            
                psql.close();
          
            }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar borrar\n"
                    + e,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                
                if(con!=null){
                    con.close();
                }
                
            }catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexion\n"
                    + ex,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        return resultado;

    }
    
    public int BorrarPrestamos(String id1, String id2, String tabla, String codigo1, String codigo2){
        String SSQL="DELETE from "+tabla+" where ("+codigo1+"='"+id1+"') and ("+codigo2+"='"+id2+"')";
        Connection con = null;
        int resultado=0;
            try{
                con = metodospool.dataSource.getConnection();
                PreparedStatement psql = con.prepareStatement(SSQL);
                resultado = psql.executeUpdate();
            
                psql.close();
          
            }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar borrar\n"
                    + e,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                
                if(con!=null){
                    con.close();
                }
                
            }catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexion\n"
                    + ex,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        return resultado;

    }
    
    
    public int ModificarPeliculas(String id, String titulo, String director, String genero, Date fecha, String argumento){
        String SSQL;
        int resultado = 0;
        
        Connection con = null;
        SSQL="UPDATE PELICULAS SET Titulo= ?, Director= ?, Genero=?, Fecha_Alta=?, Argumento=? WHERE Codigo_Pelicula LIKE "+String.valueOf(id);
                 
        try {
            con = metodospool.dataSource.getConnection();
            PreparedStatement psql = con.prepareStatement(SSQL);
            //System.out.println("Titulo: "+titulo+" Director: "+director+" Genero: "+genero+" Fecha: "+fecha);
            psql.setString(1, titulo);
            psql.setString(2, director);
            psql.setString(3, genero);
            psql.setDate(4, fecha);
            psql.setString(5, argumento);
            
            resultado = psql.executeUpdate();
            
            psql.close();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar la informacion\n"
                    + e,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                
                if(con!=null){
                    con.close();
                }
                
            }catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexion\n"
                    + ex,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        return resultado;
    }
    
    public void BuscarPeliculas(String valor, String filtro, JTable tabla){
        
        String [] columnas={"ID","Titulo","Director","Genero","Fecha Alta","Argumento"};
        String [] registros=new String[6];
        ModeloTabla=new DefaultTableModel(null,columnas);
        String SSQL;
        Connection conect = null;
        
        if(filtro.equals("Titulo")){
            
            SSQL="SELECT Codigo_Pelicula,Titulo,Director,Genero,Fecha_Alta,Argumento "+
                    "FROM PELICULAS WHERE Titulo LIKE '%"+valor+"%'";
            
        }else if(filtro.equals("Director")){
            SSQL="SELECT Codigo_Pelicula,Titulo,Director,Genero,Fecha_Alta,Argumento "+
                    "FROM PELICULAS WHERE Director LIKE '%"+valor+"%'";
            
        }else if(filtro.equals("Genero")){
            SSQL="SELECT Codigo_Pelicula,Titulo,Director,Genero,Fecha_Alta,Argumento "+
                    "FROM PELICULAS WHERE Genero LIKE '%"+valor+"%'";
        }else{
            SSQL="SELECT Codigo_Pelicula,Titulo,Director,Genero,Fecha_Alta,Argumento "+
                    "FROM PELICULAS WHERE Fecha_Alta LIKE '%"+valor+"%'";
        }
        
        try{
            
            conect = metodospool.dataSource.getConnection();
            PreparedStatement st = conect.prepareStatement(SSQL);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                registros[0]=rs.getString("Codigo_Pelicula");
                registros[1]=rs.getString("Titulo");
                registros[2]=rs.getString("Director");
                registros[3]=rs.getString("Genero");
                registros[4]=rs.getString("Fecha_Alta");
                registros[5]=rs.getString("Argumento");
                
                ModeloTabla.addRow(registros);
            }
            
            tabla.setModel(ModeloTabla);
            
        }catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
            
        }finally{
            
            if(conect!=null){
                
                try{
                    conect.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
        
    }
    
    public int GuardarPeliculas(String titulo, String director, String genero, Date fecha, 
            String argumento){
        
        int resultado = 0;
        
        Connection con = null;
        
        String SSQL = "INSERT INTO PELICULAS (Titulo, Director, Genero, Fecha_Alta, Argumento)"
                + "VALUES (?, ?, ?, ?, ?)";
        
        try {
            
            con = metodospool.dataSource.getConnection();
            PreparedStatement psql = con.prepareStatement(SSQL);
            psql.setString(1, titulo);
            psql.setString(2, director);
            psql.setString(3, genero);
            psql.setDate(4, fecha);
            psql.setString(5, argumento);
            //psql.setDate(4, fecha);
            
            resultado = psql.executeUpdate();
            
            psql.close();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar almacenar la informacion\n"
                    + e,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                
                if(con!=null){
                    con.close();
                }
                
            }catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexion\n"
                    + ex,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        return resultado;
    }
    
    public int ModificarSocios(String id, String nombre, String dni, String mail, String tfno){
        String SSQL;
        int resultado = 0;
        
        Connection con = null;
        SSQL="UPDATE SOCIOS SET Nombre= ?, DNI= ?, EMAIL=?, Telefono=? WHERE Num_Socio LIKE "+String.valueOf(id);
                 
        try {
            con = metodospool.dataSource.getConnection();
            PreparedStatement psql = con.prepareStatement(SSQL);
            //System.out.println("Titulo: "+titulo+" Director: "+director+" Genero: "+genero+" Fecha: "+fecha);
            psql.setString(1, nombre);
            psql.setString(2, dni);
            psql.setString(3, mail);
            psql.setString(4, tfno);
            
            resultado = psql.executeUpdate();
            
            psql.close();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar la informacion\n"
                    + e,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                
                if(con!=null){
                    con.close();
                }
                
            }catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexion\n"
                    + ex,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        return resultado;
    }
    
    public void BuscarSocios(String valor, String filtro, JTable tabla){
        
        String [] columnas={"Numero Socio","Nombre","DNI","E-Mail","Telefono"};
        String [] registros=new String[5];
        ModeloTabla=new DefaultTableModel(null,columnas);
        String SSQL;
        Connection conect = null;
        
        if(filtro.equals("Nombre")){
            
            SSQL="SELECT Num_Socio, Nombre, DNI, EMAIL, Telefono "+
                    "FROM SOCIOS WHERE Nombre LIKE '%"+valor+"%'";
            
        }else if(filtro.equals("DNI")){
            SSQL="SELECT Num_Socio, Nombre, DNI, EMAIL, Telefono "+
                    "FROM SOCIOS WHERE DNI LIKE '%"+valor+"%'";
            
        /*}else if(filtro.equals("E-Mail")){
            SSQL="SELECT Num_Socio, Nombre, DNI, EMAIL, Telefono "+
                    "FROM SOCIOS WHERE EMAIL LIKE '%"+valor+"%'";*/
        }else{
            SSQL="SELECT Num_Socio, Nombre, DNI, EMAIL, Telefono "+
                    "FROM SOCIOS WHERE Telefono LIKE '%"+valor+"%'";
        }
        
        try{
            
            conect = metodospool.dataSource.getConnection();
            PreparedStatement st = conect.prepareStatement(SSQL);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                registros[0]=rs.getString("Num_Socio");
                registros[1]=rs.getString("Nombre");
                registros[2]=rs.getString("DNI");
                registros[3]=rs.getString("EMAIL");
                registros[4]=rs.getString("Telefono");
                
                ModeloTabla.addRow(registros);
            }
            
            tabla.setModel(ModeloTabla);
            
        }catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
            
        }finally{
            
            if(conect!=null){
                
                try{
                    conect.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
        
    }
    //funciona bien
    public int GuardarSocios(String nombre, String DNI, String EMAIL, String Telefono){
        
        int resultado = 0;
        
        Connection con = null;
        
        String SSQL = "INSERT INTO SOCIOS (Nombre, DNI, EMAIL, Telefono)"
                + "VALUES (?, ?, ?, ?)";
        
        try {
            
            con = metodospool.dataSource.getConnection();
            PreparedStatement psql = con.prepareStatement(SSQL);
            psql.setString(1, nombre);
            psql.setString(2, DNI);
            psql.setString(3, EMAIL);
            psql.setString(4, Telefono);
            
            resultado = psql.executeUpdate();
            
            psql.close();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar almacenar la informacion\n"
                    + e,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                
                if(con!=null){
                    con.close();
                }
                
            }catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexion\n"
                    + ex,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        return resultado;
    }
    
    public int ModificarPrestamos(String id_socio, String id_pelicula, Date fecha, Double precio, int dias){
        String SSQL;
        int resultado = 0;
        
        Connection con = null;
        SSQL="UPDATE PRESTAMO SET Precio= ?, Num_Dias=? WHERE (Num_Socio LIKE "+String.valueOf(id_socio)+") AND (Codigo_Pelicula LIKE "+String.valueOf(id_pelicula)+")";
        //AND Fecha_Prestamo LIKE "+String.valueOf(fecha);
                 
        try {
            con = metodospool.dataSource.getConnection();
            PreparedStatement psql = con.prepareStatement(SSQL);
            //System.out.println("Titulo: "+titulo+" Director: "+director+" Genero: "+genero+" Fecha: "+fecha);
            psql.setDouble(1, precio);
            psql.setInt(2, dias);
            
            
            resultado = psql.executeUpdate();
            
            psql.close();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar la informacion\n"
                    + e,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                
                if(con!=null){
                    con.close();
                }
                
            }catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexion\n"
                    + ex,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        return resultado;
    }
    
    public void BuscarPrestamos(String valor, String filtro, JTable tabla){
        
        String [] columnas={"Numero Socio","Codigo Pelicula","Fecha Prestamo","Precio","Dias Prestamo"};
        String [] registros=new String[5];
        ModeloTabla=new DefaultTableModel(null,columnas);
        String SSQL;
        Connection conect = null;
        if(filtro.equals("Codigo Pelicula")){
            
            SSQL="SELECT Num_Socio, Codigo_Pelicula, Fecha_Prestamo, Precio, Num_Dias "+
                    "FROM PRESTAMO WHERE Codigo_Pelicula LIKE '%"+valor+"%'";
            
        }else if(filtro.equals("Numero Socio")){
            
            SSQL="SELECT Num_Socio, Codigo_Pelicula, Fecha_Prestamo, Precio, Num_Dias "+
                    "FROM PRESTAMO WHERE Num_Socio LIKE '%"+valor+"%'";
        
        }else if(filtro.equals("Fecha Prestamo")){
            
            SSQL="SELECT Num_Socio, Codigo_Pelicula, Fecha_Prestamo, Precio, Num_Dias "+
                    "FROM PRESTAMO WHERE Fecha_Prestamo LIKE '%"+valor+"%'";
            
        }else if(filtro.equals("Precio")){
           SSQL="SELECT Num_Socio, Codigo_Pelicula, Fecha_Prestamo, Precio, Num_Dias "+
                    "FROM PRESTAMO WHERE Precio LIKE '%"+valor+"%'";
            
        }else{
            SSQL="SELECT Num_Socio, Codigo_Pelicula, Fecha_Prestamo, Precio, Num_Dias "+
                    "FROM PRESTAMO WHERE Num_Dias LIKE '%"+valor+"%'";
        }
        
        try{
            
            conect = metodospool.dataSource.getConnection();
            PreparedStatement st = conect.prepareStatement(SSQL);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                registros[0]=rs.getString("Num_Socio");
                registros[1]=rs.getString("Codigo_Pelicula");
                registros[2]=rs.getString("Fecha_Prestamo");
                registros[3]=rs.getString("Precio");
                registros[4]=rs.getString("Num_Dias");
                
                ModeloTabla.addRow(registros);
            }
            
            tabla.setModel(ModeloTabla);
            
        }catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
            
        }finally{
            
            if(conect!=null){
                
                try{
                    conect.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
        
    }
    
    public int GuardarPrestamos(String socio, String cod, Date fecha, Double precio, int dias){
        
        int resultado = 0;
        
        Connection con = null;
        
        String SSQL = "INSERT INTO PRESTAMO (Num_Socio, Codigo_Pelicula, Fecha_Prestamo, Precio, Num_Dias)"
                + "VALUES (?, ?, ?, ?, ?)";
        
        try {
            
            con = metodospool.dataSource.getConnection();
            PreparedStatement psql = con.prepareStatement(SSQL);
            psql.setString(1, socio);
            psql.setString(2, cod);
            psql.setDate(3, fecha);
            psql.setDouble(4, precio);
            psql.setInt(5, dias);
            
            
            resultado = psql.executeUpdate();
            
            psql.close();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar almacenar la informacion\n"
                    + e,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                
                if(con!=null){
                    con.close();
                }
                
            }catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexion\n"
                    + ex,"Error e la operacion", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        return resultado;
    }
}
