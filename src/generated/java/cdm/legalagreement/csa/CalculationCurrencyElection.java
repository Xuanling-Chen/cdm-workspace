package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.CalculationCurrencyElectionMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the ISDA SIMM Calculation Currency as either the Base Currency or an alternative currency. ISDA 2016 CSA for Initial Margin, Paragraph 13, General Principles (ee)(3). | ISDA 2018 CSA for Initial Margin, Paragraph 13, General Principles (ee)(3).
 * @version ${project.version}
 */
@RosettaClass

public interface CalculationCurrencyElection extends RosettaModelObject {
	CalculationCurrencyElection build();
	CalculationCurrencyElection.CalculationCurrencyElectionBuilder toBuilder();
	
	/**
	 * The currency in which the ISDA SIMM Calculation is denominated, when different from the Base Currency. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * The SIMM Calculation Currency (also known as SIMM Reporting Currency) means the Base Currency when True. It means a different currency when False. In that latter case, the SIMM Calculation Currency is specified as part of the currency attribute.
	 */
	Boolean getIsBaseCurrency();
	/**
	 * The party which the SIMM Calculation Currency qualification applies to.
	 */
	CounterpartyRoleEnum getParty();
	final static CalculationCurrencyElectionMeta metaData = new CalculationCurrencyElectionMeta();
	
	@Override
	default RosettaMetaData<? extends CalculationCurrencyElection> metaData() {
		return metaData;
	} 
			
	static CalculationCurrencyElection.CalculationCurrencyElectionBuilder builder() {
		return new CalculationCurrencyElection.CalculationCurrencyElectionBuilderImpl();
	}
	
	default Class<? extends CalculationCurrencyElection> getType() {
		return CalculationCurrencyElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isBaseCurrency"), Boolean.class, getIsBaseCurrency(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
	}
	
	
	interface CalculationCurrencyElectionBuilder extends CalculationCurrencyElection, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		CalculationCurrencyElection.CalculationCurrencyElectionBuilder setCurrency(FieldWithMetaString currency);
		CalculationCurrencyElection.CalculationCurrencyElectionBuilder setCurrencyValue(String currency);
		CalculationCurrencyElection.CalculationCurrencyElectionBuilder setIsBaseCurrency(Boolean isBaseCurrency);
		CalculationCurrencyElection.CalculationCurrencyElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isBaseCurrency"), Boolean.class, getIsBaseCurrency(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
		}
		
	}
	
	//CalculationCurrencyElection.CalculationCurrencyElectionImpl
	class CalculationCurrencyElectionImpl implements CalculationCurrencyElection {
		private final FieldWithMetaString currency;
		private final Boolean isBaseCurrency;
		private final CounterpartyRoleEnum party;
		
		protected CalculationCurrencyElectionImpl(CalculationCurrencyElection.CalculationCurrencyElectionBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.isBaseCurrency = builder.getIsBaseCurrency();
			this.party = builder.getParty();
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public Boolean getIsBaseCurrency() {
			return isBaseCurrency;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public CalculationCurrencyElection build() {
			return this;
		}
		
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder toBuilder() {
			CalculationCurrencyElection.CalculationCurrencyElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationCurrencyElection.CalculationCurrencyElectionBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getIsBaseCurrency()).ifPresent(builder::setIsBaseCurrency);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationCurrencyElection _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(isBaseCurrency, _that.getIsBaseCurrency())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (isBaseCurrency != null ? isBaseCurrency.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationCurrencyElection {" +
				"currency=" + this.currency + ", " +
				"isBaseCurrency=" + this.isBaseCurrency + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//CalculationCurrencyElection.CalculationCurrencyElectionBuilderImpl
	class CalculationCurrencyElectionBuilderImpl implements CalculationCurrencyElection.CalculationCurrencyElectionBuilder {
	
		protected FieldWithMetaStringBuilder currency;
		protected Boolean isBaseCurrency;
		protected CounterpartyRoleEnum party;
	
		public CalculationCurrencyElectionBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateCurrency() {
			FieldWithMetaStringBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getIsBaseCurrency() {
			return isBaseCurrency;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder setIsBaseCurrency(Boolean isBaseCurrency) {
			this.isBaseCurrency = isBaseCurrency==null?null:isBaseCurrency;
			return this;
		}
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public CalculationCurrencyElection build() {
			return new CalculationCurrencyElection.CalculationCurrencyElectionImpl(this);
		}
		
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null) return true;
			if (getIsBaseCurrency()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationCurrencyElection.CalculationCurrencyElectionBuilder o = (CalculationCurrencyElection.CalculationCurrencyElectionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getIsBaseCurrency(), o.getIsBaseCurrency(), this::setIsBaseCurrency);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationCurrencyElection _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(isBaseCurrency, _that.getIsBaseCurrency())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (isBaseCurrency != null ? isBaseCurrency.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationCurrencyElectionBuilder {" +
				"currency=" + this.currency + ", " +
				"isBaseCurrency=" + this.isBaseCurrency + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
