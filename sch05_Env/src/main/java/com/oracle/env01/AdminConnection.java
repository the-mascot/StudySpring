package com.oracle.env01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements DisposableBean, InitializingBean, EnvironmentAware {
	
	private Environment env;
	private String adminId;
	private String adminPw;
	
	// 생성자 이후 1
	public void setEnvironment(Environment env) {
		System.out.println("AdminConnection setEnvironment()...");
		setEnv(env);
	}
	// 생성자 이후 2
	public void afterPropertiesSet() throws Exception {
		System.out.println("AdminConnection afterPropertiesSet()...");
		System.out.println("AdminConnection env.Property(admin.id)->"+env.getProperty("admin.id"));
		setAdminId(env.getProperty("admin.id"));
		setAdminPw(env.getProperty("admin.pw"));
	}

	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		System.out.println("setAdminId()");
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		System.out.println("setAdminPw()");
		this.adminPw = adminPw;
	}

	
	
	
}
