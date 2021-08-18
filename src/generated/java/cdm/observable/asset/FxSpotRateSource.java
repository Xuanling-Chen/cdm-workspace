package cdm.observable.asset;

import cdm.observable.asset.meta.FxSpotRateSourceMeta;
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
 * A class defining the rate source and fixing time for an FX rate.
 * @version ${project.version}
 */
@RosettaClass

public interface FxSpotRateSource extends RosettaModelObject {
	FxSpotRateSource build();
	FxSpotRateSource.FxSpotRateSourceBuilder toBuilder();
	
	/**
	 * The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 */
	InformationSource getPrimaryRateSource();
	/**
	 * An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 */
	InformationSource getSecondaryRateSource();
	final static FxSpotRateSourceMeta metaData = new FxSpotRateSourceMeta();
	
	@Override
	default RosettaMetaData<? extends FxSpotRateSource> metaData() {
		return metaData;
	} 
			
	static FxSpotRateSource.FxSpotRateSourceBuilder builder() {
		return new FxSpotRateSource.FxSpotRateSourceBuilderImpl();
	}
	
	default Class<? extends FxSpotRateSource> getType() {
		return FxSpotRateSource.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.class, getSecondaryRateSource());
	}
	
	
	interface FxSpotRateSourceBuilder extends FxSpotRateSource, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource();
		InformationSource.InformationSourceBuilder getPrimaryRateSource();
		InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource();
		InformationSource.InformationSourceBuilder getSecondaryRateSource();
		FxSpotRateSource.FxSpotRateSourceBuilder setPrimaryRateSource(InformationSource primaryRateSource);
		FxSpotRateSource.FxSpotRateSourceBuilder setSecondaryRateSource(InformationSource secondaryRateSource);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getSecondaryRateSource());
		}
		
	}
	
	//FxSpotRateSource.FxSpotRateSourceImpl
	class FxSpotRateSourceImpl implements FxSpotRateSource {
		private final InformationSource primaryRateSource;
		private final InformationSource secondaryRateSource;
		
		protected FxSpotRateSourceImpl(FxSpotRateSource.FxSpotRateSourceBuilder builder) {
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public InformationSource getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		public InformationSource getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		public FxSpotRateSource build() {
			return this;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder toBuilder() {
			FxSpotRateSource.FxSpotRateSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSpotRateSource.FxSpotRateSourceBuilder builder) {
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSpotRateSource _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSpotRateSource {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource +
			'}';
		}
	}
	
	//FxSpotRateSource.FxSpotRateSourceBuilderImpl
	class FxSpotRateSourceBuilderImpl implements FxSpotRateSource.FxSpotRateSourceBuilder {
	
		protected InformationSource.InformationSourceBuilder primaryRateSource;
		protected InformationSource.InformationSourceBuilder secondaryRateSource;
	
		public FxSpotRateSourceBuilderImpl() {
		}
	
		@Override
		public InformationSource.InformationSourceBuilder getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (primaryRateSource!=null) {
				result = primaryRateSource;
			}
			else {
				result = primaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (secondaryRateSource!=null) {
				result = secondaryRateSource;
			}
			else {
				result = secondaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder setPrimaryRateSource(InformationSource primaryRateSource) {
			this.primaryRateSource = primaryRateSource==null?null:primaryRateSource.toBuilder();
			return this;
		}
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder setSecondaryRateSource(InformationSource secondaryRateSource) {
			this.secondaryRateSource = secondaryRateSource==null?null:secondaryRateSource.toBuilder();
			return this;
		}
		
		@Override
		public FxSpotRateSource build() {
			return new FxSpotRateSource.FxSpotRateSourceImpl(this);
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder prune() {
			if (primaryRateSource!=null && !primaryRateSource.prune().hasData()) primaryRateSource = null;
			if (secondaryRateSource!=null && !secondaryRateSource.prune().hasData()) secondaryRateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryRateSource()!=null && getPrimaryRateSource().hasData()) return true;
			if (getSecondaryRateSource()!=null && getSecondaryRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxSpotRateSource.FxSpotRateSourceBuilder o = (FxSpotRateSource.FxSpotRateSourceBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::setSecondaryRateSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSpotRateSource _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSpotRateSourceBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource +
			'}';
		}
	}
}
