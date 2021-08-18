package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.PartyRoleMeta;
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
 * A class to specify the role(s) that party(ies) may have in relation to the execution, contract or other legal agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface PartyRole extends RosettaModelObject {
	PartyRole build();
	PartyRole.PartyRoleBuilder toBuilder();
	
	/**
	 * A reference to the party that has ownership of this party role information. FpML specifies that For shared trade information, this attribute will reference the originator of the data (for example, an execution facility or clearing house).
	 */
	ReferenceWithMetaParty getOwnershipPartyReference();
	/**
	 * A reference to the party to which the role refers to.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 * The party role.
	 */
	PartyRoleEnum getRole();
	final static PartyRoleMeta metaData = new PartyRoleMeta();
	
	@Override
	default RosettaMetaData<? extends PartyRole> metaData() {
		return metaData;
	} 
			
	static PartyRole.PartyRoleBuilder builder() {
		return new PartyRole.PartyRoleBuilderImpl();
	}
	
	default Class<? extends PartyRole> getType() {
		return PartyRole.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("role"), PartyRoleEnum.class, getRole(), this);
		
		processRosetta(path.newSubPath("ownershipPartyReference"), processor, ReferenceWithMetaParty.class, getOwnershipPartyReference());
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
	}
	
	
	interface PartyRoleBuilder extends PartyRole, RosettaModelObjectBuilder {
		ReferenceWithMetaPartyBuilder getOrCreateOwnershipPartyReference();
		ReferenceWithMetaPartyBuilder getOwnershipPartyReference();
		ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		ReferenceWithMetaPartyBuilder getPartyReference();
		PartyRole.PartyRoleBuilder setOwnershipPartyReference(ReferenceWithMetaParty ownershipPartyReference);
		PartyRole.PartyRoleBuilder setOwnershipPartyReferenceValue(Party ownershipPartyReference);
		PartyRole.PartyRoleBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		PartyRole.PartyRoleBuilder setPartyReferenceValue(Party partyReference);
		PartyRole.PartyRoleBuilder setRole(PartyRoleEnum role);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("role"), PartyRoleEnum.class, getRole(), this);
			
			processRosetta(path.newSubPath("ownershipPartyReference"), processor, ReferenceWithMetaPartyBuilder.class, getOwnershipPartyReference());
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPartyReference());
		}
		
	}
	
	//PartyRole.PartyRoleImpl
	class PartyRoleImpl implements PartyRole {
		private final ReferenceWithMetaParty ownershipPartyReference;
		private final ReferenceWithMetaParty partyReference;
		private final PartyRoleEnum role;
		
		protected PartyRoleImpl(PartyRole.PartyRoleBuilder builder) {
			this.ownershipPartyReference = ofNullable(builder.getOwnershipPartyReference()).map(f->f.build()).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.role = builder.getRole();
		}
		
		@Override
		public ReferenceWithMetaParty getOwnershipPartyReference() {
			return ownershipPartyReference;
		}
		
		@Override
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyRoleEnum getRole() {
			return role;
		}
		
		@Override
		public PartyRole build() {
			return this;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder toBuilder() {
			PartyRole.PartyRoleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyRole.PartyRoleBuilder builder) {
			ofNullable(getOwnershipPartyReference()).ifPresent(builder::setOwnershipPartyReference);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRole _that = getType().cast(o);
		
			if (!Objects.equals(ownershipPartyReference, _that.getOwnershipPartyReference())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ownershipPartyReference != null ? ownershipPartyReference.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRole {" +
				"ownershipPartyReference=" + this.ownershipPartyReference + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
	
	//PartyRole.PartyRoleBuilderImpl
	class PartyRoleBuilderImpl implements PartyRole.PartyRoleBuilder {
	
		protected ReferenceWithMetaPartyBuilder ownershipPartyReference;
		protected ReferenceWithMetaPartyBuilder partyReference;
		protected PartyRoleEnum role;
	
		public PartyRoleBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaPartyBuilder getOwnershipPartyReference() {
			return ownershipPartyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreateOwnershipPartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (ownershipPartyReference!=null) {
				result = ownershipPartyReference;
			}
			else {
				result = ownershipPartyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
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
		public PartyRoleEnum getRole() {
			return role;
		}
		
	
		@Override
		public PartyRole.PartyRoleBuilder setOwnershipPartyReference(ReferenceWithMetaParty ownershipPartyReference) {
			this.ownershipPartyReference = ownershipPartyReference==null?null:ownershipPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder setOwnershipPartyReferenceValue(Party ownershipPartyReference) {
			this.getOrCreateOwnershipPartyReference().setValue(ownershipPartyReference);
			return this;
		}
		@Override
		public PartyRole.PartyRoleBuilder setPartyReference(ReferenceWithMetaParty partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder setPartyReferenceValue(Party partyReference) {
			this.getOrCreatePartyReference().setValue(partyReference);
			return this;
		}
		@Override
		public PartyRole.PartyRoleBuilder setRole(PartyRoleEnum role) {
			this.role = role==null?null:role;
			return this;
		}
		
		@Override
		public PartyRole build() {
			return new PartyRole.PartyRoleImpl(this);
		}
		
		@Override
		public PartyRole.PartyRoleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRole.PartyRoleBuilder prune() {
			if (ownershipPartyReference!=null && !ownershipPartyReference.prune().hasData()) ownershipPartyReference = null;
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOwnershipPartyReference()!=null && getOwnershipPartyReference().hasData()) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getRole()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRole.PartyRoleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyRole.PartyRoleBuilder o = (PartyRole.PartyRoleBuilder) other;
			
			merger.mergeRosetta(getOwnershipPartyReference(), o.getOwnershipPartyReference(), this::setOwnershipPartyReference);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			
			merger.mergeBasic(getRole(), o.getRole(), this::setRole);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRole _that = getType().cast(o);
		
			if (!Objects.equals(ownershipPartyReference, _that.getOwnershipPartyReference())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ownershipPartyReference != null ? ownershipPartyReference.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRoleBuilder {" +
				"ownershipPartyReference=" + this.ownershipPartyReference + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
}
