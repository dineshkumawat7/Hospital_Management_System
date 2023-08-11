package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specialist;

public class SpecialistDao {
	private Connection conn;

	public SpecialistDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addSpecialist(String spec) {
		boolean f = false;
		try {

			String qry = "insert into specialist(spec_name) values(?)";
			PreparedStatement pStatement = conn.prepareStatement(qry);
			pStatement.setString(1, spec);

			int i = pStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Specialist> getAllSpecialist() {

		List<Specialist> list = new ArrayList<Specialist>();
		Specialist specialist = null;

		try {
			String sql = "select * from specialist";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();

			while (rs.next()) {
				specialist = new Specialist();
				specialist.setId(rs.getInt(1));
				specialist.setSpecialistName(rs.getString(2));
				list.add(specialist);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int countSpecialist() {
		int count = 0;
		try {
			String sql = "select * from specialist";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next()) {
				count++;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return count;
	}
}
