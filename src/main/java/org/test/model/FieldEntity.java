package org.test.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Node("Field")
public class FieldEntity {
    @Id
    @GeneratedValue
    private Long id; // 1 2

    private String field;

    public FieldEntity(String fields){
        this.field = fields;
    }

    public FieldEntity(Long id,String fields){
        this.id = id;
        this.field = fields;
    }
}
