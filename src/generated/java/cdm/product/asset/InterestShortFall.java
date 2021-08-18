package cdm.product.asset;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder;
import cdm.product.asset.meta.InterestShortFallMeta;
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
 * A class to specify the interest shortfall floating rate payment event.
 * @version ${project.version}
 */
@RosettaClass

public interface InterestShortFall extends RosettaModelObject {
	InterestShortFall build();
	InterestShortFall.InterestShortFallBuilder toBuilder();
	
	/**
	 */
	Boolean getCompounding();
	/**
	 * Specifies the nature of the interest Shortfall cap (i.e. Fixed Cap or Variable Cap) in the case where it is applicable. ISDA 2003 Term: Interest Shortfall Cap.
	 */
	InterestShortfallCapEnum getInterestShortfallCap();
	/**
	 * The rate source in the case of a variable cap.
	 */
	FieldWithMetaFloatingRateIndexEnum getRateSource();
	final static InterestShortFallMeta metaData = new InterestShortFallMeta();
	
	@Override
	default RosettaMetaData<? extends InterestShortFall> metaData() {
		return metaData;
	} 
			
	static InterestShortFall.InterestShortFallBuilder builder() {
		return new InterestShortFall.InterestShortFallBuilderImpl();
	}
	
	default Class<? extends InterestShortFall> getType() {
		return InterestShortFall.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("compounding"), Boolean.class, getCompounding(), this);
		processor.processBasic(path.newSubPath("interestShortfallCap"), InterestShortfallCapEnum.class, getInterestShortfallCap(), this);
		
