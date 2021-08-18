package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.AncillaryEntityMeta;
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
 * Holds an identifier for an ancillary entity, either identified directly via its ancillary role or directly as a legal entity.
 * @version ${project.version}
 */
@RosettaClass

public interface AncillaryEntity extends RosettaModelObject {
	AncillaryEntity build();
	AncillaryEntity.AncillaryEntityBuilder toBuilder();
	
	/**
	 * Identifies a party via its ancillary role on a transaction (e.g. CCP or DCO through which the trade should be cleared.)
	 */
	AncillaryRoleEnum getAncillaryParty();
	/**
	 */
	LegalEntity getLegalEntity();
	final static AncillaryEntityMeta metaData = new AncillaryEntityMeta();
	
	@Override
	default RosettaMetaData<? extends AncillaryEntity> metaData() {
		return metaData;
	} 
			
	static AncillaryEntity.AncillaryEntityBuilder builder() {
		return new AncillaryEntity.AncillaryEntityBuilderImpl();
	}
	
	default Class<? extends AncillaryEntity> getType() {
		return AncillaryEntity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ancillaryParty"), AncillaryRoleEnum.class, getAncillaryParty(), this);
		
		processRosetta(path.newSubPath("legalEntity"), processor, LegalEntity.class, getLegalEntity());
	}
	
	
	interface AncillaryEntityBuilder extends AncillaryEntity, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateLegalEntity();
		LegalEntity.LegalEntityBuilder getLegalEntity();
		AncillaryEntity.AncillaryEntityBuilder setAncillaryParty(AncillaryRoleEnum ancillaryParty);
		AncillaryEntity.AncillaryEntityBuilder setLegalEntity(LegalEntity legalEntity);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("ancillaryParty"), AncillaryRoleEnum.class, getAncillaryParty(), this);
			
			processRosetta(path.newSubPath("legalEntity"), processor, LegalEntity.LegalEntityBuilder.class, getLegalEntity());
		}
		
	}
	
	//AncillaryEntity.AncillaryEntityImpl
	class AncillaryEntityImpl implements AncillaryEntity {
		private final AncillaryRoleEnum ancillaryParty;
		private final LegalEntity legalEntity;
		
		protected AncillaryEntityImpl(AncillaryEntity.AncillaryEntityBuilder builder) {
			this.ancillaryParty = builder.getAncillaryParty();
			this.legalEntity = ofNullable(builder.getLegalEntity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AncillaryRoleEnum getAncillaryParty() {
			return ancillaryParty;
		}
		
		@Override
		public LegalEntity getLegalEntity() {
			return legalEntity;
		}
		
		@Override
		public AncillaryEntity build() {
			return this;
		}
		
		@Override
		public AncillaryEntity.AncillaryEntityBuilder toBuilder() {
			AncillaryEntity.AncillaryEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AncillaryEntity.AncillaryEntityBuilder builder) {
			ofNullable(getAncillaryParty()).ifPresent(builder::setAncillaryParty);
			ofNullable(getLegalEntity()).ifPresent(builder::setLegalEntity);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AncillaryEntity _that = getType().cast(o);
		
			if (!Objects.equals(ancillaryParty, _that.getAncillaryParty())) return false;
			if (!Objects.equals(legalEntity, _that.getLegalEntity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ancillaryParty != null ? ancillaryParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (legalEntity != null ? legalEntity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AncillaryEntity {" +
				"ancillaryParty=" + this.ancillaryParty + ", " +
				"legalEntity=" + this.legalEntity +
			'}';
		}
	}
	
	//AncillaryEntity.AncillaryEntityBuilderImpl
	class AncillaryEntityBuilderImpl implements AncillaryEntity.AncillaryEntityBuilder {
	
		protected AncillaryRoleEnum ancillaryParty;
		protected LegalEntity.LegalEntityBuilder legalEntity;
	
		public AncillaryEntityBuilderImpl() {
		}
	
		@Override
		public AncillaryRoleEnum getAncillaryParty() {
			return ancillaryParty;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getLegalEntity() {
			return legalEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateLegalEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (legalEntity!=null) {
				result = legalEntity;
			}
			else {
				result = legalEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
	
		@Override
		public AncillaryEntity.AncillaryEntityBuilder setAncillaryParty(AncillaryRoleEnum ancillaryParty) {
			this.ancillaryParty = ancillaryParty==null?null:ancillaryParty;
			return this;
		}
		@Override
		public AncillaryEntity.AncillaryEntityBuilder setLegalEntity(LegalEntity legalEntity) {
			this.legalEntity = legalEntity==null?null:legalEntity.toBuilder();
			return this;
		}
		
		@Override
		public AncillaryEntity build() {
			return new AncillaryEntity.AncillaryEntityImpl(this);
		}
		
		@Override
		public AncillaryEntity.AncillaryEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AncillaryEntity.AncillaryEntityBuilder prune() {
			if (legalEntity!=null && !legalEntity.prune().hasData()) legalEntity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAncillaryParty()!=null) return true;
			if (getLegalEntity()!=null && getLegalEntity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AncillaryEntity.AncillaryEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AncillaryEntity.AncillaryEntityBuilder o = (AncillaryEntity.AncillaryEntityBuilder) other;
			
			merger.mergeRosetta(getLegalEntity(), o.getLegalEntity(), this::setLegalEntity);
			
			merger.mergeBasic(getAncillaryParty(), o.getAncillaryParty(), this::setAncillaryParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AncillaryEntity _that = getType().cast(o);
		
			if (!Objects.equals(ancillaryParty, _that.getAncillaryParty())) return false;
			if (!Objects.equals(legalEntity, _that.getLegalEntity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ancillaryParty != null ? ancillaryParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (legalEntity != null ? legalEntity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AncillaryEntityBuilder {" +
				"ancillaryParty=" + this.ancillaryParty + ", " +
				"legalEntity=" + this.legalEntity +
			'}';
		}
	}
}
