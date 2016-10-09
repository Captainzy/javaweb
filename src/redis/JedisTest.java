package redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

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
		
	}
}
