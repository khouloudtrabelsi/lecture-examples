package de.unistuttgart.iste.pe2.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "departments")
public class Department {

    @DatabaseField(id = true)
    private Integer departmentId;

    @DatabaseField(columnName = "departmentName", defaultValue = "Unknown")
    private String departmentName;

    @DatabaseField(columnName = "managerId")
    private Integer managerId;

    /*
     * No-arguments constructor required by the OR-Mapper
     */
    public Department() {}

    public Department(Integer departmentId, String departmentName, Integer managerId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}
