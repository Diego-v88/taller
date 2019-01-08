/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import controllers.Facade;
import dao.DAOException;
import entities.Guard;
import entities.Turn;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author arguser
 */
public class EnviarCorreoTest {
    
    public Facade fachada = new Facade();
    
    public EnviarCorreoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of EnviarCorreo method, of class EnviarCorreo.
     */
    @Test
    public void testEnviarCorreo() {
        System.out.println("EnviarCorreo");
        Guard guard = new Guard();
        List<Turn> turn = new ArrayList<>();
        try {
            guard = fachada.getGuardById(Integer.parseInt("3"));
            turn = fachada.getTurnsByGuard(guard);
        } catch (DAOException ex) {
            Logger.getLogger(EnviarCorreoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        SendMail instance = new SendMail();
        instance.SendMail(guard, turn);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
