package com.lixy.drawout.utils;


import com.alibaba.fastjson.JSON;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class SerializationUtil {


    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();

    private static Objenesis objenesis = new ObjenesisStd(true);

    private static <T> Schema<T> getSchema(Class<T> clazz) {
        @SuppressWarnings("unchecked")
        Schema<T> schema = (Schema<T>) cachedSchema.get(clazz);
        if (schema == null) {
            schema = RuntimeSchema.getSchema(clazz);
            if (schema != null) {
                cachedSchema.put(clazz, schema);
            }
        }
        return schema;
    }


    /**
     * 通过json序列化
     */
    public static byte[] serializerByJSON(Object obj) {
        String jsonString = JSON.toJSONString(obj);
        return serializer(jsonString);
    }


    /**
     * 通过json反序列化
     */
    public static <T> T deserializerByJSON(byte[] data, Class<T> clazz) {
        String jsonString = deserializer(data, String.class);
        return JSON.parseObject(jsonString, clazz);
    }


    /**
     * 序列化
     *
     * @param obj
     * @return
     */
    public static <T> byte[] serializer(T obj) {
        if (null == obj) {
            return null;
        }
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            if (obj instanceof List) {
                PbWrapper pbWrapper = new PbWrapper();
                pbWrapper.setList((List) obj);
                Schema<PbWrapper> schema = getSchema(PbWrapper.class);
                return ProtostuffIOUtil.toByteArray(pbWrapper, schema, buffer);
            } else if (obj instanceof Map) {
                PbWrapper pbWrapper = new PbWrapper();
                pbWrapper.setMap((Map) obj);
                Schema<PbWrapper> schema = getSchema(PbWrapper.class);
                return ProtostuffIOUtil.toByteArray(pbWrapper, schema, buffer);
            } else {
                Schema<T> schema = getSchema(clazz);
                return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
    }


    /**
     * 反序列化
     *
     * @param data
     * @param clazz
     * @return
     */
    public static <T> T deserializer(byte[] data, Class<T> clazz) {
        if (null == data) {
            return null;
        }
        try {
            if (clazz == List.class) {
                PbWrapper obj = objenesis.newInstance(PbWrapper.class);
                Schema<PbWrapper> schema = getSchema(PbWrapper.class);
                ProtostuffIOUtil.mergeFrom(data, obj, schema);
                return (T) obj.getList();
            } else if (clazz == Map.class) {
                PbWrapper obj = objenesis.newInstance(PbWrapper.class);
                Schema<PbWrapper> schema = getSchema(PbWrapper.class);
                ProtostuffIOUtil.mergeFrom(data, obj, schema);
                return (T) obj.getMap();
            } else {
                T obj = objenesis.newInstance(clazz);
                Schema<T> schema = getSchema(clazz);
                ProtostuffIOUtil.mergeFrom(data, obj, schema);
                return obj;
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

}
