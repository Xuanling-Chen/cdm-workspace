package cdm.product.template;

import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.RelativeDateOffset;
import cdm.observable.asset.FxSpotRateSource;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.product.template.meta.CompositeMeta;
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
 * Specifies the conditions to be applied for converting into a reference currency when the actual currency rate is not determined upfront.
 * @version ${project.version}
 */
@RosettaClass

public interface Composite extends RosettaModelObject {
	Composite build();
	Composite.CompositeBuilder toBuilder();
	
	/**
	 * Specifies the method according to which an amount or a date is determined.
	 */
	DeterminationMethodEnum getDeterminationMethod();
	/**
	 * The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
	 */
	BusinessCenterTime getFixingTime();
	/**
	 * Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
	 */
	FxSpotRateSource getFxSpotRateSource();
	/**
	 * A date specified as some offset to another date (the anchor date).
	 */
	RelativeDateOffset getRelativeDate();
	final static CompositeMeta metaData = new CompositeMeta();
	
	@Override
	default RosettaMetaData<? extends Composite> metaData() {
		return metaData;
	} 
			
	static Composite.CompositeBuilder builder() {
		return new Composite.CompositeBuilderImpl();
	}
	
	default Class<? extends Composite> getType() {
		return Composite.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
		
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
		processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.class, getFxSpotRateSource());
		processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.class, getRelativeDate());
	}
	
	
	interface CompositeBuilder extends Composite, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource();
		FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate();
		Composite.CompositeBuilder setDeterminationMethod(DeterminationMethodEnum determinationMethod);
		Composite.CompositeBuilder setFixingTime(BusinessCenterTime fixingTime);
		Composite.CompositeBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource);
		Composite.CompositeBuilder setRelativeDate(RelativeDateOffset relativeDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
			
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
			processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFxSpotRateSource());
			processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeDate());
		}
		
	}
	
	//Composite.CompositeImpl
	class CompositeImpl implements Composite {
		private final DeterminationMethodEnum determinationMethod;
		private final BusinessCenterTime fixingTime;
		private final FxSpotRateSource fxSpotRateSource;
		private final RelativeDateOffset relativeDate;
		
		protected CompositeImpl(Composite.CompositeBuilder builder) {
			this.determinationMethod = builder.getDeterminationMethod();
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.fxSpotRateSource = ofNullable(builder.getFxSpotRateSource()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public FxSpotRateSource getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		public RelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public Composite build() {
			return this;
		}
		
		@Override
		public Composite.CompositeBuilder toBuilder() {
			Composite.CompositeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Composite.CompositeBuilder builder) {
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getFxSpotRateSource()).ifPresent(builder::setFxSpotRateSource);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Composite _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Composite {" +
				"determinationMethod=" + this.determinationMethod + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}
	
	//Composite.CompositeBuilderImpl
	class CompositeBuilderImpl implements Composite.CompositeBuilder {
	
		protected DeterminationMethodEnum determinationMethod;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		protected FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSource;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeDate;
	
		public CompositeBuilderImpl() {
		}
	
		@Override
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (fxSpotRateSource!=null) {
				result = fxSpotRateSource;
			}
			else {
				result = fxSpotRateSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeDate!=null) {
				result = relativeDate;
			}
			else {
				result = relativeDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Composite.CompositeBuilder setDeterminationMethod(DeterminationMethodEnum determinationMethod) {
			this.determinationMethod = determinationMethod==null?null:determinationMethod;
			return this;
		}
		@Override
		public Composite.CompositeBuilder setFixingTime(BusinessCenterTime fixingTime) {
			this.fixingTime = fixingTime==null?null:fixingTime.toBuilder();
			return this;
		}
		@Override
		public Composite.CompositeBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource) {
			this.fxSpotRateSource = fxSpotRateSource==null?null:fxSpotRateSource.toBuilder();
			return this;
		}
		@Override
		public Composite.CompositeBuilder setRelativeDate(RelativeDateOffset relativeDate) {
			this.relativeDate = relativeDate==null?null:relativeDate.toBuilder();
			return this;
		}
		
		@Override
		public Composite build() {
			return new Composite.CompositeImpl(this);
		}
		
		@Override
		public Composite.CompositeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Composite.CompositeBuilder prune() {
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			if (fxSpotRateSource!=null && !fxSpotRateSource.prune().hasData()) fxSpotRateSource = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeterminationMethod()!=null) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getFxSpotRateSource()!=null && getFxSpotRateSource().hasData()) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Composite.CompositeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Composite.CompositeBuilder o = (Composite.CompositeBuilder) other;
			
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getFxSpotRateSource(), o.getFxSpotRateSource(), this::setFxSpotRateSource);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			
			merger.mergeBasic(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Composite _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompositeBuilder {" +
				"determinationMethod=" + this.determinationMethod + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}
}
