package com.ks.riskcontrol.pojos;



public class EntityRef {
    private Integer en_id ;
    private Integer ref_entity_id ;
    public Integer getEn_id() {
        return en_id;
    }
    public void setEn_id(int en_id) {
        this.en_id = en_id;
    }
    public Integer getRef_entity_id() {
        return ref_entity_id;
    }
    public void setRef_entity_id(int ref_entity_id) {
        this.ref_entity_id = ref_entity_id;
    }

    @Override
    public String toString() {
        return "EntityRef{" +
                "en_id=" + en_id +
                ", ref_entity_id=" + ref_entity_id +
                '}';
    }
}