package redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import properties.ReadPropertiesUtil;
import properties.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	public static void main(String[] args){
		String host = "127.0.0.1";
		int port = 6379;
		Jedis jedis = new Jedis(host, port);
		System.out.println(jedis.ping());
		System.out.println(jedis.get("username"));
		jedis.set("username", "zhang3");
		jedis.lpush("user", "zhang3");
		jedis.lpush("user", "li4");
		jedis.lpushx("user", "wang5");
		List<String> userList = jedis.lrange("user", 0, 100);
		System.out.println("userlist -->"+userList);
		
		jedis.sadd("user2", "zhang3");
		jedis.sadd("user2","wang5");
		jedis.sadd("user2", "li4");
		Set<String> userList2 = jedis.smembers("user2");
		System.out.println("userList2 -->"+userList2);
		
		jedis.rpush("tk", "hahatk");
		jedis.lpop("tk");
		
		jedis.lset("user", 0, "nothing");
		String filepath = Test.class.getClassLoader().getResource("").getPath()+"redis.properties";
		Map<String,String> map = ReadPropertiesUtil.readByProperties(filepath);
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(Integer.valueOf(map.get("redis.maxIdle")));
		config.setMaxWaitMillis(Integer.valueOf(map.get("redis.maxWaitMillis")));
		config.setMaxTotal(Integer.valueOf(map.get("redis.maxActive")));
		config.setTestOnBorrow(Boolean.valueOf(map.get("redis.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(map.get("redis.testOnReturn")));
		JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);
		Jedis j = jedisPool.getResource();
		j.set("test", "this is test of pool");
		
	}
}
