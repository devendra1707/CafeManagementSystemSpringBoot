package com.cms.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cms.rest.DashbordRest;
import com.cms.service.DashboardService;

@RestController
public class DashboardRestImpl implements DashbordRest {

	@Autowired
	DashboardService dashboardService;
	
	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
	
		return dashboardService.getCount();
	}

}
