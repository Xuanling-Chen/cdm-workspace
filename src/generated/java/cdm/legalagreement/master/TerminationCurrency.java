package cdm.legalagreement.master;

import cdm.legalagreement.master.meta.TerminationCurrencyMeta;
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
 * Specifies how the Termination Currency for the agreement will be determined.
 * @version ${project.version}
 */
@RosettaClass

public interface TerminationCurrency extends RosettaModelObject {
	TerminationCurrency build();
	TerminationCurrency.TerminationCurrencyBuilder toBuilder();
	
	/**
	 * Provides that the Termination Currency will be determined by reference to a contractual mechanism when closing out the Agreement.
	 */
	PartyOptionTerminationCurrency getPartyOptionTerminationCurrency();
	/**
	 * Allows for specific Termination Currency(ies) and a fallback Termination Currency to be selected.
	 */
	TerminationCurrencySelection getStatedTerminationCurrency();
	final static TerminationCurrencyMeta metaData = new TerminationCurrencyMeta();
	
	@Override
	default RosettaMetaData<? extends TerminationCurrency> metaData() {
		return metaData;
	} 
			
	static TerminationCurrency.TerminationCurrencyBuilder builder() {
		return new TerminationCurrency.TerminationCurrencyBuilderImpl();
	}
	
	default Class<? extends TerminationCurrency> getType() {
		return TerminationCurrency.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyOptionTerminationCurrency"), processor, PartyOptionTerminationCurrency.class, getPartyOptionTerminationCurrency());
		processRosetta(path.newSubPath("statedTerminationCurrency"), processor, TerminationCurrencySelection.class, getStatedTerminationCurrency());
	}
	
	
	interface TerminationCurrencyBuilder extends TerminationCurrency, RosettaModelObjectBuilder {
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder getOrCreatePartyOptionTerminationCurrency();
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder getPartyOptionTerminationCurrency();
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder getOrCreateStatedTerminationCurrency();
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder getStatedTerminationCurrency();
		TerminationCurrency.TerminationCurrencyBuilder setPartyOptionTerminationCurrency(PartyOptionTerminationCurrency partyOptionTerminationCurrency);
		TerminationCurrency.TerminationCurrencyBuilder setStatedTerminationCurrency(TerminationCurrencySelection statedTerminationCurrency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyOptionTerminationCurrency"), processor, PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder.class, getPartyOptionTerminationCurrency());
			processRosetta(path.newSubPath("statedTerminationCurrency"), processor, TerminationCurrencySelection.TerminationCurrencySelectionBuilder.class, getStatedTerminationCurrency());
		}
		
	}
	
	//TerminationCurrency.TerminationCurrencyImpl
	class TerminationCurrencyImpl implements TerminationCurrency {
		private final PartyOptionTerminationCurrency partyOptionTerminationCurrency;
		private final TerminationCurrencySelection statedTerminationCurrency;
		
