package cdm.observable.asset;

import cdm.observable.asset.meta.FxSettlementRateSourceMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The source of the Foreign Exchange settlement rate.
 * @version ${project.version}
 */
@RosettaClass

public interface FxSettlementRateSource extends RosettaModelObject {
	FxSettlementRateSource build();
	FxSettlementRateSource.FxSettlementRateSourceBuilder toBuilder();
	
	/**
	 * Indicates that a non-standard rate source will be used for the fixing.
	 */
	FxInformationSource getNonstandardSettlementRate();
	/**
	 * Indicates that an officially defined rate settlement rate option will be the used for the fixing.
	 */
	FieldWithMetaString getSettlementRateOption();
	final static FxSettlementRateSourceMeta metaData = new FxSettlementRateSourceMeta();
	
	@Override
	default RosettaMetaData<? extends FxSettlementRateSource> metaData() {
		return metaData;
	} 
			
	static FxSettlementRateSource.FxSettlementRateSourceBuilder builder() {
		return new FxSettlementRateSource.FxSettlementRateSourceBuilderImpl();
	}
	
	default Class<? extends FxSettlementRateSource> getType() {
		return FxSettlementRateSource.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("nonstandardSettlementRate"), processor, FxInformationSource.class, getNonstandardSettlementRate());
		processRosetta(path.newSubPath("settlementRateOption"), processor, FieldWithMetaString.class, getSettlementRateOption());
	}
	
	
	interface FxSettlementRateSourceBuilder extends FxSettlementRateSource, RosettaModelObjectBuilder {
		FxInformationSource.FxInformationSourceBuilder getOrCreateNonstandardSettlementRate();
		FxInformationSource.FxInformationSourceBuilder getNonstandardSettlementRate();
		FieldWithMetaStringBuilder getOrCreateSettlementRateOption();
		FieldWithMetaStringBuilder getSettlementRateOption();
		FxSettlementRateSource.FxSettlementRateSourceBuilder setNonstandardSettlementRate(FxInformationSource nonstandardSettlementRate);
		FxSettlementRateSource.FxSettlementRateSourceBuilder setSettlementRateOption(FieldWithMetaString settlementRateOption);
		FxSettlementRateSource.FxSettlementRateSourceBuilder setSettlementRateOptionValue(String settlementRateOption);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("nonstandardSettlementRate"), processor, FxInformationSource.FxInformationSourceBuilder.class, getNonstandardSettlementRate());
			processRosetta(path.newSubPath("settlementRateOption"), processor, FieldWithMetaStringBuilder.class, getSettlementRateOption());
		}
		
	}
	
	//FxSettlementRateSource.FxSettlementRateSourceImpl
	class FxSettlementRateSourceImpl implements FxSettlementRateSource {
		private final FxInformationSource nonstandardSettlementRate;
		private final FieldWithMetaString settlementRateOption;
		
		protected FxSettlementRateSourceImpl(FxSettlementRateSource.FxSettlementRateSourceBuilder builder) {
			this.nonstandardSettlementRate = ofNullable(builder.getNonstandardSettlementRate()).map(f->f.build()).orElse(null);
			this.settlementRateOption = ofNullable(builder.getSettlementRateOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FxInformationSource getNonstandardSettlementRate() {
			return nonstandardSettlementRate;
		}
		
		@Override
		public FieldWithMetaString getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public FxSettlementRateSource build() {
			return this;
		}
		
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder toBuilder() {
			FxSettlementRateSource.FxSettlementRateSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSettlementRateSource.FxSettlementRateSourceBuilder builder) {
			ofNullable(getNonstandardSettlementRate()).ifPresent(builder::setNonstandardSettlementRate);
			ofNullable(getSettlementRateOption()).ifPresent(builder::setSettlementRateOption);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementRateSource _that = getType().cast(o);
		
			if (!Objects.equals(nonstandardSettlementRate, _that.getNonstandardSettlementRate())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonstandardSettlementRate != null ? nonstandardSettlementRate.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementRateSource {" +
				"nonstandardSettlementRate=" + this.nonstandardSettlementRate + ", " +
				"settlementRateOption=" + this.settlementRateOption +
			'}';
		}
	}
	
	//FxSettlementRateSource.FxSettlementRateSourceBuilderImpl
	class FxSettlementRateSourceBuilderImpl implements FxSettlementRateSource.FxSettlementRateSourceBuilder {
	
		protected FxInformationSource.FxInformationSourceBuilder nonstandardSettlementRate;
		protected FieldWithMetaStringBuilder settlementRateOption;
	
		public FxSettlementRateSourceBuilderImpl() {
		}
	
		@Override
		public FxInformationSource.FxInformationSourceBuilder getNonstandardSettlementRate() {
			return nonstandardSettlementRate;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder getOrCreateNonstandardSettlementRate() {
			FxInformationSource.FxInformationSourceBuilder result;
			if (nonstandardSettlementRate!=null) {
				result = nonstandardSettlementRate;
			}
			else {
				result = nonstandardSettlementRate = FxInformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateSettlementRateOption() {
			FieldWithMetaStringBuilder result;
			if (settlementRateOption!=null) {
				result = settlementRateOption;
			}
			else {
				result = settlementRateOption = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder setNonstandardSettlementRate(FxInformationSource nonstandardSettlementRate) {
			this.nonstandardSettlementRate = nonstandardSettlementRate==null?null:nonstandardSettlementRate.toBuilder();
			return this;
		}
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder setSettlementRateOption(FieldWithMetaString settlementRateOption) {
			this.settlementRateOption = settlementRateOption==null?null:settlementRateOption.toBuilder();
			return this;
		}
		
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder setSettlementRateOptionValue(String settlementRateOption) {
			this.getOrCreateSettlementRateOption().setValue(settlementRateOption);
			return this;
		}
		
		@Override
		public FxSettlementRateSource build() {
			return new FxSettlementRateSource.FxSettlementRateSourceImpl(this);
		}
		
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder prune() {
			if (nonstandardSettlementRate!=null && !nonstandardSettlementRate.prune().hasData()) nonstandardSettlementRate = null;
			if (settlementRateOption!=null && !settlementRateOption.prune().hasData()) settlementRateOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNonstandardSettlementRate()!=null && getNonstandardSettlementRate().hasData()) return true;
			if (getSettlementRateOption()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxSettlementRateSource.FxSettlementRateSourceBuilder o = (FxSettlementRateSource.FxSettlementRateSourceBuilder) other;
			
			merger.mergeRosetta(getNonstandardSettlementRate(), o.getNonstandardSettlementRate(), this::setNonstandardSettlementRate);
			merger.mergeRosetta(getSettlementRateOption(), o.getSettlementRateOption(), this::setSettlementRateOption);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementRateSource _that = getType().cast(o);
		
			if (!Objects.equals(nonstandardSettlementRate, _that.getNonstandardSettlementRate())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonstandardSettlementRate != null ? nonstandardSettlementRate.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementRateSourceBuilder {" +
				"nonstandardSettlementRate=" + this.nonstandardSettlementRate + ", " +
				"settlementRateOption=" + this.settlementRateOption +
			'}';
		}
	}
}
