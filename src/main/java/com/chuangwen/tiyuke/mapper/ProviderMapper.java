package com.chuangwen.tiyuke.mapper;

import com.chuangwen.tiyuke.entities.Provider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProviderMapper {

//   获取所有供应商
    List<Provider> getAllProviders(Provider provider);

//    根据供应商名称查询
    Provider getProviderById(Integer pid);

//    添加供应商
    int addProvider(Provider provider);

//    删除供应商
    int deleteProviderById(Integer pid);

//    更新供应商信息
    int updateProvider(Provider provider);

}
