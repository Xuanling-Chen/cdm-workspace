package cdm.product.asset;

import cdm.product.asset.meta.DiscountingMethodMeta;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder;
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
 * A data defining:  discounting information. The 2000 ISDA definitions, section 8.4. discounting (related to the calculation of a discounted fixed amount or floating amount) apply. This type must only be included if discounting applies.
 * @version ${project.version}
 */
@RosettaClass

public interface DiscountingMethod extends RosettaModelObject {
	DiscountingMethod build();
	DiscountingMethod.DiscountingMethodBuilder toBuilder();
	
	/**
	 * A discount rate, expressed as a decimal, to be used in the calculation of a discounted amount. A discount amount of 5% would be represented as 0.05.
	 */
	BigDecimal getDiscountRate();
	/**
	 * A discount day count fraction to be used in the calculation of a discounted amount.
	 */
	FieldWithMetaDayCountFractionEnum getDiscountRateDayCountFraction();
	/**
	 * The discounting method that is applicable.
	 */
	DiscountingTypeEnum getDiscountingType();
	final static DiscountingMethodMeta metaData = new DiscountingMethodMeta();
	
	@Override
	default RosettaMetaData<? extends DiscountingMethod> metaData() {
		return metaData;
	} 
			
	static DiscountingMethod.DiscountingMethodBuilder builder() {
		return new DiscountingMethod.DiscountingMethodBuilderImpl();
	}
	
	default Class<? extends DiscountingMethod> getType() {
		return DiscountingMethod.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("discountRate"), BigDecimal.class, getDiscountRate(), this);
		processor.processBasic(path.newSubPath("discountingType"), DiscountingTypeEnum.class, getDiscountingType(), this);
		
