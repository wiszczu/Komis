package pl.altkom.web.tomek;

import java.util.List;
import javax.sql.DataSource;

public interface ClientDataDAO {
	
	public void saveClientData(Client client, DataSource dataSource) throws Exception;
	public List<Client> readClientsData(DataSource dataSource) throws Exception;
}
