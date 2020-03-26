package com.heima.regies;

import com.heimai.RedisUtils.RidesUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class rediesdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
	/*	JedisPoolConfig  poolConfig=new JedisPoolConfig();
		poolConfig.setMaxIdle(30);
		poolConfig.setMinIdle(10);
		poolConfig.setMaxTotal(100);
		JedisPool pool=new JedisPool(poolConfig, "localhost", 6379);
		Jedis jedis=pool.getResource();*/
		Jedis jedis=RidesUtils.getjedis();
		jedis.set("kliu", "mimi");
		System.out.println(jedis.get("kliu"));
		
	}

}
