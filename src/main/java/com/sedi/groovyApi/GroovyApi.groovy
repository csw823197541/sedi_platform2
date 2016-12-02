package com.sedi.groovyApi


/**
 * Created by liuminhang on 2016/12/2.
 */
class GroovyApi {

    private static Map<String,Class> groovyClassMap = new HashMap<>();
    private static GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

    private GroovyApi(){};

    public static Class getGroovyClassByName(String inClassName){
        return groovyClassMap.get(inClassName)
    }

    public static String putGroovyClass(String inClassContent) throws Exception{
        Class groovyClass = groovyClassLoader.parseClass(inClassContent)
        groovyClassMap.put(groovyClass.getName(),groovyClass)
        return groovyClass.getName()
    }
}
