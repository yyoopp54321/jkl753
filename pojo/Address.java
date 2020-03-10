package com.example.jkl.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private String name;

    private Integer phone;

    private Short role;

    private String provice;

    private String district;

    private String city;

    private String street;

    private Integer postcode;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return phone
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * @return role
     */
    public Short getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(Short role) {
        this.role = role;
    }

    /**
     * @return provice
     */
    public String getProvice() {
        return provice;
    }

    /**
     * @param provice
     */
    public void setProvice(String provice) {
        this.provice = provice == null ? null : provice.trim();
    }

    /**
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street
     */
    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    /**
     * @return postcode
     */
    public Integer getPostcode() {
        return postcode;
    }

    /**
     * @param postcode
     */
    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}