package cdm.event.workflow;

import cdm.event.workflow.meta.LimitApplicableMeta;
import cdm.event.workflow.metafields.FieldWithMetaCreditLimitTypeEnum;
import cdm.event.workflow.metafields.FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface LimitApplicable extends RosettaModelObject {
	LimitApplicable build();
	LimitApplicable.LimitApplicableBuilder toBuilder();
	
	/**
	 * The limit remaining for the limit level and limit type. This does not take into account any pending trades. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
	 */
	BigDecimal getAmountRemaining();
	/**
	 * The limit utilised by all the cleared trades for the limit level and limit type. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
	 */
	BigDecimal getAmountUtilized();
	/**
	 * This element is required in FpML, optional in CDM for the purpose of accommodating the CME data representation while making reference to the FpML one.
	 */
	Integer getClipSize();
	/**
	 * The currency in which the applicable limit is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * Standard code to indicate which type of credit line is being referred to - i.e. IM, DV01, PV01, CS01, Notional, Clip Size, Notional, maximumOrderQuantity.
	 */
	FieldWithMetaCreditLimitTypeEnum getLimitType();
	/**
	 */
	CreditLimitUtilisation getUtilization();
	/**
	 */
	Velocity getVelocity();
	final static LimitApplicableMeta metaData = new LimitApplicableMeta();
	
	@Override
	default RosettaMetaData<? extends LimitApplicable> metaData() {
		return metaData;
	} 
			
	static LimitApplicable.LimitApplicableBuilder builder() {
		return new LimitApplicable.LimitApplicableBuilderImpl();
	}
	
	default Class<? extends LimitApplicable> getType() {
		return LimitApplicable.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("amountRemaining"), BigDecimal.class, getAmountRemaining(), this);
		processor.processBasic(path.newSubPath("amountUtilized"), BigDecimal.class, getAmountUtilized(), this);
		processor.processBasic(path.newSubPath("clipSize"), Integer.class, getClipSize(), this);
		
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
		processRosetta(path.newSubPath("limitType"), processor, FieldWithMetaCreditLimitTypeEnum.class, getLimitType());
		processRosetta(path.newSubPath("utilization"), processor, CreditLimitUtilisation.class, getUtilization());
		processRosetta(path.newSubPath("velocity"), processor, Velocity.class, getVelocity());
	}
	
	
	interface LimitApplicableBuilder extends LimitApplicable, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		FieldWithMetaCreditLimitTypeEnumBuilder getOrCreateLimitType();
		FieldWithMetaCreditLimitTypeEnumBuilder getLimitType();
		CreditLimitUtilisation.CreditLimitUtilisationBuilder getOrCreateUtilization();
		CreditLimitUtilisation.CreditLimitUtilisationBuilder getUtilization();
		Velocity.VelocityBuilder getOrCreateVelocity();
		Velocity.VelocityBuilder getVelocity();
		LimitApplicable.LimitApplicableBuilder setAmountRemaining(BigDecimal amountRemaining);
		LimitApplicable.LimitApplicableBuilder setAmountUtilized(BigDecimal amountUtilized);
		LimitApplicable.LimitApplicableBuilder setClipSize(Integer clipSize);
		LimitApplicable.LimitApplicableBuilder setCurrency(FieldWithMetaString currency);
		LimitApplicable.LimitApplicableBuilder setCurrencyValue(String currency);
		LimitApplicable.LimitApplicableBuilder setLimitType(FieldWithMetaCreditLimitTypeEnum limitType);
		LimitApplicable.LimitApplicableBuilder setLimitTypeValue(CreditLimitTypeEnum limitType);
		LimitApplicable.LimitApplicableBuilder setUtilization(CreditLimitUtilisation utilization);
		LimitApplicable.LimitApplicableBuilder setVelocity(Velocity velocity);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("amountRemaining"), BigDecimal.class, getAmountRemaining(), this);
			processor.processBasic(path.newSubPath("amountUtilized"), BigDecimal.class, getAmountUtilized(), this);
			processor.processBasic(path.newSubPath("clipSize"), Integer.class, getClipSize(), this);
			
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
			processRosetta(path.newSubPath("limitType"), processor, FieldWithMetaCreditLimitTypeEnumBuilder.class, getLimitType());
			processRosetta(path.newSubPath("utilization"), processor, CreditLimitUtilisation.CreditLimitUtilisationBuilder.class, getUtilization());
			processRosetta(path.newSubPath("velocity"), processor, Velocity.VelocityBuilder.class, getVelocity());
		}
		
	}
	
	//LimitApplicable.LimitApplicableImpl
	class LimitApplicableImpl implements LimitApplicable {
		private final BigDecimal amountRemaining;
		private final BigDecimal amountUtilized;
		private final Integer clipSize;
		private final FieldWithMetaString currency;
		private final FieldWithMetaCreditLimitTypeEnum limitType;
		private final CreditLimitUtilisation utilization;
		private final Velocity velocity;
		
		protected LimitApplicableImpl(LimitApplicable.LimitApplicableBuilder builder) {
			this.amountRemaining = builder.getAmountRemaining();
			this.amountUtilized = builder.getAmountUtilized();
			this.clipSize = builder.getClipSize();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.limitType = ofNullable(builder.getLimitType()).map(f->f.build()).orElse(null);
			this.utilization = ofNullable(builder.getUtilization()).map(f->f.build()).orElse(null);
			this.velocity = ofNullable(builder.getVelocity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getAmountRemaining() {
			return amountRemaining;
		}
		
		@Override
		public BigDecimal getAmountUtilized() {
			return amountUtilized;
		}
		
		@Override
		public Integer getClipSize() {
			return clipSize;
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaCreditLimitTypeEnum getLimitType() {
			return limitType;
		}
		
		@Override
		public CreditLimitUtilisation getUtilization() {
			return utilization;
		}
		
		@Override
		public Velocity getVelocity() {
			return velocity;
		}
		
		@Override
		public LimitApplicable build() {
			return this;
		}
		
		@Override
		public LimitApplicable.LimitApplicableBuilder toBuilder() {
			LimitApplicable.LimitApplicableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LimitApplicable.LimitApplicableBuilder builder) {
			ofNullable(getAmountRemaining()).ifPresent(builder::setAmountRemaining);
			ofNullable(getAmountUtilized()).ifPresent(builder::setAmountUtilized);
			ofNullable(getClipSize()).ifPresent(builder::setClipSize);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getLimitType()).ifPresent(builder::setLimitType);
			ofNullable(getUtilization()).ifPresent(builder::setUtilization);
			ofNullable(getVelocity()).ifPresent(builder::setVelocity);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitApplicable _that = getType().cast(o);
		
			if (!Objects.equals(amountRemaining, _that.getAmountRemaining())) return false;
			if (!Objects.equals(amountUtilized, _that.getAmountUtilized())) return false;
			if (!Objects.equals(clipSize, _that.getClipSize())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(limitType, _that.getLimitType())) return false;
			if (!Objects.equals(utilization, _that.getUtilization())) return false;
			if (!Objects.equals(velocity, _that.getVelocity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRemaining != null ? amountRemaining.hashCode() : 0);
			_result = 31 * _result + (amountUtilized != null ? amountUtilized.hashCode() : 0);
			_result = 31 * _result + (clipSize != null ? clipSize.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (limitType != null ? limitType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (utilization != null ? utilization.hashCode() : 0);
			_result = 31 * _result + (velocity != null ? velocity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitApplicable {" +
				"amountRemaining=" + this.amountRemaining + ", " +
				"amountUtilized=" + this.amountUtilized + ", " +
				"clipSize=" + this.clipSize + ", " +
				"currency=" + this.currency + ", " +
				"limitType=" + this.limitType + ", " +
				"utilization=" + this.utilization + ", " +
				"velocity=" + this.velocity +
			'}';
		}
	}
	
	//LimitApplicable.LimitApplicableBuilderImpl
	class LimitApplicableBuilderImpl implements LimitApplicable.LimitApplicableBuilder {
	
		protected BigDecimal amountRemaining;
		protected BigDecimal amountUtilized;
		protected Integer clipSize;
		protected FieldWithMetaStringBuilder currency;
		protected FieldWithMetaCreditLimitTypeEnumBuilder limitType;
		protected CreditLimitUtilisation.CreditLimitUtilisationBuilder utilization;
		protected Velocity.VelocityBuilder velocity;
	
		public LimitApplicableBuilderImpl() {
		}
	
		@Override
		public BigDecimal getAmountRemaining() {
			return amountRemaining;
		}
		
		@Override
		public BigDecimal getAmountUtilized() {
			return amountUtilized;
		}
		
		@Override
		public Integer getClipSize() {
			return clipSize;
		}
		
		@Override
		public FieldWithMetaStringBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateCurrency() {
			FieldWithMetaStringBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaCreditLimitTypeEnumBuilder getLimitType() {
			return limitType;
		}
		
		@Override
		public FieldWithMetaCreditLimitTypeEnumBuilder getOrCreateLimitType() {
			FieldWithMetaCreditLimitTypeEnumBuilder result;
			if (limitType!=null) {
				result = limitType;
			}
			else {
				result = limitType = FieldWithMetaCreditLimitTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditLimitUtilisation.CreditLimitUtilisationBuilder getUtilization() {
			return utilization;
		}
		
		@Override
		public CreditLimitUtilisation.CreditLimitUtilisationBuilder getOrCreateUtilization() {
			CreditLimitUtilisation.CreditLimitUtilisationBuilder result;
			if (utilization!=null) {
				result = utilization;
			}
			else {
				result = utilization = CreditLimitUtilisation.builder();
			}
			
			return result;
		}
		
		@Override
		public Velocity.VelocityBuilder getVelocity() {
			return velocity;
		}
		
		@Override
		public Velocity.VelocityBuilder getOrCreateVelocity() {
			Velocity.VelocityBuilder result;
			if (velocity!=null) {
				result = velocity;
			}
			else {
				result = velocity = Velocity.builder();
			}
			
			return result;
		}
		
	
		@Override
		public LimitApplicable.LimitApplicableBuilder setAmountRemaining(BigDecimal amountRemaining) {
			this.amountRemaining = amountRemaining==null?null:amountRemaining;
			return this;
		}
		@Override
		public LimitApplicable.LimitApplicableBuilder setAmountUtilized(BigDecimal amountUtilized) {
			this.amountUtilized = amountUtilized==null?null:amountUtilized;
			return this;
		}
		@Override
		public LimitApplicable.LimitApplicableBuilder setClipSize(Integer clipSize) {
			this.clipSize = clipSize==null?null:clipSize;
			return this;
		}
		@Override
		public LimitApplicable.LimitApplicableBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicable.LimitApplicableBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public LimitApplicable.LimitApplicableBuilder setLimitType(FieldWithMetaCreditLimitTypeEnum limitType) {
			this.limitType = limitType==null?null:limitType.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicable.LimitApplicableBuilder setLimitTypeValue(CreditLimitTypeEnum limitType) {
			this.getOrCreateLimitType().setValue(limitType);
			return this;
		}
		@Override
		public LimitApplicable.LimitApplicableBuilder setUtilization(CreditLimitUtilisation utilization) {
			this.utilization = utilization==null?null:utilization.toBuilder();
			return this;
		}
		@Override
		public LimitApplicable.LimitApplicableBuilder setVelocity(Velocity velocity) {
			this.velocity = velocity==null?null:velocity.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicable build() {
			return new LimitApplicable.LimitApplicableImpl(this);
		}
		
		@Override
		public LimitApplicable.LimitApplicableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitApplicable.LimitApplicableBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (limitType!=null && !limitType.prune().hasData()) limitType = null;
			if (utilization!=null && !utilization.prune().hasData()) utilization = null;
			if (velocity!=null && !velocity.prune().hasData()) velocity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmountRemaining()!=null) return true;
			if (getAmountUtilized()!=null) return true;
			if (getClipSize()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getLimitType()!=null) return true;
			if (getUtilization()!=null && getUtilization().hasData()) return true;
			if (getVelocity()!=null && getVelocity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitApplicable.LimitApplicableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LimitApplicable.LimitApplicableBuilder o = (LimitApplicable.LimitApplicableBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getLimitType(), o.getLimitType(), this::setLimitType);
			merger.mergeRosetta(getUtilization(), o.getUtilization(), this::setUtilization);
			merger.mergeRosetta(getVelocity(), o.getVelocity(), this::setVelocity);
			
			merger.mergeBasic(getAmountRemaining(), o.getAmountRemaining(), this::setAmountRemaining);
			merger.mergeBasic(getAmountUtilized(), o.getAmountUtilized(), this::setAmountUtilized);
			merger.mergeBasic(getClipSize(), o.getClipSize(), this::setClipSize);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitApplicable _that = getType().cast(o);
		
			if (!Objects.equals(amountRemaining, _that.getAmountRemaining())) return false;
			if (!Objects.equals(amountUtilized, _that.getAmountUtilized())) return false;
			if (!Objects.equals(clipSize, _that.getClipSize())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(limitType, _that.getLimitType())) return false;
			if (!Objects.equals(utilization, _that.getUtilization())) return false;
			if (!Objects.equals(velocity, _that.getVelocity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRemaining != null ? amountRemaining.hashCode() : 0);
			_result = 31 * _result + (amountUtilized != null ? amountUtilized.hashCode() : 0);
			_result = 31 * _result + (clipSize != null ? clipSize.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (limitType != null ? limitType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (utilization != null ? utilization.hashCode() : 0);
			_result = 31 * _result + (velocity != null ? velocity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitApplicableBuilder {" +
				"amountRemaining=" + this.amountRemaining + ", " +
				"amountUtilized=" + this.amountUtilized + ", " +
				"clipSize=" + this.clipSize + ", " +
				"currency=" + this.currency + ", " +
				"limitType=" + this.limitType + ", " +
				"utilization=" + this.utilization + ", " +
				"velocity=" + this.velocity +
			'}';
		}
	}
}
