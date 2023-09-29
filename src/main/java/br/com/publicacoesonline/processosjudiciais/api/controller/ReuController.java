package br.com.publicacoesonline.processosjudiciais.api.controller;

import br.com.publicacoesonline.processosjudiciais.api.assembler.ReuAssembler;
import br.com.publicacoesonline.processosjudiciais.api.dto.ReuModel;
import br.com.publicacoesonline.processosjudiciais.api.dto.input.ReuInput;
import br.com.publicacoesonline.processosjudiciais.domain.model.Reu;
import br.com.publicacoesonline.processosjudiciais.domain.service.ReuService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/reus")
public class ReuController {

    private ReuService reuService;
    private ReuAssembler reuAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReuModel cadastrar(@Valid @RequestBody ReuInput reuInput) {
        Reu novoReu = reuAssembler.toEntity(reuInput);
        return reuAssembler.toModel(this.reuService.cadastrar(novoReu));
    }

}
