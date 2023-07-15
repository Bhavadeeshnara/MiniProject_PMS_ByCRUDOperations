package com.pms.dao;

import com.pms.util.*;
import com.pms.pojo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	Connection conn = DBUtil.getDBConnection();

	public int addProd(ProductPojo prod) {

		String insertQuery = "insert into Product values(?,?,?,?)";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);

			pstmt.setInt(1, prod.getPno());
			pstmt.setString(2, prod.getPname());
			pstmt.setDouble(3, prod.getPrice());
			pstmt.setString(4, prod.getDom());
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public int updateProd(ProductPojo prod) {

		String updateQuery = "update Product set pname =? , price =? ,dom=? where pno = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);

			pstmt.setString(1, prod.getPname());
			pstmt.setDouble(2, prod.getPrice());
			pstmt.setInt(4, prod.getPno());
			pstmt.setString(3, prod.getDom());
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public ProductPojo getProdByNo(int prodNo) {

		String selectQuery = "select * from Product where pno = ?";

		ProductPojo prod = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);

			pstmt.setInt(1, prodNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				double price = rs.getDouble("price");
				String dom1 = rs.getString("dom");
				prod = new ProductPojo();
				prod.setPno(pno);
				prod.setPname(pname);
				prod.setPrice(price);
				prod.setDom(dom1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prod;
	}

	public int deleteProdByNo(int prodNo) {

		// delete from dept where dno = ?;

		String deleteQuery = "delete from Product where pno = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);

			pstmt.setInt(1, prodNo);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public List<ProductPojo> getAll() {

		String selectAllQuery = "select * from Product";

		List<ProductPojo> list = new ArrayList<ProductPojo>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				Double price = rs.getDouble("price");
				String dom = rs.getString("dom");
				ProductPojo prod = new ProductPojo();
				list.add(prod);

				prod.setPno(pno);
				prod.setPname(pname);
				prod.setPrice(price);
				prod.setDom(dom);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}