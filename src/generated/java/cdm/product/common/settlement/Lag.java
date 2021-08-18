package cdm.product.common.settlement;

import cdm.base.datetime.Offset;
import cdm.product.common.settlement.meta.LagMeta;
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
 * The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
 * @version ${project.version}
 */
@RosettaClass

public interface Lag extends RosettaModelObject {
	Lag build();
	Lag.LagBuilder toBuilder();
	
	/**
	 * Defines the offset of the series of pricing dates relative to the calculation period.
	 */
	Offset getFirstObservationDateOffset();
	/**
	 * Defines the offset of the series of pricing dates relative to the calculation period.
	 */
	Offset getLagDuration();
	final static LagMeta metaData = new LagMeta();
	
	@Override
	default RosettaMetaData<? extends Lag> metaData() {
		return metaData;
	} 
			
	static Lag.LagBuilder builder() {
		return new Lag.LagBuilderImpl();
	}
	
	default Class<? extends Lag> getType() {
		return Lag.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("firstObservationDateOffset"), processor, Offset.class, getFirstObservationDateOffset());
		processRosetta(path.newSubPath("lagDuration"), processor, Offset.class, getLagDuration());
	}
	
	
	interface LagBuilder extends Lag, RosettaModelObjectBuilder {
		Offset.OffsetBuilder getOrCreateFirstObservationDateOffset();
		Offset.OffsetBuilder getFirstObservationDateOffset();
		Offset.OffsetBuilder getOrCreateLagDuration();
		Offset.OffsetBuilder getLagDuration();
		Lag.LagBuilder setFirstObservationDateOffset(Offset firstObservationDateOffset);
		Lag.LagBuilder setLagDuration(Offset lagDuration);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("firstObservationDateOffset"), processor, Offset.OffsetBuilder.class, getFirstObservationDateOffset());
			processRosetta(path.newSubPath("lagDuration"), processor, Offset.OffsetBuilder.class, getLagDuration());
		}
		
	}
	
	//Lag.LagImpl
	class LagImpl implements Lag {
		private final Offset firstObservationDateOffset;
		private final Offset lagDuration;
		
		protected LagImpl(Lag.LagBuilder builder) {
			this.firstObservationDateOffset = ofNullable(builder.getFirstObservationDateOffset()).map(f->f.build()).orElse(null);
			this.lagDuration = ofNullable(builder.getLagDuration()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Offset getFirstObservationDateOffset() {
			return firstObservationDateOffset;
		}
		
		@Override
		public Offset getLagDuration() {
			return lagDuration;
		}
		
		@Override
		public Lag build() {
			return this;
		}
		
		@Override
		public Lag.LagBuilder toBuilder() {
			Lag.LagBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Lag.LagBuilder builder) {
			ofNullable(getFirstObservationDateOffset()).ifPresent(builder::setFirstObservationDateOffset);
			ofNullable(getLagDuration()).ifPresent(builder::setLagDuration);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lag _that = getType().cast(o);
		
			if (!Objects.equals(firstObservationDateOffset, _that.getFirstObservationDateOffset())) return false;
			if (!Objects.equals(lagDuration, _that.getLagDuration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (firstObservationDateOffset != null ? firstObservationDateOffset.hashCode() : 0);
			_result = 31 * _result + (lagDuration != null ? lagDuration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Lag {" +
				"firstObservationDateOffset=" + this.firstObservationDateOffset + ", " +
				"lagDuration=" + this.lagDuration +
			'}';
		}
	}
	
	//Lag.LagBuilderImpl
	class LagBuilderImpl implements Lag.LagBuilder {
	
		protected Offset.OffsetBuilder firstObservationDateOffset;
		protected Offset.OffsetBuilder lagDuration;
	
		public LagBuilderImpl() {
		}
	
		@Override
		public Offset.OffsetBuilder getFirstObservationDateOffset() {
			return firstObservationDateOffset;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateFirstObservationDateOffset() {
			Offset.OffsetBuilder result;
			if (firstObservationDateOffset!=null) {
				result = firstObservationDateOffset;
			}
			else {
				result = firstObservationDateOffset = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		public Offset.OffsetBuilder getLagDuration() {
			return lagDuration;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateLagDuration() {
			Offset.OffsetBuilder result;
			if (lagDuration!=null) {
				result = lagDuration;
			}
			else {
				result = lagDuration = Offset.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Lag.LagBuilder setFirstObservationDateOffset(Offset firstObservationDateOffset) {
			this.firstObservationDateOffset = firstObservationDateOffset==null?null:firstObservationDateOffset.toBuilder();
			return this;
		}
		@Override
		public Lag.LagBuilder setLagDuration(Offset lagDuration) {
			this.lagDuration = lagDuration==null?null:lagDuration.toBuilder();
			return this;
		}
		
		@Override
		public Lag build() {
			return new Lag.LagImpl(this);
		}
		
		@Override
		public Lag.LagBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lag.LagBuilder prune() {
			if (firstObservationDateOffset!=null && !firstObservationDateOffset.prune().hasData()) firstObservationDateOffset = null;
			if (lagDuration!=null && !lagDuration.prune().hasData()) lagDuration = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFirstObservationDateOffset()!=null && getFirstObservationDateOffset().hasData()) return true;
			if (getLagDuration()!=null && getLagDuration().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lag.LagBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Lag.LagBuilder o = (Lag.LagBuilder) other;
			
			merger.mergeRosetta(getFirstObservationDateOffset(), o.getFirstObservationDateOffset(), this::setFirstObservationDateOffset);
			merger.mergeRosetta(getLagDuration(), o.getLagDuration(), this::setLagDuration);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lag _that = getType().cast(o);
		
			if (!Objects.equals(firstObservationDateOffset, _that.getFirstObservationDateOffset())) return false;
			if (!Objects.equals(lagDuration, _that.getLagDuration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (firstObservationDateOffset != null ? firstObservationDateOffset.hashCode() : 0);
			_result = 31 * _result + (lagDuration != null ? lagDuration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LagBuilder {" +
				"firstObservationDateOffset=" + this.firstObservationDateOffset + ", " +
				"lagDuration=" + this.lagDuration +
			'}';
		}
	}
}
