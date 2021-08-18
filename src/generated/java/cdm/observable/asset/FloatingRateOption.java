package cdm.observable.asset;

import cdm.base.datetime.Period;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder;
import cdm.observable.asset.meta.FloatingRateOptionMeta;
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
 * Specification of a floating rate option as a floating rate index and tenor.
 * @version ${project.version}
 */
@RosettaClass

public interface FloatingRateOption extends RosettaModelObject {
	FloatingRateOption build();
	FloatingRateOption.FloatingRateOptionBuilder toBuilder();
	
	/**
	 * The reference index that is used to specify the floating interest rate. The FpML standard maintains the list of such indices, which are positioned as enumeration values as part of the CDM.
	 */
	FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex();
	/**
	 * The ISDA Designated Maturity, i.e. the floating rate tenor.
	 */
	Period getIndexTenor();
	final static FloatingRateOptionMeta metaData = new FloatingRateOptionMeta();
	
	@Override
	default RosettaMetaData<? extends FloatingRateOption> metaData() {
		return metaData;
	} 
			
	static FloatingRateOption.FloatingRateOptionBuilder builder() {
		return new FloatingRateOption.FloatingRateOptionBuilderImpl();
	}
	
	default Class<? extends FloatingRateOption> getType() {
		return FloatingRateOption.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnum.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
	}
	
	
	interface FloatingRateOptionBuilder extends FloatingRateOption, RosettaModelObjectBuilder {
		FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex();
		FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		Period.PeriodBuilder getIndexTenor();
		FloatingRateOption.FloatingRateOptionBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum floatingRateIndex);
		FloatingRateOption.FloatingRateOptionBuilder setFloatingRateIndexValue(FloatingRateIndexEnum floatingRateIndex);
		FloatingRateOption.FloatingRateOptionBuilder setIndexTenor(Period indexTenor);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnumBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
		}
		
	}
	
	//FloatingRateOption.FloatingRateOptionImpl
	class FloatingRateOptionImpl implements FloatingRateOption {
		private final FieldWithMetaFloatingRateIndexEnum floatingRateIndex;
		private final Period indexTenor;
		
		protected FloatingRateOptionImpl(FloatingRateOption.FloatingRateOptionBuilder builder) {
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public FloatingRateOption build() {
			return this;
		}
		
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder toBuilder() {
			FloatingRateOption.FloatingRateOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateOption.FloatingRateOptionBuilder builder) {
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateOption {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}
	
	//FloatingRateOption.FloatingRateOptionBuilderImpl
	class FloatingRateOptionBuilderImpl implements FloatingRateOption.FloatingRateOptionBuilder {
	
		protected FieldWithMetaFloatingRateIndexEnumBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
	
		public FloatingRateOptionBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex() {
			FieldWithMetaFloatingRateIndexEnumBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FieldWithMetaFloatingRateIndexEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public Period.PeriodBuilder getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor() {
			Period.PeriodBuilder result;
			if (indexTenor!=null) {
				result = indexTenor;
			}
			else {
				result = indexTenor = Period.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder setFloatingRateIndexValue(FloatingRateIndexEnum floatingRateIndex) {
			this.getOrCreateFloatingRateIndex().setValue(floatingRateIndex);
			return this;
		}
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder setIndexTenor(Period indexTenor) {
			this.indexTenor = indexTenor==null?null:indexTenor.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateOption build() {
			return new FloatingRateOption.FloatingRateOptionImpl(this);
		}
		
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder prune() {
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateIndex()!=null) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateOption.FloatingRateOptionBuilder o = (FloatingRateOption.FloatingRateOptionBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateOptionBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}
}
