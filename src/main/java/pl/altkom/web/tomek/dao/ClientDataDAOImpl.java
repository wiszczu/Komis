package pl.altkom.web.tomek.dao;

import pl.altkom.web.tomek.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;

public class ClientDataDAOImpl implements ClientDataDAO {

	public void saveClientData(Client cl, DataSource dataSource) throws Exception {
		
        Connection con = null;
        
        try {
	        con = dataSource.getConnection();
	        
	        PreparedStatement pstmt = con.prepareStatement(
	        "INSERT INTO klient(id,imie,nazwisko,region,wiek,mezczyzna) VALUES (?,?,?,?,?,?)");
	
	        pstmt.setInt(1, generateId());
	        pstmt.setString(2, cl.getName());
	        pstmt.setString(3, cl.getSurname());
	        pstmt.setString(4, cl.getRegion());
	        pstmt.setInt(5, cl.getAge());
	        pstmt.setInt(6, cl.getGender().equals("male") ? 1 : 0);
	        
	        pstmt.executeUpdate();
	        pstmt.close();
        } finally {
        	if (con != null) {
        		con.close();
        	}
        }
	}
	
	public List<Client> readClientsData(DataSource dataSource) throws Exception {

        Connection conn = null;
        List<Client> clients = new ArrayList<>();
        
        try {
	        conn = dataSource.getConnection();
	        
	        PreparedStatement pstmt = conn.prepareStatement(
	        "SELECT id, imie, nazwisko, region, wiek, mezczyzna FROM klient");
	
	        ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
				Client cl = new Client();
				cl.setId(rs.getInt(1));
				cl.setName(rs.getString(2));
				cl.setSurname(rs.getString(3));
				cl.setRegion(rs.getString(4));
				cl.setAge(rs.getInt(5));
				if (rs.getInt(6) == 1) {
					cl.setGender("male");
				} else {
					cl.setGender("female");
				}
				clients.add(cl);
			}

	        rs.close();
	        pstmt.close();
        } finally {
        	if (conn != null) {
        		conn.close();
        	}
        }
        return clients;
	}

	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}

	@Override
	public void removeClient(String name, String surname, DataSource dataSource) throws Exception {

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.createStatement()
					.executeUpdate("DELETE FROM klient WHERE " +
							"imie = '" + name + "' AND nazwisko = '" + surname + "';");
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public void removeClient(int id, DataSource dataSource) throws Exception {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.createStatement()
					.executeUpdate("DELETE FROM klient WHERE id = " + id + ";");
		} finally {
			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public void updateClient(int id, DataSource dataSource) throws Exception {

	}
}
