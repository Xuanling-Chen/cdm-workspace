package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ExecutionTermsMeta;
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
 * A class to specify execution location and language of execution to determine duty to be paid.
 * @version ${project.version}
 */
@RosettaClass

public interface ExecutionTerms extends RosettaModelObject {
	ExecutionTerms build();
	ExecutionTerms.ExecutionTermsBuilder toBuilder();
	
	/**
	 * The bespoke execution language election.
	 */
	ExecutionLanguage getExecutionLanguage();
	/**
	 * The bespoke execution location election.
	 */
	ExecutionLocation getExecutionLocation();
	final static ExecutionTermsMeta metaData = new ExecutionTermsMeta();
	
	@Override
	default RosettaMetaData<? extends ExecutionTerms> metaData() {
		return metaData;
	} 
			
	static ExecutionTerms.ExecutionTermsBuilder builder() {
		return new ExecutionTerms.ExecutionTermsBuilderImpl();
	}
	
	default Class<? extends ExecutionTerms> getType() {
		return ExecutionTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("executionLanguage"), processor, ExecutionLanguage.class, getExecutionLanguage());
		processRosetta(path.newSubPath("executionLocation"), processor, ExecutionLocation.class, getExecutionLocation());
	}
	
	
	interface ExecutionTermsBuilder extends ExecutionTerms, RosettaModelObjectBuilder {
		ExecutionLanguage.ExecutionLanguageBuilder getOrCreateExecutionLanguage();
		ExecutionLanguage.ExecutionLanguageBuilder getExecutionLanguage();
		ExecutionLocation.ExecutionLocationBuilder getOrCreateExecutionLocation();
		ExecutionLocation.ExecutionLocationBuilder getExecutionLocation();
		ExecutionTerms.ExecutionTermsBuilder setExecutionLanguage(ExecutionLanguage executionLanguage);
		ExecutionTerms.ExecutionTermsBuilder setExecutionLocation(ExecutionLocation executionLocation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("executionLanguage"), processor, ExecutionLanguage.ExecutionLanguageBuilder.class, getExecutionLanguage());
			processRosetta(path.newSubPath("executionLocation"), processor, ExecutionLocation.ExecutionLocationBuilder.class, getExecutionLocation());
		}
		
	}
	
	//ExecutionTerms.ExecutionTermsImpl
	class ExecutionTermsImpl implements ExecutionTerms {
		private final ExecutionLanguage executionLanguage;
		private final ExecutionLocation executionLocation;
		
		protected ExecutionTermsImpl(ExecutionTerms.ExecutionTermsBuilder builder) {
			this.executionLanguage = ofNullable(builder.getExecutionLanguage()).map(f->f.build()).orElse(null);
			this.executionLocation = ofNullable(builder.getExecutionLocation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ExecutionLanguage getExecutionLanguage() {
			return executionLanguage;
		}
		
		@Override
		public ExecutionLocation getExecutionLocation() {
			return executionLocation;
		}
		
		@Override
		public ExecutionTerms build() {
			return this;
		}
		
		@Override
		public ExecutionTerms.ExecutionTermsBuilder toBuilder() {
			ExecutionTerms.ExecutionTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionTerms.ExecutionTermsBuilder builder) {
			ofNullable(getExecutionLanguage()).ifPresent(builder::setExecutionLanguage);
			ofNullable(getExecutionLocation()).ifPresent(builder::setExecutionLocation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionTerms _that = getType().cast(o);
		
			if (!Objects.equals(executionLanguage, _that.getExecutionLanguage())) return false;
			if (!Objects.equals(executionLocation, _that.getExecutionLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionLanguage != null ? executionLanguage.hashCode() : 0);
			_result = 31 * _result + (executionLocation != null ? executionLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionTerms {" +
				"executionLanguage=" + this.executionLanguage + ", " +
				"executionLocation=" + this.executionLocation +
			'}';
		}
	}
	
	//ExecutionTerms.ExecutionTermsBuilderImpl
	class ExecutionTermsBuilderImpl implements ExecutionTerms.ExecutionTermsBuilder {
	
		protected ExecutionLanguage.ExecutionLanguageBuilder executionLanguage;
		protected ExecutionLocation.ExecutionLocationBuilder executionLocation;
	
		public ExecutionTermsBuilderImpl() {
		}
	
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder getExecutionLanguage() {
			return executionLanguage;
		}
		
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder getOrCreateExecutionLanguage() {
			ExecutionLanguage.ExecutionLanguageBuilder result;
			if (executionLanguage!=null) {
				result = executionLanguage;
			}
			else {
				result = executionLanguage = ExecutionLanguage.builder();
			}
			
			return result;
		}
		
		@Override
		public ExecutionLocation.ExecutionLocationBuilder getExecutionLocation() {
			return executionLocation;
		}
		
		@Override
		public ExecutionLocation.ExecutionLocationBuilder getOrCreateExecutionLocation() {
			ExecutionLocation.ExecutionLocationBuilder result;
			if (executionLocation!=null) {
				result = executionLocation;
			}
			else {
				result = executionLocation = ExecutionLocation.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ExecutionTerms.ExecutionTermsBuilder setExecutionLanguage(ExecutionLanguage executionLanguage) {
			this.executionLanguage = executionLanguage==null?null:executionLanguage.toBuilder();
			return this;
		}
		@Override
		public ExecutionTerms.ExecutionTermsBuilder setExecutionLocation(ExecutionLocation executionLocation) {
			this.executionLocation = executionLocation==null?null:executionLocation.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionTerms build() {
			return new ExecutionTerms.ExecutionTermsImpl(this);
		}
		
		@Override
		public ExecutionTerms.ExecutionTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionTerms.ExecutionTermsBuilder prune() {
			if (executionLanguage!=null && !executionLanguage.prune().hasData()) executionLanguage = null;
			if (executionLocation!=null && !executionLocation.prune().hasData()) executionLocation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExecutionLanguage()!=null && getExecutionLanguage().hasData()) return true;
			if (getExecutionLocation()!=null && getExecutionLocation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionTerms.ExecutionTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionTerms.ExecutionTermsBuilder o = (ExecutionTerms.ExecutionTermsBuilder) other;
			
			merger.mergeRosetta(getExecutionLanguage(), o.getExecutionLanguage(), this::setExecutionLanguage);
			merger.mergeRosetta(getExecutionLocation(), o.getExecutionLocation(), this::setExecutionLocation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionTerms _that = getType().cast(o);
		
			if (!Objects.equals(executionLanguage, _that.getExecutionLanguage())) return false;
			if (!Objects.equals(executionLocation, _that.getExecutionLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionLanguage != null ? executionLanguage.hashCode() : 0);
			_result = 31 * _result + (executionLocation != null ? executionLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionTermsBuilder {" +
				"executionLanguage=" + this.executionLanguage + ", " +
				"executionLocation=" + this.executionLocation +
			'}';
		}
	}
}
