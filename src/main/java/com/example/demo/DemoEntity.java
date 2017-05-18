package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DemoEntity {
    public DemoEntity() {
    }

    public DemoEntity(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Integer getStatus() {
        return status;
    }

    private String  displayName;

    public void setId(String id) {
        this.id = id;
    }

    private Integer status;

    @Id
    private String id;

    public String getId() {
        return id;
    }


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }




}
