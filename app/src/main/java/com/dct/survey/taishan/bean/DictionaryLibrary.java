package com.dct.survey.taishan.bean;

import com.dct.survey.taishan.dao.MyObjectConverent;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.util.List;

/**
 * 创建：Android
 * 日期：2017/7/18 11:59
 * 描述：数据字典的集合
 */

@Entity
public class DictionaryLibrary {

    //经营主体
    @Convert(/**指定转换器 **/converter = MyObjectConverent.class,/**指定数据库中的列字段**/columnType =String.class )
    private List<DictionaryBean> business_Entity;

    //控制地带
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> control_Area;

    //破环因素
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> disaster_Reason;

    //现有用途
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> existing_use;

    //实施效果
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> implementation_Effect;

    //环境现状类型
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> invironment_Type;

    //用地性質
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> land_Usege;

    //级别
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> level;

    //所有权
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> ownerShip;

    //保护范围界桩
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> protect_Boundary_Marker;

    //本体防护
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> protect_Defend;

    //保护标志碑
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> protect_Marker;

    //保护规划
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> protect_Plan;

    //专项保护工程
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> protect_Project;

    //保护范围
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> protect_Range;

    //保护档案
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> protect_Record;

    //展示利用条件
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> show_Condition;

    //专项展示设施
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> show_Facility;

    //展示方式
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> show_Way;

    //类型
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> type;

    //年代
    @Convert(converter = MyObjectConverent .class, columnType =String.class )
    private List<DictionaryBean> years;

    @Generated(hash = 860333663)
    public DictionaryLibrary(List<DictionaryBean> business_Entity, List<DictionaryBean> control_Area,
            List<DictionaryBean> disaster_Reason, List<DictionaryBean> existing_use,
            List<DictionaryBean> implementation_Effect, List<DictionaryBean> invironment_Type,
            List<DictionaryBean> land_Usege, List<DictionaryBean> level, List<DictionaryBean> ownerShip,
            List<DictionaryBean> protect_Boundary_Marker, List<DictionaryBean> protect_Defend,
            List<DictionaryBean> protect_Marker, List<DictionaryBean> protect_Plan,
            List<DictionaryBean> protect_Project, List<DictionaryBean> protect_Range,
            List<DictionaryBean> protect_Record, List<DictionaryBean> show_Condition,
            List<DictionaryBean> show_Facility, List<DictionaryBean> show_Way,
            List<DictionaryBean> type, List<DictionaryBean> years) {
        this.business_Entity = business_Entity;
        this.control_Area = control_Area;
        this.disaster_Reason = disaster_Reason;
        this.existing_use = existing_use;
        this.implementation_Effect = implementation_Effect;
        this.invironment_Type = invironment_Type;
        this.land_Usege = land_Usege;
        this.level = level;
        this.ownerShip = ownerShip;
        this.protect_Boundary_Marker = protect_Boundary_Marker;
        this.protect_Defend = protect_Defend;
        this.protect_Marker = protect_Marker;
        this.protect_Plan = protect_Plan;
        this.protect_Project = protect_Project;
        this.protect_Range = protect_Range;
        this.protect_Record = protect_Record;
        this.show_Condition = show_Condition;
        this.show_Facility = show_Facility;
        this.show_Way = show_Way;
        this.type = type;
        this.years = years;
    }

    @Generated(hash = 1635786349)
    public DictionaryLibrary() {
    }

    public List<DictionaryBean> getBusiness_Entity() {
        return this.business_Entity;
    }

    public void setBusiness_Entity(List<DictionaryBean> business_Entity) {
        this.business_Entity = business_Entity;
    }

    public List<DictionaryBean> getControl_Area() {
        return this.control_Area;
    }

    public void setControl_Area(List<DictionaryBean> control_Area) {
        this.control_Area = control_Area;
    }

    public List<DictionaryBean> getDisaster_Reason() {
        return this.disaster_Reason;
    }

