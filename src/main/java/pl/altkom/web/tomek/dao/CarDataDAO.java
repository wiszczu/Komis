package pl.altkom.web.tomek.dao;

import pl.altkom.web.tomek.Car;

import javax.sql.DataSource;
import java.util.List;

public interface CarDataDAO {
	
	public void saveCarData(Car car, DataSource dataSource) throws Exception;
	public List<Car> readCarsData(DataSource dataSource) throws Exception;
}
