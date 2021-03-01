package com.dca.heroesapi.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(value = "heroes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    @Id
    private String id;

    private String name;
}
