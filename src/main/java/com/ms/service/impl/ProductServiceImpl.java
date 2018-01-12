package com.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ms.entity.Product;
import com.ms.repo.ProductRepository;
import com.ms.service.ProductService;

/**
 * @author chenxin
 * @since 2018-01-11
 * @abstract
 */

//在实现类而不是接口上添加注解
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepository;
	
	@Override
	public Product save(Product product) {
		return prodRepository.save(product);
	}

	@Override
	public void deleteByProductId(long id) {
		prodRepository.delete(id);
	}

	@Override
	public Product findByProductId(long id) {
		return prodRepository.findOne(id);
	}

	@Override
	public Page<Product> findByProductName(String name,PageRequest pageRequest) {
		return prodRepository.findByProdName(name,pageRequest);
	}

	@Override
	public List<Product> findByProductCategory(String category) {
		return prodRepository.findByProdCategory(category);
	}

	@Override
	public void deleteAll() {
		prodRepository.deleteAll();
	}

	@Override
	public Iterable<Product> findAll() {
		return prodRepository.findAll();
	}

}
