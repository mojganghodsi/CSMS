package com.hastobe.csms;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/***
 * Interface in order to:
 * map json to java object
 * map java object to json
 */
public interface JsonMapper {
    /***
     * json to java object mapper
     * @param obj, java object
     * @return json object
     * @throws JsonProcessingException
     */
    default String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    /***
     * java object to json mapper
     * @param json
     * @param clazz
     * @param <T>
     * @return java object
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    default <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }
}
