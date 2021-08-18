package cdm.legalagreement.master;

import cdm.legalagreement.master.meta.MasterAgreementMeta;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterAgreementTypeEnum;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class for defining the agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
 * @version ${project.version}
 */
@RosettaClass

public interface MasterAgreement extends RosettaModelObject {
	MasterAgreement build();
	MasterAgreement.MasterAgreementBuilder toBuilder();
	
	/**
	 * The date on which the master agreement was signed.
	 */
	Date getMasterAgreementDate();
	/**
	 * An identifier that has been created to identify the master agreement.
	 */
	FieldWithMetaString getMasterAgreementId();
	/**
	 * The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
	 */
	FieldWithMetaMasterAgreementTypeEnum getMasterAgreementType();
	/**
	 * The version of the master agreement.
	 */
	FieldWithMetaString getMasterAgreementVersion();
	final static MasterAgreementMeta metaData = new MasterAgreementMeta();
	
	@Override
	default RosettaMetaData<? extends MasterAgreement> metaData() {
		return metaData;
	} 
			
	static MasterAgreement.MasterAgreementBuilder builder() {
		return new MasterAgreement.MasterAgreementBuilderImpl();
	}
	
	default Class<? extends MasterAgreement> getType() {
		return MasterAgreement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("masterAgreementDate"), Date.class, getMasterAgreementDate(), this);
		
