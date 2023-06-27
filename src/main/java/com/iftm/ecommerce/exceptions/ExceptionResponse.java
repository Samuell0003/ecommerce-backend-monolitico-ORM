package com.iftm.ecommerce.exceptions;

import java.io.Serializable;
import java.util.Date;


public class ExceptionResponse implements Serializable {
    private Date timestamp;
    private String message;
    private String datails;

    
    public ExceptionResponse(Date timestamp, String message, String datails) {
        this.timestamp = timestamp;
        this.message = message;
        this.datails = datails;
    }

    public ExceptionResponse() {}
     
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((datails == null) ? 0 : datails.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ExceptionResponse other = (ExceptionResponse) obj;
        if (timestamp == null) {
            if (other.timestamp != null)
                return false;
        } else if (!timestamp.equals(other.timestamp))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (datails == null) {
            if (other.datails != null)
                return false;
        } else if (!datails.equals(other.datails))
            return false;
        return true;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDatails() {
        return datails;
    }
    public void setDatails(String datails) {
        this.datails = datails;
    }


    
}
