package com.devops.dto;

import com.devops.entity.UserTable;
import com.univocity.parsers.annotations.Parsed;

import java.util.Objects;

public class UserDTO {

    private String name;
    @Parsed(index = 0)
    private String address;
    @Parsed(index = 1)
    private int age;
    @Parsed(index = 2)
    private String phone;

    public UserDTO() {
    }

    public UserDTO(String name,
                           String address,
                           int age,
                           String phone) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.phone = phone;
    }

    public static UserDTO instanceOf(UserTable UserTable) {
        return new UserDTO(
        		UserTable.getUserPrimaryKey().getName(),
        		UserTable.getUserPrimaryKey().getAddress(),
        		UserTable.getUserPrimaryKey().getAge(),
        		UserTable.getUserPrimaryKey().getPhone()
        );
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
        UserDTO that = (UserDTO) o;
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
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
