package cdm.legalagreement.master;

import cdm.legalagreement.master.meta.TerminationCurrencySelectionMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies Termination Currency where a currency is stated at the time the agreement is entered into.
 * @version ${project.version}
 */
@RosettaClass

public interface TerminationCurrencySelection extends RosettaModelObject {
	TerminationCurrencySelection build();
	TerminationCurrencySelection.TerminationCurrencySelectionBuilder toBuilder();
	
	/**
	 * Specifies fallback Termination Currency where both parties are Affected Parties.
	 */
	String getBothAffected();
	/**
	 * Specifies a single fallback Termination Currency should the stated currency not be freely available.
	 */
	String getFallbackCurrency();
	/**
	 * Specifies different termination currencies to apply depending on which party or parties are the Defaulting Party Affected Party(ies).
	 */
	List<? extends PartyTerminationCurrencySelection> getPartyElection();
	/**
	 * Specifies a single Termination Currency for the agreement.
	 */
	String getStatedCurrency();
	final static TerminationCurrencySelectionMeta metaData = new TerminationCurrencySelectionMeta();
	
	@Override
	default RosettaMetaData<? extends TerminationCurrencySelection> metaData() {
		return metaData;
	} 
			
	static TerminationCurrencySelection.TerminationCurrencySelectionBuilder builder() {
		return new TerminationCurrencySelection.TerminationCurrencySelectionBuilderImpl();
	}
	
	default Class<? extends TerminationCurrencySelection> getType() {
		return TerminationCurrencySelection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bothAffected"), String.class, getBothAffected(), this);
		processor.processBasic(path.newSubPath("fallbackCurrency"), String.class, getFallbackCurrency(), this);
		processor.processBasic(path.newSubPath("statedCurrency"), String.class, getStatedCurrency(), this);
		
		processRosetta(path.newSubPath("partyElection"), processor, PartyTerminationCurrencySelection.class, getPartyElection());
	}
	
	
	interface TerminationCurrencySelectionBuilder extends TerminationCurrencySelection, RosettaModelObjectBuilder {
		PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder getOrCreatePartyElection(int _index);
		List<? extends PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder> getPartyElection();
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder setBothAffected(String bothAffected);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder setFallbackCurrency(String fallbackCurrency);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(PartyTerminationCurrencySelection partyElection);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(PartyTerminationCurrencySelection partyElection, int _idx);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(List<? extends PartyTerminationCurrencySelection> partyElection);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder setPartyElection(List<? extends PartyTerminationCurrencySelection> partyElection);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder setStatedCurrency(String statedCurrency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bothAffected"), String.class, getBothAffected(), this);
			processor.processBasic(path.newSubPath("fallbackCurrency"), String.class, getFallbackCurrency(), this);
			processor.processBasic(path.newSubPath("statedCurrency"), String.class, getStatedCurrency(), this);
			
			processRosetta(path.newSubPath("partyElection"), processor, PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder.class, getPartyElection());
		}
		
	}
	
	//TerminationCurrencySelection.TerminationCurrencySelectionImpl
	class TerminationCurrencySelectionImpl implements TerminationCurrencySelection {
		private final String bothAffected;
		private final String fallbackCurrency;
		private final List<? extends PartyTerminationCurrencySelection> partyElection;
		private final String statedCurrency;
		
		protected TerminationCurrencySelectionImpl(TerminationCurrencySelection.TerminationCurrencySelectionBuilder builder) {
			this.bothAffected = builder.getBothAffected();
			this.fallbackCurrency = builder.getFallbackCurrency();
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.statedCurrency = builder.getStatedCurrency();
		}
		
		@Override
		public String getBothAffected() {
			return bothAffected;
		}
		
		@Override
		public String getFallbackCurrency() {
			return fallbackCurrency;
		}
		
		@Override
		public List<? extends PartyTerminationCurrencySelection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public String getStatedCurrency() {
			return statedCurrency;
		}
		
