package com.ks.riskcontrol.mapper;

import com.ks.riskcontrol.pojos.*;
import com.ks.riskcontrol.pojos.Enum;

import java.util.List;

public interface NodeMapper {

    public Integer insertFieldType(FieldType val) throws Exception;
    public Integer insertEnum(Enum val) throws Exception;
    public Integer insertEntity(Entity val) throws Exception;
    public Integer insertEntityRef(EntityRef val) throws Exception;
    public Integer insertFieldList(FieldList val) throws Exception;
    public NextVal getRefEntityId(String en_name) throws Exception;
    public NextVal getFId(String type) throws Exception;
    public NextVal queryFId() throws Exception;
    public NextVal queryEId() throws Exception;
    public void deleteFieldtype() throws Exception;
    public void deleteEnum() throws Exception;
    public void deleteEntity() throws Exception;
    public void deleteFieldlist() throws Exception;
    public void deleteEntityref() throws Exception;
}