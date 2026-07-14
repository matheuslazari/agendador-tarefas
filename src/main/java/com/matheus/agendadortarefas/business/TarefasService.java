package com.matheus.agendadortarefas.business;

import com.matheus.agendadortarefas.business.dto.TarefasDTO;
import com.matheus.agendadortarefas.business.mapper.TarefasConverter;
import com.matheus.agendadortarefas.infraestructure.entity.TarefasEntity;
import com.matheus.agendadortarefas.infraestructure.enums.StatusNotificacaoEnum;
import com.matheus.agendadortarefas.infraestructure.repository.TarefasRepository;
import com.matheus.agendadortarefas.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefasEntity(dto);

        return tarefaConverter.paraTarefasDTO(
                tarefasRepository.save(entity));
    }
}
