package pl.altkom.web.tomek.dao;

import pl.altkom.web.tomek.Car;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDataDAOImpl implements CarDataDAO {

	public void saveCarData(Car car, DataSource dataSource) throws Exception {
		
        Connection con = null;
        
        try {
	        con = dataSource.getConnection();
	        
	        PreparedStatement pstmt = con.prepareStatement(
	        "INSERT INTO samochód(id, marka, model, produkcja, przebieg) VALUES (?,?,?,?,?)");
	
	        pstmt.setInt(1, generateId());
	        pstmt.setString(2, car.getBrand());
	        pstmt.setString(3, car.getModel());
	        pstmt.setInt(4, car.getYearOfProduction());
	        pstmt.setInt(5, car.getMileage());
	        
	        pstmt.executeUpdate();
	        pstmt.close();
        } finally {
        	if (con != null) {
        		con.close();
        	}
        }
	}
	
	public List<Car> readCarsData(DataSource dataSource) throws Exception {

        Connection conn = null;
        List<Car> cars = new ArrayList<>();
        
        try {
	        conn = dataSource.getConnection();
	        
	        PreparedStatement pstmt = conn.prepareStatement(
	        "SELECT marka, model, produkcja, przebieg FROM samochód");
	
	        ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
				Car car = new Car();
				car.setBrand(rs.getString(1));
				car.setModel(rs.getString(2));
				car.setYearOfProduction(rs.getInt(3));
				car.setMileage(rs.getInt(4));
				cars.add(car);
			}

	        rs.close();
	        pstmt.close();
        } finally {
        	if (conn != null) {
        		conn.close();
        	}
        }
        return cars;
	}

	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}
}
