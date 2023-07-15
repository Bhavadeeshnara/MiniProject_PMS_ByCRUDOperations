package com.pms.service;

import java.util.List;
import com.pms.dao.ProductDAO;
import com.pms.pojo.ProductPojo;

public class ProductServiceImp implements IProductService {
	private ProductDAO dao = new ProductDAO();

	@Override
	public int addProd(ProductPojo prod) {
		// TODO Auto-generated method stub
		return dao.addProd(prod);
	}

	@Override
	public int updateProd(ProductPojo prod) {
		// TODO Auto-generated method stub
		return dao.updateProd(prod);
	}

	@Override
	public int deleteProdByNo(int prodNo) {
		// TODO Auto-generated method stub
		return dao.deleteProdByNo(prodNo);
	}

	@Override
	public ProductPojo getProdByNo(int prodNo) {
		// TODO Auto-generated method stub
		return dao.getProdByNo(prodNo);
	}

	@Override
	public List<ProductPojo> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public static boolean dataInputValidation(ProductPojo prod) {
		boolean flag = false;
		if (prod.getPno() > 9 && prod.getPname().length() >= 4 && prod.getPrice() > 2 && prod.getDom() != null) {
			flag = true;

		}
		return flag;
	}

}