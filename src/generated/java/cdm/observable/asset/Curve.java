package cdm.observable.asset;

import cdm.observable.asset.meta.CurveMeta;
import cdm.observable.asset.metafields.FieldWithMetaCommodityReferencePriceEnum;
import cdm.observable.asset.metafields.FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder;
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

public interface Curve extends RosettaModelObject {
	Curve build();
	Curve.CurveBuilder toBuilder();
	
	/**
	 */
	FieldWithMetaCommodityReferencePriceEnum getCommodityCurve();
	/**
	 */
	InterestRateCurve getInterestRateCurve();
	final static CurveMeta metaData = new CurveMeta();
	
	@Override
	default RosettaMetaData<? extends Curve> metaData() {
		return metaData;
	} 
			
	static Curve.CurveBuilder builder() {
		return new Curve.CurveBuilderImpl();
	}
	
	default Class<? extends Curve> getType() {
		return Curve.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("commodityCurve"), processor, FieldWithMetaCommodityReferencePriceEnum.class, getCommodityCurve());
		processRosetta(path.newSubPath("interestRateCurve"), processor, InterestRateCurve.class, getInterestRateCurve());
	}
	
	
	interface CurveBuilder extends Curve, RosettaModelObjectBuilder {
		FieldWithMetaCommodityReferencePriceEnumBuilder getOrCreateCommodityCurve();
		FieldWithMetaCommodityReferencePriceEnumBuilder getCommodityCurve();
		InterestRateCurve.InterestRateCurveBuilder getOrCreateInterestRateCurve();
		InterestRateCurve.InterestRateCurveBuilder getInterestRateCurve();
		Curve.CurveBuilder setCommodityCurve(FieldWithMetaCommodityReferencePriceEnum commodityCurve);
		Curve.CurveBuilder setCommodityCurveValue(CommodityReferencePriceEnum commodityCurve);
		Curve.CurveBuilder setInterestRateCurve(InterestRateCurve interestRateCurve);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("commodityCurve"), processor, FieldWithMetaCommodityReferencePriceEnumBuilder.class, getCommodityCurve());
			processRosetta(path.newSubPath("interestRateCurve"), processor, InterestRateCurve.InterestRateCurveBuilder.class, getInterestRateCurve());
		}
		
	}
	
	//Curve.CurveImpl
	class CurveImpl implements Curve {
		private final FieldWithMetaCommodityReferencePriceEnum commodityCurve;
		private final InterestRateCurve interestRateCurve;
		
		protected CurveImpl(Curve.CurveBuilder builder) {
			this.commodityCurve = ofNullable(builder.getCommodityCurve()).map(f->f.build()).orElse(null);
			this.interestRateCurve = ofNullable(builder.getInterestRateCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaCommodityReferencePriceEnum getCommodityCurve() {
			return commodityCurve;
		}
		
		@Override
		public InterestRateCurve getInterestRateCurve() {
			return interestRateCurve;
		}
		
		@Override
		public Curve build() {
			return this;
		}
		
		@Override
		public Curve.CurveBuilder toBuilder() {
			Curve.CurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Curve.CurveBuilder builder) {
			ofNullable(getCommodityCurve()).ifPresent(builder::setCommodityCurve);
			ofNullable(getInterestRateCurve()).ifPresent(builder::setInterestRateCurve);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Curve _that = getType().cast(o);
		
			if (!Objects.equals(commodityCurve, _that.getCommodityCurve())) return false;
			if (!Objects.equals(interestRateCurve, _that.getInterestRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityCurve != null ? commodityCurve.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (interestRateCurve != null ? interestRateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Curve {" +
				"commodityCurve=" + this.commodityCurve + ", " +
				"interestRateCurve=" + this.interestRateCurve +
			'}';
		}
	}
	
	//Curve.CurveBuilderImpl
	class CurveBuilderImpl implements Curve.CurveBuilder {
	
		protected FieldWithMetaCommodityReferencePriceEnumBuilder commodityCurve;
		protected InterestRateCurve.InterestRateCurveBuilder interestRateCurve;
	
		public CurveBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaCommodityReferencePriceEnumBuilder getCommodityCurve() {
			return commodityCurve;
		}
		
		@Override
		public FieldWithMetaCommodityReferencePriceEnumBuilder getOrCreateCommodityCurve() {
			FieldWithMetaCommodityReferencePriceEnumBuilder result;
			if (commodityCurve!=null) {
				result = commodityCurve;
			}
			else {
				result = commodityCurve = FieldWithMetaCommodityReferencePriceEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public InterestRateCurve.InterestRateCurveBuilder getInterestRateCurve() {
			return interestRateCurve;
		}
		
		@Override
		public InterestRateCurve.InterestRateCurveBuilder getOrCreateInterestRateCurve() {
			InterestRateCurve.InterestRateCurveBuilder result;
			if (interestRateCurve!=null) {
				result = interestRateCurve;
			}
			else {
				result = interestRateCurve = InterestRateCurve.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Curve.CurveBuilder setCommodityCurve(FieldWithMetaCommodityReferencePriceEnum commodityCurve) {
			this.commodityCurve = commodityCurve==null?null:commodityCurve.toBuilder();
			return this;
		}
		
		@Override
		public Curve.CurveBuilder setCommodityCurveValue(CommodityReferencePriceEnum commodityCurve) {
			this.getOrCreateCommodityCurve().setValue(commodityCurve);
			return this;
		}
		@Override
		public Curve.CurveBuilder setInterestRateCurve(InterestRateCurve interestRateCurve) {
			this.interestRateCurve = interestRateCurve==null?null:interestRateCurve.toBuilder();
			return this;
		}
		
		@Override
		public Curve build() {
			return new Curve.CurveImpl(this);
		}
		
		@Override
		public Curve.CurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Curve.CurveBuilder prune() {
			if (commodityCurve!=null && !commodityCurve.prune().hasData()) commodityCurve = null;
			if (interestRateCurve!=null && !interestRateCurve.prune().hasData()) interestRateCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityCurve()!=null) return true;
			if (getInterestRateCurve()!=null && getInterestRateCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Curve.CurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Curve.CurveBuilder o = (Curve.CurveBuilder) other;
			
			merger.mergeRosetta(getCommodityCurve(), o.getCommodityCurve(), this::setCommodityCurve);
			merger.mergeRosetta(getInterestRateCurve(), o.getInterestRateCurve(), this::setInterestRateCurve);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Curve _that = getType().cast(o);
		
			if (!Objects.equals(commodityCurve, _that.getCommodityCurve())) return false;
			if (!Objects.equals(interestRateCurve, _that.getInterestRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityCurve != null ? commodityCurve.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (interestRateCurve != null ? interestRateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurveBuilder {" +
				"commodityCurve=" + this.commodityCurve + ", " +
				"interestRateCurve=" + this.interestRateCurve +
			'}';
		}
	}
}
