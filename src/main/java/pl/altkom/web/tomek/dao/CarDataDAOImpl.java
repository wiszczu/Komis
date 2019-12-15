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
	        "INSERT INTO samochód(id, marka, model, produkcja, przebieg, pojemnosc) VALUES (?,?,?,?,?,?)");
	
	        pstmt.setInt(1, generateId());
	        pstmt.setString(2, car.getBrand());
	        pstmt.setString(3, car.getModel());
	        pstmt.setInt(4, car.getYearOfProduction());
	        pstmt.setString(5, car.getMileage());
	        pstmt.setString(6, car.getCapacity());

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
	        "SELECT id, marka, model, produkcja, przebieg, pojemnosc FROM samochód");
	
	        ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt(1));
				car.setBrand(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setYearOfProduction(rs.getInt(4));
				car.setMileage(rs.getString(5));
				car.setCapacity(rs.getString(6));
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
