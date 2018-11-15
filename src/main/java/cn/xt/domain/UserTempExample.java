package cn.xt.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserTempExample() {
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

        public Criteria andUserTempIdIsNull() {
            addCriterion("USER_TEMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserTempIdIsNotNull() {
            addCriterion("USER_TEMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserTempIdEqualTo(String value) {
            addCriterion("USER_TEMP_ID =", value, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdNotEqualTo(String value) {
            addCriterion("USER_TEMP_ID <>", value, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdGreaterThan(String value) {
            addCriterion("USER_TEMP_ID >", value, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TEMP_ID >=", value, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdLessThan(String value) {
            addCriterion("USER_TEMP_ID <", value, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdLessThanOrEqualTo(String value) {
            addCriterion("USER_TEMP_ID <=", value, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdLike(String value) {
            addCriterion("USER_TEMP_ID like", value, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdNotLike(String value) {
            addCriterion("USER_TEMP_ID not like", value, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdIn(List<String> values) {
            addCriterion("USER_TEMP_ID in", values, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdNotIn(List<String> values) {
            addCriterion("USER_TEMP_ID not in", values, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdBetween(String value1, String value2) {
            addCriterion("USER_TEMP_ID between", value1, value2, "userTempId");
            return (Criteria) this;
        }

        public Criteria andUserTempIdNotBetween(String value1, String value2) {
            addCriterion("USER_TEMP_ID not between", value1, value2, "userTempId");
            return (Criteria) this;
        }

        public Criteria andKeyClassIsNull() {
            addCriterion("KEY_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andKeyClassIsNotNull() {
            addCriterion("KEY_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andKeyClassEqualTo(String value) {
            addCriterion("KEY_CLASS =", value, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassNotEqualTo(String value) {
            addCriterion("KEY_CLASS <>", value, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassGreaterThan(String value) {
            addCriterion("KEY_CLASS >", value, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_CLASS >=", value, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassLessThan(String value) {
            addCriterion("KEY_CLASS <", value, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassLessThanOrEqualTo(String value) {
            addCriterion("KEY_CLASS <=", value, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassLike(String value) {
            addCriterion("KEY_CLASS like", value, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassNotLike(String value) {
            addCriterion("KEY_CLASS not like", value, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassIn(List<String> values) {
            addCriterion("KEY_CLASS in", values, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassNotIn(List<String> values) {
            addCriterion("KEY_CLASS not in", values, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassBetween(String value1, String value2) {
            addCriterion("KEY_CLASS between", value1, value2, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyClassNotBetween(String value1, String value2) {
            addCriterion("KEY_CLASS not between", value1, value2, "keyClass");
            return (Criteria) this;
        }

        public Criteria andKeyNameIsNull() {
            addCriterion("KEY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andKeyNameIsNotNull() {
            addCriterion("KEY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andKeyNameEqualTo(String value) {
            addCriterion("KEY_NAME =", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotEqualTo(String value) {
            addCriterion("KEY_NAME <>", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameGreaterThan(String value) {
            addCriterion("KEY_NAME >", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_NAME >=", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameLessThan(String value) {
            addCriterion("KEY_NAME <", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameLessThanOrEqualTo(String value) {
            addCriterion("KEY_NAME <=", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameLike(String value) {
            addCriterion("KEY_NAME like", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotLike(String value) {
            addCriterion("KEY_NAME not like", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameIn(List<String> values) {
            addCriterion("KEY_NAME in", values, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotIn(List<String> values) {
            addCriterion("KEY_NAME not in", values, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameBetween(String value1, String value2) {
            addCriterion("KEY_NAME between", value1, value2, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotBetween(String value1, String value2) {
            addCriterion("KEY_NAME not between", value1, value2, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyContentIsNull() {
            addCriterion("KEY_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andKeyContentIsNotNull() {
            addCriterion("KEY_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andKeyContentEqualTo(String value) {
            addCriterion("KEY_CONTENT =", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentNotEqualTo(String value) {
            addCriterion("KEY_CONTENT <>", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentGreaterThan(String value) {
            addCriterion("KEY_CONTENT >", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_CONTENT >=", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentLessThan(String value) {
            addCriterion("KEY_CONTENT <", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentLessThanOrEqualTo(String value) {
            addCriterion("KEY_CONTENT <=", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentLike(String value) {
            addCriterion("KEY_CONTENT like", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentNotLike(String value) {
            addCriterion("KEY_CONTENT not like", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentIn(List<String> values) {
            addCriterion("KEY_CONTENT in", values, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentNotIn(List<String> values) {
            addCriterion("KEY_CONTENT not in", values, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentBetween(String value1, String value2) {
            addCriterion("KEY_CONTENT between", value1, value2, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentNotBetween(String value1, String value2) {
            addCriterion("KEY_CONTENT not between", value1, value2, "keyContent");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Integer value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<Integer> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<Integer> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andCnoteIsNull() {
            addCriterion("CNOTE is null");
            return (Criteria) this;
        }

        public Criteria andCnoteIsNotNull() {
            addCriterion("CNOTE is not null");
            return (Criteria) this;
        }

        public Criteria andCnoteEqualTo(String value) {
            addCriterion("CNOTE =", value, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteNotEqualTo(String value) {
            addCriterion("CNOTE <>", value, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteGreaterThan(String value) {
            addCriterion("CNOTE >", value, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteGreaterThanOrEqualTo(String value) {
            addCriterion("CNOTE >=", value, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteLessThan(String value) {
            addCriterion("CNOTE <", value, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteLessThanOrEqualTo(String value) {
            addCriterion("CNOTE <=", value, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteLike(String value) {
            addCriterion("CNOTE like", value, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteNotLike(String value) {
            addCriterion("CNOTE not like", value, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteIn(List<String> values) {
            addCriterion("CNOTE in", values, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteNotIn(List<String> values) {
            addCriterion("CNOTE not in", values, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteBetween(String value1, String value2) {
            addCriterion("CNOTE between", value1, value2, "cnote");
            return (Criteria) this;
        }

        public Criteria andCnoteNotBetween(String value1, String value2) {
            addCriterion("CNOTE not between", value1, value2, "cnote");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("UPDATE_BY =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("UPDATE_BY <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("UPDATE_BY >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("UPDATE_BY <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("UPDATE_BY like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("UPDATE_BY not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("UPDATE_BY in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("UPDATE_BY not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("UPDATE_BY between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

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