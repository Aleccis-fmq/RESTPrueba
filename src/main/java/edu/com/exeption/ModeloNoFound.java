package edu.com.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//SE REALIZA EN ResponseExHandler / @ResponseStatus (HttpStatus.NOT_FOUND)
public class ModeloNoFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	
	public ModeloNoFound(String msj) {
		super(msj);
	}

}
