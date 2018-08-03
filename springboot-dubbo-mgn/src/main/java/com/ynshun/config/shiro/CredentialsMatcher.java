package com.ynshun.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.ynshun.common.util.TypeUtil;

public class CredentialsMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;
		// 获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
		String inPassword = new String(utoken.getPassword());
		// 获得数据库中的密码
		String dbPassword = TypeUtil.transfer(info.getCredentials(), String.class);
		// 进行密码的比对
		return this.equals(inPassword, dbPassword);
	}

}