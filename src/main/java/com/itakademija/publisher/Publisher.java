package com.itakademija.publisher;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Publisher implements Serializable {
    private Long id;
    private String name;
    private String address;

    public Publisher() {
    }

    public Publisher(String address, String name, Long id) {
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Publisher.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("address='" + address + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher publisher)) return false;
        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
