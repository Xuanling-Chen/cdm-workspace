package cdm.product.common.settlement;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.Quantity;
import cdm.base.math.Quantity;
import cdm.base.math.metafields.ReferenceWithMetaQuantity;
import cdm.base.math.metafields.ReferenceWithMetaQuantity.ReferenceWithMetaQuantityBuilder;
import cdm.product.asset.FutureValueAmount;
import cdm.product.common.settlement.meta.ResolvablePayoutQuantityMeta;
import cdm.product.common.settlement.metafields.ReferenceWithMetaResolvablePayoutQuantity;
import cdm.product.common.settlement.metafields.ReferenceWithMetaResolvablePayoutQuantity.ReferenceWithMetaResolvablePayoutQuantityBuilder;
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
 * Generic class to specify the quantity for different payout legs in a contractual product, when that quantity can vary across payout legs or across time. A resolvable quantity can always be resolved into a single quantity from the quantity notation which has a corresponding asset identifier. In addition to the base case, where quantity is directly specified as a number as part of the quantity notation, the other use cases are: (i) quantity based on some pre-defined schedule (eg amortising notional), (ii) quantity based on some pre-defined events (eg resetting cross-currency notional), or quantity set as reference to another quantity (eg equity notional as no. securities x price).
 * @version ${project.version}
 */
@RosettaClass

public interface ResolvablePayoutQuantity extends RosettaModelObject, GlobalKey {
	ResolvablePayoutQuantity build();
	ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder toBuilder();
	
	/**
	 * The future value notional is specific to BRL CDI swaps, and is specified alongside the notional amount. The value is calculated as follows: Future Value Notional = Notional Amount * (1 + Fixed Rate) ^ (Fixed Rate Day Count Fraction). The currency should always match that expressed in the notional schedule. The value date should match the adjusted termination date.
	 */
	FutureValueAmount getFutureValueNotional();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Quantity multiplier is specified on top of a reference quantity and is used as a multiplying factor when resolving the quantity. A quantity multiplier can only exist when the resolvable quantity specifies a reference quantity.
	 */
	QuantityMultiplier getQuantityMultiplier();
	/**
	 * Reference quantity when resolvable quantity is defined as relative to another (resolvable) quantity. A resolvable quantity needs to contain either an absolute quantity or a reference to another (resolvable) quantity. This requirement is captured by a choice rule on the class.
	 */
	ReferenceWithMetaResolvablePayoutQuantity getQuantityReference();
	/**
	 * Quantity step schedule, including an initial quantity specified as an absolute number.
	 */
	NonNegativeQuantitySchedule getQuantitySchedule();
	/**
	 * Whether the quantity is resettable
	 */
	Boolean getReset();
	/**
	 * A product&#39;s quantity as a single, non-negative amount.  When specified as part of a product definition, this quantity attribute would not be set.  Instead it is specified on the quantity notation along with an asset identifier matching this payout&#39;s asset identifier.  This allows the the quantity to be resolved for a payout leg, which can then be specified here for convenience during data processing.  There needs to be at least one resolvable quantity across payout legs of a product to define an anchor that other payout quantities can refer to.  This attribute is ignored when mapping existing FpML messages.
	 */
	ReferenceWithMetaQuantity getResolvedQuantity();
	final static ResolvablePayoutQuantityMeta metaData = new ResolvablePayoutQuantityMeta();
	
	@Override
	default RosettaMetaData<? extends ResolvablePayoutQuantity> metaData() {
		return metaData;
	} 
			
	static ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder builder() {
		return new ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilderImpl();
	}
	
	default Class<? extends ResolvablePayoutQuantity> getType() {
		return ResolvablePayoutQuantity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("reset"), Boolean.class, getReset(), this);
		
