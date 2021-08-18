package cdm.legalagreement.common;

import cdm.base.staticdata.party.Counterparty;
import cdm.legalagreement.common.meta.AgreementTermsMeta;
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
 * Specification of the content of a legal agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface AgreementTerms extends RosettaModelObject {
	AgreementTerms build();
	AgreementTerms.AgreementTermsBuilder toBuilder();
	
	/**
	 * Specification of the standard set of terms that define a legal agreement.
	 */
	Agreement getAgreement();
	/**
	 */
	List<? extends Counterparty> getCounterparty();
	final static AgreementTermsMeta metaData = new AgreementTermsMeta();
	
	@Override
	default RosettaMetaData<? extends AgreementTerms> metaData() {
		return metaData;
	} 
			
	static AgreementTerms.AgreementTermsBuilder builder() {
		return new AgreementTerms.AgreementTermsBuilderImpl();
	}
	
	default Class<? extends AgreementTerms> getType() {
		return AgreementTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("agreement"), processor, Agreement.class, getAgreement());
		processRosetta(path.newSubPath("counterparty"), processor, Counterparty.class, getCounterparty());
	}
	
	
	interface AgreementTermsBuilder extends AgreementTerms, RosettaModelObjectBuilder {
		Agreement.AgreementBuilder getOrCreateAgreement();
		Agreement.AgreementBuilder getAgreement();
		Counterparty.CounterpartyBuilder getOrCreateCounterparty(int _index);
		List<? extends Counterparty.CounterpartyBuilder> getCounterparty();
		AgreementTerms.AgreementTermsBuilder setAgreement(Agreement agreement);
		AgreementTerms.AgreementTermsBuilder addCounterparty(Counterparty counterparty);
		AgreementTerms.AgreementTermsBuilder addCounterparty(Counterparty counterparty, int _idx);
		AgreementTerms.AgreementTermsBuilder addCounterparty(List<? extends Counterparty> counterparty);
		AgreementTerms.AgreementTermsBuilder setCounterparty(List<? extends Counterparty> counterparty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("agreement"), processor, Agreement.AgreementBuilder.class, getAgreement());
			processRosetta(path.newSubPath("counterparty"), processor, Counterparty.CounterpartyBuilder.class, getCounterparty());
		}
		
	}
	
	//AgreementTerms.AgreementTermsImpl
	class AgreementTermsImpl implements AgreementTerms {
		private final Agreement agreement;
		private final List<? extends Counterparty> counterparty;
		
		protected AgreementTermsImpl(AgreementTerms.AgreementTermsBuilder builder) {
			this.agreement = ofNullable(builder.getAgreement()).map(f->f.build()).orElse(null);
			this.counterparty = ofNullable(builder.getCounterparty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Agreement getAgreement() {
			return agreement;
		}
		
		@Override
		public List<? extends Counterparty> getCounterparty() {
			return counterparty;
		}
		
		@Override
		public AgreementTerms build() {
			return this;
		}
		
		@Override
		public AgreementTerms.AgreementTermsBuilder toBuilder() {
			AgreementTerms.AgreementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgreementTerms.AgreementTermsBuilder builder) {
			ofNullable(getAgreement()).ifPresent(builder::setAgreement);
			ofNullable(getCounterparty()).ifPresent(builder::setCounterparty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementTerms _that = getType().cast(o);
		
			if (!Objects.equals(agreement, _that.getAgreement())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreement != null ? agreement.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgreementTerms {" +
				"agreement=" + this.agreement + ", " +
				"counterparty=" + this.counterparty +
			'}';
		}
	}
	
	//AgreementTerms.AgreementTermsBuilderImpl
	class AgreementTermsBuilderImpl implements AgreementTerms.AgreementTermsBuilder {
	
		protected Agreement.AgreementBuilder agreement;
		protected List<Counterparty.CounterpartyBuilder> counterparty = new ArrayList<>();
	
		public AgreementTermsBuilderImpl() {
		}
	
		@Override
		public Agreement.AgreementBuilder getAgreement() {
			return agreement;
		}
		
		@Override
		public Agreement.AgreementBuilder getOrCreateAgreement() {
			Agreement.AgreementBuilder result;
			if (agreement!=null) {
				result = agreement;
			}
			else {
				result = agreement = Agreement.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends Counterparty.CounterpartyBuilder> getCounterparty() {
			return counterparty;
		}
		
		public Counterparty.CounterpartyBuilder getOrCreateCounterparty(int _index) {
		
			if (counterparty==null) {
				this.counterparty = new ArrayList<>();
			}
			Counterparty.CounterpartyBuilder result;
			return getIndex(counterparty, _index, () -> {
						Counterparty.CounterpartyBuilder newCounterparty = Counterparty.builder();
						return newCounterparty;
					});
		}
		
	
		@Override
		public AgreementTerms.AgreementTermsBuilder setAgreement(Agreement agreement) {
			this.agreement = agreement==null?null:agreement.toBuilder();
			return this;
		}
		@Override
		public AgreementTerms.AgreementTermsBuilder addCounterparty(Counterparty counterparty) {
			if (counterparty!=null) this.counterparty.add(counterparty.toBuilder());
			return this;
		}
		
		@Override
		public AgreementTerms.AgreementTermsBuilder addCounterparty(Counterparty counterparty, int _idx) {
			getIndex(this.counterparty, _idx, () -> counterparty.toBuilder());
			return this;
		}
		@Override 
		public AgreementTerms.AgreementTermsBuilder addCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys != null) {
				for (Counterparty toAdd : counterpartys) {
					this.counterparty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AgreementTerms.AgreementTermsBuilder setCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys == null)  {
				this.counterparty = new ArrayList<>();
			}
			else {
				this.counterparty = counterpartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AgreementTerms build() {
			return new AgreementTerms.AgreementTermsImpl(this);
		}
		
		@Override
		public AgreementTerms.AgreementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementTerms.AgreementTermsBuilder prune() {
			if (agreement!=null && !agreement.prune().hasData()) agreement = null;
			counterparty = counterparty.stream().filter(b->b!=null).<Counterparty.CounterpartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgreement()!=null && getAgreement().hasData()) return true;
			if (getCounterparty()!=null && getCounterparty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementTerms.AgreementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgreementTerms.AgreementTermsBuilder o = (AgreementTerms.AgreementTermsBuilder) other;
			
			merger.mergeRosetta(getAgreement(), o.getAgreement(), this::setAgreement);
			merger.mergeRosetta(getCounterparty(), o.getCounterparty(), this::getOrCreateCounterparty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementTerms _that = getType().cast(o);
		
			if (!Objects.equals(agreement, _that.getAgreement())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreement != null ? agreement.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgreementTermsBuilder {" +
				"agreement=" + this.agreement + ", " +
				"counterparty=" + this.counterparty +
			'}';
		}
	}
}
