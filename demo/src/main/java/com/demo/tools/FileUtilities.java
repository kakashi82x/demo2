/*
 * 
 */
package com.demo.tools;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.beans.Imagen;

/**
 * The Class FileUtilities.
 */
@Service ("fileUtilities")
public class FileUtilities {
	
	private static final Logger LOG = Logger.getLogger(FileUtilities.class);
	
	/**
	 * Convert to multipart file.
	 *
	 * @param encodeImages the encode images
	 * @return the list
	 */
	public MultipartFile convertToMultipartFile(final Imagen imagen) {
		final byte[] decodeImg = Base64.decodeBase64(imagen.getImagen());

		LOG.info("name: " + imagen.getName());
		LOG.info("Size: " + decodeImg.length);
		return new CustomMultipartFile(decodeImg, imagen.getName() + ".png");
	}
}
