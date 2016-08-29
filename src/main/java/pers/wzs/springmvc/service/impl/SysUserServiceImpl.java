package pers.wzs.springmvc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pers.wzs.springmvc.mapper.SysUserMapper;
import pers.wzs.springmvc.pojo.SysUser;
import pers.wzs.springmvc.service.BaseService;
import pers.wzs.springmvc.service.SysUserService;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl extends BaseService<SysUser> implements SysUserService {
	
	@Override
	public PageInfo<SysUser> getSysUsers(SysUser user,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize, "sys_user_id desc");
		List<SysUser> sysUsers = mapper.select(user);
		return new PageInfo<>(sysUsers);
	}
}
