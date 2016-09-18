package pers.wzs.springmvc.service;


import com.github.pagehelper.PageInfo;
import pers.wzs.springmvc.pojo.SysUser;

import java.util.List;

public interface SysUserService extends IService<SysUser>{
	PageInfo<SysUser> getSysUsers(SysUser user,int pageNum,int pageSize);

	int insertSysUsers(List<SysUser> users) throws Exception;
}
