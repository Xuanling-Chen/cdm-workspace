package cdm.event.position;

import cdm.event.position.meta.FxRateObservableMeta;
import cdm.observable.asset.InformationSource;
import cdm.observable.asset.QuotedCurrencyPair;
import cdm.observable.asset.QuotedCurrencyPair;
import cdm.observable.asset.metafields.ReferenceWithMetaQuotedCurrencyPair;
import cdm.observable.asset.metafields.ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder;
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
 * Defines foreign exchange (FX) asset class specific parameters for market observations.
 * @version ${project.version}
 */
@RosettaClass

public interface FxRateObservable extends RosettaModelObject {
	FxRateObservable build();
	FxRateObservable.FxRateObservableBuilder toBuilder();
	
	/**
	 * Specifies the primary source from which a rate should be observed.
	 */
	InformationSource getPrimaryFxSpotRateSource();
	/**
	 * Describes the composition of a rate that has been quoted or is to be quoted.
	 */
	ReferenceWithMetaQuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * Specifies an alternative, or secondary, source from which a rate should be observed.
	 */
	InformationSource getSecondaryFxSpotRateSource();
	final static FxRateObservableMeta metaData = new FxRateObservableMeta();
	
	@Override
	default RosettaMetaData<? extends FxRateObservable> metaData() {
		return metaData;
	} 
			
	static FxRateObservable.FxRateObservableBuilder builder() {
		return new FxRateObservable.FxRateObservableBuilderImpl();
	}
	
