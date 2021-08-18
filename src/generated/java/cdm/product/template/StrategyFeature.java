package cdm.product.template;

import cdm.product.template.meta.StrategyFeatureMeta;
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
 * A class for defining option strategy features.
 * @version ${project.version}
 */
@RosettaClass

public interface StrategyFeature extends RosettaModelObject {
	StrategyFeature build();
	StrategyFeature.StrategyFeatureBuilder toBuilder();
	
	/**
	 * Definition of the later expiration date in a calendar spread.
	 */
	CalendarSpread getCalendarSpread();
	/**
	 * Definition of the upper strike in a strike spread.
	 */
	StrikeSpread getStrikeSpread();
	final static StrategyFeatureMeta metaData = new StrategyFeatureMeta();
	
	@Override
	default RosettaMetaData<? extends StrategyFeature> metaData() {
		return metaData;
	} 
			
	static StrategyFeature.StrategyFeatureBuilder builder() {
		return new StrategyFeature.StrategyFeatureBuilderImpl();
	}
	
	default Class<? extends StrategyFeature> getType() {
		return StrategyFeature.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("calendarSpread"), processor, CalendarSpread.class, getCalendarSpread());
		processRosetta(path.newSubPath("strikeSpread"), processor, StrikeSpread.class, getStrikeSpread());
	}
	
	
	interface StrategyFeatureBuilder extends StrategyFeature, RosettaModelObjectBuilder {
		CalendarSpread.CalendarSpreadBuilder getOrCreateCalendarSpread();
		CalendarSpread.CalendarSpreadBuilder getCalendarSpread();
		StrikeSpread.StrikeSpreadBuilder getOrCreateStrikeSpread();
		StrikeSpread.StrikeSpreadBuilder getStrikeSpread();
		StrategyFeature.StrategyFeatureBuilder setCalendarSpread(CalendarSpread calendarSpread);
		StrategyFeature.StrategyFeatureBuilder setStrikeSpread(StrikeSpread strikeSpread);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("calendarSpread"), processor, CalendarSpread.CalendarSpreadBuilder.class, getCalendarSpread());
			processRosetta(path.newSubPath("strikeSpread"), processor, StrikeSpread.StrikeSpreadBuilder.class, getStrikeSpread());
		}
		
	}
	
	//StrategyFeature.StrategyFeatureImpl
	class StrategyFeatureImpl implements StrategyFeature {
		private final CalendarSpread calendarSpread;
		private final StrikeSpread strikeSpread;
		
		protected StrategyFeatureImpl(StrategyFeature.StrategyFeatureBuilder builder) {
			this.calendarSpread = ofNullable(builder.getCalendarSpread()).map(f->f.build()).orElse(null);
			this.strikeSpread = ofNullable(builder.getStrikeSpread()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CalendarSpread getCalendarSpread() {
			return calendarSpread;
		}
		
		@Override
		public StrikeSpread getStrikeSpread() {
			return strikeSpread;
		}
		
		@Override
		public StrategyFeature build() {
			return this;
		}
		
		@Override
		public StrategyFeature.StrategyFeatureBuilder toBuilder() {
			StrategyFeature.StrategyFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StrategyFeature.StrategyFeatureBuilder builder) {
			ofNullable(getCalendarSpread()).ifPresent(builder::setCalendarSpread);
			ofNullable(getStrikeSpread()).ifPresent(builder::setStrikeSpread);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StrategyFeature _that = getType().cast(o);
		
			if (!Objects.equals(calendarSpread, _that.getCalendarSpread())) return false;
			if (!Objects.equals(strikeSpread, _that.getStrikeSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calendarSpread != null ? calendarSpread.hashCode() : 0);
			_result = 31 * _result + (strikeSpread != null ? strikeSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrategyFeature {" +
				"calendarSpread=" + this.calendarSpread + ", " +
				"strikeSpread=" + this.strikeSpread +
			'}';
		}
	}
	
	//StrategyFeature.StrategyFeatureBuilderImpl
	class StrategyFeatureBuilderImpl implements StrategyFeature.StrategyFeatureBuilder {
	
		protected CalendarSpread.CalendarSpreadBuilder calendarSpread;
		protected StrikeSpread.StrikeSpreadBuilder strikeSpread;
	
		public StrategyFeatureBuilderImpl() {
		}
	
		@Override
		public CalendarSpread.CalendarSpreadBuilder getCalendarSpread() {
			return calendarSpread;
		}
		
		@Override
		public CalendarSpread.CalendarSpreadBuilder getOrCreateCalendarSpread() {
			CalendarSpread.CalendarSpreadBuilder result;
			if (calendarSpread!=null) {
				result = calendarSpread;
			}
			else {
				result = calendarSpread = CalendarSpread.builder();
			}
			
			return result;
		}
		
		@Override
		public StrikeSpread.StrikeSpreadBuilder getStrikeSpread() {
			return strikeSpread;
		}
		
		@Override
		public StrikeSpread.StrikeSpreadBuilder getOrCreateStrikeSpread() {
			StrikeSpread.StrikeSpreadBuilder result;
			if (strikeSpread!=null) {
				result = strikeSpread;
			}
			else {
				result = strikeSpread = StrikeSpread.builder();
			}
			
			return result;
		}
		
	
		@Override
		public StrategyFeature.StrategyFeatureBuilder setCalendarSpread(CalendarSpread calendarSpread) {
			this.calendarSpread = calendarSpread==null?null:calendarSpread.toBuilder();
			return this;
		}
		@Override
		public StrategyFeature.StrategyFeatureBuilder setStrikeSpread(StrikeSpread strikeSpread) {
			this.strikeSpread = strikeSpread==null?null:strikeSpread.toBuilder();
			return this;
		}
		
		@Override
		public StrategyFeature build() {
			return new StrategyFeature.StrategyFeatureImpl(this);
		}
		
		@Override
		public StrategyFeature.StrategyFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrategyFeature.StrategyFeatureBuilder prune() {
			if (calendarSpread!=null && !calendarSpread.prune().hasData()) calendarSpread = null;
			if (strikeSpread!=null && !strikeSpread.prune().hasData()) strikeSpread = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalendarSpread()!=null && getCalendarSpread().hasData()) return true;
			if (getStrikeSpread()!=null && getStrikeSpread().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrategyFeature.StrategyFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StrategyFeature.StrategyFeatureBuilder o = (StrategyFeature.StrategyFeatureBuilder) other;
			
			merger.mergeRosetta(getCalendarSpread(), o.getCalendarSpread(), this::setCalendarSpread);
			merger.mergeRosetta(getStrikeSpread(), o.getStrikeSpread(), this::setStrikeSpread);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StrategyFeature _that = getType().cast(o);
		
			if (!Objects.equals(calendarSpread, _that.getCalendarSpread())) return false;
			if (!Objects.equals(strikeSpread, _that.getStrikeSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calendarSpread != null ? calendarSpread.hashCode() : 0);
			_result = 31 * _result + (strikeSpread != null ? strikeSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrategyFeatureBuilder {" +
				"calendarSpread=" + this.calendarSpread + ", " +
				"strikeSpread=" + this.strikeSpread +
			'}';
		}
	}
}
