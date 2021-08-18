package cdm.event.workflow;

import cdm.event.workflow.LimitApplicable.LimitApplicableBuilder;
import cdm.event.workflow.LimitApplicable.LimitApplicableBuilderImpl;
import cdm.event.workflow.LimitApplicable.LimitApplicableImpl;
import cdm.event.workflow.meta.LimitApplicableExtendedMeta;
import cdm.event.workflow.metafields.FieldWithMetaCreditLimitTypeEnum;
import cdm.event.workflow.metafields.FieldWithMetaLimitLevelEnum;
import cdm.event.workflow.metafields.FieldWithMetaLimitLevelEnum.FieldWithMetaLimitLevelEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to represent the CDM attributes that are not part of the FpML standard. Once broader usage is confirmed, it is expected that those two classes can be collapsed.
 * @version ${project.version}
 */
@RosettaClass

public interface LimitApplicableExtended extends LimitApplicable {
	LimitApplicableExtended build();
	LimitApplicableExtended.LimitApplicableExtendedBuilder toBuilder();
	
	/**
	 * The total limit available for the limit level and limit type. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
	 */
	BigDecimal getLimitAmount();
	/**
	 * The limit utilized by this specific trade. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
	 */
	BigDecimal getLimitImpactDueToTrade();
	/**
	 * The level at which the limit is set: customer business, proprietary business or account level. This attribute is specified as a string as part of the CME clearing confirmation specification.
	 */
	FieldWithMetaLimitLevelEnum getLimitLevel();
	final static LimitApplicableExtendedMeta metaData = new LimitApplicableExtendedMeta();
	
	@Override
	default RosettaMetaData<? extends LimitApplicableExtended> metaData() {
		return metaData;
	} 
			
	static LimitApplicableExtended.LimitApplicableExtendedBuilder builder() {
		return new LimitApplicableExtended.LimitApplicableExtendedBuilderImpl();
	}
	
	default Class<? extends LimitApplicableExtended> getType() {
		return LimitApplicableExtended.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.event.workflow.LimitApplicable.super.process(path, processor);
		processor.processBasic(path.newSubPath("limitAmount"), BigDecimal.class, getLimitAmount(), this);
		processor.processBasic(path.newSubPath("limitImpactDueToTrade"), BigDecimal.class, getLimitImpactDueToTrade(), this);
		
		processRosetta(path.newSubPath("limitLevel"), processor, FieldWithMetaLimitLevelEnum.class, getLimitLevel());
	}
	
	
	interface LimitApplicableExtendedBuilder extends LimitApplicableExtended, LimitApplicable.LimitApplicableBuilder, RosettaModelObjectBuilder {
		FieldWithMetaLimitLevelEnumBuilder getOrCreateLimitLevel();
		FieldWithMetaLimitLevelEnumBuilder getLimitLevel();
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitAmount(BigDecimal limitAmount);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitImpactDueToTrade(BigDecimal limitImpactDueToTrade);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitLevel(FieldWithMetaLimitLevelEnum limitLevel);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitLevelValue(LimitLevelEnum limitLevel);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setAmountRemaining(BigDecimal amountRemaining);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setAmountUtilized(BigDecimal amountUtilized);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setClipSize(Integer clipSize);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setCurrency(FieldWithMetaString currency);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setCurrencyValue(String currency);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitType(FieldWithMetaCreditLimitTypeEnum limitType);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitTypeValue(CreditLimitTypeEnum limitType);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setUtilization(CreditLimitUtilisation utilization);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setVelocity(Velocity velocity);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			LimitApplicable.LimitApplicableBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("limitAmount"), BigDecimal.class, getLimitAmount(), this);
			processor.processBasic(path.newSubPath("limitImpactDueToTrade"), BigDecimal.class, getLimitImpactDueToTrade(), this);
			
