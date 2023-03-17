package edu.escuelaing.app.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("Log")
public class Log {
    @Id
    private ObjectId id;
    private String log;
    private Date logDate;

    public Log(){

    }

    public Log(ObjectId id, String log, Date logDate) {
        this.id = id;
        this.log = log;
        this.logDate = logDate;
    }

    public Log(LogDao logDao){
        this.log = logDao.getLog();
        this.logDate = logDao.getLogDate();
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
