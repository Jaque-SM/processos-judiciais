package br.com.publicacoesonline.processosjudiciais.api.assembler;


import br.com.publicacoesonline.processosjudiciais.api.dto.ReuModel;
import br.com.publicacoesonline.processosjudiciais.api.dto.input.ReuInput;
import br.com.publicacoesonline.processosjudiciais.domain.model.Reu;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ReuAssembler {

    private ModelMapper modelMapper;

    public ReuModel toModel(Reu reu) {
        return this.modelMapper.map(reu, ReuModel.class);
    }

    public Reu toEntity(ReuInput reuInput) {
        return this.modelMapper.map(reuInput, Reu.class);
    }

}
