package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.LegalAgreementTypeMeta;
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
 * A class to specify the type of legal agreement, which is extended by each legal agreement instance, such as the ISDA 2016 CSA for Initial Margin.
 * @version ${project.version}
 */
@RosettaClass

public interface LegalAgreementType extends RosettaModelObject {
	LegalAgreementType build();
	LegalAgreementType.LegalAgreementTypeBuilder toBuilder();
	
	/**
	 * The law governing the legal agreement, e.g. English Law, New York Law or Japanese Law.
	 */
	GoverningLawEnum getGoverningLaw();
	/**
	 * The legal agreement name, e.g. Credit Support Annex for Variation Margin.
	 */
	LegalAgreementNameEnum getName();
	/**
	 * The legal agreement publisher, e.g. ISDA.
	 */
	LegalAgreementPublisherEnum getPublisher();
	/**
	 * In the case where successive definitions of the legal agreement have been developed, the vintage identification. This is typically (but not necessarily) done by referencing the year, e.g. 2013 in the case of the ISDA 2013 Standard Credit Support Annex.
	 */
	Integer getVintage();
	final static LegalAgreementTypeMeta metaData = new LegalAgreementTypeMeta();
	
	@Override
	default RosettaMetaData<? extends LegalAgreementType> metaData() {
		return metaData;
	} 
			
	static LegalAgreementType.LegalAgreementTypeBuilder builder() {
		return new LegalAgreementType.LegalAgreementTypeBuilderImpl();
	}
	
	default Class<? extends LegalAgreementType> getType() {
		return LegalAgreementType.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("governingLaw"), GoverningLawEnum.class, getGoverningLaw(), this);
		processor.processBasic(path.newSubPath("name"), LegalAgreementNameEnum.class, getName(), this);
		processor.processBasic(path.newSubPath("publisher"), LegalAgreementPublisherEnum.class, getPublisher(), this);
		processor.processBasic(path.newSubPath("vintage"), Integer.class, getVintage(), this);
		
	}
	
	
	interface LegalAgreementTypeBuilder extends LegalAgreementType, RosettaModelObjectBuilder {
		LegalAgreementType.LegalAgreementTypeBuilder setGoverningLaw(GoverningLawEnum governingLaw);
		LegalAgreementType.LegalAgreementTypeBuilder setName(LegalAgreementNameEnum name);
		LegalAgreementType.LegalAgreementTypeBuilder setPublisher(LegalAgreementPublisherEnum publisher);
		LegalAgreementType.LegalAgreementTypeBuilder setVintage(Integer vintage);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("governingLaw"), GoverningLawEnum.class, getGoverningLaw(), this);
			processor.processBasic(path.newSubPath("name"), LegalAgreementNameEnum.class, getName(), this);
			processor.processBasic(path.newSubPath("publisher"), LegalAgreementPublisherEnum.class, getPublisher(), this);
			processor.processBasic(path.newSubPath("vintage"), Integer.class, getVintage(), this);
			
		}
		
	}
	
	//LegalAgreementType.LegalAgreementTypeImpl
	class LegalAgreementTypeImpl implements LegalAgreementType {
		private final GoverningLawEnum governingLaw;
		private final LegalAgreementNameEnum name;
		private final LegalAgreementPublisherEnum publisher;
		private final Integer vintage;
		
		protected LegalAgreementTypeImpl(LegalAgreementType.LegalAgreementTypeBuilder builder) {
			this.governingLaw = builder.getGoverningLaw();
			this.name = builder.getName();
			this.publisher = builder.getPublisher();
			this.vintage = builder.getVintage();
		}
		
		@Override
		public GoverningLawEnum getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		public LegalAgreementNameEnum getName() {
			return name;
		}
		
		@Override
		public LegalAgreementPublisherEnum getPublisher() {
			return publisher;
		}
		
		@Override
		public Integer getVintage() {
			return vintage;
		}
		
		@Override
		public LegalAgreementType build() {
			return this;
		}
		
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder toBuilder() {
			LegalAgreementType.LegalAgreementTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalAgreementType.LegalAgreementTypeBuilder builder) {
			ofNullable(getGoverningLaw()).ifPresent(builder::setGoverningLaw);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getPublisher()).ifPresent(builder::setPublisher);
			ofNullable(getVintage()).ifPresent(builder::setVintage);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(publisher, _that.getPublisher())) return false;
			if (!Objects.equals(vintage, _that.getVintage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (governingLaw != null ? governingLaw.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (name != null ? name.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (publisher != null ? publisher.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (vintage != null ? vintage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalAgreementType {" +
				"governingLaw=" + this.governingLaw + ", " +
				"name=" + this.name + ", " +
				"publisher=" + this.publisher + ", " +
				"vintage=" + this.vintage +
			'}';
		}
	}
	
	//LegalAgreementType.LegalAgreementTypeBuilderImpl
	class LegalAgreementTypeBuilderImpl implements LegalAgreementType.LegalAgreementTypeBuilder {
	
		protected GoverningLawEnum governingLaw;
		protected LegalAgreementNameEnum name;
		protected LegalAgreementPublisherEnum publisher;
		protected Integer vintage;
	
		public LegalAgreementTypeBuilderImpl() {
		}
	
		@Override
		public GoverningLawEnum getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		public LegalAgreementNameEnum getName() {
			return name;
		}
		
		@Override
		public LegalAgreementPublisherEnum getPublisher() {
			return publisher;
		}
		
		@Override
		public Integer getVintage() {
			return vintage;
		}
		
	
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder setGoverningLaw(GoverningLawEnum governingLaw) {
			this.governingLaw = governingLaw==null?null:governingLaw;
			return this;
		}
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder setName(LegalAgreementNameEnum name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder setPublisher(LegalAgreementPublisherEnum publisher) {
			this.publisher = publisher==null?null:publisher;
			return this;
		}
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder setVintage(Integer vintage) {
			this.vintage = vintage==null?null:vintage;
			return this;
		}
		
		@Override
		public LegalAgreementType build() {
			return new LegalAgreementType.LegalAgreementTypeImpl(this);
		}
		
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGoverningLaw()!=null) return true;
			if (getName()!=null) return true;
			if (getPublisher()!=null) return true;
			if (getVintage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalAgreementType.LegalAgreementTypeBuilder o = (LegalAgreementType.LegalAgreementTypeBuilder) other;
			
			
			merger.mergeBasic(getGoverningLaw(), o.getGoverningLaw(), this::setGoverningLaw);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getPublisher(), o.getPublisher(), this::setPublisher);
			merger.mergeBasic(getVintage(), o.getVintage(), this::setVintage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(publisher, _that.getPublisher())) return false;
			if (!Objects.equals(vintage, _that.getVintage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (governingLaw != null ? governingLaw.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (name != null ? name.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (publisher != null ? publisher.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (vintage != null ? vintage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalAgreementTypeBuilder {" +
				"governingLaw=" + this.governingLaw + ", " +
				"name=" + this.name + ", " +
				"publisher=" + this.publisher + ", " +
				"vintage=" + this.vintage +
			'}';
		}
	}
}
