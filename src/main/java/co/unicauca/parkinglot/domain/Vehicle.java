/*
 * Copyright (C) 2021 Luis Tabares
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package co.unicauca.parkinglot.domain;

/**
 *
 * @author Luis Tabares
 */
public class Vehicle {

    /**
     * Placa
     */
    private String plate;

    /**
     * Tipo: carro, moto, camion
     */
    private TypeEnum type;

    /**
     * Constructor parametrizado
     *
     * @param plate placa del vehiculo
     * @param tipo tipo de vehiculo
     */
    public Vehicle(String plate, TypeEnum tipo) {
        this.plate = plate;
        this.type = tipo;
    }

    /**
     * Constructor por defecto
     */
    public Vehicle() {
    }

    //Getters and Setters
    /**
     * Metodo getter
     *
     * @return la placa del vehiculo
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Metodo setter
     *
     * @param placa cadena que se asigna como placa del vehiculo
     */
    public void setPlate(String placa) {
        this.plate = placa;
    }

    /**
     * Metodo getter
     *
     * @return el tipo del vehiculo
     */
    public TypeEnum getType() {
        return this.type;
    }

    /**
     * Metodo setter
     *
     * @param type parametro TypeEnum que se asigna como tipo de vehiculo
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * Metodo toString()
     *
     * @return cadena con los datos del vehiculo
     */
    public String toString() {
        return "Vehicle{" + "plate=" + this.plate + ", type=" + this.type + '}';
    }
}
