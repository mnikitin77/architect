package com.mvnikitin.architect.lesson6;

import java.util.HashMap;
import java.util.Map;

public class CompanyIdentityMapper {

    private final static CompanyIdentityMapper INSTANCE =
            new CompanyIdentityMapper();

    private static Map<Integer, Company> companies = new HashMap<>();

    private CompanyIdentityMapper() {};

    public static CompanyIdentityMapper getInstance() {
        return INSTANCE;
    }

    public synchronized Company get(int id) {
        return companies.get(id);
    }

    public synchronized void put(Company company) {
        companies.put(company.getId(), company);
    }

    public synchronized void delete(Company company) {
        companies.remove(company.getId());
    }
}
