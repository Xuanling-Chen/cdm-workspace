package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.ClosedStateMeta;
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
 *  A class to qualify the closed state of an execution or a contract through the combination or a state (e.g. terminated, novated) and a set of dates: activity date, effective date and, when relevant, last payment date.
 * @version ${project.version}
 */
@RosettaClass

public interface ClosedState extends RosettaModelObject {
	ClosedState build();
	ClosedState.ClosedStateBuilder toBuilder();
	
	/**
	 * The activity date on which the closing state took place, i.e. either the event date of the closing event (e.g. option exercise, contract early termination) or the contractual termination date.
	 */
	Date getActivityDate();
	/**
	 * The date on which the closing event contractually takes effect, when different from the activity date. When an explicit event effective date attribute is associated with the closing event, it will be that date. In the case of a cancellation event, it will be the date on which the cancelled event took place.
	 */
	Date getEffectiveDate();
	/**
	 * The date associated with the last payment in relation to the artefact (e.g. contract) to which this closed state applies. As an example, in the case of an early termination event, it would be the settlement date of the associated fee, if applicable.
	 */
	Date getLastPaymentDate();
	/**
	 * The qualification of what gave way to the contract or execution closure, e.g. allocation, termination, ...
	 */
	ClosedStateEnum getState();
	final static ClosedStateMeta metaData = new ClosedStateMeta();
	
	@Override
	default RosettaMetaData<? extends ClosedState> metaData() {
		return metaData;
	} 
			
	static ClosedState.ClosedStateBuilder builder() {
		return new ClosedState.ClosedStateBuilderImpl();
	}
	
	default Class<? extends ClosedState> getType() {
		return ClosedState.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("activityDate"), Date.class, getActivityDate(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("lastPaymentDate"), Date.class, getLastPaymentDate(), this);
		processor.processBasic(path.newSubPath("state"), ClosedStateEnum.class, getState(), this);
		
	}
	
	
	interface ClosedStateBuilder extends ClosedState, RosettaModelObjectBuilder {
		ClosedState.ClosedStateBuilder setActivityDate(Date activityDate);
		ClosedState.ClosedStateBuilder setEffectiveDate(Date effectiveDate);
		ClosedState.ClosedStateBuilder setLastPaymentDate(Date lastPaymentDate);
		ClosedState.ClosedStateBuilder setState(ClosedStateEnum state);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("activityDate"), Date.class, getActivityDate(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("lastPaymentDate"), Date.class, getLastPaymentDate(), this);
			processor.processBasic(path.newSubPath("state"), ClosedStateEnum.class, getState(), this);
			
		}
		
	}
	
	//ClosedState.ClosedStateImpl
	class ClosedStateImpl implements ClosedState {
		private final Date activityDate;
		private final Date effectiveDate;
		private final Date lastPaymentDate;
		private final ClosedStateEnum state;
		
		protected ClosedStateImpl(ClosedState.ClosedStateBuilder builder) {
			this.activityDate = builder.getActivityDate();
			this.effectiveDate = builder.getEffectiveDate();
			this.lastPaymentDate = builder.getLastPaymentDate();
			this.state = builder.getState();
		}
		
		@Override
		public Date getActivityDate() {
			return activityDate;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public Date getLastPaymentDate() {
			return lastPaymentDate;
		}
		
		@Override
		public ClosedStateEnum getState() {
			return state;
		}
		
		@Override
		public ClosedState build() {
			return this;
		}
		
		@Override
		public ClosedState.ClosedStateBuilder toBuilder() {
			ClosedState.ClosedStateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClosedState.ClosedStateBuilder builder) {
			ofNullable(getActivityDate()).ifPresent(builder::setActivityDate);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getLastPaymentDate()).ifPresent(builder::setLastPaymentDate);
			ofNullable(getState()).ifPresent(builder::setState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClosedState _that = getType().cast(o);
		
			if (!Objects.equals(activityDate, _that.getActivityDate())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(lastPaymentDate, _that.getLastPaymentDate())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (activityDate != null ? activityDate.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (lastPaymentDate != null ? lastPaymentDate.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClosedState {" +
				"activityDate=" + this.activityDate + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"lastPaymentDate=" + this.lastPaymentDate + ", " +
				"state=" + this.state +
			'}';
		}
	}
	
	//ClosedState.ClosedStateBuilderImpl
	class ClosedStateBuilderImpl implements ClosedState.ClosedStateBuilder {
	
		protected Date activityDate;
		protected Date effectiveDate;
		protected Date lastPaymentDate;
		protected ClosedStateEnum state;
	
		public ClosedStateBuilderImpl() {
		}
	
		@Override
		public Date getActivityDate() {
			return activityDate;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public Date getLastPaymentDate() {
			return lastPaymentDate;
		}
		
		@Override
		public ClosedStateEnum getState() {
			return state;
		}
		
	
		@Override
		public ClosedState.ClosedStateBuilder setActivityDate(Date activityDate) {
			this.activityDate = activityDate==null?null:activityDate;
			return this;
		}
		@Override
		public ClosedState.ClosedStateBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		public ClosedState.ClosedStateBuilder setLastPaymentDate(Date lastPaymentDate) {
			this.lastPaymentDate = lastPaymentDate==null?null:lastPaymentDate;
			return this;
		}
		@Override
		public ClosedState.ClosedStateBuilder setState(ClosedStateEnum state) {
			this.state = state==null?null:state;
			return this;
		}
		
		@Override
		public ClosedState build() {
			return new ClosedState.ClosedStateImpl(this);
		}
		
		@Override
		public ClosedState.ClosedStateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClosedState.ClosedStateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getActivityDate()!=null) return true;
			if (getEffectiveDate()!=null) return true;
			if (getLastPaymentDate()!=null) return true;
			if (getState()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClosedState.ClosedStateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClosedState.ClosedStateBuilder o = (ClosedState.ClosedStateBuilder) other;
			
			
			merger.mergeBasic(getActivityDate(), o.getActivityDate(), this::setActivityDate);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getLastPaymentDate(), o.getLastPaymentDate(), this::setLastPaymentDate);
			merger.mergeBasic(getState(), o.getState(), this::setState);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClosedState _that = getType().cast(o);
		
			if (!Objects.equals(activityDate, _that.getActivityDate())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(lastPaymentDate, _that.getLastPaymentDate())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (activityDate != null ? activityDate.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (lastPaymentDate != null ? lastPaymentDate.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClosedStateBuilder {" +
				"activityDate=" + this.activityDate + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"lastPaymentDate=" + this.lastPaymentDate + ", " +
				"state=" + this.state +
			'}';
		}
	}
}
