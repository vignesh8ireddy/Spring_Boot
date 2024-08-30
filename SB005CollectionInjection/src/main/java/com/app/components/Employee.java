package com.app.components;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@ConfigurationProperties(prefix = "emp.info")
public class Employee {
    private String name;
    private long id;
    private Company company;
    private String[] skillSet;
    private List<String> projectNames;
    private Set<Long> mobileNumbers;
    private Map<String, Object> idDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String[] getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(String[] skillSet) {
        this.skillSet = skillSet;
    }

    public List<String> getProjectNames() {
        return projectNames;
    }

    public void setProjectNames(List<String> projectNames) {
        this.projectNames = projectNames;
    }

    public Set<Long> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(Set<Long> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Map<String, Object> getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(Map<String, Object> idDetails) {
        this.idDetails = idDetails;
    }

    @Override
    public String toString() {
        return id+", "+name+", "+company.getName()+", "+company.getLocation()+", "+company.getType()
                +", "+skillSet+", "+projectNames+", "+mobileNumbers+", "+idDetails;
    }
}
