package pers.wzs.springmvc.service;

import java.util.List;

/**
 * 通用接口
 */
public interface IService<T> {

    T selectByPK(Object key);

    int insert(T entity);

    int deleteByPK(Object key);

    int update(T entity);

    List<T> select(T entity);

    List<T> selectByExample(Object example);

}
