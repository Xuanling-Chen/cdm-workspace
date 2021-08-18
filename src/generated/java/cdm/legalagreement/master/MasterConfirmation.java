package cdm.legalagreement.master;

import cdm.legalagreement.master.meta.MasterConfirmationMeta;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationTypeEnum;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class for defining the master confirmation agreement executed between the parties.
 * @version ${project.version}
 */
@RosettaClass

public interface MasterConfirmation extends RosettaModelObject {
	MasterConfirmation build();
	MasterConfirmation.MasterConfirmationBuilder toBuilder();
	
	/**
	 * The date that an annex to the master confirmation was executed between the parties.
	 */
	Date getMasterConfirmationAnnexDate();
	/**
	 * The type of master confirmation annex executed between the parties.
	 */
	FieldWithMetaMasterConfirmationAnnexTypeEnum getMasterConfirmationAnnexType();
	/**
	 * The date of the confirmation executed between the parties and intended to govern all relevant transactions between those parties.
	 */
	Date getMasterConfirmationDate();
	/**
	 * The type of master confirmation executed between the parties.
	 */
	FieldWithMetaMasterConfirmationTypeEnum getMasterConfirmationType();
	final static MasterConfirmationMeta metaData = new MasterConfirmationMeta();
	
	@Override
	default RosettaMetaData<? extends MasterConfirmation> metaData() {
		return metaData;
	} 
			
	static MasterConfirmation.MasterConfirmationBuilder builder() {
		return new MasterConfirmation.MasterConfirmationBuilderImpl();
	}
	
	default Class<? extends MasterConfirmation> getType() {
		return MasterConfirmation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("masterConfirmationAnnexDate"), Date.class, getMasterConfirmationAnnexDate(), this);
		processor.processBasic(path.newSubPath("masterConfirmationDate"), Date.class, getMasterConfirmationDate(), this);
		
