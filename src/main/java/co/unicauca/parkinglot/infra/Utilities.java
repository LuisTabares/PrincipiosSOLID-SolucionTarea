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
package co.unicauca.parkinglot.infra;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Singleton class with utilities
 *
 * @author Luis Tabares
 */
public class Utilities {

    /**
     * Singleton instance
     */
    private static Utilities instance;

    /**
     * Default constructor
     */
    private Utilities() {

    }

    /**
     * Method to get the only singleton instance
     *
     * @return
     */
    public static Utilities getInstance() {
        if (instance == null) {
            instance = new Utilities();
        }
        return instance;
    }

    /**
     * Method used to round a number to the nearest hundred
     *
     * @param cost the value to be rounded
     * @return the rounded value
     */
    public long roundHundreds(long cost) {
        return ((cost + 99) / 100) * 100;
    }

    /**
     * Method that calculate the minutes between two LocalDateTime
     *
     * @param input the LocalDateTime of input vehicle to the parking lot
     * @param output the LocalDateTime of the vehicle ouput from the parking lot
     * @return the minutes bewteen the two dates
     */
    public long minutesBetween(LocalDateTime input, LocalDateTime output) {
        long minutes = Duration.between(input, output).toMinutes();
        return minutes;
    }

    /**
     * Method to get a random number to play the lottery
     *
     * @return a number as a ticket for the lottery
     */
    public int getLotteryTicket() {
        int ticket = (int) (Math.random() * (1000 - 1)) + 1;
        return ticket;
    }

    /**
     * Method to play the lottery
     *
     * @param ticket the number to play the lottery
     * @return if the ticket is winner or not
     */
    public boolean playLottery(int ticket) {
        boolean winner = false;
        int randomNumber = (int) (Math.random() * (1000 - 1)) + 1;
        if (ticket == randomNumber) {
            winner = true;
        }
        return winner;
    }
}