    public void setDisaster_Reason(List<DictionaryBean> disaster_Reason) {
        this.disaster_Reason = disaster_Reason;
    }

    public List<DictionaryBean> getExisting_use() {
        return this.existing_use;
    }

    public void setExisting_use(List<DictionaryBean> existing_use) {
        this.existing_use = existing_use;
    }

    public List<DictionaryBean> getImplementation_Effect() {
        return this.implementation_Effect;
    }

    public void setImplementation_Effect(List<DictionaryBean> implementation_Effect) {
        this.implementation_Effect = implementation_Effect;
    }

    public List<DictionaryBean> getInvironment_Type() {
        return this.invironment_Type;
    }

    public void setInvironment_Type(List<DictionaryBean> invironment_Type) {
        this.invironment_Type = invironment_Type;
    }

    public List<DictionaryBean> getLand_Usege() {
        return this.land_Usege;
    }

    public void setLand_Usege(List<DictionaryBean> land_Usege) {
        this.land_Usege = land_Usege;
    }

    public List<DictionaryBean> getLevel() {
        return this.level;
    }

    public void setLevel(List<DictionaryBean> level) {
        this.level = level;
    }

    public List<DictionaryBean> getOwnerShip() {
        return this.ownerShip;
    }

    public void setOwnerShip(List<DictionaryBean> ownerShip) {
        this.ownerShip = ownerShip;
    }

    public List<DictionaryBean> getProtect_Boundary_Marker() {
        return this.protect_Boundary_Marker;
    }

    public void setProtect_Boundary_Marker(List<DictionaryBean> protect_Boundary_Marker) {
        this.protect_Boundary_Marker = protect_Boundary_Marker;
    }

    public List<DictionaryBean> getProtect_Defend() {
        return this.protect_Defend;
    }

    public void setProtect_Defend(List<DictionaryBean> protect_Defend) {
        this.protect_Defend = protect_Defend;
    }

    public List<DictionaryBean> getProtect_Marker() {
        return this.protect_Marker;
    }

    public void setProtect_Marker(List<DictionaryBean> protect_Marker) {
        this.protect_Marker = protect_Marker;
    }

    public List<DictionaryBean> getProtect_Plan() {
        return this.protect_Plan;
    }

    public void setProtect_Plan(List<DictionaryBean> protect_Plan) {
        this.protect_Plan = protect_Plan;
    }

    public List<DictionaryBean> getProtect_Project() {
        return this.protect_Project;
    }

    public void setProtect_Project(List<DictionaryBean> protect_Project) {
        this.protect_Project = protect_Project;
    }

    public List<DictionaryBean> getProtect_Range() {
        return this.protect_Range;
    }

    public void setProtect_Range(List<DictionaryBean> protect_Range) {
        this.protect_Range = protect_Range;
    }

    public List<DictionaryBean> getProtect_Record() {
        return this.protect_Record;
    }

    public void setProtect_Record(List<DictionaryBean> protect_Record) {
        this.protect_Record = protect_Record;
    }

    public List<DictionaryBean> getShow_Condition() {
        return this.show_Condition;
    }

    public void setShow_Condition(List<DictionaryBean> show_Condition) {
        this.show_Condition = show_Condition;
    }

    public List<DictionaryBean> getShow_Facility() {
        return this.show_Facility;
    }

    public void setShow_Facility(List<DictionaryBean> show_Facility) {
        this.show_Facility = show_Facility;
    }

    public List<DictionaryBean> getShow_Way() {
        return this.show_Way;
    }

    public void setShow_Way(List<DictionaryBean> show_Way) {
        this.show_Way = show_Way;
    }

    public List<DictionaryBean> getType() {
        return this.type;
    }

    public void setType(List<DictionaryBean> type) {
        this.type = type;
    }

    public List<DictionaryBean> getYears() {
        return this.years;
    }

    public void setYears(List<DictionaryBean> years) {
        this.years = years;
    }

}
