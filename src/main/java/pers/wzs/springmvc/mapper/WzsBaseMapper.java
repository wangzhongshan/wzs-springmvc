package pers.wzs.springmvc.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wangzhongshan
 * @created 2016-08-18 12:07
 */
public interface WzsBaseMapper<T> extends Mapper<T>,MySqlMapper<T>,IdsMapper<T>{
}
