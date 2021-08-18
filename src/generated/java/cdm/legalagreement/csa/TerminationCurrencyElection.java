package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.TerminationCurrencyElectionMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Amendment to Termination Currency election by the parties to the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (t) (A) &amp; (B).
 * @version ${project.version}
 */
@RosettaClass

public interface TerminationCurrencyElection extends RosettaModelObject {
	TerminationCurrencyElection build();
	TerminationCurrencyElection.TerminationCurrencyElectionBuilder toBuilder();
	
	/**
	 * The Termination Currency associated with the party that referenced as part of this class. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * The qualification of whether the Termination Currency is specified in this document (True) or in an Eligible Support Credit Support (IM) Schedule (False)
	 */
	Boolean getIsSpecified();
	/**
	 * The elective party.
	 */
	List<? extends CounterpartyRoleEnum> getParty();
	final static TerminationCurrencyElectionMeta metaData = new TerminationCurrencyElectionMeta();
	
	@Override
	default RosettaMetaData<? extends TerminationCurrencyElection> metaData() {
		return metaData;
	} 
			
	static TerminationCurrencyElection.TerminationCurrencyElectionBuilder builder() {
		return new TerminationCurrencyElection.TerminationCurrencyElectionBuilderImpl();
	}
	
	default Class<? extends TerminationCurrencyElection> getType() {
		return TerminationCurrencyElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
	}
	
	
	interface TerminationCurrencyElectionBuilder extends TerminationCurrencyElection, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder setCurrency(FieldWithMetaString currency);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder setCurrencyValue(String currency);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder setIsSpecified(Boolean isSpecified);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(CounterpartyRoleEnum party);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(CounterpartyRoleEnum party, int _idx);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(List<? extends CounterpartyRoleEnum> party);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder setParty(List<? extends CounterpartyRoleEnum> party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
		}
		
	}
	
	//TerminationCurrencyElection.TerminationCurrencyElectionImpl
	class TerminationCurrencyElectionImpl implements TerminationCurrencyElection {
		private final FieldWithMetaString currency;
		private final Boolean isSpecified;
		private final List<? extends CounterpartyRoleEnum> party;
		
		protected TerminationCurrencyElectionImpl(TerminationCurrencyElection.TerminationCurrencyElectionBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.isSpecified = builder.getIsSpecified();
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		public List<? extends CounterpartyRoleEnum> getParty() {
			return party;
		}
		
		@Override
		public TerminationCurrencyElection build() {
			return this;
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder toBuilder() {
			TerminationCurrencyElection.TerminationCurrencyElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminationCurrencyElection.TerminationCurrencyElectionBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getIsSpecified()).ifPresent(builder::setIsSpecified);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencyElection _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyElection {" +
				"currency=" + this.currency + ", " +
				"isSpecified=" + this.isSpecified + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//TerminationCurrencyElection.TerminationCurrencyElectionBuilderImpl
	class TerminationCurrencyElectionBuilderImpl implements TerminationCurrencyElection.TerminationCurrencyElectionBuilder {
	
		protected FieldWithMetaStringBuilder currency;
		protected Boolean isSpecified;
		protected List<CounterpartyRoleEnum> party = new ArrayList<>();
	
		public TerminationCurrencyElectionBuilderImpl() {
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
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		public List<? extends CounterpartyRoleEnum> getParty() {
			return party;
		}
		
	
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder setIsSpecified(Boolean isSpecified) {
			this.isSpecified = isSpecified==null?null:isSpecified;
			return this;
		}
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(CounterpartyRoleEnum party) {
			if (party!=null) this.party.add(party);
			return this;
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(CounterpartyRoleEnum party, int _idx) {
			getIndex(this.party, _idx, () -> party);
			return this;
		}
		@Override 
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(List<? extends CounterpartyRoleEnum> partys) {
			if (partys != null) {
				for (CounterpartyRoleEnum toAdd : partys) {
					this.party.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder setParty(List<? extends CounterpartyRoleEnum> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public TerminationCurrencyElection build() {
			return new TerminationCurrencyElection.TerminationCurrencyElectionImpl(this);
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null) return true;
			if (getIsSpecified()!=null) return true;
			if (getParty()!=null && !getParty().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminationCurrencyElection.TerminationCurrencyElectionBuilder o = (TerminationCurrencyElection.TerminationCurrencyElectionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getIsSpecified(), o.getIsSpecified(), this::setIsSpecified);
			merger.mergeBasic(getParty(), o.getParty(), (Consumer<CounterpartyRoleEnum>) this::addParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencyElection _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyElectionBuilder {" +
				"currency=" + this.currency + ", " +
				"isSpecified=" + this.isSpecified + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
