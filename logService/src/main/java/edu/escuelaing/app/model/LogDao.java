package edu.escuelaing.app.model;

import java.util.Date;

public class LogDao {
    private String log;
    private Date logDate;

    public LogDao(String log, Date logDate) {
        this.log = log;
        this.logDate = logDate;
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
}