			processRosetta(path.newSubPath("limitLevel"), processor, FieldWithMetaLimitLevelEnumBuilder.class, getLimitLevel());
		}
		
	}
	
	//LimitApplicableExtended.LimitApplicableExtendedImpl
	class LimitApplicableExtendedImpl extends LimitApplicable.LimitApplicableImpl implements LimitApplicableExtended {
		private final BigDecimal limitAmount;
		private final BigDecimal limitImpactDueToTrade;
		private final FieldWithMetaLimitLevelEnum limitLevel;
		
		protected LimitApplicableExtendedImpl(LimitApplicableExtended.LimitApplicableExtendedBuilder builder) {
			super(builder);
			this.limitAmount = builder.getLimitAmount();
			this.limitImpactDueToTrade = builder.getLimitImpactDueToTrade();
			this.limitLevel = ofNullable(builder.getLimitLevel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getLimitAmount() {
			return limitAmount;
		}
		
		@Override
		public BigDecimal getLimitImpactDueToTrade() {
			return limitImpactDueToTrade;
		}
		
		@Override
		public FieldWithMetaLimitLevelEnum getLimitLevel() {
			return limitLevel;
		}
		
		@Override
		public LimitApplicableExtended build() {
			return this;
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder toBuilder() {
			LimitApplicableExtended.LimitApplicableExtendedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LimitApplicableExtended.LimitApplicableExtendedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLimitAmount()).ifPresent(builder::setLimitAmount);
			ofNullable(getLimitImpactDueToTrade()).ifPresent(builder::setLimitImpactDueToTrade);
			ofNullable(getLimitLevel()).ifPresent(builder::setLimitLevel);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LimitApplicableExtended _that = getType().cast(o);
		
			if (!Objects.equals(limitAmount, _that.getLimitAmount())) return false;
			if (!Objects.equals(limitImpactDueToTrade, _that.getLimitImpactDueToTrade())) return false;
			if (!Objects.equals(limitLevel, _that.getLimitLevel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (limitAmount != null ? limitAmount.hashCode() : 0);
			_result = 31 * _result + (limitImpactDueToTrade != null ? limitImpactDueToTrade.hashCode() : 0);
			_result = 31 * _result + (limitLevel != null ? limitLevel.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitApplicableExtended {" +
				"limitAmount=" + this.limitAmount + ", " +
				"limitImpactDueToTrade=" + this.limitImpactDueToTrade + ", " +
				"limitLevel=" + this.limitLevel +
			'}' + " " + super.toString();
		}
	}
	
	//LimitApplicableExtended.LimitApplicableExtendedBuilderImpl
	class LimitApplicableExtendedBuilderImpl extends LimitApplicable.LimitApplicableBuilderImpl  implements LimitApplicableExtended.LimitApplicableExtendedBuilder {
	
		protected BigDecimal limitAmount;
		protected BigDecimal limitImpactDueToTrade;
		protected FieldWithMetaLimitLevelEnumBuilder limitLevel;
	
		public LimitApplicableExtendedBuilderImpl() {
		}
	
		@Override
		public BigDecimal getLimitAmount() {
			return limitAmount;
		}
		
		@Override
		public BigDecimal getLimitImpactDueToTrade() {
			return limitImpactDueToTrade;
		}
		
		@Override
		public FieldWithMetaLimitLevelEnumBuilder getLimitLevel() {
			return limitLevel;
		}
		
		@Override
		public FieldWithMetaLimitLevelEnumBuilder getOrCreateLimitLevel() {
			FieldWithMetaLimitLevelEnumBuilder result;
			if (limitLevel!=null) {
				result = limitLevel;
			}
			else {
				result = limitLevel = FieldWithMetaLimitLevelEnum.builder();
			}
			
			return result;
		}
		
	
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitAmount(BigDecimal limitAmount) {
			this.limitAmount = limitAmount==null?null:limitAmount;
			return this;
		}
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitImpactDueToTrade(BigDecimal limitImpactDueToTrade) {
			this.limitImpactDueToTrade = limitImpactDueToTrade==null?null:limitImpactDueToTrade;
			return this;
		}
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitLevel(FieldWithMetaLimitLevelEnum limitLevel) {
			this.limitLevel = limitLevel==null?null:limitLevel.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitLevelValue(LimitLevelEnum limitLevel) {
			this.getOrCreateLimitLevel().setValue(limitLevel);
			return this;
		}
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setAmountRemaining(BigDecimal amountRemaining) {
			this.amountRemaining = amountRemaining==null?null:amountRemaining;
			return this;
		}
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setAmountUtilized(BigDecimal amountUtilized) {
			this.amountUtilized = amountUtilized==null?null:amountUtilized;
			return this;
		}
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setClipSize(Integer clipSize) {
			this.clipSize = clipSize==null?null:clipSize;
			return this;
		}
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitType(FieldWithMetaCreditLimitTypeEnum limitType) {
			this.limitType = limitType==null?null:limitType.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitTypeValue(CreditLimitTypeEnum limitType) {
			this.getOrCreateLimitType().setValue(limitType);
			return this;
		}
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setUtilization(CreditLimitUtilisation utilization) {
			this.utilization = utilization==null?null:utilization.toBuilder();
			return this;
		}
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setVelocity(Velocity velocity) {
			this.velocity = velocity==null?null:velocity.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicableExtended build() {
			return new LimitApplicableExtended.LimitApplicableExtendedImpl(this);
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder prune() {
			super.prune();
			if (limitLevel!=null && !limitLevel.prune().hasData()) limitLevel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLimitAmount()!=null) return true;
			if (getLimitImpactDueToTrade()!=null) return true;
			if (getLimitLevel()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LimitApplicableExtended.LimitApplicableExtendedBuilder o = (LimitApplicableExtended.LimitApplicableExtendedBuilder) other;
			
			merger.mergeRosetta(getLimitLevel(), o.getLimitLevel(), this::setLimitLevel);
			
			merger.mergeBasic(getLimitAmount(), o.getLimitAmount(), this::setLimitAmount);
			merger.mergeBasic(getLimitImpactDueToTrade(), o.getLimitImpactDueToTrade(), this::setLimitImpactDueToTrade);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LimitApplicableExtended _that = getType().cast(o);
		
			if (!Objects.equals(limitAmount, _that.getLimitAmount())) return false;
			if (!Objects.equals(limitImpactDueToTrade, _that.getLimitImpactDueToTrade())) return false;
			if (!Objects.equals(limitLevel, _that.getLimitLevel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (limitAmount != null ? limitAmount.hashCode() : 0);
			_result = 31 * _result + (limitImpactDueToTrade != null ? limitImpactDueToTrade.hashCode() : 0);
			_result = 31 * _result + (limitLevel != null ? limitLevel.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitApplicableExtendedBuilder {" +
				"limitAmount=" + this.limitAmount + ", " +
				"limitImpactDueToTrade=" + this.limitImpactDueToTrade + ", " +
				"limitLevel=" + this.limitLevel +
			'}' + " " + super.toString();
		}
	}
}
