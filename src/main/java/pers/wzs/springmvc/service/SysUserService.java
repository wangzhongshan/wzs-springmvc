package pers.wzs.springmvc.service;


import com.github.pagehelper.PageInfo;
import pers.wzs.springmvc.pojo.SysUser;

public interface SysUserService {
	SysUser getById(Long id);
	int insert(SysUser sysUser);

	PageInfo<SysUser> getSysUsers(SysUser user,int pageNum,int pageSize);
}
