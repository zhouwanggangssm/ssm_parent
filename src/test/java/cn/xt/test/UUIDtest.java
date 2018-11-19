package cn.xt.test;

import org.junit.Test;

import java.util.UUID;

public class UUIDtest {
    @Test
    public void test(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");
        System.out.println(uuid);
    }
}
