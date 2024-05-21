package com.cotizador.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "deadLines")
public class DeadLine {
    @Id
    private String id;
    private String deadline;
    private String normalInterest;
    private String punctualInterest;

}