		processRosetta(path.newSubPath("rateSource"), processor, FieldWithMetaFloatingRateIndexEnum.class, getRateSource());
	}
	
	
	interface InterestShortFallBuilder extends InterestShortFall, RosettaModelObjectBuilder {
		FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateRateSource();
		FieldWithMetaFloatingRateIndexEnumBuilder getRateSource();
		InterestShortFall.InterestShortFallBuilder setCompounding(Boolean compounding);
		InterestShortFall.InterestShortFallBuilder setInterestShortfallCap(InterestShortfallCapEnum interestShortfallCap);
		InterestShortFall.InterestShortFallBuilder setRateSource(FieldWithMetaFloatingRateIndexEnum rateSource);
		InterestShortFall.InterestShortFallBuilder setRateSourceValue(FloatingRateIndexEnum rateSource);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("compounding"), Boolean.class, getCompounding(), this);
			processor.processBasic(path.newSubPath("interestShortfallCap"), InterestShortfallCapEnum.class, getInterestShortfallCap(), this);
			
			processRosetta(path.newSubPath("rateSource"), processor, FieldWithMetaFloatingRateIndexEnumBuilder.class, getRateSource());
		}
		
	}
	
	//InterestShortFall.InterestShortFallImpl
	class InterestShortFallImpl implements InterestShortFall {
		private final Boolean compounding;
		private final InterestShortfallCapEnum interestShortfallCap;
		private final FieldWithMetaFloatingRateIndexEnum rateSource;
		
		protected InterestShortFallImpl(InterestShortFall.InterestShortFallBuilder builder) {
			this.compounding = builder.getCompounding();
			this.interestShortfallCap = builder.getInterestShortfallCap();
			this.rateSource = ofNullable(builder.getRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getCompounding() {
			return compounding;
		}
		
		@Override
		public InterestShortfallCapEnum getInterestShortfallCap() {
			return interestShortfallCap;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum getRateSource() {
			return rateSource;
		}
		
		@Override
		public InterestShortFall build() {
			return this;
		}
		
		@Override
		public InterestShortFall.InterestShortFallBuilder toBuilder() {
			InterestShortFall.InterestShortFallBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestShortFall.InterestShortFallBuilder builder) {
			ofNullable(getCompounding()).ifPresent(builder::setCompounding);
			ofNullable(getInterestShortfallCap()).ifPresent(builder::setInterestShortfallCap);
			ofNullable(getRateSource()).ifPresent(builder::setRateSource);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestShortFall _that = getType().cast(o);
		
			if (!Objects.equals(compounding, _that.getCompounding())) return false;
			if (!Objects.equals(interestShortfallCap, _that.getInterestShortfallCap())) return false;
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compounding != null ? compounding.hashCode() : 0);
			_result = 31 * _result + (interestShortfallCap != null ? interestShortfallCap.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rateSource != null ? rateSource.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestShortFall {" +
				"compounding=" + this.compounding + ", " +
				"interestShortfallCap=" + this.interestShortfallCap + ", " +
				"rateSource=" + this.rateSource +
			'}';
		}
	}
	
	//InterestShortFall.InterestShortFallBuilderImpl
	class InterestShortFallBuilderImpl implements InterestShortFall.InterestShortFallBuilder {
	
		protected Boolean compounding;
		protected InterestShortfallCapEnum interestShortfallCap;
		protected FieldWithMetaFloatingRateIndexEnumBuilder rateSource;
	
		public InterestShortFallBuilderImpl() {
		}
	
		@Override
		public Boolean getCompounding() {
			return compounding;
		}
		
		@Override
		public InterestShortfallCapEnum getInterestShortfallCap() {
			return interestShortfallCap;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnumBuilder getRateSource() {
			return rateSource;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateRateSource() {
			FieldWithMetaFloatingRateIndexEnumBuilder result;
			if (rateSource!=null) {
				result = rateSource;
			}
			else {
				result = rateSource = FieldWithMetaFloatingRateIndexEnum.builder();
			}
			
			return result;
		}
		
	
		@Override
		public InterestShortFall.InterestShortFallBuilder setCompounding(Boolean compounding) {
			this.compounding = compounding==null?null:compounding;
			return this;
		}
		@Override
		public InterestShortFall.InterestShortFallBuilder setInterestShortfallCap(InterestShortfallCapEnum interestShortfallCap) {
			this.interestShortfallCap = interestShortfallCap==null?null:interestShortfallCap;
			return this;
		}
		@Override
		public InterestShortFall.InterestShortFallBuilder setRateSource(FieldWithMetaFloatingRateIndexEnum rateSource) {
			this.rateSource = rateSource==null?null:rateSource.toBuilder();
			return this;
		}
		
		@Override
		public InterestShortFall.InterestShortFallBuilder setRateSourceValue(FloatingRateIndexEnum rateSource) {
			this.getOrCreateRateSource().setValue(rateSource);
			return this;
		}
		
		@Override
		public InterestShortFall build() {
			return new InterestShortFall.InterestShortFallImpl(this);
		}
		
		@Override
		public InterestShortFall.InterestShortFallBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestShortFall.InterestShortFallBuilder prune() {
			if (rateSource!=null && !rateSource.prune().hasData()) rateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCompounding()!=null) return true;
			if (getInterestShortfallCap()!=null) return true;
			if (getRateSource()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestShortFall.InterestShortFallBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestShortFall.InterestShortFallBuilder o = (InterestShortFall.InterestShortFallBuilder) other;
			
			merger.mergeRosetta(getRateSource(), o.getRateSource(), this::setRateSource);
			
			merger.mergeBasic(getCompounding(), o.getCompounding(), this::setCompounding);
			merger.mergeBasic(getInterestShortfallCap(), o.getInterestShortfallCap(), this::setInterestShortfallCap);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestShortFall _that = getType().cast(o);
		
			if (!Objects.equals(compounding, _that.getCompounding())) return false;
			if (!Objects.equals(interestShortfallCap, _that.getInterestShortfallCap())) return false;
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compounding != null ? compounding.hashCode() : 0);
			_result = 31 * _result + (interestShortfallCap != null ? interestShortfallCap.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rateSource != null ? rateSource.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestShortFallBuilder {" +
				"compounding=" + this.compounding + ", " +
				"interestShortfallCap=" + this.interestShortfallCap + ", " +
				"rateSource=" + this.rateSource +
			'}';
		}
	}
}
