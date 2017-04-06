package com.example.service;

import com.example.RedisKey;
import com.example.model.Girl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * GirlService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>四月 4, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll() throws Exception {
        List<Girl> girls = girlService.findAll();
        Assert.assertEquals(22,girls.size());
    }

    /**
     * Method: save(Girl girl)
     */
    @Test
    public void testSave() throws Exception {
        Girl girl = new Girl();
        girl.setAge(18);
        girl.setAmount(10D);
        girl.setCupSize("S");
        girlService.save(girl);

    }
    /**
     * Method: save(Girl girl)
     */
    @Test(expected = Exception.class)
    public void testFailSave() throws Exception {
        Girl girl = new Girl();
        girl.setAge(17);
        girl.setAmount(10D);
        girl.setCupSize("S");
        girlService.save(girl);

    }

    /**
     * Method: findOne(Girl girl)
     */
    @Test
    public void testFindOne() throws Exception {
        Girl girl = girlService.findOne(1);
        Assert.assertEquals(new Integer(18), girl.getAge());
    }
    @Test
    public void testFindOneRedis() throws Exception {
        Girl girl = girlService.findOne(1);
        stringRedisTemplate.delete(String.format(RedisKey.GIRL, 1));
        Assert.assertEquals(new Integer(18), girl.getAge());
    }
}
