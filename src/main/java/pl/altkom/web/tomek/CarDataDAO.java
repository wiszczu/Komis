package pl.altkom.web.tomek;

import javax.sql.DataSource;
import java.util.List;

public interface CarDataDAO {
	
	public void saveCarData(Car car, DataSource dataSource) throws Exception;
	public List<Car> readCarsData(DataSource dataSource) throws Exception;
}
