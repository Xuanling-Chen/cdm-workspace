package cdm.product.asset;

import cdm.product.asset.meta.BasketReferenceInformationMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * CDS Basket Reference Information.
 * @version ${project.version}
 */
@RosettaClass

public interface BasketReferenceInformation extends RosettaModelObject {
	BasketReferenceInformation build();
	BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder();
	
	/**
	 * A CDS basket identifier.
	 */
	List<? extends FieldWithMetaString> getBasketId();
	/**
	 * The name of the basket expressed as a free format string. FpML does not define usage rules for this element.
	 */
	FieldWithMetaString getBasketName();
	/**
	 * M th reference obligation to default to allow representation of N th to M th defaults.
	 */
	Integer getMthToDefault();
	/**
	 * N th reference obligation to default triggers payout.
	 */
	Integer getNthToDefault();
	/**
	 * This element contains all the reference pool items to define the reference entity and reference obligation(s) in the basket.
	 */
	ReferencePool getReferencePool();
	/**
	 * This element contains CDS tranche terms.
	 */
	Tranche getTranche();
	final static BasketReferenceInformationMeta metaData = new BasketReferenceInformationMeta();
	
	@Override
	default RosettaMetaData<? extends BasketReferenceInformation> metaData() {
		return metaData;
	} 
			
	static BasketReferenceInformation.BasketReferenceInformationBuilder builder() {
		return new BasketReferenceInformation.BasketReferenceInformationBuilderImpl();
	}
	
	default Class<? extends BasketReferenceInformation> getType() {
		return BasketReferenceInformation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("mthToDefault"), Integer.class, getMthToDefault(), this);
		processor.processBasic(path.newSubPath("nthToDefault"), Integer.class, getNthToDefault(), this);
		
