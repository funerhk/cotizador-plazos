package com.cotizador.service.interfaces;

import com.cotizador.entity.dto.DeadLineDto;
import com.cotizador.utils.ApiResponse;

import java.util.List;

public interface DeadLineService {
    DeadLineDto findById(String deadLineId);
    List<DeadLineDto> findAllDeadLines();
    ApiResponse delete(String deadLineId);
    ApiResponse save(DeadLineDto dto);
    ApiResponse update(String deadLineId, DeadLineDto dto);
}
