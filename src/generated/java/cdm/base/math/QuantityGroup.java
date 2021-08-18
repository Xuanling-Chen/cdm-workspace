package cdm.base.math;

import cdm.base.math.meta.QuantityGroupMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface QuantityGroup extends RosettaModelObject {
	QuantityGroup build();
	QuantityGroup.QuantityGroupBuilder toBuilder();
	
	/**
	 */
	List<? extends BigDecimal> getAmount();
	/**
	 */
	String getCurrency();
	final static QuantityGroupMeta metaData = new QuantityGroupMeta();
	
	@Override
	default RosettaMetaData<? extends QuantityGroup> metaData() {
		return metaData;
	} 
			
	static QuantityGroup.QuantityGroupBuilder builder() {
		return new QuantityGroup.QuantityGroupBuilderImpl();
	}
	
	default Class<? extends QuantityGroup> getType() {
		return QuantityGroup.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("currency"), String.class, getCurrency(), this);
		
	}
	
	
	interface QuantityGroupBuilder extends QuantityGroup, RosettaModelObjectBuilder {
		QuantityGroup.QuantityGroupBuilder addAmount(BigDecimal amount);
		QuantityGroup.QuantityGroupBuilder addAmount(BigDecimal amount, int _idx);
		QuantityGroup.QuantityGroupBuilder addAmount(List<? extends BigDecimal> amount);
		QuantityGroup.QuantityGroupBuilder setAmount(List<? extends BigDecimal> amount);
		QuantityGroup.QuantityGroupBuilder setCurrency(String currency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("currency"), String.class, getCurrency(), this);
			
		}
		
	}
	
	//QuantityGroup.QuantityGroupImpl
	class QuantityGroupImpl implements QuantityGroup {
		private final List<? extends BigDecimal> amount;
		private final String currency;
		
		protected QuantityGroupImpl(QuantityGroup.QuantityGroupBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.currency = builder.getCurrency();
		}
		
		@Override
		public List<? extends BigDecimal> getAmount() {
			return amount;
		}
		
		@Override
		public String getCurrency() {
			return currency;
		}
		
		@Override
		public QuantityGroup build() {
			return this;
		}
		
		@Override
		public QuantityGroup.QuantityGroupBuilder toBuilder() {
			QuantityGroup.QuantityGroupBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantityGroup.QuantityGroupBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityGroup _that = getType().cast(o);
		
			if (!ListEquals.listEquals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityGroup {" +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
	
	//QuantityGroup.QuantityGroupBuilderImpl
	class QuantityGroupBuilderImpl implements QuantityGroup.QuantityGroupBuilder {
	
		protected List<BigDecimal> amount = new ArrayList<>();
		protected String currency;
	
		public QuantityGroupBuilderImpl() {
		}
	
		@Override
		public List<? extends BigDecimal> getAmount() {
			return amount;
		}
		
		@Override
		public String getCurrency() {
			return currency;
		}
		
	
		@Override
		public QuantityGroup.QuantityGroupBuilder addAmount(BigDecimal amount) {
			if (amount!=null) this.amount.add(amount);
			return this;
		}
		
		@Override
		public QuantityGroup.QuantityGroupBuilder addAmount(BigDecimal amount, int _idx) {
			getIndex(this.amount, _idx, () -> amount);
			return this;
		}
		@Override 
		public QuantityGroup.QuantityGroupBuilder addAmount(List<? extends BigDecimal> amounts) {
			if (amounts != null) {
				for (BigDecimal toAdd : amounts) {
					this.amount.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public QuantityGroup.QuantityGroupBuilder setAmount(List<? extends BigDecimal> amounts) {
			if (amounts == null)  {
				this.amount = new ArrayList<>();
			}
			else {
				this.amount = amounts.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public QuantityGroup.QuantityGroupBuilder setCurrency(String currency) {
			this.currency = currency==null?null:currency;
			return this;
		}
		
		@Override
		public QuantityGroup build() {
			return new QuantityGroup.QuantityGroupImpl(this);
		}
		
		@Override
		public QuantityGroup.QuantityGroupBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityGroup.QuantityGroupBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && !getAmount().isEmpty()) return true;
			if (getCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityGroup.QuantityGroupBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuantityGroup.QuantityGroupBuilder o = (QuantityGroup.QuantityGroupBuilder) other;
			
			
			merger.mergeBasic(getAmount(), o.getAmount(), (Consumer<BigDecimal>) this::addAmount);
			merger.mergeBasic(getCurrency(), o.getCurrency(), this::setCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityGroup _that = getType().cast(o);
		
			if (!ListEquals.listEquals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityGroupBuilder {" +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
