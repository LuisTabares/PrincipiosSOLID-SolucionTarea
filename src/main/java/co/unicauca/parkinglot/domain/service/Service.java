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
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Tabares
 */
public class Service {

    /**
     * An interface or abstraction of the vehicle repository
     */
    private IVehicleRepository repository;

    /**
     * Dependency injection on the constructor, to create a non concrete
     * repository
     *
     * @param repository the abstract repository
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    /**
     * Method that calls the method of an specific class to calculate the cost
     *
     * @param vehicle the vehicle
     * @param input the input date of the vehicle
     * @param output the output date of the vehicle
     * @return
     */
    public long calculateParkingCost(Vehicle vehicle, LocalDateTime input, LocalDateTime output) {
        if (vehicle == null || input == null || output == null) {
            return -1;
        }

        IParkingCost parkingCost = ParkingCostFactory.getInstance().getParkingCost(vehicle.getType());
        long cost = parkingCost.calculateCost(vehicle, input, output);
        return cost;
    }

    /**
     * Method that save the vehicle on a db through a repository
     *
     * @param vehicle
     * @return
     */
    public boolean saveVehicle(Vehicle vehicle) {
        if (vehicle == null || vehicle.getPlate().isEmpty()) {
            return false;
        }

        repository.saveVehicle(vehicle);
        return true;
    }

    /**
     * Method that lists all the vehicles on the db
     *
     * @return the vehicles on the db
     */
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.listVehicles();

        return vehicles;
    }
}
