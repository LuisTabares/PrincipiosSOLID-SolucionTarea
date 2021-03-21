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
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 * Interface of the repository in charge of manage the db for the vehicle
 *
 * @author Luis Tabares
 */
public interface IVehicleRepository {

    /**
     * Abstact method to save the vehicle on a db
     *
     * @param vehicle to be saved
     * @return if the vehicle was saved or not
     */
    boolean saveVehicle(Vehicle vehicle);

    /**
     * Abstact mehtod to list the vehicles on a db
     *
     * @return the vehicles on the db
     */
    List<Vehicle> listVehicles();
}
