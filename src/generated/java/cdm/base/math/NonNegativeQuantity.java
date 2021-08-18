package cdm.base.math;

import cdm.base.math.Quantity.QuantityBuilder;
import cdm.base.math.Quantity.QuantityBuilderImpl;
import cdm.base.math.Quantity.QuantityImpl;
import cdm.base.math.meta.NonNegativeQuantityMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;


/**
 *  Class to specify a quantity as a non-negative number, which condition is enforced through a data rule that only applies to the extending class.
 * @version ${project.version}
 */
@RosettaClass

public interface NonNegativeQuantity extends Quantity {
	NonNegativeQuantity build();
	NonNegativeQuantity.NonNegativeQuantityBuilder toBuilder();
	
	final static NonNegativeQuantityMeta metaData = new NonNegativeQuantityMeta();
	
	@Override
	default RosettaMetaData<? extends NonNegativeQuantity> metaData() {
		return metaData;
	} 
			
	static NonNegativeQuantity.NonNegativeQuantityBuilder builder() {
		return new NonNegativeQuantity.NonNegativeQuantityBuilderImpl();
	}
	
	default Class<? extends NonNegativeQuantity> getType() {
		return NonNegativeQuantity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.math.Quantity.super.process(path, processor);
		
	}
	
	
	interface NonNegativeQuantityBuilder extends NonNegativeQuantity, Quantity.QuantityBuilder, RosettaModelObjectBuilder {
		NonNegativeQuantity.NonNegativeQuantityBuilder setMultiplier(BigDecimal multiplier);
		NonNegativeQuantity.NonNegativeQuantityBuilder setMultiplierUnit(UnitType multiplierUnit);
		NonNegativeQuantity.NonNegativeQuantityBuilder setAmount(BigDecimal amount);
		NonNegativeQuantity.NonNegativeQuantityBuilder setUnitOfAmount(UnitType unitOfAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			Quantity.QuantityBuilder.super.process(path, processor);
			
			
		}
		
	}
	
	//NonNegativeQuantity.NonNegativeQuantityImpl
	class NonNegativeQuantityImpl extends Quantity.QuantityImpl implements NonNegativeQuantity {
		
		protected NonNegativeQuantityImpl(NonNegativeQuantity.NonNegativeQuantityBuilder builder) {
			super(builder);
		}
		
		@Override
		public NonNegativeQuantity build() {
			return this;
		}
		
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder toBuilder() {
			NonNegativeQuantity.NonNegativeQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeQuantity.NonNegativeQuantityBuilder builder) {
			super.setBuilderFields(builder);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeQuantity {" +
			'}' + " " + super.toString();
		}
	}
	
	//NonNegativeQuantity.NonNegativeQuantityBuilderImpl
	class NonNegativeQuantityBuilderImpl extends Quantity.QuantityBuilderImpl  implements NonNegativeQuantity.NonNegativeQuantityBuilder {
	
	
		public NonNegativeQuantityBuilderImpl() {
		}
	
	
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder setMultiplierUnit(UnitType multiplierUnit) {
			this.multiplierUnit = multiplierUnit==null?null:multiplierUnit.toBuilder();
			return this;
		}
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder setUnitOfAmount(UnitType unitOfAmount) {
			this.unitOfAmount = unitOfAmount==null?null:unitOfAmount.toBuilder();
			return this;
		}
		
		@Override
		public NonNegativeQuantity build() {
			return new NonNegativeQuantity.NonNegativeQuantityImpl(this);
		}
		
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonNegativeQuantity.NonNegativeQuantityBuilder o = (NonNegativeQuantity.NonNegativeQuantityBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeQuantityBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
