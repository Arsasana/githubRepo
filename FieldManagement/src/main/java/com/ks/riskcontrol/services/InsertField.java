package com.ks.riskcontrol.services;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ks.riskcontrol.pojos.*;
import com.ks.riskcontrol.pojos.Enum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 遍历xml所有节点（包括子节点下还有子节点多层嵌套）
 */
public class InsertField {
    private static Logger log= LogManager.getLogger(InsertField.class);
    private static SAXReader sax = new SAXReader();                         //创建一个SAXReader对象
    private static int index =0;
    private static FieldService fieldService= new FieldService();
    private static List<tempObject> temp=new ArrayList<>();                //临时存放Ref字段
    public void perform(){
        try {
            fieldService.delete();
            log.trace("========================插入字段========================");
            getRoot("/usr/ksRepo/DataType.xml");
            getRoot("/usr/ksRepo/Entity.xml");
            if(!temp.isEmpty()){insertTemp();}
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            temp.clear();
        }
    }
    /**
     * 获取文件的xml对象，然后获取对应的根节点root
     */
    public void getRoot(String path) throws Exception {

        File xmlFile = new File(path);                                      // 根据指定的路径创建file对象
        Document document = sax.read(xmlFile);                              // 获取document对象,如果文档无节点，则会抛出Exception提前结束
        Element root = document.getRootElement();                           // 获取根节点
        try{
            if(root.getName().equals("UFDataTypes")){
                index=fieldService.selectFId();
                getDataTypeNodes(root,index,index);                         // 从根节点开始遍历所有节点
            }
            else {
                index=fieldService.selectEId();
                getEntityNodes(root,index,index);
            }
        }
        catch (Exception e){
            throw new IllegalArgumentException("path :"+path+"          index :"+index);
        }
        finally {
            index=0;
        }
    }
    public void getDataTypeNodes(Element node,int preNode,int pNode)  {
        FieldType ft=new FieldType();
        Enum et=new Enum();
        preNode=fieldService.selectFId();
        if(!node.getName().equals("enum")) {
            ft.setF_id(preNode);
            ft.setType(node.getName());
        }
        else {
            et.setF_id(pNode);
        }
        List<Attribute> listAttr = node.attributes();               // 当前节点的所有属性
        for ( Attribute attr : listAttr) {                          // 遍历当前节点的所有属性
            if(!node.getName().equals("enum")) {
                ft.set_value(attr.getName(), attr.getValue());
            }
            else {
                et.setEnumValue(attr.getName(), attr.getValue());
            }
        }
        if(node.getName().equals("EnumChar")) {                     //如果是子节点
            pNode=preNode;
        }
        if(node.getName().equals("UFDataTypes")){}
        else if(!node.getName().equals("enum")) {
            log.trace(ft);
            fieldService.insertFieldType(ft);
        }
        else{
            log.trace(et);
            fieldService.insertEnum(et);
        }
        List<Element> listElement = node.elements();                // 所有一级子节点的list
        for ( Element e : listElement) {                            // 遍历所有一级子节点
            getDataTypeNodes(e,preNode,pNode);                      // 递归
        }
    }
    public void getEntityNodes(Element node,int preNode,int pNode) throws SQLException {
        Entity ett=new Entity();
        FieldList fl=new FieldList();
        EntityRef er=new EntityRef();
        preNode=fieldService.selectEId();
        if(node.getName().equals("Entity")) {		                //entity
            ett.setEn_id(preNode);
        }
        else if(node.getName().equals("Field")) {                   //fieldlist
            fl.setEn_id(pNode);
        }
//        else {                          			       //Ref
//            er.setEn_id(pNode);
//        }
        List<Attribute> listAttr = node.attributes();               // 当前节点的所有属性
        for ( Attribute attr : listAttr) {                          // 遍历当前节点的所有属性
            String parmsName = attr.getName();                      // 属性名称
            String parms = attr.getValue();                         // 属性的值
            if (node.getName().equals("UFEntityModel")){}
            else if(node.getName().equals("Entity")) {		         //entity
                ett.setValue(attr.getName(), parms);
            }
            else if(node.getName().equals("Field")) { 	             //fieldlist
                fl.setValue(parmsName, parms);
        }
            else {
                int val=fieldService.selectRefEntityId(parms);
                if(val!=-1){                                        //Ref
                    er.setEn_id(pNode);
                    er.setRef_entity_id(val);
                    log.trace(val);
                }
                else {
                    log.trace(val);
                    temp.add(new tempObject(pNode, parms));
                }
            }
        }
        if(node.getName().equals("Entity")) {
            log.trace(ett);
            fieldService.insertEntity(ett);
            pNode=preNode;
        }
        else if(node.getName().equals("Field")) { 	                  //fieldlist
            log.trace(fl);
            fieldService.insertFieldList(fl);
        }
        else if(node.getName().equals("Ref")&&er.getEn_id()!=null){ //&&(er.getRef_entity_id()!=-1)
            log.trace(er);
            fieldService.insertEntityRef(er);
        }
        List<Element> listElement = node.elements();                 // 所有一级子节点的list
        for ( Element e : listElement) {                            // 遍历所有一级子节点
            getEntityNodes(e,preNode,pNode);                        // 递归
        }
    }
    private void insertTemp(){
        EntityRef er=new EntityRef();
        int val;
        for(tempObject tempObject:temp){
            val=fieldService.selectRefEntityId(tempObject.getType());
            if(val==-1){
                log.error("未找到引用项   :"+tempObject.getType());
            }
            er.setRef_entity_id(fieldService.selectRefEntityId(tempObject.getType()));
            er.setEn_id(tempObject.getpNode());
            log.trace(er);
            fieldService.insertEntityRef(er);
        }
    }
}