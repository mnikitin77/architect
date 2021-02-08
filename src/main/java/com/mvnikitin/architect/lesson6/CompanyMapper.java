package com.mvnikitin.architect.lesson6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper {

    private final Connection conn;

    private PreparedStatement findByIdStmt;
    private PreparedStatement insertStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement deleteStmt;


    public CompanyMapper(Connection conn) throws SQLException {
        this.conn = conn;

        findByIdStmt = conn.prepareStatement(
                "SELECT id, name, contact_name, industry, phone, email, " +
                        "hq_address, reg_address FROM company " +
                        "WHERE id = ?");

        insertStmt = conn.prepareStatement(
                "INSERT INTO company VALUES (NEXTVAL('company_id_seq'), " +
                        "?, ?, ?, ?, ?, ?, ?) RETURNING id");

        updateStmt = conn.prepareStatement(
                "UPDATE company SET name = ?, contact_name = ?, industry = ?" +
                        ", phone = ?, email = ?, hq_address = ?, reg_address = ?" +
                        " WHERE id = ?");

        deleteStmt = conn.prepareStatement(
                "DELETE FROM company WHERE id = ?");
    }

    public Company findById(int id) throws SQLException {

        Company company = CompanyIdentityMapper.getInstance().get(id);

        if (company == null) {

            findByIdStmt.setInt(1, id);

            try (ResultSet rs = findByIdStmt.executeQuery()) {
                while (rs.next()) {
                    company = new Company();
                    company.setId(rs.getInt(1));
                    company.setName(rs.getString(2));
                    company.setContactName(rs.getString(3));
                    company.setIndustry(rs.getString(4));
                    company.setPhone(rs.getString(5));
                    company.setEmail(rs.getString(6));
                    company.setHqAddress(rs.getString(7));
                    company.setRegisterAddress(rs.getString(8));

                    CompanyIdentityMapper.getInstance().put(company);
                }
            }
        }

        return company;
    }

    public void insert(Company company) throws SQLException {

        insertStmt.setString(1, company.getName());
        insertStmt.setString(2, company.getContactName());
        insertStmt.setString(3, company.getIndustry());
        insertStmt.setString(4, company.getPhone());
        insertStmt.setString(5, company.getEmail());
        insertStmt.setString(6, company.getHqAddress());
        insertStmt.setString(7, company.getRegisterAddress());

        if (insertStmt.execute()) {
            try (ResultSet rs = insertStmt.getResultSet()) {
                if (rs.next()) {
                    Company newCompany = new Company();
                    newCompany.setId(rs.getInt(1));

                    newCompany.setName(company.getName());
                    newCompany.setContactName(company.getContactName());
                    newCompany.setIndustry(company.getIndustry());
                    newCompany.setPhone(company.getPhone());
                    newCompany.setEmail(company.getEmail());
                    newCompany.setHqAddress(company.getHqAddress());
                    newCompany.setRegisterAddress(company.getRegisterAddress());

                    CompanyIdentityMapper.getInstance().put(newCompany);
                }
            }
        }
    }

    public void update(Company company) throws SQLException {

        updateStmt.setString(1, company.getName());
        updateStmt.setString(2, company.getContactName());
        updateStmt.setString(3, company.getIndustry());
        updateStmt.setString(4, company.getPhone());
        updateStmt.setString(5, company.getEmail());
        updateStmt.setString(6, company.getHqAddress());
        updateStmt.setString(7, company.getRegisterAddress());
        updateStmt.setInt(8, company.getId());

        updateStmt.execute();

        CompanyIdentityMapper.getInstance().put(company);
    }

    public void delete(Company company) throws SQLException {

        CompanyIdentityMapper.getInstance().delete(company);

        deleteStmt.setInt(1, company.getId());
        deleteStmt.execute();
    }
}
