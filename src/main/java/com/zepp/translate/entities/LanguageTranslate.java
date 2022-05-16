package com.zepp.translate.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LanguageTranslate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String source;
    @Column(unique = true, nullable = false)
    private String target;
    @Column(unique = true, nullable = false)
    private String targetLangName;

    private String output;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Version
    private int version;

    public LanguageTranslate() {
        this.source = "en";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public int getVersion() {
        return version;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    public void setSource(String source) {
        this.source = source;
    }
}
