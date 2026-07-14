package com.matheus.agendadortarefas.business.mapper;

import com.matheus.agendadortarefas.business.dto.TarefasDTO;
import com.matheus.agendadortarefas.infraestructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateDeTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
