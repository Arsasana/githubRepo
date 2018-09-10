package com.ks.riskcontrol.pojos;


import com.ks.riskcontrol.services.FieldService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FieldList {
    private static final Logger log= LogManager.getLogger(Entity.class);
    private   Integer en_id ;
    private  Integer f_id ;
    private    String fl_name ;
    private   String fl_notnull ;
    private   String fl_label ;
    private  String fl_description ;
    private   String fl_iskey;
    private  String fl_isvisible;
    private static FieldService fieldService=new FieldService();

    public void setValue(String parmsName, String parms) {
        if(parmsName.equals("type")) {
            setF_id(parms);
        }
        else if (parmsName.equals("label")) {
            setFl_label(parms);
        }
        else if (parmsName.equals("name")) {
            setFl_name((parms));
        }
        else if (parmsName.equals("description")) {
            setFl_description(parms);
        }
        else if (parmsName.equals("notnull")) {
            setFl_notnull(parms);
        }
        else if (parmsName.equals("iskey")) {
            setFl_iskey(parms);
        }
        else if (parmsName.equals("isvisible")) {
            setFl_isvisible(parms);
        }
        else {
            log.info("无效字段:     FieldList:"+parmsName);
        }

    }

    public String getFl_isvisible() {
        return fl_isvisible;
    }
    public void setFl_isvisible(String fl_isvisible) {
        this.fl_isvisible = fl_isvisible;
    }
    public String getFl_iskey() {
        return fl_iskey;
    }
    public void setFl_iskey(String fl_iskey) {
        this.fl_iskey = fl_iskey;
    }
    public void setF_id(String parms) {
        this.f_id = FieldService.getFId(parms);
    }
    public int getF_id() {
        return f_id;
    }
    public int getEn_id() {
        return en_id;
    }
    public void setEn_id(int en_id) {
        this.en_id = en_id;
    }
    public void setF_id(int f_id) {
        this.f_id = f_id;
    }
    public String getFl_name() {
        return fl_name;
    }
    public void setFl_name(String fl_name) {
        this.fl_name = fl_name;
    }
    public String getFl_notnull() {
        return fl_notnull;
    }
    public void setFl_notnull(String fl_notnull) {
        this.fl_notnull = fl_notnull;
    }
    public String getFl_label() {
        return fl_label;
    }
    public void setFl_label(String fl_label) {
        this.fl_label = fl_label;
    }
    public String getFl_description() {
        return fl_description;
    }
    public void setFl_description(String fl_description) {
        this.fl_description = fl_description;
    }
    @Override
    public String toString() {
        return "FieldList{" +
                "en_id=" + en_id +
                ", f_id=" + f_id +
                ", fl_name='" + fl_name + '\'' +
                ", fl_notnull='" + fl_notnull + '\'' +
                ", fl_label='" + fl_label + '\'' +
                ", fl_description='" + fl_description + '\'' +
                ", fl_iskey='" + fl_iskey + '\'' +
                '}';
    }
}