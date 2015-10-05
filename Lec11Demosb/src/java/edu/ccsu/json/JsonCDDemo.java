package edu.ccsu.json;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;

/**
 *
 * @author Chad Williams
 */
public class JsonCDDemo {

    public static void main(String[] args) {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArray jsonObj = factory.createArrayBuilder()
                .add(factory.createObjectBuilder()
                        .add("artist", "Green Day")
                        .add("title", "Dookie")
                        .add("year", 1994)
                        .add("musician", factory.createArrayBuilder()
                                .add(factory.createObjectBuilder()
                                        .add("first", "Billy Joe")
                                        .add("last", "Armstrong"))
                                .add(factory.createObjectBuilder()
                                        .add("first", "Tre")
                                        .add("last", "Cool"))
                        )
                )
                .add(factory.createObjectBuilder()
                        .add("artist", "Pear Jam")
                        .add("title", "Ten")
                        .add("year", 1991)
                        .add("musician", factory.createArrayBuilder()
                                .add(factory.createObjectBuilder()
                                        .add("first", "Eddie")
                                        .add("last", "Vedder"))
                                .add(factory.createObjectBuilder()
                                        .add("first", "Mike")
                                        .add("last", "McCready"))
                        )
                )
                .build();
        System.out.println(jsonObj);
    }
}
