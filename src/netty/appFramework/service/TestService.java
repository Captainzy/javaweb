package netty.appFramework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int testQueryCount(){
		String sql = "SELECT COUNT(*) FROM tb_company";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
