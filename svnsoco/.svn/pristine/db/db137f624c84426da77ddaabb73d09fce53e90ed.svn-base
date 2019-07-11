package com.soco.car.car.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarTypeMappingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CarTypeMappingExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeIsNull() {
            addCriterion("carTypeCode is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeIsNotNull() {
            addCriterion("carTypeCode is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeEqualTo(String value) {
            addCriterion("carTypeCode =", value, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeNotEqualTo(String value) {
            addCriterion("carTypeCode <>", value, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeGreaterThan(String value) {
            addCriterion("carTypeCode >", value, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("carTypeCode >=", value, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeLessThan(String value) {
            addCriterion("carTypeCode <", value, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("carTypeCode <=", value, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeLike(String value) {
            addCriterion("carTypeCode like", value, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeNotLike(String value) {
            addCriterion("carTypeCode not like", value, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeIn(List<String> values) {
            addCriterion("carTypeCode in", values, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeNotIn(List<String> values) {
            addCriterion("carTypeCode not in", values, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeBetween(String value1, String value2) {
            addCriterion("carTypeCode between", value1, value2, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarTypeCodeNotBetween(String value1, String value2) {
            addCriterion("carTypeCode not between", value1, value2, "carTypeCode");
            return (Criteria) this;
        }

        public Criteria andCarModelNameIsNull() {
            addCriterion("carModelName is null");
            return (Criteria) this;
        }

        public Criteria andCarModelNameIsNotNull() {
            addCriterion("carModelName is not null");
            return (Criteria) this;
        }

        public Criteria andCarModelNameEqualTo(String value) {
            addCriterion("carModelName =", value, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameNotEqualTo(String value) {
            addCriterion("carModelName <>", value, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameGreaterThan(String value) {
            addCriterion("carModelName >", value, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("carModelName >=", value, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameLessThan(String value) {
            addCriterion("carModelName <", value, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameLessThanOrEqualTo(String value) {
            addCriterion("carModelName <=", value, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameLike(String value) {
            addCriterion("carModelName like", value, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameNotLike(String value) {
            addCriterion("carModelName not like", value, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameIn(List<String> values) {
            addCriterion("carModelName in", values, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameNotIn(List<String> values) {
            addCriterion("carModelName not in", values, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameBetween(String value1, String value2) {
            addCriterion("carModelName between", value1, value2, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCarModelNameNotBetween(String value1, String value2) {
            addCriterion("carModelName not between", value1, value2, "carModelName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
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