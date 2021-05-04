package com.test.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodstableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodstableExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsIsNull() {
            addCriterion("goods_kinds is null");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsIsNotNull() {
            addCriterion("goods_kinds is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsEqualTo(Byte value) {
            addCriterion("goods_kinds =", value, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsNotEqualTo(Byte value) {
            addCriterion("goods_kinds <>", value, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsGreaterThan(Byte value) {
            addCriterion("goods_kinds >", value, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsGreaterThanOrEqualTo(Byte value) {
            addCriterion("goods_kinds >=", value, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsLessThan(Byte value) {
            addCriterion("goods_kinds <", value, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsLessThanOrEqualTo(Byte value) {
            addCriterion("goods_kinds <=", value, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsIn(List<Byte> values) {
            addCriterion("goods_kinds in", values, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsNotIn(List<Byte> values) {
            addCriterion("goods_kinds not in", values, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsBetween(Byte value1, Byte value2) {
            addCriterion("goods_kinds between", value1, value2, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsKindsNotBetween(Byte value1, Byte value2) {
            addCriterion("goods_kinds not between", value1, value2, "goodsKinds");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIsNull() {
            addCriterion("goods_info is null");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIsNotNull() {
            addCriterion("goods_info is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoEqualTo(String value) {
            addCriterion("goods_info =", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotEqualTo(String value) {
            addCriterion("goods_info <>", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoGreaterThan(String value) {
            addCriterion("goods_info >", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoGreaterThanOrEqualTo(String value) {
            addCriterion("goods_info >=", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLessThan(String value) {
            addCriterion("goods_info <", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLessThanOrEqualTo(String value) {
            addCriterion("goods_info <=", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLike(String value) {
            addCriterion("goods_info like", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotLike(String value) {
            addCriterion("goods_info not like", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIn(List<String> values) {
            addCriterion("goods_info in", values, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotIn(List<String> values) {
            addCriterion("goods_info not in", values, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoBetween(String value1, String value2) {
            addCriterion("goods_info between", value1, value2, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotBetween(String value1, String value2) {
            addCriterion("goods_info not between", value1, value2, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNull() {
            addCriterion("goods_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNotNull() {
            addCriterion("goods_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgEqualTo(String value) {
            addCriterion("goods_img =", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotEqualTo(String value) {
            addCriterion("goods_img <>", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThan(String value) {
            addCriterion("goods_img >", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_img >=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThan(String value) {
            addCriterion("goods_img <", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThanOrEqualTo(String value) {
            addCriterion("goods_img <=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLike(String value) {
            addCriterion("goods_img like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotLike(String value) {
            addCriterion("goods_img not like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIn(List<String> values) {
            addCriterion("goods_img in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotIn(List<String> values) {
            addCriterion("goods_img not in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgBetween(String value1, String value2) {
            addCriterion("goods_img between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotBetween(String value1, String value2) {
            addCriterion("goods_img not between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteIsNull() {
            addCriterion("goods_site is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteIsNotNull() {
            addCriterion("goods_site is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteEqualTo(String value) {
            addCriterion("goods_site =", value, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteNotEqualTo(String value) {
            addCriterion("goods_site <>", value, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteGreaterThan(String value) {
            addCriterion("goods_site >", value, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteGreaterThanOrEqualTo(String value) {
            addCriterion("goods_site >=", value, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteLessThan(String value) {
            addCriterion("goods_site <", value, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteLessThanOrEqualTo(String value) {
            addCriterion("goods_site <=", value, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteLike(String value) {
            addCriterion("goods_site like", value, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteNotLike(String value) {
            addCriterion("goods_site not like", value, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteIn(List<String> values) {
            addCriterion("goods_site in", values, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteNotIn(List<String> values) {
            addCriterion("goods_site not in", values, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteBetween(String value1, String value2) {
            addCriterion("goods_site between", value1, value2, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsSiteNotBetween(String value1, String value2) {
            addCriterion("goods_site not between", value1, value2, "goodsSite");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterIsNull() {
            addCriterion("goods_master is null");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterIsNotNull() {
            addCriterion("goods_master is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterEqualTo(String value) {
            addCriterion("goods_master =", value, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterNotEqualTo(String value) {
            addCriterion("goods_master <>", value, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterGreaterThan(String value) {
            addCriterion("goods_master >", value, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterGreaterThanOrEqualTo(String value) {
            addCriterion("goods_master >=", value, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterLessThan(String value) {
            addCriterion("goods_master <", value, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterLessThanOrEqualTo(String value) {
            addCriterion("goods_master <=", value, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterLike(String value) {
            addCriterion("goods_master like", value, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterNotLike(String value) {
            addCriterion("goods_master not like", value, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterIn(List<String> values) {
            addCriterion("goods_master in", values, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterNotIn(List<String> values) {
            addCriterion("goods_master not in", values, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterBetween(String value1, String value2) {
            addCriterion("goods_master between", value1, value2, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsMasterNotBetween(String value1, String value2) {
            addCriterion("goods_master not between", value1, value2, "goodsMaster");
            return (Criteria) this;
        }

        public Criteria andGoodsContactIsNull() {
            addCriterion("goods_contact is null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactIsNotNull() {
            addCriterion("goods_contact is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactEqualTo(String value) {
            addCriterion("goods_contact =", value, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNotEqualTo(String value) {
            addCriterion("goods_contact <>", value, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactGreaterThan(String value) {
            addCriterion("goods_contact >", value, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactGreaterThanOrEqualTo(String value) {
            addCriterion("goods_contact >=", value, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactLessThan(String value) {
            addCriterion("goods_contact <", value, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactLessThanOrEqualTo(String value) {
            addCriterion("goods_contact <=", value, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactLike(String value) {
            addCriterion("goods_contact like", value, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNotLike(String value) {
            addCriterion("goods_contact not like", value, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactIn(List<String> values) {
            addCriterion("goods_contact in", values, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNotIn(List<String> values) {
            addCriterion("goods_contact not in", values, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactBetween(String value1, String value2) {
            addCriterion("goods_contact between", value1, value2, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNotBetween(String value1, String value2) {
            addCriterion("goods_contact not between", value1, value2, "goodsContact");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeIsNull() {
            addCriterion("goods_time is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeIsNotNull() {
            addCriterion("goods_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeEqualTo(Date value) {
            addCriterion("goods_time =", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeNotEqualTo(Date value) {
            addCriterion("goods_time <>", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeGreaterThan(Date value) {
            addCriterion("goods_time >", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_time >=", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeLessThan(Date value) {
            addCriterion("goods_time <", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeLessThanOrEqualTo(Date value) {
            addCriterion("goods_time <=", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeIn(List<Date> values) {
            addCriterion("goods_time in", values, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeNotIn(List<Date> values) {
            addCriterion("goods_time not in", values, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeBetween(Date value1, Date value2) {
            addCriterion("goods_time between", value1, value2, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeNotBetween(Date value1, Date value2) {
            addCriterion("goods_time not between", value1, value2, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessIsNull() {
            addCriterion("goods_success is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessIsNotNull() {
            addCriterion("goods_success is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessEqualTo(Integer value) {
            addCriterion("goods_success =", value, "goodsSuccess");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessNotEqualTo(Integer value) {
            addCriterion("goods_success <>", value, "goodsSuccess");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessGreaterThan(Integer value) {
            addCriterion("goods_success >", value, "goodsSuccess");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_success >=", value, "goodsSuccess");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessLessThan(Integer value) {
            addCriterion("goods_success <", value, "goodsSuccess");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessLessThanOrEqualTo(Integer value) {
            addCriterion("goods_success <=", value, "goodsSuccess");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessIn(List<Integer> values) {
            addCriterion("goods_success in", values, "goodsSuccess");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessNotIn(List<Integer> values) {
            addCriterion("goods_success not in", values, "goodsSuccess");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessBetween(Integer value1, Integer value2) {
            addCriterion("goods_success between", value1, value2, "goodsSuccess");
            return (Criteria) this;
        }

        public Criteria andGoodsSuccessNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_success not between", value1, value2, "goodsSuccess");
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