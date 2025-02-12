package org.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.test.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.service.CsvImporterService;
import org.test.service.SubjectService;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CsvImporterService csvImporterService;

    @PutMapping("/create")
    public Subject create(@RequestBody Subject subject) {
        return subjectService.save(subject);
    }


    @GetMapping("/test")
    public void test(){
        csvImporterService.importData();
    }
}