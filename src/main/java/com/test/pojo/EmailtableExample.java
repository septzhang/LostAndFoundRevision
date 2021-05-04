package com.test.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailtableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailtableExample() {
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

        public Criteria andEmailIdIsNull() {
            addCriterion("email_id is null");
            return (Criteria) this;
        }

        public Criteria andEmailIdIsNotNull() {
            addCriterion("email_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmailIdEqualTo(Integer value) {
            addCriterion("email_id =", value, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailIdNotEqualTo(Integer value) {
            addCriterion("email_id <>", value, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailIdGreaterThan(Integer value) {
            addCriterion("email_id >", value, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("email_id >=", value, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailIdLessThan(Integer value) {
            addCriterion("email_id <", value, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailIdLessThanOrEqualTo(Integer value) {
            addCriterion("email_id <=", value, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailIdIn(List<Integer> values) {
            addCriterion("email_id in", values, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailIdNotIn(List<Integer> values) {
            addCriterion("email_id not in", values, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailIdBetween(Integer value1, Integer value2) {
            addCriterion("email_id between", value1, value2, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("email_id not between", value1, value2, "emailId");
            return (Criteria) this;
        }

        public Criteria andEmailSenderIsNull() {
            addCriterion("email_sender is null");
            return (Criteria) this;
        }

        public Criteria andEmailSenderIsNotNull() {
            addCriterion("email_sender is not null");
            return (Criteria) this;
        }

        public Criteria andEmailSenderEqualTo(String value) {
            addCriterion("email_sender =", value, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderNotEqualTo(String value) {
            addCriterion("email_sender <>", value, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderGreaterThan(String value) {
            addCriterion("email_sender >", value, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderGreaterThanOrEqualTo(String value) {
            addCriterion("email_sender >=", value, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderLessThan(String value) {
            addCriterion("email_sender <", value, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderLessThanOrEqualTo(String value) {
            addCriterion("email_sender <=", value, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderLike(String value) {
            addCriterion("email_sender like", value, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderNotLike(String value) {
            addCriterion("email_sender not like", value, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderIn(List<String> values) {
            addCriterion("email_sender in", values, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderNotIn(List<String> values) {
            addCriterion("email_sender not in", values, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderBetween(String value1, String value2) {
            addCriterion("email_sender between", value1, value2, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailSenderNotBetween(String value1, String value2) {
            addCriterion("email_sender not between", value1, value2, "emailSender");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeIsNull() {
            addCriterion("email_addressee is null");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeIsNotNull() {
            addCriterion("email_addressee is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeEqualTo(String value) {
            addCriterion("email_addressee =", value, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeNotEqualTo(String value) {
            addCriterion("email_addressee <>", value, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeGreaterThan(String value) {
            addCriterion("email_addressee >", value, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeGreaterThanOrEqualTo(String value) {
            addCriterion("email_addressee >=", value, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeLessThan(String value) {
            addCriterion("email_addressee <", value, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeLessThanOrEqualTo(String value) {
            addCriterion("email_addressee <=", value, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeLike(String value) {
            addCriterion("email_addressee like", value, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeNotLike(String value) {
            addCriterion("email_addressee not like", value, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeIn(List<String> values) {
            addCriterion("email_addressee in", values, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeNotIn(List<String> values) {
            addCriterion("email_addressee not in", values, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeBetween(String value1, String value2) {
            addCriterion("email_addressee between", value1, value2, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailAddresseeNotBetween(String value1, String value2) {
            addCriterion("email_addressee not between", value1, value2, "emailAddressee");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIsNull() {
            addCriterion("email_status is null");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIsNotNull() {
            addCriterion("email_status is not null");
            return (Criteria) this;
        }

        public Criteria andEmailStatusEqualTo(Byte value) {
            addCriterion("email_status =", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotEqualTo(Byte value) {
            addCriterion("email_status <>", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusGreaterThan(Byte value) {
            addCriterion("email_status >", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("email_status >=", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLessThan(Byte value) {
            addCriterion("email_status <", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLessThanOrEqualTo(Byte value) {
            addCriterion("email_status <=", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIn(List<Byte> values) {
            addCriterion("email_status in", values, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotIn(List<Byte> values) {
            addCriterion("email_status not in", values, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusBetween(Byte value1, Byte value2) {
            addCriterion("email_status between", value1, value2, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("email_status not between", value1, value2, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailInfoIsNull() {
            addCriterion("email_info is null");
            return (Criteria) this;
        }

        public Criteria andEmailInfoIsNotNull() {
            addCriterion("email_info is not null");
            return (Criteria) this;
        }

        public Criteria andEmailInfoEqualTo(String value) {
            addCriterion("email_info =", value, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoNotEqualTo(String value) {
            addCriterion("email_info <>", value, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoGreaterThan(String value) {
            addCriterion("email_info >", value, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoGreaterThanOrEqualTo(String value) {
            addCriterion("email_info >=", value, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoLessThan(String value) {
            addCriterion("email_info <", value, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoLessThanOrEqualTo(String value) {
            addCriterion("email_info <=", value, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoLike(String value) {
            addCriterion("email_info like", value, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoNotLike(String value) {
            addCriterion("email_info not like", value, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoIn(List<String> values) {
            addCriterion("email_info in", values, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoNotIn(List<String> values) {
            addCriterion("email_info not in", values, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoBetween(String value1, String value2) {
            addCriterion("email_info between", value1, value2, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailInfoNotBetween(String value1, String value2) {
            addCriterion("email_info not between", value1, value2, "emailInfo");
            return (Criteria) this;
        }

        public Criteria andEmailTimeIsNull() {
            addCriterion("email_time is null");
            return (Criteria) this;
        }

        public Criteria andEmailTimeIsNotNull() {
            addCriterion("email_time is not null");
            return (Criteria) this;
        }

        public Criteria andEmailTimeEqualTo(Date value) {
            addCriterion("email_time =", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeNotEqualTo(Date value) {
            addCriterion("email_time <>", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeGreaterThan(Date value) {
            addCriterion("email_time >", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("email_time >=", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeLessThan(Date value) {
            addCriterion("email_time <", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeLessThanOrEqualTo(Date value) {
            addCriterion("email_time <=", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeIn(List<Date> values) {
            addCriterion("email_time in", values, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeNotIn(List<Date> values) {
            addCriterion("email_time not in", values, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeBetween(Date value1, Date value2) {
            addCriterion("email_time between", value1, value2, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeNotBetween(Date value1, Date value2) {
            addCriterion("email_time not between", value1, value2, "emailTime");
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