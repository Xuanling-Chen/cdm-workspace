package cdm.event.workflow;

import cdm.base.datetime.PeriodTimeEnum;
import cdm.event.workflow.meta.VelocityMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface Velocity extends RosettaModelObject {
	Velocity build();
	Velocity.VelocityBuilder toBuilder();
	
	/**
	 */
	PeriodTimeEnum getPeriod();
	/**
	 */
	Integer getPeriodMultiplier();
	final static VelocityMeta metaData = new VelocityMeta();
	
	@Override
	default RosettaMetaData<? extends Velocity> metaData() {
		return metaData;
	} 
			
	static Velocity.VelocityBuilder builder() {
		return new Velocity.VelocityBuilderImpl();
	}
	
	default Class<? extends Velocity> getType() {
		return Velocity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("period"), PeriodTimeEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		
	}
	
	
	interface VelocityBuilder extends Velocity, RosettaModelObjectBuilder {
		Velocity.VelocityBuilder setPeriod(PeriodTimeEnum period);
		Velocity.VelocityBuilder setPeriodMultiplier(Integer periodMultiplier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("period"), PeriodTimeEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			
		}
		
	}
	
	//Velocity.VelocityImpl
	class VelocityImpl implements Velocity {
		private final PeriodTimeEnum period;
		private final Integer periodMultiplier;
		
		protected VelocityImpl(Velocity.VelocityBuilder builder) {
			this.period = builder.getPeriod();
			this.periodMultiplier = builder.getPeriodMultiplier();
		}
		
		@Override
		public PeriodTimeEnum getPeriod() {
			return period;
		}
		
		@Override
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		public Velocity build() {
			return this;
		}
		
		@Override
		public Velocity.VelocityBuilder toBuilder() {
			Velocity.VelocityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Velocity.VelocityBuilder builder) {
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
			ofNullable(getPeriodMultiplier()).ifPresent(builder::setPeriodMultiplier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Velocity _that = getType().cast(o);
		
			if (!Objects.equals(period, _that.getPeriod())) return false;
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Velocity {" +
				"period=" + this.period + ", " +
				"periodMultiplier=" + this.periodMultiplier +
			'}';
		}
	}
	
	//Velocity.VelocityBuilderImpl
	class VelocityBuilderImpl implements Velocity.VelocityBuilder {
	
		protected PeriodTimeEnum period;
		protected Integer periodMultiplier;
	
		public VelocityBuilderImpl() {
		}
	
		@Override
		public PeriodTimeEnum getPeriod() {
			return period;
		}
		
		@Override
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
	
		@Override
		public Velocity.VelocityBuilder setPeriod(PeriodTimeEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		public Velocity.VelocityBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		
		@Override
		public Velocity build() {
			return new Velocity.VelocityImpl(this);
		}
		
		@Override
		public Velocity.VelocityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Velocity.VelocityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriod()!=null) return true;
			if (getPeriodMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Velocity.VelocityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Velocity.VelocityBuilder o = (Velocity.VelocityBuilder) other;
			
			
			merger.mergeBasic(getPeriod(), o.getPeriod(), this::setPeriod);
			merger.mergeBasic(getPeriodMultiplier(), o.getPeriodMultiplier(), this::setPeriodMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Velocity _that = getType().cast(o);
		
			if (!Objects.equals(period, _that.getPeriod())) return false;
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VelocityBuilder {" +
				"period=" + this.period + ", " +
				"periodMultiplier=" + this.periodMultiplier +
			'}';
		}
	}
}
