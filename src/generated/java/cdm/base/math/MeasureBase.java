package cdm.base.math;

import cdm.base.math.meta.MeasureBaseMeta;
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
 * Provides an abstract base class shared by Price and Quantity.
 * @version ${project.version}
 */
@RosettaClass

public interface MeasureBase extends RosettaModelObject {
	MeasureBase build();
	MeasureBase.MeasureBaseBuilder toBuilder();
	
	/**
	 * Specifies an amount to be qualified and used in a Price or Quantity definition.
	 */
	BigDecimal getAmount();
	/**
	 * Qualifies the unit by which the amount is measured.
	 */
	UnitType getUnitOfAmount();
	final static MeasureBaseMeta metaData = new MeasureBaseMeta();
	
	@Override
	default RosettaMetaData<? extends MeasureBase> metaData() {
		return metaData;
	} 
			
	static MeasureBase.MeasureBaseBuilder builder() {
		return new MeasureBase.MeasureBaseBuilderImpl();
	}
	
	default Class<? extends MeasureBase> getType() {
		return MeasureBase.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		
		processRosetta(path.newSubPath("unitOfAmount"), processor, UnitType.class, getUnitOfAmount());
	}
	
	
	interface MeasureBaseBuilder extends MeasureBase, RosettaModelObjectBuilder {
		UnitType.UnitTypeBuilder getOrCreateUnitOfAmount();
		UnitType.UnitTypeBuilder getUnitOfAmount();
		MeasureBase.MeasureBaseBuilder setAmount(BigDecimal amount);
		MeasureBase.MeasureBaseBuilder setUnitOfAmount(UnitType unitOfAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			
			processRosetta(path.newSubPath("unitOfAmount"), processor, UnitType.UnitTypeBuilder.class, getUnitOfAmount());
		}
		
	}
	
	//MeasureBase.MeasureBaseImpl
	class MeasureBaseImpl implements MeasureBase {
		private final BigDecimal amount;
		private final UnitType unitOfAmount;
		
		protected MeasureBaseImpl(MeasureBase.MeasureBaseBuilder builder) {
			this.amount = builder.getAmount();
			this.unitOfAmount = ofNullable(builder.getUnitOfAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public UnitType getUnitOfAmount() {
			return unitOfAmount;
		}
		
		@Override
		public MeasureBase build() {
			return this;
		}
		
		@Override
		public MeasureBase.MeasureBaseBuilder toBuilder() {
			MeasureBase.MeasureBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MeasureBase.MeasureBaseBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getUnitOfAmount()).ifPresent(builder::setUnitOfAmount);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MeasureBase _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(unitOfAmount, _that.getUnitOfAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (unitOfAmount != null ? unitOfAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MeasureBase {" +
				"amount=" + this.amount + ", " +
				"unitOfAmount=" + this.unitOfAmount +
			'}';
		}
	}
	
	//MeasureBase.MeasureBaseBuilderImpl
	class MeasureBaseBuilderImpl implements MeasureBase.MeasureBaseBuilder {
	
		protected BigDecimal amount;
		protected UnitType.UnitTypeBuilder unitOfAmount;
	
		public MeasureBaseBuilderImpl() {
		}
	
		@Override
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public UnitType.UnitTypeBuilder getUnitOfAmount() {
			return unitOfAmount;
		}
		
		@Override
		public UnitType.UnitTypeBuilder getOrCreateUnitOfAmount() {
			UnitType.UnitTypeBuilder result;
			if (unitOfAmount!=null) {
				result = unitOfAmount;
			}
			else {
				result = unitOfAmount = UnitType.builder();
			}
			
			return result;
		}
		
	
		@Override
		public MeasureBase.MeasureBaseBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		public MeasureBase.MeasureBaseBuilder setUnitOfAmount(UnitType unitOfAmount) {
			this.unitOfAmount = unitOfAmount==null?null:unitOfAmount.toBuilder();
			return this;
		}
		
		@Override
		public MeasureBase build() {
			return new MeasureBase.MeasureBaseImpl(this);
		}
		
		@Override
		public MeasureBase.MeasureBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MeasureBase.MeasureBaseBuilder prune() {
			if (unitOfAmount!=null && !unitOfAmount.prune().hasData()) unitOfAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null) return true;
			if (getUnitOfAmount()!=null && getUnitOfAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MeasureBase.MeasureBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MeasureBase.MeasureBaseBuilder o = (MeasureBase.MeasureBaseBuilder) other;
			
			merger.mergeRosetta(getUnitOfAmount(), o.getUnitOfAmount(), this::setUnitOfAmount);
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MeasureBase _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(unitOfAmount, _that.getUnitOfAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (unitOfAmount != null ? unitOfAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MeasureBaseBuilder {" +
				"amount=" + this.amount + ", " +
				"unitOfAmount=" + this.unitOfAmount +
			'}';
		}
	}
}