		processRosetta(path.newSubPath("discountRateDayCountFraction"), processor, FieldWithMetaDayCountFractionEnum.class, getDiscountRateDayCountFraction());
	}
	
	
	interface DiscountingMethodBuilder extends DiscountingMethod, RosettaModelObjectBuilder {
		FieldWithMetaDayCountFractionEnumBuilder getOrCreateDiscountRateDayCountFraction();
		FieldWithMetaDayCountFractionEnumBuilder getDiscountRateDayCountFraction();
		DiscountingMethod.DiscountingMethodBuilder setDiscountRate(BigDecimal discountRate);
		DiscountingMethod.DiscountingMethodBuilder setDiscountRateDayCountFraction(FieldWithMetaDayCountFractionEnum discountRateDayCountFraction);
		DiscountingMethod.DiscountingMethodBuilder setDiscountRateDayCountFractionValue(DayCountFractionEnum discountRateDayCountFraction);
		DiscountingMethod.DiscountingMethodBuilder setDiscountingType(DiscountingTypeEnum discountingType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("discountRate"), BigDecimal.class, getDiscountRate(), this);
			processor.processBasic(path.newSubPath("discountingType"), DiscountingTypeEnum.class, getDiscountingType(), this);
			
			processRosetta(path.newSubPath("discountRateDayCountFraction"), processor, FieldWithMetaDayCountFractionEnumBuilder.class, getDiscountRateDayCountFraction());
		}
		
	}
	
	//DiscountingMethod.DiscountingMethodImpl
	class DiscountingMethodImpl implements DiscountingMethod {
		private final BigDecimal discountRate;
		private final FieldWithMetaDayCountFractionEnum discountRateDayCountFraction;
		private final DiscountingTypeEnum discountingType;
		
		protected DiscountingMethodImpl(DiscountingMethod.DiscountingMethodBuilder builder) {
			this.discountRate = builder.getDiscountRate();
			this.discountRateDayCountFraction = ofNullable(builder.getDiscountRateDayCountFraction()).map(f->f.build()).orElse(null);
			this.discountingType = builder.getDiscountingType();
		}
		
		@Override
		public BigDecimal getDiscountRate() {
			return discountRate;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnum getDiscountRateDayCountFraction() {
			return discountRateDayCountFraction;
		}
		
		@Override
		public DiscountingTypeEnum getDiscountingType() {
			return discountingType;
		}
		
		@Override
		public DiscountingMethod build() {
			return this;
		}
		
		@Override
		public DiscountingMethod.DiscountingMethodBuilder toBuilder() {
			DiscountingMethod.DiscountingMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DiscountingMethod.DiscountingMethodBuilder builder) {
			ofNullable(getDiscountRate()).ifPresent(builder::setDiscountRate);
			ofNullable(getDiscountRateDayCountFraction()).ifPresent(builder::setDiscountRateDayCountFraction);
			ofNullable(getDiscountingType()).ifPresent(builder::setDiscountingType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DiscountingMethod _that = getType().cast(o);
		
			if (!Objects.equals(discountRate, _that.getDiscountRate())) return false;
			if (!Objects.equals(discountRateDayCountFraction, _that.getDiscountRateDayCountFraction())) return false;
			if (!Objects.equals(discountingType, _that.getDiscountingType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountRate != null ? discountRate.hashCode() : 0);
			_result = 31 * _result + (discountRateDayCountFraction != null ? discountRateDayCountFraction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountingType != null ? discountingType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DiscountingMethod {" +
				"discountRate=" + this.discountRate + ", " +
				"discountRateDayCountFraction=" + this.discountRateDayCountFraction + ", " +
				"discountingType=" + this.discountingType +
			'}';
		}
	}
	
	//DiscountingMethod.DiscountingMethodBuilderImpl
	class DiscountingMethodBuilderImpl implements DiscountingMethod.DiscountingMethodBuilder {
	
		protected BigDecimal discountRate;
		protected FieldWithMetaDayCountFractionEnumBuilder discountRateDayCountFraction;
		protected DiscountingTypeEnum discountingType;
	
		public DiscountingMethodBuilderImpl() {
		}
	
		@Override
		public BigDecimal getDiscountRate() {
			return discountRate;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnumBuilder getDiscountRateDayCountFraction() {
			return discountRateDayCountFraction;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnumBuilder getOrCreateDiscountRateDayCountFraction() {
			FieldWithMetaDayCountFractionEnumBuilder result;
			if (discountRateDayCountFraction!=null) {
				result = discountRateDayCountFraction;
			}
			else {
				result = discountRateDayCountFraction = FieldWithMetaDayCountFractionEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public DiscountingTypeEnum getDiscountingType() {
			return discountingType;
		}
		
	
		@Override
		public DiscountingMethod.DiscountingMethodBuilder setDiscountRate(BigDecimal discountRate) {
			this.discountRate = discountRate==null?null:discountRate;
			return this;
		}
		@Override
		public DiscountingMethod.DiscountingMethodBuilder setDiscountRateDayCountFraction(FieldWithMetaDayCountFractionEnum discountRateDayCountFraction) {
			this.discountRateDayCountFraction = discountRateDayCountFraction==null?null:discountRateDayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public DiscountingMethod.DiscountingMethodBuilder setDiscountRateDayCountFractionValue(DayCountFractionEnum discountRateDayCountFraction) {
			this.getOrCreateDiscountRateDayCountFraction().setValue(discountRateDayCountFraction);
			return this;
		}
		@Override
		public DiscountingMethod.DiscountingMethodBuilder setDiscountingType(DiscountingTypeEnum discountingType) {
			this.discountingType = discountingType==null?null:discountingType;
			return this;
		}
		
		@Override
		public DiscountingMethod build() {
			return new DiscountingMethod.DiscountingMethodImpl(this);
		}
		
		@Override
		public DiscountingMethod.DiscountingMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DiscountingMethod.DiscountingMethodBuilder prune() {
			if (discountRateDayCountFraction!=null && !discountRateDayCountFraction.prune().hasData()) discountRateDayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDiscountRate()!=null) return true;
			if (getDiscountRateDayCountFraction()!=null) return true;
			if (getDiscountingType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DiscountingMethod.DiscountingMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DiscountingMethod.DiscountingMethodBuilder o = (DiscountingMethod.DiscountingMethodBuilder) other;
			
			merger.mergeRosetta(getDiscountRateDayCountFraction(), o.getDiscountRateDayCountFraction(), this::setDiscountRateDayCountFraction);
			
			merger.mergeBasic(getDiscountRate(), o.getDiscountRate(), this::setDiscountRate);
			merger.mergeBasic(getDiscountingType(), o.getDiscountingType(), this::setDiscountingType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DiscountingMethod _that = getType().cast(o);
		
			if (!Objects.equals(discountRate, _that.getDiscountRate())) return false;
			if (!Objects.equals(discountRateDayCountFraction, _that.getDiscountRateDayCountFraction())) return false;
			if (!Objects.equals(discountingType, _that.getDiscountingType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountRate != null ? discountRate.hashCode() : 0);
			_result = 31 * _result + (discountRateDayCountFraction != null ? discountRateDayCountFraction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountingType != null ? discountingType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DiscountingMethodBuilder {" +
				"discountRate=" + this.discountRate + ", " +
				"discountRateDayCountFraction=" + this.discountRateDayCountFraction + ", " +
				"discountingType=" + this.discountingType +
			'}';
		}
	}
}
