package pl.altkom.web.tomek.dao;

import pl.altkom.web.tomek.Client;

import java.util.List;
import javax.sql.DataSource;

public interface ClientDataDAO {
	
	public void saveClientData(Client client, DataSource dataSource) throws Exception;
	public List<Client> readClientsData(DataSource dataSource) throws Exception;
	public void removeClient(String name, String surname, DataSource dataSource) throws Exception;
	public void removeClient(int id, DataSource dataSource) throws Exception;
	public void updateClient(int id, DataSource dataSource) throws Exception;
}
