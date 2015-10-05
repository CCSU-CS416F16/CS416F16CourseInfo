package edu.ccsu.json;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

/**
 *
 * @author Chad Williams
 */
public class JsonDemo {

    public static void main(String[] args) {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject jsonObj = factory.createObjectBuilder()
                .add("firstName", "John")
                .add("lastName", "Doe")
                .add("age", 25)
                .add("address", factory.createObjectBuilder()
                        .add("street", "1 Main St.")
                        .add("city", "New Britain")
                        .add("state", "CT")
                        .add("zipCode", "06050"))
                .add("phoneNumber", factory.createArrayBuilder()
                        .add(factory.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "860 867-5309"))
                        .add(factory.createObjectBuilder()
                                .add("type", "fax")
                                .add("number", "860 123-4567")))
                .build();
        System.out.println(jsonObj);
    }
}
