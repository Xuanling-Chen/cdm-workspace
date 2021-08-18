package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.CalculationAgentTermsMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify Calculation Agent for purposes of Initial or Variation Margin agreements
 * @version ${project.version}
 */
@RosettaClass

public interface CalculationAgentTerms extends RosettaModelObject {
	CalculationAgentTerms build();
	CalculationAgentTerms.CalculationAgentTermsBuilder toBuilder();
	
	/**
	 * The Calculation Agent (IM) terms when specified
	 */
	String getBespokeCalculationAgentTerms();
	/**
	 * The party which is specified as Calculation Agent for Initial Margin.
	 */
	List<? extends CounterpartyRoleEnum> getParty();
	final static CalculationAgentTermsMeta metaData = new CalculationAgentTermsMeta();
	
	@Override
	default RosettaMetaData<? extends CalculationAgentTerms> metaData() {
		return metaData;
	} 
			
	static CalculationAgentTerms.CalculationAgentTermsBuilder builder() {
		return new CalculationAgentTerms.CalculationAgentTermsBuilderImpl();
	}
	
	default Class<? extends CalculationAgentTerms> getType() {
		return CalculationAgentTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bespokeCalculationAgentTerms"), String.class, getBespokeCalculationAgentTerms(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
	}
	
	
	interface CalculationAgentTermsBuilder extends CalculationAgentTerms, RosettaModelObjectBuilder {
		CalculationAgentTerms.CalculationAgentTermsBuilder setBespokeCalculationAgentTerms(String bespokeCalculationAgentTerms);
		CalculationAgentTerms.CalculationAgentTermsBuilder addParty(CounterpartyRoleEnum party);
		CalculationAgentTerms.CalculationAgentTermsBuilder addParty(CounterpartyRoleEnum party, int _idx);
		CalculationAgentTerms.CalculationAgentTermsBuilder addParty(List<? extends CounterpartyRoleEnum> party);
		CalculationAgentTerms.CalculationAgentTermsBuilder setParty(List<? extends CounterpartyRoleEnum> party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bespokeCalculationAgentTerms"), String.class, getBespokeCalculationAgentTerms(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
		}
		
	}
	
	//CalculationAgentTerms.CalculationAgentTermsImpl
	class CalculationAgentTermsImpl implements CalculationAgentTerms {
		private final String bespokeCalculationAgentTerms;
		private final List<? extends CounterpartyRoleEnum> party;
		
		protected CalculationAgentTermsImpl(CalculationAgentTerms.CalculationAgentTermsBuilder builder) {
			this.bespokeCalculationAgentTerms = builder.getBespokeCalculationAgentTerms();
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public String getBespokeCalculationAgentTerms() {
			return bespokeCalculationAgentTerms;
		}
		
		@Override
		public List<? extends CounterpartyRoleEnum> getParty() {
			return party;
		}
		
		@Override
		public CalculationAgentTerms build() {
			return this;
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder toBuilder() {
			CalculationAgentTerms.CalculationAgentTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationAgentTerms.CalculationAgentTermsBuilder builder) {
			ofNullable(getBespokeCalculationAgentTerms()).ifPresent(builder::setBespokeCalculationAgentTerms);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAgentTerms _that = getType().cast(o);
		
			if (!Objects.equals(bespokeCalculationAgentTerms, _that.getBespokeCalculationAgentTerms())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeCalculationAgentTerms != null ? bespokeCalculationAgentTerms.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAgentTerms {" +
				"bespokeCalculationAgentTerms=" + this.bespokeCalculationAgentTerms + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//CalculationAgentTerms.CalculationAgentTermsBuilderImpl
	class CalculationAgentTermsBuilderImpl implements CalculationAgentTerms.CalculationAgentTermsBuilder {
	
		protected String bespokeCalculationAgentTerms;
		protected List<CounterpartyRoleEnum> party = new ArrayList<>();
	
		public CalculationAgentTermsBuilderImpl() {
		}
	
		@Override
		public String getBespokeCalculationAgentTerms() {
			return bespokeCalculationAgentTerms;
		}
		
		@Override
		public List<? extends CounterpartyRoleEnum> getParty() {
			return party;
		}
		
	
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder setBespokeCalculationAgentTerms(String bespokeCalculationAgentTerms) {
			this.bespokeCalculationAgentTerms = bespokeCalculationAgentTerms==null?null:bespokeCalculationAgentTerms;
			return this;
		}
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder addParty(CounterpartyRoleEnum party) {
			if (party!=null) this.party.add(party);
			return this;
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder addParty(CounterpartyRoleEnum party, int _idx) {
			getIndex(this.party, _idx, () -> party);
			return this;
		}
		@Override 
		public CalculationAgentTerms.CalculationAgentTermsBuilder addParty(List<? extends CounterpartyRoleEnum> partys) {
			if (partys != null) {
				for (CounterpartyRoleEnum toAdd : partys) {
					this.party.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public CalculationAgentTerms.CalculationAgentTermsBuilder setParty(List<? extends CounterpartyRoleEnum> partys) {
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
		public CalculationAgentTerms build() {
			return new CalculationAgentTerms.CalculationAgentTermsImpl(this);
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBespokeCalculationAgentTerms()!=null) return true;
			if (getParty()!=null && !getParty().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationAgentTerms.CalculationAgentTermsBuilder o = (CalculationAgentTerms.CalculationAgentTermsBuilder) other;
			
			
			merger.mergeBasic(getBespokeCalculationAgentTerms(), o.getBespokeCalculationAgentTerms(), this::setBespokeCalculationAgentTerms);
			merger.mergeBasic(getParty(), o.getParty(), (Consumer<CounterpartyRoleEnum>) this::addParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAgentTerms _that = getType().cast(o);
		
			if (!Objects.equals(bespokeCalculationAgentTerms, _that.getBespokeCalculationAgentTerms())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeCalculationAgentTerms != null ? bespokeCalculationAgentTerms.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAgentTermsBuilder {" +
				"bespokeCalculationAgentTerms=" + this.bespokeCalculationAgentTerms + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
