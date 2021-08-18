package cdm.legalagreement.csa;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.legalagreement.csa.meta.CoveredTransactionsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specification of Transactions covered by the legal agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface CoveredTransactions extends RosettaModelObject {
	CoveredTransactions build();
	CoveredTransactions.CoveredTransactionsBuilder toBuilder();
	
	/**
	 * The party specific additional obligations applicable to the document.
	 */
	List<? extends AdditionalObligations> getAdditionalObligations();
	/**
	 * Covered Transactions when not expressed using the ISDA taxonomy.
	 */
	List<? extends String> getBespokeCoveredTransactions();
	/**
	 * Covered Transactions when expressed using the ISDA taxonomy.
	 */
	List<? extends ProductTaxonomy> getCoveredTransactions();
	/**
	 * The bespoke definition of exposure for Covered Transactions as part of the agreement.
	 */
	String getExposure();
	/**
	 * Includes any Transaction specified below that is entered into on or after the specified date.
	 */
	Date getInclusionDate();
	final static CoveredTransactionsMeta metaData = new CoveredTransactionsMeta();
	
	@Override
	default RosettaMetaData<? extends CoveredTransactions> metaData() {
		return metaData;
	} 
			
	static CoveredTransactions.CoveredTransactionsBuilder builder() {
		return new CoveredTransactions.CoveredTransactionsBuilderImpl();
	}
	
	default Class<? extends CoveredTransactions> getType() {
		return CoveredTransactions.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bespokeCoveredTransactions"), String.class, getBespokeCoveredTransactions(), this);
		processor.processBasic(path.newSubPath("exposure"), String.class, getExposure(), this);
		processor.processBasic(path.newSubPath("inclusionDate"), Date.class, getInclusionDate(), this);
		
		processRosetta(path.newSubPath("additionalObligations"), processor, AdditionalObligations.class, getAdditionalObligations());
		processRosetta(path.newSubPath("coveredTransactions"), processor, ProductTaxonomy.class, getCoveredTransactions());
	}
	
	
	interface CoveredTransactionsBuilder extends CoveredTransactions, RosettaModelObjectBuilder {
		AdditionalObligations.AdditionalObligationsBuilder getOrCreateAdditionalObligations(int _index);
		List<? extends AdditionalObligations.AdditionalObligationsBuilder> getAdditionalObligations();
		ProductTaxonomy.ProductTaxonomyBuilder getOrCreateCoveredTransactions(int _index);
		List<? extends ProductTaxonomy.ProductTaxonomyBuilder> getCoveredTransactions();
		CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(AdditionalObligations additionalObligations);
		CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(AdditionalObligations additionalObligations, int _idx);
		CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(List<? extends AdditionalObligations> additionalObligations);
		CoveredTransactions.CoveredTransactionsBuilder setAdditionalObligations(List<? extends AdditionalObligations> additionalObligations);
		CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(String bespokeCoveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(String bespokeCoveredTransactions, int _idx);
		CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(List<? extends String> bespokeCoveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder setBespokeCoveredTransactions(List<? extends String> bespokeCoveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(ProductTaxonomy coveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(ProductTaxonomy coveredTransactions, int _idx);
		CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(List<? extends ProductTaxonomy> coveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder setCoveredTransactions(List<? extends ProductTaxonomy> coveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder setExposure(String exposure);
		CoveredTransactions.CoveredTransactionsBuilder setInclusionDate(Date inclusionDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bespokeCoveredTransactions"), String.class, getBespokeCoveredTransactions(), this);
			processor.processBasic(path.newSubPath("exposure"), String.class, getExposure(), this);
			processor.processBasic(path.newSubPath("inclusionDate"), Date.class, getInclusionDate(), this);
			
			processRosetta(path.newSubPath("additionalObligations"), processor, AdditionalObligations.AdditionalObligationsBuilder.class, getAdditionalObligations());
			processRosetta(path.newSubPath("coveredTransactions"), processor, ProductTaxonomy.ProductTaxonomyBuilder.class, getCoveredTransactions());
		}
		
	}
	
	//CoveredTransactions.CoveredTransactionsImpl
	class CoveredTransactionsImpl implements CoveredTransactions {
		private final List<? extends AdditionalObligations> additionalObligations;
		private final List<? extends String> bespokeCoveredTransactions;
		private final List<? extends ProductTaxonomy> coveredTransactions;
		private final String exposure;
		private final Date inclusionDate;
		
		protected CoveredTransactionsImpl(CoveredTransactions.CoveredTransactionsBuilder builder) {
			this.additionalObligations = ofNullable(builder.getAdditionalObligations()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.bespokeCoveredTransactions = ofNullable(builder.getBespokeCoveredTransactions()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.coveredTransactions = ofNullable(builder.getCoveredTransactions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exposure = builder.getExposure();
			this.inclusionDate = builder.getInclusionDate();
		}
		
		@Override
		public List<? extends AdditionalObligations> getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		public List<? extends String> getBespokeCoveredTransactions() {
			return bespokeCoveredTransactions;
		}
		
		@Override
		public List<? extends ProductTaxonomy> getCoveredTransactions() {
			return coveredTransactions;
		}
		
		@Override
		public String getExposure() {
			return exposure;
		}
		
		@Override
		public Date getInclusionDate() {
			return inclusionDate;
		}
		
		@Override
		public CoveredTransactions build() {
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder toBuilder() {
			CoveredTransactions.CoveredTransactionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoveredTransactions.CoveredTransactionsBuilder builder) {
			ofNullable(getAdditionalObligations()).ifPresent(builder::setAdditionalObligations);
			ofNullable(getBespokeCoveredTransactions()).ifPresent(builder::setBespokeCoveredTransactions);
			ofNullable(getCoveredTransactions()).ifPresent(builder::setCoveredTransactions);
			ofNullable(getExposure()).ifPresent(builder::setExposure);
			ofNullable(getInclusionDate()).ifPresent(builder::setInclusionDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoveredTransactions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!ListEquals.listEquals(bespokeCoveredTransactions, _that.getBespokeCoveredTransactions())) return false;
			if (!ListEquals.listEquals(coveredTransactions, _that.getCoveredTransactions())) return false;
			if (!Objects.equals(exposure, _that.getExposure())) return false;
			if (!Objects.equals(inclusionDate, _that.getInclusionDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (bespokeCoveredTransactions != null ? bespokeCoveredTransactions.hashCode() : 0);
			_result = 31 * _result + (coveredTransactions != null ? coveredTransactions.hashCode() : 0);
			_result = 31 * _result + (exposure != null ? exposure.hashCode() : 0);
			_result = 31 * _result + (inclusionDate != null ? inclusionDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoveredTransactions {" +
				"additionalObligations=" + this.additionalObligations + ", " +
				"bespokeCoveredTransactions=" + this.bespokeCoveredTransactions + ", " +
				"coveredTransactions=" + this.coveredTransactions + ", " +
				"exposure=" + this.exposure + ", " +
				"inclusionDate=" + this.inclusionDate +
			'}';
		}
	}
	
	//CoveredTransactions.CoveredTransactionsBuilderImpl
	class CoveredTransactionsBuilderImpl implements CoveredTransactions.CoveredTransactionsBuilder {
	
		protected List<AdditionalObligations.AdditionalObligationsBuilder> additionalObligations = new ArrayList<>();
		protected List<String> bespokeCoveredTransactions = new ArrayList<>();
		protected List<ProductTaxonomy.ProductTaxonomyBuilder> coveredTransactions = new ArrayList<>();
		protected String exposure;
		protected Date inclusionDate;
	
		public CoveredTransactionsBuilderImpl() {
		}
	
		@Override
		public List<? extends AdditionalObligations.AdditionalObligationsBuilder> getAdditionalObligations() {
			return additionalObligations;
		}
		
		public AdditionalObligations.AdditionalObligationsBuilder getOrCreateAdditionalObligations(int _index) {
		
			if (additionalObligations==null) {
				this.additionalObligations = new ArrayList<>();
			}
			AdditionalObligations.AdditionalObligationsBuilder result;
			return getIndex(additionalObligations, _index, () -> {
						AdditionalObligations.AdditionalObligationsBuilder newAdditionalObligations = AdditionalObligations.builder();
						return newAdditionalObligations;
					});
		}
		
		@Override
		public List<? extends String> getBespokeCoveredTransactions() {
			return bespokeCoveredTransactions;
		}
		
		@Override
		public List<? extends ProductTaxonomy.ProductTaxonomyBuilder> getCoveredTransactions() {
			return coveredTransactions;
		}
		
		public ProductTaxonomy.ProductTaxonomyBuilder getOrCreateCoveredTransactions(int _index) {
		
			if (coveredTransactions==null) {
				this.coveredTransactions = new ArrayList<>();
			}
			ProductTaxonomy.ProductTaxonomyBuilder result;
			return getIndex(coveredTransactions, _index, () -> {
						ProductTaxonomy.ProductTaxonomyBuilder newCoveredTransactions = ProductTaxonomy.builder();
						return newCoveredTransactions;
					});
		}
		
		@Override
		public String getExposure() {
			return exposure;
		}
		
		@Override
		public Date getInclusionDate() {
			return inclusionDate;
		}
		
	
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(AdditionalObligations additionalObligations) {
			if (additionalObligations!=null) this.additionalObligations.add(additionalObligations.toBuilder());
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(AdditionalObligations additionalObligations, int _idx) {
			getIndex(this.additionalObligations, _idx, () -> additionalObligations.toBuilder());
			return this;
		}
		@Override 
		public CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(List<? extends AdditionalObligations> additionalObligationss) {
			if (additionalObligationss != null) {
				for (AdditionalObligations toAdd : additionalObligationss) {
					this.additionalObligations.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CoveredTransactions.CoveredTransactionsBuilder setAdditionalObligations(List<? extends AdditionalObligations> additionalObligationss) {
			if (additionalObligationss == null)  {
				this.additionalObligations = new ArrayList<>();
			}
			else {
				this.additionalObligations = additionalObligationss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(String bespokeCoveredTransactions) {
			if (bespokeCoveredTransactions!=null) this.bespokeCoveredTransactions.add(bespokeCoveredTransactions);
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(String bespokeCoveredTransactions, int _idx) {
			getIndex(this.bespokeCoveredTransactions, _idx, () -> bespokeCoveredTransactions);
			return this;
		}
		@Override 
		public CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(List<? extends String> bespokeCoveredTransactionss) {
			if (bespokeCoveredTransactionss != null) {
				for (String toAdd : bespokeCoveredTransactionss) {
					this.bespokeCoveredTransactions.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public CoveredTransactions.CoveredTransactionsBuilder setBespokeCoveredTransactions(List<? extends String> bespokeCoveredTransactionss) {
			if (bespokeCoveredTransactionss == null)  {
				this.bespokeCoveredTransactions = new ArrayList<>();
			}
			else {
				this.bespokeCoveredTransactions = bespokeCoveredTransactionss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(ProductTaxonomy coveredTransactions) {
			if (coveredTransactions!=null) this.coveredTransactions.add(coveredTransactions.toBuilder());
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(ProductTaxonomy coveredTransactions, int _idx) {
			getIndex(this.coveredTransactions, _idx, () -> coveredTransactions.toBuilder());
			return this;
		}
		@Override 
		public CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(List<? extends ProductTaxonomy> coveredTransactionss) {
			if (coveredTransactionss != null) {
				for (ProductTaxonomy toAdd : coveredTransactionss) {
					this.coveredTransactions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CoveredTransactions.CoveredTransactionsBuilder setCoveredTransactions(List<? extends ProductTaxonomy> coveredTransactionss) {
			if (coveredTransactionss == null)  {
				this.coveredTransactions = new ArrayList<>();
			}
			else {
				this.coveredTransactions = coveredTransactionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder setExposure(String exposure) {
			this.exposure = exposure==null?null:exposure;
			return this;
		}
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder setInclusionDate(Date inclusionDate) {
			this.inclusionDate = inclusionDate==null?null:inclusionDate;
			return this;
		}
		
		@Override
		public CoveredTransactions build() {
			return new CoveredTransactions.CoveredTransactionsImpl(this);
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder prune() {
			additionalObligations = additionalObligations.stream().filter(b->b!=null).<AdditionalObligations.AdditionalObligationsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			coveredTransactions = coveredTransactions.stream().filter(b->b!=null).<ProductTaxonomy.ProductTaxonomyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalObligations()!=null && getAdditionalObligations().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBespokeCoveredTransactions()!=null && !getBespokeCoveredTransactions().isEmpty()) return true;
			if (getCoveredTransactions()!=null && getCoveredTransactions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExposure()!=null) return true;
			if (getInclusionDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoveredTransactions.CoveredTransactionsBuilder o = (CoveredTransactions.CoveredTransactionsBuilder) other;
			
			merger.mergeRosetta(getAdditionalObligations(), o.getAdditionalObligations(), this::getOrCreateAdditionalObligations);
			merger.mergeRosetta(getCoveredTransactions(), o.getCoveredTransactions(), this::getOrCreateCoveredTransactions);
			
			merger.mergeBasic(getBespokeCoveredTransactions(), o.getBespokeCoveredTransactions(), (Consumer<String>) this::addBespokeCoveredTransactions);
			merger.mergeBasic(getExposure(), o.getExposure(), this::setExposure);
			merger.mergeBasic(getInclusionDate(), o.getInclusionDate(), this::setInclusionDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoveredTransactions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!ListEquals.listEquals(bespokeCoveredTransactions, _that.getBespokeCoveredTransactions())) return false;
			if (!ListEquals.listEquals(coveredTransactions, _that.getCoveredTransactions())) return false;
			if (!Objects.equals(exposure, _that.getExposure())) return false;
			if (!Objects.equals(inclusionDate, _that.getInclusionDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (bespokeCoveredTransactions != null ? bespokeCoveredTransactions.hashCode() : 0);
			_result = 31 * _result + (coveredTransactions != null ? coveredTransactions.hashCode() : 0);
			_result = 31 * _result + (exposure != null ? exposure.hashCode() : 0);
			_result = 31 * _result + (inclusionDate != null ? inclusionDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoveredTransactionsBuilder {" +
				"additionalObligations=" + this.additionalObligations + ", " +
				"bespokeCoveredTransactions=" + this.bespokeCoveredTransactions + ", " +
				"coveredTransactions=" + this.coveredTransactions + ", " +
				"exposure=" + this.exposure + ", " +
				"inclusionDate=" + this.inclusionDate +
			'}';
		}
	}
}
