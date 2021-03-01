package com.dca.heroesapi.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(value = "heroes")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    @Id
    private String id;

    private String name;
}
