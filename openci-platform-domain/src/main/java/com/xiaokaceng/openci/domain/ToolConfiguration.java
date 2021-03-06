package com.xiaokaceng.openci.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.dayatang.domain.QuerySettings;

@Entity
@Table(name = "tool_configurations")
@DiscriminatorColumn(name = "tool_type", discriminatorType = DiscriminatorType.STRING)
public abstract class ToolConfiguration extends TimeIntervalEntity {

	private static final long serialVersionUID = -7992490907551882249L;
	protected static final String HTTP_PROTOCOL_REQUEST_STR = "http://";

	@Column(nullable = false, unique = true)
	private String name;

	@Column(name = "service_url")
	private String serviceUrl;

	private String username;

	private String password;

	private boolean usable = false;

	ToolConfiguration() {
	}

	public ToolConfiguration(String name, String serviceUrl, String username, String password) {
		this.name = name;
		this.serviceUrl = serviceUrl;
		this.username = username;
		this.password = password;
	}

	public static List<ToolConfiguration> findByUsable() {
		return getRepository().find(QuerySettings.create(ToolConfiguration.class).eq("usable", true));
	}

	public abstract String getRequestAddress(String projectName);

	protected String endsWith(String str) {
		if (!str.endsWith("/")) {
			str += "/";
		}
		return str;
	}

	public void usabled() {
		usable = true;
		save();
	}

	public void unusabled() {
		usable = false;
		save();
	}

	public String getName() {
		return name;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isUsable() {
		return usable;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ToolConfiguration)) {
			return false;
		}
		ToolConfiguration that = (ToolConfiguration) other;
		return new EqualsBuilder().append(getName(), that.getName()).append(getServiceUrl(), that.getServiceUrl()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getServiceUrl()).hashCode();
	}

	@Override
	public String toString() {
		return getName();
	}

}
