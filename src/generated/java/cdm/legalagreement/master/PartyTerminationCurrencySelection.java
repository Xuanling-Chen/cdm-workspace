package cdm.legalagreement.master;

import cdm.base.staticdata.party.Party;
import cdm.legalagreement.master.meta.PartyTerminationCurrencySelectionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the termination currency to be used by a party when it is the Non-Defaulting Party or the Party which is not the Affected Party.
 * @version ${project.version}
 */
@RosettaClass

public interface PartyTerminationCurrencySelection extends RosettaModelObject {
	PartyTerminationCurrencySelection build();
	PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder toBuilder();
	
	/**
	 * The elective party.
	 */
	Party getParty();
	/**
	 * Specifies termination Currency
	 */
	String getStatedPartyCurrency();
	final static PartyTerminationCurrencySelectionMeta metaData = new PartyTerminationCurrencySelectionMeta();
	
	@Override
	default RosettaMetaData<? extends PartyTerminationCurrencySelection> metaData() {
		return metaData;
	} 
			
	static PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder builder() {
		return new PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilderImpl();
	}
	
	default Class<? extends PartyTerminationCurrencySelection> getType() {
		return PartyTerminationCurrencySelection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("statedPartyCurrency"), String.class, getStatedPartyCurrency(), this);
		
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	
	
	interface PartyTerminationCurrencySelectionBuilder extends PartyTerminationCurrencySelection, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateParty();
		Party.PartyBuilder getParty();
		PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder setParty(Party party);
		PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder setStatedPartyCurrency(String statedPartyCurrency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("statedPartyCurrency"), String.class, getStatedPartyCurrency(), this);
			
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		
	}
	
	//PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionImpl
	class PartyTerminationCurrencySelectionImpl implements PartyTerminationCurrencySelection {
		private final Party party;
		private final String statedPartyCurrency;
		
		protected PartyTerminationCurrencySelectionImpl(PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder builder) {
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.statedPartyCurrency = builder.getStatedPartyCurrency();
		}
		
		@Override
		public Party getParty() {
			return party;
		}
		
		@Override
		public String getStatedPartyCurrency() {
			return statedPartyCurrency;
		}
		
		@Override
		public PartyTerminationCurrencySelection build() {
			return this;
		}
		
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder toBuilder() {
			PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getStatedPartyCurrency()).ifPresent(builder::setStatedPartyCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTerminationCurrencySelection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(statedPartyCurrency, _that.getStatedPartyCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (statedPartyCurrency != null ? statedPartyCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTerminationCurrencySelection {" +
				"party=" + this.party + ", " +
				"statedPartyCurrency=" + this.statedPartyCurrency +
			'}';
		}
	}
	
	//PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilderImpl
	class PartyTerminationCurrencySelectionBuilderImpl implements PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder {
	
		protected Party.PartyBuilder party;
		protected String statedPartyCurrency;
	
		public PartyTerminationCurrencySelectionBuilderImpl() {
		}
	
		@Override
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
		@Override
		public String getStatedPartyCurrency() {
			return statedPartyCurrency;
		}
		
	
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder setParty(Party party) {
			this.party = party==null?null:party.toBuilder();
			return this;
		}
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder setStatedPartyCurrency(String statedPartyCurrency) {
			this.statedPartyCurrency = statedPartyCurrency==null?null:statedPartyCurrency;
			return this;
		}
		
		@Override
		public PartyTerminationCurrencySelection build() {
			return new PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionImpl(this);
		}
		
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder prune() {
			if (party!=null && !party.prune().hasData()) party = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && getParty().hasData()) return true;
			if (getStatedPartyCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder o = (PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			
			merger.mergeBasic(getStatedPartyCurrency(), o.getStatedPartyCurrency(), this::setStatedPartyCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTerminationCurrencySelection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(statedPartyCurrency, _that.getStatedPartyCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (statedPartyCurrency != null ? statedPartyCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTerminationCurrencySelectionBuilder {" +
				"party=" + this.party + ", " +
				"statedPartyCurrency=" + this.statedPartyCurrency +
			'}';
		}
	}
}
