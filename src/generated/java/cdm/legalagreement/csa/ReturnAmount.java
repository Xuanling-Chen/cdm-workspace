package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ReturnAmountMeta;
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
 * A class to specify the application of Interest Amount with respect the Return Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
 * @version ${project.version}
 */
@RosettaClass

public interface ReturnAmount extends RosettaModelObject {
	ReturnAmount build();
	ReturnAmount.ReturnAmountBuilder toBuilder();
	
	/**
	 * Custom election that might be specified by the parties to the agreement.
	 */
	String getCustomElection();
	/**
	 * Default language is included when True, and excluded when False.
	 */
	Boolean getIncludesDefaultLanguage();
	final static ReturnAmountMeta metaData = new ReturnAmountMeta();
	
	@Override
	default RosettaMetaData<? extends ReturnAmount> metaData() {
		return metaData;
	} 
			
	static ReturnAmount.ReturnAmountBuilder builder() {
		return new ReturnAmount.ReturnAmountBuilderImpl();
	}
	
	default Class<? extends ReturnAmount> getType() {
		return ReturnAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		processor.processBasic(path.newSubPath("includesDefaultLanguage"), Boolean.class, getIncludesDefaultLanguage(), this);
		
	}
	
	
	interface ReturnAmountBuilder extends ReturnAmount, RosettaModelObjectBuilder {
		ReturnAmount.ReturnAmountBuilder setCustomElection(String customElection);
		ReturnAmount.ReturnAmountBuilder setIncludesDefaultLanguage(Boolean includesDefaultLanguage);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
			processor.processBasic(path.newSubPath("includesDefaultLanguage"), Boolean.class, getIncludesDefaultLanguage(), this);
			
		}
		
	}
	
	//ReturnAmount.ReturnAmountImpl
	class ReturnAmountImpl implements ReturnAmount {
		private final String customElection;
		private final Boolean includesDefaultLanguage;
		
		protected ReturnAmountImpl(ReturnAmount.ReturnAmountBuilder builder) {
			this.customElection = builder.getCustomElection();
			this.includesDefaultLanguage = builder.getIncludesDefaultLanguage();
		}
		
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public Boolean getIncludesDefaultLanguage() {
			return includesDefaultLanguage;
		}
		
		@Override
		public ReturnAmount build() {
			return this;
		}
		
		@Override
		public ReturnAmount.ReturnAmountBuilder toBuilder() {
			ReturnAmount.ReturnAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnAmount.ReturnAmountBuilder builder) {
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
			ofNullable(getIncludesDefaultLanguage()).ifPresent(builder::setIncludesDefaultLanguage);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnAmount _that = getType().cast(o);
		
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(includesDefaultLanguage, _that.getIncludesDefaultLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (includesDefaultLanguage != null ? includesDefaultLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnAmount {" +
				"customElection=" + this.customElection + ", " +
				"includesDefaultLanguage=" + this.includesDefaultLanguage +
			'}';
		}
	}
	
	//ReturnAmount.ReturnAmountBuilderImpl
	class ReturnAmountBuilderImpl implements ReturnAmount.ReturnAmountBuilder {
	
		protected String customElection;
		protected Boolean includesDefaultLanguage;
	
		public ReturnAmountBuilderImpl() {
		}
	
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public Boolean getIncludesDefaultLanguage() {
			return includesDefaultLanguage;
		}
		
	
		@Override
		public ReturnAmount.ReturnAmountBuilder setCustomElection(String customElection) {
			this.customElection = customElection==null?null:customElection;
			return this;
		}
		@Override
		public ReturnAmount.ReturnAmountBuilder setIncludesDefaultLanguage(Boolean includesDefaultLanguage) {
			this.includesDefaultLanguage = includesDefaultLanguage==null?null:includesDefaultLanguage;
			return this;
		}
		
		@Override
		public ReturnAmount build() {
			return new ReturnAmount.ReturnAmountImpl(this);
		}
		
		@Override
		public ReturnAmount.ReturnAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnAmount.ReturnAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomElection()!=null) return true;
			if (getIncludesDefaultLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnAmount.ReturnAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnAmount.ReturnAmountBuilder o = (ReturnAmount.ReturnAmountBuilder) other;
			
			
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			merger.mergeBasic(getIncludesDefaultLanguage(), o.getIncludesDefaultLanguage(), this::setIncludesDefaultLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnAmount _that = getType().cast(o);
		
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(includesDefaultLanguage, _that.getIncludesDefaultLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (includesDefaultLanguage != null ? includesDefaultLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnAmountBuilder {" +
				"customElection=" + this.customElection + ", " +
				"includesDefaultLanguage=" + this.includesDefaultLanguage +
			'}';
		}
	}
}
