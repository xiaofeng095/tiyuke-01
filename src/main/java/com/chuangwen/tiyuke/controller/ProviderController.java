package com.chuangwen.tiyuke.controller;

import com.chuangwen.tiyuke.dao.ProviderDao;
import com.chuangwen.tiyuke.entities.Provider;
import com.chuangwen.tiyuke.entities.User;
import com.chuangwen.tiyuke.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProviderDao providerDao;

    @Autowired
    ProviderMapper providerMapper;


    @GetMapping("/provider_list")
    public String getProviderList(Map<String,Object> map,Provider provider){

        List<Provider> providers = providerMapper.getAllProviders(provider);

        map.put("providerList",providers);
        map.put("providerSearch",provider.getProviderName());

        return "provider/list.html";
    }

    /**
     * 查看与修改共用，根据type值判断返回view或update页面
     * @param pid 查询 用户名
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/provider_view/{pid}")
    public String getProviderView(@PathVariable("pid") Integer pid,
                              @RequestParam(value = "type",defaultValue = "view")String type,Map<String,Object> map){
        logger.info("查看"+pid+"详情");

//        Provider provider = providerDao.providerView(pid);

        Provider providerById = providerMapper.getProviderById(pid);

        map.put("providerInfo",providerById);
        return "provider/"+type;

    }


    @PutMapping("/provider_update")
    public String providerUpdate(Provider provider){

        logger.info("修改"+provider+"信息");

        providerMapper.updateProvider(provider);

//        providerDao.save(provider);
        return "redirect:/provider_list";
    }

    @GetMapping("/provider_add")
    public String toAddUserPage(){

        return "provider/add.html";
    }

    @PostMapping("/provider_add")
    public String addUser(Provider provider){
        logger.info("添加"+provider+"数据");
        //provider.setCreateDate(new Date());

        providerMapper.addProvider(provider);
//        providerDao.save(provider);
        return "redirect:/provider_list";
    }

    @DeleteMapping("/provider_delete/{pid}")
    public String deleteUser(@PathVariable("pid")Integer pid){
        logger.info("删除"+pid);
        providerMapper.deleteProviderById(pid);
//        providerDao.delete(pid);
        return "redirect:/provider_list";
    }



}