		processRosetta(path.newSubPath("masterAgreementId"), processor, FieldWithMetaString.class, getMasterAgreementId());
		processRosetta(path.newSubPath("masterAgreementType"), processor, FieldWithMetaMasterAgreementTypeEnum.class, getMasterAgreementType());
		processRosetta(path.newSubPath("masterAgreementVersion"), processor, FieldWithMetaString.class, getMasterAgreementVersion());
	}
	
	
	interface MasterAgreementBuilder extends MasterAgreement, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateMasterAgreementId();
		FieldWithMetaStringBuilder getMasterAgreementId();
		FieldWithMetaMasterAgreementTypeEnumBuilder getOrCreateMasterAgreementType();
		FieldWithMetaMasterAgreementTypeEnumBuilder getMasterAgreementType();
		FieldWithMetaStringBuilder getOrCreateMasterAgreementVersion();
		FieldWithMetaStringBuilder getMasterAgreementVersion();
		MasterAgreement.MasterAgreementBuilder setMasterAgreementDate(Date masterAgreementDate);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementId(FieldWithMetaString masterAgreementId);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementIdValue(String masterAgreementId);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementType(FieldWithMetaMasterAgreementTypeEnum masterAgreementType);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementTypeValue(MasterAgreementTypeEnum masterAgreementType);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementVersion(FieldWithMetaString masterAgreementVersion);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementVersionValue(String masterAgreementVersion);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("masterAgreementDate"), Date.class, getMasterAgreementDate(), this);
			
			processRosetta(path.newSubPath("masterAgreementId"), processor, FieldWithMetaStringBuilder.class, getMasterAgreementId());
			processRosetta(path.newSubPath("masterAgreementType"), processor, FieldWithMetaMasterAgreementTypeEnumBuilder.class, getMasterAgreementType());
			processRosetta(path.newSubPath("masterAgreementVersion"), processor, FieldWithMetaStringBuilder.class, getMasterAgreementVersion());
		}
		
	}
	
	//MasterAgreement.MasterAgreementImpl
	class MasterAgreementImpl implements MasterAgreement {
		private final Date masterAgreementDate;
		private final FieldWithMetaString masterAgreementId;
		private final FieldWithMetaMasterAgreementTypeEnum masterAgreementType;
		private final FieldWithMetaString masterAgreementVersion;
		
		protected MasterAgreementImpl(MasterAgreement.MasterAgreementBuilder builder) {
			this.masterAgreementDate = builder.getMasterAgreementDate();
			this.masterAgreementId = ofNullable(builder.getMasterAgreementId()).map(f->f.build()).orElse(null);
			this.masterAgreementType = ofNullable(builder.getMasterAgreementType()).map(f->f.build()).orElse(null);
			this.masterAgreementVersion = ofNullable(builder.getMasterAgreementVersion()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Date getMasterAgreementDate() {
			return masterAgreementDate;
		}
		
		@Override
		public FieldWithMetaString getMasterAgreementId() {
			return masterAgreementId;
		}
		
		@Override
		public FieldWithMetaMasterAgreementTypeEnum getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		public FieldWithMetaString getMasterAgreementVersion() {
			return masterAgreementVersion;
		}
		
		@Override
		public MasterAgreement build() {
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder toBuilder() {
			MasterAgreement.MasterAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreement.MasterAgreementBuilder builder) {
			ofNullable(getMasterAgreementDate()).ifPresent(builder::setMasterAgreementDate);
			ofNullable(getMasterAgreementId()).ifPresent(builder::setMasterAgreementId);
			ofNullable(getMasterAgreementType()).ifPresent(builder::setMasterAgreementType);
			ofNullable(getMasterAgreementVersion()).ifPresent(builder::setMasterAgreementVersion);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreement _that = getType().cast(o);
		
			if (!Objects.equals(masterAgreementDate, _that.getMasterAgreementDate())) return false;
			if (!Objects.equals(masterAgreementId, _that.getMasterAgreementId())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterAgreementVersion, _that.getMasterAgreementVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreementDate != null ? masterAgreementDate.hashCode() : 0);
			_result = 31 * _result + (masterAgreementId != null ? masterAgreementId.hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersion != null ? masterAgreementVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreement {" +
				"masterAgreementDate=" + this.masterAgreementDate + ", " +
				"masterAgreementId=" + this.masterAgreementId + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterAgreementVersion=" + this.masterAgreementVersion +
			'}';
		}
	}
	
	//MasterAgreement.MasterAgreementBuilderImpl
	class MasterAgreementBuilderImpl implements MasterAgreement.MasterAgreementBuilder {
	
		protected Date masterAgreementDate;
		protected FieldWithMetaStringBuilder masterAgreementId;
		protected FieldWithMetaMasterAgreementTypeEnumBuilder masterAgreementType;
		protected FieldWithMetaStringBuilder masterAgreementVersion;
	
		public MasterAgreementBuilderImpl() {
		}
	
		@Override
		public Date getMasterAgreementDate() {
			return masterAgreementDate;
		}
		
		@Override
		public FieldWithMetaStringBuilder getMasterAgreementId() {
			return masterAgreementId;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateMasterAgreementId() {
			FieldWithMetaStringBuilder result;
			if (masterAgreementId!=null) {
				result = masterAgreementId;
			}
			else {
				result = masterAgreementId = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaMasterAgreementTypeEnumBuilder getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		public FieldWithMetaMasterAgreementTypeEnumBuilder getOrCreateMasterAgreementType() {
			FieldWithMetaMasterAgreementTypeEnumBuilder result;
			if (masterAgreementType!=null) {
				result = masterAgreementType;
			}
			else {
				result = masterAgreementType = FieldWithMetaMasterAgreementTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getMasterAgreementVersion() {
			return masterAgreementVersion;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateMasterAgreementVersion() {
			FieldWithMetaStringBuilder result;
			if (masterAgreementVersion!=null) {
				result = masterAgreementVersion;
			}
			else {
				result = masterAgreementVersion = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementDate(Date masterAgreementDate) {
			this.masterAgreementDate = masterAgreementDate==null?null:masterAgreementDate;
			return this;
		}
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementId(FieldWithMetaString masterAgreementId) {
			this.masterAgreementId = masterAgreementId==null?null:masterAgreementId.toBuilder();
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementIdValue(String masterAgreementId) {
			this.getOrCreateMasterAgreementId().setValue(masterAgreementId);
			return this;
		}
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementType(FieldWithMetaMasterAgreementTypeEnum masterAgreementType) {
			this.masterAgreementType = masterAgreementType==null?null:masterAgreementType.toBuilder();
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementTypeValue(MasterAgreementTypeEnum masterAgreementType) {
			this.getOrCreateMasterAgreementType().setValue(masterAgreementType);
			return this;
		}
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementVersion(FieldWithMetaString masterAgreementVersion) {
			this.masterAgreementVersion = masterAgreementVersion==null?null:masterAgreementVersion.toBuilder();
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementVersionValue(String masterAgreementVersion) {
			this.getOrCreateMasterAgreementVersion().setValue(masterAgreementVersion);
			return this;
		}
		
		@Override
		public MasterAgreement build() {
			return new MasterAgreement.MasterAgreementImpl(this);
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement.MasterAgreementBuilder prune() {
			if (masterAgreementId!=null && !masterAgreementId.prune().hasData()) masterAgreementId = null;
			if (masterAgreementType!=null && !masterAgreementType.prune().hasData()) masterAgreementType = null;
			if (masterAgreementVersion!=null && !masterAgreementVersion.prune().hasData()) masterAgreementVersion = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMasterAgreementDate()!=null) return true;
			if (getMasterAgreementId()!=null) return true;
			if (getMasterAgreementType()!=null) return true;
			if (getMasterAgreementVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement.MasterAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreement.MasterAgreementBuilder o = (MasterAgreement.MasterAgreementBuilder) other;
			
			merger.mergeRosetta(getMasterAgreementId(), o.getMasterAgreementId(), this::setMasterAgreementId);
			merger.mergeRosetta(getMasterAgreementType(), o.getMasterAgreementType(), this::setMasterAgreementType);
			merger.mergeRosetta(getMasterAgreementVersion(), o.getMasterAgreementVersion(), this::setMasterAgreementVersion);
			
			merger.mergeBasic(getMasterAgreementDate(), o.getMasterAgreementDate(), this::setMasterAgreementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreement _that = getType().cast(o);
		
			if (!Objects.equals(masterAgreementDate, _that.getMasterAgreementDate())) return false;
			if (!Objects.equals(masterAgreementId, _that.getMasterAgreementId())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterAgreementVersion, _that.getMasterAgreementVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreementDate != null ? masterAgreementDate.hashCode() : 0);
			_result = 31 * _result + (masterAgreementId != null ? masterAgreementId.hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersion != null ? masterAgreementVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementBuilder {" +
				"masterAgreementDate=" + this.masterAgreementDate + ", " +
				"masterAgreementId=" + this.masterAgreementId + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterAgreementVersion=" + this.masterAgreementVersion +
			'}';
		}
	}
}
