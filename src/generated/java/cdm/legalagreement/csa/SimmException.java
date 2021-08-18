package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.SimmExceptionMeta;
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
 * A class to specify the SIMM exception to the regulatory regime clause of the ISDA 2016 and 2018 CSA for Initial Margin as either a normalized value specified as part of an enumeration or a customized value specified of type string. ISDA 2016 Credit Support Annex for Initial Margin paragraph 13, Regime: SIMM Exception.
 * @version ${project.version}
 */
@RosettaClass

public interface SimmException extends RosettaModelObject {
	SimmException build();
	SimmException.SimmExceptionBuilder toBuilder();
	
	/**
	 * The Standard Initial Margin Model exception when specified as a customized approach by the party.
	 */
	String getAsSpecified();
	/**
	 * The Standard Initial Margin model exception approach applicable when specified by the party according to one of the enumerated values.
	 */
	SimmExceptionApplicableEnum getSimmExceptionApplicable();
	/**
	 * The Standard Initial Margin Model exception when specified by the party according to one of the enumerated values.
	 */
	ExceptionEnum getStandardisedException();
	final static SimmExceptionMeta metaData = new SimmExceptionMeta();
	
	@Override
	default RosettaMetaData<? extends SimmException> metaData() {
		return metaData;
	} 
			
	static SimmException.SimmExceptionBuilder builder() {
		return new SimmException.SimmExceptionBuilderImpl();
	}
	
	default Class<? extends SimmException> getType() {
		return SimmException.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
		processor.processBasic(path.newSubPath("simmExceptionApplicable"), SimmExceptionApplicableEnum.class, getSimmExceptionApplicable(), this);
		processor.processBasic(path.newSubPath("standardisedException"), ExceptionEnum.class, getStandardisedException(), this);
		
	}
	
	
	interface SimmExceptionBuilder extends SimmException, RosettaModelObjectBuilder {
		SimmException.SimmExceptionBuilder setAsSpecified(String asSpecified);
		SimmException.SimmExceptionBuilder setSimmExceptionApplicable(SimmExceptionApplicableEnum simmExceptionApplicable);
		SimmException.SimmExceptionBuilder setStandardisedException(ExceptionEnum standardisedException);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
			processor.processBasic(path.newSubPath("simmExceptionApplicable"), SimmExceptionApplicableEnum.class, getSimmExceptionApplicable(), this);
			processor.processBasic(path.newSubPath("standardisedException"), ExceptionEnum.class, getStandardisedException(), this);
			
		}
		
	}
	
	//SimmException.SimmExceptionImpl
	class SimmExceptionImpl implements SimmException {
		private final String asSpecified;
		private final SimmExceptionApplicableEnum simmExceptionApplicable;
		private final ExceptionEnum standardisedException;
		
		protected SimmExceptionImpl(SimmException.SimmExceptionBuilder builder) {
			this.asSpecified = builder.getAsSpecified();
			this.simmExceptionApplicable = builder.getSimmExceptionApplicable();
			this.standardisedException = builder.getStandardisedException();
		}
		
		@Override
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public SimmExceptionApplicableEnum getSimmExceptionApplicable() {
			return simmExceptionApplicable;
		}
		
		@Override
		public ExceptionEnum getStandardisedException() {
			return standardisedException;
		}
		
		@Override
		public SimmException build() {
			return this;
		}
		
		@Override
		public SimmException.SimmExceptionBuilder toBuilder() {
			SimmException.SimmExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimmException.SimmExceptionBuilder builder) {
			ofNullable(getAsSpecified()).ifPresent(builder::setAsSpecified);
			ofNullable(getSimmExceptionApplicable()).ifPresent(builder::setSimmExceptionApplicable);
			ofNullable(getStandardisedException()).ifPresent(builder::setStandardisedException);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmException _that = getType().cast(o);
		
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(simmExceptionApplicable, _that.getSimmExceptionApplicable())) return false;
			if (!Objects.equals(standardisedException, _that.getStandardisedException())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (simmExceptionApplicable != null ? simmExceptionApplicable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (standardisedException != null ? standardisedException.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimmException {" +
				"asSpecified=" + this.asSpecified + ", " +
				"simmExceptionApplicable=" + this.simmExceptionApplicable + ", " +
				"standardisedException=" + this.standardisedException +
			'}';
		}
	}
	
	//SimmException.SimmExceptionBuilderImpl
	class SimmExceptionBuilderImpl implements SimmException.SimmExceptionBuilder {
	
		protected String asSpecified;
		protected SimmExceptionApplicableEnum simmExceptionApplicable;
		protected ExceptionEnum standardisedException;
	
		public SimmExceptionBuilderImpl() {
		}
	
		@Override
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public SimmExceptionApplicableEnum getSimmExceptionApplicable() {
			return simmExceptionApplicable;
		}
		
		@Override
		public ExceptionEnum getStandardisedException() {
			return standardisedException;
		}
		
	
		@Override
		public SimmException.SimmExceptionBuilder setAsSpecified(String asSpecified) {
			this.asSpecified = asSpecified==null?null:asSpecified;
			return this;
		}
		@Override
		public SimmException.SimmExceptionBuilder setSimmExceptionApplicable(SimmExceptionApplicableEnum simmExceptionApplicable) {
			this.simmExceptionApplicable = simmExceptionApplicable==null?null:simmExceptionApplicable;
			return this;
		}
		@Override
		public SimmException.SimmExceptionBuilder setStandardisedException(ExceptionEnum standardisedException) {
			this.standardisedException = standardisedException==null?null:standardisedException;
			return this;
		}
		
		@Override
		public SimmException build() {
			return new SimmException.SimmExceptionImpl(this);
		}
		
		@Override
		public SimmException.SimmExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmException.SimmExceptionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsSpecified()!=null) return true;
			if (getSimmExceptionApplicable()!=null) return true;
			if (getStandardisedException()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmException.SimmExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SimmException.SimmExceptionBuilder o = (SimmException.SimmExceptionBuilder) other;
			
			
			merger.mergeBasic(getAsSpecified(), o.getAsSpecified(), this::setAsSpecified);
			merger.mergeBasic(getSimmExceptionApplicable(), o.getSimmExceptionApplicable(), this::setSimmExceptionApplicable);
			merger.mergeBasic(getStandardisedException(), o.getStandardisedException(), this::setStandardisedException);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmException _that = getType().cast(o);
		
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(simmExceptionApplicable, _that.getSimmExceptionApplicable())) return false;
			if (!Objects.equals(standardisedException, _that.getStandardisedException())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (simmExceptionApplicable != null ? simmExceptionApplicable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (standardisedException != null ? standardisedException.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimmExceptionBuilder {" +
				"asSpecified=" + this.asSpecified + ", " +
				"simmExceptionApplicable=" + this.simmExceptionApplicable + ", " +
				"standardisedException=" + this.standardisedException +
			'}';
		}
	}
}
