/**
 * 
 */
package com.projectjoa.servicea.preset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectjoa.servicea.service.SampleService;

/**
 * @author chcho
 *
 */

@RestController
public class SampleController {

	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="/test", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> sample(){
		
		List<HashMap<String,String>> list = sampleService.selectEmployees();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
