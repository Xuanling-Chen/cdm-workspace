package cdm.observable.asset;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import cdm.base.math.Quantity.QuantityBuilderImpl;
import cdm.base.math.Quantity.QuantityImpl;
import cdm.base.math.UnitType;
import cdm.observable.asset.meta.MoneyMeta;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a monetary amount in a specified currency.
 * @version ${project.version}
 */
@RosettaClass

public interface Money extends Quantity, GlobalKey {
	Money build();
	Money.MoneyBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	final static MoneyMeta metaData = new MoneyMeta();
	
	@Override
	default RosettaMetaData<? extends Money> metaData() {
		return metaData;
	} 
			
	static Money.MoneyBuilder builder() {
		return new Money.MoneyBuilderImpl();
	}
	
	default Class<? extends Money> getType() {
		return Money.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.math.Quantity.super.process(path, processor);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface MoneyBuilder extends Money, Quantity.QuantityBuilder, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Money.MoneyBuilder setMeta(MetaFields meta);
		Money.MoneyBuilder setMultiplier(BigDecimal multiplier);
		Money.MoneyBuilder setMultiplierUnit(UnitType multiplierUnit);
		Money.MoneyBuilder setAmount(BigDecimal amount);
		Money.MoneyBuilder setUnitOfAmount(UnitType unitOfAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			Quantity.QuantityBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//Money.MoneyImpl
	class MoneyImpl extends Quantity.QuantityImpl implements Money {
		private final MetaFields meta;
		
		protected MoneyImpl(Money.MoneyBuilder builder) {
			super(builder);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Money build() {
			return this;
		}
		
		@Override
		public Money.MoneyBuilder toBuilder() {
			Money.MoneyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Money.MoneyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Money _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Money {" +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}
	
	//Money.MoneyBuilderImpl
	class MoneyBuilderImpl extends Quantity.QuantityBuilderImpl  implements Money.MoneyBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
	
		public MoneyBuilderImpl() {
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
		public Money.MoneyBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Money.MoneyBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		public Money.MoneyBuilder setMultiplierUnit(UnitType multiplierUnit) {
			this.multiplierUnit = multiplierUnit==null?null:multiplierUnit.toBuilder();
			return this;
		}
		@Override
		public Money.MoneyBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		public Money.MoneyBuilder setUnitOfAmount(UnitType unitOfAmount) {
			this.unitOfAmount = unitOfAmount==null?null:unitOfAmount.toBuilder();
			return this;
		}
		
		@Override
		public Money build() {
			return new Money.MoneyImpl(this);
		}
		
		@Override
		public Money.MoneyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Money.MoneyBuilder prune() {
			super.prune();
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Money.MoneyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Money.MoneyBuilder o = (Money.MoneyBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Money _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyBuilder {" +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}
}
