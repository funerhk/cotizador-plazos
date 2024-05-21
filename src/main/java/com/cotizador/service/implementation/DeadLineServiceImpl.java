package com.cotizador.service.implementation;

import com.cotizador.entity.dto.DeadLineDto;
import com.cotizador.entity.mapper.DeadLineMapper;
import com.cotizador.entity.model.DeadLine;
import com.cotizador.entity.repository.DeadLineRepository;
import com.cotizador.exception.DeadLineNotFoundException;
import com.cotizador.service.interfaces.DeadLineService;
import com.cotizador.utils.ApiResponse;
import com.cotizador.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeadLineServiceImpl implements DeadLineService {
    @Autowired
    private DeadLineRepository deadLineRepository;

    @Override
    public DeadLineDto findById(String deadLineId) {
        DeadLine deadLine = deadLineRepository.findById(deadLineId)
                .orElseThrow(() -> new DeadLineNotFoundException(Message.DEADLINE_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now()));
        return DeadLineMapper.toDto(deadLine);
    }

    @Override
    public List<DeadLineDto> findAllDeadLines() {
        return deadLineRepository.findAll()
                .stream()
                .map((dto) -> new DeadLineDto(dto.getId(), dto.getDeadline(), dto.getNormalInterest(), dto.getPunctualInterest()))
                .toList();
    }

    @Override
    public ApiResponse delete(String deadLineId) {
        DeadLineDto deadLineDto = findById(deadLineId);
        if (deadLineDto == null) {
            throw new DeadLineNotFoundException(Message.DEADLINE_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        }
        DeadLine deadLine = new DeadLine();
        deadLine.setId(deadLineId);
        deadLine.setDeadline(deadLineDto.deadline());
        deadLine.setNormalInterest(deadLineDto.normalInterest());
        deadLine.setPunctualInterest(deadLineDto.punctualInterest());
        deadLineRepository.delete(deadLine);
        return new ApiResponse(Message.DEADLINE_DELETE_SUCCESSFULLY, 204, HttpStatus.NO_CONTENT, LocalDateTime.now());
    }

    @Override
    public ApiResponse save(DeadLineDto dto) {
        DeadLine deadLine = new DeadLine();
        deadLine.setDeadline(dto.deadline());
        deadLine.setNormalInterest(dto.normalInterest());
        deadLine.setPunctualInterest(dto.punctualInterest());
        deadLineRepository.save(deadLine);
        return new ApiResponse(Message.DEADLINE_SAVE_SUCCESSFULLY, 201, HttpStatus.CREATED, LocalDateTime.now());
    }

    @Override
    public ApiResponse update(String deadLineId, DeadLineDto dto) {
        DeadLine deadLine = deadLineRepository.findById(deadLineId)
                .orElseThrow(() -> new DeadLineNotFoundException(Message.DEADLINE_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now()));
        deadLine.setDeadline(dto.deadline());
        deadLine.setNormalInterest(dto.normalInterest());
        deadLine.setPunctualInterest(dto.punctualInterest());
        deadLineRepository.save(deadLine);
        return new ApiResponse(Message.DEADLINE_UPDATE_SUCCESSFULLY, 201, HttpStatus.OK, LocalDateTime.now());
    }
}
