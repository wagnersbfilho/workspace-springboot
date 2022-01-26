package br.com.wagner.spring.teste;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TesteConexao {

	@Autowired
	public static DataSource dataSource;
	
	public TesteConexao(DataSource dataSource) throws SQLException {
		System.out.println("Database connection valid = " + dataSource.getConnection().isValid(1000));
	}
	
	public static void main(String[] args) {
		try {
			new TesteConexao(dataSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
