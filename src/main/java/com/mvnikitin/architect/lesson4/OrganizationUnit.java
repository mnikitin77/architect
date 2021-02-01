package com.mvnikitin.architect.lesson4;

public interface OrganizationUnit {
    void add(OrganizationUnit unit);
    void remove(OrganizationUnit unit);
    OrganizationUnit getChild(int index);
    OrganizationUnit getParent();
    int getChildrenCount();

    // Operations
    void setEmployeesNumber(int number);
    int getEmployeesNumber();
    int getTotalEmployeesNumber();
    void setExecutiveName(String name);
    String getExecutiveName();
}
