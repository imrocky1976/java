import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import redis.clients.jedis.Pipeline;

import java.util.List;

public class MyJedis {
    private JedisPool jedisPool;
    private static Logger logger = LogManager.getLogger(MyJedis.class);

    public MyJedis(String hostname, int port) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        jedisPool = new JedisPool(poolConfig, hostname, port);
    }

    public String set(String key, String val) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return null;
        }

        try {
            return jedis.set(key, val);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }

    public String get(String key) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return null;
        }

        try {
            return jedis.get(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }

    public String set(byte[] key, byte[] val) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return null;
        }

        try {
            return jedis.set(key, val);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (jedis != null)
                jedis.close();
        }

        return null;
    }

    public byte[] get(byte[] key) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return null;
        }

        try {
            return jedis.get(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }

    public List<Object> mdel(List<String> keys) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return null;
        }

        Pipeline pipeline = jedis.pipelined();
        try {
            for (String key : keys) {
                pipeline.del(key);
            }
            return pipeline.syncAndReturnAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }

    public void close() {
        if (jedisPool != null)
            jedisPool.close();
    }

    private Jedis getJedis() {
        try {
            return jedisPool.getResource();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


    public static void main(String[] args) {
        String serverName = new String("dp-shihj");
        int port = 6379;
        MyJedis myJedis = new MyJedis(serverName, port);

        String ret = myJedis.set(new String("java"), new String("jedis"));
        System.out.println("set (java, jedis): " + ret);

        ret = myJedis.get(new String("java"));
        System.out.println("get java: " + ret);

        ret = myJedis.get(new String("python"));
        System.out.println("get python: " + ret);

        myJedis.close();

    }
}
