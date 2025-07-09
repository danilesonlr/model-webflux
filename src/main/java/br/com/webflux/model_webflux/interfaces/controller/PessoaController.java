package br.com.webflux.model_webflux.interfaces.controller;

import br.com.webflux.model_webflux.application.PessoaUseCase;
import br.com.webflux.model_webflux.interfaces.dto.PessoaDTO;
import br.com.webflux.model_webflux.interfaces.mapper.PessoaDTOMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoa")
@RequiredArgsConstructor
@Tag(name = "Pessoas", description = "Operações relacionadas a pessoas")

public class PessoaController {

  private final PessoaUseCase pessoaUseCase;

  @PostMapping
  //@ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Salvar pessoa", description = "Salva uma nova pessoa.")
  public Object save(@RequestBody PessoaDTO pessoaDTO) {
    return pessoaUseCase.save(PessoaDTOMapper.INSTANCE.pessoaToEntity(pessoaDTO));
  }

  @GetMapping
  @Operation(summary = "Buscar todos", description = "Buscar todos as pessoas.")
  public Object findAll() {
    return pessoaUseCase.findAll();
  }
}
