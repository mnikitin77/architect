package com.mvnikitin.architect.lesson4.composite;

public interface OrganizationUnit {
    void addSubunit(OrganizationUnit unit);
    void removeSubunit(OrganizationUnit unit);
    void setParentUnit(OrganizationUnit unit);
    OrganizationUnit getSubunit(int index);
    OrganizationUnit getParentUnit();

    // Operations
    void setName(String name);
    String getName();
    int getSubunitsCount();
    int getTotalSubunitsCount();
    void setEmployeesNumber(int number);
    int getEmployeesNumber();
    int getTotalEmployeesNumber();
    void setExecutiveName(String name);
    String getExecutiveName();
}
