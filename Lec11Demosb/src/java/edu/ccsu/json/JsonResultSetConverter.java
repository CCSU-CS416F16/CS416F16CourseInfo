package edu.ccsu.json;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;

public class JsonResultSetConverter {

    public static JsonArray convert(ResultSet rs)
            throws SQLException {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
        ResultSetMetaData rsmd = rs.getMetaData();

        while (rs.next()) {
            int numColumns = rsmd.getColumnCount();
            JsonObjectBuilder objBuilder = Json.createObjectBuilder();

            for (int i = 1; i < numColumns + 1; i++) {
                String column_name = rsmd.getColumnName(i);
                if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
                    objBuilder.add(column_name, rs.getInt(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
                    objBuilder.add(column_name, rs.getBoolean(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
                    objBuilder.add(column_name, rs.getDouble(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.FLOAT) {
                    objBuilder.add(column_name, rs.getFloat(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
                    objBuilder.add(column_name, rs.getInt(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.NVARCHAR) {
                    objBuilder.add(column_name, rs.getNString(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {
                    objBuilder.add(column_name, rs.getString(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.TINYINT) {
                    objBuilder.add(column_name, rs.getInt(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.SMALLINT) {
                    objBuilder.add(column_name, rs.getInt(column_name));
                } else {
                    objBuilder.add(column_name, rs.getObject(column_name).toString());
                }
            }
            arrayBuilder.add(objBuilder.build());
        }
        return arrayBuilder.build();
    }
}
