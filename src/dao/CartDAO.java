package dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dto.CartVO;
import dto.MemberVO;
import dto.ProductVO;
import oracle.jdbc.internal.OracleTypes;
import utill.DBManager;

public class CartDAO {
	private CartDAO() {
	}

	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
		return instance;
	}
	
	public ProductVO getProductInCart(int prod_id){
		ProductVO productVO = new ProductVO();

		Connection conn = null;
		CallableStatement ctmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ctmt = conn.prepareCall("{?= call product_list_package.fn_detail_prod(?)}");
			ctmt.registerOutParameter(1, OracleTypes.ARRAY, "PROD_TABLE");
			ctmt.setInt(2, prod_id);
			ctmt.execute();
			Array ts = ctmt.getArray(1);
			Object[] objArr = (Object[]) ts.getArray();

			rs = ts.getResultSet();

			for (int i = 0; i < objArr.length; i++) {
				Object[] attrs = null;
				Struct bean = (Struct) objArr[i];
				attrs = bean.getAttributes();

				List<Object> arr = Arrays.asList(attrs);
				productVO.setId(Integer.parseInt(arr.get(0).toString()));
				productVO.setProdCategory(Integer.parseInt(arr.get(1).toString()));
				productVO.setProdName(String.valueOf(arr.get(2)));
				productVO.setProdDetail(String.valueOf(arr.get(3)));
				productVO.setPrice(Integer.parseInt(arr.get(4).toString()));
				productVO.setDiscount(Integer.parseInt(arr.get(5).toString()));
				productVO.setPackageType(String.valueOf(arr.get(6)));
				productVO.setOrigin(String.valueOf(arr.get(7)));
				productVO.setProdImg(String.valueOf(arr.get(8)));
			}
		} catch (SQLException e) {
			System.err.format("SQL State: %s\\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ctmt, rs);
		}
		return productVO;
	}
		

	public ArrayList<CartVO> listCart(String email) {
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();

		Connection conn = null;
		CallableStatement ctmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			ctmt = conn.prepareCall("{ ? = call cart_p.FN_GET_CART_LIST_INFO(?) }");

			ctmt.registerOutParameter(1, OracleTypes.ARRAY, "CART_TABLE");
			ctmt.setString(2, email);
			ctmt.execute();

			Array ts = ctmt.getArray(1);
			Object[] objArr = (Object[]) ts.getArray();

			rs = ts.getResultSet();

			for (int i = 0; i < objArr.length; i++) {
				Object[] attrs = null;
				Struct bean = (Struct) objArr[i];
				attrs = bean.getAttributes();
				CartVO cart = new CartVO();

				List<Object> arr = Arrays.asList(attrs);
				cart.setId(Integer.parseInt(arr.get(0).toString()));
				cart.setProd_id(Integer.parseInt(arr.get(1).toString()));
				cart.setEmail(String.valueOf(arr.get(2)));
				cart.setQty(Integer.parseInt(arr.get(3).toString()));
				cart.setUseyn(String.valueOf(arr.get(4)));
				cartList.add(cart);
			}

			for (CartVO c : cartList) {
				System.out.println(c.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ctmt, rs);
		}
		return cartList;
	}

}
