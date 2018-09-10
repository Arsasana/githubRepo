package com.ks.riskcontrol.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FieldType {
    private Integer f_id;
    private String typeName;
    private  String label;
    private String type;
    private Integer length;
    private String prefix;
    private Integer precision;
    private static final Logger log= LogManager.getLogger(Entity.class);
    public void set_value(String parmsName,String parms) {
        if(parmsName.equals("typename")) {
            setTypeName(parms);
        }
        else if (parmsName.equals("label")) {
            setLable(parms);
        }
        else if (parmsName.equals("length")) {
            setLength(Integer.parseInt(parms));
        }
        else if (parmsName.equals("prefix")) {
            setPrefix(parms);
        }
        else if (parmsName.equals("precision")) {
            setPrecision(Integer.parseInt(parms));
        }
        else {
            log.info("无效字段:     FieldType:"+parmsName);
        }
    }
    public Integer getF_id() {
        return f_id;
    }
    public void setF_id(int f_id) {
        this.f_id = f_id;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getLable() {
        return label;
    }
    public void setLable(String lable) {
        this.label = lable;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public Integer getPrecision() {
        return precision;
    }
    public void setPrecision(int precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        return "FieldType{" +
                "f_id=" + f_id +
                ", typeName='" + typeName + '\'' +
                ", lable='" + label + '\'' +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", prefix='" + prefix + '\'' +
                ", precision=" + precision +
                '}';
    }
}