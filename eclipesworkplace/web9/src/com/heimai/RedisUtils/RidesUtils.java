package com.heimai.RedisUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RidesUtils {
	private static JedisPool pool=null;
	
	//静态代码块就只需要加载一次就可以
	static{
		InputStream in = RidesUtils.class.getClassLoader().getResourceAsStream("redis.propreties");
		Properties pro=new Properties();
		try {
			JedisPoolConfig  poolConfig=new JedisPoolConfig();
			pro.load(in);
		poolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("MaxIdle")));
		poolConfig.setMinIdle(Integer.parseInt(pro.getProperty("MinIdle")));
		poolConfig.setMinIdle(Integer.parseInt(pro.getProperty("MaxTotal")));
		pool=new JedisPool(poolConfig, pro.getProperty("url"), Integer.parseInt(pro.getProperty("prot")));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
  public static Jedis getjedis(){
	return pool.getResource();
	  
  }
}
