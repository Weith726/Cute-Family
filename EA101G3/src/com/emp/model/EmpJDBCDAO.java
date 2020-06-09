package com.emp.model;

import java.util.*;
import java.sql.*;

public class EmpJDBCDAO implements EmpDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "TEAM3";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO EMPLOYEE (empID,empName,empGender,empBirth,empJob,empPhone,empAddress,"
			+ "empAcc,empPwd,empPic,hiredate,quitdate,empStatus) VALUES (emp_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT empID,empName,empGender,to_char(empBirth,'yyyy-mm-dd') empBirth,empJob,empPhone,empAddress,empAcc,"
			+ "empPwd,empPic,to_char(hiredate,'yyyy-mm-dd') hiredate,to_char(quitdate,'yyyy-mm-dd') quitdate,empStatus FROM EMPLOYEE order by empID";

	private static final String GET_ONE_STMT = "SELECT empID,empName,empGender,to_char(empBirth,'yyyy-mm-dd') empBirth,empJob,empPhone,empAddress,empAcc,"
			+ "empPwd,empPic,to_char(hiredate,'yyyy-mm-dd') hiredate,to_char(quitdate,'yyyy-mm-dd') quitdate,empStatus FROM EMPLOYEE where empID = ?";

	private static final String DELETE = "DELETE FROM EMPLOYEE where empID = ?";

	private static final String UPDATE = "UPDATE EMPLOYEE set empName=?,empGender=?,empBirth=?,empJob=?,empPhone=?,empAddress=?,empAcc=?,"
			+ "empPwd=?,empPic=?,hiredate=?,quitdate=?,empStatus=? where empId = ?";

	@Override
	public void insert(EmpVO empVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, empVO.getEmpID());
			pstmt.setString(2, empVO.getEmpName());
			pstmt.setString(3, empVO.getEmpGender());
			pstmt.setDate(4, empVO.getEmpBirth());
			pstmt.setString(5, empVO.getEmpJob());
			pstmt.setString(6, empVO.getEmpPhone());
			pstmt.setString(7, empVO.getEmpAddress());
			pstmt.setString(8, empVO.getEmpAcc());
			pstmt.setString(9, empVO.getEmpPwd());
			pstmt.setBytes(10, empVO.getEmpPic());
			pstmt.setDate(11, empVO.getHiredate());
			pstmt.setDate(12, empVO.getQuitdate());
			pstmt.setInt(13, empVO.getEmpStatus());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(EmpVO empVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, empVO.getEmpName());
			pstmt.setString(2, empVO.getEmpGender());
			pstmt.setDate(3, empVO.getEmpBirth());
			pstmt.setString(4, empVO.getEmpJob());
			pstmt.setString(5, empVO.getEmpPhone());
			pstmt.setString(6, empVO.getEmpAddress());
			pstmt.setString(7, empVO.getEmpAcc());
			pstmt.setString(8, empVO.getEmpPwd());
			pstmt.setBytes(9, empVO.getEmpPic());
			pstmt.setDate(10, empVO.getHiredate());
			pstmt.setDate(11, empVO.getQuitdate());
			pstmt.setInt(12, empVO.getEmpStatus());
			pstmt.setInt(13, empVO.getEmpID());

			pstmt.executeUpdate();
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer empID) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, empID);

			pstmt.executeUpdate();
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public EmpVO findByPrimaryKey(Integer empID) {
		// TODO Auto-generated method stub
		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, empID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				empVO = new EmpVO();
				empVO.setEmpName(rs.getString("empName"));
				empVO.setEmpGender(rs.getString("empGender"));
				empVO.setEmpBirth(rs.getDate("empBirth"));
				empVO.setEmpJob(rs.getString("empJob"));
				empVO.setEmpPhone(rs.getString("empPhone"));
				empVO.setEmpAddress(rs.getString("empAddress"));
				empVO.setEmpAcc(rs.getString("empJob"));
				empVO.setEmpPwd(rs.getString("empPhone"));
				empVO.setEmpPic(rs.getBytes("empPic"));
				empVO.setHiredate(rs.getDate("hiredate"));
				empVO.setQuitdate(rs.getDate("quitdate"));
				empVO.setEmpStatus(rs.getInt("empStatus"));
			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO empVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				empVO = new EmpVO();
				empVO.setEmpID(rs.getInt("empID"));
				empVO.setEmpName(rs.getString("empName"));
				empVO.setEmpGender(rs.getString("empGender"));
				empVO.setEmpBirth(rs.getDate("empBirth"));
				empVO.setEmpJob(rs.getString("empJob"));
				empVO.setEmpPhone(rs.getString("empPhone"));
				empVO.setEmpAddress(rs.getString("empAddress"));
				empVO.setEmpAcc(rs.getString("empJob"));
				empVO.setEmpPwd(rs.getString("empPhone"));
				empVO.setEmpPic(rs.getBytes("empPic"));
				empVO.setHiredate(rs.getDate("hiredate"));
				empVO.setQuitdate(rs.getDate("quitdate"));
				empVO.setEmpStatus(rs.getInt("empStatus"));
				list.add(empVO); // Store the row in the list
			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		EmpJDBCDAO dao = new EmpJDBCDAO();

		// 新增
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("吳永志1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptno(10);
//		dao.insert(empVO1);
//
//		// 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);
//
//		// 刪除
//		dao.delete(7014);
//
//		// 查詢
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		System.out.println(empVO3.getDeptno());
//		System.out.println("---------------------");

		// 查詢
		List<EmpVO> list = dao.getAll();
		for (EmpVO aEmp : list) {
			System.out.print(aEmp.getEmpID() + ",");
			System.out.print(aEmp.getEmpName() + ",");
			System.out.print(aEmp.getEmpGender() + ",");
			System.out.print(aEmp.getEmpBirth() + ",");
			System.out.print(aEmp.getEmpJob() + ",");
			System.out.print(aEmp.getEmpPhone() + ",");
			System.out.print(aEmp.getEmpAddress());
			System.out.println();
		}
	}
}
