package cdm.legalagreement.csa;

import cdm.legalagreement.common.ExecutionLocationEnum;
import cdm.legalagreement.csa.meta.ExecutionLocationMeta;
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
 * A class to specify execution location terms of a Security Agreement
 * @version ${project.version}
 */
@RosettaClass

public interface ExecutionLocation extends RosettaModelObject {
	ExecutionLocation build();
	ExecutionLocation.ExecutionLocationBuilder toBuilder();
	
	/**
	 * The payer of documentary duty
	 */
	String getDutyPayer();
	/**
	 * Bespoke terms specific to the payment of documentary duty
	 */
	String getDutyPayerLanguage();
	/**
	 * The date that documentary duty will be paid
	 */
	Date getDutyPaymentDate();
	/**
	 * Bespoke terms specific to the date that documentary duty will be paid
	 */
	String getDutyPaymentLanguage();
	/**
	 * The execution location of the agreement
	 */
	ExecutionLocationEnum getExecutionLocation();
	/**
	 * Bespoke execution location language to be included when specified.
	 */
	String getOtherLanguage();
	final static ExecutionLocationMeta metaData = new ExecutionLocationMeta();
	
	@Override
	default RosettaMetaData<? extends ExecutionLocation> metaData() {
		return metaData;
	} 
			
	static ExecutionLocation.ExecutionLocationBuilder builder() {
		return new ExecutionLocation.ExecutionLocationBuilderImpl();
	}
	
