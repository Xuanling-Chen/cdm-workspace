package cdm.product.common.settlement;

import cdm.base.datetime.Offset;
import cdm.product.asset.RollSourceCalendarEnum;
import cdm.product.common.settlement.meta.RollFeatureMeta;
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
 * Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. 
 * @version ${project.version}
 */
@RosettaClass

public interface RollFeature extends RosettaModelObject {
	RollFeature build();
	RollFeature.RollFeatureBuilder toBuilder();
	
	/**
	 * Specifies, for a Commodity Transaction that references a delivery date for a listed future, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 should be specified and so on.
	 */
	Offset getDeliveryDateRollConvention();
	/**
	 * Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if Future is chosen, the pricing will roll to the next futures contract on expiration, if ListedOption is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
	 */
	RollSourceCalendarEnum getRollSourceCalendar();
	final static RollFeatureMeta metaData = new RollFeatureMeta();
	
	@Override
	default RosettaMetaData<? extends RollFeature> metaData() {
		return metaData;
	} 
			
	static RollFeature.RollFeatureBuilder builder() {
		return new RollFeature.RollFeatureBuilderImpl();
	}
	
	default Class<? extends RollFeature> getType() {
		return RollFeature.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rollSourceCalendar"), RollSourceCalendarEnum.class, getRollSourceCalendar(), this);
		
		processRosetta(path.newSubPath("deliveryDateRollConvention"), processor, Offset.class, getDeliveryDateRollConvention());
	}
	
	
	interface RollFeatureBuilder extends RollFeature, RosettaModelObjectBuilder {
		Offset.OffsetBuilder getOrCreateDeliveryDateRollConvention();
		Offset.OffsetBuilder getDeliveryDateRollConvention();
		RollFeature.RollFeatureBuilder setDeliveryDateRollConvention(Offset deliveryDateRollConvention);
		RollFeature.RollFeatureBuilder setRollSourceCalendar(RollSourceCalendarEnum rollSourceCalendar);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("rollSourceCalendar"), RollSourceCalendarEnum.class, getRollSourceCalendar(), this);
			
			processRosetta(path.newSubPath("deliveryDateRollConvention"), processor, Offset.OffsetBuilder.class, getDeliveryDateRollConvention());
		}
		
	}
	
	//RollFeature.RollFeatureImpl
	class RollFeatureImpl implements RollFeature {
		private final Offset deliveryDateRollConvention;
		private final RollSourceCalendarEnum rollSourceCalendar;
		
		protected RollFeatureImpl(RollFeature.RollFeatureBuilder builder) {
			this.deliveryDateRollConvention = ofNullable(builder.getDeliveryDateRollConvention()).map(f->f.build()).orElse(null);
			this.rollSourceCalendar = builder.getRollSourceCalendar();
		}
		
		@Override
		public Offset getDeliveryDateRollConvention() {
			return deliveryDateRollConvention;
		}
		
		@Override
		public RollSourceCalendarEnum getRollSourceCalendar() {
			return rollSourceCalendar;
		}
		
		@Override
		public RollFeature build() {
			return this;
		}
		
		@Override
		public RollFeature.RollFeatureBuilder toBuilder() {
			RollFeature.RollFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RollFeature.RollFeatureBuilder builder) {
			ofNullable(getDeliveryDateRollConvention()).ifPresent(builder::setDeliveryDateRollConvention);
			ofNullable(getRollSourceCalendar()).ifPresent(builder::setRollSourceCalendar);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RollFeature _that = getType().cast(o);
		
			if (!Objects.equals(deliveryDateRollConvention, _that.getDeliveryDateRollConvention())) return false;
			if (!Objects.equals(rollSourceCalendar, _that.getRollSourceCalendar())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryDateRollConvention != null ? deliveryDateRollConvention.hashCode() : 0);
			_result = 31 * _result + (rollSourceCalendar != null ? rollSourceCalendar.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RollFeature {" +
				"deliveryDateRollConvention=" + this.deliveryDateRollConvention + ", " +
				"rollSourceCalendar=" + this.rollSourceCalendar +
			'}';
		}
	}
	
	//RollFeature.RollFeatureBuilderImpl
	class RollFeatureBuilderImpl implements RollFeature.RollFeatureBuilder {
	
		protected Offset.OffsetBuilder deliveryDateRollConvention;
		protected RollSourceCalendarEnum rollSourceCalendar;
	
		public RollFeatureBuilderImpl() {
		}
	
		@Override
		public Offset.OffsetBuilder getDeliveryDateRollConvention() {
			return deliveryDateRollConvention;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateDeliveryDateRollConvention() {
			Offset.OffsetBuilder result;
			if (deliveryDateRollConvention!=null) {
				result = deliveryDateRollConvention;
			}
			else {
				result = deliveryDateRollConvention = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		public RollSourceCalendarEnum getRollSourceCalendar() {
			return rollSourceCalendar;
		}
		
	
		@Override
		public RollFeature.RollFeatureBuilder setDeliveryDateRollConvention(Offset deliveryDateRollConvention) {
			this.deliveryDateRollConvention = deliveryDateRollConvention==null?null:deliveryDateRollConvention.toBuilder();
			return this;
		}
		@Override
		public RollFeature.RollFeatureBuilder setRollSourceCalendar(RollSourceCalendarEnum rollSourceCalendar) {
			this.rollSourceCalendar = rollSourceCalendar==null?null:rollSourceCalendar;
			return this;
		}
		
		@Override
		public RollFeature build() {
			return new RollFeature.RollFeatureImpl(this);
		}
		
		@Override
		public RollFeature.RollFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RollFeature.RollFeatureBuilder prune() {
			if (deliveryDateRollConvention!=null && !deliveryDateRollConvention.prune().hasData()) deliveryDateRollConvention = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryDateRollConvention()!=null && getDeliveryDateRollConvention().hasData()) return true;
			if (getRollSourceCalendar()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RollFeature.RollFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RollFeature.RollFeatureBuilder o = (RollFeature.RollFeatureBuilder) other;
			
			merger.mergeRosetta(getDeliveryDateRollConvention(), o.getDeliveryDateRollConvention(), this::setDeliveryDateRollConvention);
			
			merger.mergeBasic(getRollSourceCalendar(), o.getRollSourceCalendar(), this::setRollSourceCalendar);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RollFeature _that = getType().cast(o);
		
			if (!Objects.equals(deliveryDateRollConvention, _that.getDeliveryDateRollConvention())) return false;
			if (!Objects.equals(rollSourceCalendar, _that.getRollSourceCalendar())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryDateRollConvention != null ? deliveryDateRollConvention.hashCode() : 0);
			_result = 31 * _result + (rollSourceCalendar != null ? rollSourceCalendar.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RollFeatureBuilder {" +
				"deliveryDateRollConvention=" + this.deliveryDateRollConvention + ", " +
				"rollSourceCalendar=" + this.rollSourceCalendar +
			'}';
		}
	}
}
