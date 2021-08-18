package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.BaseAndEligibleCurrencyMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The base and eligible currency(ies) for the document as specified by the parties to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface BaseAndEligibleCurrency extends RosettaModelObject {
	BaseAndEligibleCurrency build();
	BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder toBuilder();
	
	/**
	 * The base currency for the document as elected by the parties to the agreement. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getBaseCurrency();
	/**
	 * The list of eligible currencies, in addition to the base currency, for the document as elected by the parties to the agreement.
	 */
	List<? extends FieldWithMetaString> getEligibleCurrency();
	final static BaseAndEligibleCurrencyMeta metaData = new BaseAndEligibleCurrencyMeta();
	
	@Override
	default RosettaMetaData<? extends BaseAndEligibleCurrency> metaData() {
		return metaData;
	} 
			
	static BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder builder() {
		return new BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilderImpl();
	}
	
	default Class<? extends BaseAndEligibleCurrency> getType() {
		return BaseAndEligibleCurrency.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("baseCurrency"), processor, FieldWithMetaString.class, getBaseCurrency());
		processRosetta(path.newSubPath("eligibleCurrency"), processor, FieldWithMetaString.class, getEligibleCurrency());
	}
	
	
	interface BaseAndEligibleCurrencyBuilder extends BaseAndEligibleCurrency, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateBaseCurrency();
		FieldWithMetaStringBuilder getBaseCurrency();
		FieldWithMetaStringBuilder getOrCreateEligibleCurrency(int _index);
		List<? extends FieldWithMetaStringBuilder> getEligibleCurrency();
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrency(FieldWithMetaString baseCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrencyValue(String baseCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(FieldWithMetaString eligibleCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(FieldWithMetaString eligibleCurrency, int _idx);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrencyValue(String eligibleCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrencyValue(String eligibleCurrency, int _idx);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(List<? extends FieldWithMetaString> eligibleCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrency(List<? extends FieldWithMetaString> eligibleCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrencyValue(List<? extends String> eligibleCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrencyValue(List<? extends String> eligibleCurrency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("baseCurrency"), processor, FieldWithMetaStringBuilder.class, getBaseCurrency());
			processRosetta(path.newSubPath("eligibleCurrency"), processor, FieldWithMetaStringBuilder.class, getEligibleCurrency());
		}
		
	}
	
	//BaseAndEligibleCurrency.BaseAndEligibleCurrencyImpl
	class BaseAndEligibleCurrencyImpl implements BaseAndEligibleCurrency {
		private final FieldWithMetaString baseCurrency;
		private final List<? extends FieldWithMetaString> eligibleCurrency;
		
		protected BaseAndEligibleCurrencyImpl(BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder builder) {
			this.baseCurrency = ofNullable(builder.getBaseCurrency()).map(f->f.build()).orElse(null);
			this.eligibleCurrency = ofNullable(builder.getEligibleCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public FieldWithMetaString getBaseCurrency() {
			return baseCurrency;
		}
		
		@Override
		public List<? extends FieldWithMetaString> getEligibleCurrency() {
			return eligibleCurrency;
		}
		
		@Override
		public BaseAndEligibleCurrency build() {
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder toBuilder() {
			BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder builder) {
			ofNullable(getBaseCurrency()).ifPresent(builder::setBaseCurrency);
			ofNullable(getEligibleCurrency()).ifPresent(builder::setEligibleCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BaseAndEligibleCurrency _that = getType().cast(o);
		
			if (!Objects.equals(baseCurrency, _that.getBaseCurrency())) return false;
			if (!ListEquals.listEquals(eligibleCurrency, _that.getEligibleCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseCurrency != null ? baseCurrency.hashCode() : 0);
			_result = 31 * _result + (eligibleCurrency != null ? eligibleCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BaseAndEligibleCurrency {" +
				"baseCurrency=" + this.baseCurrency + ", " +
				"eligibleCurrency=" + this.eligibleCurrency +
			'}';
		}
	}
	
	//BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilderImpl
	class BaseAndEligibleCurrencyBuilderImpl implements BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder {
	
		protected FieldWithMetaStringBuilder baseCurrency;
		protected List<FieldWithMetaStringBuilder> eligibleCurrency = new ArrayList<>();
	
		public BaseAndEligibleCurrencyBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getBaseCurrency() {
			return baseCurrency;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateBaseCurrency() {
			FieldWithMetaStringBuilder result;
			if (baseCurrency!=null) {
				result = baseCurrency;
			}
			else {
				result = baseCurrency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends FieldWithMetaStringBuilder> getEligibleCurrency() {
			return eligibleCurrency;
		}
		
		public FieldWithMetaStringBuilder getOrCreateEligibleCurrency(int _index) {
		
			if (eligibleCurrency==null) {
				this.eligibleCurrency = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(eligibleCurrency, _index, () -> {
						FieldWithMetaStringBuilder newEligibleCurrency = FieldWithMetaString.builder();
						return newEligibleCurrency;
					});
		}
		
	
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrency(FieldWithMetaString baseCurrency) {
			this.baseCurrency = baseCurrency==null?null:baseCurrency.toBuilder();
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrencyValue(String baseCurrency) {
			this.getOrCreateBaseCurrency().setValue(baseCurrency);
			return this;
		}
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(FieldWithMetaString eligibleCurrency) {
			if (eligibleCurrency!=null) this.eligibleCurrency.add(eligibleCurrency.toBuilder());
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(FieldWithMetaString eligibleCurrency, int _idx) {
			getIndex(this.eligibleCurrency, _idx, () -> eligibleCurrency.toBuilder());
			return this;
		}
		
			@Override
			public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrencyValue(String eligibleCurrency) {
				this.getOrCreateEligibleCurrency(-1).setValue(eligibleCurrency);
				return this;
			}
			
			@Override
			public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrencyValue(String eligibleCurrency, int _idx) {
				this.getOrCreateEligibleCurrency(_idx).setValue(eligibleCurrency);
				return this;
			}
		@Override 
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(List<? extends FieldWithMetaString> eligibleCurrencys) {
			if (eligibleCurrencys != null) {
				for (FieldWithMetaString toAdd : eligibleCurrencys) {
					this.eligibleCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrency(List<? extends FieldWithMetaString> eligibleCurrencys) {
			if (eligibleCurrencys == null)  {
				this.eligibleCurrency = new ArrayList<>();
			}
			else {
				this.eligibleCurrency = eligibleCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrencyValue(List<? extends String> eligibleCurrencys) {
			if (eligibleCurrencys != null) {
				for (String toAdd : eligibleCurrencys) {
					this.addEligibleCurrencyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrencyValue(List<? extends String> eligibleCurrencys) {
			this.eligibleCurrency.clear();
			if (eligibleCurrencys!=null) {
				eligibleCurrencys.forEach(this::addEligibleCurrencyValue);
			}
			return this;
		}
		
		
		@Override
		public BaseAndEligibleCurrency build() {
			return new BaseAndEligibleCurrency.BaseAndEligibleCurrencyImpl(this);
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder prune() {
			if (baseCurrency!=null && !baseCurrency.prune().hasData()) baseCurrency = null;
			eligibleCurrency = eligibleCurrency.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBaseCurrency()!=null) return true;
			if (getEligibleCurrency()!=null && !getEligibleCurrency().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder o = (BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder) other;
			
			merger.mergeRosetta(getBaseCurrency(), o.getBaseCurrency(), this::setBaseCurrency);
			merger.mergeRosetta(getEligibleCurrency(), o.getEligibleCurrency(), this::getOrCreateEligibleCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BaseAndEligibleCurrency _that = getType().cast(o);
		
			if (!Objects.equals(baseCurrency, _that.getBaseCurrency())) return false;
			if (!ListEquals.listEquals(eligibleCurrency, _that.getEligibleCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseCurrency != null ? baseCurrency.hashCode() : 0);
			_result = 31 * _result + (eligibleCurrency != null ? eligibleCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BaseAndEligibleCurrencyBuilder {" +
				"baseCurrency=" + this.baseCurrency + ", " +
				"eligibleCurrency=" + this.eligibleCurrency +
			'}';
		}
	}
}
