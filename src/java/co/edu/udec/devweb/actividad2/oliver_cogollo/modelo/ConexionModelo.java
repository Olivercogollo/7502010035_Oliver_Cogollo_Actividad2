/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udec.devweb.actividad2.oliver_cogollo.modelo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class ConexionModelo {
    
    private static ConexionModelo conexion;
    private EntityManagerFactory fabricaConexion;
    public ConexionModelo ( ) {
        fabricaConexion = Persistence.createEntityManagerFactory("estudiantesPU");
    }
    
    
    public static ConexionModelo getConexionModelo() {
        if (conexion == null) {
            conexion = new ConexionModelo();
        }
            return conexion;
    }
    
    public EntityManagerFactory getEntityManagerFactory(){
        return fabricaConexion;
    }
}
