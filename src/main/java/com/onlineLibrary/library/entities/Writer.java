package com.onlineLibrary.library.entities;

import java.sql.Date;

public class Writer {
    private int id;
    private Date birthday;
    private String fullName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Writer writer = (Writer) o;

        if (id != writer.id) return false;
        if (birthday != null ? !birthday.equals(writer.birthday) : writer.birthday != null) return false;
        if (fullName != null ? !fullName.equals(writer.fullName) : writer.fullName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }
}
