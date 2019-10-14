/*
 * 
 */
package com.demo.tools;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Class Base64DecodedMultipartFile.
 */
@Component
public class CustomMultipartFile implements MultipartFile {

	/** The img content. */
	private final byte[] imgContent;

	/** The file name. */
	private String fileName;

	/** The content type. */
	private String contentType;

	/** The file. */
	private File file;

	/** The dest path. */
	private String destPath = System.getProperty("java.io.tmpdir");

	/** The file output stream. */
	private FileOutputStream fileOutputStream;

	public CustomMultipartFile() {
		this.imgContent = null;
	}
	
	/**
	 * Instantiates a new base 64 decoded multipart file.
	 *
	 * @param imgContent the img content
	 * @param fileName   the file name
	 */
	public CustomMultipartFile(final byte[] imgContent, final String fileName) {
		this.imgContent = imgContent;
		this.fileName = fileName;
		this.file = new File(destPath + fileName);
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.fileName;
	}

	/**
	 * Gets the original filename.
	 *
	 * @return the original filename
	 */
	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return this.fileName;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.imgContent == null || this.imgContent.length == 0;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return this.imgContent.length;
	}

	/**
	 * Gets the bytes.
	 *
	 * @return the bytes
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public byte[] getBytes() throws IOException {
		// TODO Auto-generated method stub
		return this.imgContent;
	}

	/**
	 * Gets the input stream.
	 *
	 * @return the input stream
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(this.imgContent);
	}

	/**
	 * Transfer to.
	 *
	 * @param dest the dest
	 * @throws IOException           Signals that an I/O exception has occurred.
	 * @throws IllegalStateException the illegal state exception
	 */
	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		this.fileOutputStream = new FileOutputStream(dest);
		this.fileOutputStream.write(this.imgContent);
		fileOutputStream.flush();
		fileOutputStream.close();
		file.deleteOnExit();
	}

}
