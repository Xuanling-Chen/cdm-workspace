package cdm.product.template;

import cdm.event.position.AveragingObservation;
import cdm.observable.asset.FixedRateSpecification;
import cdm.observable.asset.FixedRateSpecification;
import cdm.observable.asset.Price;
import cdm.observable.asset.ReferenceSwapCurve;
import cdm.observable.asset.metafields.ReferenceWithMetaFixedRateSpecification;
import cdm.observable.asset.metafields.ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder;
import cdm.product.template.meta.OptionStrikeMeta;
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
 * Defines the strike price of an option.
 * @version ${project.version}
 */
@RosettaClass

public interface OptionStrike extends RosettaModelObject {
	OptionStrike build();
	OptionStrike.OptionStrikeBuilder toBuilder();
	
	/**
	 * Defines an option strike that is calculated from an average of observed market prices.
	 */
	AveragingObservation getAveragingStrikeFeature();
	/**
	 * Defines the strike of an option when expressed by reference to a swap curve (Typically the case for a convertible bond option).
	 */
	ReferenceSwapCurve getReferenceSwapCurve();
	/**
	 * Defines the strike of an option in the form of a price that could be a cash price, interestRate, or other types.
	 */
	Price getStrikePrice();
	/**
	 * Defines the strike of an option in reference to the spread of the underlying swap (typical practice in the case of an option on a credit single name swaps).
	 */
	ReferenceWithMetaFixedRateSpecification getStrikeReference();
	final static OptionStrikeMeta metaData = new OptionStrikeMeta();
	
	@Override
	default RosettaMetaData<? extends OptionStrike> metaData() {
		return metaData;
	} 
			
	static OptionStrike.OptionStrikeBuilder builder() {
		return new OptionStrike.OptionStrikeBuilderImpl();
	}
	
