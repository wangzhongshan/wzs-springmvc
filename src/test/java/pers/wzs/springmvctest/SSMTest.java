package pers.wzs.springmvctest;

import com.github.pagehelper.PageInfo;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.wzs.springmvc.mapper.RoleMapper;
import pers.wzs.springmvc.pojo.Role;
import pers.wzs.springmvc.pojo.SysUser;
import pers.wzs.springmvc.service.SysUserService;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class SSMTest {

	
	@Resource
	private SysUserService sysUserService;
	@Autowired
	private RoleMapper roleMapper;

	@Test
	public void test1() {
		SysUser sysUser = sysUserService.getById(10l);
		System.out.println("--------------------------------" + sysUser.toString());
	}

	@Test
	public void testInsert() {

		for (int i = 0; i <20 ; i++) {
			SysUser sysUser = new SysUser();
			sysUser.setSysUserLoginName("wzs"+(i+16));
			sysUser.setSysUserLoginPassword("r3r3");
			sysUser.setSysUserPayPasswrod("wfeffe");
			sysUser.setSysUserSex("0");
			sysUser.setSysUserRegisterDatetime(new Date());
			sysUserService.insert(sysUser);
			System.out.println(sysUser.getSysUserId());
		}
	}

	@Test
	public void testRoleMapper() {
		//Role role = roleMapper.selectByPrimaryKey(1l);

		Role role1 = new Role();
		role1.setName("报表员");
		role1.setStatus("0");
		System.out.println(roleMapper.insertSelective(role1));
	}

	@Test
	public void testGetUsers() {
		SysUser user = new SysUser();
		user.setSysUserIsMobileActive("N");
		PageInfo<SysUser> sysUsers = sysUserService.getSysUsers(user, 4, 10);
		System.out.println(sysUsers.getSize());
	}
}
