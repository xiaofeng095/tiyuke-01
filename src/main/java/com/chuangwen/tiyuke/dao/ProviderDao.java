package com.chuangwen.tiyuke.dao;



import com.chuangwen.tiyuke.entities.Provider;
import com.chuangwen.tiyuke.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.*;

@Repository
public class ProviderDao {

    private static List<Provider> providerList = null;

//    static {
//        providerMap = new HashMap<Integer, Provider>();
//
//        providerMap.put(2001, new Provider(2001, "PR-AA", "梦学谷供应商111", "小张", "18888666981", "深圳软件园", "0911-0123456", "品质A"));
//        providerMap.put(2002, new Provider(2002, "PR-BB", "梦学谷供应商222", "小李", "18888666982", "深圳软件园", "0911-0123453", "品质B"));
//        providerMap.put(2003, new Provider(2003, "PR-CC", "梦学谷供应商333", "小白", "18888666983", "深圳软件园", "0911-0123454", "品质C"));
//        providerMap.put(2004, new Provider(2004, "PR-DD", "梦学谷供应商444", "小梦", "18888666984", "深圳软件园", "0911-0123451", "品质D"));
//        providerMap.put(2005, new Provider(2005, "PR-EE", "梦学谷供应商555", "小谷", "18888666985", "深圳软件园", "0911-0123452", "品质E"));
//
//    }
static {
    providerList = new ArrayList<>();

    providerList.add( new Provider(100001, "PR-AA", "南京金陵中学111", "江苏省","南京","张校长", "18888666981", "深圳软件园", "0911-0123456", "品质A"));
    providerList.add( new Provider(100002, "PR-AA", "南京金陵中学111", "江苏省","泰州","张校长", "18888666981", "深圳软件园", "0911-0123456", "品质A"));
    providerList.add( new Provider(100003, "PR-AA", "南京金陵中学111", "江苏省","常州","张校长", "18888666981", "深圳软件园", "0911-0123456", "品质A"));
    providerList.add( new Provider(100004, "PR-AA", "南京金陵中学111", "江苏省","无锡","张校长", "18888666981", "深圳软件园", "0911-0123456", "品质A"));
    providerList.add( new Provider(100005, "PR-AA", "南京金陵中学111", "江苏省","南京","张校长", "18888666981", "深圳软件园", "0911-0123456", "品质A"));


}
    //添加、修改 用户名
    public void save(Provider provider){
//        if(provider.getPid() == null){
//            provider.setPid(initId++);
//        }
//        providerMap.put(provider.getPid(), provider);

        //若pid为空则添加新用户
        if(provider.getPid() == null){
            //获取最后一位用户得id号自增
            provider.setPid(providerList.get(providerList.size()-1).getPid()+1);
            //添加新用户
            providerList.add(provider);
        }else{//uid不为空 编辑用户信息
            for (int i = 0;i<providerList.size();i++) {
                //判断修改值是否已存在
                if (provider.getPid().equals(providerList.get(i).getPid())){
                    //修改
                    providerList.set(i,provider);
                    //结束操作
                    break;
                }
            }
        }
    }

    //返回所有数据
    public Collection<Provider> getAll(){
        return providerList;
    }

    //查询数据
    public Collection<Provider> getAll(String providerName){
        Collection<Provider> providers = getAll();

        //不为空
        if( !StringUtils.isEmpty( providerName )) {
            int count = 0;
            for (Provider provider: providers) {
                //包含则存在
                if ( provider.getProviderName().toUpperCase().contains(  providerName.toUpperCase() ) ) {
                    count++;
                    //count>1 表示集合至少有一个存在的用户, 否则创建新的集合
                    providers = count > 1 ? providers : new ArrayList<Provider>();
                    providers.add(provider);
                }
            }
            if (count==0){
                //没有查询到，返回空集合
                providers = new ArrayList<Provider>();
            }
        }

        return providers;
    }

    public Provider providerView(Integer pid){
        Provider provider = null;

        //list集合中查找元素下标
        for (int i=0;i<providerList.size();i++){
            if (pid.equals(providerList.get(i).getPid())){
                //根据下标获取对象
                provider = providerList.get(i);
            }
        }

        //返回查询到的数据
        return provider;
    }

    public void delete(Integer pid){
        //遍历User数组
        for (int i = 0;i<providerList.size();i++) {
            //判断需要删除得用户数据下标
            if (pid.equals(providerList.get(i).getPid())){
                //删除数据
                providerList.remove(i);
            }
        }
    }
}
