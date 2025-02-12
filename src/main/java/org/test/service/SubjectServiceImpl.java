package org.test.service;

import org.test.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }
}
