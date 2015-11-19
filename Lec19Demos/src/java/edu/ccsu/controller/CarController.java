/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.controller;

import edu.ccsu.model.Car;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author cw1491
 */
@ManagedBean
public class CarController {

    @PersistenceUnit(unitName = "Lec19DemosPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;


    public String saveCar() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String targetPage = "error";
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetPage;
    }


}
