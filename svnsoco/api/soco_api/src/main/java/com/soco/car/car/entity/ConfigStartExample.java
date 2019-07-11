package com.soco.car.car.entity;

import java.util.ArrayList;
import java.util.List;

public class ConfigStartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ConfigStartExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStartidIsNull() {
            addCriterion("startId is null");
            return (Criteria) this;
        }

        public Criteria andStartidIsNotNull() {
            addCriterion("startId is not null");
            return (Criteria) this;
        }

        public Criteria andStartidEqualTo(Long value) {
            addCriterion("startId =", value, "startid");
            return (Criteria) this;
        }

        public Criteria andStartidNotEqualTo(Long value) {
            addCriterion("startId <>", value, "startid");
            return (Criteria) this;
        }

        public Criteria andStartidGreaterThan(Long value) {
            addCriterion("startId >", value, "startid");
            return (Criteria) this;
        }

        public Criteria andStartidGreaterThanOrEqualTo(Long value) {
            addCriterion("startId >=", value, "startid");
            return (Criteria) this;
        }

        public Criteria andStartidLessThan(Long value) {
            addCriterion("startId <", value, "startid");
            return (Criteria) this;
        }

        public Criteria andStartidLessThanOrEqualTo(Long value) {
            addCriterion("startId <=", value, "startid");
            return (Criteria) this;
        }

        public Criteria andStartidIn(List<Long> values) {
            addCriterion("startId in", values, "startid");
            return (Criteria) this;
        }

        public Criteria andStartidNotIn(List<Long> values) {
            addCriterion("startId not in", values, "startid");
            return (Criteria) this;
        }

        public Criteria andStartidBetween(Long value1, Long value2) {
            addCriterion("startId between", value1, value2, "startid");
            return (Criteria) this;
        }

        public Criteria andStartidNotBetween(Long value1, Long value2) {
            addCriterion("startId not between", value1, value2, "startid");
            return (Criteria) this;
        }

        public Criteria andIndexsIsNull() {
            addCriterion("indexs is null");
            return (Criteria) this;
        }

        public Criteria andIndexsIsNotNull() {
            addCriterion("indexs is not null");
            return (Criteria) this;
        }

        public Criteria andIndexsEqualTo(Integer value) {
            addCriterion("indexs =", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotEqualTo(Integer value) {
            addCriterion("indexs <>", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsGreaterThan(Integer value) {
            addCriterion("indexs >", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsGreaterThanOrEqualTo(Integer value) {
            addCriterion("indexs >=", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLessThan(Integer value) {
            addCriterion("indexs <", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLessThanOrEqualTo(Integer value) {
            addCriterion("indexs <=", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsIn(List<Integer> values) {
            addCriterion("indexs in", values, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotIn(List<Integer> values) {
            addCriterion("indexs not in", values, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsBetween(Integer value1, Integer value2) {
            addCriterion("indexs between", value1, value2, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotBetween(Integer value1, Integer value2) {
            addCriterion("indexs not between", value1, value2, "indexs");
            return (Criteria) this;
        }

        public Criteria andStarttypeIsNull() {
            addCriterion("startType is null");
            return (Criteria) this;
        }

        public Criteria andStarttypeIsNotNull() {
            addCriterion("startType is not null");
            return (Criteria) this;
        }

        public Criteria andStarttypeEqualTo(Integer value) {
            addCriterion("startType =", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeNotEqualTo(Integer value) {
            addCriterion("startType <>", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeGreaterThan(Integer value) {
            addCriterion("startType >", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("startType >=", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeLessThan(Integer value) {
            addCriterion("startType <", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeLessThanOrEqualTo(Integer value) {
            addCriterion("startType <=", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeIn(List<Integer> values) {
            addCriterion("startType in", values, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeNotIn(List<Integer> values) {
            addCriterion("startType not in", values, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeBetween(Integer value1, Integer value2) {
            addCriterion("startType between", value1, value2, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("startType not between", value1, value2, "starttype");
            return (Criteria) this;
        }

        public Criteria andImgversionIsNull() {
            addCriterion("imgVersion is null");
            return (Criteria) this;
        }

        public Criteria andImgversionIsNotNull() {
            addCriterion("imgVersion is not null");
            return (Criteria) this;
        }

        public Criteria andImgversionEqualTo(Integer value) {
            addCriterion("imgVersion =", value, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgversionNotEqualTo(Integer value) {
            addCriterion("imgVersion <>", value, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgversionGreaterThan(Integer value) {
            addCriterion("imgVersion >", value, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgversionGreaterThanOrEqualTo(Integer value) {
            addCriterion("imgVersion >=", value, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgversionLessThan(Integer value) {
            addCriterion("imgVersion <", value, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgversionLessThanOrEqualTo(Integer value) {
            addCriterion("imgVersion <=", value, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgversionIn(List<Integer> values) {
            addCriterion("imgVersion in", values, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgversionNotIn(List<Integer> values) {
            addCriterion("imgVersion not in", values, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgversionBetween(Integer value1, Integer value2) {
            addCriterion("imgVersion between", value1, value2, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgversionNotBetween(Integer value1, Integer value2) {
            addCriterion("imgVersion not between", value1, value2, "imgversion");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNull() {
            addCriterion("imgUrl is null");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNotNull() {
            addCriterion("imgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andImgurlEqualTo(String value) {
            addCriterion("imgUrl =", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotEqualTo(String value) {
            addCriterion("imgUrl <>", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThan(String value) {
            addCriterion("imgUrl >", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("imgUrl >=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThan(String value) {
            addCriterion("imgUrl <", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThanOrEqualTo(String value) {
            addCriterion("imgUrl <=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLike(String value) {
            addCriterion("imgUrl like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotLike(String value) {
            addCriterion("imgUrl not like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlIn(List<String> values) {
            addCriterion("imgUrl in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotIn(List<String> values) {
            addCriterion("imgUrl not in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlBetween(String value1, String value2) {
            addCriterion("imgUrl between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotBetween(String value1, String value2) {
            addCriterion("imgUrl not between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updateTime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updateTime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}