/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.controller;

import edu.ccsu.model.Car;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author cw1491
 */
@ManagedBean
public class CarControllerSoln {

    @PersistenceUnit(unitName = "Lec19DemosPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{car}")
    private Car car;

    public String saveCar() {
        String returnValue = "error";
        try {
            userTransaction.begin();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.persist(getCar());
            userTransaction.commit();
            entityManager.close();
            returnValue = "carSaved";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public List getMatchingCars() {
        List<Car> customers = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String selectSQL = "select c from Car c where c.make like :make and c.model like :model";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);
            selectQuery.setParameter("make", car.getMake() + "%");
            selectQuery.setParameter("model", car.getModel() + "%");
            customers = selectQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public String deleteCar() {
        String returnValue = "error";
        try {
            userTransaction.begin();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            car = entityManager.find(Car.class, car.getCarId());
            entityManager.remove(car);
            userTransaction.commit();
            returnValue = "deleteSuccessful";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    /**
     * @return the customer
     */
    public Car getCar() {
        return car;
    }

    /**
     * @param customer the customer to set
     */
    public void setCar(Car car) {
        this.car = car;
    }
    //this managed property will read value from request parameter rebate
    @ManagedProperty(value = "#{param.inital}")
    private String initial;

    public String getInitial() {
        return initial == null ? "" : initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String reset() {
        car.setEmmissionsCheck(false);
        car.setJointOwnership(false);
        return "navigationEx";
    }

    public String remainingChecks() {
        if (car.getNumberOfMiles() > 100000) {
            return "highMileageCarSales";
        }
        if (getInitial().equals("true") && car.getMake().equals("Toyota")) {
            return "rebateEarned";
        }
        // If first car and toyota offer rebate

        String rules = car.specialRules();
        if (rules.equals("jointOwnership")) {
            return "jointOwnershipForm";
        } else if (rules.equals("emissions")) {
            return "emissionsForm";
        }
        // saveCar();
        return "purchaseComplete";
    }
}
