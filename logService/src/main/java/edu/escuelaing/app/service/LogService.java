package edu.escuelaing.app.service;

import edu.escuelaing.app.model.Log;
import edu.escuelaing.app.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@EnableMongoRepositories
@Service
public class LogService {
    @Autowired
    LogRepository logRepository;
    public List<Log> getLastLogs(){
        List<Log> logs = logRepository.findAll();
        if (logs.size()<10){
            return logs;
        }
        else {
            return logs.subList(logs.size()-10,logs.size());
        }
    }

    public void createLog(Log log){
        logRepository.save(log);
    }
}
