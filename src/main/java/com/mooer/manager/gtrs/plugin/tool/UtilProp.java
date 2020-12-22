package com.mooer.manager.gtrs.plugin.tool;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * securities相关配置
 * @author IT03
 *
 */
@ConfigurationProperties(prefix = "main.plugin.util")
@Component
public class UtilProp {

	private long workerId = 0;

	private long datacenterId = 0;
	
	private String trackerServer = "";

	public long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}

	public long getDatacenterId() {
		return datacenterId;
	}

	public void setDatacenterId(long datacenterId) {
		this.datacenterId = datacenterId;
	}

	public String getTrackerServer() {
		return trackerServer;
	}

	public void setTrackerServer(String trackerServer) {
		this.trackerServer = trackerServer;
	}
	
}
