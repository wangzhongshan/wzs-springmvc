package pers.wzs.springmvc.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import pers.wzs.springmvc.Constants.MapperFindMethod;
import pers.wzs.springmvc.mapper.WzsBaseMapper;
import pers.wzs.springmvc.service.CommonService;
import pers.wzs.springmvc.utils.SpringContextUtil;

import java.util.List;

/**
 * @author wangzhongshan
 * @description 通用service实现类
 * @created 2016-09-02 16:18
 */
@Service
public class CommonServiceImpl implements CommonService{

    private static final MapperFindMethod defaultMethod = MapperFindMethod.CONVENTION;
    private static final String mapper_suffix = "Mapper";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Autowired
    private List<WzsBaseMapper> mappers;

    @Override
    public <T extends WzsBaseMapper> T getMapperByMapperClass(Class<T> mapperClass) {
        return sqlSessionTemplate.getMapper(mapperClass);
    }

    @Override
    public <T> WzsBaseMapper<T> getMapper(Class<T> entityClass) {
        return getMapper(entityClass, defaultMethod);
    }

    @Override
    public <T> WzsBaseMapper<T> getMapper(Class<T> entityClass, MapperFindMethod method) {
        switch (method) {
            case ACCURATE:
                return getMapperAccurate(entityClass);
            case CONVENTION:
                return getMapperConvention(entityClass);
            default:
                return getMapperConvention(entityClass);
        }
    }

    private <T> WzsBaseMapper<T> getMapperConvention(Class<T> entityClass) {
        return (WzsBaseMapper<T>) SpringContextUtil.getBean(ClassUtils.getShortNameAsProperty(entityClass) + mapper_suffix);
    }

    private <T> WzsBaseMapper<T> getMapperAccurate(Class<T> entityClass) {
        for (int i = 0; i < mappers.size(); i++) {
            WzsBaseMapper mapper = mappers.get(i);
            Class<?> oriMapper = mapper.getClass().getInterfaces()[0];
            ResolvableType resolvableType = ResolvableType.forClass(oriMapper);
            Class<?> typeClass = resolvableType.getInterfaces()[0].getGeneric(0).resolve();
            if (entityClass == typeClass) {
                return mapper;
            }
        }
        return null;
    }

    @Override
    public <T> T selectByPK(Class<T> entityClass, Object key) {
        return getMapper(entityClass).selectByPrimaryKey(key);
    }

    @Override
    public <T> int insert(T entity) {
        return ((WzsBaseMapper<T>) getMapper(entity.getClass())).insertSelective(entity);
    }

    @Override
    public <T> int insert(List<T> entitys) {
        if (entitys == null || entitys.size() == 0) {
            return 0;
        }
        WzsBaseMapper<T> mapper = (WzsBaseMapper<T>) getMapper(entitys.get(0).getClass());
        return mapper.insertList(entitys);
    }

    @Override
    public <T> int deleteByPK(Class<T> entityClass, Object key) {
        return getMapper(entityClass).deleteByPrimaryKey(key);
    }

    @Override
    public <T> int update(T entity) {
        return ((WzsBaseMapper<T>) getMapper(entity.getClass())).updateByPrimaryKeySelective(entity);
    }

    @Override
    public <T> List<T> select(T entity) {
        return ((WzsBaseMapper<T>) getMapper(entity.getClass())).select(entity);
    }
}
