package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.GeneralSimmElectionsMeta;
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
 * A class to specify the ISDA SIMM as the Method for all Covered Transactions with respect to all Regimes. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ee).
 * @version ${project.version}
 */
@RosettaClass

public interface GeneralSimmElections extends RosettaModelObject {
	GeneralSimmElections build();
	GeneralSimmElections.GeneralSimmElectionsBuilder toBuilder();
	
	/**
	 * The SIMM Calculation Currency, as specified for each of the parties to the CSA Initial Margin. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ee)(3).
	 */
	SimmCalculationCurrency getSimmCalculationCurrency();
	/**
	 * The qualification of the ISDA SIMM version that is specified for all Covered Transactions as specified by ISDA 2018 CSA for Initial Margin, Paragraph 13, General Principles, (ee)(1).
	 */
	SimmVersion getSimmVersion();
	final static GeneralSimmElectionsMeta metaData = new GeneralSimmElectionsMeta();
	
	@Override
	default RosettaMetaData<? extends GeneralSimmElections> metaData() {
		return metaData;
	} 
			
	static GeneralSimmElections.GeneralSimmElectionsBuilder builder() {
		return new GeneralSimmElections.GeneralSimmElectionsBuilderImpl();
	}
	
	default Class<? extends GeneralSimmElections> getType() {
		return GeneralSimmElections.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("simmCalculationCurrency"), processor, SimmCalculationCurrency.class, getSimmCalculationCurrency());
		processRosetta(path.newSubPath("simmVersion"), processor, SimmVersion.class, getSimmVersion());
	}
	
	
	interface GeneralSimmElectionsBuilder extends GeneralSimmElections, RosettaModelObjectBuilder {
		SimmCalculationCurrency.SimmCalculationCurrencyBuilder getOrCreateSimmCalculationCurrency();
		SimmCalculationCurrency.SimmCalculationCurrencyBuilder getSimmCalculationCurrency();
		SimmVersion.SimmVersionBuilder getOrCreateSimmVersion();
		SimmVersion.SimmVersionBuilder getSimmVersion();
		GeneralSimmElections.GeneralSimmElectionsBuilder setSimmCalculationCurrency(SimmCalculationCurrency simmCalculationCurrency);
		GeneralSimmElections.GeneralSimmElectionsBuilder setSimmVersion(SimmVersion simmVersion);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("simmCalculationCurrency"), processor, SimmCalculationCurrency.SimmCalculationCurrencyBuilder.class, getSimmCalculationCurrency());
			processRosetta(path.newSubPath("simmVersion"), processor, SimmVersion.SimmVersionBuilder.class, getSimmVersion());
		}
		
	}
	
	//GeneralSimmElections.GeneralSimmElectionsImpl
	class GeneralSimmElectionsImpl implements GeneralSimmElections {
		private final SimmCalculationCurrency simmCalculationCurrency;
		private final SimmVersion simmVersion;
		
		protected GeneralSimmElectionsImpl(GeneralSimmElections.GeneralSimmElectionsBuilder builder) {
			this.simmCalculationCurrency = ofNullable(builder.getSimmCalculationCurrency()).map(f->f.build()).orElse(null);
			this.simmVersion = ofNullable(builder.getSimmVersion()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public SimmCalculationCurrency getSimmCalculationCurrency() {
			return simmCalculationCurrency;
		}
		
		@Override
		public SimmVersion getSimmVersion() {
			return simmVersion;
		}
		
		@Override
		public GeneralSimmElections build() {
			return this;
		}
		
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder toBuilder() {
			GeneralSimmElections.GeneralSimmElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GeneralSimmElections.GeneralSimmElectionsBuilder builder) {
			ofNullable(getSimmCalculationCurrency()).ifPresent(builder::setSimmCalculationCurrency);
			ofNullable(getSimmVersion()).ifPresent(builder::setSimmVersion);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralSimmElections _that = getType().cast(o);
		
			if (!Objects.equals(simmCalculationCurrency, _that.getSimmCalculationCurrency())) return false;
			if (!Objects.equals(simmVersion, _that.getSimmVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (simmCalculationCurrency != null ? simmCalculationCurrency.hashCode() : 0);
			_result = 31 * _result + (simmVersion != null ? simmVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralSimmElections {" +
				"simmCalculationCurrency=" + this.simmCalculationCurrency + ", " +
				"simmVersion=" + this.simmVersion +
			'}';
		}
	}
	
	//GeneralSimmElections.GeneralSimmElectionsBuilderImpl
	class GeneralSimmElectionsBuilderImpl implements GeneralSimmElections.GeneralSimmElectionsBuilder {
	
		protected SimmCalculationCurrency.SimmCalculationCurrencyBuilder simmCalculationCurrency;
		protected SimmVersion.SimmVersionBuilder simmVersion;
	
		public GeneralSimmElectionsBuilderImpl() {
		}
	
		@Override
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder getSimmCalculationCurrency() {
			return simmCalculationCurrency;
		}
		
		@Override
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder getOrCreateSimmCalculationCurrency() {
			SimmCalculationCurrency.SimmCalculationCurrencyBuilder result;
			if (simmCalculationCurrency!=null) {
				result = simmCalculationCurrency;
			}
			else {
				result = simmCalculationCurrency = SimmCalculationCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		public SimmVersion.SimmVersionBuilder getSimmVersion() {
			return simmVersion;
		}
		
		@Override
		public SimmVersion.SimmVersionBuilder getOrCreateSimmVersion() {
			SimmVersion.SimmVersionBuilder result;
			if (simmVersion!=null) {
				result = simmVersion;
			}
			else {
				result = simmVersion = SimmVersion.builder();
			}
			
			return result;
		}
		
	
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder setSimmCalculationCurrency(SimmCalculationCurrency simmCalculationCurrency) {
			this.simmCalculationCurrency = simmCalculationCurrency==null?null:simmCalculationCurrency.toBuilder();
			return this;
		}
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder setSimmVersion(SimmVersion simmVersion) {
			this.simmVersion = simmVersion==null?null:simmVersion.toBuilder();
			return this;
		}
		
		@Override
		public GeneralSimmElections build() {
			return new GeneralSimmElections.GeneralSimmElectionsImpl(this);
		}
		
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder prune() {
			if (simmCalculationCurrency!=null && !simmCalculationCurrency.prune().hasData()) simmCalculationCurrency = null;
			if (simmVersion!=null && !simmVersion.prune().hasData()) simmVersion = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSimmCalculationCurrency()!=null && getSimmCalculationCurrency().hasData()) return true;
			if (getSimmVersion()!=null && getSimmVersion().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GeneralSimmElections.GeneralSimmElectionsBuilder o = (GeneralSimmElections.GeneralSimmElectionsBuilder) other;
			
			merger.mergeRosetta(getSimmCalculationCurrency(), o.getSimmCalculationCurrency(), this::setSimmCalculationCurrency);
			merger.mergeRosetta(getSimmVersion(), o.getSimmVersion(), this::setSimmVersion);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralSimmElections _that = getType().cast(o);
		
			if (!Objects.equals(simmCalculationCurrency, _that.getSimmCalculationCurrency())) return false;
			if (!Objects.equals(simmVersion, _that.getSimmVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (simmCalculationCurrency != null ? simmCalculationCurrency.hashCode() : 0);
			_result = 31 * _result + (simmVersion != null ? simmVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralSimmElectionsBuilder {" +
				"simmCalculationCurrency=" + this.simmCalculationCurrency + ", " +
				"simmVersion=" + this.simmVersion +
			'}';
		}
	}
}
