package edu.com.exeption;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExHandler extends ResponseEntityExceptionHandler {

	//CLASE PADRE
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExcResponse> manejorTodosExcp(Exception ex , WebRequest e){
		ExcResponse er = new ExcResponse(LocalDateTime.now(),
				ex.getMessage(),
				e.getDescription(false));
		
		return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	//ValorDesdeModeloNoFound
	@ExceptionHandler(ModeloNoFound.class)
	public ResponseEntity<ExcResponse> manejoException(ModeloNoFound ex, WebRequest request) {

		// exception
		ExcResponse er = new ExcResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ExcResponse>(er, HttpStatus.NOT_FOUND);
	}

	// abstract , contiene metodos

	
	
	//PostValoresdeValidacion
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		
		//mensaje
		String mensaje = ex.getBindingResult().getAllErrors().stream()
				.map(e -> e.getDefaultMessage().concat(" . "))
				.collect(Collectors.joining());
		
		// exception
		ExcResponse er = new ExcResponse(LocalDateTime.now(), mensaje, request.getDescription(false));
		
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}

	// abstract , contiene metodos

	
}
