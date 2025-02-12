package org.test.service;

import org.springframework.stereotype.Service;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
@Service
public class CsvImporterServiceImpl implements CsvImporterService{
    @Autowired
    private Driver driver;


    private String path = "src/main/resources/csv/";


    @Override
    public void importData() {
        // 先清空所有
        Session session = driver.session();
        session.run("match (n) detach delete n");

        // 顺序最好不要乱 先创建节点 再出创建关系 2和3颠倒无所谓
        createNode(path+"2.csv",session);
        createNode(path+"3.csv",session);
        createNode(path+"1.csv",session);

    }

    public void createNode(String filePath,Session session) {
        String sql = "";

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            for (CSVRecord record : csvParser) {
                if("src/main/resources/csv/3.csv".equals(filePath)){ // 2
                    sql = String.format(" MERGE   (:Node {title:\"%s\"})", record.get("name"));
                }
                if("src/main/resources/csv/2.csv".equals(filePath)){ // 3
                    // 注意这里的节点是Field
                    sql = String.format(" MERGE  (:Field {field:\"%s\"})", record.get("name"));
                }
                if("src/main/resources/csv/1.csv".equals(filePath)){ // 1
                        //       这里是创建关系 在创建关系的前提要先创建节点
                        //       这样会创建出来很多孤岛
                        ////     sql = String.format("CREATE (b:Node {title:\"%s\"}) - [r:belong] -> (a:Node {title:\"%s\"})  ",record.get("node1"),record.get("node2"));
                        sql = String.format(" match(a:Node),(b:Field) where a.title=\"%s\" and b.field=\"%s\" create  (b)-[r:PROPERTIES {description:\"%s\"}]->(a)",record.get("node1"),record.get("node2"),record.get("label"));
                }
                // 都放这里执行
                System.out.println("sql:"+sql);
                session.run(sql);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
