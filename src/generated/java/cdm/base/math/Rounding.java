package cdm.base.math;

import cdm.base.math.meta.RoundingMeta;
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
 * Defines rounding rules and precision to be used in the rounding of a number.
 * @version ${project.version}
 */
@RosettaClass

public interface Rounding extends RosettaModelObject {
	Rounding build();
	Rounding.RoundingBuilder toBuilder();
	
	/**
	 * Specifies the rounding precision in terms of a number of decimal places when the number is evaluated in decimal form (not percentage), e.g. 0.09876543 rounded to the nearest 5 decimal places is  0.0987654.
	 */
	Integer getPrecision();
	/**
	 * Specifies the rounding rounding rule as up, down, or nearest.
	 */
	RoundingDirectionEnum getRoundingDirection();
	final static RoundingMeta metaData = new RoundingMeta();
	
	@Override
	default RosettaMetaData<? extends Rounding> metaData() {
		return metaData;
	} 
			
	static Rounding.RoundingBuilder builder() {
		return new Rounding.RoundingBuilderImpl();
	}
	
	default Class<? extends Rounding> getType() {
		return Rounding.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
		processor.processBasic(path.newSubPath("roundingDirection"), RoundingDirectionEnum.class, getRoundingDirection(), this);
		
	}
	
	
	interface RoundingBuilder extends Rounding, RosettaModelObjectBuilder {
		Rounding.RoundingBuilder setPrecision(Integer precision);
		Rounding.RoundingBuilder setRoundingDirection(RoundingDirectionEnum roundingDirection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
			processor.processBasic(path.newSubPath("roundingDirection"), RoundingDirectionEnum.class, getRoundingDirection(), this);
			
		}
		
	}
	
	//Rounding.RoundingImpl
	class RoundingImpl implements Rounding {
		private final Integer precision;
		private final RoundingDirectionEnum roundingDirection;
		
		protected RoundingImpl(Rounding.RoundingBuilder builder) {
			this.precision = builder.getPrecision();
			this.roundingDirection = builder.getRoundingDirection();
		}
		
		@Override
		public Integer getPrecision() {
			return precision;
		}
		
		@Override
		public RoundingDirectionEnum getRoundingDirection() {
			return roundingDirection;
		}
		
		@Override
		public Rounding build() {
			return this;
		}
		
		@Override
		public Rounding.RoundingBuilder toBuilder() {
			Rounding.RoundingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Rounding.RoundingBuilder builder) {
			ofNullable(getPrecision()).ifPresent(builder::setPrecision);
			ofNullable(getRoundingDirection()).ifPresent(builder::setRoundingDirection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Rounding _that = getType().cast(o);
		
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			if (!Objects.equals(roundingDirection, _that.getRoundingDirection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			_result = 31 * _result + (roundingDirection != null ? roundingDirection.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Rounding {" +
				"precision=" + this.precision + ", " +
				"roundingDirection=" + this.roundingDirection +
			'}';
		}
	}
	
	//Rounding.RoundingBuilderImpl
	class RoundingBuilderImpl implements Rounding.RoundingBuilder {
	
		protected Integer precision;
		protected RoundingDirectionEnum roundingDirection;
	
		public RoundingBuilderImpl() {
		}
	
		@Override
		public Integer getPrecision() {
			return precision;
		}
		
		@Override
		public RoundingDirectionEnum getRoundingDirection() {
			return roundingDirection;
		}
		
	
		@Override
		public Rounding.RoundingBuilder setPrecision(Integer precision) {
			this.precision = precision==null?null:precision;
			return this;
		}
		@Override
		public Rounding.RoundingBuilder setRoundingDirection(RoundingDirectionEnum roundingDirection) {
			this.roundingDirection = roundingDirection==null?null:roundingDirection;
			return this;
		}
		
		@Override
		public Rounding build() {
			return new Rounding.RoundingImpl(this);
		}
		
		@Override
		public Rounding.RoundingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rounding.RoundingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrecision()!=null) return true;
			if (getRoundingDirection()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rounding.RoundingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Rounding.RoundingBuilder o = (Rounding.RoundingBuilder) other;
			
			
			merger.mergeBasic(getPrecision(), o.getPrecision(), this::setPrecision);
			merger.mergeBasic(getRoundingDirection(), o.getRoundingDirection(), this::setRoundingDirection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Rounding _that = getType().cast(o);
		
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			if (!Objects.equals(roundingDirection, _that.getRoundingDirection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			_result = 31 * _result + (roundingDirection != null ? roundingDirection.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoundingBuilder {" +
				"precision=" + this.precision + ", " +
				"roundingDirection=" + this.roundingDirection +
			'}';
		}
	}
}