		processRosetta(path.newSubPath("masterConfirmationAnnexType"), processor, FieldWithMetaMasterConfirmationAnnexTypeEnum.class, getMasterConfirmationAnnexType());
		processRosetta(path.newSubPath("masterConfirmationType"), processor, FieldWithMetaMasterConfirmationTypeEnum.class, getMasterConfirmationType());
	}
	
	
	interface MasterConfirmationBuilder extends MasterConfirmation, RosettaModelObjectBuilder {
		FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder getOrCreateMasterConfirmationAnnexType();
		FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder getMasterConfirmationAnnexType();
		FieldWithMetaMasterConfirmationTypeEnumBuilder getOrCreateMasterConfirmationType();
		FieldWithMetaMasterConfirmationTypeEnumBuilder getMasterConfirmationType();
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexDate(Date masterConfirmationAnnexDate);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexType(FieldWithMetaMasterConfirmationAnnexTypeEnum masterConfirmationAnnexType);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexTypeValue(MasterConfirmationAnnexTypeEnum masterConfirmationAnnexType);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationDate(Date masterConfirmationDate);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationType(FieldWithMetaMasterConfirmationTypeEnum masterConfirmationType);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationTypeValue(MasterConfirmationTypeEnum masterConfirmationType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("masterConfirmationAnnexDate"), Date.class, getMasterConfirmationAnnexDate(), this);
			processor.processBasic(path.newSubPath("masterConfirmationDate"), Date.class, getMasterConfirmationDate(), this);
			
			processRosetta(path.newSubPath("masterConfirmationAnnexType"), processor, FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder.class, getMasterConfirmationAnnexType());
			processRosetta(path.newSubPath("masterConfirmationType"), processor, FieldWithMetaMasterConfirmationTypeEnumBuilder.class, getMasterConfirmationType());
		}
		
	}
	
	//MasterConfirmation.MasterConfirmationImpl
	class MasterConfirmationImpl implements MasterConfirmation {
		private final Date masterConfirmationAnnexDate;
		private final FieldWithMetaMasterConfirmationAnnexTypeEnum masterConfirmationAnnexType;
		private final Date masterConfirmationDate;
		private final FieldWithMetaMasterConfirmationTypeEnum masterConfirmationType;
		
		protected MasterConfirmationImpl(MasterConfirmation.MasterConfirmationBuilder builder) {
			this.masterConfirmationAnnexDate = builder.getMasterConfirmationAnnexDate();
			this.masterConfirmationAnnexType = ofNullable(builder.getMasterConfirmationAnnexType()).map(f->f.build()).orElse(null);
			this.masterConfirmationDate = builder.getMasterConfirmationDate();
			this.masterConfirmationType = ofNullable(builder.getMasterConfirmationType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Date getMasterConfirmationAnnexDate() {
			return masterConfirmationAnnexDate;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnum getMasterConfirmationAnnexType() {
			return masterConfirmationAnnexType;
		}
		
		@Override
		public Date getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationTypeEnum getMasterConfirmationType() {
			return masterConfirmationType;
		}
		
		@Override
		public MasterConfirmation build() {
			return this;
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder toBuilder() {
			MasterConfirmation.MasterConfirmationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterConfirmation.MasterConfirmationBuilder builder) {
			ofNullable(getMasterConfirmationAnnexDate()).ifPresent(builder::setMasterConfirmationAnnexDate);
			ofNullable(getMasterConfirmationAnnexType()).ifPresent(builder::setMasterConfirmationAnnexType);
			ofNullable(getMasterConfirmationDate()).ifPresent(builder::setMasterConfirmationDate);
			ofNullable(getMasterConfirmationType()).ifPresent(builder::setMasterConfirmationType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(masterConfirmationAnnexDate, _that.getMasterConfirmationAnnexDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexType, _that.getMasterConfirmationAnnexType())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!Objects.equals(masterConfirmationType, _that.getMasterConfirmationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterConfirmationAnnexDate != null ? masterConfirmationAnnexDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexType != null ? masterConfirmationAnnexType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationType != null ? masterConfirmationType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmation {" +
				"masterConfirmationAnnexDate=" + this.masterConfirmationAnnexDate + ", " +
				"masterConfirmationAnnexType=" + this.masterConfirmationAnnexType + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"masterConfirmationType=" + this.masterConfirmationType +
			'}';
		}
	}
	
	//MasterConfirmation.MasterConfirmationBuilderImpl
	class MasterConfirmationBuilderImpl implements MasterConfirmation.MasterConfirmationBuilder {
	
		protected Date masterConfirmationAnnexDate;
		protected FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder masterConfirmationAnnexType;
		protected Date masterConfirmationDate;
		protected FieldWithMetaMasterConfirmationTypeEnumBuilder masterConfirmationType;
	
		public MasterConfirmationBuilderImpl() {
		}
	
		@Override
		public Date getMasterConfirmationAnnexDate() {
			return masterConfirmationAnnexDate;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder getMasterConfirmationAnnexType() {
			return masterConfirmationAnnexType;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder getOrCreateMasterConfirmationAnnexType() {
			FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder result;
			if (masterConfirmationAnnexType!=null) {
				result = masterConfirmationAnnexType;
			}
			else {
				result = masterConfirmationAnnexType = FieldWithMetaMasterConfirmationAnnexTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationTypeEnumBuilder getMasterConfirmationType() {
			return masterConfirmationType;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationTypeEnumBuilder getOrCreateMasterConfirmationType() {
			FieldWithMetaMasterConfirmationTypeEnumBuilder result;
			if (masterConfirmationType!=null) {
				result = masterConfirmationType;
			}
			else {
				result = masterConfirmationType = FieldWithMetaMasterConfirmationTypeEnum.builder();
			}
			
			return result;
		}
		
	
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexDate(Date masterConfirmationAnnexDate) {
			this.masterConfirmationAnnexDate = masterConfirmationAnnexDate==null?null:masterConfirmationAnnexDate;
			return this;
		}
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexType(FieldWithMetaMasterConfirmationAnnexTypeEnum masterConfirmationAnnexType) {
			this.masterConfirmationAnnexType = masterConfirmationAnnexType==null?null:masterConfirmationAnnexType.toBuilder();
			return this;
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexTypeValue(MasterConfirmationAnnexTypeEnum masterConfirmationAnnexType) {
			this.getOrCreateMasterConfirmationAnnexType().setValue(masterConfirmationAnnexType);
			return this;
		}
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationDate(Date masterConfirmationDate) {
			this.masterConfirmationDate = masterConfirmationDate==null?null:masterConfirmationDate;
			return this;
		}
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationType(FieldWithMetaMasterConfirmationTypeEnum masterConfirmationType) {
			this.masterConfirmationType = masterConfirmationType==null?null:masterConfirmationType.toBuilder();
			return this;
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationTypeValue(MasterConfirmationTypeEnum masterConfirmationType) {
			this.getOrCreateMasterConfirmationType().setValue(masterConfirmationType);
			return this;
		}
		
		@Override
		public MasterConfirmation build() {
			return new MasterConfirmation.MasterConfirmationImpl(this);
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder prune() {
			if (masterConfirmationAnnexType!=null && !masterConfirmationAnnexType.prune().hasData()) masterConfirmationAnnexType = null;
			if (masterConfirmationType!=null && !masterConfirmationType.prune().hasData()) masterConfirmationType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMasterConfirmationAnnexDate()!=null) return true;
			if (getMasterConfirmationAnnexType()!=null) return true;
			if (getMasterConfirmationDate()!=null) return true;
			if (getMasterConfirmationType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterConfirmation.MasterConfirmationBuilder o = (MasterConfirmation.MasterConfirmationBuilder) other;
			
			merger.mergeRosetta(getMasterConfirmationAnnexType(), o.getMasterConfirmationAnnexType(), this::setMasterConfirmationAnnexType);
			merger.mergeRosetta(getMasterConfirmationType(), o.getMasterConfirmationType(), this::setMasterConfirmationType);
			
			merger.mergeBasic(getMasterConfirmationAnnexDate(), o.getMasterConfirmationAnnexDate(), this::setMasterConfirmationAnnexDate);
			merger.mergeBasic(getMasterConfirmationDate(), o.getMasterConfirmationDate(), this::setMasterConfirmationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(masterConfirmationAnnexDate, _that.getMasterConfirmationAnnexDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexType, _that.getMasterConfirmationAnnexType())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!Objects.equals(masterConfirmationType, _that.getMasterConfirmationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterConfirmationAnnexDate != null ? masterConfirmationAnnexDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexType != null ? masterConfirmationAnnexType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationType != null ? masterConfirmationType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmationBuilder {" +
				"masterConfirmationAnnexDate=" + this.masterConfirmationAnnexDate + ", " +
				"masterConfirmationAnnexType=" + this.masterConfirmationAnnexType + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"masterConfirmationType=" + this.masterConfirmationType +
			'}';
		}
	}
}
