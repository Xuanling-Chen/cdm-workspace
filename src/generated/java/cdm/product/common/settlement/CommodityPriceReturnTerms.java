package cdm.product.common.settlement;

import cdm.base.math.Rounding;
import cdm.product.asset.SpreadSchedule;
import cdm.product.common.settlement.meta.CommodityPriceReturnTermsMeta;
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
 * Defines parameters in which the commodity price is assessed.
 * @version ${project.version}
 */
@RosettaClass

public interface CommodityPriceReturnTerms extends RosettaModelObject {
	CommodityPriceReturnTerms build();
	CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder toBuilder();
	
	/**
	 * Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.
	 */
	BigDecimal getConversionFactor();
	/**
	 * Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. 
	 */
	RollFeature getRollFeature();
	/**
	 * Defines rounding rules and precision to be used in the rounding of a number.
	 */
	Rounding getRounding();
	/**
	 * Defines a spread value for one or more defined dates.
	 */
	SpreadSchedule getSpread();
	final static CommodityPriceReturnTermsMeta metaData = new CommodityPriceReturnTermsMeta();
	
	@Override
	default RosettaMetaData<? extends CommodityPriceReturnTerms> metaData() {
		return metaData;
	} 
			
	static CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder builder() {
		return new CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilderImpl();
	}
	
	default Class<? extends CommodityPriceReturnTerms> getType() {
		return CommodityPriceReturnTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		
		processRosetta(path.newSubPath("rollFeature"), processor, RollFeature.class, getRollFeature());
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
		processRosetta(path.newSubPath("spread"), processor, SpreadSchedule.class, getSpread());
	}
	
	
	interface CommodityPriceReturnTermsBuilder extends CommodityPriceReturnTerms, RosettaModelObjectBuilder {
		RollFeature.RollFeatureBuilder getOrCreateRollFeature();
		RollFeature.RollFeatureBuilder getRollFeature();
		Rounding.RoundingBuilder getOrCreateRounding();
		Rounding.RoundingBuilder getRounding();
		SpreadSchedule.SpreadScheduleBuilder getOrCreateSpread();
		SpreadSchedule.SpreadScheduleBuilder getSpread();
		CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder setConversionFactor(BigDecimal conversionFactor);
		CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder setRollFeature(RollFeature rollFeature);
		CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder setRounding(Rounding rounding);
		CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder setSpread(SpreadSchedule spread);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
			
			processRosetta(path.newSubPath("rollFeature"), processor, RollFeature.RollFeatureBuilder.class, getRollFeature());
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
			processRosetta(path.newSubPath("spread"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpread());
		}
		
	}
	
	//CommodityPriceReturnTerms.CommodityPriceReturnTermsImpl
	class CommodityPriceReturnTermsImpl implements CommodityPriceReturnTerms {
		private final BigDecimal conversionFactor;
		private final RollFeature rollFeature;
		private final Rounding rounding;
		private final SpreadSchedule spread;
		
		protected CommodityPriceReturnTermsImpl(CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder builder) {
			this.conversionFactor = builder.getConversionFactor();
			this.rollFeature = ofNullable(builder.getRollFeature()).map(f->f.build()).orElse(null);
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
			this.spread = ofNullable(builder.getSpread()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		public RollFeature getRollFeature() {
			return rollFeature;
		}
		
		@Override
		public Rounding getRounding() {
			return rounding;
		}
		
		@Override
		public SpreadSchedule getSpread() {
			return spread;
		}
		
		@Override
		public CommodityPriceReturnTerms build() {
			return this;
		}
		
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder toBuilder() {
			CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder builder) {
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
			ofNullable(getRollFeature()).ifPresent(builder::setRollFeature);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPriceReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(rollFeature, _that.getRollFeature())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (rollFeature != null ? rollFeature.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPriceReturnTerms {" +
				"conversionFactor=" + this.conversionFactor + ", " +
				"rollFeature=" + this.rollFeature + ", " +
				"rounding=" + this.rounding + ", " +
				"spread=" + this.spread +
			'}';
		}
	}
	
	//CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilderImpl
	class CommodityPriceReturnTermsBuilderImpl implements CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder {
	
		protected BigDecimal conversionFactor;
		protected RollFeature.RollFeatureBuilder rollFeature;
		protected Rounding.RoundingBuilder rounding;
		protected SpreadSchedule.SpreadScheduleBuilder spread;
	
		public CommodityPriceReturnTermsBuilderImpl() {
		}
	
		@Override
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		public RollFeature.RollFeatureBuilder getRollFeature() {
			return rollFeature;
		}
		
		@Override
		public RollFeature.RollFeatureBuilder getOrCreateRollFeature() {
			RollFeature.RollFeatureBuilder result;
			if (rollFeature!=null) {
				result = rollFeature;
			}
			else {
				result = rollFeature = RollFeature.builder();
			}
			
			return result;
		}
		
		@Override
		public Rounding.RoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateRounding() {
			Rounding.RoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder getSpread() {
			return spread;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder getOrCreateSpread() {
			SpreadSchedule.SpreadScheduleBuilder result;
			if (spread!=null) {
				result = spread;
			}
			else {
				result = spread = SpreadSchedule.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder setConversionFactor(BigDecimal conversionFactor) {
			this.conversionFactor = conversionFactor==null?null:conversionFactor;
			return this;
		}
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder setRollFeature(RollFeature rollFeature) {
			this.rollFeature = rollFeature==null?null:rollFeature.toBuilder();
			return this;
		}
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder setRounding(Rounding rounding) {
			this.rounding = rounding==null?null:rounding.toBuilder();
			return this;
		}
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder setSpread(SpreadSchedule spread) {
			this.spread = spread==null?null:spread.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPriceReturnTerms build() {
			return new CommodityPriceReturnTerms.CommodityPriceReturnTermsImpl(this);
		}
		
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder prune() {
			if (rollFeature!=null && !rollFeature.prune().hasData()) rollFeature = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			if (spread!=null && !spread.prune().hasData()) spread = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConversionFactor()!=null) return true;
			if (getRollFeature()!=null && getRollFeature().hasData()) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			if (getSpread()!=null && getSpread().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder o = (CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder) other;
			
			merger.mergeRosetta(getRollFeature(), o.getRollFeature(), this::setRollFeature);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			merger.mergeRosetta(getSpread(), o.getSpread(), this::setSpread);
			
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPriceReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(rollFeature, _that.getRollFeature())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (rollFeature != null ? rollFeature.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPriceReturnTermsBuilder {" +
				"conversionFactor=" + this.conversionFactor + ", " +
				"rollFeature=" + this.rollFeature + ", " +
				"rounding=" + this.rounding + ", " +
				"spread=" + this.spread +
			'}';
		}
	}
}
