package cdm.observable.asset;

import cdm.observable.asset.meta.PriceSourceDisruptionMeta;
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
 * A data defining:  the parameters used to get a price quote to replace the settlement rate option that is disrupted.
 * @version ${project.version}
 */
@RosettaClass

public interface PriceSourceDisruption extends RosettaModelObject {
	PriceSourceDisruption build();
	PriceSourceDisruption.PriceSourceDisruptionBuilder toBuilder();
	
	/**
	 * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
	 */
	FallbackReferencePrice getFallbackReferencePrice();
	final static PriceSourceDisruptionMeta metaData = new PriceSourceDisruptionMeta();
	
	@Override
	default RosettaMetaData<? extends PriceSourceDisruption> metaData() {
		return metaData;
	} 
			
	static PriceSourceDisruption.PriceSourceDisruptionBuilder builder() {
		return new PriceSourceDisruption.PriceSourceDisruptionBuilderImpl();
	}
	
	default Class<? extends PriceSourceDisruption> getType() {
		return PriceSourceDisruption.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("fallbackReferencePrice"), processor, FallbackReferencePrice.class, getFallbackReferencePrice());
	}
	
	
	interface PriceSourceDisruptionBuilder extends PriceSourceDisruption, RosettaModelObjectBuilder {
		FallbackReferencePrice.FallbackReferencePriceBuilder getOrCreateFallbackReferencePrice();
		FallbackReferencePrice.FallbackReferencePriceBuilder getFallbackReferencePrice();
		PriceSourceDisruption.PriceSourceDisruptionBuilder setFallbackReferencePrice(FallbackReferencePrice fallbackReferencePrice);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("fallbackReferencePrice"), processor, FallbackReferencePrice.FallbackReferencePriceBuilder.class, getFallbackReferencePrice());
		}
		
	}
	
	//PriceSourceDisruption.PriceSourceDisruptionImpl
	class PriceSourceDisruptionImpl implements PriceSourceDisruption {
		private final FallbackReferencePrice fallbackReferencePrice;
		
		protected PriceSourceDisruptionImpl(PriceSourceDisruption.PriceSourceDisruptionBuilder builder) {
			this.fallbackReferencePrice = ofNullable(builder.getFallbackReferencePrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FallbackReferencePrice getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		public PriceSourceDisruption build() {
			return this;
		}
		
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder toBuilder() {
			PriceSourceDisruption.PriceSourceDisruptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceSourceDisruption.PriceSourceDisruptionBuilder builder) {
			ofNullable(getFallbackReferencePrice()).ifPresent(builder::setFallbackReferencePrice);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceSourceDisruption _that = getType().cast(o);
		
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceSourceDisruption {" +
				"fallbackReferencePrice=" + this.fallbackReferencePrice +
			'}';
		}
	}
	
	//PriceSourceDisruption.PriceSourceDisruptionBuilderImpl
	class PriceSourceDisruptionBuilderImpl implements PriceSourceDisruption.PriceSourceDisruptionBuilder {
	
		protected FallbackReferencePrice.FallbackReferencePriceBuilder fallbackReferencePrice;
	
		public PriceSourceDisruptionBuilderImpl() {
		}
	
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder getOrCreateFallbackReferencePrice() {
			FallbackReferencePrice.FallbackReferencePriceBuilder result;
			if (fallbackReferencePrice!=null) {
				result = fallbackReferencePrice;
			}
			else {
				result = fallbackReferencePrice = FallbackReferencePrice.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder setFallbackReferencePrice(FallbackReferencePrice fallbackReferencePrice) {
			this.fallbackReferencePrice = fallbackReferencePrice==null?null:fallbackReferencePrice.toBuilder();
			return this;
		}
		
		@Override
		public PriceSourceDisruption build() {
			return new PriceSourceDisruption.PriceSourceDisruptionImpl(this);
		}
		
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder prune() {
			if (fallbackReferencePrice!=null && !fallbackReferencePrice.prune().hasData()) fallbackReferencePrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFallbackReferencePrice()!=null && getFallbackReferencePrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceSourceDisruption.PriceSourceDisruptionBuilder o = (PriceSourceDisruption.PriceSourceDisruptionBuilder) other;
			
			merger.mergeRosetta(getFallbackReferencePrice(), o.getFallbackReferencePrice(), this::setFallbackReferencePrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceSourceDisruption _that = getType().cast(o);
		
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceSourceDisruptionBuilder {" +
				"fallbackReferencePrice=" + this.fallbackReferencePrice +
			'}';
		}
	}
}
