package com.doctor.DAO.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.doctor.api.GenericDaoMaster;

public abstract class GenericDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//This method is used to get the data from Generic Dao table
	private GenericDaoMaster getGenericDaoMaster(String SearchKey) {
		
		String sql ="select * from GenericDao where tableKey='"+SearchKey+"'";
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		GenericDaoMaster objGen =  (GenericDaoMaster)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(GenericDaoMaster.class));
		
		return objGen;
	}
	
	//This method is used get maximum id value of patients table.
	public Integer getMaxValue(String SearchKey) {
		
		GenericDaoMaster obj = getGenericDaoMaster(SearchKey);
		String queryString = "SELECT ISNULL ( MAX ("+obj.getNonDisplayColumn()+"),0) FROM "+obj.getTableName();
		Integer maxValue =(Integer) jdbcTemplate.queryForObject(queryString,Integer.class);
		return maxValue;
	}
	
	

}
