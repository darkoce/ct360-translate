package com.zepp.translate.entities.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

public class LanguageTranslateRequest {
    private long id;
    private String source;
    //@NotBlank(message = "code jezika na koji se prevodi ne sme biti blanko!!!")
    private String target;
    //@NotBlank(message = "Naziv jezika na koji se prevodi ne sme biti blanko!!!")
    private String targetLangName;

    //@NotBlank(message = "Prevod ne sme biti blanko!!!")
    private String output;

    //@Null(message = "Datum kreiranja mašine mora biti 'null'!!!")
    private Date createdAt;

    //@Null(message = "Datum update-a mašine mora biti 'null'!!!")
    private Date updateDate;

    private int version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetLangName() {
        return targetLangName;
    }

    public void setTargetLangName(String targetLangName) {
        this.targetLangName = targetLangName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