		processRosetta(path.newSubPath("futureValueNotional"), processor, FutureValueAmount.class, getFutureValueNotional());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("quantityMultiplier"), processor, QuantityMultiplier.class, getQuantityMultiplier());
		processRosetta(path.newSubPath("quantityReference"), processor, ReferenceWithMetaResolvablePayoutQuantity.class, getQuantityReference());
		processRosetta(path.newSubPath("quantitySchedule"), processor, NonNegativeQuantitySchedule.class, getQuantitySchedule());
		processRosetta(path.newSubPath("resolvedQuantity"), processor, ReferenceWithMetaQuantity.class, getResolvedQuantity());
	}
	
	
	interface ResolvablePayoutQuantityBuilder extends ResolvablePayoutQuantity, RosettaModelObjectBuilder {
		FutureValueAmount.FutureValueAmountBuilder getOrCreateFutureValueNotional();
		FutureValueAmount.FutureValueAmountBuilder getFutureValueNotional();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		QuantityMultiplier.QuantityMultiplierBuilder getOrCreateQuantityMultiplier();
		QuantityMultiplier.QuantityMultiplierBuilder getQuantityMultiplier();
		ReferenceWithMetaResolvablePayoutQuantityBuilder getOrCreateQuantityReference();
		ReferenceWithMetaResolvablePayoutQuantityBuilder getQuantityReference();
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder getOrCreateQuantitySchedule();
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder getQuantitySchedule();
		ReferenceWithMetaQuantityBuilder getOrCreateResolvedQuantity();
		ReferenceWithMetaQuantityBuilder getResolvedQuantity();
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setFutureValueNotional(FutureValueAmount futureValueNotional);
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setMeta(MetaFields meta);
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setQuantityMultiplier(QuantityMultiplier quantityMultiplier);
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setQuantityReference(ReferenceWithMetaResolvablePayoutQuantity quantityReference);
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setQuantityReferenceValue(ResolvablePayoutQuantity quantityReference);
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setQuantitySchedule(NonNegativeQuantitySchedule quantitySchedule);
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setReset(Boolean reset);
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setResolvedQuantity(ReferenceWithMetaQuantity resolvedQuantity);
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setResolvedQuantityValue(Quantity resolvedQuantity);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("reset"), Boolean.class, getReset(), this);
			
			processRosetta(path.newSubPath("futureValueNotional"), processor, FutureValueAmount.FutureValueAmountBuilder.class, getFutureValueNotional());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("quantityMultiplier"), processor, QuantityMultiplier.QuantityMultiplierBuilder.class, getQuantityMultiplier());
			processRosetta(path.newSubPath("quantityReference"), processor, ReferenceWithMetaResolvablePayoutQuantityBuilder.class, getQuantityReference());
			processRosetta(path.newSubPath("quantitySchedule"), processor, NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder.class, getQuantitySchedule());
			processRosetta(path.newSubPath("resolvedQuantity"), processor, ReferenceWithMetaQuantityBuilder.class, getResolvedQuantity());
		}
		
	}
	
	//ResolvablePayoutQuantity.ResolvablePayoutQuantityImpl
	class ResolvablePayoutQuantityImpl implements ResolvablePayoutQuantity {
		private final FutureValueAmount futureValueNotional;
		private final MetaFields meta;
		private final QuantityMultiplier quantityMultiplier;
		private final ReferenceWithMetaResolvablePayoutQuantity quantityReference;
		private final NonNegativeQuantitySchedule quantitySchedule;
		private final Boolean reset;
		private final ReferenceWithMetaQuantity resolvedQuantity;
		
		protected ResolvablePayoutQuantityImpl(ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder builder) {
			this.futureValueNotional = ofNullable(builder.getFutureValueNotional()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.quantityMultiplier = ofNullable(builder.getQuantityMultiplier()).map(f->f.build()).orElse(null);
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
			this.quantitySchedule = ofNullable(builder.getQuantitySchedule()).map(f->f.build()).orElse(null);
			this.reset = builder.getReset();
			this.resolvedQuantity = ofNullable(builder.getResolvedQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FutureValueAmount getFutureValueNotional() {
			return futureValueNotional;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public QuantityMultiplier getQuantityMultiplier() {
			return quantityMultiplier;
		}
		
		@Override
		public ReferenceWithMetaResolvablePayoutQuantity getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public NonNegativeQuantitySchedule getQuantitySchedule() {
			return quantitySchedule;
		}
		
		@Override
		public Boolean getReset() {
			return reset;
		}
		
		@Override
		public ReferenceWithMetaQuantity getResolvedQuantity() {
			return resolvedQuantity;
		}
		
		@Override
		public ResolvablePayoutQuantity build() {
			return this;
		}
		
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder toBuilder() {
			ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder builder) {
			ofNullable(getFutureValueNotional()).ifPresent(builder::setFutureValueNotional);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getQuantityMultiplier()).ifPresent(builder::setQuantityMultiplier);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
			ofNullable(getQuantitySchedule()).ifPresent(builder::setQuantitySchedule);
			ofNullable(getReset()).ifPresent(builder::setReset);
			ofNullable(getResolvedQuantity()).ifPresent(builder::setResolvedQuantity);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResolvablePayoutQuantity _that = getType().cast(o);
		
			if (!Objects.equals(futureValueNotional, _that.getFutureValueNotional())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(quantityMultiplier, _that.getQuantityMultiplier())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(quantitySchedule, _that.getQuantitySchedule())) return false;
			if (!Objects.equals(reset, _that.getReset())) return false;
			if (!Objects.equals(resolvedQuantity, _that.getResolvedQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (futureValueNotional != null ? futureValueNotional.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (quantityMultiplier != null ? quantityMultiplier.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (quantitySchedule != null ? quantitySchedule.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (resolvedQuantity != null ? resolvedQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResolvablePayoutQuantity {" +
				"futureValueNotional=" + this.futureValueNotional + ", " +
				"meta=" + this.meta + ", " +
				"quantityMultiplier=" + this.quantityMultiplier + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"quantitySchedule=" + this.quantitySchedule + ", " +
				"reset=" + this.reset + ", " +
				"resolvedQuantity=" + this.resolvedQuantity +
			'}';
		}
	}
	
	//ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilderImpl
	class ResolvablePayoutQuantityBuilderImpl implements ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder, GlobalKeyBuilder {
	
		protected FutureValueAmount.FutureValueAmountBuilder futureValueNotional;
		protected MetaFields.MetaFieldsBuilder meta;
		protected QuantityMultiplier.QuantityMultiplierBuilder quantityMultiplier;
		protected ReferenceWithMetaResolvablePayoutQuantityBuilder quantityReference;
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantitySchedule;
		protected Boolean reset;
		protected ReferenceWithMetaQuantityBuilder resolvedQuantity;
	
		public ResolvablePayoutQuantityBuilderImpl() {
		}
	
		@Override
		public FutureValueAmount.FutureValueAmountBuilder getFutureValueNotional() {
			return futureValueNotional;
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder getOrCreateFutureValueNotional() {
			FutureValueAmount.FutureValueAmountBuilder result;
			if (futureValueNotional!=null) {
				result = futureValueNotional;
			}
			else {
				result = futureValueNotional = FutureValueAmount.builder();
			}
			
			return result;
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
		public QuantityMultiplier.QuantityMultiplierBuilder getQuantityMultiplier() {
			return quantityMultiplier;
		}
		
		@Override
		public QuantityMultiplier.QuantityMultiplierBuilder getOrCreateQuantityMultiplier() {
			QuantityMultiplier.QuantityMultiplierBuilder result;
			if (quantityMultiplier!=null) {
				result = quantityMultiplier;
			}
			else {
				result = quantityMultiplier = QuantityMultiplier.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaResolvablePayoutQuantityBuilder getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public ReferenceWithMetaResolvablePayoutQuantityBuilder getOrCreateQuantityReference() {
			ReferenceWithMetaResolvablePayoutQuantityBuilder result;
			if (quantityReference!=null) {
				result = quantityReference;
			}
			else {
				result = quantityReference = ReferenceWithMetaResolvablePayoutQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder getQuantitySchedule() {
			return quantitySchedule;
		}
		
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder getOrCreateQuantitySchedule() {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder result;
			if (quantitySchedule!=null) {
				result = quantitySchedule;
			}
			else {
				result = quantitySchedule = NonNegativeQuantitySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getReset() {
			return reset;
		}
		
		@Override
		public ReferenceWithMetaQuantityBuilder getResolvedQuantity() {
			return resolvedQuantity;
		}
		
		@Override
		public ReferenceWithMetaQuantityBuilder getOrCreateResolvedQuantity() {
			ReferenceWithMetaQuantityBuilder result;
			if (resolvedQuantity!=null) {
				result = resolvedQuantity;
			}
			else {
				result = resolvedQuantity = ReferenceWithMetaQuantity.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setFutureValueNotional(FutureValueAmount futureValueNotional) {
			this.futureValueNotional = futureValueNotional==null?null:futureValueNotional.toBuilder();
			return this;
		}
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setQuantityMultiplier(QuantityMultiplier quantityMultiplier) {
			this.quantityMultiplier = quantityMultiplier==null?null:quantityMultiplier.toBuilder();
			return this;
		}
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setQuantityReference(ReferenceWithMetaResolvablePayoutQuantity quantityReference) {
			this.quantityReference = quantityReference==null?null:quantityReference.toBuilder();
			return this;
		}
		
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setQuantityReferenceValue(ResolvablePayoutQuantity quantityReference) {
			this.getOrCreateQuantityReference().setValue(quantityReference);
			return this;
		}
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setQuantitySchedule(NonNegativeQuantitySchedule quantitySchedule) {
			this.quantitySchedule = quantitySchedule==null?null:quantitySchedule.toBuilder();
			return this;
		}
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setReset(Boolean reset) {
			this.reset = reset==null?null:reset;
			return this;
		}
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setResolvedQuantity(ReferenceWithMetaQuantity resolvedQuantity) {
			this.resolvedQuantity = resolvedQuantity==null?null:resolvedQuantity.toBuilder();
			return this;
		}
		
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder setResolvedQuantityValue(Quantity resolvedQuantity) {
			this.getOrCreateResolvedQuantity().setValue(resolvedQuantity);
			return this;
		}
		
		@Override
		public ResolvablePayoutQuantity build() {
			return new ResolvablePayoutQuantity.ResolvablePayoutQuantityImpl(this);
		}
		
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder prune() {
			if (futureValueNotional!=null && !futureValueNotional.prune().hasData()) futureValueNotional = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (quantityMultiplier!=null && !quantityMultiplier.prune().hasData()) quantityMultiplier = null;
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			if (quantitySchedule!=null && !quantitySchedule.prune().hasData()) quantitySchedule = null;
			if (resolvedQuantity!=null && !resolvedQuantity.prune().hasData()) resolvedQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFutureValueNotional()!=null && getFutureValueNotional().hasData()) return true;
			if (getQuantityMultiplier()!=null && getQuantityMultiplier().hasData()) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			if (getQuantitySchedule()!=null && getQuantitySchedule().hasData()) return true;
			if (getReset()!=null) return true;
			if (getResolvedQuantity()!=null && getResolvedQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder o = (ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder) other;
			
			merger.mergeRosetta(getFutureValueNotional(), o.getFutureValueNotional(), this::setFutureValueNotional);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getQuantityMultiplier(), o.getQuantityMultiplier(), this::setQuantityMultiplier);
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			merger.mergeRosetta(getQuantitySchedule(), o.getQuantitySchedule(), this::setQuantitySchedule);
			merger.mergeRosetta(getResolvedQuantity(), o.getResolvedQuantity(), this::setResolvedQuantity);
			
			merger.mergeBasic(getReset(), o.getReset(), this::setReset);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResolvablePayoutQuantity _that = getType().cast(o);
		
			if (!Objects.equals(futureValueNotional, _that.getFutureValueNotional())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(quantityMultiplier, _that.getQuantityMultiplier())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(quantitySchedule, _that.getQuantitySchedule())) return false;
			if (!Objects.equals(reset, _that.getReset())) return false;
			if (!Objects.equals(resolvedQuantity, _that.getResolvedQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (futureValueNotional != null ? futureValueNotional.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (quantityMultiplier != null ? quantityMultiplier.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (quantitySchedule != null ? quantitySchedule.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (resolvedQuantity != null ? resolvedQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResolvablePayoutQuantityBuilder {" +
				"futureValueNotional=" + this.futureValueNotional + ", " +
				"meta=" + this.meta + ", " +
				"quantityMultiplier=" + this.quantityMultiplier + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"quantitySchedule=" + this.quantitySchedule + ", " +
				"reset=" + this.reset + ", " +
				"resolvedQuantity=" + this.resolvedQuantity +
			'}';
		}
	}
}
