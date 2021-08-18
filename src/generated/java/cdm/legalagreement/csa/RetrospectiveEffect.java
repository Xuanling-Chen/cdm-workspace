package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.RetrospectiveEffectMeta;
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
 * A class to specify the retrospective effect exception to the regulatory regime clause of Initial Margin documents as either a normalized value specified as part of an enumeration or a customized value specified of type string.
 * @version ${project.version}
 */
@RosettaClass

public interface RetrospectiveEffect extends RosettaModelObject {
	RetrospectiveEffect build();
	RetrospectiveEffect.RetrospectiveEffectBuilder toBuilder();
	
	/**
	 * The Standard Initial Margin Model exception when specified as a customized approach by the party.
	 */
	String getAsSpecified();
	/**
	 * The Standard Initial Margin Model exception when specified by the party according to one of the enumerated values.
	 */
	ExceptionEnum getStandardisedException();
	final static RetrospectiveEffectMeta metaData = new RetrospectiveEffectMeta();
	
	@Override
	default RosettaMetaData<? extends RetrospectiveEffect> metaData() {
		return metaData;
	} 
			
	static RetrospectiveEffect.RetrospectiveEffectBuilder builder() {
		return new RetrospectiveEffect.RetrospectiveEffectBuilderImpl();
	}
	
	default Class<? extends RetrospectiveEffect> getType() {
		return RetrospectiveEffect.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
		processor.processBasic(path.newSubPath("standardisedException"), ExceptionEnum.class, getStandardisedException(), this);
		
	}
	
	
	interface RetrospectiveEffectBuilder extends RetrospectiveEffect, RosettaModelObjectBuilder {
		RetrospectiveEffect.RetrospectiveEffectBuilder setAsSpecified(String asSpecified);
		RetrospectiveEffect.RetrospectiveEffectBuilder setStandardisedException(ExceptionEnum standardisedException);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
			processor.processBasic(path.newSubPath("standardisedException"), ExceptionEnum.class, getStandardisedException(), this);
			
		}
		
	}
	
	//RetrospectiveEffect.RetrospectiveEffectImpl
	class RetrospectiveEffectImpl implements RetrospectiveEffect {
		private final String asSpecified;
		private final ExceptionEnum standardisedException;
		
		protected RetrospectiveEffectImpl(RetrospectiveEffect.RetrospectiveEffectBuilder builder) {
			this.asSpecified = builder.getAsSpecified();
			this.standardisedException = builder.getStandardisedException();
		}
		
		@Override
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public ExceptionEnum getStandardisedException() {
			return standardisedException;
		}
		
		@Override
		public RetrospectiveEffect build() {
			return this;
		}
		
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder toBuilder() {
			RetrospectiveEffect.RetrospectiveEffectBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RetrospectiveEffect.RetrospectiveEffectBuilder builder) {
			ofNullable(getAsSpecified()).ifPresent(builder::setAsSpecified);
			ofNullable(getStandardisedException()).ifPresent(builder::setStandardisedException);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RetrospectiveEffect _that = getType().cast(o);
		
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(standardisedException, _that.getStandardisedException())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (standardisedException != null ? standardisedException.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrospectiveEffect {" +
				"asSpecified=" + this.asSpecified + ", " +
				"standardisedException=" + this.standardisedException +
			'}';
		}
	}
	
	//RetrospectiveEffect.RetrospectiveEffectBuilderImpl
	class RetrospectiveEffectBuilderImpl implements RetrospectiveEffect.RetrospectiveEffectBuilder {
	
		protected String asSpecified;
		protected ExceptionEnum standardisedException;
	
		public RetrospectiveEffectBuilderImpl() {
		}
	
		@Override
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public ExceptionEnum getStandardisedException() {
			return standardisedException;
		}
		
	
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder setAsSpecified(String asSpecified) {
			this.asSpecified = asSpecified==null?null:asSpecified;
			return this;
		}
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder setStandardisedException(ExceptionEnum standardisedException) {
			this.standardisedException = standardisedException==null?null:standardisedException;
			return this;
		}
		
		@Override
		public RetrospectiveEffect build() {
			return new RetrospectiveEffect.RetrospectiveEffectImpl(this);
		}
		
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsSpecified()!=null) return true;
			if (getStandardisedException()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RetrospectiveEffect.RetrospectiveEffectBuilder o = (RetrospectiveEffect.RetrospectiveEffectBuilder) other;
			
			
			merger.mergeBasic(getAsSpecified(), o.getAsSpecified(), this::setAsSpecified);
			merger.mergeBasic(getStandardisedException(), o.getStandardisedException(), this::setStandardisedException);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RetrospectiveEffect _that = getType().cast(o);
		
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(standardisedException, _that.getStandardisedException())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (standardisedException != null ? standardisedException.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrospectiveEffectBuilder {" +
				"asSpecified=" + this.asSpecified + ", " +
				"standardisedException=" + this.standardisedException +
			'}';
		}
	}
}