		processRosetta(path.newSubPath("basketId"), processor, FieldWithMetaString.class, getBasketId());
		processRosetta(path.newSubPath("basketName"), processor, FieldWithMetaString.class, getBasketName());
		processRosetta(path.newSubPath("referencePool"), processor, ReferencePool.class, getReferencePool());
		processRosetta(path.newSubPath("tranche"), processor, Tranche.class, getTranche());
	}
	
	
	interface BasketReferenceInformationBuilder extends BasketReferenceInformation, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateBasketId(int _index);
		List<? extends FieldWithMetaStringBuilder> getBasketId();
		FieldWithMetaStringBuilder getOrCreateBasketName();
		FieldWithMetaStringBuilder getBasketName();
		ReferencePool.ReferencePoolBuilder getOrCreateReferencePool();
		ReferencePool.ReferencePoolBuilder getReferencePool();
		Tranche.TrancheBuilder getOrCreateTranche();
		Tranche.TrancheBuilder getTranche();
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(FieldWithMetaString basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(FieldWithMetaString basketId, int _idx);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(String basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(String basketId, int _idx);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(List<? extends FieldWithMetaString> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketId(List<? extends FieldWithMetaString> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(List<? extends String> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketIdValue(List<? extends String> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketName(FieldWithMetaString basketName);
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketNameValue(String basketName);
		BasketReferenceInformation.BasketReferenceInformationBuilder setMthToDefault(Integer mthToDefault);
		BasketReferenceInformation.BasketReferenceInformationBuilder setNthToDefault(Integer nthToDefault);
		BasketReferenceInformation.BasketReferenceInformationBuilder setReferencePool(ReferencePool referencePool);
		BasketReferenceInformation.BasketReferenceInformationBuilder setTranche(Tranche tranche);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("mthToDefault"), Integer.class, getMthToDefault(), this);
			processor.processBasic(path.newSubPath("nthToDefault"), Integer.class, getNthToDefault(), this);
			
			processRosetta(path.newSubPath("basketId"), processor, FieldWithMetaStringBuilder.class, getBasketId());
			processRosetta(path.newSubPath("basketName"), processor, FieldWithMetaStringBuilder.class, getBasketName());
			processRosetta(path.newSubPath("referencePool"), processor, ReferencePool.ReferencePoolBuilder.class, getReferencePool());
			processRosetta(path.newSubPath("tranche"), processor, Tranche.TrancheBuilder.class, getTranche());
		}
		
	}
	
	//BasketReferenceInformation.BasketReferenceInformationImpl
	class BasketReferenceInformationImpl implements BasketReferenceInformation {
		private final List<? extends FieldWithMetaString> basketId;
		private final FieldWithMetaString basketName;
		private final Integer mthToDefault;
		private final Integer nthToDefault;
		private final ReferencePool referencePool;
		private final Tranche tranche;
		
		protected BasketReferenceInformationImpl(BasketReferenceInformation.BasketReferenceInformationBuilder builder) {
			this.basketId = ofNullable(builder.getBasketId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.basketName = ofNullable(builder.getBasketName()).map(f->f.build()).orElse(null);
			this.mthToDefault = builder.getMthToDefault();
			this.nthToDefault = builder.getNthToDefault();
			this.referencePool = ofNullable(builder.getReferencePool()).map(f->f.build()).orElse(null);
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends FieldWithMetaString> getBasketId() {
			return basketId;
		}
		
		@Override
		public FieldWithMetaString getBasketName() {
			return basketName;
		}
		
		@Override
		public Integer getMthToDefault() {
			return mthToDefault;
		}
		
		@Override
		public Integer getNthToDefault() {
			return nthToDefault;
		}
		
		@Override
		public ReferencePool getReferencePool() {
			return referencePool;
		}
		
		@Override
		public Tranche getTranche() {
			return tranche;
		}
		
		@Override
		public BasketReferenceInformation build() {
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder() {
			BasketReferenceInformation.BasketReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketReferenceInformation.BasketReferenceInformationBuilder builder) {
			ofNullable(getBasketId()).ifPresent(builder::setBasketId);
			ofNullable(getBasketName()).ifPresent(builder::setBasketName);
			ofNullable(getMthToDefault()).ifPresent(builder::setMthToDefault);
			ofNullable(getNthToDefault()).ifPresent(builder::setNthToDefault);
			ofNullable(getReferencePool()).ifPresent(builder::setReferencePool);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!Objects.equals(mthToDefault, _that.getMthToDefault())) return false;
			if (!Objects.equals(nthToDefault, _that.getNthToDefault())) return false;
			if (!Objects.equals(referencePool, _that.getReferencePool())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (mthToDefault != null ? mthToDefault.hashCode() : 0);
			_result = 31 * _result + (nthToDefault != null ? nthToDefault.hashCode() : 0);
			_result = 31 * _result + (referencePool != null ? referencePool.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformation {" +
				"basketId=" + this.basketId + ", " +
				"basketName=" + this.basketName + ", " +
				"mthToDefault=" + this.mthToDefault + ", " +
				"nthToDefault=" + this.nthToDefault + ", " +
				"referencePool=" + this.referencePool + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}
	
	//BasketReferenceInformation.BasketReferenceInformationBuilderImpl
	class BasketReferenceInformationBuilderImpl implements BasketReferenceInformation.BasketReferenceInformationBuilder {
	
		protected List<FieldWithMetaStringBuilder> basketId = new ArrayList<>();
		protected FieldWithMetaStringBuilder basketName;
		protected Integer mthToDefault;
		protected Integer nthToDefault;
		protected ReferencePool.ReferencePoolBuilder referencePool;
		protected Tranche.TrancheBuilder tranche;
	
		public BasketReferenceInformationBuilderImpl() {
		}
	
		@Override
		public List<? extends FieldWithMetaStringBuilder> getBasketId() {
			return basketId;
		}
		
		public FieldWithMetaStringBuilder getOrCreateBasketId(int _index) {
		
			if (basketId==null) {
				this.basketId = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(basketId, _index, () -> {
						FieldWithMetaStringBuilder newBasketId = FieldWithMetaString.builder();
						return newBasketId;
					});
		}
		
		@Override
		public FieldWithMetaStringBuilder getBasketName() {
			return basketName;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateBasketName() {
			FieldWithMetaStringBuilder result;
			if (basketName!=null) {
				result = basketName;
			}
			else {
				result = basketName = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public Integer getMthToDefault() {
			return mthToDefault;
		}
		
		@Override
		public Integer getNthToDefault() {
			return nthToDefault;
		}
		
		@Override
		public ReferencePool.ReferencePoolBuilder getReferencePool() {
			return referencePool;
		}
		
		@Override
		public ReferencePool.ReferencePoolBuilder getOrCreateReferencePool() {
			ReferencePool.ReferencePoolBuilder result;
			if (referencePool!=null) {
				result = referencePool;
			}
			else {
				result = referencePool = ReferencePool.builder();
			}
			
			return result;
		}
		
		@Override
		public Tranche.TrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public Tranche.TrancheBuilder getOrCreateTranche() {
			Tranche.TrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = Tranche.builder();
			}
			
			return result;
		}
		
	
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(FieldWithMetaString basketId) {
			if (basketId!=null) this.basketId.add(basketId.toBuilder());
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(FieldWithMetaString basketId, int _idx) {
			getIndex(this.basketId, _idx, () -> basketId.toBuilder());
			return this;
		}
		
			@Override
			public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(String basketId) {
				this.getOrCreateBasketId(-1).setValue(basketId);
				return this;
			}
			
			@Override
			public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(String basketId, int _idx) {
				this.getOrCreateBasketId(_idx).setValue(basketId);
				return this;
			}
		@Override 
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(List<? extends FieldWithMetaString> basketIds) {
			if (basketIds != null) {
				for (FieldWithMetaString toAdd : basketIds) {
					this.basketId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketId(List<? extends FieldWithMetaString> basketIds) {
			if (basketIds == null)  {
				this.basketId = new ArrayList<>();
			}
			else {
				this.basketId = basketIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(List<? extends String> basketIds) {
			if (basketIds != null) {
				for (String toAdd : basketIds) {
					this.addBasketIdValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketIdValue(List<? extends String> basketIds) {
			this.basketId.clear();
			if (basketIds!=null) {
				basketIds.forEach(this::addBasketIdValue);
			}
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketName(FieldWithMetaString basketName) {
			this.basketName = basketName==null?null:basketName.toBuilder();
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketNameValue(String basketName) {
			this.getOrCreateBasketName().setValue(basketName);
			return this;
		}
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setMthToDefault(Integer mthToDefault) {
			this.mthToDefault = mthToDefault==null?null:mthToDefault;
			return this;
		}
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setNthToDefault(Integer nthToDefault) {
			this.nthToDefault = nthToDefault==null?null:nthToDefault;
			return this;
		}
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setReferencePool(ReferencePool referencePool) {
			this.referencePool = referencePool==null?null:referencePool.toBuilder();
			return this;
		}
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setTranche(Tranche tranche) {
			this.tranche = tranche==null?null:tranche.toBuilder();
			return this;
		}
		
		@Override
		public BasketReferenceInformation build() {
			return new BasketReferenceInformation.BasketReferenceInformationImpl(this);
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder prune() {
			basketId = basketId.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (basketName!=null && !basketName.prune().hasData()) basketName = null;
			if (referencePool!=null && !referencePool.prune().hasData()) referencePool = null;
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketId()!=null && !getBasketId().isEmpty()) return true;
			if (getBasketName()!=null) return true;
			if (getMthToDefault()!=null) return true;
			if (getNthToDefault()!=null) return true;
			if (getReferencePool()!=null && getReferencePool().hasData()) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketReferenceInformation.BasketReferenceInformationBuilder o = (BasketReferenceInformation.BasketReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getBasketId(), o.getBasketId(), this::getOrCreateBasketId);
			merger.mergeRosetta(getBasketName(), o.getBasketName(), this::setBasketName);
			merger.mergeRosetta(getReferencePool(), o.getReferencePool(), this::setReferencePool);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			
			merger.mergeBasic(getMthToDefault(), o.getMthToDefault(), this::setMthToDefault);
			merger.mergeBasic(getNthToDefault(), o.getNthToDefault(), this::setNthToDefault);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!Objects.equals(mthToDefault, _that.getMthToDefault())) return false;
			if (!Objects.equals(nthToDefault, _that.getNthToDefault())) return false;
			if (!Objects.equals(referencePool, _that.getReferencePool())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (mthToDefault != null ? mthToDefault.hashCode() : 0);
			_result = 31 * _result + (nthToDefault != null ? nthToDefault.hashCode() : 0);
			_result = 31 * _result + (referencePool != null ? referencePool.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformationBuilder {" +
				"basketId=" + this.basketId + ", " +
				"basketName=" + this.basketName + ", " +
				"mthToDefault=" + this.mthToDefault + ", " +
				"nthToDefault=" + this.nthToDefault + ", " +
				"referencePool=" + this.referencePool + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}
}
