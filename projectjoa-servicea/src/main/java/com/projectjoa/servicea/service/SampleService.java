/**
 * 
 */
package com.projectjoa.servicea.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectjoa.servicea.mapperImpl.SampleMapper;

/**
 * @author chcho
 *
 */
@Service("sampleService")
public class SampleService {

	@Autowired
	private SampleMapper sampleMapper;
	
	public List<HashMap<String,String>> selectEmployees(){
		return sampleMapper.selectEmployees();
	}
}
