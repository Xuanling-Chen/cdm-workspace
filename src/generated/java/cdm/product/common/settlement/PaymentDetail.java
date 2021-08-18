package cdm.product.common.settlement;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.observable.asset.Money;
import cdm.product.common.settlement.meta.PaymentDetailMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface PaymentDetail extends RosettaModelObject, GlobalKey {
	PaymentDetail build();
	PaymentDetail.PaymentDetailBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 * A fixed payment amount.
	 */
	Money getPaymentAmount();
	/**
	 */
	AdjustableOrRelativeDate getPaymentDate();
	/**
	 * The calculation rule.
	 */
	PaymentRule getPaymentRule();
	final static PaymentDetailMeta metaData = new PaymentDetailMeta();
	
	@Override
	default RosettaMetaData<? extends PaymentDetail> metaData() {
		return metaData;
	} 
			
	static PaymentDetail.PaymentDetailBuilder builder() {
		return new PaymentDetail.PaymentDetailBuilderImpl();
	}
	
	default Class<? extends PaymentDetail> getType() {
		return PaymentDetail.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("paymentAmount"), processor, Money.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentRule"), processor, PaymentRule.class, getPaymentRule());
	}
	
	
	interface PaymentDetailBuilder extends PaymentDetail, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Money.MoneyBuilder getOrCreatePaymentAmount();
		Money.MoneyBuilder getPaymentAmount();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate();
		PaymentRule.PaymentRuleBuilder getOrCreatePaymentRule();
		PaymentRule.PaymentRuleBuilder getPaymentRule();
		PaymentDetail.PaymentDetailBuilder setMeta(MetaFields meta);
		PaymentDetail.PaymentDetailBuilder setPaymentAmount(Money paymentAmount);
		PaymentDetail.PaymentDetailBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		PaymentDetail.PaymentDetailBuilder setPaymentRule(PaymentRule paymentRule);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("paymentAmount"), processor, Money.MoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentRule"), processor, PaymentRule.PaymentRuleBuilder.class, getPaymentRule());
		}
		
	}
	
	//PaymentDetail.PaymentDetailImpl
	class PaymentDetailImpl implements PaymentDetail {
		private final MetaFields meta;
		private final Money paymentAmount;
		private final AdjustableOrRelativeDate paymentDate;
		private final PaymentRule paymentRule;
		
		protected PaymentDetailImpl(PaymentDetail.PaymentDetailBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.paymentRule = ofNullable(builder.getPaymentRule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Money getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public AdjustableOrRelativeDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public PaymentRule getPaymentRule() {
			return paymentRule;
		}
		
		@Override
		public PaymentDetail build() {
			return this;
		}
		
		@Override
		public PaymentDetail.PaymentDetailBuilder toBuilder() {
			PaymentDetail.PaymentDetailBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDetail.PaymentDetailBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getPaymentRule()).ifPresent(builder::setPaymentRule);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDetail _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentRule, _that.getPaymentRule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentRule != null ? paymentRule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetail {" +
				"meta=" + this.meta + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentRule=" + this.paymentRule +
			'}';
		}
	}
	
	//PaymentDetail.PaymentDetailBuilderImpl
	class PaymentDetailBuilderImpl implements PaymentDetail.PaymentDetailBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected Money.MoneyBuilder paymentAmount;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDate;
		protected PaymentRule.PaymentRuleBuilder paymentRule;
	
		public PaymentDetailBuilderImpl() {
		}
	
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public Money.MoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePaymentAmount() {
			Money.MoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public PaymentRule.PaymentRuleBuilder getPaymentRule() {
			return paymentRule;
		}
		
		@Override
		public PaymentRule.PaymentRuleBuilder getOrCreatePaymentRule() {
			PaymentRule.PaymentRuleBuilder result;
			if (paymentRule!=null) {
				result = paymentRule;
			}
			else {
				result = paymentRule = PaymentRule.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PaymentDetail.PaymentDetailBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public PaymentDetail.PaymentDetailBuilder setPaymentAmount(Money paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		public PaymentDetail.PaymentDetailBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		public PaymentDetail.PaymentDetailBuilder setPaymentRule(PaymentRule paymentRule) {
			this.paymentRule = paymentRule==null?null:paymentRule.toBuilder();
			return this;
		}
		
		@Override
		public PaymentDetail build() {
			return new PaymentDetail.PaymentDetailImpl(this);
		}
		
		@Override
		public PaymentDetail.PaymentDetailBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetail.PaymentDetailBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (paymentRule!=null && !paymentRule.prune().hasData()) paymentRule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getPaymentRule()!=null && getPaymentRule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetail.PaymentDetailBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentDetail.PaymentDetailBuilder o = (PaymentDetail.PaymentDetailBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getPaymentRule(), o.getPaymentRule(), this::setPaymentRule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDetail _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentRule, _that.getPaymentRule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentRule != null ? paymentRule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetailBuilder {" +
				"meta=" + this.meta + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentRule=" + this.paymentRule +
			'}';
		}
	}
}
