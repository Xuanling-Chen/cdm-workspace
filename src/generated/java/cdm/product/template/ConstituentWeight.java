package cdm.product.template;

import cdm.product.template.meta.ConstituentWeightMeta;
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
 * A class describing the weight of each of the underlier constituent within the basket, either in absolute or relative terms.
 * @version ${project.version}
 */
@RosettaClass

public interface ConstituentWeight extends RosettaModelObject {
	ConstituentWeight build();
	ConstituentWeight.ConstituentWeightBuilder toBuilder();
	
	/**
	 * The relative weight of each respective basket constituent, expressed in percentage. A basket percentage of 5% would be represented as 0.05.
	 */
	BigDecimal getBasketPercentage();
	/**
	 * The number of units (index or securities) that constitute the underlier of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
	 */
	BigDecimal getOpenUnits();
	final static ConstituentWeightMeta metaData = new ConstituentWeightMeta();
	
	@Override
	default RosettaMetaData<? extends ConstituentWeight> metaData() {
		return metaData;
	} 
			
	static ConstituentWeight.ConstituentWeightBuilder builder() {
		return new ConstituentWeight.ConstituentWeightBuilderImpl();
	}
	
	default Class<? extends ConstituentWeight> getType() {
		return ConstituentWeight.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basketPercentage"), BigDecimal.class, getBasketPercentage(), this);
		processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
		
	}
	
	
	interface ConstituentWeightBuilder extends ConstituentWeight, RosettaModelObjectBuilder {
		ConstituentWeight.ConstituentWeightBuilder setBasketPercentage(BigDecimal basketPercentage);
		ConstituentWeight.ConstituentWeightBuilder setOpenUnits(BigDecimal openUnits);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("basketPercentage"), BigDecimal.class, getBasketPercentage(), this);
			processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
			
		}
		
	}
	
	//ConstituentWeight.ConstituentWeightImpl
	class ConstituentWeightImpl implements ConstituentWeight {
		private final BigDecimal basketPercentage;
		private final BigDecimal openUnits;
		
		protected ConstituentWeightImpl(ConstituentWeight.ConstituentWeightBuilder builder) {
			this.basketPercentage = builder.getBasketPercentage();
			this.openUnits = builder.getOpenUnits();
		}
		
		@Override
		public BigDecimal getBasketPercentage() {
			return basketPercentage;
		}
		
		@Override
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		public ConstituentWeight build() {
			return this;
		}
		
		@Override
		public ConstituentWeight.ConstituentWeightBuilder toBuilder() {
			ConstituentWeight.ConstituentWeightBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConstituentWeight.ConstituentWeightBuilder builder) {
			ofNullable(getBasketPercentage()).ifPresent(builder::setBasketPercentage);
			ofNullable(getOpenUnits()).ifPresent(builder::setOpenUnits);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConstituentWeight _that = getType().cast(o);
		
			if (!Objects.equals(basketPercentage, _that.getBasketPercentage())) return false;
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketPercentage != null ? basketPercentage.hashCode() : 0);
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConstituentWeight {" +
				"basketPercentage=" + this.basketPercentage + ", " +
				"openUnits=" + this.openUnits +
			'}';
		}
	}
	
	//ConstituentWeight.ConstituentWeightBuilderImpl
	class ConstituentWeightBuilderImpl implements ConstituentWeight.ConstituentWeightBuilder {
	
		protected BigDecimal basketPercentage;
		protected BigDecimal openUnits;
	
		public ConstituentWeightBuilderImpl() {
		}
	
		@Override
		public BigDecimal getBasketPercentage() {
			return basketPercentage;
		}
		
		@Override
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
	
		@Override
		public ConstituentWeight.ConstituentWeightBuilder setBasketPercentage(BigDecimal basketPercentage) {
			this.basketPercentage = basketPercentage==null?null:basketPercentage;
			return this;
		}
		@Override
		public ConstituentWeight.ConstituentWeightBuilder setOpenUnits(BigDecimal openUnits) {
			this.openUnits = openUnits==null?null:openUnits;
			return this;
		}
		
		@Override
		public ConstituentWeight build() {
			return new ConstituentWeight.ConstituentWeightImpl(this);
		}
		
		@Override
		public ConstituentWeight.ConstituentWeightBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConstituentWeight.ConstituentWeightBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketPercentage()!=null) return true;
			if (getOpenUnits()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConstituentWeight.ConstituentWeightBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ConstituentWeight.ConstituentWeightBuilder o = (ConstituentWeight.ConstituentWeightBuilder) other;
			
			
			merger.mergeBasic(getBasketPercentage(), o.getBasketPercentage(), this::setBasketPercentage);
			merger.mergeBasic(getOpenUnits(), o.getOpenUnits(), this::setOpenUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConstituentWeight _that = getType().cast(o);
		
			if (!Objects.equals(basketPercentage, _that.getBasketPercentage())) return false;
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketPercentage != null ? basketPercentage.hashCode() : 0);
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConstituentWeightBuilder {" +
				"basketPercentage=" + this.basketPercentage + ", " +
				"openUnits=" + this.openUnits +
			'}';
		}
	}
}
