package org.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
@Data
@AllArgsConstructor
@Accessors(chain = true)
@Node("Subject")
public class Subject {
    @Id
    @GeneratedValue
    private  Long id;

    private String name;
}
