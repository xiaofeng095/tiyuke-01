package com.chuangwen.tiyuke;

import com.chuangwen.tiyuke.entities.Provider;
import com.chuangwen.tiyuke.mapper.ProviderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tiyuke01ApplicationTests {

    @Autowired
    ProviderMapper providerMapper;

    @Test
    public void contextLoads() {

        List<Provider> allProviders = providerMapper.getAllProviders(null);
        System.out.println(allProviders.get(0));

        Provider providerById = providerMapper.getProviderById(100003);
        System.out.println(providerById);

      //  providerMapper.addProvider(new Provider(null,"jsnjzftkjxy2","江苏正方体科教学院","江苏","南京","夏传林","17714398356","南京市雨花台区西善桥街道128号","028-8733043","潜在客户，需求量大，需要定期跟单"));


        providerMapper.updateProvider(new Provider(100003,"jsnjzftkjxy3","江苏正方体科教学院","江苏","南京","夏传林","17714398356","南京市雨花台区西善桥街道128号","028-8733043","潜在客户，需求量大，需要定期跟单"));

        providerMapper.deleteProviderById(100003);
    }

}
