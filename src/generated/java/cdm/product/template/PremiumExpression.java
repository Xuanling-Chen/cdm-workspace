package cdm.product.template;

import cdm.observable.asset.Money;
import cdm.product.template.meta.PremiumExpressionMeta;
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
 * This class corresponds to the FpML Premium.model group for representing the option premium when expressed in a way other than an amount.
 * @version ${project.version}
 */
@RosettaClass

public interface PremiumExpression extends RosettaModelObject {
	PremiumExpression build();
	PremiumExpression.PremiumExpressionBuilder toBuilder();
	
	/**
	 * The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.
	 */
	BigDecimal getPercentageOfNotional();
	/**
	 * Forward start premium type
	 */
	PremiumTypeEnum getPremiumType();
	/**
	 * The amount of premium to be paid expressed as a function of the number of options.
	 */
	Money getPricePerOption();
	final static PremiumExpressionMeta metaData = new PremiumExpressionMeta();
	
	@Override
	default RosettaMetaData<? extends PremiumExpression> metaData() {
		return metaData;
	} 
			
	static PremiumExpression.PremiumExpressionBuilder builder() {
		return new PremiumExpression.PremiumExpressionBuilderImpl();
	}
	
	default Class<? extends PremiumExpression> getType() {
		return PremiumExpression.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
		processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
		
		processRosetta(path.newSubPath("pricePerOption"), processor, Money.class, getPricePerOption());
	}
	
	
	interface PremiumExpressionBuilder extends PremiumExpression, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreatePricePerOption();
		Money.MoneyBuilder getPricePerOption();
		PremiumExpression.PremiumExpressionBuilder setPercentageOfNotional(BigDecimal percentageOfNotional);
		PremiumExpression.PremiumExpressionBuilder setPremiumType(PremiumTypeEnum premiumType);
		PremiumExpression.PremiumExpressionBuilder setPricePerOption(Money pricePerOption);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
			processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
			
			processRosetta(path.newSubPath("pricePerOption"), processor, Money.MoneyBuilder.class, getPricePerOption());
		}
		
	}
	
	//PremiumExpression.PremiumExpressionImpl
	class PremiumExpressionImpl implements PremiumExpression {
		private final BigDecimal percentageOfNotional;
		private final PremiumTypeEnum premiumType;
		private final Money pricePerOption;
		
		protected PremiumExpressionImpl(PremiumExpression.PremiumExpressionBuilder builder) {
			this.percentageOfNotional = builder.getPercentageOfNotional();
			this.premiumType = builder.getPremiumType();
			this.pricePerOption = ofNullable(builder.getPricePerOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getPercentageOfNotional() {
			return percentageOfNotional;
		}
		
		@Override
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
		}
		
		@Override
		public Money getPricePerOption() {
			return pricePerOption;
		}
		
		@Override
		public PremiumExpression build() {
			return this;
		}
		
		@Override
		public PremiumExpression.PremiumExpressionBuilder toBuilder() {
			PremiumExpression.PremiumExpressionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PremiumExpression.PremiumExpressionBuilder builder) {
			ofNullable(getPercentageOfNotional()).ifPresent(builder::setPercentageOfNotional);
			ofNullable(getPremiumType()).ifPresent(builder::setPremiumType);
			ofNullable(getPricePerOption()).ifPresent(builder::setPricePerOption);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PremiumExpression _that = getType().cast(o);
		
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PremiumExpression {" +
				"percentageOfNotional=" + this.percentageOfNotional + ", " +
				"premiumType=" + this.premiumType + ", " +
				"pricePerOption=" + this.pricePerOption +
			'}';
		}
	}
	
	//PremiumExpression.PremiumExpressionBuilderImpl
	class PremiumExpressionBuilderImpl implements PremiumExpression.PremiumExpressionBuilder {
	
		protected BigDecimal percentageOfNotional;
		protected PremiumTypeEnum premiumType;
		protected Money.MoneyBuilder pricePerOption;
	
		public PremiumExpressionBuilderImpl() {
		}
	
		@Override
		public BigDecimal getPercentageOfNotional() {
			return percentageOfNotional;
		}
		
		@Override
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
		}
		
		@Override
		public Money.MoneyBuilder getPricePerOption() {
			return pricePerOption;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePricePerOption() {
			Money.MoneyBuilder result;
			if (pricePerOption!=null) {
				result = pricePerOption;
			}
			else {
				result = pricePerOption = Money.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PremiumExpression.PremiumExpressionBuilder setPercentageOfNotional(BigDecimal percentageOfNotional) {
			this.percentageOfNotional = percentageOfNotional==null?null:percentageOfNotional;
			return this;
		}
		@Override
		public PremiumExpression.PremiumExpressionBuilder setPremiumType(PremiumTypeEnum premiumType) {
			this.premiumType = premiumType==null?null:premiumType;
			return this;
		}
		@Override
		public PremiumExpression.PremiumExpressionBuilder setPricePerOption(Money pricePerOption) {
			this.pricePerOption = pricePerOption==null?null:pricePerOption.toBuilder();
			return this;
		}
		
		@Override
		public PremiumExpression build() {
			return new PremiumExpression.PremiumExpressionImpl(this);
		}
		
		@Override
		public PremiumExpression.PremiumExpressionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PremiumExpression.PremiumExpressionBuilder prune() {
			if (pricePerOption!=null && !pricePerOption.prune().hasData()) pricePerOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPercentageOfNotional()!=null) return true;
			if (getPremiumType()!=null) return true;
			if (getPricePerOption()!=null && getPricePerOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PremiumExpression.PremiumExpressionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PremiumExpression.PremiumExpressionBuilder o = (PremiumExpression.PremiumExpressionBuilder) other;
			
			merger.mergeRosetta(getPricePerOption(), o.getPricePerOption(), this::setPricePerOption);
			
			merger.mergeBasic(getPercentageOfNotional(), o.getPercentageOfNotional(), this::setPercentageOfNotional);
			merger.mergeBasic(getPremiumType(), o.getPremiumType(), this::setPremiumType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PremiumExpression _that = getType().cast(o);
		
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PremiumExpressionBuilder {" +
				"percentageOfNotional=" + this.percentageOfNotional + ", " +
				"premiumType=" + this.premiumType + ", " +
				"pricePerOption=" + this.pricePerOption +
			'}';
		}
	}
}