	default Class<? extends ExecutionLocation> getType() {
		return ExecutionLocation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dutyPayer"), String.class, getDutyPayer(), this);
		processor.processBasic(path.newSubPath("dutyPayerLanguage"), String.class, getDutyPayerLanguage(), this);
		processor.processBasic(path.newSubPath("dutyPaymentDate"), Date.class, getDutyPaymentDate(), this);
		processor.processBasic(path.newSubPath("dutyPaymentLanguage"), String.class, getDutyPaymentLanguage(), this);
		processor.processBasic(path.newSubPath("executionLocation"), ExecutionLocationEnum.class, getExecutionLocation(), this);
		processor.processBasic(path.newSubPath("otherLanguage"), String.class, getOtherLanguage(), this);
		
	}
	
	
	interface ExecutionLocationBuilder extends ExecutionLocation, RosettaModelObjectBuilder {
		ExecutionLocation.ExecutionLocationBuilder setDutyPayer(String dutyPayer);
		ExecutionLocation.ExecutionLocationBuilder setDutyPayerLanguage(String dutyPayerLanguage);
		ExecutionLocation.ExecutionLocationBuilder setDutyPaymentDate(Date dutyPaymentDate);
		ExecutionLocation.ExecutionLocationBuilder setDutyPaymentLanguage(String dutyPaymentLanguage);
		ExecutionLocation.ExecutionLocationBuilder setExecutionLocation(ExecutionLocationEnum executionLocation);
		ExecutionLocation.ExecutionLocationBuilder setOtherLanguage(String otherLanguage);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("dutyPayer"), String.class, getDutyPayer(), this);
			processor.processBasic(path.newSubPath("dutyPayerLanguage"), String.class, getDutyPayerLanguage(), this);
			processor.processBasic(path.newSubPath("dutyPaymentDate"), Date.class, getDutyPaymentDate(), this);
			processor.processBasic(path.newSubPath("dutyPaymentLanguage"), String.class, getDutyPaymentLanguage(), this);
			processor.processBasic(path.newSubPath("executionLocation"), ExecutionLocationEnum.class, getExecutionLocation(), this);
			processor.processBasic(path.newSubPath("otherLanguage"), String.class, getOtherLanguage(), this);
			
		}
		
	}
	
	//ExecutionLocation.ExecutionLocationImpl
	class ExecutionLocationImpl implements ExecutionLocation {
		private final String dutyPayer;
		private final String dutyPayerLanguage;
		private final Date dutyPaymentDate;
		private final String dutyPaymentLanguage;
		private final ExecutionLocationEnum executionLocation;
		private final String otherLanguage;
		
		protected ExecutionLocationImpl(ExecutionLocation.ExecutionLocationBuilder builder) {
			this.dutyPayer = builder.getDutyPayer();
			this.dutyPayerLanguage = builder.getDutyPayerLanguage();
			this.dutyPaymentDate = builder.getDutyPaymentDate();
			this.dutyPaymentLanguage = builder.getDutyPaymentLanguage();
			this.executionLocation = builder.getExecutionLocation();
			this.otherLanguage = builder.getOtherLanguage();
		}
		
		@Override
		public String getDutyPayer() {
			return dutyPayer;
		}
		
		@Override
		public String getDutyPayerLanguage() {
			return dutyPayerLanguage;
		}
		
		@Override
		public Date getDutyPaymentDate() {
			return dutyPaymentDate;
		}
		
		@Override
		public String getDutyPaymentLanguage() {
			return dutyPaymentLanguage;
		}
		
		@Override
		public ExecutionLocationEnum getExecutionLocation() {
			return executionLocation;
		}
		
		@Override
		public String getOtherLanguage() {
			return otherLanguage;
		}
		
		@Override
		public ExecutionLocation build() {
			return this;
		}
		
		@Override
		public ExecutionLocation.ExecutionLocationBuilder toBuilder() {
			ExecutionLocation.ExecutionLocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionLocation.ExecutionLocationBuilder builder) {
			ofNullable(getDutyPayer()).ifPresent(builder::setDutyPayer);
			ofNullable(getDutyPayerLanguage()).ifPresent(builder::setDutyPayerLanguage);
			ofNullable(getDutyPaymentDate()).ifPresent(builder::setDutyPaymentDate);
			ofNullable(getDutyPaymentLanguage()).ifPresent(builder::setDutyPaymentLanguage);
			ofNullable(getExecutionLocation()).ifPresent(builder::setExecutionLocation);
			ofNullable(getOtherLanguage()).ifPresent(builder::setOtherLanguage);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionLocation _that = getType().cast(o);
		
			if (!Objects.equals(dutyPayer, _that.getDutyPayer())) return false;
			if (!Objects.equals(dutyPayerLanguage, _that.getDutyPayerLanguage())) return false;
			if (!Objects.equals(dutyPaymentDate, _that.getDutyPaymentDate())) return false;
			if (!Objects.equals(dutyPaymentLanguage, _that.getDutyPaymentLanguage())) return false;
			if (!Objects.equals(executionLocation, _that.getExecutionLocation())) return false;
			if (!Objects.equals(otherLanguage, _that.getOtherLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dutyPayer != null ? dutyPayer.hashCode() : 0);
			_result = 31 * _result + (dutyPayerLanguage != null ? dutyPayerLanguage.hashCode() : 0);
			_result = 31 * _result + (dutyPaymentDate != null ? dutyPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dutyPaymentLanguage != null ? dutyPaymentLanguage.hashCode() : 0);
			_result = 31 * _result + (executionLocation != null ? executionLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLanguage != null ? otherLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionLocation {" +
				"dutyPayer=" + this.dutyPayer + ", " +
				"dutyPayerLanguage=" + this.dutyPayerLanguage + ", " +
				"dutyPaymentDate=" + this.dutyPaymentDate + ", " +
				"dutyPaymentLanguage=" + this.dutyPaymentLanguage + ", " +
				"executionLocation=" + this.executionLocation + ", " +
				"otherLanguage=" + this.otherLanguage +
			'}';
		}
	}
	
	//ExecutionLocation.ExecutionLocationBuilderImpl
	class ExecutionLocationBuilderImpl implements ExecutionLocation.ExecutionLocationBuilder {
	
		protected String dutyPayer;
		protected String dutyPayerLanguage;
		protected Date dutyPaymentDate;
		protected String dutyPaymentLanguage;
		protected ExecutionLocationEnum executionLocation;
		protected String otherLanguage;
	
		public ExecutionLocationBuilderImpl() {
		}
	
		@Override
		public String getDutyPayer() {
			return dutyPayer;
		}
		
		@Override
		public String getDutyPayerLanguage() {
			return dutyPayerLanguage;
		}
		
		@Override
		public Date getDutyPaymentDate() {
			return dutyPaymentDate;
		}
		
		@Override
		public String getDutyPaymentLanguage() {
			return dutyPaymentLanguage;
		}
		
		@Override
		public ExecutionLocationEnum getExecutionLocation() {
			return executionLocation;
		}
		
		@Override
		public String getOtherLanguage() {
			return otherLanguage;
		}
		
	
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setDutyPayer(String dutyPayer) {
			this.dutyPayer = dutyPayer==null?null:dutyPayer;
			return this;
		}
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setDutyPayerLanguage(String dutyPayerLanguage) {
			this.dutyPayerLanguage = dutyPayerLanguage==null?null:dutyPayerLanguage;
			return this;
		}
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setDutyPaymentDate(Date dutyPaymentDate) {
			this.dutyPaymentDate = dutyPaymentDate==null?null:dutyPaymentDate;
			return this;
		}
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setDutyPaymentLanguage(String dutyPaymentLanguage) {
			this.dutyPaymentLanguage = dutyPaymentLanguage==null?null:dutyPaymentLanguage;
			return this;
		}
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setExecutionLocation(ExecutionLocationEnum executionLocation) {
			this.executionLocation = executionLocation==null?null:executionLocation;
			return this;
		}
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setOtherLanguage(String otherLanguage) {
			this.otherLanguage = otherLanguage==null?null:otherLanguage;
			return this;
		}
		
		@Override
		public ExecutionLocation build() {
			return new ExecutionLocation.ExecutionLocationImpl(this);
		}
		
		@Override
		public ExecutionLocation.ExecutionLocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDutyPayer()!=null) return true;
			if (getDutyPayerLanguage()!=null) return true;
			if (getDutyPaymentDate()!=null) return true;
			if (getDutyPaymentLanguage()!=null) return true;
			if (getExecutionLocation()!=null) return true;
			if (getOtherLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionLocation.ExecutionLocationBuilder o = (ExecutionLocation.ExecutionLocationBuilder) other;
			
			
			merger.mergeBasic(getDutyPayer(), o.getDutyPayer(), this::setDutyPayer);
			merger.mergeBasic(getDutyPayerLanguage(), o.getDutyPayerLanguage(), this::setDutyPayerLanguage);
			merger.mergeBasic(getDutyPaymentDate(), o.getDutyPaymentDate(), this::setDutyPaymentDate);
			merger.mergeBasic(getDutyPaymentLanguage(), o.getDutyPaymentLanguage(), this::setDutyPaymentLanguage);
			merger.mergeBasic(getExecutionLocation(), o.getExecutionLocation(), this::setExecutionLocation);
			merger.mergeBasic(getOtherLanguage(), o.getOtherLanguage(), this::setOtherLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionLocation _that = getType().cast(o);
		
			if (!Objects.equals(dutyPayer, _that.getDutyPayer())) return false;
			if (!Objects.equals(dutyPayerLanguage, _that.getDutyPayerLanguage())) return false;
			if (!Objects.equals(dutyPaymentDate, _that.getDutyPaymentDate())) return false;
			if (!Objects.equals(dutyPaymentLanguage, _that.getDutyPaymentLanguage())) return false;
			if (!Objects.equals(executionLocation, _that.getExecutionLocation())) return false;
			if (!Objects.equals(otherLanguage, _that.getOtherLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dutyPayer != null ? dutyPayer.hashCode() : 0);
			_result = 31 * _result + (dutyPayerLanguage != null ? dutyPayerLanguage.hashCode() : 0);
			_result = 31 * _result + (dutyPaymentDate != null ? dutyPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dutyPaymentLanguage != null ? dutyPaymentLanguage.hashCode() : 0);
			_result = 31 * _result + (executionLocation != null ? executionLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLanguage != null ? otherLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionLocationBuilder {" +
				"dutyPayer=" + this.dutyPayer + ", " +
				"dutyPayerLanguage=" + this.dutyPayerLanguage + ", " +
				"dutyPaymentDate=" + this.dutyPaymentDate + ", " +
				"dutyPaymentLanguage=" + this.dutyPaymentLanguage + ", " +
				"executionLocation=" + this.executionLocation + ", " +
				"otherLanguage=" + this.otherLanguage +
			'}';
		}
	}
}
