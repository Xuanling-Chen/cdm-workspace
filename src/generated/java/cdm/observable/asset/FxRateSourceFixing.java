package cdm.observable.asset;

import cdm.base.datetime.AdjustableDate;
import cdm.observable.asset.meta.FxRateSourceFixingMeta;
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
 * Describes a rate source to be fixed and the date the fixing occurs
 * @version ${project.version}
 */
@RosettaClass

public interface FxRateSourceFixing extends RosettaModelObject {
	FxRateSourceFixing build();
	FxRateSourceFixing.FxRateSourceFixingBuilder toBuilder();
	
	/**
	 * The date on which the fixing is scheduled to occur.
	 */
	AdjustableDate getFixingDate();
	/**
	 */
	FxSettlementRateSource getSettlementRateSource();
	final static FxRateSourceFixingMeta metaData = new FxRateSourceFixingMeta();
	
	@Override
	default RosettaMetaData<? extends FxRateSourceFixing> metaData() {
		return metaData;
	} 
			
	static FxRateSourceFixing.FxRateSourceFixingBuilder builder() {
		return new FxRateSourceFixing.FxRateSourceFixingBuilderImpl();
	}
	
	default Class<? extends FxRateSourceFixing> getType() {
		return FxRateSourceFixing.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("fixingDate"), processor, AdjustableDate.class, getFixingDate());
		processRosetta(path.newSubPath("settlementRateSource"), processor, FxSettlementRateSource.class, getSettlementRateSource());
	}
	
	
	interface FxRateSourceFixingBuilder extends FxRateSourceFixing, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateFixingDate();
		AdjustableDate.AdjustableDateBuilder getFixingDate();
		FxSettlementRateSource.FxSettlementRateSourceBuilder getOrCreateSettlementRateSource();
		FxSettlementRateSource.FxSettlementRateSourceBuilder getSettlementRateSource();
		FxRateSourceFixing.FxRateSourceFixingBuilder setFixingDate(AdjustableDate fixingDate);
		FxRateSourceFixing.FxRateSourceFixingBuilder setSettlementRateSource(FxSettlementRateSource settlementRateSource);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("fixingDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getFixingDate());
			processRosetta(path.newSubPath("settlementRateSource"), processor, FxSettlementRateSource.FxSettlementRateSourceBuilder.class, getSettlementRateSource());
		}
		
	}
	
	//FxRateSourceFixing.FxRateSourceFixingImpl
	class FxRateSourceFixingImpl implements FxRateSourceFixing {
		private final AdjustableDate fixingDate;
		private final FxSettlementRateSource settlementRateSource;
		
		protected FxRateSourceFixingImpl(FxRateSourceFixing.FxRateSourceFixingBuilder builder) {
			this.fixingDate = ofNullable(builder.getFixingDate()).map(f->f.build()).orElse(null);
			this.settlementRateSource = ofNullable(builder.getSettlementRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AdjustableDate getFixingDate() {
			return fixingDate;
		}
		
		@Override
		public FxSettlementRateSource getSettlementRateSource() {
			return settlementRateSource;
		}
		
		@Override
		public FxRateSourceFixing build() {
			return this;
		}
		
		@Override
		public FxRateSourceFixing.FxRateSourceFixingBuilder toBuilder() {
			FxRateSourceFixing.FxRateSourceFixingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRateSourceFixing.FxRateSourceFixingBuilder builder) {
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getSettlementRateSource()).ifPresent(builder::setSettlementRateSource);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateSourceFixing _that = getType().cast(o);
		
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(settlementRateSource, _that.getSettlementRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (settlementRateSource != null ? settlementRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateSourceFixing {" +
				"fixingDate=" + this.fixingDate + ", " +
				"settlementRateSource=" + this.settlementRateSource +
			'}';
		}
	}
	
	//FxRateSourceFixing.FxRateSourceFixingBuilderImpl
	class FxRateSourceFixingBuilderImpl implements FxRateSourceFixing.FxRateSourceFixingBuilder {
	
		protected AdjustableDate.AdjustableDateBuilder fixingDate;
		protected FxSettlementRateSource.FxSettlementRateSourceBuilder settlementRateSource;
	
		public FxRateSourceFixingBuilderImpl() {
		}
	
		@Override
		public AdjustableDate.AdjustableDateBuilder getFixingDate() {
			return fixingDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateFixingDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (fixingDate!=null) {
				result = fixingDate;
			}
			else {
				result = fixingDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder getSettlementRateSource() {
			return settlementRateSource;
		}
		
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder getOrCreateSettlementRateSource() {
			FxSettlementRateSource.FxSettlementRateSourceBuilder result;
			if (settlementRateSource!=null) {
				result = settlementRateSource;
			}
			else {
				result = settlementRateSource = FxSettlementRateSource.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FxRateSourceFixing.FxRateSourceFixingBuilder setFixingDate(AdjustableDate fixingDate) {
			this.fixingDate = fixingDate==null?null:fixingDate.toBuilder();
			return this;
		}
		@Override
		public FxRateSourceFixing.FxRateSourceFixingBuilder setSettlementRateSource(FxSettlementRateSource settlementRateSource) {
			this.settlementRateSource = settlementRateSource==null?null:settlementRateSource.toBuilder();
			return this;
		}
		
		@Override
		public FxRateSourceFixing build() {
			return new FxRateSourceFixing.FxRateSourceFixingImpl(this);
		}
		
		@Override
		public FxRateSourceFixing.FxRateSourceFixingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateSourceFixing.FxRateSourceFixingBuilder prune() {
			if (fixingDate!=null && !fixingDate.prune().hasData()) fixingDate = null;
			if (settlementRateSource!=null && !settlementRateSource.prune().hasData()) settlementRateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixingDate()!=null && getFixingDate().hasData()) return true;
			if (getSettlementRateSource()!=null && getSettlementRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateSourceFixing.FxRateSourceFixingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxRateSourceFixing.FxRateSourceFixingBuilder o = (FxRateSourceFixing.FxRateSourceFixingBuilder) other;
			
			merger.mergeRosetta(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			merger.mergeRosetta(getSettlementRateSource(), o.getSettlementRateSource(), this::setSettlementRateSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateSourceFixing _that = getType().cast(o);
		
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(settlementRateSource, _that.getSettlementRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (settlementRateSource != null ? settlementRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateSourceFixingBuilder {" +
				"fixingDate=" + this.fixingDate + ", " +
				"settlementRateSource=" + this.settlementRateSource +
			'}';
		}
	}
}
