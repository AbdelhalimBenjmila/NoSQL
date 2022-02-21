package com.devops.entity;


import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.devops.dto.UserDTO;

import java.io.Serializable;
import java.util.Objects;

@Table("user")
public class UserTable {

    @PrimaryKey
    private UserPrimaryKey UserPrimaryKey;

    public UserTable() {
    }

    public UserTable(String name,
                        String address,
                        int age,
                        String phone) {
        this.UserPrimaryKey = new UserPrimaryKey(
        		name,
                address,
                age,
                phone);
    }

    public static UserTable instanceOf(UserDTO UserDTO) {
        return new UserTable(
        		UserDTO.getName(),
        		UserDTO.getAddress(),
        		UserDTO.getAge(),
        		UserDTO.getPhone());
    }

    public UserPrimaryKey getUserPrimaryKey() {
        return UserPrimaryKey;
    }

    @Override
    public String toString() {
        return "UserPrimaryKey{" +
                "UserPrimaryKey=" + UserPrimaryKey +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTable ExampleTable = (UserTable) o;

        return UserPrimaryKey.equals(ExampleTable.UserPrimaryKey);
    }

    @Override
    public int hashCode() {
        return UserPrimaryKey.hashCode();
    }

    @PrimaryKeyClass
    public static class UserPrimaryKey implements Serializable {

        @PrimaryKeyColumn(name = "name", type = PrimaryKeyType.PARTITIONED)
        private String name;
        @PrimaryKeyColumn(name = "address", type = PrimaryKeyType.CLUSTERED)
        private String address;
        @PrimaryKeyColumn(name = "age", type = PrimaryKeyType.CLUSTERED)
        private int age;
        @PrimaryKeyColumn(name = "phone", type = PrimaryKeyType.CLUSTERED)
        private String phone;

        public UserPrimaryKey(String name,
                                      String address,
                                      int age,
                                      String phone) {
            this.name = name;
            this.address = address;
            this.age = age;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserPrimaryKey that = (UserPrimaryKey) o;
            return age == that.age &&
            		phone == that.phone &&
                    Objects.equals(name, that.name) &&
                    Objects.equals(address, that.address);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, address, age, phone);
        }

        @Override
        public String toString() {
            return "UserPrimaryKey{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", age=" + age +
                    ", phone=" + phone +
                    '}';
        }
    }

}
