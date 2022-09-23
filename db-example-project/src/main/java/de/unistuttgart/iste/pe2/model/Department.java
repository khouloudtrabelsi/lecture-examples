package de.unistuttgart.iste.pe2.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ABTEILUNG")
public class Department {

@DatabaseField(id = true)
private Integer departmentNr;

@DatabaseField(columnName = "BEZEICHNUNG", defaultValue = "Unknown")
private String name;

@DatabaseField(columnName = "ABTEILUNGSLEITER")
private Integer manager;

    /*
    * No-arguments constructor required by the OR-Mapper
    */
    public Department() {
    }

    public Department(Integer departmentNr, String name, Integer manager) {
        this.departmentNr = departmentNr;
        this.name = name;
        this.manager = manager;
    }

    public Integer getDepartmentNr() {
        return departmentNr;
    }

    public void setDepartmentNr(Integer departmentNr) {
        this.departmentNr = departmentNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

}