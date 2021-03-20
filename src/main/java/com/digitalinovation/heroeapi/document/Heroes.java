package com.digitalinovation.heroeapi.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName= "heroes_table")
public class Heroes {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;
    @DynamoDBAttribute(attributeName = "nome")
    private String nome;
    @DynamoDBHashKey(attributeName = "universo")
    private String universo;
    @DynamoDBHashKey(attributeName = "filmes")
    private int filmes;
}
