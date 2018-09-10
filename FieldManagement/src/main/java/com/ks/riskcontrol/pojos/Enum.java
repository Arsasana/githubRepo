package com.ks.riskcontrol.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Enum {
    private static final Logger log= LogManager.getLogger(Entity.class);
    private  String name;
    private  String value;
    private  String label;
    private Integer f_id;
    public void setEnumValue(String parmsName,String parms) {
        if(parmsName.equals("name")) {
            setName(parms);
        }
        else if (parmsName.equals("value")) {
            setValue(parms);
        }
        else if (parmsName.equals("label")) {
            setLabel(parms);
        }
        else {
            log.info("无效字段:     Enum:"+parmsName);
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public Integer getF_id() {
        return f_id;
    }
    public void setF_id(int f_id) {
        this.f_id = f_id;
    }
    @Override
    public String toString() {
        return "Enum{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", f_id=" + f_id +
                '}';
    }
}