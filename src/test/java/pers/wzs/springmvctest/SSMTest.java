package pers.wzs.springmvctest;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.wzs.springmvc.mapper.CountryMapper;
import pers.wzs.springmvc.mapper.WzsBaseMapper;
import pers.wzs.springmvc.pojo.Country;
import pers.wzs.springmvc.pojo.Role;
import pers.wzs.springmvc.pojo.SysUser;
import pers.wzs.springmvc.service.CommonService;
import pers.wzs.springmvc.service.SysUserService;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class SSMTest {


	@Resource
	private SysUserService sysUserService;
	@Autowired
	private Mapper<Role> roleMapper;
	@Autowired
	private Mapper<SysUser> mapper;
	@Autowired
	private Mapper<Role> roleMapper1;
	@Autowired
	private WzsBaseMapper<Country> countryMapper;
	@Autowired
	private CommonService commonService;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private List<WzsBaseMapper> mappers;


	@Test
	public void test1() {
		SysUser sysUser = sysUserService.selectByPK(1l);
		System.out.println("--------------------------------" + sysUser.toString());
	}

	@Test
	public void testInsert() throws Exception {
		SysUser sysUser = new SysUser();
		sysUser.setSysUserLoginName("wzs52");
		sysUser.setSysUserLoginPassword("r3r3");
		sysUser.setSysUserPayPasswrod("wfeffe");
		sysUser.setSysUserSex("0");
		sysUser.setSysUserRegisterDatetime(new Date());

		SysUser sysUser2 = new SysUser();
		sysUser2.setSysUserLoginName("wzs53");
		sysUser2.setSysUserLoginPassword("r3r3");
		sysUser2.setSysUserPayPasswrod("wfeffe");
		sysUser2.setSysUserSex("0");
		sysUser2.setSysUserRegisterDatetime(new Date());

		List<SysUser> users = new ArrayList<>();
		users.add(sysUser);
		users.add(sysUser2);

		sysUserService.insertSysUsers(users);
		System.out.println(users.size());
	}

	@Test
	public void testRoleMapper() {
		//Role role = roleMapper.selectByPrimaryKey(1l);

		Role role1 = new Role();
		role1.setName("报表员1");
		role1.setStatus("0");
		System.out.println(roleMapper.insertSelective(role1));
	}

	@Test
	public void testGetUsers() {
		SysUser user = new SysUser();
		user.setSysUserIsMobileActive("N");
		PageInfo<SysUser> sysUsers = sysUserService.getSysUsers(user, 1, 10);
		System.out.println(sysUsers.getSize());
	}

	@Test
	public void testCommonMapper() throws Exception {
		//SysUser user = mapper.selectByPrimaryKey(1l);
		//Role role = roleMapper1.selectByPrimaryKey(1l);
		//Role role1 = roleMapper.selectByPrimaryKey(1l);
		//Country country = countryMapper.selectByPrimaryKey(5);
		//System.out.println(country);
		for (int i = 0; i < mappers.size(); i++) {
			System.out.println(mappers.get(i));
		}
	}

	@Test
	public void testCommonService() throws Exception {
		//Mapper<SysUser> user = commonService.getMapperByEntity(SysUser.class);
		//SysUser country = user.selectByPrimaryKey(5l);
		//System.out.println(country);

		Role role = new Role();
		role.setName("报表员5");
		role.setStatus("0");
		Role role2 = new Role();
		role2.setName("报表员6");
		role2.setStatus("0");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		roles.add(role2);
		int count=commonService.insert(roles);
		System.out.println(count);

		//SysUser sysUser = commonService.selectByPK(SysUser.class, 2l);
		//System.out.println(sysUser);

		//SysUser sysUser = new SysUser();
		//sysUser.setSysUserLoginName("wzs52");
		//sysUser.setSysUserLoginPassword("r3r3");
		//sysUser.setSysUserPayPasswrod("wfeffe");
		//sysUser.setSysUserSex("0");
		//sysUser.setSysUserRegisterDatetime(new Date());
		//commonService.insert(sysUser);

		//int i = commonService.deleteByPK(SysUser.class, 56l);
		//System.out.println(i);
		//SysUser sysUser = new SysUser();
		//sysUser.setSysUserId(55l);
		//sysUser.setSysUserLoginPassword("r4r4");
		//commonService.update(sysUser);

		//SysUser sysUser = new SysUser();
		//sysUser.setSysUserLoginPassword("r3r3");
		//List<SysUser> select = commonService.select(sysUser);
		//System.out.println(select.size());
	}
}
