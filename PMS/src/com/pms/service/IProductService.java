package com.pms.service;

import java.util.List;

import com.pms.pojo.ProductPojo;

public interface IProductService {

	public int addProd(ProductPojo prod);

	public int updateProd(ProductPojo prod);

	public int deleteProdByNo(int prodNo);

	public ProductPojo getProdByNo(int prodNo);

	public List<ProductPojo> getAll();
}