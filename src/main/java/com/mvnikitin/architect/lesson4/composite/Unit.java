package com.mvnikitin.architect.lesson4.composite;

import java.util.ArrayList;
import java.util.List;

public class Unit implements OrganizationUnit {

    List<OrganizationUnit> subUnits;
    OrganizationUnit parentUnit;

    String name;
    int stuff;
    String executiveName;

    public Unit named(String name) {
        this.name = name;
        return this;
    }

    public Unit managedBy(String name) {
        executiveName = name;
        return this;
    }

    public Unit staffOf(int number) {
        stuff = number;
        return this;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addSubunit(OrganizationUnit unit) {
        if (subUnits == null) {
            subUnits = new ArrayList<>();
        }
        unit.setParentUnit(this);
        subUnits.add(unit);
    }

    @Override
    public void removeSubunit(OrganizationUnit unit) {
        if (subUnits != null) {
            subUnits.remove(unit);
        }
    }

    @Override
    public void setParentUnit(OrganizationUnit unit) {
        parentUnit = unit;
    }

    @Override
    public OrganizationUnit getSubunit(int index) {
        return subUnits != null ? subUnits.get(index) : null;
    }

    @Override
    public OrganizationUnit getParentUnit() {
        return parentUnit;
    }

    @Override
    public int getSubunitsCount() {
        return subUnits != null ? subUnits.size() : 0;
    }

    @Override
    public int getTotalSubunitsCount() {
        int count = 0;

        if (subUnits != null) {
            count += subUnits.size();
            for (OrganizationUnit unit: subUnits) {
                count += unit.getSubunitsCount();
            }
        }

        return count;
    }

    @Override
    public void setEmployeesNumber(int number) {
        stuff = number;
    }

    @Override
    public int getEmployeesNumber() {
        return stuff;
    }

    @Override
    public int getTotalEmployeesNumber() {
        int count = stuff;

        if (subUnits != null) {
            for (OrganizationUnit unit: subUnits) {
                count += unit.getTotalEmployeesNumber();
            }
        }

        return count;
    }

    @Override
    public void setExecutiveName(String name) {
        executiveName = name;
    }

    @Override
    public String getExecutiveName() {
        return executiveName;
    }
}
