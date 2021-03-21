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

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of IProductRepository that connects with a sqlite db
 *
 * @author Luis Tabares
 */
public class VehicleRepository implements IVehicleRepository {

    /**
     * Connection instance
     */
    private Connection conn;

    /**
     * Default constructor that call a method to initialize the database
     */
    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Method that saves a vehicle on the db
     *
     * @param vehicle to be saved od the db
     * @return if the vehicle could be saved or not
     */
    @Override
    public boolean saveVehicle(Vehicle vehicle) {
        try {
            if (vehicle == null || vehicle.getPlate().isEmpty()) {
                return false;
            }

            String sql = "INSERT INTO Vehicle ( Plate, Type ) "
                    + "VALUES ( ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vehicle.getPlate());
            pstmt.setString(2, vehicle.getType().toString());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * Method that list all the vehicles on the db
     *
     * @return the vehicles on the db
     */
    @Override
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            String sql = "SELECT Plate, Type From Vehicle";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("Plate"));
                newVehicle.setType(TypeEnum.valueOf(rs.getString("Type")));

                vehicles.add(newVehicle);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vehicles;
    }

    /**
     * Methot that creates the sqlite db on memory
     */
    private void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "     Plate text PRIMARY KEY,\n"
                + "     Type text not null\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method that initializes the connection instance on memory
     */
    private void connect() {
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method that closes the connection instance
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
