package com.cms.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cms.doa.BillDAO;
import com.cms.doa.CategoryDAO;
import com.cms.doa.ProductDAO;
import com.cms.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	BillDAO billDAO;

	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
		Map<String, Object> map = new HashMap<>();
		map.put("categort", categoryDAO.count());
		map.put("product", productDAO.count());
		map.put("bill", billDAO.count());

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
