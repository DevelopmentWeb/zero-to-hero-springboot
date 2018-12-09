package com.gaurav.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GitHubProject implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String orgName;

    @Column(unique = true)
    private String reopName;

    public GitHubProject(String orgName, String reopName) {
        this.orgName = orgName;
        this.reopName = reopName;
    }

    public GitHubProject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getReopName() {
        return reopName;
    }

    public void setReopName(String reopName) {
        this.reopName = reopName;
    }

    @Override
    public String toString() {
        return "com.gaurav.events.GitHubProject{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", reopName='" + reopName + '\'' +
                '}';
    }
}