package pers.wzs.springmvc.service;

import java.util.List;

/**
 * 通用接口
 */
public interface IService<T> {

    T selectByPK(Object key);

    /**
     * @param ids eg:2,3,4,5
     * @return
     */
    List<T> selectByIds(String ids);

    int insert(T entity);

    int deleteByPK(Object key);

    /**
     * @param ids eg:2,3,4,5
     * @return
     */
    int deleteByIds(String ids);

    int update(T entity);

    List<T> select(T entity);

    List<T> selectByExample(Object example);

}
