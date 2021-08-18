package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.OtherAgreementMeta;
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
 * A class for defining an agreement executed between parties.
 * @version ${project.version}
 */
@RosettaClass

public interface OtherAgreement extends RosettaModelObject {
	OtherAgreement build();
	OtherAgreement.OtherAgreementBuilder toBuilder();
	
	/**
	 * The date on which the agreement was signed.
	 */
	Date getDate();
	/**
	 * An identifier that has been created to identify the agreement.
	 */
	FieldWithMetaString getIdentifier();
	/**
	 * The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
	 */
	FieldWithMetaString getOtherAgreementType();
	/**
	 * The version of the agreement.
	 */
	FieldWithMetaString getVersion();
	final static OtherAgreementMeta metaData = new OtherAgreementMeta();
	
	@Override
	default RosettaMetaData<? extends OtherAgreement> metaData() {
		return metaData;
	} 
			
	static OtherAgreement.OtherAgreementBuilder builder() {
		return new OtherAgreement.OtherAgreementBuilderImpl();
	}
	
	default Class<? extends OtherAgreement> getType() {
		return OtherAgreement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.class, getIdentifier());
		processRosetta(path.newSubPath("otherAgreementType"), processor, FieldWithMetaString.class, getOtherAgreementType());
		processRosetta(path.newSubPath("version"), processor, FieldWithMetaString.class, getVersion());
	}
	
	
	interface OtherAgreementBuilder extends OtherAgreement, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateIdentifier();
		FieldWithMetaStringBuilder getIdentifier();
		FieldWithMetaStringBuilder getOrCreateOtherAgreementType();
		FieldWithMetaStringBuilder getOtherAgreementType();
		FieldWithMetaStringBuilder getOrCreateVersion();
		FieldWithMetaStringBuilder getVersion();
		OtherAgreement.OtherAgreementBuilder setDate(Date date);
		OtherAgreement.OtherAgreementBuilder setIdentifier(FieldWithMetaString identifier);
		OtherAgreement.OtherAgreementBuilder setIdentifierValue(String identifier);
		OtherAgreement.OtherAgreementBuilder setOtherAgreementType(FieldWithMetaString otherAgreementType);
		OtherAgreement.OtherAgreementBuilder setOtherAgreementTypeValue(String otherAgreementType);
		OtherAgreement.OtherAgreementBuilder setVersion(FieldWithMetaString version);
		OtherAgreement.OtherAgreementBuilder setVersionValue(String version);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaStringBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("otherAgreementType"), processor, FieldWithMetaStringBuilder.class, getOtherAgreementType());
			processRosetta(path.newSubPath("version"), processor, FieldWithMetaStringBuilder.class, getVersion());
		}
		
	}
	
	//OtherAgreement.OtherAgreementImpl
	class OtherAgreementImpl implements OtherAgreement {
		private final Date date;
		private final FieldWithMetaString identifier;
		private final FieldWithMetaString otherAgreementType;
		private final FieldWithMetaString version;
		
		protected OtherAgreementImpl(OtherAgreement.OtherAgreementBuilder builder) {
			this.date = builder.getDate();
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.otherAgreementType = ofNullable(builder.getOtherAgreementType()).map(f->f.build()).orElse(null);
			this.version = ofNullable(builder.getVersion()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Date getDate() {
			return date;
		}
		
		@Override
		public FieldWithMetaString getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaString getOtherAgreementType() {
			return otherAgreementType;
		}
		
		@Override
		public FieldWithMetaString getVersion() {
			return version;
		}
		
		@Override
		public OtherAgreement build() {
			return this;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder toBuilder() {
			OtherAgreement.OtherAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreement.OtherAgreementBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getOtherAgreementType()).ifPresent(builder::setOtherAgreementType);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreement _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(otherAgreementType, _that.getOtherAgreementType())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (otherAgreementType != null ? otherAgreementType.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreement {" +
				"date=" + this.date + ", " +
				"identifier=" + this.identifier + ", " +
				"otherAgreementType=" + this.otherAgreementType + ", " +
				"version=" + this.version +
			'}';
		}
	}
	
	//OtherAgreement.OtherAgreementBuilderImpl
	class OtherAgreementBuilderImpl implements OtherAgreement.OtherAgreementBuilder {
	
		protected Date date;
		protected FieldWithMetaStringBuilder identifier;
		protected FieldWithMetaStringBuilder otherAgreementType;
		protected FieldWithMetaStringBuilder version;
	
		public OtherAgreementBuilderImpl() {
		}
	
		@Override
		public Date getDate() {
			return date;
		}
		
		@Override
		public FieldWithMetaStringBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateIdentifier() {
			FieldWithMetaStringBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOtherAgreementType() {
			return otherAgreementType;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateOtherAgreementType() {
			FieldWithMetaStringBuilder result;
			if (otherAgreementType!=null) {
				result = otherAgreementType;
			}
			else {
				result = otherAgreementType = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getVersion() {
			return version;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateVersion() {
			FieldWithMetaStringBuilder result;
			if (version!=null) {
				result = version;
			}
			else {
				result = version = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public OtherAgreement.OtherAgreementBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		public OtherAgreement.OtherAgreementBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public OtherAgreement.OtherAgreementBuilder setOtherAgreementType(FieldWithMetaString otherAgreementType) {
			this.otherAgreementType = otherAgreementType==null?null:otherAgreementType.toBuilder();
			return this;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder setOtherAgreementTypeValue(String otherAgreementType) {
			this.getOrCreateOtherAgreementType().setValue(otherAgreementType);
			return this;
		}
		@Override
		public OtherAgreement.OtherAgreementBuilder setVersion(FieldWithMetaString version) {
			this.version = version==null?null:version.toBuilder();
			return this;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder setVersionValue(String version) {
			this.getOrCreateVersion().setValue(version);
			return this;
		}
		
		@Override
		public OtherAgreement build() {
			return new OtherAgreement.OtherAgreementImpl(this);
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreement.OtherAgreementBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (otherAgreementType!=null && !otherAgreementType.prune().hasData()) otherAgreementType = null;
			if (version!=null && !version.prune().hasData()) version = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getIdentifier()!=null) return true;
			if (getOtherAgreementType()!=null) return true;
			if (getVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreement.OtherAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreement.OtherAgreementBuilder o = (OtherAgreement.OtherAgreementBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getOtherAgreementType(), o.getOtherAgreementType(), this::setOtherAgreementType);
			merger.mergeRosetta(getVersion(), o.getVersion(), this::setVersion);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreement _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(otherAgreementType, _that.getOtherAgreementType())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (otherAgreementType != null ? otherAgreementType.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementBuilder {" +
				"date=" + this.date + ", " +
				"identifier=" + this.identifier + ", " +
				"otherAgreementType=" + this.otherAgreementType + ", " +
				"version=" + this.version +
			'}';
		}
	}
}
