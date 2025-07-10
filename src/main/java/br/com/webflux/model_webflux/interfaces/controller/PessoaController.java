package br.com.webflux.model_webflux.interfaces.controller;

import br.com.webflux.model_webflux.application.usecases.PessoaUseCase;
import br.com.webflux.model_webflux.interfaces.dto.PessoaDTO;
import br.com.webflux.model_webflux.interfaces.mapper.PessoaDTOMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @PostMapping("/save")
  @Operation(summary = "Salvar pessoa", description = "Salva uma nova pessoa.")
  public Object save(@RequestBody PessoaDTO pessoaDTO) {
    return pessoaUseCase.save(PessoaDTOMapper.pessoaToEntity(pessoaDTO));
  }

  @GetMapping("/all")
  @Operation(summary = "Buscar todos", description = "Buscar todos as pessoas.")
  public Object findAll() {
    return pessoaUseCase.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Buscar por id", description = "Buscar pessoa por id")
  public Object findId(@PathVariable String id) {
    return pessoaUseCase.findById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Deletar", description = "Deletar pessoa por id")
  public Object delete(@PathVariable String id) {
    return pessoaUseCase.delete(id);
  }

  @PostMapping("/update/{id}")
  @Operation(summary = "Atualizar", description = "Atualizar pessoa por id")
  public Object update(@PathVariable String id, @RequestBody PessoaDTO pessoaDTO) {
    return pessoaUseCase.update(id, PessoaDTOMapper.pessoaToEntity(pessoaDTO));
  }
}
