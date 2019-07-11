package com.soco.car.device.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevicestateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public DevicestateExample() {
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

        public Criteria andStateidIsNull() {
            addCriterion("stateId is null");
            return (Criteria) this;
        }

        public Criteria andStateidIsNotNull() {
            addCriterion("stateId is not null");
            return (Criteria) this;
        }

        public Criteria andStateidEqualTo(Long value) {
            addCriterion("stateId =", value, "stateid");
            return (Criteria) this;
        }

        public Criteria andStateidNotEqualTo(Long value) {
            addCriterion("stateId <>", value, "stateid");
            return (Criteria) this;
        }

        public Criteria andStateidGreaterThan(Long value) {
            addCriterion("stateId >", value, "stateid");
            return (Criteria) this;
        }

        public Criteria andStateidGreaterThanOrEqualTo(Long value) {
            addCriterion("stateId >=", value, "stateid");
            return (Criteria) this;
        }

        public Criteria andStateidLessThan(Long value) {
            addCriterion("stateId <", value, "stateid");
            return (Criteria) this;
        }

        public Criteria andStateidLessThanOrEqualTo(Long value) {
            addCriterion("stateId <=", value, "stateid");
            return (Criteria) this;
        }

        public Criteria andStateidIn(List<Long> values) {
            addCriterion("stateId in", values, "stateid");
            return (Criteria) this;
        }

        public Criteria andStateidNotIn(List<Long> values) {
            addCriterion("stateId not in", values, "stateid");
            return (Criteria) this;
        }

        public Criteria andStateidBetween(Long value1, Long value2) {
            addCriterion("stateId between", value1, value2, "stateid");
            return (Criteria) this;
        }

        public Criteria andStateidNotBetween(Long value1, Long value2) {
            addCriterion("stateId not between", value1, value2, "stateid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(Long value) {
            addCriterion("deviceId =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(Long value) {
            addCriterion("deviceId <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(Long value) {
            addCriterion("deviceId >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(Long value) {
            addCriterion("deviceId >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(Long value) {
            addCriterion("deviceId <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(Long value) {
            addCriterion("deviceId <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<Long> values) {
            addCriterion("deviceId in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<Long> values) {
            addCriterion("deviceId not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(Long value1, Long value2) {
            addCriterion("deviceId between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(Long value1, Long value2) {
            addCriterion("deviceId not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andStartMileageIsNull() {
            addCriterion("start_mileage is null");
            return (Criteria) this;
        }

        public Criteria andStartMileageIsNotNull() {
            addCriterion("start_mileage is not null");
            return (Criteria) this;
        }

        public Criteria andStartMileageEqualTo(Double value) {
            addCriterion("start_mileage =", value, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartMileageNotEqualTo(Double value) {
            addCriterion("start_mileage <>", value, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartMileageGreaterThan(Double value) {
            addCriterion("start_mileage >", value, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartMileageGreaterThanOrEqualTo(Double value) {
            addCriterion("start_mileage >=", value, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartMileageLessThan(Double value) {
            addCriterion("start_mileage <", value, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartMileageLessThanOrEqualTo(Double value) {
            addCriterion("start_mileage <=", value, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartMileageIn(List<Double> values) {
            addCriterion("start_mileage in", values, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartMileageNotIn(List<Double> values) {
            addCriterion("start_mileage not in", values, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartMileageBetween(Double value1, Double value2) {
            addCriterion("start_mileage between", value1, value2, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartMileageNotBetween(Double value1, Double value2) {
            addCriterion("start_mileage not between", value1, value2, "startMileage");
            return (Criteria) this;
        }

        public Criteria andStartPowerIsNull() {
            addCriterion("start_power is null");
            return (Criteria) this;
        }

        public Criteria andStartPowerIsNotNull() {
            addCriterion("start_power is not null");
            return (Criteria) this;
        }

        public Criteria andStartPowerEqualTo(Double value) {
            addCriterion("start_power =", value, "startPower");
            return (Criteria) this;
        }

        public Criteria andStartPowerNotEqualTo(Double value) {
            addCriterion("start_power <>", value, "startPower");
            return (Criteria) this;
        }

        public Criteria andStartPowerGreaterThan(Double value) {
            addCriterion("start_power >", value, "startPower");
            return (Criteria) this;
        }

        public Criteria andStartPowerGreaterThanOrEqualTo(Double value) {
            addCriterion("start_power >=", value, "startPower");
            return (Criteria) this;
        }

        public Criteria andStartPowerLessThan(Double value) {
            addCriterion("start_power <", value, "startPower");
            return (Criteria) this;
        }

        public Criteria andStartPowerLessThanOrEqualTo(Double value) {
            addCriterion("start_power <=", value, "startPower");
            return (Criteria) this;
        }

        public Criteria andStartPowerIn(List<Double> values) {
            addCriterion("start_power in", values, "startPower");
            return (Criteria) this;
        }

        public Criteria andStartPowerNotIn(List<Double> values) {
            addCriterion("start_power not in", values, "startPower");
            return (Criteria) this;
        }

        public Criteria andStartPowerBetween(Double value1, Double value2) {
            addCriterion("start_power between", value1, value2, "startPower");
            return (Criteria) this;
        }

        public Criteria andStartPowerNotBetween(Double value1, Double value2) {
            addCriterion("start_power not between", value1, value2, "startPower");
            return (Criteria) this;
        }

        public Criteria andEndMileageIsNull() {
            addCriterion("end_mileage is null");
            return (Criteria) this;
        }

        public Criteria andEndMileageIsNotNull() {
            addCriterion("end_mileage is not null");
            return (Criteria) this;
        }

        public Criteria andEndMileageEqualTo(Double value) {
            addCriterion("end_mileage =", value, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndMileageNotEqualTo(Double value) {
            addCriterion("end_mileage <>", value, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndMileageGreaterThan(Double value) {
            addCriterion("end_mileage >", value, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndMileageGreaterThanOrEqualTo(Double value) {
            addCriterion("end_mileage >=", value, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndMileageLessThan(Double value) {
            addCriterion("end_mileage <", value, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndMileageLessThanOrEqualTo(Double value) {
            addCriterion("end_mileage <=", value, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndMileageIn(List<Double> values) {
            addCriterion("end_mileage in", values, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndMileageNotIn(List<Double> values) {
            addCriterion("end_mileage not in", values, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndMileageBetween(Double value1, Double value2) {
            addCriterion("end_mileage between", value1, value2, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndMileageNotBetween(Double value1, Double value2) {
            addCriterion("end_mileage not between", value1, value2, "endMileage");
            return (Criteria) this;
        }

        public Criteria andEndPowerIsNull() {
            addCriterion("end_power is null");
            return (Criteria) this;
        }

        public Criteria andEndPowerIsNotNull() {
            addCriterion("end_power is not null");
            return (Criteria) this;
        }

        public Criteria andEndPowerEqualTo(Double value) {
            addCriterion("end_power =", value, "endPower");
            return (Criteria) this;
        }

        public Criteria andEndPowerNotEqualTo(Double value) {
            addCriterion("end_power <>", value, "endPower");
            return (Criteria) this;
        }

        public Criteria andEndPowerGreaterThan(Double value) {
            addCriterion("end_power >", value, "endPower");
            return (Criteria) this;
        }

        public Criteria andEndPowerGreaterThanOrEqualTo(Double value) {
            addCriterion("end_power >=", value, "endPower");
            return (Criteria) this;
        }

        public Criteria andEndPowerLessThan(Double value) {
            addCriterion("end_power <", value, "endPower");
            return (Criteria) this;
        }

        public Criteria andEndPowerLessThanOrEqualTo(Double value) {
            addCriterion("end_power <=", value, "endPower");
            return (Criteria) this;
        }

        public Criteria andEndPowerIn(List<Double> values) {
            addCriterion("end_power in", values, "endPower");
            return (Criteria) this;
        }

        public Criteria andEndPowerNotIn(List<Double> values) {
            addCriterion("end_power not in", values, "endPower");
            return (Criteria) this;
        }

        public Criteria andEndPowerBetween(Double value1, Double value2) {
            addCriterion("end_power between", value1, value2, "endPower");
            return (Criteria) this;
        }

        public Criteria andEndPowerNotBetween(Double value1, Double value2) {
            addCriterion("end_power not between", value1, value2, "endPower");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
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