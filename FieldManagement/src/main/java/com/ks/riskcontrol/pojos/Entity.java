package com.ks.riskcontrol.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Entity {
    private Integer en_id;
    private String en_entityType;
    private String en_name;
    private String en_title;
    private String en_description;
    private  String en_sourcescheme=null;
    private  String en_source=null;
    private  String en_level=null;
    private static final Logger log= LogManager.getLogger(Entity.class);
    public Entity(int en_id, String en_entityType, String en_name, String en_title, String en_description, String en_sourcescheme, String en_source, String en_level) {
        this.en_id = en_id;
        this.en_entityType = en_entityType;
        this.en_name = en_name;
        this.en_title = en_title;
        this.en_description = en_description;
        this.en_sourcescheme = en_sourcescheme;
        this.en_source = en_source;
        this.en_level = en_level;
    }
    public Entity(){}

    public void setValue(String parmsName,String parms) {
        if(parmsName.equals("name")) {
            setEn_name(parms);
        }
        else if (parmsName.equals("title")) {
            setEn_title(parms);;
        }
        else if (parmsName.equals("description")) {
            setEn_description(parms);
        }
        else {
            log.info("无效字段:     Entity:"+parmsName);
        }

    }
    public Integer getEn_id() {
        return en_id;
    }
    public void setEn_id(int en_id) {
        this.en_id = en_id;
    }
    public String getEn_entityType() {
        return en_entityType;
    }
    public void setEn_entityType(String en_entityType) {
        this.en_entityType = en_entityType;
    }
    public String getEn_name() {
        return en_name;
    }
    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }
    public String getEn_title() {
        return en_title;
    }
    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }
    public String getEn_description() {
        return en_description;
    }
    public void setEn_description(String en_description) {
        this.en_description = en_description;
    }
    public String getEn_sourceschema() {
        return en_sourcescheme;
    }
    public void setEn_sourceschema(String en_sourceschema) {
        this.en_sourcescheme = en_sourceschema;
    }
    public String getEn_source() {
        return en_source;
    }
    public void setEn_source(String en_source) {
        this.en_source = en_source;
    }
    public String getEn_level() {
        return en_level;
    }
    public void setEn_level(String en_level) {
        this.en_level = en_level;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "en_id=" + en_id +
                ", en_entityType='" + en_entityType + '\'' +
                ", en_name='" + en_name + '\'' +
                ", en_title='" + en_title + '\'' +
                ", en_description='" + en_description + '\'' +
                ", en_sourceschema='" + en_sourcescheme + '\'' +
                ", en_source='" + en_source + '\'' +
                ", en_level='" + en_level + '\'' +
                '}';
    }
}