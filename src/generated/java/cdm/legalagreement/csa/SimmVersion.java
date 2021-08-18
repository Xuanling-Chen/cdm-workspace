package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.SimmVersionMeta;
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
 * A class to specify the ISDA SIMM version that applies to the ISDA 2018 CSA for Initial Margin. According to the ISDA 2018 CSA for Initial Margin, Paragraph 13, General Principles (ee) (1) provisions, the SIMM version is either not specified, or references a version used by one of the parties to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface SimmVersion extends RosettaModelObject {
	SimmVersion build();
	SimmVersion.SimmVersionBuilder toBuilder();
	
	/**
	 * The SIMM version exception when specified as a customized approach by the party.
	 */
	String getAsSpecified();
	/**
	 * A boolean attribute to determine whether the SIMM version is specified for the purpose of the legal agreement.
	 */
	Boolean getIsSpecified();
	/**
	 * The party which the specified SIMM version applies to.
	 */
	CounterpartyRoleEnum getPartyVersion();
	final static SimmVersionMeta metaData = new SimmVersionMeta();
	
	@Override
	default RosettaMetaData<? extends SimmVersion> metaData() {
		return metaData;
	} 
			
	static SimmVersion.SimmVersionBuilder builder() {
		return new SimmVersion.SimmVersionBuilderImpl();
	}
	
	default Class<? extends SimmVersion> getType() {
		return SimmVersion.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
		processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
		processor.processBasic(path.newSubPath("partyVersion"), CounterpartyRoleEnum.class, getPartyVersion(), this);
		
	}
	
	
	interface SimmVersionBuilder extends SimmVersion, RosettaModelObjectBuilder {
		SimmVersion.SimmVersionBuilder setAsSpecified(String asSpecified);
		SimmVersion.SimmVersionBuilder setIsSpecified(Boolean isSpecified);
		SimmVersion.SimmVersionBuilder setPartyVersion(CounterpartyRoleEnum partyVersion);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
			processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
			processor.processBasic(path.newSubPath("partyVersion"), CounterpartyRoleEnum.class, getPartyVersion(), this);
			
		}
		
	}
	
	//SimmVersion.SimmVersionImpl
	class SimmVersionImpl implements SimmVersion {
		private final String asSpecified;
		private final Boolean isSpecified;
		private final CounterpartyRoleEnum partyVersion;
		
		protected SimmVersionImpl(SimmVersion.SimmVersionBuilder builder) {
			this.asSpecified = builder.getAsSpecified();
			this.isSpecified = builder.getIsSpecified();
			this.partyVersion = builder.getPartyVersion();
		}
		
		@Override
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		public CounterpartyRoleEnum getPartyVersion() {
			return partyVersion;
		}
		
		@Override
		public SimmVersion build() {
			return this;
		}
		
		@Override
		public SimmVersion.SimmVersionBuilder toBuilder() {
			SimmVersion.SimmVersionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimmVersion.SimmVersionBuilder builder) {
			ofNullable(getAsSpecified()).ifPresent(builder::setAsSpecified);
			ofNullable(getIsSpecified()).ifPresent(builder::setIsSpecified);
			ofNullable(getPartyVersion()).ifPresent(builder::setPartyVersion);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmVersion _that = getType().cast(o);
		
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(partyVersion, _that.getPartyVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (partyVersion != null ? partyVersion.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimmVersion {" +
				"asSpecified=" + this.asSpecified + ", " +
				"isSpecified=" + this.isSpecified + ", " +
				"partyVersion=" + this.partyVersion +
			'}';
		}
	}
	
	//SimmVersion.SimmVersionBuilderImpl
	class SimmVersionBuilderImpl implements SimmVersion.SimmVersionBuilder {
	
		protected String asSpecified;
		protected Boolean isSpecified;
		protected CounterpartyRoleEnum partyVersion;
	
		public SimmVersionBuilderImpl() {
		}
	
		@Override
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		public CounterpartyRoleEnum getPartyVersion() {
			return partyVersion;
		}
		
	
		@Override
		public SimmVersion.SimmVersionBuilder setAsSpecified(String asSpecified) {
			this.asSpecified = asSpecified==null?null:asSpecified;
			return this;
		}
		@Override
		public SimmVersion.SimmVersionBuilder setIsSpecified(Boolean isSpecified) {
			this.isSpecified = isSpecified==null?null:isSpecified;
			return this;
		}
		@Override
		public SimmVersion.SimmVersionBuilder setPartyVersion(CounterpartyRoleEnum partyVersion) {
			this.partyVersion = partyVersion==null?null:partyVersion;
			return this;
		}
		
		@Override
		public SimmVersion build() {
			return new SimmVersion.SimmVersionImpl(this);
		}
		
		@Override
		public SimmVersion.SimmVersionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmVersion.SimmVersionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsSpecified()!=null) return true;
			if (getIsSpecified()!=null) return true;
			if (getPartyVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmVersion.SimmVersionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SimmVersion.SimmVersionBuilder o = (SimmVersion.SimmVersionBuilder) other;
			
			
			merger.mergeBasic(getAsSpecified(), o.getAsSpecified(), this::setAsSpecified);
			merger.mergeBasic(getIsSpecified(), o.getIsSpecified(), this::setIsSpecified);
			merger.mergeBasic(getPartyVersion(), o.getPartyVersion(), this::setPartyVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmVersion _that = getType().cast(o);
		
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(partyVersion, _that.getPartyVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (partyVersion != null ? partyVersion.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimmVersionBuilder {" +
				"asSpecified=" + this.asSpecified + ", " +
				"isSpecified=" + this.isSpecified + ", " +
				"partyVersion=" + this.partyVersion +
			'}';
		}
	}
}