	default Class<? extends OptionStrike> getType() {
		return OptionStrike.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("averagingStrikeFeature"), processor, AveragingObservation.class, getAveragingStrikeFeature());
		processRosetta(path.newSubPath("referenceSwapCurve"), processor, ReferenceSwapCurve.class, getReferenceSwapCurve());
		processRosetta(path.newSubPath("strikePrice"), processor, Price.class, getStrikePrice());
		processRosetta(path.newSubPath("strikeReference"), processor, ReferenceWithMetaFixedRateSpecification.class, getStrikeReference());
	}
	
	
	interface OptionStrikeBuilder extends OptionStrike, RosettaModelObjectBuilder {
		AveragingObservation.AveragingObservationBuilder getOrCreateAveragingStrikeFeature();
		AveragingObservation.AveragingObservationBuilder getAveragingStrikeFeature();
		ReferenceSwapCurve.ReferenceSwapCurveBuilder getOrCreateReferenceSwapCurve();
		ReferenceSwapCurve.ReferenceSwapCurveBuilder getReferenceSwapCurve();
		Price.PriceBuilder getOrCreateStrikePrice();
		Price.PriceBuilder getStrikePrice();
		ReferenceWithMetaFixedRateSpecificationBuilder getOrCreateStrikeReference();
		ReferenceWithMetaFixedRateSpecificationBuilder getStrikeReference();
		OptionStrike.OptionStrikeBuilder setAveragingStrikeFeature(AveragingObservation averagingStrikeFeature);
		OptionStrike.OptionStrikeBuilder setReferenceSwapCurve(ReferenceSwapCurve referenceSwapCurve);
		OptionStrike.OptionStrikeBuilder setStrikePrice(Price strikePrice);
		OptionStrike.OptionStrikeBuilder setStrikeReference(ReferenceWithMetaFixedRateSpecification strikeReference);
		OptionStrike.OptionStrikeBuilder setStrikeReferenceValue(FixedRateSpecification strikeReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("averagingStrikeFeature"), processor, AveragingObservation.AveragingObservationBuilder.class, getAveragingStrikeFeature());
			processRosetta(path.newSubPath("referenceSwapCurve"), processor, ReferenceSwapCurve.ReferenceSwapCurveBuilder.class, getReferenceSwapCurve());
			processRosetta(path.newSubPath("strikePrice"), processor, Price.PriceBuilder.class, getStrikePrice());
			processRosetta(path.newSubPath("strikeReference"), processor, ReferenceWithMetaFixedRateSpecificationBuilder.class, getStrikeReference());
		}
		
	}
	
	//OptionStrike.OptionStrikeImpl
	class OptionStrikeImpl implements OptionStrike {
		private final AveragingObservation averagingStrikeFeature;
		private final ReferenceSwapCurve referenceSwapCurve;
		private final Price strikePrice;
		private final ReferenceWithMetaFixedRateSpecification strikeReference;
		
		protected OptionStrikeImpl(OptionStrike.OptionStrikeBuilder builder) {
			this.averagingStrikeFeature = ofNullable(builder.getAveragingStrikeFeature()).map(f->f.build()).orElse(null);
			this.referenceSwapCurve = ofNullable(builder.getReferenceSwapCurve()).map(f->f.build()).orElse(null);
			this.strikePrice = ofNullable(builder.getStrikePrice()).map(f->f.build()).orElse(null);
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AveragingObservation getAveragingStrikeFeature() {
			return averagingStrikeFeature;
		}
		
		@Override
		public ReferenceSwapCurve getReferenceSwapCurve() {
			return referenceSwapCurve;
		}
		
		@Override
		public Price getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		public ReferenceWithMetaFixedRateSpecification getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public OptionStrike build() {
			return this;
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder toBuilder() {
			OptionStrike.OptionStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionStrike.OptionStrikeBuilder builder) {
			ofNullable(getAveragingStrikeFeature()).ifPresent(builder::setAveragingStrikeFeature);
			ofNullable(getReferenceSwapCurve()).ifPresent(builder::setReferenceSwapCurve);
			ofNullable(getStrikePrice()).ifPresent(builder::setStrikePrice);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(averagingStrikeFeature, _that.getAveragingStrikeFeature())) return false;
			if (!Objects.equals(referenceSwapCurve, _that.getReferenceSwapCurve())) return false;
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingStrikeFeature != null ? averagingStrikeFeature.hashCode() : 0);
			_result = 31 * _result + (referenceSwapCurve != null ? referenceSwapCurve.hashCode() : 0);
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionStrike {" +
				"averagingStrikeFeature=" + this.averagingStrikeFeature + ", " +
				"referenceSwapCurve=" + this.referenceSwapCurve + ", " +
				"strikePrice=" + this.strikePrice + ", " +
				"strikeReference=" + this.strikeReference +
			'}';
		}
	}
	
	//OptionStrike.OptionStrikeBuilderImpl
	class OptionStrikeBuilderImpl implements OptionStrike.OptionStrikeBuilder {
	
		protected AveragingObservation.AveragingObservationBuilder averagingStrikeFeature;
		protected ReferenceSwapCurve.ReferenceSwapCurveBuilder referenceSwapCurve;
		protected Price.PriceBuilder strikePrice;
		protected ReferenceWithMetaFixedRateSpecificationBuilder strikeReference;
	
		public OptionStrikeBuilderImpl() {
		}
	
		@Override
		public AveragingObservation.AveragingObservationBuilder getAveragingStrikeFeature() {
			return averagingStrikeFeature;
		}
		
		@Override
		public AveragingObservation.AveragingObservationBuilder getOrCreateAveragingStrikeFeature() {
			AveragingObservation.AveragingObservationBuilder result;
			if (averagingStrikeFeature!=null) {
				result = averagingStrikeFeature;
			}
			else {
				result = averagingStrikeFeature = AveragingObservation.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder getReferenceSwapCurve() {
			return referenceSwapCurve;
		}
		
		@Override
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder getOrCreateReferenceSwapCurve() {
			ReferenceSwapCurve.ReferenceSwapCurveBuilder result;
			if (referenceSwapCurve!=null) {
				result = referenceSwapCurve;
			}
			else {
				result = referenceSwapCurve = ReferenceSwapCurve.builder();
			}
			
			return result;
		}
		
		@Override
		public Price.PriceBuilder getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateStrikePrice() {
			Price.PriceBuilder result;
			if (strikePrice!=null) {
				result = strikePrice;
			}
			else {
				result = strikePrice = Price.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaFixedRateSpecificationBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public ReferenceWithMetaFixedRateSpecificationBuilder getOrCreateStrikeReference() {
			ReferenceWithMetaFixedRateSpecificationBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = ReferenceWithMetaFixedRateSpecification.builder();
			}
			
			return result;
		}
		
	
		@Override
		public OptionStrike.OptionStrikeBuilder setAveragingStrikeFeature(AveragingObservation averagingStrikeFeature) {
			this.averagingStrikeFeature = averagingStrikeFeature==null?null:averagingStrikeFeature.toBuilder();
			return this;
		}
		@Override
		public OptionStrike.OptionStrikeBuilder setReferenceSwapCurve(ReferenceSwapCurve referenceSwapCurve) {
			this.referenceSwapCurve = referenceSwapCurve==null?null:referenceSwapCurve.toBuilder();
			return this;
		}
		@Override
		public OptionStrike.OptionStrikeBuilder setStrikePrice(Price strikePrice) {
			this.strikePrice = strikePrice==null?null:strikePrice.toBuilder();
			return this;
		}
		@Override
		public OptionStrike.OptionStrikeBuilder setStrikeReference(ReferenceWithMetaFixedRateSpecification strikeReference) {
			this.strikeReference = strikeReference==null?null:strikeReference.toBuilder();
			return this;
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder setStrikeReferenceValue(FixedRateSpecification strikeReference) {
			this.getOrCreateStrikeReference().setValue(strikeReference);
			return this;
		}
		
		@Override
		public OptionStrike build() {
			return new OptionStrike.OptionStrikeImpl(this);
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionStrike.OptionStrikeBuilder prune() {
			if (averagingStrikeFeature!=null && !averagingStrikeFeature.prune().hasData()) averagingStrikeFeature = null;
			if (referenceSwapCurve!=null && !referenceSwapCurve.prune().hasData()) referenceSwapCurve = null;
			if (strikePrice!=null && !strikePrice.prune().hasData()) strikePrice = null;
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAveragingStrikeFeature()!=null && getAveragingStrikeFeature().hasData()) return true;
			if (getReferenceSwapCurve()!=null && getReferenceSwapCurve().hasData()) return true;
			if (getStrikePrice()!=null && getStrikePrice().hasData()) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionStrike.OptionStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionStrike.OptionStrikeBuilder o = (OptionStrike.OptionStrikeBuilder) other;
			
			merger.mergeRosetta(getAveragingStrikeFeature(), o.getAveragingStrikeFeature(), this::setAveragingStrikeFeature);
			merger.mergeRosetta(getReferenceSwapCurve(), o.getReferenceSwapCurve(), this::setReferenceSwapCurve);
			merger.mergeRosetta(getStrikePrice(), o.getStrikePrice(), this::setStrikePrice);
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(averagingStrikeFeature, _that.getAveragingStrikeFeature())) return false;
			if (!Objects.equals(referenceSwapCurve, _that.getReferenceSwapCurve())) return false;
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingStrikeFeature != null ? averagingStrikeFeature.hashCode() : 0);
			_result = 31 * _result + (referenceSwapCurve != null ? referenceSwapCurve.hashCode() : 0);
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionStrikeBuilder {" +
				"averagingStrikeFeature=" + this.averagingStrikeFeature + ", " +
				"referenceSwapCurve=" + this.referenceSwapCurve + ", " +
				"strikePrice=" + this.strikePrice + ", " +
				"strikeReference=" + this.strikeReference +
			'}';
		}
	}
}
