package com.li.knowledge.utils.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wyp on 2017/03/05.
 * JSON工具类
 */
public final class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);
    public static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 序列化一个对象为JSON字符串
     *
     * @param o 对象
     * @return JSON字符串
     */
    public static String toJSONString(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            LOGGER.error("序列化对象为JSON字符串时发生问题", ex);
        }
        return "";
    }

    /**
     * 将一个对象转换为一个Map
     *
     * @param o 对象
     * @return Map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(Object o) {
        return MAPPER.convertValue(o, Map.class);
    }

    /**
     * 将一个json字符串转换为一个Map
     *
     * @param jsonStr json字符串
     * @return Map
     */
    public static Map<String, Object> readValueToMap(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) return new HashMap<>();

        try {
            return MAPPER.readValue(jsonStr, new TypeReference<HashMap<String, Object>>() {
            });
        } catch (IOException e) {
            LOGGER.error("序列化JSON字符串为对象时发生问题", e);
            return new HashMap<>();
        }
    }

    public static <T> Map<String, T> readValueToMapWithType(String jsonStr, Class<?> resultClass) {
        if (StringUtils.isEmpty(jsonStr)) return new HashMap<>();

        try {
            return MAPPER.readValue(jsonStr,
                    MAPPER.getTypeFactory().constructMapType(Map.class, String.class, resultClass));
        } catch (IOException e) {
            LOGGER.error("反序列化字符串: " + jsonStr + " 发生了问题", e);
            return new HashMap<>();
        }
    }

    public static <T> T parseObject(String jsonStr, Class<T> resultClass) {
        if (StringUtils.isEmpty(jsonStr)) return null;

        try {
            return MAPPER.readValue(jsonStr, resultClass);
        } catch (IOException e) {
            LOGGER.error("反序列化字符串: " + jsonStr + " 发生了问题", e);
            return null;
        }
    }

    public static <T> List<T> toList(String jsonStr, Class<?> resultClass) {
        if (StringUtils.isEmpty(jsonStr)) return null;

        try {
            return MAPPER.readValue(jsonStr,
                    MAPPER.getTypeFactory().constructCollectionType(List.class, resultClass));
        } catch (IOException e) {
            LOGGER.error("反序列化字符串: " + jsonStr + " 发生了问题", e);

            return null;
        }
    }

    /**
     * 转换为 List<LinkedHashMap<String, Object>> 对象
     *
     * @param jsonStr json字符串
     * @return List<LinkedHashMap<String, Object>> 对象
     */
    public static List<LinkedHashMap<String, Object>> toList(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) return null;

        try {
            return MAPPER.readValue(jsonStr, new TypeReference<List<LinkedHashMap<String, Object>>>() {
            });
        } catch (IOException e) {
            LOGGER.error("反序列化字符串: " + jsonStr + " 发生了问题", e);

            return null;
        }
    }
}
