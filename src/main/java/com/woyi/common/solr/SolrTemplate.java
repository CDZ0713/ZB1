package com.woyi.common.solr;

import org.apache.solr.client.solrj.impl.HttpSolrServer;

import java.net.MalformedURLException;

public class SolrTemplate {

	private HttpSolrServer server;
	private String SOLR_URL = "http://localhost:8983/solr";

	public String getSOLR_URL() {
		return SOLR_URL;
	}

	public synchronized void setSOLR_URL(String sOLR_URL) {
		SOLR_URL = sOLR_URL;
	}
	public HttpSolrServer getHttpSolrServer() throws MalformedURLException {
		if(server == null){
			server = new HttpSolrServer(SOLR_URL);//HttpSolrServer 是线程安全的，建议重复使用HttpSolrServer 实例。
			server.setSoTimeout(1000); // socket read timeout 
			server.setConnectionTimeout(1000); 
			server.setDefaultMaxConnectionsPerHost(100); 
			server.setMaxTotalConnections(100); 
			server.setFollowRedirects(false); // defaults to false 
			// allowCompression defaults to false. 
			// Server side must support gzip or deflate for this to have any effect. s
			server.setAllowCompression(true); 
			server.setMaxRetries(1); // defaults to 0. > 1 not recommended.
		}
		return server;
	}
}
