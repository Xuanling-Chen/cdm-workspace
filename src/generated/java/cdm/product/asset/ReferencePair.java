package cdm.product.asset;

import cdm.base.staticdata.party.EntityTypeEnum;
import cdm.base.staticdata.party.EntityTypeEnum;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.metafields.FieldWithMetaEntityTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder;
import cdm.product.asset.meta.ReferencePairMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface ReferencePair extends RosettaModelObject {
	ReferencePair build();
	ReferencePair.ReferencePairBuilder toBuilder();
	
	/**
	 * Defines the reference entity types corresponding to a list of types in the ISDA First to Default documentation.
	 */
	FieldWithMetaEntityTypeEnum getEntityType();
	/**
	 * Used to indicate that there is no Reference Obligation associated with this Credit Default Swap and that there will never be one.
	 */
	Boolean getNoReferenceObligation();
	/**
	 * The corporate or sovereign entity on which you are buying or selling protection and any successor that assumes all or substantially all of its contractual and other obligations. It is vital to use the correct legal name of the entity and to be careful not to choose a subsidiary if you really want to trade protection on a parent company. Please note, Reference Entities cannot be senior or subordinated. It is the obligations of the Reference Entities that can be senior or subordinated. ISDA 2003 Term: Reference Entity.
	 */
	LegalEntity getReferenceEntity();
	/**
	 * The Reference Obligation is a financial instrument that is either issued or guaranteed by the reference entity. It serves to clarify the precise reference entity protection is being offered upon, and its legal position with regard to other related firms (parents/subsidiaries). Furthermore the Reference Obligation is ALWAYS deliverable and establishes the Pari Passu ranking (as the deliverable bonds must rank equal to the reference obligation). ISDA 2003 Term: Reference Obligation.
	 */
	ReferenceObligation getReferenceObligation();
	final static ReferencePairMeta metaData = new ReferencePairMeta();
	
	@Override
	default RosettaMetaData<? extends ReferencePair> metaData() {
		return metaData;
	} 
			
	static ReferencePair.ReferencePairBuilder builder() {
		return new ReferencePair.ReferencePairBuilderImpl();
	}
	
	default Class<? extends ReferencePair> getType() {
		return ReferencePair.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("noReferenceObligation"), Boolean.class, getNoReferenceObligation(), this);
		
		processRosetta(path.newSubPath("entityType"), processor, FieldWithMetaEntityTypeEnum.class, getEntityType());
		processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.class, getReferenceEntity());
		processRosetta(path.newSubPath("referenceObligation"), processor, ReferenceObligation.class, getReferenceObligation());
	}
	
	
	interface ReferencePairBuilder extends ReferencePair, RosettaModelObjectBuilder {
		FieldWithMetaEntityTypeEnumBuilder getOrCreateEntityType();
		FieldWithMetaEntityTypeEnumBuilder getEntityType();
		LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity();
		LegalEntity.LegalEntityBuilder getReferenceEntity();
		ReferenceObligation.ReferenceObligationBuilder getOrCreateReferenceObligation();
		ReferenceObligation.ReferenceObligationBuilder getReferenceObligation();
		ReferencePair.ReferencePairBuilder setEntityType(FieldWithMetaEntityTypeEnum entityType);
		ReferencePair.ReferencePairBuilder setEntityTypeValue(EntityTypeEnum entityType);
		ReferencePair.ReferencePairBuilder setNoReferenceObligation(Boolean noReferenceObligation);
		ReferencePair.ReferencePairBuilder setReferenceEntity(LegalEntity referenceEntity);
		ReferencePair.ReferencePairBuilder setReferenceObligation(ReferenceObligation referenceObligation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("noReferenceObligation"), Boolean.class, getNoReferenceObligation(), this);
			
			processRosetta(path.newSubPath("entityType"), processor, FieldWithMetaEntityTypeEnumBuilder.class, getEntityType());
			processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getReferenceEntity());
			processRosetta(path.newSubPath("referenceObligation"), processor, ReferenceObligation.ReferenceObligationBuilder.class, getReferenceObligation());
		}
		
	}
	
	//ReferencePair.ReferencePairImpl
	class ReferencePairImpl implements ReferencePair {
		private final FieldWithMetaEntityTypeEnum entityType;
		private final Boolean noReferenceObligation;
		private final LegalEntity referenceEntity;
		private final ReferenceObligation referenceObligation;
		
		protected ReferencePairImpl(ReferencePair.ReferencePairBuilder builder) {
			this.entityType = ofNullable(builder.getEntityType()).map(f->f.build()).orElse(null);
			this.noReferenceObligation = builder.getNoReferenceObligation();
			this.referenceEntity = ofNullable(builder.getReferenceEntity()).map(f->f.build()).orElse(null);
			this.referenceObligation = ofNullable(builder.getReferenceObligation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaEntityTypeEnum getEntityType() {
			return entityType;
		}
		
		@Override
		public Boolean getNoReferenceObligation() {
			return noReferenceObligation;
		}
		
		@Override
		public LegalEntity getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public ReferenceObligation getReferenceObligation() {
			return referenceObligation;
		}
		
		@Override
		public ReferencePair build() {
			return this;
		}
		
		@Override
		public ReferencePair.ReferencePairBuilder toBuilder() {
			ReferencePair.ReferencePairBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferencePair.ReferencePairBuilder builder) {
			ofNullable(getEntityType()).ifPresent(builder::setEntityType);
			ofNullable(getNoReferenceObligation()).ifPresent(builder::setNoReferenceObligation);
			ofNullable(getReferenceEntity()).ifPresent(builder::setReferenceEntity);
			ofNullable(getReferenceObligation()).ifPresent(builder::setReferenceObligation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferencePair _that = getType().cast(o);
		
			if (!Objects.equals(entityType, _that.getEntityType())) return false;
			if (!Objects.equals(noReferenceObligation, _that.getNoReferenceObligation())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(referenceObligation, _that.getReferenceObligation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entityType != null ? entityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (noReferenceObligation != null ? noReferenceObligation.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (referenceObligation != null ? referenceObligation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferencePair {" +
				"entityType=" + this.entityType + ", " +
				"noReferenceObligation=" + this.noReferenceObligation + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"referenceObligation=" + this.referenceObligation +
			'}';
		}
	}
	
	//ReferencePair.ReferencePairBuilderImpl
	class ReferencePairBuilderImpl implements ReferencePair.ReferencePairBuilder {
	
		protected FieldWithMetaEntityTypeEnumBuilder entityType;
		protected Boolean noReferenceObligation;
		protected LegalEntity.LegalEntityBuilder referenceEntity;
		protected ReferenceObligation.ReferenceObligationBuilder referenceObligation;
	
		public ReferencePairBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaEntityTypeEnumBuilder getEntityType() {
			return entityType;
		}
		
		@Override
		public FieldWithMetaEntityTypeEnumBuilder getOrCreateEntityType() {
			FieldWithMetaEntityTypeEnumBuilder result;
			if (entityType!=null) {
				result = entityType;
			}
			else {
				result = entityType = FieldWithMetaEntityTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getNoReferenceObligation() {
			return noReferenceObligation;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (referenceEntity!=null) {
				result = referenceEntity;
			}
			else {
				result = referenceEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceObligation.ReferenceObligationBuilder getReferenceObligation() {
			return referenceObligation;
		}
		
		@Override
		public ReferenceObligation.ReferenceObligationBuilder getOrCreateReferenceObligation() {
			ReferenceObligation.ReferenceObligationBuilder result;
			if (referenceObligation!=null) {
				result = referenceObligation;
			}
			else {
				result = referenceObligation = ReferenceObligation.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferencePair.ReferencePairBuilder setEntityType(FieldWithMetaEntityTypeEnum entityType) {
			this.entityType = entityType==null?null:entityType.toBuilder();
			return this;
		}
		
		@Override
		public ReferencePair.ReferencePairBuilder setEntityTypeValue(EntityTypeEnum entityType) {
			this.getOrCreateEntityType().setValue(entityType);
			return this;
		}
		@Override
		public ReferencePair.ReferencePairBuilder setNoReferenceObligation(Boolean noReferenceObligation) {
			this.noReferenceObligation = noReferenceObligation==null?null:noReferenceObligation;
			return this;
		}
		@Override
		public ReferencePair.ReferencePairBuilder setReferenceEntity(LegalEntity referenceEntity) {
			this.referenceEntity = referenceEntity==null?null:referenceEntity.toBuilder();
			return this;
		}
		@Override
		public ReferencePair.ReferencePairBuilder setReferenceObligation(ReferenceObligation referenceObligation) {
			this.referenceObligation = referenceObligation==null?null:referenceObligation.toBuilder();
			return this;
		}
		
		@Override
		public ReferencePair build() {
			return new ReferencePair.ReferencePairImpl(this);
		}
		
		@Override
		public ReferencePair.ReferencePairBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferencePair.ReferencePairBuilder prune() {
			if (entityType!=null && !entityType.prune().hasData()) entityType = null;
			if (referenceEntity!=null && !referenceEntity.prune().hasData()) referenceEntity = null;
			if (referenceObligation!=null && !referenceObligation.prune().hasData()) referenceObligation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEntityType()!=null) return true;
			if (getNoReferenceObligation()!=null) return true;
			if (getReferenceEntity()!=null && getReferenceEntity().hasData()) return true;
			if (getReferenceObligation()!=null && getReferenceObligation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferencePair.ReferencePairBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferencePair.ReferencePairBuilder o = (ReferencePair.ReferencePairBuilder) other;
			
			merger.mergeRosetta(getEntityType(), o.getEntityType(), this::setEntityType);
			merger.mergeRosetta(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeRosetta(getReferenceObligation(), o.getReferenceObligation(), this::setReferenceObligation);
			
			merger.mergeBasic(getNoReferenceObligation(), o.getNoReferenceObligation(), this::setNoReferenceObligation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferencePair _that = getType().cast(o);
		
			if (!Objects.equals(entityType, _that.getEntityType())) return false;
			if (!Objects.equals(noReferenceObligation, _that.getNoReferenceObligation())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(referenceObligation, _that.getReferenceObligation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entityType != null ? entityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (noReferenceObligation != null ? noReferenceObligation.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (referenceObligation != null ? referenceObligation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferencePairBuilder {" +
				"entityType=" + this.entityType + ", " +
				"noReferenceObligation=" + this.noReferenceObligation + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"referenceObligation=" + this.referenceObligation +
			'}';
		}
	}
}
