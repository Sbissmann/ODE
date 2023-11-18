package at.uastw;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LibrarySerde implements Serde {


    ObjectMapper mapper= new ObjectMapper();

    String JSONString;

    @Override
    public String serializeLibrary(Library library) {


        try {
            JSONString= mapper.writeValueAsString(library);
        } catch (JsonProcessingException e) {
            System.out.println("Failure");
        }

    return JSONString;
    }

    @Override
    public Library deserializeLibrary(String libraryJson) {

        Library mylib;
        try {
            mylib = mapper.readValue(libraryJson, Library.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return mylib;

    }
}