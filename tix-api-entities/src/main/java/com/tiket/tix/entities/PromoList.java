package com.tiket.tix.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;

@Document(collection = "promo_list")
public class PromoList {
    @Id
    private String _id;

    @Field("promo_type")
    private String promoType;

    @Field("title")
    private String title;

    @Field("lang")
    private String lang;

    @Field("photo")
    private String photo;

    @Field("precedence")
    private int precedence;

    @Field("status")
    private int status;

    @Field("Category")
    private String category;

    @Field("slug")
    private String slug;

    @Field("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @Field("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @Field("created_datetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDatetime;

    @Field("updated_datetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedDatetime;

    @Field("updated_by")
    private int updatedBy;

    @Field("created_by")
    private int createdBy;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPromoType() {
        return promoType;
    }

    public void setPromoType(String promoType) {
        this.promoType = promoType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public Date getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(Date updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "PromoList{" +
                "_id='" + _id + '\'' +
                ", promoType='" + promoType + '\'' +
                ", title='" + title + '\'' +
                ", lang='" + lang + '\'' +
                ", photo='" + photo + '\'' +
                ", precedence=" + precedence +
                ", status=" + status +
                ", category='" + category + '\'' +
                ", slug='" + slug + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createdDatetime=" + createdDatetime +
                ", updatedDatetime=" + updatedDatetime +
                ", updatedBy=" + updatedBy +
                ", createdBy=" + createdBy +
                '}';
    }
}
