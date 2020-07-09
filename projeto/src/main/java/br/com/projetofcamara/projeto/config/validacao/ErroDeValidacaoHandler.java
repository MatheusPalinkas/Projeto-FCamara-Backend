package br.com.projetofcamara.projeto.config.validacao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.projetofcamara.projeto.exception.RegraDeNegocioException;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	private static final Logger log  = LoggerFactory.getLogger(ErroDeValidacaoHandler.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
		List<ErroDeFormularioDto> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RegraDeNegocioException.class)
	public List<ErroDeFormularioDto> handle(RegraDeNegocioException exception) {
		List<ErroDeFormularioDto> dto = new ArrayList<>();
		String nomeCampo = "CAMPO_INVALIDO";
		String mensagem = exception.getMessage();
		String[] campoMensagem = mensagem.split(",");
		
		if(campoMensagem != null && campoMensagem.length > 1) {
			nomeCampo = campoMensagem[0];
			mensagem = campoMensagem[0];
		}
		dto.add( new ErroDeFormularioDto(nomeCampo, mensagem));
		log.error(dto.toString());
		
		return dto;
	}

}
