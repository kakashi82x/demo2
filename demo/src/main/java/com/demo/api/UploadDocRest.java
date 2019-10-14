/*
 * 
 */
package com.demo.api;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.beans.Acdo;
import com.demo.beans.Customer;
import com.demo.beans.Data;
import com.demo.beans.Imagen;
import com.demo.beans.Response;
import com.demo.services.DocService;
import com.demo.tools.CustomMultipartFile;
import com.demo.tools.FileUtilities;

// TODO: Auto-generated Javadoc
/**
 * The Class UploadDocRest.
 */
@RestController
@RequestMapping ("/v1")
public class UploadDocRest {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(UploadDocRest.class);
	
	/** The file utilities. */
	@Autowired
	private FileUtilities fileUtilities;
	
	/** The doc service. */
	@Autowired
	private DocService docService;
	
	/**
	 * Upload docuemts.
	 *
	 * @param customer the customer
	 * @return the response
	 */
	@RequestMapping( value = "/upload/documents", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity uploadDocuemts (final @RequestBody Customer customer) {
		Response response = new Response();
		response.setCode(1);
		response.setDescription("Error al procesar solicitud");
		List<MultipartFile> multipartList = new ArrayList<MultipartFile>();
		for(final Imagen item : this.getImageList(customer.getAcdo())) {
			multipartList.add(fileUtilities.convertToMultipartFile(item));
		}
		
		response = this.docService.sendDocs(new Data(), multipartList.toArray(new CustomMultipartFile[multipartList.size()]));
		if(response.getCode() != 0) {
			return new ResponseEntity<Response>(response, HttpStatus.OK); 
		} 
		
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/**
	 * Gets the image list.
	 *
	 * @param acdoList the acdo list
	 * @return the image list
	 */
	private List<Imagen> getImageList(final List<Acdo> acdoList) {
		final List<Imagen> lstImage = new ArrayList<Imagen>();
		for(final Acdo item: acdoList) {
			for(final Imagen img : item.getImagenes()) {
				lstImage.add(img);
			}
		}
		return lstImage;
	}
}
