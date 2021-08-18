package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.ControlAgreementElectionsMeta;
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
 * A class to specify the Control Agreement election sby each party to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface ControlAgreementElections extends RosettaModelObject {
	ControlAgreementElections build();
	ControlAgreementElections.ControlAgreementElectionsBuilder toBuilder();
	
	/**
	 * Unless specified as inapplicable in the event of any inconsistency between this Deed and the Control Agreement, this Deed will prevail over the Control Agreement
	 */
	Boolean getConsistencyWithControlAgreement();
	/**
	 * The identification of whether the Control Agreement is a Credit Support Document with respect to each party
	 */
	Boolean getControlAgreementAsCsd();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * Unless specified as inapplicable the parties recognise that the Control Agreement is a means by which the parties can perform their obligations.
	 */
	Boolean getRelationshipWithControlAgreement();
	final static ControlAgreementElectionsMeta metaData = new ControlAgreementElectionsMeta();
	
	@Override
	default RosettaMetaData<? extends ControlAgreementElections> metaData() {
		return metaData;
	} 
			
	static ControlAgreementElections.ControlAgreementElectionsBuilder builder() {
		return new ControlAgreementElections.ControlAgreementElectionsBuilderImpl();
	}
	
	default Class<? extends ControlAgreementElections> getType() {
		return ControlAgreementElections.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("consistencyWithControlAgreement"), Boolean.class, getConsistencyWithControlAgreement(), this);
		processor.processBasic(path.newSubPath("controlAgreementAsCsd"), Boolean.class, getControlAgreementAsCsd(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("relationshipWithControlAgreement"), Boolean.class, getRelationshipWithControlAgreement(), this);
		
	}
	
	
	interface ControlAgreementElectionsBuilder extends ControlAgreementElections, RosettaModelObjectBuilder {
		ControlAgreementElections.ControlAgreementElectionsBuilder setConsistencyWithControlAgreement(Boolean consistencyWithControlAgreement);
		ControlAgreementElections.ControlAgreementElectionsBuilder setControlAgreementAsCsd(Boolean controlAgreementAsCsd);
		ControlAgreementElections.ControlAgreementElectionsBuilder setParty(CounterpartyRoleEnum party);
		ControlAgreementElections.ControlAgreementElectionsBuilder setRelationshipWithControlAgreement(Boolean relationshipWithControlAgreement);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("consistencyWithControlAgreement"), Boolean.class, getConsistencyWithControlAgreement(), this);
			processor.processBasic(path.newSubPath("controlAgreementAsCsd"), Boolean.class, getControlAgreementAsCsd(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("relationshipWithControlAgreement"), Boolean.class, getRelationshipWithControlAgreement(), this);
			
		}
		
	}
	
	//ControlAgreementElections.ControlAgreementElectionsImpl
	class ControlAgreementElectionsImpl implements ControlAgreementElections {
		private final Boolean consistencyWithControlAgreement;
		private final Boolean controlAgreementAsCsd;
		private final CounterpartyRoleEnum party;
		private final Boolean relationshipWithControlAgreement;
		
		protected ControlAgreementElectionsImpl(ControlAgreementElections.ControlAgreementElectionsBuilder builder) {
			this.consistencyWithControlAgreement = builder.getConsistencyWithControlAgreement();
			this.controlAgreementAsCsd = builder.getControlAgreementAsCsd();
			this.party = builder.getParty();
			this.relationshipWithControlAgreement = builder.getRelationshipWithControlAgreement();
		}
		
		@Override
		public Boolean getConsistencyWithControlAgreement() {
			return consistencyWithControlAgreement;
		}
		
		@Override
		public Boolean getControlAgreementAsCsd() {
			return controlAgreementAsCsd;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Boolean getRelationshipWithControlAgreement() {
			return relationshipWithControlAgreement;
		}
		
		@Override
		public ControlAgreementElections build() {
			return this;
		}
		
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder toBuilder() {
			ControlAgreementElections.ControlAgreementElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ControlAgreementElections.ControlAgreementElectionsBuilder builder) {
			ofNullable(getConsistencyWithControlAgreement()).ifPresent(builder::setConsistencyWithControlAgreement);
			ofNullable(getControlAgreementAsCsd()).ifPresent(builder::setControlAgreementAsCsd);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRelationshipWithControlAgreement()).ifPresent(builder::setRelationshipWithControlAgreement);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(consistencyWithControlAgreement, _that.getConsistencyWithControlAgreement())) return false;
			if (!Objects.equals(controlAgreementAsCsd, _that.getControlAgreementAsCsd())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(relationshipWithControlAgreement, _that.getRelationshipWithControlAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (consistencyWithControlAgreement != null ? consistencyWithControlAgreement.hashCode() : 0);
			_result = 31 * _result + (controlAgreementAsCsd != null ? controlAgreementAsCsd.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (relationshipWithControlAgreement != null ? relationshipWithControlAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementElections {" +
				"consistencyWithControlAgreement=" + this.consistencyWithControlAgreement + ", " +
				"controlAgreementAsCsd=" + this.controlAgreementAsCsd + ", " +
				"party=" + this.party + ", " +
				"relationshipWithControlAgreement=" + this.relationshipWithControlAgreement +
			'}';
		}
	}
	
	//ControlAgreementElections.ControlAgreementElectionsBuilderImpl
	class ControlAgreementElectionsBuilderImpl implements ControlAgreementElections.ControlAgreementElectionsBuilder {
	
		protected Boolean consistencyWithControlAgreement;
		protected Boolean controlAgreementAsCsd;
		protected CounterpartyRoleEnum party;
		protected Boolean relationshipWithControlAgreement;
	
		public ControlAgreementElectionsBuilderImpl() {
		}
	
		@Override
		public Boolean getConsistencyWithControlAgreement() {
			return consistencyWithControlAgreement;
		}
		
		@Override
		public Boolean getControlAgreementAsCsd() {
			return controlAgreementAsCsd;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Boolean getRelationshipWithControlAgreement() {
			return relationshipWithControlAgreement;
		}
		
	
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder setConsistencyWithControlAgreement(Boolean consistencyWithControlAgreement) {
			this.consistencyWithControlAgreement = consistencyWithControlAgreement==null?null:consistencyWithControlAgreement;
			return this;
		}
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder setControlAgreementAsCsd(Boolean controlAgreementAsCsd) {
			this.controlAgreementAsCsd = controlAgreementAsCsd==null?null:controlAgreementAsCsd;
			return this;
		}
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder setRelationshipWithControlAgreement(Boolean relationshipWithControlAgreement) {
			this.relationshipWithControlAgreement = relationshipWithControlAgreement==null?null:relationshipWithControlAgreement;
			return this;
		}
		
		@Override
		public ControlAgreementElections build() {
			return new ControlAgreementElections.ControlAgreementElectionsImpl(this);
		}
		
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConsistencyWithControlAgreement()!=null) return true;
			if (getControlAgreementAsCsd()!=null) return true;
			if (getParty()!=null) return true;
			if (getRelationshipWithControlAgreement()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ControlAgreementElections.ControlAgreementElectionsBuilder o = (ControlAgreementElections.ControlAgreementElectionsBuilder) other;
			
			
			merger.mergeBasic(getConsistencyWithControlAgreement(), o.getConsistencyWithControlAgreement(), this::setConsistencyWithControlAgreement);
			merger.mergeBasic(getControlAgreementAsCsd(), o.getControlAgreementAsCsd(), this::setControlAgreementAsCsd);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getRelationshipWithControlAgreement(), o.getRelationshipWithControlAgreement(), this::setRelationshipWithControlAgreement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(consistencyWithControlAgreement, _that.getConsistencyWithControlAgreement())) return false;
			if (!Objects.equals(controlAgreementAsCsd, _that.getControlAgreementAsCsd())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(relationshipWithControlAgreement, _that.getRelationshipWithControlAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (consistencyWithControlAgreement != null ? consistencyWithControlAgreement.hashCode() : 0);
			_result = 31 * _result + (controlAgreementAsCsd != null ? controlAgreementAsCsd.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (relationshipWithControlAgreement != null ? relationshipWithControlAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementElectionsBuilder {" +
				"consistencyWithControlAgreement=" + this.consistencyWithControlAgreement + ", " +
				"controlAgreementAsCsd=" + this.controlAgreementAsCsd + ", " +
				"party=" + this.party + ", " +
				"relationshipWithControlAgreement=" + this.relationshipWithControlAgreement +
			'}';
		}
	}
}
