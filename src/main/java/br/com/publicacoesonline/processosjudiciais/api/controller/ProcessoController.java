package br.com.publicacoesonline.processosjudiciais.api.controller;

import br.com.publicacoesonline.processosjudiciais.api.assembler.ProcessoAssembler;
import br.com.publicacoesonline.processosjudiciais.api.dto.ProcessoModel;
import br.com.publicacoesonline.processosjudiciais.api.dto.input.ProcessoInput;
import br.com.publicacoesonline.processosjudiciais.api.dto.input.ProcessoUpdateInput;
import br.com.publicacoesonline.processosjudiciais.domain.model.Processo;
import br.com.publicacoesonline.processosjudiciais.domain.service.AtivarProcessoService;
import br.com.publicacoesonline.processosjudiciais.domain.service.ConcluirProcessoService;
import br.com.publicacoesonline.processosjudiciais.domain.service.ProcessoService;
import br.com.publicacoesonline.processosjudiciais.domain.service.SuspenderProcessoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/processos")
public class ProcessoController {

    private ProcessoService processoService;
    private SuspenderProcessoService suspenderProcessoService;
    private AtivarProcessoService ativarProcessoService;
    private ConcluirProcessoService concluirProcessoService;
    private ProcessoAssembler processoAssembler;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProcessoModel salvar(@Valid @RequestBody ProcessoInput processoInput) {
        Processo processo = this.processoAssembler.toEntity(processoInput);
        return this.processoAssembler.toModel(this.processoService.salvar(processo));
    }

    @GetMapping
    public List<ProcessoModel> listar() {
        return this.processoAssembler.toCollectionModel(this.processoService.listar());
    }

    @PutMapping("{numero}")
    public ResponseEntity<ProcessoModel> atualizar(@PathVariable String numero,
                                                   @Valid @RequestBody ProcessoUpdateInput processoUpdateInput) {

        if (!this.processoService.existePorNumero(numero)) {
            return ResponseEntity.notFound().build();
        }

        Processo processo = this.processoAssembler.toEntityUpdate(processoUpdateInput);
        processo.setNumero(numero);

        return ResponseEntity.ok(this.processoAssembler.toModel(this.processoService.atualizar(processo)));
    }

    @DeleteMapping("{numero}")
    public ResponseEntity<Void> excluir(@PathVariable String numero) {
        if (!this.processoService.existePorNumero(numero)) return ResponseEntity.notFound().build();
        this.processoService.excluir(numero);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{numero}/suspender")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void suspender(@PathVariable String numero) {
        this.suspenderProcessoService.suspender(numero);
    }

    @PutMapping("{numero}/ativar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ativar(@PathVariable String numero) {
        this.ativarProcessoService.ativar(numero);
    }

    @PutMapping("{numero}/concluir")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void concluir(@PathVariable String numero) {
        this.concluirProcessoService.concluir(numero);
    }

}
