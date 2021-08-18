package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.EnforcementEventMeta;
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
 * A class to specify Enforcement Events specific to Security Agreements
 * @version ${project.version}
 */
@RosettaClass

public interface EnforcementEvent extends RosettaModelObject {
	EnforcementEvent build();
	EnforcementEvent.EnforcementEventBuilder toBuilder();
	
	/**
	 * The early termination election
	 */
	Boolean getEarlyTerminationDate();
	/**
	 * The failure to pay election
	 */
	Boolean getFailureToPay();
	final static EnforcementEventMeta metaData = new EnforcementEventMeta();
	
	@Override
	default RosettaMetaData<? extends EnforcementEvent> metaData() {
		return metaData;
	} 
			
	static EnforcementEvent.EnforcementEventBuilder builder() {
		return new EnforcementEvent.EnforcementEventBuilderImpl();
	}
	
	default Class<? extends EnforcementEvent> getType() {
		return EnforcementEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("earlyTerminationDate"), Boolean.class, getEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("failureToPay"), Boolean.class, getFailureToPay(), this);
		
	}
	
	
	interface EnforcementEventBuilder extends EnforcementEvent, RosettaModelObjectBuilder {
		EnforcementEvent.EnforcementEventBuilder setEarlyTerminationDate(Boolean earlyTerminationDate);
		EnforcementEvent.EnforcementEventBuilder setFailureToPay(Boolean failureToPay);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("earlyTerminationDate"), Boolean.class, getEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("failureToPay"), Boolean.class, getFailureToPay(), this);
			
		}
		
	}
	
	//EnforcementEvent.EnforcementEventImpl
	class EnforcementEventImpl implements EnforcementEvent {
		private final Boolean earlyTerminationDate;
		private final Boolean failureToPay;
		
		protected EnforcementEventImpl(EnforcementEvent.EnforcementEventBuilder builder) {
			this.earlyTerminationDate = builder.getEarlyTerminationDate();
			this.failureToPay = builder.getFailureToPay();
		}
		
		@Override
		public Boolean getEarlyTerminationDate() {
			return earlyTerminationDate;
		}
		
		@Override
		public Boolean getFailureToPay() {
			return failureToPay;
		}
		
		@Override
		public EnforcementEvent build() {
			return this;
		}
		
		@Override
		public EnforcementEvent.EnforcementEventBuilder toBuilder() {
			EnforcementEvent.EnforcementEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnforcementEvent.EnforcementEventBuilder builder) {
			ofNullable(getEarlyTerminationDate()).ifPresent(builder::setEarlyTerminationDate);
			ofNullable(getFailureToPay()).ifPresent(builder::setFailureToPay);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnforcementEvent _that = getType().cast(o);
		
			if (!Objects.equals(earlyTerminationDate, _that.getEarlyTerminationDate())) return false;
			if (!Objects.equals(failureToPay, _that.getFailureToPay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earlyTerminationDate != null ? earlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (failureToPay != null ? failureToPay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnforcementEvent {" +
				"earlyTerminationDate=" + this.earlyTerminationDate + ", " +
				"failureToPay=" + this.failureToPay +
			'}';
		}
	}
	
	//EnforcementEvent.EnforcementEventBuilderImpl
	class EnforcementEventBuilderImpl implements EnforcementEvent.EnforcementEventBuilder {
	
		protected Boolean earlyTerminationDate;
		protected Boolean failureToPay;
	
		public EnforcementEventBuilderImpl() {
		}
	
		@Override
		public Boolean getEarlyTerminationDate() {
			return earlyTerminationDate;
		}
		
		@Override
		public Boolean getFailureToPay() {
			return failureToPay;
		}
		
	
		@Override
		public EnforcementEvent.EnforcementEventBuilder setEarlyTerminationDate(Boolean earlyTerminationDate) {
			this.earlyTerminationDate = earlyTerminationDate==null?null:earlyTerminationDate;
			return this;
		}
		@Override
		public EnforcementEvent.EnforcementEventBuilder setFailureToPay(Boolean failureToPay) {
			this.failureToPay = failureToPay==null?null:failureToPay;
			return this;
		}
		
		@Override
		public EnforcementEvent build() {
			return new EnforcementEvent.EnforcementEventImpl(this);
		}
		
		@Override
		public EnforcementEvent.EnforcementEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnforcementEvent.EnforcementEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEarlyTerminationDate()!=null) return true;
			if (getFailureToPay()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnforcementEvent.EnforcementEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnforcementEvent.EnforcementEventBuilder o = (EnforcementEvent.EnforcementEventBuilder) other;
			
			
			merger.mergeBasic(getEarlyTerminationDate(), o.getEarlyTerminationDate(), this::setEarlyTerminationDate);
			merger.mergeBasic(getFailureToPay(), o.getFailureToPay(), this::setFailureToPay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnforcementEvent _that = getType().cast(o);
		
			if (!Objects.equals(earlyTerminationDate, _that.getEarlyTerminationDate())) return false;
			if (!Objects.equals(failureToPay, _that.getFailureToPay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earlyTerminationDate != null ? earlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (failureToPay != null ? failureToPay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnforcementEventBuilder {" +
				"earlyTerminationDate=" + this.earlyTerminationDate + ", " +
				"failureToPay=" + this.failureToPay +
			'}';
		}
	}
}
