package com.soco.car.car.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CarTypeExample() {
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

        public Criteria andCarTypeNameIsNull() {
            addCriterion("carTypeName is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameIsNotNull() {
            addCriterion("carTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameEqualTo(String value) {
            addCriterion("carTypeName =", value, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameNotEqualTo(String value) {
            addCriterion("carTypeName <>", value, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameGreaterThan(String value) {
            addCriterion("carTypeName >", value, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("carTypeName >=", value, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameLessThan(String value) {
            addCriterion("carTypeName <", value, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameLessThanOrEqualTo(String value) {
            addCriterion("carTypeName <=", value, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameLike(String value) {
            addCriterion("carTypeName like", value, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameNotLike(String value) {
            addCriterion("carTypeName not like", value, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameIn(List<String> values) {
            addCriterion("carTypeName in", values, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameNotIn(List<String> values) {
            addCriterion("carTypeName not in", values, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameBetween(String value1, String value2) {
            addCriterion("carTypeName between", value1, value2, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andCarTypeNameNotBetween(String value1, String value2) {
            addCriterion("carTypeName not between", value1, value2, "carTypeName");
            return (Criteria) this;
        }

        public Criteria andOptIsNull() {
            addCriterion("opt is null");
            return (Criteria) this;
        }

        public Criteria andOptIsNotNull() {
            addCriterion("opt is not null");
            return (Criteria) this;
        }

        public Criteria andOptEqualTo(String value) {
            addCriterion("opt =", value, "opt");
            return (Criteria) this;
        }

        public Criteria andOptNotEqualTo(String value) {
            addCriterion("opt <>", value, "opt");
            return (Criteria) this;
        }

        public Criteria andOptGreaterThan(String value) {
            addCriterion("opt >", value, "opt");
            return (Criteria) this;
        }

        public Criteria andOptGreaterThanOrEqualTo(String value) {
            addCriterion("opt >=", value, "opt");
            return (Criteria) this;
        }

        public Criteria andOptLessThan(String value) {
            addCriterion("opt <", value, "opt");
            return (Criteria) this;
        }

        public Criteria andOptLessThanOrEqualTo(String value) {
            addCriterion("opt <=", value, "opt");
            return (Criteria) this;
        }

        public Criteria andOptLike(String value) {
            addCriterion("opt like", value, "opt");
            return (Criteria) this;
        }

        public Criteria andOptNotLike(String value) {
            addCriterion("opt not like", value, "opt");
            return (Criteria) this;
        }

        public Criteria andOptIn(List<String> values) {
            addCriterion("opt in", values, "opt");
            return (Criteria) this;
        }

        public Criteria andOptNotIn(List<String> values) {
            addCriterion("opt not in", values, "opt");
            return (Criteria) this;
        }

        public Criteria andOptBetween(String value1, String value2) {
            addCriterion("opt between", value1, value2, "opt");
            return (Criteria) this;
        }

        public Criteria andOptNotBetween(String value1, String value2) {
            addCriterion("opt not between", value1, value2, "opt");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(Double value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(Double value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(Double value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(Double value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(Double value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(Double value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<Double> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<Double> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(Double value1, Double value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(Double value1, Double value2) {
            addCriterion("value not between", value1, value2, "value");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
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