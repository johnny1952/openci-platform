package com.xiaokaceng.openci.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("jenkins")
public class JenkinsConfiguration extends ToolConfiguration {

	private static final long serialVersionUID = -6711849762118486849L;

	JenkinsConfiguration() {
	}

	public JenkinsConfiguration(String name, String serviceUrl, String username, String password) {
		super(name, serviceUrl, username, password);
	}

	@Override
	public String getRequestAddress(String projectName) {
		return getServiceUrl();
	}

}
