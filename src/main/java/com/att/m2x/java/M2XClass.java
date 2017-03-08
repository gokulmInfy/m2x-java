package com.att.m2x.java;

import java.io.IOException;

/**
 * The Class M2XClass.
 */
public abstract class M2XClass
{
	public final M2XClient client;

	/**
	 * Instantiates a new M2X class.
	 *
	 * @param the client
	 */
	M2XClass(M2XClient client)
	{
		this.client = client;
	}

	/**
	 * Builds the path.
	 *
	 * @param path the path
	 * @return the string
	 */
	abstract String buildPath(String path);
	String concat(String... strings)
	{
		StringBuilder sb = new StringBuilder();
		for (String str : strings)
			if (str != null)
				sb.append(str);
		return sb.toString();
	}

	
	/**
	 * Make get call.
	 *
	 * @param path the path
	 * @param query the query
	 * @return the M2X response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public M2XResponse makeGet(String path, String query) throws IOException
	{
		return makeRequest("GET", path, query, null);
	}
	
	
	/**
	 * Make post call.
	 *
	 * @param path the path
	 * @param jsonContent the json content
	 * @return the M2X response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public M2XResponse makePost(String path, String jsonContent) throws IOException
	{
		return makeRequest("POST", path, null, jsonContent);
	}
	
	
	/**
	 * Make put call.
	 *
	 * @param path the path
	 * @param jsonContent the json content
	 * @return the M2X response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public M2XResponse makePut(String path, String jsonContent) throws IOException
	{
		return makeRequest("PUT", path, null, jsonContent);
	}
	
	/**
	 * Make delete call.
	 *
	 * @param path the path
	 * @param query the query
	 * @return the M2X response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public M2XResponse makeDelete(String path, String query) throws IOException
	{
		return makeRequest("DELETE", path, query, null);
	}

	/**
	 * Make request.
	 *
	 * @param method the HTTP method (GET/POST/PUT/DELETE)
	 * @param path the path
	 * @param query the query
	 * @param jsonContent the json content
	 * @return the M2X response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public M2XResponse makeRequest(String method, String path, String query, String jsonContent)
		throws IOException
	{
		return this.client.makeRequest(method, buildPath(path), query, jsonContent);
	}

	/**
	 * Get details of an existing entity.
	 *
	 * @return the API response
	 * @throws IOException if an input or output exception occurred
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#View-Device-Details">View Device Details</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#View-Distribution-Details">View Distribution Details</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/keys#View-Key-Details">View Key Details</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#View-Data-Stream">Device-View Data Stream</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#View-Data-Stream">Distribution-View Data Stream</a>
	 */
	public M2XResponse details() throws IOException { return makeGet(null, null); }

	/**
	 * Update an existing entity.
	 *
	 * @param jsonContent parameters for the entity to be updated as JSON formatted string
	 * @return the API response
	 * @throws IOException if an input or output exception occurred
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Update-Device-Details">Update Device Details</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Update-Distribution-Details">Update Distribution Details</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/keys#Update-Key">Update Key</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Create-Update-Data-Stream">Device#Create Update Data Stream</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Create-Update-Data-Stream">Distribution#Create Update Data Stream</a>
	 */
	public M2XResponse update(String jsonContent) throws IOException { return makePut(null, jsonContent); }

	/**
	 * Delete an existing entity.
	 *
	 * @return the API response
	 * @throws IOException if an input or output exception occurred
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Delete-Device">Delete Device</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Delete-Distribution">Distribution#Delete Distribution</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/keys#Delete-Key">Delete Key</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Delete-Data-Stream">Device#Delete Data Stream</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Delete-Data-Stream">Distribution#Delete Data Stream</a>
	 */
	public M2XResponse delete() throws IOException { return makeDelete(null, null); }
}
