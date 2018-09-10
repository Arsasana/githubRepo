package com.ks.riskcontrol.services;


import com.ks.riskcontrol.dao.DBTools;
import com.ks.riskcontrol.mapper.NodeMapper;
import com.ks.riskcontrol.pojos.*;
import com.ks.riskcontrol.pojos.Enum;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FieldService {
    private static SqlSession session = DBTools.getSession();
    private static NodeMapper mapper = session.getMapper(NodeMapper.class);
    private static Logger log= LogManager.getLogger(FieldService.class);


    public static void insertEntity(Entity entity) {
        try {
            mapper.insertEntity(entity);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    public static void insertEntityRef(EntityRef entityRef) {
        try {
            mapper.insertEntityRef(entityRef);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    public static void insertEnum(Enum en) {
        try {
            mapper.insertEnum(en);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    public static void insertFieldList(FieldList fieldList) {
        try {
            mapper.insertFieldList(fieldList);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    public static void insertFieldType(FieldType fieldType) {
        try {
            mapper.insertFieldType(fieldType);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    public static Integer selectRefEntityId(String param){
        try {
            NextVal val=    mapper.getRefEntityId(param);
            session.commit();
            return val==null?-1:val.getNextVal();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }
    public static Integer selectFId(){
        try {
            NextVal val=    mapper.queryFId();
            session.commit();
            return val.getNextVal();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }
    public static Integer selectEId(){
        try {
            NextVal val=    mapper.queryEId();
            session.commit();
            return val.getNextVal();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }
    public static Integer getFId(String parms) {
        try {
            NextVal val=    mapper.getFId(parms);
            session.commit();
            return val==null?-1:val.getNextVal();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }
    public static Boolean delete(){
        log.trace("========================删除原数据========================");
        try {
            session.commit();
            mapper.deleteFieldtype();
            mapper.deleteEnum();
            mapper.deleteEntity();
            mapper.deleteFieldlist();
            mapper.deleteEntityref();
            session.commit();
            log.trace("========================删除成功========================");
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return false;
        }
        return true;
    }
}