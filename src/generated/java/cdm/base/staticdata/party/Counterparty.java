package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.CounterpartyMeta;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
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
 * Defines a counterparty enumerated value, e.g. Party1 or Party2, with an associated party reference. The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the CounterpartyEnum (e.g. values Party1 or Party2). The CounterpartyEnum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this Counterparty type, which is positioned outside of the product definition, allows the CounterpartyEnum to be associated with an actual party reference.
 * @version ${project.version}
 */
@RosettaClass

public interface Counterparty extends RosettaModelObject {
	Counterparty build();
	Counterparty.CounterpartyBuilder toBuilder();
	
	/**
	 * Specifies the party that is associated to the counterparty.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 * Specifies the CounterpartyEnum, e.g. either Party1 or Party2, that is associated to the partyReference.
	 */
	CounterpartyRoleEnum getRole();
	final static CounterpartyMeta metaData = new CounterpartyMeta();
	
	@Override
	default RosettaMetaData<? extends Counterparty> metaData() {
		return metaData;
	} 
			
	static Counterparty.CounterpartyBuilder builder() {
		return new Counterparty.CounterpartyBuilderImpl();
	}
	
	default Class<? extends Counterparty> getType() {
		return Counterparty.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("role"), CounterpartyRoleEnum.class, getRole(), this);
		
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
	}
	
	
	interface CounterpartyBuilder extends Counterparty, RosettaModelObjectBuilder {
		ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		ReferenceWithMetaPartyBuilder getPartyReference();
		Counterparty.CounterpartyBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		Counterparty.CounterpartyBuilder setPartyReferenceValue(Party partyReference);
		Counterparty.CounterpartyBuilder setRole(CounterpartyRoleEnum role);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("role"), CounterpartyRoleEnum.class, getRole(), this);
			
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPartyReference());
		}
		
	}
	
	//Counterparty.CounterpartyImpl
	class CounterpartyImpl implements Counterparty {
		private final ReferenceWithMetaParty partyReference;
		private final CounterpartyRoleEnum role;
		
		protected CounterpartyImpl(Counterparty.CounterpartyBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.role = builder.getRole();
		}
		
		@Override
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		public CounterpartyRoleEnum getRole() {
			return role;
		}
		
		@Override
		public Counterparty build() {
			return this;
		}
		
		@Override
		public Counterparty.CounterpartyBuilder toBuilder() {
			Counterparty.CounterpartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Counterparty.CounterpartyBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty {" +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
	
	//Counterparty.CounterpartyBuilderImpl
	class CounterpartyBuilderImpl implements Counterparty.CounterpartyBuilder {
	
		protected ReferenceWithMetaPartyBuilder partyReference;
		protected CounterpartyRoleEnum role;
	
		public CounterpartyBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaPartyBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreatePartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		public CounterpartyRoleEnum getRole() {
			return role;
		}
		
	
		@Override
		public Counterparty.CounterpartyBuilder setPartyReference(ReferenceWithMetaParty partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		
		@Override
		public Counterparty.CounterpartyBuilder setPartyReferenceValue(Party partyReference) {
			this.getOrCreatePartyReference().setValue(partyReference);
			return this;
		}
		@Override
		public Counterparty.CounterpartyBuilder setRole(CounterpartyRoleEnum role) {
			this.role = role==null?null:role;
			return this;
		}
		
		@Override
		public Counterparty build() {
			return new Counterparty.CounterpartyImpl(this);
		}
		
		@Override
		public Counterparty.CounterpartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty.CounterpartyBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getRole()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty.CounterpartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty.CounterpartyBuilder o = (Counterparty.CounterpartyBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			
			merger.mergeBasic(getRole(), o.getRole(), this::setRole);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartyBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
}
