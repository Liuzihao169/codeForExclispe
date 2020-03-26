package com.itheima.springmvc.conversion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConveter implements Converter<String , Date >{

	@Override
	public Date convert(String resource) {
		// TODO Auto-generated method stub
		DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH-mm:ss");
		try {
		return format.parse(resource);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


}
