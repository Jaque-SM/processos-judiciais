package br.com.publicacoesonline.processosjudiciais.api.assembler;

import br.com.publicacoesonline.processosjudiciais.api.dto.ProcessoModel;
import br.com.publicacoesonline.processosjudiciais.api.dto.input.ProcessoInput;
import br.com.publicacoesonline.processosjudiciais.api.dto.input.ProcessoUpdateInput;
import br.com.publicacoesonline.processosjudiciais.domain.model.Processo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProcessoAssembler {

    private ModelMapper modelMapper;

    public ProcessoModel toModel(Processo processo) {
        return this.modelMapper.map(processo, ProcessoModel.class);
    }

    public Processo toEntity(ProcessoInput processoInput) {
        return this.modelMapper.map(processoInput, Processo.class);
    }

    public Processo toEntityUpdate(ProcessoUpdateInput processoUpdateInput) {
        return this.modelMapper.map(processoUpdateInput, Processo.class);
    }

    public List<ProcessoModel> toCollectionModel(List<Processo> processos) {
        return processos.stream().map(this::toModel)
                .collect(Collectors.toList());
    }

}
