package cdm.base.math;

import cdm.base.math.MeasureBase.MeasureBaseBuilder;
import cdm.base.math.MeasureBase.MeasureBaseBuilderImpl;
import cdm.base.math.MeasureBase.MeasureBaseImpl;
import cdm.base.math.meta.QuantityMeta;
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
 * Specifies a quantity to be associated with an event, for example a trade amount.
 * @version ${project.version}
 */
@RosettaClass

public interface Quantity extends MeasureBase {
	Quantity build();
	Quantity.QuantityBuilder toBuilder();
	
	/**
	 * Defines the number to be multiplied by the amount to derive a total quantity.
	 */
	BigDecimal getMultiplier();
	/**
	 * Qualifies the multiplier with the applicable unit.  For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unitOfAmount would be contracts, the multiplier would 1,000 and the mulitiplier Unit would be 1,000 MT (Metric Tons).
	 */
	UnitType getMultiplierUnit();
	final static QuantityMeta metaData = new QuantityMeta();
	
	@Override
	default RosettaMetaData<? extends Quantity> metaData() {
		return metaData;
	} 
			
	static Quantity.QuantityBuilder builder() {
		return new Quantity.QuantityBuilderImpl();
	}
	
	default Class<? extends Quantity> getType() {
		return Quantity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.math.MeasureBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		
		processRosetta(path.newSubPath("multiplierUnit"), processor, UnitType.class, getMultiplierUnit());
	}
	
	
	interface QuantityBuilder extends Quantity, MeasureBase.MeasureBaseBuilder, RosettaModelObjectBuilder {
		UnitType.UnitTypeBuilder getOrCreateMultiplierUnit();
		UnitType.UnitTypeBuilder getMultiplierUnit();
		Quantity.QuantityBuilder setMultiplier(BigDecimal multiplier);
		Quantity.QuantityBuilder setMultiplierUnit(UnitType multiplierUnit);
		Quantity.QuantityBuilder setAmount(BigDecimal amount);
		Quantity.QuantityBuilder setUnitOfAmount(UnitType unitOfAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			MeasureBase.MeasureBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			
			processRosetta(path.newSubPath("multiplierUnit"), processor, UnitType.UnitTypeBuilder.class, getMultiplierUnit());
		}
		
	}
	
	//Quantity.QuantityImpl
	class QuantityImpl extends MeasureBase.MeasureBaseImpl implements Quantity {
		private final BigDecimal multiplier;
		private final UnitType multiplierUnit;
		
		protected QuantityImpl(Quantity.QuantityBuilder builder) {
			super(builder);
			this.multiplier = builder.getMultiplier();
			this.multiplierUnit = ofNullable(builder.getMultiplierUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		public UnitType getMultiplierUnit() {
			return multiplierUnit;
		}
		
		@Override
		public Quantity build() {
			return this;
		}
		
		@Override
		public Quantity.QuantityBuilder toBuilder() {
			Quantity.QuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Quantity.QuantityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getMultiplierUnit()).ifPresent(builder::setMultiplierUnit);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Quantity _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(multiplierUnit, _that.getMultiplierUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (multiplierUnit != null ? multiplierUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Quantity {" +
				"multiplier=" + this.multiplier + ", " +
				"multiplierUnit=" + this.multiplierUnit +
			'}' + " " + super.toString();
		}
	}
	
	//Quantity.QuantityBuilderImpl
	class QuantityBuilderImpl extends MeasureBase.MeasureBaseBuilderImpl  implements Quantity.QuantityBuilder {
	
		protected BigDecimal multiplier;
		protected UnitType.UnitTypeBuilder multiplierUnit;
	
		public QuantityBuilderImpl() {
		}
	
		@Override
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		public UnitType.UnitTypeBuilder getMultiplierUnit() {
			return multiplierUnit;
		}
		
		@Override
		public UnitType.UnitTypeBuilder getOrCreateMultiplierUnit() {
			UnitType.UnitTypeBuilder result;
			if (multiplierUnit!=null) {
				result = multiplierUnit;
			}
			else {
				result = multiplierUnit = UnitType.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Quantity.QuantityBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		public Quantity.QuantityBuilder setMultiplierUnit(UnitType multiplierUnit) {
			this.multiplierUnit = multiplierUnit==null?null:multiplierUnit.toBuilder();
			return this;
		}
		@Override
		public Quantity.QuantityBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		public Quantity.QuantityBuilder setUnitOfAmount(UnitType unitOfAmount) {
			this.unitOfAmount = unitOfAmount==null?null:unitOfAmount.toBuilder();
			return this;
		}
		
		@Override
		public Quantity build() {
			return new Quantity.QuantityImpl(this);
		}
		
		@Override
		public Quantity.QuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Quantity.QuantityBuilder prune() {
			super.prune();
			if (multiplierUnit!=null && !multiplierUnit.prune().hasData()) multiplierUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultiplier()!=null) return true;
			if (getMultiplierUnit()!=null && getMultiplierUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Quantity.QuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Quantity.QuantityBuilder o = (Quantity.QuantityBuilder) other;
			
			merger.mergeRosetta(getMultiplierUnit(), o.getMultiplierUnit(), this::setMultiplierUnit);
			
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Quantity _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(multiplierUnit, _that.getMultiplierUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (multiplierUnit != null ? multiplierUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityBuilder {" +
				"multiplier=" + this.multiplier + ", " +
				"multiplierUnit=" + this.multiplierUnit +
			'}' + " " + super.toString();
		}
	}
}
