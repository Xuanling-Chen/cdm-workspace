package cdm.observable.event;

import cdm.observable.event.meta.TriggerMeta;
import cdm.observable.event.metafields.ReferenceWithMetaCreditEvents;
import cdm.observable.event.metafields.ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Trigger point at which feature is effective.
 * @version ${project.version}
 */
@RosettaClass

public interface Trigger extends RosettaModelObject {
	Trigger build();
	Trigger.TriggerBuilder toBuilder();
	
	/**
	 */
	CreditEvents getCreditEvents();
	/**
	 */
	ReferenceWithMetaCreditEvents getCreditEventsReference();
	/**
	 * The trigger level.
	 */
	BigDecimal getLevel();
	/**
	 * The trigger level percentage.
	 */
	BigDecimal getLevelPercentage();
	/**
	 * The valuation time type of knock condition.
	 */
	TriggerTimeTypeEnum getTriggerTimeType();
	/**
	 * The Triggering condition.
	 */
	TriggerTypeEnum getTriggerType();
	final static TriggerMeta metaData = new TriggerMeta();
	
	@Override
	default RosettaMetaData<? extends Trigger> metaData() {
		return metaData;
	} 
			
	static Trigger.TriggerBuilder builder() {
		return new Trigger.TriggerBuilderImpl();
	}
	
	default Class<? extends Trigger> getType() {
		return Trigger.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("level"), BigDecimal.class, getLevel(), this);
		processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
		processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
		processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
		
		processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.class, getCreditEvents());
		processRosetta(path.newSubPath("creditEventsReference"), processor, ReferenceWithMetaCreditEvents.class, getCreditEventsReference());
	}
	
	
	interface TriggerBuilder extends Trigger, RosettaModelObjectBuilder {
		CreditEvents.CreditEventsBuilder getOrCreateCreditEvents();
		CreditEvents.CreditEventsBuilder getCreditEvents();
		ReferenceWithMetaCreditEventsBuilder getOrCreateCreditEventsReference();
		ReferenceWithMetaCreditEventsBuilder getCreditEventsReference();
		Trigger.TriggerBuilder setCreditEvents(CreditEvents creditEvents);
		Trigger.TriggerBuilder setCreditEventsReference(ReferenceWithMetaCreditEvents creditEventsReference);
		Trigger.TriggerBuilder setCreditEventsReferenceValue(CreditEvents creditEventsReference);
		Trigger.TriggerBuilder setLevel(BigDecimal level);
		Trigger.TriggerBuilder setLevelPercentage(BigDecimal levelPercentage);
		Trigger.TriggerBuilder setTriggerTimeType(TriggerTimeTypeEnum triggerTimeType);
		Trigger.TriggerBuilder setTriggerType(TriggerTypeEnum triggerType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("level"), BigDecimal.class, getLevel(), this);
			processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
			processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
			processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
			
			processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.CreditEventsBuilder.class, getCreditEvents());
			processRosetta(path.newSubPath("creditEventsReference"), processor, ReferenceWithMetaCreditEventsBuilder.class, getCreditEventsReference());
		}
		
	}
	
	//Trigger.TriggerImpl
	class TriggerImpl implements Trigger {
		private final CreditEvents creditEvents;
		private final ReferenceWithMetaCreditEvents creditEventsReference;
		private final BigDecimal level;
		private final BigDecimal levelPercentage;
		private final TriggerTimeTypeEnum triggerTimeType;
		private final TriggerTypeEnum triggerType;
		
		protected TriggerImpl(Trigger.TriggerBuilder builder) {
			this.creditEvents = ofNullable(builder.getCreditEvents()).map(f->f.build()).orElse(null);
			this.creditEventsReference = ofNullable(builder.getCreditEventsReference()).map(f->f.build()).orElse(null);
			this.level = builder.getLevel();
			this.levelPercentage = builder.getLevelPercentage();
			this.triggerTimeType = builder.getTriggerTimeType();
			this.triggerType = builder.getTriggerType();
		}
		
		@Override
		public CreditEvents getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public ReferenceWithMetaCreditEvents getCreditEventsReference() {
			return creditEventsReference;
		}
		
		@Override
		public BigDecimal getLevel() {
			return level;
		}
		
		@Override
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		public TriggerTimeTypeEnum getTriggerTimeType() {
			return triggerTimeType;
		}
		
		@Override
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
		@Override
		public Trigger build() {
			return this;
		}
		
		@Override
		public Trigger.TriggerBuilder toBuilder() {
			Trigger.TriggerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Trigger.TriggerBuilder builder) {
			ofNullable(getCreditEvents()).ifPresent(builder::setCreditEvents);
			ofNullable(getCreditEventsReference()).ifPresent(builder::setCreditEventsReference);
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getLevelPercentage()).ifPresent(builder::setLevelPercentage);
			ofNullable(getTriggerTimeType()).ifPresent(builder::setTriggerTimeType);
			ofNullable(getTriggerType()).ifPresent(builder::setTriggerType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trigger _that = getType().cast(o);
		
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(creditEventsReference, _that.getCreditEventsReference())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(triggerTimeType, _that.getTriggerTimeType())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (creditEventsReference != null ? creditEventsReference.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (triggerTimeType != null ? triggerTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Trigger {" +
				"creditEvents=" + this.creditEvents + ", " +
				"creditEventsReference=" + this.creditEventsReference + ", " +
				"level=" + this.level + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"triggerTimeType=" + this.triggerTimeType + ", " +
				"triggerType=" + this.triggerType +
			'}';
		}
	}
	
	//Trigger.TriggerBuilderImpl
	class TriggerBuilderImpl implements Trigger.TriggerBuilder {
	
		protected CreditEvents.CreditEventsBuilder creditEvents;
		protected ReferenceWithMetaCreditEventsBuilder creditEventsReference;
		protected BigDecimal level;
		protected BigDecimal levelPercentage;
		protected TriggerTimeTypeEnum triggerTimeType;
		protected TriggerTypeEnum triggerType;
	
		public TriggerBuilderImpl() {
		}
	
		@Override
		public CreditEvents.CreditEventsBuilder getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder getOrCreateCreditEvents() {
			CreditEvents.CreditEventsBuilder result;
			if (creditEvents!=null) {
				result = creditEvents;
			}
			else {
				result = creditEvents = CreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaCreditEventsBuilder getCreditEventsReference() {
			return creditEventsReference;
		}
		
		@Override
		public ReferenceWithMetaCreditEventsBuilder getOrCreateCreditEventsReference() {
			ReferenceWithMetaCreditEventsBuilder result;
			if (creditEventsReference!=null) {
				result = creditEventsReference;
			}
			else {
				result = creditEventsReference = ReferenceWithMetaCreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getLevel() {
			return level;
		}
		
		@Override
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		public TriggerTimeTypeEnum getTriggerTimeType() {
			return triggerTimeType;
		}
		
		@Override
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
	
		@Override
		public Trigger.TriggerBuilder setCreditEvents(CreditEvents creditEvents) {
			this.creditEvents = creditEvents==null?null:creditEvents.toBuilder();
			return this;
		}
		@Override
		public Trigger.TriggerBuilder setCreditEventsReference(ReferenceWithMetaCreditEvents creditEventsReference) {
			this.creditEventsReference = creditEventsReference==null?null:creditEventsReference.toBuilder();
			return this;
		}
		
		@Override
		public Trigger.TriggerBuilder setCreditEventsReferenceValue(CreditEvents creditEventsReference) {
			this.getOrCreateCreditEventsReference().setValue(creditEventsReference);
			return this;
		}
		@Override
		public Trigger.TriggerBuilder setLevel(BigDecimal level) {
			this.level = level==null?null:level;
			return this;
		}
		@Override
		public Trigger.TriggerBuilder setLevelPercentage(BigDecimal levelPercentage) {
			this.levelPercentage = levelPercentage==null?null:levelPercentage;
			return this;
		}
		@Override
		public Trigger.TriggerBuilder setTriggerTimeType(TriggerTimeTypeEnum triggerTimeType) {
			this.triggerTimeType = triggerTimeType==null?null:triggerTimeType;
			return this;
		}
		@Override
		public Trigger.TriggerBuilder setTriggerType(TriggerTypeEnum triggerType) {
			this.triggerType = triggerType==null?null:triggerType;
			return this;
		}
		
		@Override
		public Trigger build() {
			return new Trigger.TriggerImpl(this);
		}
		
		@Override
		public Trigger.TriggerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trigger.TriggerBuilder prune() {
			if (creditEvents!=null && !creditEvents.prune().hasData()) creditEvents = null;
			if (creditEventsReference!=null && !creditEventsReference.prune().hasData()) creditEventsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditEvents()!=null && getCreditEvents().hasData()) return true;
			if (getCreditEventsReference()!=null && getCreditEventsReference().hasData()) return true;
			if (getLevel()!=null) return true;
			if (getLevelPercentage()!=null) return true;
			if (getTriggerTimeType()!=null) return true;
			if (getTriggerType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trigger.TriggerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Trigger.TriggerBuilder o = (Trigger.TriggerBuilder) other;
			
			merger.mergeRosetta(getCreditEvents(), o.getCreditEvents(), this::setCreditEvents);
			merger.mergeRosetta(getCreditEventsReference(), o.getCreditEventsReference(), this::setCreditEventsReference);
			
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeBasic(getLevelPercentage(), o.getLevelPercentage(), this::setLevelPercentage);
			merger.mergeBasic(getTriggerTimeType(), o.getTriggerTimeType(), this::setTriggerTimeType);
			merger.mergeBasic(getTriggerType(), o.getTriggerType(), this::setTriggerType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trigger _that = getType().cast(o);
		
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(creditEventsReference, _that.getCreditEventsReference())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(triggerTimeType, _that.getTriggerTimeType())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (creditEventsReference != null ? creditEventsReference.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (triggerTimeType != null ? triggerTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerBuilder {" +
				"creditEvents=" + this.creditEvents + ", " +
				"creditEventsReference=" + this.creditEventsReference + ", " +
				"level=" + this.level + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"triggerTimeType=" + this.triggerTimeType + ", " +
				"triggerType=" + this.triggerType +
			'}';
		}
	}
}
