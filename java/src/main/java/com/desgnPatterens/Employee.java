package com.desgnPatterens;

public  class Employee {

    public static class  Builder {
        String id;
        String name;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.id = this.id;
            employee.name = this.name;
            return employee;
        }

    }

    private String id;
    private String name;

    public Builder builder() {
        return new Builder();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
