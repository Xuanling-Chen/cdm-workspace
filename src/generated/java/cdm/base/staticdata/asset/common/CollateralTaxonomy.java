package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.CollateralTaxonomyMeta;
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
 * Specifies the collateral taxonomy, which is composed of a taxonomy value and a taxonomy source.
 * @version ${project.version}
 */
@RosettaClass

public interface CollateralTaxonomy extends RosettaModelObject {
	CollateralTaxonomy build();
	CollateralTaxonomy.CollateralTaxonomyBuilder toBuilder();
	
	/**
	 * The taxonomy source.
	 */
	TaxonomySourceEnum getTaxonomySource();
	/**
	 * The taxonomy value.
	 */
	CollateralTaxonomyValue getTaxonomyValue();
	final static CollateralTaxonomyMeta metaData = new CollateralTaxonomyMeta();
	
	@Override
	default RosettaMetaData<? extends CollateralTaxonomy> metaData() {
		return metaData;
	} 
			
	static CollateralTaxonomy.CollateralTaxonomyBuilder builder() {
		return new CollateralTaxonomy.CollateralTaxonomyBuilderImpl();
	}
	
	default Class<? extends CollateralTaxonomy> getType() {
		return CollateralTaxonomy.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("taxonomySource"), TaxonomySourceEnum.class, getTaxonomySource(), this);
		
		processRosetta(path.newSubPath("taxonomyValue"), processor, CollateralTaxonomyValue.class, getTaxonomyValue());
	}
	
	
	interface CollateralTaxonomyBuilder extends CollateralTaxonomy, RosettaModelObjectBuilder {
		CollateralTaxonomyValue.CollateralTaxonomyValueBuilder getOrCreateTaxonomyValue();
		CollateralTaxonomyValue.CollateralTaxonomyValueBuilder getTaxonomyValue();
		CollateralTaxonomy.CollateralTaxonomyBuilder setTaxonomySource(TaxonomySourceEnum taxonomySource);
		CollateralTaxonomy.CollateralTaxonomyBuilder setTaxonomyValue(CollateralTaxonomyValue taxonomyValue);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("taxonomySource"), TaxonomySourceEnum.class, getTaxonomySource(), this);
			
			processRosetta(path.newSubPath("taxonomyValue"), processor, CollateralTaxonomyValue.CollateralTaxonomyValueBuilder.class, getTaxonomyValue());
		}
		
	}
	
	//CollateralTaxonomy.CollateralTaxonomyImpl
	class CollateralTaxonomyImpl implements CollateralTaxonomy {
		private final TaxonomySourceEnum taxonomySource;
		private final CollateralTaxonomyValue taxonomyValue;
		
		protected CollateralTaxonomyImpl(CollateralTaxonomy.CollateralTaxonomyBuilder builder) {
			this.taxonomySource = builder.getTaxonomySource();
			this.taxonomyValue = ofNullable(builder.getTaxonomyValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public TaxonomySourceEnum getTaxonomySource() {
			return taxonomySource;
		}
		
		@Override
		public CollateralTaxonomyValue getTaxonomyValue() {
			return taxonomyValue;
		}
		
		@Override
		public CollateralTaxonomy build() {
			return this;
		}
		
		@Override
		public CollateralTaxonomy.CollateralTaxonomyBuilder toBuilder() {
			CollateralTaxonomy.CollateralTaxonomyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralTaxonomy.CollateralTaxonomyBuilder builder) {
			ofNullable(getTaxonomySource()).ifPresent(builder::setTaxonomySource);
			ofNullable(getTaxonomyValue()).ifPresent(builder::setTaxonomyValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralTaxonomy _that = getType().cast(o);
		
			if (!Objects.equals(taxonomySource, _that.getTaxonomySource())) return false;
			if (!Objects.equals(taxonomyValue, _that.getTaxonomyValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taxonomySource != null ? taxonomySource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (taxonomyValue != null ? taxonomyValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralTaxonomy {" +
				"taxonomySource=" + this.taxonomySource + ", " +
				"taxonomyValue=" + this.taxonomyValue +
			'}';
		}
	}
	
	//CollateralTaxonomy.CollateralTaxonomyBuilderImpl
	class CollateralTaxonomyBuilderImpl implements CollateralTaxonomy.CollateralTaxonomyBuilder {
	
		protected TaxonomySourceEnum taxonomySource;
		protected CollateralTaxonomyValue.CollateralTaxonomyValueBuilder taxonomyValue;
	
		public CollateralTaxonomyBuilderImpl() {
		}
	
		@Override
		public TaxonomySourceEnum getTaxonomySource() {
			return taxonomySource;
		}
		
		@Override
		public CollateralTaxonomyValue.CollateralTaxonomyValueBuilder getTaxonomyValue() {
			return taxonomyValue;
		}
		
		@Override
		public CollateralTaxonomyValue.CollateralTaxonomyValueBuilder getOrCreateTaxonomyValue() {
			CollateralTaxonomyValue.CollateralTaxonomyValueBuilder result;
			if (taxonomyValue!=null) {
				result = taxonomyValue;
			}
			else {
				result = taxonomyValue = CollateralTaxonomyValue.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CollateralTaxonomy.CollateralTaxonomyBuilder setTaxonomySource(TaxonomySourceEnum taxonomySource) {
			this.taxonomySource = taxonomySource==null?null:taxonomySource;
			return this;
		}
		@Override
		public CollateralTaxonomy.CollateralTaxonomyBuilder setTaxonomyValue(CollateralTaxonomyValue taxonomyValue) {
			this.taxonomyValue = taxonomyValue==null?null:taxonomyValue.toBuilder();
			return this;
		}
		
		@Override
		public CollateralTaxonomy build() {
			return new CollateralTaxonomy.CollateralTaxonomyImpl(this);
		}
		
		@Override
		public CollateralTaxonomy.CollateralTaxonomyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralTaxonomy.CollateralTaxonomyBuilder prune() {
			if (taxonomyValue!=null && !taxonomyValue.prune().hasData()) taxonomyValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTaxonomySource()!=null) return true;
			if (getTaxonomyValue()!=null && getTaxonomyValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralTaxonomy.CollateralTaxonomyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralTaxonomy.CollateralTaxonomyBuilder o = (CollateralTaxonomy.CollateralTaxonomyBuilder) other;
			
			merger.mergeRosetta(getTaxonomyValue(), o.getTaxonomyValue(), this::setTaxonomyValue);
			
			merger.mergeBasic(getTaxonomySource(), o.getTaxonomySource(), this::setTaxonomySource);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralTaxonomy _that = getType().cast(o);
		
			if (!Objects.equals(taxonomySource, _that.getTaxonomySource())) return false;
			if (!Objects.equals(taxonomyValue, _that.getTaxonomyValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taxonomySource != null ? taxonomySource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (taxonomyValue != null ? taxonomyValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralTaxonomyBuilder {" +
				"taxonomySource=" + this.taxonomySource + ", " +
				"taxonomyValue=" + this.taxonomyValue +
			'}';
		}
	}
}
