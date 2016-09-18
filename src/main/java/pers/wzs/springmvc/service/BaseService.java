package pers.wzs.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import pers.wzs.springmvc.mapper.WzsBaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wangzhongshan
 * @description 通用BaseService
 * @created 2016-08-26 10:41
 */
public abstract class BaseService<T> implements IService<T>{
    @Autowired
    protected WzsBaseMapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    @Override
    public T selectByPK(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public List<T> selectByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    public int insert(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int deleteByPK(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int deleteByIds(String ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public int update(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> select(T entity) {
        return mapper.select(entity);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
}
