package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ConcentrationLimitCriteriaMeta;
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
 * A class to describe a set of criteria to describe specific assets that the concentration limits apply to.
 * @version ${project.version}
 */
@RosettaClass

public interface ConcentrationLimitCriteria extends RosettaModelObject {
	ConcentrationLimitCriteria build();
	ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder toBuilder();
	
	/**
	 * Filter based on the asset.
	 */
	List<? extends AssetCriteria> getAsset();
	/**
	 * Filter based on the issuer.
	 */
	List<? extends IssuerCriteria> getIssuer();
	final static ConcentrationLimitCriteriaMeta metaData = new ConcentrationLimitCriteriaMeta();
	
	@Override
	default RosettaMetaData<? extends ConcentrationLimitCriteria> metaData() {
		return metaData;
	} 
			
	static ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder builder() {
		return new ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilderImpl();
	}
	
	default Class<? extends ConcentrationLimitCriteria> getType() {
		return ConcentrationLimitCriteria.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("asset"), processor, AssetCriteria.class, getAsset());
		processRosetta(path.newSubPath("issuer"), processor, IssuerCriteria.class, getIssuer());
	}
	
	
	interface ConcentrationLimitCriteriaBuilder extends ConcentrationLimitCriteria, RosettaModelObjectBuilder {
		AssetCriteria.AssetCriteriaBuilder getOrCreateAsset(int _index);
		List<? extends AssetCriteria.AssetCriteriaBuilder> getAsset();
		IssuerCriteria.IssuerCriteriaBuilder getOrCreateIssuer(int _index);
		List<? extends IssuerCriteria.IssuerCriteriaBuilder> getIssuer();
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAsset(AssetCriteria asset);
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAsset(AssetCriteria asset, int _idx);
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAsset(List<? extends AssetCriteria> asset);
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setAsset(List<? extends AssetCriteria> asset);
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addIssuer(IssuerCriteria issuer);
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addIssuer(IssuerCriteria issuer, int _idx);
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addIssuer(List<? extends IssuerCriteria> issuer);
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setIssuer(List<? extends IssuerCriteria> issuer);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("asset"), processor, AssetCriteria.AssetCriteriaBuilder.class, getAsset());
			processRosetta(path.newSubPath("issuer"), processor, IssuerCriteria.IssuerCriteriaBuilder.class, getIssuer());
		}
		
	}
	
	//ConcentrationLimitCriteria.ConcentrationLimitCriteriaImpl
	class ConcentrationLimitCriteriaImpl implements ConcentrationLimitCriteria {
		private final List<? extends AssetCriteria> asset;
		private final List<? extends IssuerCriteria> issuer;
		
		protected ConcentrationLimitCriteriaImpl(ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder builder) {
			this.asset = ofNullable(builder.getAsset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.issuer = ofNullable(builder.getIssuer()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		public ConcentrationLimitCriteria build() {
			return this;
		}
		
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder toBuilder() {
			ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder builder) {
			ofNullable(getAsset()).ifPresent(builder::setAsset);
			ofNullable(getIssuer()).ifPresent(builder::setIssuer);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConcentrationLimitCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(asset, _that.getAsset())) return false;
			if (!ListEquals.listEquals(issuer, _that.getIssuer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConcentrationLimitCriteria {" +
				"asset=" + this.asset + ", " +
				"issuer=" + this.issuer +
			'}';
		}
	}
	
	//ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilderImpl
	class ConcentrationLimitCriteriaBuilderImpl implements ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder {
	
		protected List<AssetCriteria.AssetCriteriaBuilder> asset = new ArrayList<>();
		protected List<IssuerCriteria.IssuerCriteriaBuilder> issuer = new ArrayList<>();
	
		public ConcentrationLimitCriteriaBuilderImpl() {
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
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAsset(AssetCriteria asset) {
			if (asset!=null) this.asset.add(asset.toBuilder());
			return this;
		}
		
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAsset(AssetCriteria asset, int _idx) {
			getIndex(this.asset, _idx, () -> asset.toBuilder());
			return this;
		}
		@Override 
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAsset(List<? extends AssetCriteria> assets) {
			if (assets != null) {
				for (AssetCriteria toAdd : assets) {
					this.asset.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setAsset(List<? extends AssetCriteria> assets) {
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
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addIssuer(IssuerCriteria issuer) {
			if (issuer!=null) this.issuer.add(issuer.toBuilder());
			return this;
		}
		
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addIssuer(IssuerCriteria issuer, int _idx) {
			getIndex(this.issuer, _idx, () -> issuer.toBuilder());
			return this;
		}
		@Override 
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addIssuer(List<? extends IssuerCriteria> issuers) {
			if (issuers != null) {
				for (IssuerCriteria toAdd : issuers) {
					this.issuer.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setIssuer(List<? extends IssuerCriteria> issuers) {
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
		public ConcentrationLimitCriteria build() {
			return new ConcentrationLimitCriteria.ConcentrationLimitCriteriaImpl(this);
		}
		
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder prune() {
			asset = asset.stream().filter(b->b!=null).<AssetCriteria.AssetCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			issuer = issuer.stream().filter(b->b!=null).<IssuerCriteria.IssuerCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsset()!=null && getAsset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIssuer()!=null && getIssuer().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder o = (ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder) other;
			
			merger.mergeRosetta(getAsset(), o.getAsset(), this::getOrCreateAsset);
			merger.mergeRosetta(getIssuer(), o.getIssuer(), this::getOrCreateIssuer);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConcentrationLimitCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(asset, _that.getAsset())) return false;
			if (!ListEquals.listEquals(issuer, _that.getIssuer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConcentrationLimitCriteriaBuilder {" +
				"asset=" + this.asset + ", " +
				"issuer=" + this.issuer +
			'}';
		}
	}
}
