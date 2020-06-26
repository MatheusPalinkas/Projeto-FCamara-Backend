package br.com.projetofcamara.projeto.controller;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetofcamara.projeto.config.security.TokenService;
import br.com.projetofcamara.projeto.controller.dto.TokenDto;
import br.com.projetofcamara.projeto.controller.dto.UsuarioDto;
import br.com.projetofcamara.projeto.controller.form.LoginForm;
import br.com.projetofcamara.projeto.entity.Usuario;
import br.com.projetofcamara.projeto.service.UsuarioService;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	} 
	
	@GetMapping("/usuario")
	public ResponseEntity<UsuarioDto> buscarInformacoesUsuario(HttpServletRequest request){
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		String idUsuario = tokenService.getIdUsuario(token.substring(7, token.length()));
		Optional<Usuario> buscarUsuario = usuarioService.buscarUsuarioPeloId(idUsuario);
		if(buscarUsuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(buscarUsuario.get()));
		}
		return ResponseEntity.notFound().build();
	}
}
