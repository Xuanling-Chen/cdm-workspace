package cdm.product.common.settlement;

import cdm.product.common.settlement.meta.PaymentRuleMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining the payment calculation rule. As of FpML 5.10, percentage rule is the only calculation rule that has been specified as part of the standard.
 * @version ${project.version}
 */
@RosettaClass

public interface PaymentRule extends RosettaModelObject {
	PaymentRule build();
	PaymentRule.PaymentRuleBuilder toBuilder();
	
	/**
	 * This attribute is not present as part of the FpML construct, as the payment rule is specialised by means of runtime type extension through the xsi:type.
	 */
	PercentageRule getPercentageRule();
	final static PaymentRuleMeta metaData = new PaymentRuleMeta();
	
	@Override
	default RosettaMetaData<? extends PaymentRule> metaData() {
		return metaData;
	} 
			
	static PaymentRule.PaymentRuleBuilder builder() {
		return new PaymentRule.PaymentRuleBuilderImpl();
	}
	
	default Class<? extends PaymentRule> getType() {
		return PaymentRule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("percentageRule"), processor, PercentageRule.class, getPercentageRule());
	}
	
	
	interface PaymentRuleBuilder extends PaymentRule, RosettaModelObjectBuilder {
		PercentageRule.PercentageRuleBuilder getOrCreatePercentageRule();
		PercentageRule.PercentageRuleBuilder getPercentageRule();
		PaymentRule.PaymentRuleBuilder setPercentageRule(PercentageRule percentageRule);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("percentageRule"), processor, PercentageRule.PercentageRuleBuilder.class, getPercentageRule());
		}
		
	}
	
	//PaymentRule.PaymentRuleImpl
	class PaymentRuleImpl implements PaymentRule {
		private final PercentageRule percentageRule;
		
		protected PaymentRuleImpl(PaymentRule.PaymentRuleBuilder builder) {
			this.percentageRule = ofNullable(builder.getPercentageRule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public PercentageRule getPercentageRule() {
			return percentageRule;
		}
		
		@Override
		public PaymentRule build() {
			return this;
		}
		
		@Override
		public PaymentRule.PaymentRuleBuilder toBuilder() {
			PaymentRule.PaymentRuleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentRule.PaymentRuleBuilder builder) {
			ofNullable(getPercentageRule()).ifPresent(builder::setPercentageRule);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentRule _that = getType().cast(o);
		
			if (!Objects.equals(percentageRule, _that.getPercentageRule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (percentageRule != null ? percentageRule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentRule {" +
				"percentageRule=" + this.percentageRule +
			'}';
		}
	}
	
	//PaymentRule.PaymentRuleBuilderImpl
	class PaymentRuleBuilderImpl implements PaymentRule.PaymentRuleBuilder {
	
		protected PercentageRule.PercentageRuleBuilder percentageRule;
	
		public PaymentRuleBuilderImpl() {
		}
	
		@Override
		public PercentageRule.PercentageRuleBuilder getPercentageRule() {
			return percentageRule;
		}
		
		@Override
		public PercentageRule.PercentageRuleBuilder getOrCreatePercentageRule() {
			PercentageRule.PercentageRuleBuilder result;
			if (percentageRule!=null) {
				result = percentageRule;
			}
			else {
				result = percentageRule = PercentageRule.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PaymentRule.PaymentRuleBuilder setPercentageRule(PercentageRule percentageRule) {
			this.percentageRule = percentageRule==null?null:percentageRule.toBuilder();
			return this;
		}
		
		@Override
		public PaymentRule build() {
			return new PaymentRule.PaymentRuleImpl(this);
		}
		
		@Override
		public PaymentRule.PaymentRuleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentRule.PaymentRuleBuilder prune() {
			if (percentageRule!=null && !percentageRule.prune().hasData()) percentageRule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPercentageRule()!=null && getPercentageRule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentRule.PaymentRuleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentRule.PaymentRuleBuilder o = (PaymentRule.PaymentRuleBuilder) other;
			
			merger.mergeRosetta(getPercentageRule(), o.getPercentageRule(), this::setPercentageRule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentRule _that = getType().cast(o);
		
			if (!Objects.equals(percentageRule, _that.getPercentageRule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (percentageRule != null ? percentageRule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentRuleBuilder {" +
				"percentageRule=" + this.percentageRule +
			'}';
		}
	}
}
