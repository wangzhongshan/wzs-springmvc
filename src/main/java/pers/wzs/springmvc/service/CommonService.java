package pers.wzs.springmvc.service;

import pers.wzs.springmvc.Constants.MapperFindMethod;
import pers.wzs.springmvc.mapper.WzsBaseMapper;

import java.util.List;

/**
 * @author wangzhongshan
 * @description 通用service
 * @created 2016-09-01 17:04
 */
public interface CommonService {

    <T extends WzsBaseMapper> T getMapperByMapperClass(Class<T> mapperClass);

    <T> WzsBaseMapper<T> getMapper(Class<T> entityClass);

    <T> WzsBaseMapper<T> getMapper(Class<T> entityClass, MapperFindMethod method);

    <T> T selectByPK(Class<T> entityClass, Object key);

    <T> int insert(T entity);

    <T> int insert(List<T> entitys);

    <T> int deleteByPK(Class<T> entityClass, Object key);

    <T> int update(T entity);

    <T> List<T> select(T entity);

}
