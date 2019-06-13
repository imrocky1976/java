import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;


public class MyJedisTest {

    @Test
    public void testMyJedisGetSet() {
        MyJedis myJedis = new MyJedis("dp-shihj", 6379);

        // set java jedis
        String ret = myJedis.set("java", "jedis");
        Assert.assertEquals("OK", ret);

        ret = myJedis.get("java");
        Assert.assertEquals("jedis", ret);

        //set python redis-py
        Assert.assertEquals("OK", myJedis.set("python", "redis-py"));

        ret = myJedis.get("c++");
        Assert.assertEquals(null, ret);

        //pipeline
        ArrayList<String> keys = new ArrayList<>();
        keys.add("java");
        keys.add("python");
        List<Object> resultList = myJedis.mdel(keys);
        Assert.assertEquals(2, resultList.size());
        for (Object o : resultList) {
            Assert.assertEquals("1", o.toString());
        }

        myJedis.close();
    }
}
