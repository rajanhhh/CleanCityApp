package com.clean.springbootstarter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.clean.springbootstarter.beans.UserInfo;

@Service
public class cleanCityService {
	
	@Autowired
	  JdbcTemplate jdbcTemplate;
	
	/**
	 * fetch cleancity data into table.
	 */
		
		public List<UserInfo> fetchAllUserInfo() {
			String sql = "SELECT *"+
					"FROM cleancity_records";
			
			
			
			List<UserInfo> userRecords = jdbcTemplate.query(sql,
					(resultSet, rowNum) -> new UserInfo(resultSet.getString("name"),
														resultSet.getString("address"),
														resultSet.getString("pin"),
														resultSet.getString("phone_number"),
														resultSet.getBinaryStream("photo")
														));
			
			return userRecords;
		}
		
		/**
		 * insert cleancity data into table.
		 */
			
			public int insertUserInfo(UserInfo userInfo) {
				
				
				String sql = "INSERT INTO cleancity_records (name, address, pin, phone_number, photo) "
						+ "VALUES (?, ?, ?, ?, ?)";
				int queryStatus=jdbcTemplate.update(sql,userInfo.getName(),userInfo.getAddress(),userInfo.getPin(),userInfo.getPhone_number(),userInfo.getPhoto());
				
				System.out.println("quer status is "+queryStatus);
				
				return queryStatus;
				
			}
		public List<UserInfo> fetchUserInfoByPin(String pin ) {
			
			
			String sql = "SELECT name,address,pin,phone_number FROM cleancity_records"+" WHERE pin ="+pin;
			
			
			
			List<UserInfo> userRecords = jdbcTemplate.query(sql,
					(resultSet, rowNum) -> new UserInfo(resultSet.getString("name"),
														resultSet.getString("address"),
														resultSet.getString("pin"),
														resultSet.getString("phone_number")
														
														));
			
			return userRecords;
		}


public List<UserInfo> fetchUserInfoWithImage(String pin ) {
			
			
			String sql = "SELECT * FROM cleancity_records"+" WHERE pin ="+pin;
			
			
			
			List<UserInfo> userRecords = jdbcTemplate.query(sql,
					(resultSet, rowNum) -> new UserInfo(resultSet.getString("name"),
														resultSet.getString("address"),
														resultSet.getString("pin"),
														resultSet.getString("phone_number"),
														resultSet.getBinaryStream("photo")
														));
			
			return userRecords;
		}
}
