package cn.xt.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoteRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VoteRecordExample() {
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

        public Criteria andVoteRecordIdIsNull() {
            addCriterion("VOTE_RECORD_ID is null");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdIsNotNull() {
            addCriterion("VOTE_RECORD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdEqualTo(String value) {
            addCriterion("VOTE_RECORD_ID =", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdNotEqualTo(String value) {
            addCriterion("VOTE_RECORD_ID <>", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdGreaterThan(String value) {
            addCriterion("VOTE_RECORD_ID >", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("VOTE_RECORD_ID >=", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdLessThan(String value) {
            addCriterion("VOTE_RECORD_ID <", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdLessThanOrEqualTo(String value) {
            addCriterion("VOTE_RECORD_ID <=", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdLike(String value) {
            addCriterion("VOTE_RECORD_ID like", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdNotLike(String value) {
            addCriterion("VOTE_RECORD_ID not like", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdIn(List<String> values) {
            addCriterion("VOTE_RECORD_ID in", values, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdNotIn(List<String> values) {
            addCriterion("VOTE_RECORD_ID not in", values, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdBetween(String value1, String value2) {
            addCriterion("VOTE_RECORD_ID between", value1, value2, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdNotBetween(String value1, String value2) {
            addCriterion("VOTE_RECORD_ID not between", value1, value2, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNull() {
            addCriterion("CTYPE is null");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNotNull() {
            addCriterion("CTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCtypeEqualTo(String value) {
            addCriterion("CTYPE =", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotEqualTo(String value) {
            addCriterion("CTYPE <>", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThan(String value) {
            addCriterion("CTYPE >", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThanOrEqualTo(String value) {
            addCriterion("CTYPE >=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThan(String value) {
            addCriterion("CTYPE <", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThanOrEqualTo(String value) {
            addCriterion("CTYPE <=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLike(String value) {
            addCriterion("CTYPE like", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotLike(String value) {
            addCriterion("CTYPE not like", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeIn(List<String> values) {
            addCriterion("CTYPE in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotIn(List<String> values) {
            addCriterion("CTYPE not in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeBetween(String value1, String value2) {
            addCriterion("CTYPE between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotBetween(String value1, String value2) {
            addCriterion("CTYPE not between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("DEPT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("DEPT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("DEPT_NAME =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("DEPT_NAME <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("DEPT_NAME >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("DEPT_NAME <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("DEPT_NAME like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("DEPT_NAME not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("DEPT_NAME in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("DEPT_NAME not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("DEPT_NAME between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("DEPT_NAME not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andVoterIsNull() {
            addCriterion("VOTER is null");
            return (Criteria) this;
        }

        public Criteria andVoterIsNotNull() {
            addCriterion("VOTER is not null");
            return (Criteria) this;
        }

        public Criteria andVoterEqualTo(String value) {
            addCriterion("VOTER =", value, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterNotEqualTo(String value) {
            addCriterion("VOTER <>", value, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterGreaterThan(String value) {
            addCriterion("VOTER >", value, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterGreaterThanOrEqualTo(String value) {
            addCriterion("VOTER >=", value, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterLessThan(String value) {
            addCriterion("VOTER <", value, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterLessThanOrEqualTo(String value) {
            addCriterion("VOTER <=", value, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterLike(String value) {
            addCriterion("VOTER like", value, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterNotLike(String value) {
            addCriterion("VOTER not like", value, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterIn(List<String> values) {
            addCriterion("VOTER in", values, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterNotIn(List<String> values) {
            addCriterion("VOTER not in", values, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterBetween(String value1, String value2) {
            addCriterion("VOTER between", value1, value2, "voter");
            return (Criteria) this;
        }

        public Criteria andVoterNotBetween(String value1, String value2) {
            addCriterion("VOTER not between", value1, value2, "voter");
            return (Criteria) this;
        }

        public Criteria andVoteValueIsNull() {
            addCriterion("VOTE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andVoteValueIsNotNull() {
            addCriterion("VOTE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andVoteValueEqualTo(Integer value) {
            addCriterion("VOTE_VALUE =", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueNotEqualTo(Integer value) {
            addCriterion("VOTE_VALUE <>", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueGreaterThan(Integer value) {
            addCriterion("VOTE_VALUE >", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("VOTE_VALUE >=", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueLessThan(Integer value) {
            addCriterion("VOTE_VALUE <", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueLessThanOrEqualTo(Integer value) {
            addCriterion("VOTE_VALUE <=", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueIn(List<Integer> values) {
            addCriterion("VOTE_VALUE in", values, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueNotIn(List<Integer> values) {
            addCriterion("VOTE_VALUE not in", values, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueBetween(Integer value1, Integer value2) {
            addCriterion("VOTE_VALUE between", value1, value2, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueNotBetween(Integer value1, Integer value2) {
            addCriterion("VOTE_VALUE not between", value1, value2, "voteValue");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andAdviseIsNull() {
            addCriterion("ADVISE is null");
            return (Criteria) this;
        }

        public Criteria andAdviseIsNotNull() {
            addCriterion("ADVISE is not null");
            return (Criteria) this;
        }

        public Criteria andAdviseEqualTo(String value) {
            addCriterion("ADVISE =", value, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseNotEqualTo(String value) {
            addCriterion("ADVISE <>", value, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseGreaterThan(String value) {
            addCriterion("ADVISE >", value, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseGreaterThanOrEqualTo(String value) {
            addCriterion("ADVISE >=", value, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseLessThan(String value) {
            addCriterion("ADVISE <", value, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseLessThanOrEqualTo(String value) {
            addCriterion("ADVISE <=", value, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseLike(String value) {
            addCriterion("ADVISE like", value, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseNotLike(String value) {
            addCriterion("ADVISE not like", value, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseIn(List<String> values) {
            addCriterion("ADVISE in", values, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseNotIn(List<String> values) {
            addCriterion("ADVISE not in", values, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseBetween(String value1, String value2) {
            addCriterion("ADVISE between", value1, value2, "advise");
            return (Criteria) this;
        }

        public Criteria andAdviseNotBetween(String value1, String value2) {
            addCriterion("ADVISE not between", value1, value2, "advise");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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