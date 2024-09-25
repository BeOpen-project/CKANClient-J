package org.ckan;

import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Optional;
import java.util.Properties;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.*;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.client.CredentialsProvider;

/**
 * Connection holds the connection details for this session
 *
 * @author Ross Jones <ross.jones@okfn.org>
 * @version 1.7
 * @since 2012-05-01
 */
public final class Connection {

	private String m_host;
	private int m_port;
	private String _apikey = null;
	private static Properties proxyProps;
	private static Logger logger = LogManager.getLogger(Connection.class);

	static {
		proxyProps = new Properties();
		try {
			proxyProps.load(Connection.class.getClassLoader().getResourceAsStream("configuration.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Connection() {
	}

	public Connection(String host) {
		if(host.contains("http")) {
			// remove http:// and add https://
			this.m_host = "https" + host.split("http")[1];
		}else {
			this.m_host = host;
		}
	}

	public Connection(String host, int port) {
		if (!Pattern.matches(".*:(\\d.*)", host))
			if(host.contains("http")) {
				// remove http:// and add https://
				this.m_host = "https" + host.split("http")[1];
			}else {
				this.m_host = host;
			}
		else
			this.m_host = host.split(".*:(\\d.*)")[0];
			if(host.contains("http")) {
				// remove http:// and add https://
				this.m_host = "https" + host.split("http")[1];
			}else {
				this.m_host = host;
			}
		this.m_port = port;

		try {
			new URL(this.m_host + ":" + this.m_port + "/api");
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
			logger.info(mue);
		}

	}

	public void setApiKey(String key) {
		this._apikey = key;
	}

	/**
	 * Makes a POST request
	 *
	 * Submits a POST HTTP request to the CKAN instance configured within the
	 * constructor, returning tne entire contents of the response.
	 *
	 * @param path
	 *            The URL path to make the POST request to
	 * @param data
	 *            The data to be posted to the URL
	 * @throws IOException
	 * @throws KeyStoreException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws UnsupportedOperationException
	 * @returns The String contents of the response
	 * @throws A
	 *             CKANException if the request fails
	 */
	protected String Post(String path, String data) throws UnknownHostException, SocketTimeoutException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException{
		URL url = null;
		String body = "";

		logger.info("CONNECTION: OPEN");
		System.out.println(this.m_host + path + "\t" + data);
		url = new URL(this.m_host + path);

		/*
		 * TEST NUOVO HTTP CLIENT // RequestConfig requestConfig =
		 * RequestConfig.custom().setConnectTimeout(300 * 1000).build(); // int
		 * CONNECTION_TIMEOUT = 300 * 1000; // timeout in millis //
		 * RequestConfig requestConfig = RequestConfig.custom() //
		 * .setConnectionRequestTimeout(CONNECTION_TIMEOUT) //
		 * .setConnectTimeout(CONNECTION_TIMEOUT) //
		 * .setSocketTimeout(CONNECTION_TIMEOUT) // .build(); // HttpClient
		 * httpclient =
		 * HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).
		 * build();
		 */
		RequestConfig requestConfig = RequestConfig.custom()
			.setConnectTimeout(300000)
			.setSocketTimeout(900000)
			.build();
		
		SSLContextBuilder builder = SSLContextBuilder.create();
		builder.loadTrustMaterial(new org.apache.http.conn.ssl.TrustSelfSignedStrategy());
	    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
	            builder.build());
	    
		/*
		 * Set an HTTP proxy if it is specified in system properties.
		 * 
		 * http://docs.oracle.com/javase/6/docs/technotes/guides/net/proxies.
		 * html
		 * http://hc.apache.org/httpcomponents-client-ga/httpclient/examples/org
		 * /apache/http/examples/client/ClientExecuteProxy.java
		 */
		HttpHost proxy = null;
		CloseableHttpClient httpclient=null;
		if (Boolean.parseBoolean(getProperty("https.proxyEnabled").trim())
				&& StringUtils.isNotBlank(getProperty("https.proxyHost").trim())) {
			
			int port = 80;
			if (StringUtils.isNotBlank(getProperty("https.proxyPort"))) {
				port = Integer.parseInt(getProperty("https.proxyPort"));
			}
			proxy = new HttpHost(getProperty("https.proxyHost"), port, "https");
			
						DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
			httpclient = HttpClients.custom()
			                    .setRoutePlanner(routePlanner)
			                    .setSSLSocketFactory(
			        		            sslsf).build();
						
			if (StringUtils.isNotBlank(getProperty("https.proxyUser"))) {
				CredentialsProvider credsProvider = new BasicCredentialsProvider();
				credsProvider.setCredentials(
						new AuthScope(getProperty("https.proxyHost"), port),
						new UsernamePasswordCredentials(getProperty("https.proxyUser"), getProperty("https.proxyPassword")));
				httpclient = HttpClients.custom()
						.setRoutePlanner(routePlanner)
						.setSSLSocketFactory(sslsf)
						.setDefaultCredentialsProvider(credsProvider)
						.build();
			httpclient = HttpClients.custom()
					.setRoutePlanner(routePlanner)
					.setSSLSocketFactory(sslsf)
					.setDefaultCredentialsProvider(credsProvider)
					.build();
			}
		}else {
			httpclient = HttpClients.custom().setSSLSocketFactory(
		            sslsf).build();
		}
		
		
		try {

			HttpPost postRequest = new HttpPost(url.toString());

			// postRequest.setConfig(requestConfig);
			postRequest.setHeader("X-CKAN-API-Key", this._apikey);

			StringEntity input = new StringEntity(data, "UTF-8");
			postRequest.setConfig(requestConfig);
			input.setContentType("application/json");
			input.setContentEncoding("UTF-8");
			postRequest.setEntity(input);

			HttpResponse response = httpclient.execute(postRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			logger.info("Status code: "+statusCode);
			if(statusCode==404) {
				throw new UnknownHostException("404NotFound");
			}
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String result = "";
			String line = "";
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			body = result.toString();

			
		}catch (UnsupportedOperationException | UnknownHostException e){
			e.printStackTrace();
			throw new UnknownHostException(e.getMessage());
		
		} catch (IOException e) {
			e.printStackTrace();
			if (e.getClass().equals(SocketTimeoutException.class) || e.getClass().equals(ConnectException.class))
				throw new SocketTimeoutException(e.getMessage());	
			else
				throw new IOException(e.getMessage());
		}

		return body;
	}

	private static boolean isSet(String string) {
		return string != null && string.length() > 0;
	}
	
	public static String getProperty(String propName) {
		Optional<String> prop = Optional.ofNullable(System.getenv(propName.toString()));
		return prop.orElseGet(() -> proxyProps.getProperty(propName.toString(), ""));
	}
}
