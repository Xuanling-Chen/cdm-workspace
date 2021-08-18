package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.NaturalPersonRoleMeta;
import cdm.base.staticdata.party.metafields.FieldWithMetaNaturalPersonRoleEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaNaturalPersonRoleEnum.FieldWithMetaNaturalPersonRoleEnumBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaNaturalPerson;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder;
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
 * A class to specify the role(s) that natural person(s) may have in relation to the contract.
 * @version ${project.version}
 */
@RosettaClass

public interface NaturalPersonRole extends RosettaModelObject {
	NaturalPersonRole build();
	NaturalPersonRole.NaturalPersonRoleBuilder toBuilder();
	
	/**
	 * A reference to the natural person to whom the role refers to.
	 */
	ReferenceWithMetaNaturalPerson getPersonReference();
	/**
	 * FpML specifies a person role that is distinct from the party role.
	 */
	FieldWithMetaNaturalPersonRoleEnum getRole();
	final static NaturalPersonRoleMeta metaData = new NaturalPersonRoleMeta();
	
	@Override
	default RosettaMetaData<? extends NaturalPersonRole> metaData() {
		return metaData;
	} 
			
	static NaturalPersonRole.NaturalPersonRoleBuilder builder() {
		return new NaturalPersonRole.NaturalPersonRoleBuilderImpl();
	}
	
	default Class<? extends NaturalPersonRole> getType() {
		return NaturalPersonRole.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("personReference"), processor, ReferenceWithMetaNaturalPerson.class, getPersonReference());
		processRosetta(path.newSubPath("role"), processor, FieldWithMetaNaturalPersonRoleEnum.class, getRole());
	}
	
	
	interface NaturalPersonRoleBuilder extends NaturalPersonRole, RosettaModelObjectBuilder {
		ReferenceWithMetaNaturalPersonBuilder getOrCreatePersonReference();
		ReferenceWithMetaNaturalPersonBuilder getPersonReference();
		FieldWithMetaNaturalPersonRoleEnumBuilder getOrCreateRole();
		FieldWithMetaNaturalPersonRoleEnumBuilder getRole();
		NaturalPersonRole.NaturalPersonRoleBuilder setPersonReference(ReferenceWithMetaNaturalPerson personReference);
		NaturalPersonRole.NaturalPersonRoleBuilder setPersonReferenceValue(NaturalPerson personReference);
		NaturalPersonRole.NaturalPersonRoleBuilder setRole(FieldWithMetaNaturalPersonRoleEnum role);
		NaturalPersonRole.NaturalPersonRoleBuilder setRoleValue(NaturalPersonRoleEnum role);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("personReference"), processor, ReferenceWithMetaNaturalPersonBuilder.class, getPersonReference());
			processRosetta(path.newSubPath("role"), processor, FieldWithMetaNaturalPersonRoleEnumBuilder.class, getRole());
		}
		
	}
	
	//NaturalPersonRole.NaturalPersonRoleImpl
	class NaturalPersonRoleImpl implements NaturalPersonRole {
		private final ReferenceWithMetaNaturalPerson personReference;
		private final FieldWithMetaNaturalPersonRoleEnum role;
		
		protected NaturalPersonRoleImpl(NaturalPersonRole.NaturalPersonRoleBuilder builder) {
			this.personReference = ofNullable(builder.getPersonReference()).map(f->f.build()).orElse(null);
			this.role = ofNullable(builder.getRole()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaNaturalPerson getPersonReference() {
			return personReference;
		}
		
		@Override
		public FieldWithMetaNaturalPersonRoleEnum getRole() {
			return role;
		}
		
		@Override
		public NaturalPersonRole build() {
			return this;
		}
		
		@Override
		public NaturalPersonRole.NaturalPersonRoleBuilder toBuilder() {
			NaturalPersonRole.NaturalPersonRoleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NaturalPersonRole.NaturalPersonRoleBuilder builder) {
			ofNullable(getPersonReference()).ifPresent(builder::setPersonReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonRole _that = getType().cast(o);
		
			if (!Objects.equals(personReference, _that.getPersonReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (personReference != null ? personReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonRole {" +
				"personReference=" + this.personReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
	
	//NaturalPersonRole.NaturalPersonRoleBuilderImpl
	class NaturalPersonRoleBuilderImpl implements NaturalPersonRole.NaturalPersonRoleBuilder {
	
		protected ReferenceWithMetaNaturalPersonBuilder personReference;
		protected FieldWithMetaNaturalPersonRoleEnumBuilder role;
	
		public NaturalPersonRoleBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaNaturalPersonBuilder getPersonReference() {
			return personReference;
		}
		
		@Override
		public ReferenceWithMetaNaturalPersonBuilder getOrCreatePersonReference() {
			ReferenceWithMetaNaturalPersonBuilder result;
			if (personReference!=null) {
				result = personReference;
			}
			else {
				result = personReference = ReferenceWithMetaNaturalPerson.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaNaturalPersonRoleEnumBuilder getRole() {
			return role;
		}
		
		@Override
		public FieldWithMetaNaturalPersonRoleEnumBuilder getOrCreateRole() {
			FieldWithMetaNaturalPersonRoleEnumBuilder result;
			if (role!=null) {
				result = role;
			}
			else {
				result = role = FieldWithMetaNaturalPersonRoleEnum.builder();
			}
			
			return result;
		}
		
	
		@Override
		public NaturalPersonRole.NaturalPersonRoleBuilder setPersonReference(ReferenceWithMetaNaturalPerson personReference) {
			this.personReference = personReference==null?null:personReference.toBuilder();
			return this;
		}
		
		@Override
		public NaturalPersonRole.NaturalPersonRoleBuilder setPersonReferenceValue(NaturalPerson personReference) {
			this.getOrCreatePersonReference().setValue(personReference);
			return this;
		}
		@Override
		public NaturalPersonRole.NaturalPersonRoleBuilder setRole(FieldWithMetaNaturalPersonRoleEnum role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		
		@Override
		public NaturalPersonRole.NaturalPersonRoleBuilder setRoleValue(NaturalPersonRoleEnum role) {
			this.getOrCreateRole().setValue(role);
			return this;
		}
		
		@Override
		public NaturalPersonRole build() {
			return new NaturalPersonRole.NaturalPersonRoleImpl(this);
		}
		
		@Override
		public NaturalPersonRole.NaturalPersonRoleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonRole.NaturalPersonRoleBuilder prune() {
			if (personReference!=null && !personReference.prune().hasData()) personReference = null;
			if (role!=null && !role.prune().hasData()) role = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPersonReference()!=null && getPersonReference().hasData()) return true;
			if (getRole()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonRole.NaturalPersonRoleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NaturalPersonRole.NaturalPersonRoleBuilder o = (NaturalPersonRole.NaturalPersonRoleBuilder) other;
			
			merger.mergeRosetta(getPersonReference(), o.getPersonReference(), this::setPersonReference);
			merger.mergeRosetta(getRole(), o.getRole(), this::setRole);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonRole _that = getType().cast(o);
		
			if (!Objects.equals(personReference, _that.getPersonReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (personReference != null ? personReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonRoleBuilder {" +
				"personReference=" + this.personReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
}
