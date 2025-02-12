package org.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Node")
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class NodeEntity {
    @Id
    @GeneratedValue
    private  Long id; // 1 2

    private  String title;

    public NodeEntity(){}

    public NodeEntity(String title){
        this.title = title;
    }
}
