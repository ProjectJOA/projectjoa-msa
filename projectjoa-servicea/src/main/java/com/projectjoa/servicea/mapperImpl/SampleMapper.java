/**
 * 
 */
package com.projectjoa.servicea.mapperImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author chcho
 *
 */
@Mapper
@Repository
public interface SampleMapper {

	public List<HashMap<String,String>> selectEmployees();
}
