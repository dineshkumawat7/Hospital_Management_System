package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;

public class AppointmentDao {

	private Connection conn;

	public AppointmentDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addAppointment(Appointment ap) {
		boolean f = false;
		try {

			String sql = "insert into appointment(user_id, full_name, gender, age, appointment_date, email, phone, disease, doctor_id, address, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ap.getUserId());
			ps.setString(2, ap.getFullName());
			ps.setString(3, ap.getGender());
			ps.setString(4, ap.getAge());
			ps.setString(5, ap.getAppoinDate());
			ps.setString(6, ap.getEmail());
			ps.setString(7, ap.getPhNo());
			ps.setString(8, ap.getDiseases());
			ps.setInt(9, ap.getDoctorId());
			ps.setString(10, ap.getAddress());
			ps.setString(11, ap.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Appointment> getAllAppointmentByUser(int userId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment appointment = null;
		try {
			String sql = "select * from appointment where user_id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				appointment = new Appointment();

				appointment.setId(rs.getInt("id"));
				appointment.setUserId(rs.getInt("user_id"));
				appointment.setFullName(rs.getString("full_name"));
				appointment.setGender(rs.getString("gender"));
				appointment.setAge(rs.getString("age"));
				appointment.setAppoinDate(rs.getString("appointment_date"));
				appointment.setEmail(rs.getString("email"));
				appointment.setPhNo(rs.getString("phone"));
				appointment.setDiseases(rs.getString("disease"));
				appointment.setDoctorId(rs.getInt("doctor_id"));
				appointment.setAddress(rs.getString("address"));
				appointment.setStatus(rs.getString("status"));
				list.add(appointment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Appointment> getAllAppointmentByDoctorLogin(int doctor_id) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment appointment = null;
		try {
			String sql = "select * from appointment where doctor_id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, doctor_id);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				appointment = new Appointment();

				appointment.setId(rs.getInt("id"));
				appointment.setUserId(rs.getInt("user_id"));
				appointment.setFullName(rs.getString("full_name"));
				appointment.setGender(rs.getString("gender"));
				appointment.setAge(rs.getString("age"));
				appointment.setAppoinDate(rs.getString("appointment_date"));
				appointment.setEmail(rs.getString("email"));
				appointment.setPhNo(rs.getString("phone"));
				appointment.setDiseases(rs.getString("disease"));
				appointment.setDoctorId(rs.getInt("doctor_id"));
				appointment.setAddress(rs.getString("address"));
				appointment.setStatus(rs.getString("status"));
				list.add(appointment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Appointment getAllAppointmentById(int id) {
		Appointment appointment = null;
		try {
			String sql = "select * from appointment where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				appointment = new Appointment();

				appointment.setId(rs.getInt("id"));
				appointment.setUserId(rs.getInt("user_id"));
				appointment.setFullName(rs.getString("full_name"));
				appointment.setGender(rs.getString("gender"));
				appointment.setAge(rs.getString("age"));
				appointment.setAppoinDate(rs.getString("appointment_date"));
				appointment.setEmail(rs.getString("email"));
				appointment.setPhNo(rs.getString("phone"));
				appointment.setDiseases(rs.getString("disease"));
				appointment.setDoctorId(rs.getInt("doctor_id"));
				appointment.setAddress(rs.getString("address"));
				appointment.setStatus(rs.getString("status"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointment;
	}

	public boolean updateCommentStatus(int id, int doctorId, String comment) {
		boolean f = false;
		try {
			String sql = "update appointment set status = ? where id = ? and doctor_id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, comment);
			preparedStatement.setInt(2, id);
			preparedStatement.setInt(3, doctorId);
			int executeUpdate = preparedStatement.executeUpdate();
			if (executeUpdate == 1) {
				f = true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return f;
	}

	public int countAppointment() {
		int count = 0;
		try {
			String sql = "select * from appointment";
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

	public int countDoctorByAppointment(int id, int doctor_id) {
		int count = 0;
		try {
			String sql = "select * from appointment where id = ? and doctor_id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, doctor_id);
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
