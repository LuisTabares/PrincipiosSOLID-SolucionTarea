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

import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;

/**
 * Inplementation of IParkingCost that calculates the cost specifically for a
 * car
 *
 * @author Luis Tabares
 */
public class CarParkingCost implements IParkingCost {

    /**
     * Method that calculates the parking cost for a car
     *
     * @param veh the parked vehicle
     * @param input the date in which the vehicle enter the parking lot
     * @param output the date in which the vehicle left the parking lot
     * @return the cost of parking
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long minutes = Utilities.getInstance().minutesBetween(input, output);
        long cost = 0;
        if (minutes <= 60) {
            cost = 2000;
        } else if (minutes > 60) {
            minutes -= 60;
            cost += 2000;
            cost += 1000 * minutes / 60;
            cost = Utilities.getInstance().roundHundreds(cost);
        }

        return cost;
    }

}