	default Class<? extends FxRateObservable> getType() {
		return FxRateObservable.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("primaryFxSpotRateSource"), processor, InformationSource.class, getPrimaryFxSpotRateSource());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, ReferenceWithMetaQuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("secondaryFxSpotRateSource"), processor, InformationSource.class, getSecondaryFxSpotRateSource());
	}
	
	
	interface FxRateObservableBuilder extends FxRateObservable, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreatePrimaryFxSpotRateSource();
		InformationSource.InformationSourceBuilder getPrimaryFxSpotRateSource();
		ReferenceWithMetaQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		ReferenceWithMetaQuotedCurrencyPairBuilder getQuotedCurrencyPair();
		InformationSource.InformationSourceBuilder getOrCreateSecondaryFxSpotRateSource();
		InformationSource.InformationSourceBuilder getSecondaryFxSpotRateSource();
		FxRateObservable.FxRateObservableBuilder setPrimaryFxSpotRateSource(InformationSource primaryFxSpotRateSource);
		FxRateObservable.FxRateObservableBuilder setQuotedCurrencyPair(ReferenceWithMetaQuotedCurrencyPair quotedCurrencyPair);
		FxRateObservable.FxRateObservableBuilder setQuotedCurrencyPairValue(QuotedCurrencyPair quotedCurrencyPair);
		FxRateObservable.FxRateObservableBuilder setSecondaryFxSpotRateSource(InformationSource secondaryFxSpotRateSource);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("primaryFxSpotRateSource"), processor, InformationSource.InformationSourceBuilder.class, getPrimaryFxSpotRateSource());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, ReferenceWithMetaQuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("secondaryFxSpotRateSource"), processor, InformationSource.InformationSourceBuilder.class, getSecondaryFxSpotRateSource());
		}
		
	}
	
	//FxRateObservable.FxRateObservableImpl
	class FxRateObservableImpl implements FxRateObservable {
		private final InformationSource primaryFxSpotRateSource;
		private final ReferenceWithMetaQuotedCurrencyPair quotedCurrencyPair;
		private final InformationSource secondaryFxSpotRateSource;
		
		protected FxRateObservableImpl(FxRateObservable.FxRateObservableBuilder builder) {
			this.primaryFxSpotRateSource = ofNullable(builder.getPrimaryFxSpotRateSource()).map(f->f.build()).orElse(null);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.secondaryFxSpotRateSource = ofNullable(builder.getSecondaryFxSpotRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public InformationSource getPrimaryFxSpotRateSource() {
			return primaryFxSpotRateSource;
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public InformationSource getSecondaryFxSpotRateSource() {
			return secondaryFxSpotRateSource;
		}
		
		@Override
		public FxRateObservable build() {
			return this;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder toBuilder() {
			FxRateObservable.FxRateObservableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRateObservable.FxRateObservableBuilder builder) {
			ofNullable(getPrimaryFxSpotRateSource()).ifPresent(builder::setPrimaryFxSpotRateSource);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getSecondaryFxSpotRateSource()).ifPresent(builder::setSecondaryFxSpotRateSource);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateObservable _that = getType().cast(o);
		
			if (!Objects.equals(primaryFxSpotRateSource, _that.getPrimaryFxSpotRateSource())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(secondaryFxSpotRateSource, _that.getSecondaryFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryFxSpotRateSource != null ? primaryFxSpotRateSource.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (secondaryFxSpotRateSource != null ? secondaryFxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateObservable {" +
				"primaryFxSpotRateSource=" + this.primaryFxSpotRateSource + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"secondaryFxSpotRateSource=" + this.secondaryFxSpotRateSource +
			'}';
		}
	}
	
	//FxRateObservable.FxRateObservableBuilderImpl
	class FxRateObservableBuilderImpl implements FxRateObservable.FxRateObservableBuilder {
	
		protected InformationSource.InformationSourceBuilder primaryFxSpotRateSource;
		protected ReferenceWithMetaQuotedCurrencyPairBuilder quotedCurrencyPair;
		protected InformationSource.InformationSourceBuilder secondaryFxSpotRateSource;
	
		public FxRateObservableBuilderImpl() {
		}
	
		@Override
		public InformationSource.InformationSourceBuilder getPrimaryFxSpotRateSource() {
			return primaryFxSpotRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreatePrimaryFxSpotRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (primaryFxSpotRateSource!=null) {
				result = primaryFxSpotRateSource;
			}
			else {
				result = primaryFxSpotRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			ReferenceWithMetaQuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = ReferenceWithMetaQuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getSecondaryFxSpotRateSource() {
			return secondaryFxSpotRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateSecondaryFxSpotRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (secondaryFxSpotRateSource!=null) {
				result = secondaryFxSpotRateSource;
			}
			else {
				result = secondaryFxSpotRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FxRateObservable.FxRateObservableBuilder setPrimaryFxSpotRateSource(InformationSource primaryFxSpotRateSource) {
			this.primaryFxSpotRateSource = primaryFxSpotRateSource==null?null:primaryFxSpotRateSource.toBuilder();
			return this;
		}
		@Override
		public FxRateObservable.FxRateObservableBuilder setQuotedCurrencyPair(ReferenceWithMetaQuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder setQuotedCurrencyPairValue(QuotedCurrencyPair quotedCurrencyPair) {
			this.getOrCreateQuotedCurrencyPair().setValue(quotedCurrencyPair);
			return this;
		}
		@Override
		public FxRateObservable.FxRateObservableBuilder setSecondaryFxSpotRateSource(InformationSource secondaryFxSpotRateSource) {
			this.secondaryFxSpotRateSource = secondaryFxSpotRateSource==null?null:secondaryFxSpotRateSource.toBuilder();
			return this;
		}
		
		@Override
		public FxRateObservable build() {
			return new FxRateObservable.FxRateObservableImpl(this);
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateObservable.FxRateObservableBuilder prune() {
			if (primaryFxSpotRateSource!=null && !primaryFxSpotRateSource.prune().hasData()) primaryFxSpotRateSource = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (secondaryFxSpotRateSource!=null && !secondaryFxSpotRateSource.prune().hasData()) secondaryFxSpotRateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryFxSpotRateSource()!=null && getPrimaryFxSpotRateSource().hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getSecondaryFxSpotRateSource()!=null && getSecondaryFxSpotRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateObservable.FxRateObservableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxRateObservable.FxRateObservableBuilder o = (FxRateObservable.FxRateObservableBuilder) other;
			
			merger.mergeRosetta(getPrimaryFxSpotRateSource(), o.getPrimaryFxSpotRateSource(), this::setPrimaryFxSpotRateSource);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getSecondaryFxSpotRateSource(), o.getSecondaryFxSpotRateSource(), this::setSecondaryFxSpotRateSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateObservable _that = getType().cast(o);
		
			if (!Objects.equals(primaryFxSpotRateSource, _that.getPrimaryFxSpotRateSource())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(secondaryFxSpotRateSource, _that.getSecondaryFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryFxSpotRateSource != null ? primaryFxSpotRateSource.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (secondaryFxSpotRateSource != null ? secondaryFxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateObservableBuilder {" +
				"primaryFxSpotRateSource=" + this.primaryFxSpotRateSource + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"secondaryFxSpotRateSource=" + this.secondaryFxSpotRateSource +
			'}';
		}
	}
}
