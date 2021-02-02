package com.mvnikitin.architect.lesson4.composite;

public class OrgApp {

    public static void main(String[] args) {

        OrganizationUnit root = new Unit()
                .named("The Company").managedBy("Mr John Smith Jr.");
        root.addSubunit(new Unit().named("Marketing").staffOf(3));
        root.addSubunit(new Unit().named("Sales").staffOf(50));
        root.addSubunit(new Unit().named("Accounting").staffOf(3));
        root.addSubunit(new Unit().named("HR").staffOf(3));

        OrganizationUnit operations = new Unit().named("Operations").staffOf(2);
        root.addSubunit(operations);

        operations.addSubunit(new Unit().named("Product Development").staffOf(5));
        operations.addSubunit(new Unit().named("Manufacturing").staffOf(47));
        operations.addSubunit(new Unit().named("Maintenance").staffOf(11));

        showOrganization(root, "");
        System.out.println("\n----------------------");
        System.out.println("Total subunits: " + root.getTotalSubunitsCount());
        System.out.println("Total employees: " + root.getTotalEmployeesNumber());
    }

    private static void showOrganization(OrganizationUnit unit, String prefix) {
        if (prefix != null && !prefix.isBlank()) {
            System.out.print("+");
        }
        System.out.println(prefix + unit.getName());

        int subunitsCount = unit.getSubunitsCount();
        for (int i  = 0; i < subunitsCount; i++) {
            showOrganization(unit.getSubunit(i), "--" + prefix);
        }
    }
}
