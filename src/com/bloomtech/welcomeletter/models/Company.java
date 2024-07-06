package com.bloomtech.welcomeletter.models;

public class Company {
    private static int maxId = 1;
    private int id;

    private String companyname;
    private String country;

    public static Builder builder() {
        return new Builder();
    }

    private Company(Builder builder) {
        this.id = builder.id == 0 ? maxId++ : builder.id;
        this.companyname = builder.companyname;
        this.country = builder.country;
    }

    public static final class Builder {

        private static int maxId = 1;
        private int id;

        private String companyname;
        private String country;

        public Builder withID(int id) {
            this.id = id;
            return this;
        }

        public Builder withCompanyname(String companyname) {
            this.companyname = companyname;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Company build() {
            //Auto-generate an id
            id = maxId;
            maxId++;

            return new Company(this);
        }

    }

    public int getId() {
        return id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getCountry() {
        return country;
    }
}