		@Override
		public TerminationCurrencySelection build() {
			return this;
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder toBuilder() {
			TerminationCurrencySelection.TerminationCurrencySelectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminationCurrencySelection.TerminationCurrencySelectionBuilder builder) {
			ofNullable(getBothAffected()).ifPresent(builder::setBothAffected);
			ofNullable(getFallbackCurrency()).ifPresent(builder::setFallbackCurrency);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
			ofNullable(getStatedCurrency()).ifPresent(builder::setStatedCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencySelection _that = getType().cast(o);
		
			if (!Objects.equals(bothAffected, _that.getBothAffected())) return false;
			if (!Objects.equals(fallbackCurrency, _that.getFallbackCurrency())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(statedCurrency, _that.getStatedCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bothAffected != null ? bothAffected.hashCode() : 0);
			_result = 31 * _result + (fallbackCurrency != null ? fallbackCurrency.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (statedCurrency != null ? statedCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencySelection {" +
				"bothAffected=" + this.bothAffected + ", " +
				"fallbackCurrency=" + this.fallbackCurrency + ", " +
				"partyElection=" + this.partyElection + ", " +
				"statedCurrency=" + this.statedCurrency +
			'}';
		}
	}
	
	//TerminationCurrencySelection.TerminationCurrencySelectionBuilderImpl
	class TerminationCurrencySelectionBuilderImpl implements TerminationCurrencySelection.TerminationCurrencySelectionBuilder {
	
		protected String bothAffected;
		protected String fallbackCurrency;
		protected List<PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder> partyElection = new ArrayList<>();
		protected String statedCurrency;
	
		public TerminationCurrencySelectionBuilderImpl() {
		}
	
		@Override
		public String getBothAffected() {
			return bothAffected;
		}
		
		@Override
		public String getFallbackCurrency() {
			return fallbackCurrency;
		}
		
		@Override
		public List<? extends PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder newPartyElection = PartyTerminationCurrencySelection.builder();
						return newPartyElection;
					});
		}
		
		@Override
		public String getStatedCurrency() {
			return statedCurrency;
		}
		
	
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder setBothAffected(String bothAffected) {
			this.bothAffected = bothAffected==null?null:bothAffected;
			return this;
		}
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder setFallbackCurrency(String fallbackCurrency) {
			this.fallbackCurrency = fallbackCurrency==null?null:fallbackCurrency;
			return this;
		}
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(PartyTerminationCurrencySelection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(PartyTerminationCurrencySelection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(List<? extends PartyTerminationCurrencySelection> partyElections) {
			if (partyElections != null) {
				for (PartyTerminationCurrencySelection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder setPartyElection(List<? extends PartyTerminationCurrencySelection> partyElections) {
			if (partyElections == null)  {
				this.partyElection = new ArrayList<>();
			}
			else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder setStatedCurrency(String statedCurrency) {
			this.statedCurrency = statedCurrency==null?null:statedCurrency;
			return this;
		}
		
		@Override
		public TerminationCurrencySelection build() {
			return new TerminationCurrencySelection.TerminationCurrencySelectionImpl(this);
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBothAffected()!=null) return true;
			if (getFallbackCurrency()!=null) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getStatedCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminationCurrencySelection.TerminationCurrencySelectionBuilder o = (TerminationCurrencySelection.TerminationCurrencySelectionBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getBothAffected(), o.getBothAffected(), this::setBothAffected);
			merger.mergeBasic(getFallbackCurrency(), o.getFallbackCurrency(), this::setFallbackCurrency);
			merger.mergeBasic(getStatedCurrency(), o.getStatedCurrency(), this::setStatedCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencySelection _that = getType().cast(o);
		
			if (!Objects.equals(bothAffected, _that.getBothAffected())) return false;
			if (!Objects.equals(fallbackCurrency, _that.getFallbackCurrency())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(statedCurrency, _that.getStatedCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bothAffected != null ? bothAffected.hashCode() : 0);
			_result = 31 * _result + (fallbackCurrency != null ? fallbackCurrency.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (statedCurrency != null ? statedCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencySelectionBuilder {" +
				"bothAffected=" + this.bothAffected + ", " +
				"fallbackCurrency=" + this.fallbackCurrency + ", " +
				"partyElection=" + this.partyElection + ", " +
				"statedCurrency=" + this.statedCurrency +
			'}';
		}
	}
}
