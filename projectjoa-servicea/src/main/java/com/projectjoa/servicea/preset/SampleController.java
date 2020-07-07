/**
 * 
 */
package com.projectjoa.servicea.preset;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chcho
 *
 */

@Controller
public class SampleController {

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public ResponseEntity<Map<String,String>> sample(){
		
		ResponseEntity<Map<String,String>> response = null;
		
		Map<String,String> resMap = new HashMap<String,String>();
		resMap.put("type","First Eureka client!!!");
		resMap.put("message","Spring Cloud is awesome!!!");
		
		response = new ResponseEntity<Map<String,String>>(resMap, HttpStatus.OK);
		
		return response;
	}
}
