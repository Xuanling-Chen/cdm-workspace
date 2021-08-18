package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.EligibleCollateralCriteriaMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Criteria used to specify eligible collateral.
 * @version ${project.version}
 */
@RosettaClass

public interface EligibleCollateralCriteria extends RosettaModelObject {
	EligibleCollateralCriteria build();
	EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder toBuilder();
	
	/**
	 * Filter based on the asset.
	 */
	List<? extends AssetCriteria> getAsset();
	/**
	 * Filter based on the issuer.
	 */
	List<? extends IssuerCriteria> getIssuer();
	/**
	 * Treatment of described collateral
	 */
	CollateralTreatment getTreatment();
	final static EligibleCollateralCriteriaMeta metaData = new EligibleCollateralCriteriaMeta();
	
	@Override
	default RosettaMetaData<? extends EligibleCollateralCriteria> metaData() {
		return metaData;
	} 
			
	static EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder() {
		return new EligibleCollateralCriteria.EligibleCollateralCriteriaBuilderImpl();
	}
	
	default Class<? extends EligibleCollateralCriteria> getType() {
		return EligibleCollateralCriteria.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("asset"), processor, AssetCriteria.class, getAsset());
		processRosetta(path.newSubPath("issuer"), processor, IssuerCriteria.class, getIssuer());
		processRosetta(path.newSubPath("treatment"), processor, CollateralTreatment.class, getTreatment());
	}
	
	
	interface EligibleCollateralCriteriaBuilder extends EligibleCollateralCriteria, RosettaModelObjectBuilder {
		AssetCriteria.AssetCriteriaBuilder getOrCreateAsset(int _index);
		List<? extends AssetCriteria.AssetCriteriaBuilder> getAsset();
		IssuerCriteria.IssuerCriteriaBuilder getOrCreateIssuer(int _index);
		List<? extends IssuerCriteria.IssuerCriteriaBuilder> getIssuer();
		CollateralTreatment.CollateralTreatmentBuilder getOrCreateTreatment();
		CollateralTreatment.CollateralTreatmentBuilder getTreatment();
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAsset(AssetCriteria asset);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAsset(AssetCriteria asset, int _idx);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAsset(List<? extends AssetCriteria> asset);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setAsset(List<? extends AssetCriteria> asset);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addIssuer(IssuerCriteria issuer);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addIssuer(IssuerCriteria issuer, int _idx);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addIssuer(List<? extends IssuerCriteria> issuer);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setIssuer(List<? extends IssuerCriteria> issuer);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setTreatment(CollateralTreatment treatment);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("asset"), processor, AssetCriteria.AssetCriteriaBuilder.class, getAsset());
			processRosetta(path.newSubPath("issuer"), processor, IssuerCriteria.IssuerCriteriaBuilder.class, getIssuer());
			processRosetta(path.newSubPath("treatment"), processor, CollateralTreatment.CollateralTreatmentBuilder.class, getTreatment());
		}
		
	}
	
	//EligibleCollateralCriteria.EligibleCollateralCriteriaImpl
	class EligibleCollateralCriteriaImpl implements EligibleCollateralCriteria {
		private final List<? extends AssetCriteria> asset;
		private final List<? extends IssuerCriteria> issuer;
		private final CollateralTreatment treatment;
		
		protected EligibleCollateralCriteriaImpl(EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder) {
			this.asset = ofNullable(builder.getAsset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.issuer = ofNullable(builder.getIssuer()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.treatment = ofNullable(builder.getTreatment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends AssetCriteria> getAsset() {
			return asset;
		}
		
		@Override
		public List<? extends IssuerCriteria> getIssuer() {
			return issuer;
		}
		
		@Override
		public CollateralTreatment getTreatment() {
			return treatment;
		}
		
		@Override
		public EligibleCollateralCriteria build() {
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder toBuilder() {
			EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder) {
			ofNullable(getAsset()).ifPresent(builder::setAsset);
			ofNullable(getIssuer()).ifPresent(builder::setIssuer);
			ofNullable(getTreatment()).ifPresent(builder::setTreatment);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibleCollateralCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(asset, _that.getAsset())) return false;
			if (!ListEquals.listEquals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(treatment, _that.getTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (treatment != null ? treatment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralCriteria {" +
				"asset=" + this.asset + ", " +
				"issuer=" + this.issuer + ", " +
				"treatment=" + this.treatment +
			'}';
		}
	}
	
	//EligibleCollateralCriteria.EligibleCollateralCriteriaBuilderImpl
	class EligibleCollateralCriteriaBuilderImpl implements EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder {
	
		protected List<AssetCriteria.AssetCriteriaBuilder> asset = new ArrayList<>();
		protected List<IssuerCriteria.IssuerCriteriaBuilder> issuer = new ArrayList<>();
		protected CollateralTreatment.CollateralTreatmentBuilder treatment;
	
		public EligibleCollateralCriteriaBuilderImpl() {
		}
	
		@Override
		public List<? extends AssetCriteria.AssetCriteriaBuilder> getAsset() {
			return asset;
		}
		
		public AssetCriteria.AssetCriteriaBuilder getOrCreateAsset(int _index) {
		
			if (asset==null) {
				this.asset = new ArrayList<>();
			}
			AssetCriteria.AssetCriteriaBuilder result;
			return getIndex(asset, _index, () -> {
						AssetCriteria.AssetCriteriaBuilder newAsset = AssetCriteria.builder();
						return newAsset;
					});
		}
		
		@Override
		public List<? extends IssuerCriteria.IssuerCriteriaBuilder> getIssuer() {
			return issuer;
		}
		
		public IssuerCriteria.IssuerCriteriaBuilder getOrCreateIssuer(int _index) {
		
			if (issuer==null) {
				this.issuer = new ArrayList<>();
			}
			IssuerCriteria.IssuerCriteriaBuilder result;
			return getIndex(issuer, _index, () -> {
						IssuerCriteria.IssuerCriteriaBuilder newIssuer = IssuerCriteria.builder();
						return newIssuer;
					});
		}
		
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder getTreatment() {
			return treatment;
		}
		
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder getOrCreateTreatment() {
			CollateralTreatment.CollateralTreatmentBuilder result;
			if (treatment!=null) {
				result = treatment;
			}
			else {
				result = treatment = CollateralTreatment.builder();
			}
			
			return result;
		}
		
	
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAsset(AssetCriteria asset) {
			if (asset!=null) this.asset.add(asset.toBuilder());
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAsset(AssetCriteria asset, int _idx) {
			getIndex(this.asset, _idx, () -> asset.toBuilder());
			return this;
		}
		@Override 
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAsset(List<? extends AssetCriteria> assets) {
			if (assets != null) {
				for (AssetCriteria toAdd : assets) {
					this.asset.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setAsset(List<? extends AssetCriteria> assets) {
			if (assets == null)  {
				this.asset = new ArrayList<>();
			}
			else {
				this.asset = assets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addIssuer(IssuerCriteria issuer) {
			if (issuer!=null) this.issuer.add(issuer.toBuilder());
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addIssuer(IssuerCriteria issuer, int _idx) {
			getIndex(this.issuer, _idx, () -> issuer.toBuilder());
			return this;
		}
		@Override 
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addIssuer(List<? extends IssuerCriteria> issuers) {
			if (issuers != null) {
				for (IssuerCriteria toAdd : issuers) {
					this.issuer.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setIssuer(List<? extends IssuerCriteria> issuers) {
			if (issuers == null)  {
				this.issuer = new ArrayList<>();
			}
			else {
				this.issuer = issuers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setTreatment(CollateralTreatment treatment) {
			this.treatment = treatment==null?null:treatment.toBuilder();
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria build() {
			return new EligibleCollateralCriteria.EligibleCollateralCriteriaImpl(this);
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder prune() {
			asset = asset.stream().filter(b->b!=null).<AssetCriteria.AssetCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			issuer = issuer.stream().filter(b->b!=null).<IssuerCriteria.IssuerCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (treatment!=null && !treatment.prune().hasData()) treatment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsset()!=null && getAsset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIssuer()!=null && getIssuer().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTreatment()!=null && getTreatment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder o = (EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder) other;
			
			merger.mergeRosetta(getAsset(), o.getAsset(), this::getOrCreateAsset);
			merger.mergeRosetta(getIssuer(), o.getIssuer(), this::getOrCreateIssuer);
			merger.mergeRosetta(getTreatment(), o.getTreatment(), this::setTreatment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibleCollateralCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(asset, _that.getAsset())) return false;
			if (!ListEquals.listEquals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(treatment, _that.getTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (treatment != null ? treatment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralCriteriaBuilder {" +
				"asset=" + this.asset + ", " +
				"issuer=" + this.issuer + ", " +
				"treatment=" + this.treatment +
			'}';
		}
	}
}
