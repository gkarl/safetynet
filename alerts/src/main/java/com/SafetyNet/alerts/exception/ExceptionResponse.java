package com.SafetyNet.alerts.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private int    status;
    private String error;
    private String path;

    public ExceptionResponse(Date ptimestamp, int pstatus, String perror, String ppath) {
        timestamp = ptimestamp;
        status    = pstatus;
        error     = perror;
        path      = ppath;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date ptimestamp) {
        timestamp = ptimestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "{" + "timestamp=" + timestamp + ", status=" + status + ", error='" + error + '\'' + ", path='" + path + '\'' + '}';
    }
}
