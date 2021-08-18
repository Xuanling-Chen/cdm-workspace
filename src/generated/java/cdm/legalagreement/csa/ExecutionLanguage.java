package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ExecutionLanguageMeta;
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
 * A class to specify execution language terms of a Security Agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface ExecutionLanguage extends RosettaModelObject {
	ExecutionLanguage build();
	ExecutionLanguage.ExecutionLanguageBuilder toBuilder();
	
	/**
	 * The number of original documents
	 */
	String getNumberOfOriginals();
	/**
	 * Bespoke execution language to be included when specified.
	 */
	String getOtherLanguage();
	/**
	 * A boolean attribute to determine if standard language is applicable or not
	 */
	Boolean getStandardLanguage();
	final static ExecutionLanguageMeta metaData = new ExecutionLanguageMeta();
	
	@Override
	default RosettaMetaData<? extends ExecutionLanguage> metaData() {
		return metaData;
	} 
			
	static ExecutionLanguage.ExecutionLanguageBuilder builder() {
		return new ExecutionLanguage.ExecutionLanguageBuilderImpl();
	}
	
	default Class<? extends ExecutionLanguage> getType() {
		return ExecutionLanguage.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("numberOfOriginals"), String.class, getNumberOfOriginals(), this);
		processor.processBasic(path.newSubPath("otherLanguage"), String.class, getOtherLanguage(), this);
		processor.processBasic(path.newSubPath("standardLanguage"), Boolean.class, getStandardLanguage(), this);
		
	}
	
	
	interface ExecutionLanguageBuilder extends ExecutionLanguage, RosettaModelObjectBuilder {
		ExecutionLanguage.ExecutionLanguageBuilder setNumberOfOriginals(String numberOfOriginals);
		ExecutionLanguage.ExecutionLanguageBuilder setOtherLanguage(String otherLanguage);
		ExecutionLanguage.ExecutionLanguageBuilder setStandardLanguage(Boolean standardLanguage);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("numberOfOriginals"), String.class, getNumberOfOriginals(), this);
			processor.processBasic(path.newSubPath("otherLanguage"), String.class, getOtherLanguage(), this);
			processor.processBasic(path.newSubPath("standardLanguage"), Boolean.class, getStandardLanguage(), this);
			
		}
		
	}
	
	//ExecutionLanguage.ExecutionLanguageImpl
	class ExecutionLanguageImpl implements ExecutionLanguage {
		private final String numberOfOriginals;
		private final String otherLanguage;
		private final Boolean standardLanguage;
		
		protected ExecutionLanguageImpl(ExecutionLanguage.ExecutionLanguageBuilder builder) {
			this.numberOfOriginals = builder.getNumberOfOriginals();
			this.otherLanguage = builder.getOtherLanguage();
			this.standardLanguage = builder.getStandardLanguage();
		}
		
		@Override
		public String getNumberOfOriginals() {
			return numberOfOriginals;
		}
		
		@Override
		public String getOtherLanguage() {
			return otherLanguage;
		}
		
		@Override
		public Boolean getStandardLanguage() {
			return standardLanguage;
		}
		
		@Override
		public ExecutionLanguage build() {
			return this;
		}
		
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder toBuilder() {
			ExecutionLanguage.ExecutionLanguageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionLanguage.ExecutionLanguageBuilder builder) {
			ofNullable(getNumberOfOriginals()).ifPresent(builder::setNumberOfOriginals);
			ofNullable(getOtherLanguage()).ifPresent(builder::setOtherLanguage);
			ofNullable(getStandardLanguage()).ifPresent(builder::setStandardLanguage);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionLanguage _that = getType().cast(o);
		
			if (!Objects.equals(numberOfOriginals, _that.getNumberOfOriginals())) return false;
			if (!Objects.equals(otherLanguage, _that.getOtherLanguage())) return false;
			if (!Objects.equals(standardLanguage, _that.getStandardLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfOriginals != null ? numberOfOriginals.hashCode() : 0);
			_result = 31 * _result + (otherLanguage != null ? otherLanguage.hashCode() : 0);
			_result = 31 * _result + (standardLanguage != null ? standardLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionLanguage {" +
				"numberOfOriginals=" + this.numberOfOriginals + ", " +
				"otherLanguage=" + this.otherLanguage + ", " +
				"standardLanguage=" + this.standardLanguage +
			'}';
		}
	}
	
	//ExecutionLanguage.ExecutionLanguageBuilderImpl
	class ExecutionLanguageBuilderImpl implements ExecutionLanguage.ExecutionLanguageBuilder {
	
		protected String numberOfOriginals;
		protected String otherLanguage;
		protected Boolean standardLanguage;
	
		public ExecutionLanguageBuilderImpl() {
		}
	
		@Override
		public String getNumberOfOriginals() {
			return numberOfOriginals;
		}
		
		@Override
		public String getOtherLanguage() {
			return otherLanguage;
		}
		
		@Override
		public Boolean getStandardLanguage() {
			return standardLanguage;
		}
		
	
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder setNumberOfOriginals(String numberOfOriginals) {
			this.numberOfOriginals = numberOfOriginals==null?null:numberOfOriginals;
			return this;
		}
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder setOtherLanguage(String otherLanguage) {
			this.otherLanguage = otherLanguage==null?null:otherLanguage;
			return this;
		}
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder setStandardLanguage(Boolean standardLanguage) {
			this.standardLanguage = standardLanguage==null?null:standardLanguage;
			return this;
		}
		
		@Override
		public ExecutionLanguage build() {
			return new ExecutionLanguage.ExecutionLanguageImpl(this);
		}
		
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumberOfOriginals()!=null) return true;
			if (getOtherLanguage()!=null) return true;
			if (getStandardLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionLanguage.ExecutionLanguageBuilder o = (ExecutionLanguage.ExecutionLanguageBuilder) other;
			
			
			merger.mergeBasic(getNumberOfOriginals(), o.getNumberOfOriginals(), this::setNumberOfOriginals);
			merger.mergeBasic(getOtherLanguage(), o.getOtherLanguage(), this::setOtherLanguage);
			merger.mergeBasic(getStandardLanguage(), o.getStandardLanguage(), this::setStandardLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionLanguage _that = getType().cast(o);
		
			if (!Objects.equals(numberOfOriginals, _that.getNumberOfOriginals())) return false;
			if (!Objects.equals(otherLanguage, _that.getOtherLanguage())) return false;
			if (!Objects.equals(standardLanguage, _that.getStandardLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfOriginals != null ? numberOfOriginals.hashCode() : 0);
			_result = 31 * _result + (otherLanguage != null ? otherLanguage.hashCode() : 0);
			_result = 31 * _result + (standardLanguage != null ? standardLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionLanguageBuilder {" +
				"numberOfOriginals=" + this.numberOfOriginals + ", " +
				"otherLanguage=" + this.otherLanguage + ", " +
				"standardLanguage=" + this.standardLanguage +
			'}';
		}
	}
}
