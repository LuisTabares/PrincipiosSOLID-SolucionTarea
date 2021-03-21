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

import java.util.EnumMap;
import java.util.Map;

/**
 * Fábrica de que utiliza el patrón de diseño Singleton para generar una
 * instancia de la interfaz IParkingCost
 *
 * @author Libardo, Julio
 */
public class ParkingCostFactory {

    /**
     * dictionary that maps the type enum of vechicles with their respective
     * vehicle implementation
     */
    private Map<TypeEnum, IParkingCost> dictionary;

    // Singleton
    private static ParkingCostFactory instance;

    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
        // Si se requie otro vehiculo, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de la la fábrica
     */
    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }

    /**
     * Para un vehiculo determina la clase que se encarga de calcular el costo
     * del parqueo.
     *
     * @param type el tipo de vehiculo
     * @return the implementation class for the kind of vehicle entes as
     * parameter
     */
    public IParkingCost getParkingCost(TypeEnum type) {

        IParkingCost result = null;

        if (dictionary.containsKey(type)) {
            result = dictionary.get(type);
        }

        return result;

    }
}
