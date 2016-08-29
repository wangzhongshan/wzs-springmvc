package pers.wzs.springmvc.service;


import com.github.pagehelper.PageInfo;
import pers.wzs.springmvc.pojo.SysUser;

public interface SysUserService extends IService<SysUser>{
	PageInfo<SysUser> getSysUsers(SysUser user,int pageNum,int pageSize);
}
