package com.cefalo.newstestproject.module.news.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude
public class GenereicResponseDTO {

    @NotNull
    @XmlElement(name = "statusCode")
    protected String statusCode;

    @NotNull
    @XmlElement(name = "message")
    protected String message;

    @XmlElement(name = "exceptionMessage")
    protected String exceptionMessage = "No Exception" ;


    public GenereicResponseDTO() {
    }

    public GenereicResponseDTO(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public GenereicResponseDTO(String statusCode, String message, String exceptionMessage) {
        this.statusCode = statusCode;
        this.message = message;
        this.exceptionMessage = exceptionMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "GenereicResponseDTO{" +
                "statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }
}
