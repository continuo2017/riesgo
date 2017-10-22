/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkMenu;

/**
 *
 * @author Erick
 */
public class admin {
     private String usuario;
    private String contrasena;




   private clsConn cnn=new clsConn();
    
      public String insertar3(){
        if ((verificau(usuario)==true)&&(verificac(contrasena)==true)){
            return "-1";
        }

      return "1";
    }
      
    public boolean verificau(String key) {
        String sql = "SELECT * From usuario where nombreusuario='" + key.toString() + "'";
        if (getCnn().verificar(sql) == 1) {
            return true;
        }
        return false;
    }

    public boolean verificac(String key) {
        String sql = "SELECT * From usuario where contrasena='" + key.toString() + "'";
        if (getCnn().verificar(sql) == 1) {
            return true;
        }
        return false;
    }

    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasena
     */
    public String getcontrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public clsConn getCnn() {
        return cnn;
    }
}
