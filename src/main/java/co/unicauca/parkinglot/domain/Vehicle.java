/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.unicauca.parkinglot.domain;

/**
 *
 * @author Luis Tabares
 */
public class Vehicle {

    /**
     *Placa
     */
    private String plate;

    /**
     *Tipo: carro, moto, camion
     */
    private TypeEnum type;
    
    public Vehicle(String plate, TypeEnum type){
        this.plate = plate;
        this.type = type;
    }

    public Vehicle(){
    }
    
    //Getters and Setters

    public String getPlate(){
        return plate;
    }

    public void setPlate(String placa){
        this.plate = placa;
    }

    public TypeEnum getType(){
        return this.type;
    }

    public void setType(TypeEnum type){
        this.type = type;
    }

    public String toString(){
        return "Vehicle{" + "plate=" + this.plate + ", type=" + this.type + '}';
    }
}
