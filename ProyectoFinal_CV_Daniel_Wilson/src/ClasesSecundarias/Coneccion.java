/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesSecundarias;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USER-11
 */


/**
 *
 * @author JoséDaniel
 */
public class Coneccion {

    private Connection conexion;

    public static void main(String[] args) {
        Coneccion obconeccion = new Coneccion();
        obconeccion.Conectar();
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Coneccion Conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
            conexion = DriverManager.getConnection(BaseDeDatos, "PROYECTOWD", "PROYECTOWD123");
            if (conexion != null) {
                System.out.println("Conexion exitosa a registro");
            } else {
                System.out.println("Conexion fallida");
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return this;
    }

}
