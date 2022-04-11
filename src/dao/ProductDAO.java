package dao;

import java.sql.*;
import java.util.ArrayList;

import utill.DBManager;
import vo.CategoryVO;
import vo.ProductVO;

public class ProductDAO {
	private ProductDAO() {}
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
}
