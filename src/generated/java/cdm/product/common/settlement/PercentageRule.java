package cdm.product.common.settlement;

import cdm.observable.asset.Money;
import cdm.observable.asset.Money;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder;
import cdm.product.common.settlement.meta.PercentageRuleMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining a content model for a calculation rule defined as percentage of the notional amount.
 * @version ${project.version}
 */
@RosettaClass

public interface PercentageRule extends RosettaModelObject {
	PercentageRule build();
	PercentageRule.PercentageRuleBuilder toBuilder();
	
	/**
	 * A reference to the notional amount.
	 */
	ReferenceWithMetaMoney getNotionalAmountReference();
	/**
	 * A percentage of the notional amount.
	 */
	BigDecimal getPaymentPercent();
	final static PercentageRuleMeta metaData = new PercentageRuleMeta();
	
	@Override
	default RosettaMetaData<? extends PercentageRule> metaData() {
		return metaData;
	} 
			
	static PercentageRule.PercentageRuleBuilder builder() {
		return new PercentageRule.PercentageRuleBuilderImpl();
	}
	
	default Class<? extends PercentageRule> getType() {
		return PercentageRule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("paymentPercent"), BigDecimal.class, getPaymentPercent(), this);
		
		processRosetta(path.newSubPath("notionalAmountReference"), processor, ReferenceWithMetaMoney.class, getNotionalAmountReference());
	}
	
	
	interface PercentageRuleBuilder extends PercentageRule, RosettaModelObjectBuilder {
		ReferenceWithMetaMoneyBuilder getOrCreateNotionalAmountReference();
		ReferenceWithMetaMoneyBuilder getNotionalAmountReference();
		PercentageRule.PercentageRuleBuilder setNotionalAmountReference(ReferenceWithMetaMoney notionalAmountReference);
		PercentageRule.PercentageRuleBuilder setNotionalAmountReferenceValue(Money notionalAmountReference);
		PercentageRule.PercentageRuleBuilder setPaymentPercent(BigDecimal paymentPercent);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("paymentPercent"), BigDecimal.class, getPaymentPercent(), this);
			
			processRosetta(path.newSubPath("notionalAmountReference"), processor, ReferenceWithMetaMoneyBuilder.class, getNotionalAmountReference());
		}
		
	}
	
	//PercentageRule.PercentageRuleImpl
	class PercentageRuleImpl implements PercentageRule {
		private final ReferenceWithMetaMoney notionalAmountReference;
		private final BigDecimal paymentPercent;
		
		protected PercentageRuleImpl(PercentageRule.PercentageRuleBuilder builder) {
			this.notionalAmountReference = ofNullable(builder.getNotionalAmountReference()).map(f->f.build()).orElse(null);
			this.paymentPercent = builder.getPaymentPercent();
		}
		
		@Override
		public ReferenceWithMetaMoney getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		public BigDecimal getPaymentPercent() {
			return paymentPercent;
		}
		
		@Override
		public PercentageRule build() {
			return this;
		}
		
		@Override
		public PercentageRule.PercentageRuleBuilder toBuilder() {
			PercentageRule.PercentageRuleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PercentageRule.PercentageRuleBuilder builder) {
			ofNullable(getNotionalAmountReference()).ifPresent(builder::setNotionalAmountReference);
			ofNullable(getPaymentPercent()).ifPresent(builder::setPaymentPercent);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PercentageRule _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(paymentPercent, _that.getPaymentPercent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (paymentPercent != null ? paymentPercent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PercentageRule {" +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"paymentPercent=" + this.paymentPercent +
			'}';
		}
	}
	
	//PercentageRule.PercentageRuleBuilderImpl
	class PercentageRuleBuilderImpl implements PercentageRule.PercentageRuleBuilder {
	
		protected ReferenceWithMetaMoneyBuilder notionalAmountReference;
		protected BigDecimal paymentPercent;
	
		public PercentageRuleBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaMoneyBuilder getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		public ReferenceWithMetaMoneyBuilder getOrCreateNotionalAmountReference() {
			ReferenceWithMetaMoneyBuilder result;
			if (notionalAmountReference!=null) {
				result = notionalAmountReference;
			}
			else {
				result = notionalAmountReference = ReferenceWithMetaMoney.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getPaymentPercent() {
			return paymentPercent;
		}
		
	
		@Override
		public PercentageRule.PercentageRuleBuilder setNotionalAmountReference(ReferenceWithMetaMoney notionalAmountReference) {
			this.notionalAmountReference = notionalAmountReference==null?null:notionalAmountReference.toBuilder();
			return this;
		}
		
		@Override
		public PercentageRule.PercentageRuleBuilder setNotionalAmountReferenceValue(Money notionalAmountReference) {
			this.getOrCreateNotionalAmountReference().setValue(notionalAmountReference);
			return this;
		}
		@Override
		public PercentageRule.PercentageRuleBuilder setPaymentPercent(BigDecimal paymentPercent) {
			this.paymentPercent = paymentPercent==null?null:paymentPercent;
			return this;
		}
		
		@Override
		public PercentageRule build() {
			return new PercentageRule.PercentageRuleImpl(this);
		}
		
		@Override
		public PercentageRule.PercentageRuleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PercentageRule.PercentageRuleBuilder prune() {
			if (notionalAmountReference!=null && !notionalAmountReference.prune().hasData()) notionalAmountReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalAmountReference()!=null && getNotionalAmountReference().hasData()) return true;
			if (getPaymentPercent()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PercentageRule.PercentageRuleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PercentageRule.PercentageRuleBuilder o = (PercentageRule.PercentageRuleBuilder) other;
			
			merger.mergeRosetta(getNotionalAmountReference(), o.getNotionalAmountReference(), this::setNotionalAmountReference);
			
			merger.mergeBasic(getPaymentPercent(), o.getPaymentPercent(), this::setPaymentPercent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PercentageRule _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(paymentPercent, _that.getPaymentPercent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (paymentPercent != null ? paymentPercent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PercentageRuleBuilder {" +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"paymentPercent=" + this.paymentPercent +
			'}';
		}
	}
}
