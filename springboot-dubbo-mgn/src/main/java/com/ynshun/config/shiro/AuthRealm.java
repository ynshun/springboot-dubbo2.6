package com.ynshun.config.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.ynshun.api.system.ISystemEmployeeService;
import com.ynshun.common.domain.system.SystemEmployee;
import com.ynshun.config.spring.DubboBeanFactory;

public class AuthRealm extends AuthorizingRealm {

	/**
	 * 认证.登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		try {
			UsernamePasswordToken utoken = (UsernamePasswordToken) token;
			String loginname = utoken.getUsername();

			ISystemEmployeeService employeeService = DubboBeanFactory.getDubboService(ISystemEmployeeService.class);
			SystemEmployee user = employeeService.selectByLoginname(loginname);
			
			return new SimpleAuthenticationInfo(user, user.getLoginpwd(), this.getClass().getName());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		// 获取session中的用户
		// SystemEmployee user = (SystemEmployee)
		// principal.fromRealm(this.getClass().getName()).iterator().next();
		List<String> permissions = new ArrayList<>();
		// Set<Role> roles = user.getRoles();
		// if (roles.size() > 0) {
		// for (Role role : roles) {
		// Set<Module> modules = role.getModules();
		// if (modules.size() > 0) {
		// for (Module module : modules) {
		// permissions.add(module.getMname());
		// }
		// }
		// }
		// }
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);
		return info;
	}

}