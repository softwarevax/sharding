package com.softwarevax.sharding.sharding.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class SqlEntity {

    private String ds;

    private String table;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SqlEntity sqlEntity = (SqlEntity) o;
        return ds.equals(sqlEntity.ds) && table.equals(sqlEntity.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ds, table);
    }
}
