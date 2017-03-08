package com.att.m2x.java;

import java.io.IOException;

/**
 * The Class M2XClassWithMetadata.
 */
public abstract class M2XClassWithMetadata extends M2XClass
{
	M2XClassWithMetadata(M2XClient client)
	{
		super(client);
	}

	/**
	 * Get custom metadata of an existing entity.
	 *
	 * @return the API response
	 * @throws java.io.IOException if an input or output exception occurred
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Read-Device-Metadata">Read Device Metadata</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Read-Distribution-Metadata">Read Distribution Metadata</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/collections#Read-Collection-Metadata">Read Collection Metadata</a>
	 */
	public M2XResponse metadata() throws IOException { return makeGet("/metadata", null); }

	/**
	 * Update the custom metadata of the specified entity.
	 *
	 * @param jsonContent parameters for the request as JSON formatted string
	 * @return the API response
	 * @throws java.io.IOException if an input or output exception occurred
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Update-Device-Metadata">Update Device Metadata</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Update-Distribution-Metadata">Update Distribution Metadata</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/collections#Update-Collection-Metadata">Update Collection Metadata</a>
	 */
	public M2XResponse updateMetadata(String jsonContent) throws IOException { return makePut("/metadata", jsonContent); }

	/**
	 * Get the value of a single custom metadata field from an existing entity.
	 *
	 * @param field the name of the field in the metadata
	 * @return the API response
	 * @throws java.io.IOException if an input or output exception occurred
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Read-Device-Metadata-Field">Read Device Metadata Field</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Read-Distribution-Metadata-Field">Read Distribution Metadata Field</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/collections#Read-Collection-Metadata-Field">Read Collection Metadata Field</a>
	 */
	public M2XResponse metadataField(String field) throws IOException { return makeGet("/metadata/" + field, null); }

	/**
	 * Update the custom metadata of the specified entity.
	 *
	 * @param field the name of the field in the metadata
	 * @param jsonContent parameters for the request as JSON formatted string
	 * @return the API response
	 * @throws java.io.IOException if an input or output exception occurred
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Update-Device-Metadata-Field">Update-Device-Metadata-Field</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Update-Distribution-Metadata-Field">Update-Distribution-Metadata-Field</a>
	 * @see <a href="https://m2x.att.com/developer/documentation/v2/collections#Update-Collection-Metadata-Field">Update-Collection-Metadata-Field</a>
	 */
	public M2XResponse updateMetadataField(String field, String jsonContent) throws IOException { return makePut("/metadata/" + field, jsonContent); }
}
