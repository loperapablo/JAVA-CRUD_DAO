
package interfaces;

import clases.Funcionario;
import dao.conexionSQL;
import java.sql.*;


public class DAOFuncionarioImplementacion implements DAOFuncionario{
    
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    
    

    @Override
    public void registrar(Funcionario funcionario) {
        
            String SQLtexto="insert into funcionarios (tipoIdentificacion, Identificacion, nombres, apellidos, estadoCivil, genero, direccion, telefono, fechaDeNacimiento) values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(SQLtexto);
            
            pst.setString(1, funcionario.getTipoIdentificacion());
            pst.setString(2, funcionario.getIdentificacion());
            pst.setString(3, funcionario.getNombres());
            pst.setString(4, funcionario.getApellidos());
            pst.setString(5, funcionario.getEstadoCivil());
            pst.setString(6, funcionario.getGenero());
            pst.setString(7, funcionario.getDireccion());
            pst.setString(8, funcionario.getTelefono());
            pst.setString(9, funcionario.getFechaDeNacimiento());
            
            
            
            pst.executeUpdate();
            
            cc.cerrarConexion();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void modificar(Funcionario funcionario) {
             String SQLtextoModificar="update funcionarios set tipoIdentificacion = ?, Identificacion = ?, nombres = ?, apellidos = ?, estadoCivil = ?, genero = ?, direccion = ?, telefono = ?, fechaDeNacimiento = ? WHERE Identificacion = ?";
        try {
            PreparedStatement modificar = con.prepareStatement(SQLtextoModificar);
            
            modificar.setString(1, funcionario.getTipoIdentificacion());
            modificar.setString(2, funcionario.getIdentificacion());
            modificar.setString(3, funcionario.getNombres());
            modificar.setString(4, funcionario.getApellidos());
            modificar.setString(5, funcionario.getEstadoCivil());
            modificar.setString(6, funcionario.getGenero());
            modificar.setString(7, funcionario.getDireccion());
            modificar.setString(8, funcionario.getTelefono());
            modificar.setString(9, funcionario.getFechaDeNacimiento());
            
            modificar.setString(10, funcionario.getIdentificacion());
            
            modificar.executeUpdate();
            
            cc.cerrarConexion();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(Funcionario funcionario) {
            String SQLtextoEliminar="delete from funcionarios WHERE Identificacion = ?";
        try {
            PreparedStatement eliminar = con.prepareStatement(SQLtextoEliminar);
            eliminar.setString(1, funcionario.getIdentificacion());            
            eliminar.executeUpdate();
            
            cc.cerrarConexion();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void buscar(Funcionario funcionario) {
    String SQLtextoBuscar="select * from funcionarios WHERE Identificacion = ?";
        try {
            PreparedStatement buscar = con.prepareStatement(SQLtextoBuscar);
            buscar.setString(1, funcionario.getIdentificacion()); 
            
            ResultSet consulta = buscar.executeQuery();
            
            if (consulta.next()) {
                funcionario.setIdentificacion(consulta.getString("Identificacion"));
                funcionario.setNombres(consulta.getString("nombres"));
                funcionario.setApellidos(consulta.getString("apellidos"));
                funcionario.setEstadoCivil(consulta.getString("estadoCivil"));
                funcionario.setGenero(consulta.getString("genero"));
                funcionario.setDireccion(consulta.getString("direccion"));
                funcionario.setTelefono(consulta.getString("telefono"));
                funcionario.setFechaDeNacimiento(consulta.getString("fechaDeNacimiento"));
                
            }
            cc.cerrarConexion();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
    }
    
}
