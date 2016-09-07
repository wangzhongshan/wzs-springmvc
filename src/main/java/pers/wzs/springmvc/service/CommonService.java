package pers.wzs.springmvc.service;

import pers.wzs.springmvc.Constants.MapperFindMethod;
import pers.wzs.springmvc.pojo.BaseModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wangzhongshan
 * @description 通用service
 * @created 2016-09-01 17:04
 */
public interface CommonService {

    <T extends Mapper> T getMapperByMapperClass(Class<T> mapperClass);

    <T> Mapper<T> getMapper(Class<T> entityClass);

    <T> Mapper<T> getMapper(Class<T> entityClass, MapperFindMethod method);

    <T> T selectByPK(Class<T> entityClass, Object key);

    <T> int insert(T entity);

    <T> int deleteByPK(Class<T> entityClass, Object key);

    <T> int update(T entity);

    <T> List<T> select(T entity);

}
