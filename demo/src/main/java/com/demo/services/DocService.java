/*
 * 
 */
package com.demo.services;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.beans.Data;
import com.demo.beans.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class docService.
 */
@Service("docService")
public class DocService {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(DocService.class);

	/**
	 * Send docs.
	 *
	 * @param data  the data
	 * @param files the files
	 * @return the response
	 */
	public Response sendDocs(final Data data, final MultipartFile[] files) {
		final Response response = new Response();
		LOG.info(files.length);
		for (final MultipartFile mfile : files) {
			LOG.info(mfile.getName());
			LOG.info(mfile.getSize());
			try {
				LOG.info(StringUtils.newStringUtf8(Base64.encodeBase64(mfile.getBytes(), false)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		response.setCode(0);
		response.setDescription("Todo OK");
		return response;
	}
}
