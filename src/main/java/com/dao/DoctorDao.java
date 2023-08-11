package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {
	private Connection conn;

	public DoctorDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerDoctor(Doctor s) {
		boolean f = false;
		try {
			String sql = "insert into doctor(full_name, dob, qualification, specialist, email, mob_no, password)"
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getFullName());
			ps.setString(2, s.getDob());
			ps.setString(3, s.getQualification());
			ps.setString(4, s.getSpecialist());
			ps.setString(5, s.getEmail());
			ps.setString(6, s.getMobNo());
			ps.setString(7, s.getPassword());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor = null;

		try {
			String getAllDoctor = "select * from doctor order by doctor_id desc";
			PreparedStatement ps = conn.prepareStatement(getAllDoctor);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				doctor = new Doctor();
				doctor.setId(resultSet.getInt(1));
				doctor.setFullName(resultSet.getString(2));
				doctor.setDob(resultSet.getString(3));
				doctor.setQualification(resultSet.getString(4));
				doctor.setSpecialist(resultSet.getString(5));
				doctor.setEmail(resultSet.getString(6));
				doctor.setMobNo(resultSet.getString(7));
				doctor.setPassword(resultSet.getString(8));

				list.add(doctor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Doctor getDoctorById(int id) {
		Doctor doctor = null;

		try {
			String getDoctorId = "select * from doctor where doctor_id = ?";
			PreparedStatement ps = conn.prepareStatement(getDoctorId);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				doctor = new Doctor();
				doctor.setId(resultSet.getInt("doctor_id"));
				doctor.setFullName(resultSet.getString("full_name"));
				doctor.setDob(resultSet.getString("dob"));
				doctor.setQualification(resultSet.getString("qualification"));
				doctor.setSpecialist(resultSet.getString("specialist"));
				doctor.setEmail(resultSet.getString("email"));
				doctor.setMobNo(resultSet.getString("mob_no"));
				doctor.setPassword(resultSet.getString("password"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctor;
	}

	public boolean updateDoctor(Doctor s) {
		boolean f = false;
		try {
			String update = "update doctor set full_name = ?, dob = ?, qualification = ?, specialist = ?, email = ?, mob_no = ?, password = ? where doctor_id = ?";
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, s.getFullName());
			ps.setString(2, s.getDob());
			ps.setString(3, s.getQualification());
			ps.setString(4, s.getSpecialist());
			ps.setString(5, s.getEmail());
			ps.setString(6, s.getMobNo());
			ps.setString(7, s.getPassword());
			ps.setInt(8, s.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteDoctor(int id) {
		boolean f = false;
		try {
			String sql = "delete from doctor where doctor_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public Doctor login(String email, String password) {
		Doctor doctor = null;
		try {
			String sql = "select * from doctor where email = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				doctor = new Doctor();
				doctor.setId(resultSet.getInt(1));
				doctor.setFullName(resultSet.getString(2));
				doctor.setDob(resultSet.getString(3));
				doctor.setQualification(resultSet.getString(4));
				doctor.setSpecialist(resultSet.getString(5));
				doctor.setEmail(resultSet.getString(6));
				doctor.setMobNo(resultSet.getString(7));
				doctor.setPassword(resultSet.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctor;
	}

	public int countDoctor() {
		int count = 0;
		try {
			String sql = "select * from doctor";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count++;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return count;
	}

}
