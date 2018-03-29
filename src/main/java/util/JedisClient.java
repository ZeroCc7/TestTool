package util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;


public class JedisClient {
	private static JedisClient instance;
	private static JedisPool pool;
	private static JedisPool reportPool;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("redis");
		if (bundle == null) {
			throw new IllegalArgumentException(
					"[redis.properties] is not found!");
		}

		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(Integer.valueOf(bundle
				.getString("redis.pool.maxIdle")));
		config.setTestOnBorrow(Boolean.valueOf(bundle
				.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle
				.getString("redis.pool.testOnReturn")));
		pool = new JedisPool(config, bundle.getString("redis.ip"),
				Integer.valueOf(bundle.getString("redis.port")));
		reportPool= new JedisPool(config, bundle.getString("report.ip"),
				Integer.valueOf(bundle.getString("report.port")));
	}

	public void lpushMo(String s){
		Jedis jedis = reportPool.getResource();
		String identifier = "mo:queue:" + 1099;
		jedis.lpush(identifier, s);
		reportPool.returnResource(jedis);
	}
}
