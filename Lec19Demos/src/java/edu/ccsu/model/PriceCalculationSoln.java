/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

/**
 *
 * @author cw1491
 */
@ManagedBean
public class PriceCalculationSoln implements Serializable{
    private Double price1 = 0.0;
    private Double price2 = 0.0;
    private Double tax = 0.12;
    private Double priceWithTax = 0.0;
    
    public PriceCalculationSoln(){
    }

    
    public Double getTotal(){
        double totalPrice = price1 + price2;
        return totalPrice;
    }
    
    public Double getTaxAmount(){
        return getTotal()*tax;
    }

    /**
     * @return the price1
     */
    public Double getPrice1() {
        return price1;
    }

    /**
     * @param price1 the price1 to set
     */
    public void setPrice1(Double price1) {
        this.price1 = price1;
    }

    /**
     * @return the price2
     */
    public Double getPrice2() {
        return price2;
    }

    /**
     * @param price2 the price2 to set
     */
    public void setPrice2(Double price2) {
        this.price2 = price2;
    }

    /**
     * @return the tax
     */
    public Double getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(Double tax) {
        this.tax = tax;
    }
    
    
    
    public void calcTotalWithTax(ActionEvent event){
        priceWithTax = getTotal() *(1+tax);
    }

    /**
     * @return the priceWithTax
     */
    public Double getPriceWithTax() {
        return priceWithTax;
    }

    /**
     * @param priceWithTax the priceWithTax to set
     */
    public void setPriceWithTax(Double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }
}
