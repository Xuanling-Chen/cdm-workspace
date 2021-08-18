package cdm.observable.asset;

import cdm.observable.asset.meta.RelativePriceMeta;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 *  Bond price relative to a benchmark, as in a convertible bond.
 * @version ${project.version}
 */
@RosettaClass

public interface RelativePrice extends RosettaModelObject {
	RelativePrice build();
	RelativePrice.RelativePriceBuilder toBuilder();
	
	/**
	 * Bond equity model for convertible bonds.
	 */
	List<? extends BondEquityModel> getBondEquityModel();
	/**
	 * The spread to a benchmark.
	 */
	BigDecimal getSpread();
	final static RelativePriceMeta metaData = new RelativePriceMeta();
	
	@Override
	default RosettaMetaData<? extends RelativePrice> metaData() {
		return metaData;
	} 
			
	static RelativePrice.RelativePriceBuilder builder() {
		return new RelativePrice.RelativePriceBuilderImpl();
	}
	
	default Class<? extends RelativePrice> getType() {
		return RelativePrice.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		
		processRosetta(path.newSubPath("bondEquityModel"), processor, BondEquityModel.class, getBondEquityModel());
	}
	
	
	interface RelativePriceBuilder extends RelativePrice, RosettaModelObjectBuilder {
		BondEquityModel.BondEquityModelBuilder getOrCreateBondEquityModel(int _index);
		List<? extends BondEquityModel.BondEquityModelBuilder> getBondEquityModel();
		RelativePrice.RelativePriceBuilder addBondEquityModel(BondEquityModel bondEquityModel);
		RelativePrice.RelativePriceBuilder addBondEquityModel(BondEquityModel bondEquityModel, int _idx);
		RelativePrice.RelativePriceBuilder addBondEquityModel(List<? extends BondEquityModel> bondEquityModel);
		RelativePrice.RelativePriceBuilder setBondEquityModel(List<? extends BondEquityModel> bondEquityModel);
		RelativePrice.RelativePriceBuilder setSpread(BigDecimal spread);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			
			processRosetta(path.newSubPath("bondEquityModel"), processor, BondEquityModel.BondEquityModelBuilder.class, getBondEquityModel());
		}
		
	}
	
	//RelativePrice.RelativePriceImpl
	class RelativePriceImpl implements RelativePrice {
		private final List<? extends BondEquityModel> bondEquityModel;
		private final BigDecimal spread;
		
		protected RelativePriceImpl(RelativePrice.RelativePriceBuilder builder) {
			this.bondEquityModel = ofNullable(builder.getBondEquityModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.spread = builder.getSpread();
		}
		
		@Override
		public List<? extends BondEquityModel> getBondEquityModel() {
			return bondEquityModel;
		}
		
		@Override
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		public RelativePrice build() {
			return this;
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder toBuilder() {
			RelativePrice.RelativePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativePrice.RelativePriceBuilder builder) {
			ofNullable(getBondEquityModel()).ifPresent(builder::setBondEquityModel);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativePrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(bondEquityModel, _that.getBondEquityModel())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondEquityModel != null ? bondEquityModel.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativePrice {" +
				"bondEquityModel=" + this.bondEquityModel + ", " +
				"spread=" + this.spread +
			'}';
		}
	}
	
	//RelativePrice.RelativePriceBuilderImpl
	class RelativePriceBuilderImpl implements RelativePrice.RelativePriceBuilder {
	
		protected List<BondEquityModel.BondEquityModelBuilder> bondEquityModel = new ArrayList<>();
		protected BigDecimal spread;
	
		public RelativePriceBuilderImpl() {
		}
	
		@Override
		public List<? extends BondEquityModel.BondEquityModelBuilder> getBondEquityModel() {
			return bondEquityModel;
		}
		
		public BondEquityModel.BondEquityModelBuilder getOrCreateBondEquityModel(int _index) {
		
			if (bondEquityModel==null) {
				this.bondEquityModel = new ArrayList<>();
			}
			BondEquityModel.BondEquityModelBuilder result;
			return getIndex(bondEquityModel, _index, () -> {
						BondEquityModel.BondEquityModelBuilder newBondEquityModel = BondEquityModel.builder();
						return newBondEquityModel;
					});
		}
		
		@Override
		public BigDecimal getSpread() {
			return spread;
		}
		
	
		@Override
		public RelativePrice.RelativePriceBuilder addBondEquityModel(BondEquityModel bondEquityModel) {
			if (bondEquityModel!=null) this.bondEquityModel.add(bondEquityModel.toBuilder());
			return this;
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder addBondEquityModel(BondEquityModel bondEquityModel, int _idx) {
			getIndex(this.bondEquityModel, _idx, () -> bondEquityModel.toBuilder());
			return this;
		}
		@Override 
		public RelativePrice.RelativePriceBuilder addBondEquityModel(List<? extends BondEquityModel> bondEquityModels) {
			if (bondEquityModels != null) {
				for (BondEquityModel toAdd : bondEquityModels) {
					this.bondEquityModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public RelativePrice.RelativePriceBuilder setBondEquityModel(List<? extends BondEquityModel> bondEquityModels) {
			if (bondEquityModels == null)  {
				this.bondEquityModel = new ArrayList<>();
			}
			else {
				this.bondEquityModel = bondEquityModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder setSpread(BigDecimal spread) {
			this.spread = spread==null?null:spread;
			return this;
		}
		
		@Override
		public RelativePrice build() {
			return new RelativePrice.RelativePriceImpl(this);
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativePrice.RelativePriceBuilder prune() {
			bondEquityModel = bondEquityModel.stream().filter(b->b!=null).<BondEquityModel.BondEquityModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBondEquityModel()!=null && getBondEquityModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpread()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativePrice.RelativePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelativePrice.RelativePriceBuilder o = (RelativePrice.RelativePriceBuilder) other;
			
			merger.mergeRosetta(getBondEquityModel(), o.getBondEquityModel(), this::getOrCreateBondEquityModel);
			
			merger.mergeBasic(getSpread(), o.getSpread(), this::setSpread);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativePrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(bondEquityModel, _that.getBondEquityModel())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondEquityModel != null ? bondEquityModel.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativePriceBuilder {" +
				"bondEquityModel=" + this.bondEquityModel + ", " +
				"spread=" + this.spread +
			'}';
		}
	}
}
