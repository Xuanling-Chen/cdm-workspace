package cdm.legalagreement.common;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilderImpl;
import cdm.base.staticdata.party.LegalEntity.LegalEntityImpl;
import cdm.legalagreement.common.meta.UmbrellaAgreementEntityMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the legal entities that are part of the umbrella agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface UmbrellaAgreementEntity extends LegalEntity {
	UmbrellaAgreementEntity build();
	UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder toBuilder();
	
	/**
	 * The terms that might be associated with each party to the umbrella agreement.
	 */
	String getTerms();
	final static UmbrellaAgreementEntityMeta metaData = new UmbrellaAgreementEntityMeta();
	
	@Override
	default RosettaMetaData<? extends UmbrellaAgreementEntity> metaData() {
		return metaData;
	} 
			
	static UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder builder() {
		return new UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilderImpl();
	}
	
	default Class<? extends UmbrellaAgreementEntity> getType() {
		return UmbrellaAgreementEntity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.party.LegalEntity.super.process(path, processor);
		processor.processBasic(path.newSubPath("terms"), String.class, getTerms(), this);
		
	}
	
	
	interface UmbrellaAgreementEntityBuilder extends UmbrellaAgreementEntity, LegalEntity.LegalEntityBuilder, RosettaModelObjectBuilder {
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setTerms(String terms);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(FieldWithMetaString entityId);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(FieldWithMetaString entityId, int _idx);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(String entityId);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(String entityId, int _idx);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(List<? extends FieldWithMetaString> entityId);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setEntityId(List<? extends FieldWithMetaString> entityId);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(List<? extends String> entityId);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setEntityIdValue(List<? extends String> entityId);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setMeta(MetaFields meta);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setName(FieldWithMetaString name);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setNameValue(String name);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			LegalEntity.LegalEntityBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("terms"), String.class, getTerms(), this);
			
		}
		
	}
	
	//UmbrellaAgreementEntity.UmbrellaAgreementEntityImpl
	class UmbrellaAgreementEntityImpl extends LegalEntity.LegalEntityImpl implements UmbrellaAgreementEntity {
		private final String terms;
		
		protected UmbrellaAgreementEntityImpl(UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder builder) {
			super(builder);
			this.terms = builder.getTerms();
		}
		
		@Override
		public String getTerms() {
			return terms;
		}
		
		@Override
		public UmbrellaAgreementEntity build() {
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder toBuilder() {
			UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTerms()).ifPresent(builder::setTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UmbrellaAgreementEntity _that = getType().cast(o);
		
			if (!Objects.equals(terms, _that.getTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (terms != null ? terms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UmbrellaAgreementEntity {" +
				"terms=" + this.terms +
			'}' + " " + super.toString();
		}
	}
	
	//UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilderImpl
	class UmbrellaAgreementEntityBuilderImpl extends LegalEntity.LegalEntityBuilderImpl  implements UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder {
	
		protected String terms;
	
		public UmbrellaAgreementEntityBuilderImpl() {
		}
	
		@Override
		public String getTerms() {
			return terms;
		}
		
	
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setTerms(String terms) {
			this.terms = terms==null?null:terms;
			return this;
		}
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(FieldWithMetaString entityId) {
			if (entityId!=null) this.entityId.add(entityId.toBuilder());
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(FieldWithMetaString entityId, int _idx) {
			getIndex(this.entityId, _idx, () -> entityId.toBuilder());
			return this;
		}
		
			@Override
			public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(String entityId) {
				this.getOrCreateEntityId(-1).setValue(entityId);
				return this;
			}
			
			@Override
			public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(String entityId, int _idx) {
				this.getOrCreateEntityId(_idx).setValue(entityId);
				return this;
			}
		@Override 
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(List<? extends FieldWithMetaString> entityIds) {
			if (entityIds != null) {
				for (FieldWithMetaString toAdd : entityIds) {
					this.entityId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setEntityId(List<? extends FieldWithMetaString> entityIds) {
			if (entityIds == null)  {
				this.entityId = new ArrayList<>();
			}
			else {
				this.entityId = entityIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(List<? extends String> entityIds) {
			if (entityIds != null) {
				for (String toAdd : entityIds) {
					this.addEntityIdValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setEntityIdValue(List<? extends String> entityIds) {
			this.entityId.clear();
			if (entityIds!=null) {
				entityIds.forEach(this::addEntityIdValue);
			}
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setName(FieldWithMetaString name) {
			this.name = name==null?null:name.toBuilder();
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setNameValue(String name) {
			this.getOrCreateName().setValue(name);
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity build() {
			return new UmbrellaAgreementEntity.UmbrellaAgreementEntityImpl(this);
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder o = (UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder) other;
			
			
			merger.mergeBasic(getTerms(), o.getTerms(), this::setTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UmbrellaAgreementEntity _that = getType().cast(o);
		
			if (!Objects.equals(terms, _that.getTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (terms != null ? terms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UmbrellaAgreementEntityBuilder {" +
				"terms=" + this.terms +
			'}' + " " + super.toString();
		}
	}
}
