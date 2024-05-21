package com.cotizador.entity.mapper;

import com.cotizador.entity.dto.DeadLineDto;
import com.cotizador.entity.model.DeadLine;

public class DeadLineMapper {
    public static DeadLineDto toDto(DeadLine deadLine) {
        return new DeadLineDto(deadLine.getId(), deadLine.getDeadline(), deadLine.getNormalInterest(), deadLine.getPunctualInterest());
    }
    public static DeadLine toEntity(DeadLineDto deadlineDto) {
        DeadLine deadline = new DeadLine();
        deadline.setId(deadline.getId());
        deadline.setDeadline(deadline.getDeadline());
        deadline.setNormalInterest(deadline.getNormalInterest());
        deadline.setPunctualInterest(deadline.getPunctualInterest());
        return deadline;
    }
}