		protected TerminationCurrencyImpl(TerminationCurrency.TerminationCurrencyBuilder builder) {
			this.partyOptionTerminationCurrency = ofNullable(builder.getPartyOptionTerminationCurrency()).map(f->f.build()).orElse(null);
			this.statedTerminationCurrency = ofNullable(builder.getStatedTerminationCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public PartyOptionTerminationCurrency getPartyOptionTerminationCurrency() {
			return partyOptionTerminationCurrency;
		}
		
		@Override
		public TerminationCurrencySelection getStatedTerminationCurrency() {
			return statedTerminationCurrency;
		}
		
		@Override
		public TerminationCurrency build() {
			return this;
		}
		
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder toBuilder() {
			TerminationCurrency.TerminationCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminationCurrency.TerminationCurrencyBuilder builder) {
			ofNullable(getPartyOptionTerminationCurrency()).ifPresent(builder::setPartyOptionTerminationCurrency);
			ofNullable(getStatedTerminationCurrency()).ifPresent(builder::setStatedTerminationCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrency _that = getType().cast(o);
		
			if (!Objects.equals(partyOptionTerminationCurrency, _that.getPartyOptionTerminationCurrency())) return false;
			if (!Objects.equals(statedTerminationCurrency, _that.getStatedTerminationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyOptionTerminationCurrency != null ? partyOptionTerminationCurrency.hashCode() : 0);
			_result = 31 * _result + (statedTerminationCurrency != null ? statedTerminationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrency {" +
				"partyOptionTerminationCurrency=" + this.partyOptionTerminationCurrency + ", " +
				"statedTerminationCurrency=" + this.statedTerminationCurrency +
			'}';
		}
	}
	
	//TerminationCurrency.TerminationCurrencyBuilderImpl
	class TerminationCurrencyBuilderImpl implements TerminationCurrency.TerminationCurrencyBuilder {
	
		protected PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder partyOptionTerminationCurrency;
		protected TerminationCurrencySelection.TerminationCurrencySelectionBuilder statedTerminationCurrency;
	
		public TerminationCurrencyBuilderImpl() {
		}
	
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder getPartyOptionTerminationCurrency() {
			return partyOptionTerminationCurrency;
		}
		
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder getOrCreatePartyOptionTerminationCurrency() {
			PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder result;
			if (partyOptionTerminationCurrency!=null) {
				result = partyOptionTerminationCurrency;
			}
			else {
				result = partyOptionTerminationCurrency = PartyOptionTerminationCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder getStatedTerminationCurrency() {
			return statedTerminationCurrency;
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder getOrCreateStatedTerminationCurrency() {
			TerminationCurrencySelection.TerminationCurrencySelectionBuilder result;
			if (statedTerminationCurrency!=null) {
				result = statedTerminationCurrency;
			}
			else {
				result = statedTerminationCurrency = TerminationCurrencySelection.builder();
			}
			
			return result;
		}
		
	
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder setPartyOptionTerminationCurrency(PartyOptionTerminationCurrency partyOptionTerminationCurrency) {
			this.partyOptionTerminationCurrency = partyOptionTerminationCurrency==null?null:partyOptionTerminationCurrency.toBuilder();
			return this;
		}
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder setStatedTerminationCurrency(TerminationCurrencySelection statedTerminationCurrency) {
			this.statedTerminationCurrency = statedTerminationCurrency==null?null:statedTerminationCurrency.toBuilder();
			return this;
		}
		
		@Override
		public TerminationCurrency build() {
			return new TerminationCurrency.TerminationCurrencyImpl(this);
		}
		
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder prune() {
			if (partyOptionTerminationCurrency!=null && !partyOptionTerminationCurrency.prune().hasData()) partyOptionTerminationCurrency = null;
			if (statedTerminationCurrency!=null && !statedTerminationCurrency.prune().hasData()) statedTerminationCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyOptionTerminationCurrency()!=null && getPartyOptionTerminationCurrency().hasData()) return true;
			if (getStatedTerminationCurrency()!=null && getStatedTerminationCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminationCurrency.TerminationCurrencyBuilder o = (TerminationCurrency.TerminationCurrencyBuilder) other;
			
			merger.mergeRosetta(getPartyOptionTerminationCurrency(), o.getPartyOptionTerminationCurrency(), this::setPartyOptionTerminationCurrency);
			merger.mergeRosetta(getStatedTerminationCurrency(), o.getStatedTerminationCurrency(), this::setStatedTerminationCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrency _that = getType().cast(o);
		
			if (!Objects.equals(partyOptionTerminationCurrency, _that.getPartyOptionTerminationCurrency())) return false;
			if (!Objects.equals(statedTerminationCurrency, _that.getStatedTerminationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyOptionTerminationCurrency != null ? partyOptionTerminationCurrency.hashCode() : 0);
			_result = 31 * _result + (statedTerminationCurrency != null ? statedTerminationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyBuilder {" +
				"partyOptionTerminationCurrency=" + this.partyOptionTerminationCurrency + ", " +
				"statedTerminationCurrency=" + this.statedTerminationCurrency +
			'}';
		}
	}
}
